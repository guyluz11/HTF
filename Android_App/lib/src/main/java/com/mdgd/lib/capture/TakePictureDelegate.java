package com.mdgd.lib.capture;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.widget.Toast;

import com.mdgd.lib.R;
import com.mdgd.lib.utilities.PermissionsUtil;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

/**
 * Created by Max
 * on 21/02/2018.
 */

public class TakePictureDelegate {

    private final Activity ctx;
    private final AppCompatActivity ctxSupport;
    private final ImageFormats imgFormat;

    private final ISavePictureDirectory funcImageDir;
    private final ISavePicturePath funcImagePath;
    private final String imagePath;

    private final int PRC_SELECT;
    private final int RC_SELECT;
    private final int PRC_CAPTURE;
    private final int RC_CAPTURE;

    private final String chooserDialogTitle;
    private final IOnImageObtained funcOnImageObtained;

    private TakePictureDelegate(Activity activity, ImageFormats format, String savePicDirPath,
                                ISavePicturePath savePicDirPathFun, ISavePictureDirectory savePicDir,
                                int rcPermissionCamera, int rcPermissionSelect, int requestCodeCapture,
                                int requestCodeSelect, IOnImageObtained onImageObtained, String chooserTitle) {
        this.ctx = activity;
        this.ctxSupport = null;
        this.imgFormat = format;

        this.imagePath = savePicDirPath;
        this.funcImagePath = savePicDirPathFun;
        this.funcImageDir = savePicDir;

        PRC_CAPTURE = rcPermissionCamera;
        RC_CAPTURE = rcPermissionSelect;

        PRC_SELECT = requestCodeSelect;
        RC_SELECT = requestCodeCapture;

        funcOnImageObtained = onImageObtained;
        chooserDialogTitle = chooserTitle == null ? getChooserTitle() : chooserTitle;
    }

    private TakePictureDelegate(AppCompatActivity activity, ImageFormats format, String savePicDirPath,
                                ISavePicturePath savePicDirPathFun, ISavePictureDirectory savePicDir,
                                int rcPermissionCamera, int rcPermissionSelect, int requestCodeCapture,
                                int requestCodeSelect, IOnImageObtained onImageObtained, String chooserTitle) {
        this.ctx = null;
        this.ctxSupport = activity;
        this.imgFormat = format;

        this.imagePath = savePicDirPath;
        this.funcImagePath = savePicDirPathFun;
        this.funcImageDir = savePicDir;

        PRC_CAPTURE = rcPermissionCamera;
        RC_CAPTURE = rcPermissionSelect;

        PRC_SELECT = requestCodeSelect;
        RC_SELECT = requestCodeCapture;

        funcOnImageObtained = onImageObtained;
        chooserDialogTitle = chooserTitle == null ? getChooserTitle() : chooserTitle;
    }

    private Activity getActivity(){
        return ctx == null ? ctxSupport : ctx;
    }

    public void makePicture() {
        if (PermissionsUtil.requestPermissionsIfNeed(getActivity(), PRC_CAPTURE, Manifest.permission.CAMERA,
                Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE)) {
            final PackageManager pManager = getActivity().getPackageManager();
            final boolean hasCamera = pManager.hasSystemFeature(PackageManager.FEATURE_CAMERA);
            if (!hasCamera) {
                Toast.makeText(getActivity(), R.string.no_camera_on_device, Toast.LENGTH_SHORT).show();
                return;
            }

            final Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            if (takePictureIntent.resolveActivity(pManager) != null) {
                getActivity().startActivityForResult(takePictureIntent, RC_CAPTURE);
            }
        }
    }

    public void selectFromGallery() {
        if (PermissionsUtil.requestPermissionsIfNeed(getActivity(), PRC_SELECT, Manifest.permission.READ_EXTERNAL_STORAGE)) {
            final Intent intent = new Intent(Intent.ACTION_GET_CONTENT).setType("image/*");
            getActivity().startActivityForResult(Intent.createChooser(intent, chooserDialogTitle), RC_SELECT);
        }
    }

    protected String getChooserTitle(){
        return getActivity().getString(R.string.select_image);
    }

    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        final boolean permissionsGranted = PermissionsUtil.areAllPermissionsGranted(grantResults);
        if (requestCode == PRC_CAPTURE && permissionsGranted) {
            makePicture();
        }
        else if (requestCode == PRC_SELECT && permissionsGranted) {
            selectFromGallery();
        }
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(resultCode != Activity.RESULT_OK){
            return;
        }
        if (requestCode == RC_CAPTURE) {
            fetchNewImage(data);
        }
        else if (requestCode == RC_SELECT) {
            if (data != null && data.getData() != null) {
                if(funcOnImageObtained != null) {
                    funcOnImageObtained.onImageObtained(data.getData());
                }
            }
        }
    }

    protected void fetchNewImage(Intent data) {
        final Bundle extras = data.getExtras();
        final Bitmap photo = (Bitmap) extras.get("data");
        try {
            final File dir = getSavePictureFile();
            boolean b = dir.exists() || dir.mkdirs();

            final File file = new File(dir,System.currentTimeMillis() + imgFormat.suffix);
            b = file.exists() || file.createNewFile();

            final BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(file));
            photo.compress(imgFormat.format, 100, bos);
            bos.flush();
            bos.close();

            if(funcOnImageObtained != null) {
                funcOnImageObtained.onImageObtained(Uri.fromFile(file));
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    private File getSavePictureFile() {
        if(funcImageDir != null){
            return funcImageDir.getSavePictureDirectory();
        }
        else if(funcImagePath != null){
            return new File(funcImagePath.getSavePictureDirectoryPath());
        }
        else if(!TextUtils.isEmpty(imagePath)){
            return new File(imagePath);
        }
        else {
            return new File(Environment.getDataDirectory() + "/Pictures");
        }
    }


    /**
     * Example:
     * new TakePictureDelegate.Builder(ChatsActivity.this)
     * .setPictureFormat(ImageFormats.JPEG)
     * .setSavePictureDirectory(() -> Environment.getExternalStorageDirectory() + Defines.PATH_IMAGES)
     * .setRequestCodePermissionCamera(100)
     * .setRequestCodePermissionSelectFromGallery(101)
     * .setRequestCodeCapture(102)
     * .setRequestCodeSelect(103)
     * .setChooserTitle("Select image")
     * .setOnImageObtained((Uri imageUri) -> { do something })
     * .build();
     */
    public static class Builder {

        private final Activity activity;
        private final AppCompatActivity activitySupport;
        private ImageFormats format = ImageFormats.JPEG;
        private String savePicDirPath;
        private ISavePicturePath savePicDirPathFun;
        private ISavePictureDirectory savePicDir;
        private int rcPermissionSelect = 101;
        private int rcPermissionCamera = 102;
        private int requestCodeSelect = 103;
        private int requestCodeCapture = 104;
        private IOnImageObtained onImageObtained;
        private String chooserTitle;

        public Builder(Activity activity){
            this.activity = activity;
            this.activitySupport = null;
        }

        public Builder(AppCompatActivity activity){
            this.activitySupport = activity;
            this.activity = null;
        }

        /**
         * default value ImageFormats.JPEG
         */
        public Builder setPictureFormat(ImageFormats format){
            this.format = format;
            return this;
        }

        /**
         * priority low
         * default value Environment.getDataDirectory() + "/Pictures"
         */
        public Builder setSavePictureDirectory(String path){
            this.savePicDirPath = path;
            return this;
        }

        /**
         * priority medium
         * default value Environment.getDataDirectory() + "/Pictures"
         */
        public Builder setSavePictureDirectory(ISavePicturePath path){
            this.savePicDirPathFun = path;
            return this;
        }

        /**
         * priority high
         * default value Environment.getDataDirectory() + "/Pictures"
         */
        public Builder setSavePictureDirectory(ISavePictureDirectory directory){
            this.savePicDir = directory;
            return this;
        }

        /**
         * default value 101
         */
        public Builder setRequestCodePermissionSelectFromGallery(int requestCodePermissionSelectFromGallery){
            this.rcPermissionSelect = requestCodePermissionSelectFromGallery;
            return this;
        }

        /**
         * default value 102
         */
        public Builder setRequestCodePermissionCamera(int requestCodePermissionCamera){
            this.rcPermissionCamera = requestCodePermissionCamera;
            return this;
        }

        /**
         * default value 103
         */
        public Builder setRequestCodeSelect(int requestCodeSelect){
            this.requestCodeSelect = requestCodeSelect;
            return this;
        }

        /**
         * default value 104
         */
        public Builder setRequestCodeCapture(int requestCodeCapture){
            this.requestCodeCapture = requestCodeCapture;
            return this;
        }

        public Builder setOnImageObtained(IOnImageObtained listener){
            this.onImageObtained = listener;
            return this;
        }

        /**
         * default value "Select image"
         */
        public Builder setChooserTitle(String chooserTitle){
            this.chooserTitle = chooserTitle;
            return this;
        }

        public TakePictureDelegate build(){
            if(activity == null){
                return new TakePictureDelegate(activitySupport, format, savePicDirPath, savePicDirPathFun,
                        savePicDir, rcPermissionCamera, rcPermissionSelect, requestCodeCapture, requestCodeSelect, onImageObtained, chooserTitle);
            }
            else {
                return new TakePictureDelegate(activity, format, savePicDirPath, savePicDirPathFun,
                        savePicDir, rcPermissionCamera, rcPermissionSelect, requestCodeCapture, requestCodeSelect, onImageObtained, chooserTitle);
            }
        }
    }
}

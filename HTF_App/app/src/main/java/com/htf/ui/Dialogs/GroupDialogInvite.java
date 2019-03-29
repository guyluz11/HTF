package com.htf.ui.Dialogs;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.htf.R;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

public class GroupDialogInvite extends Dialog {
    private Button button;
    private TextView exit;

    public GroupDialogInvite(@NonNull Context context) {
        super(context);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.invite_dialog);
        closeDialog();
    }

    private void doSome(){ //\
        button = findViewById(R.id.viewTeam);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //todo for niv or guy do something when button clicked
            }
        });
    }

    private void closeDialog(){
        exit = findViewById(R.id.xButton);
        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dismiss();
            }
        });
    }



}


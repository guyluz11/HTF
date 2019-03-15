package com.mdgd.lib.foreground;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.os.Build;
import android.support.v4.app.NotificationCompat;

/**
 * Created by Owner
 * on 17/12/2018.
 */
public class ForegroundDelegate {

    public NotificationCompat.Builder setupServiceNotificationAndChannel(Context ctx, String channelName, String channelId,
                                                                          int channelImportance, int notificationPriority,
                                                                          int iconResId, int titleResId, int txtResId) {
        createNotificationChannel(ctx, channelName, channelId, channelImportance);
        final NotificationCompat.Builder builder = new NotificationCompat.Builder(ctx, channelId);
        builder.setAutoCancel(false);
        if(Build.VERSION.SDK_INT >= 24) builder.setPriority(notificationPriority);
        if(Build.VERSION.SDK_INT >= 21) builder.setCategory(Notification.CATEGORY_SERVICE);
        builder.setSmallIcon(iconResId);
        builder.setOngoing(true);
        builder.setContentTitle(ctx.getString(titleResId));
        builder.setContentText(ctx.getString(txtResId));
        return builder;
    }

    public void createNotificationChannel(Context ctx, String channelName, String channelId, int channelImportance) {
        if(Build.VERSION.SDK_INT < Build.VERSION_CODES.O) return;
        final NotificationManager manager = (NotificationManager) ctx.getSystemService(Context.NOTIFICATION_SERVICE);
        if(manager == null) return;
        final NotificationChannel channel = manager.getNotificationChannel(channelId);
        if(channel == null) {
            final NotificationChannel chan = new NotificationChannel(channelId, channelName, channelImportance);
            manager.createNotificationChannel(chan);
        }
    }
}

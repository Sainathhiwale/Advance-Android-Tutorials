package com.examen.notificationservice;

import android.app.NotificationManager;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;

public class LocalNotificationService extends Service {

    /*If it is needed to bind the service with an activity this method is called.
    The service can result back something to the activity after binding.
    But if you do not want to bind the service with activity then you should return null on this method.*/
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        Toast.makeText(this, "Invoke background service onCreate method.", Toast.LENGTH_LONG).show();
        super.onCreate();
    }

    /*When the service is no longer used and destroyed this method is called by the system.
     */
    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    /*This method is invoked when the service is started using the startService() method.
     We can call the method startService() from any activity and it will request the service to start.*/
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        showLocalNotification();
        return START_STICKY;
    }

    private void showLocalNotification() {
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this)
                .setSmallIcon(R.drawable.ic_notifications)
                .setContentTitle("Examen Notification")
                .setContentText("Subcribe Successfully");
        NotificationManager manager =(NotificationManager)getSystemService(Context.NOTIFICATION_SERVICE);
        manager.notify(11,builder.build());
    }
}

package musicmachine.sanples.android.ruben.com.musicmachine;

import android.app.Notification;
import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Binder;
import android.os.IBinder;
import android.os.Messenger;
import android.util.Log;

public class PlayerService extends Service {
    private static final String TAG = PlayerService.class.getSimpleName();
    private MediaPlayer mMediaPlayer;
    public Messenger mMessenger = new Messenger(new PlayerHandler(this));

    @Override
    public void onCreate() {
        Log.d(TAG,"onCreate");
        mMediaPlayer = MediaPlayer.create(this, R.raw.jingle);
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Notification.Builder notificationBuilder = new Notification.Builder(this);
        notificationBuilder.setSmallIcon(R.mipmap.ic_launcher);
        notificationBuilder.setContentTitle("Title: Music Machine").setContentText("Ejecutando Music Machine");
        Notification notification = notificationBuilder.build();
        startForeground(11, notification);
        mMediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                stopSelf();
                stopForeground(true);
            }
        });

        return Service.START_NOT_STICKY;
    }

    @Override
    public IBinder onBind(Intent intent) {
        Log.d(TAG,"onBind");

        return mMessenger.getBinder();
    }

    @Override
    public boolean onUnbind(Intent intent) {
        Log.d(TAG,"onUnbind");

        return super.onUnbind(intent);
    }

    @Override
    public void onDestroy() {
        Log.d(TAG,"onDestroy");
        mMediaPlayer.release();

    }


    public  boolean isPlaying(){
        return mMediaPlayer.isPlaying();
    }

    public void play(){
        mMediaPlayer.start();
    }

    public void pausa(){
        mMediaPlayer.pause();
    }
}

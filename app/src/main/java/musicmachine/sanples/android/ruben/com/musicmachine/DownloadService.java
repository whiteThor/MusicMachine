package musicmachine.sanples.android.ruben.com.musicmachine;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.Message;

public class DownloadService extends Service {

    private DownloadHandle mDownloadHandle ;
    private static final String TAG = DownloadService.class.getSimpleName() ;

    @Override
    public void onCreate() {

        DownloadThread downloadThread = new DownloadThread();
        downloadThread.setName("DownloadThread");
        downloadThread.start();
        while (downloadThread.mDownloadHandle == null){

        }
        mDownloadHandle = downloadThread.mDownloadHandle;
        mDownloadHandle.setService(this);
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        String song = intent.getStringExtra(MainActivity.KEY_SONG);
        Message message = Message.obtain();
        message.obj = song;
        message.arg1 = startId;
        mDownloadHandle.sendMessage(message);
        return Service.START_REDELIVER_INTENT;
    }


    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }


}

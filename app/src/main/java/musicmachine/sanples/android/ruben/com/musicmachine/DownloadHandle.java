package musicmachine.sanples.android.ruben.com.musicmachine;

import android.os.Handler;
import android.os.Message;
import android.util.Log;

public class DownloadHandle extends Handler {


    private static final String TAG =DownloadHandle.class.getSimpleName();
    private DownloadService mService;

    @Override
    public void handleMessage(Message msg) {

        downloadSong(msg.obj.toString());
        mService.stopSelf(msg.arg1);

    }

    private void downloadSong(String song) {
        long endTime = System.currentTimeMillis() + 10*1000;

        while(System.currentTimeMillis() < endTime){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        Log.d(TAG, song + " Downloaded");

    }

    public void setService(DownloadService service) {
        mService = service;
    }
}

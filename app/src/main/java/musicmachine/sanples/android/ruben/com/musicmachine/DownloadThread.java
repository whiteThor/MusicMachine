package musicmachine.sanples.android.ruben.com.musicmachine;

import android.os.Looper;
import android.util.Log;

public class DownloadThread extends Thread {

    private static final String TAG = DownloadThread.class.getSimpleName();

    public  DownloadHandle mDownloadHandle ;

    @Override
    public void run() {

        Looper.prepare();
        mDownloadHandle = new DownloadHandle();
        Looper.loop();


    }

}

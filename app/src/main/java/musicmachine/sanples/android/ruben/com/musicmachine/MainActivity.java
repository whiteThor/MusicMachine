package musicmachine.sanples.android.ruben.com.musicmachine;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity {

    private  String TAG = MainActivity.class.getSimpleName();
    private Button mDownLoadButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mDownLoadButton.findViewById(R.id.downLoadButton);
        
        mDownLoadButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Downloading", Toast.LENGTH_SHORT).show();
                downloadSong();
            }
        });

        
    }

    private void downloadSong() {
        long endTime = System.currentTimeMillis() + 10*1000;

        while(System.currentTimeMillis() < endTime){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        Log.d(TAG, "Song Downloaded");

    }
}



















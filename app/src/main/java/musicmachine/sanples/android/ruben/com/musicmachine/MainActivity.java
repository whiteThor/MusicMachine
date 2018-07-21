package musicmachine.sanples.android.ruben.com.musicmachine;

import android.app.Activity;
import android.os.Bundle;
import android.os.Message;
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

        final DownloadThread thread = new DownloadThread();
        thread.setName("DownloadThread");
        thread.start();

        mDownLoadButton = findViewById(R.id.downLoadButton);
        
        mDownLoadButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Downloading", Toast.LENGTH_SHORT).show();

                for (String song : Playlist.songs) {
                    Message message = Message.obtain();
                    message.obj = song;
                    thread.mDownloadHandle.sendMessage(message);
                }

            }
        });

        
    }


}



















package musicmachine.sanples.android.ruben.com.musicmachine;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity {

    public static final String KEY_SONG = "song";
    private  String TAG = MainActivity.class.getSimpleName();
    private Button mDownLoadButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mDownLoadButton = findViewById(R.id.downLoadButton);
        
        mDownLoadButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Downloading", Toast.LENGTH_SHORT).show();

                for (String song : Playlist.songs) {
                    Intent intent = new Intent(MainActivity.this,DownloadIntentService.class);
                    intent.putExtra(KEY_SONG, song);
                    startService(intent);
                }

            }
        });

        
    }


}



















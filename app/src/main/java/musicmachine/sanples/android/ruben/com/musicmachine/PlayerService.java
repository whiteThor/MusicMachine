package musicmachine.sanples.android.ruben.com.musicmachine;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

public class PlayerService extends Service {
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}

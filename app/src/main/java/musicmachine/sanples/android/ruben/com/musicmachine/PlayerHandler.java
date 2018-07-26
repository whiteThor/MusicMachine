package musicmachine.sanples.android.ruben.com.musicmachine;

import android.os.Handler;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;

public class PlayerHandler extends Handler {
    private PlayerService mPlayerService;


    public PlayerHandler(PlayerService playerService) {
        mPlayerService = playerService;
    }

    @Override
    public void handleMessage(Message msg) {
        switch (msg.arg1){
            case 0:
                mPlayerService.play();
                break;
            case 1:
                mPlayerService.pausa();
                break;
            case 2:
                int isPlaying = mPlayerService.isPlaying() ? 1 : 0;
                Message message = Message.obtain();
                message.arg1 = isPlaying;
                if(msg.arg2==1){
                    message.arg2=1;
                }
                message.replyTo = mPlayerService.mMessenger;
                try {
                    msg.replyTo.send(message);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
                break;
        }
            }
}

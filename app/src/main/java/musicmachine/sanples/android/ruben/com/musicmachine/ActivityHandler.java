package musicmachine.sanples.android.ruben.com.musicmachine;

import android.os.Handler;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;

public class ActivityHandler extends Handler {
    private  MainActivity mMainActivity;

    public ActivityHandler(MainActivity mainActivity) {
        mMainActivity = mainActivity;
    }

    @Override
    public void handleMessage(Message msg) {
        if(msg.arg1 == 0){
            //Play music
            if(msg.arg2 ==1){
                mMainActivity.changePlayButtonText("Play");
            }else {


                Message message = Message.obtain();
                message.arg1 = 0;
                try {
                    msg.replyTo.send(message);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
                mMainActivity.changePlayButtonText("Pause");
            }
        }else if(msg.arg1== 1){
            if(msg.arg2==1){
                mMainActivity.changePlayButtonText("Pause");
            }else{



            //Play music
            Message message = Message.obtain();
            message.arg1 = 1;
            try {
                msg.replyTo.send(message);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
            mMainActivity.changePlayButtonText("Play");
            }
        }
    }
}

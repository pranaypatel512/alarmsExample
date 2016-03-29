package ch.swissonid.mutiblealarmmanger;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;


/**
 * Created by pmueller on 30.03.16.
 */
public class AlarmReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        if(action == null) MainActivity.start(context);
        else if(action.equals(Timer.ALARM_ONE_ACTION)) AlarmOneActivity.start(context);
        else if(action.equals(Timer.ALARM_TWO_ACTION)) AlarmTwoActivity.start(context);
    }
}

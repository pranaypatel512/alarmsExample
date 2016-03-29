package ch.swissonid.mutiblealarmmanger;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.provider.Settings;
import android.support.annotation.NonNull;

/**
 * Created by pmueller on 30.03.16.
 */
public class Timer {

    public static final int NO_INTENT_OPTION = 0;

    public static final int ALARM_ONE_REQUEST = 111;
    public static final String ALARM_ONE_ACTION = "ALARM_ONE_ACTION";

    public static final int ALARM_TWO_REQUEST = 222;
    public static final String ALARM_TWO_ACTION = "ALARM_TWO_ACTION";

    public static void startAlarm(final Context context
                                , final long timeOutTime
                                , final int requestCode
                                , final String alarmAction){
        Intent intent = getIntent(context, alarmAction);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(context, requestCode, intent, NO_INTENT_OPTION);
        long timeToWait = System.currentTimeMillis()+timeOutTime;
        getAlarmManager(context).set(AlarmManager.RTC_WAKEUP, timeToWait, pendingIntent);
    }

    @NonNull
    private static Intent getIntent(Context context, String alarmAction) {
        Intent intent = new Intent(context, AlarmReceiver.class);
        intent.setAction(alarmAction);
        return intent;
    }

    private static AlarmManager getAlarmManager(Context context) {
        return ((AlarmManager) context.getSystemService(Context.ALARM_SERVICE));
    }

    public static void startAlarmOne(final Context context){
        startAlarm(context, 8000, ALARM_ONE_REQUEST, ALARM_ONE_ACTION);
    }

    public static void startAlarmTwo(final Context context) {
        startAlarm(context, 3000, ALARM_TWO_REQUEST, ALARM_TWO_ACTION);
    }

    public static void stopAlarmOne(final Context context){
        stopAlarm(context, ALARM_ONE_REQUEST, ALARM_ONE_ACTION);
    }

    public static void startAnAlarm(final Context context){
        startAlarm(context, 1000, 0, null);
    }

    public static void stopAlarm(final Context context, final int requestCode, final String action){
        Intent intent = getIntent(context, action);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(context ,requestCode, intent, PendingIntent.FLAG_UPDATE_CURRENT);
        getAlarmManager(context).cancel(pendingIntent);
    }
}

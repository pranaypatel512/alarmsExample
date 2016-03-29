package ch.swissonid.mutiblealarmmanger;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class AlarmTwoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alarm_two);
    }

    public void stopAlarmOne(final View view){
        Timer.stopAlarmOne(this);
    }

    public void startAnAlarm(final View view){
        Timer.startAnAlarm(this);
    }

    public static void start(final Context context) {
        context.startActivity(new Intent(context, AlarmTwoActivity.class).setFlags(Intent.FLAG_ACTIVITY_NEW_TASK));
    }
}

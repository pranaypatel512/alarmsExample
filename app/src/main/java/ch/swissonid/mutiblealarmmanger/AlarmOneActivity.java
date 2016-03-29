package ch.swissonid.mutiblealarmmanger;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class AlarmOneActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alarm_one);
    }

    public static void start(final Context context) {
        context.startActivity(new Intent(context, AlarmOneActivity.class).setFlags(Intent.FLAG_ACTIVITY_NEW_TASK));
    }

    public void startAnAlarm(final View view){
        Timer.startAlarm(this, 1000,0, null);
    }
}

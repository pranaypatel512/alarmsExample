package ch.swissonid.mutiblealarmmanger;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void startAlarmOne(final View view){
        Toast.makeText(this, "Start Alarm One", Toast.LENGTH_SHORT).show();
        Timer.startAlarmOne(this);
    }

    public void startAlarmTwo(final View view){
        Toast.makeText(this, "Start Alarm Two", Toast.LENGTH_SHORT).show();
        Timer.startAlarmTwo(this);
    }

    public void stopAlarmOne(final View view){
        Timer.stopAlarmOne(this);
    }

    public static void start(final Context context){
        context.startActivity(new Intent(context, MainActivity.class).setFlags(Intent.FLAG_ACTIVITY_NEW_TASK));
    }
}

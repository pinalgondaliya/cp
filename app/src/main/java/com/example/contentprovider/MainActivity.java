package com.example.contentprovider;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    AlarmManager am;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {

            am = (AlarmManager) getSystemService(AlarmManager.class);
        }
    }

    public void setAlarm(View view) {

        Intent i = new Intent(MainActivity.this,MyService.class);

        PendingIntent p = PendingIntent.getService(this,10,i,PendingIntent.FLAG_UPDATE_CURRENT);


        Calendar c = Calendar.getInstance();
        c.add(Calendar.SECOND,5);

//        am.set(AlarmManager.RTC_WAKEUP,c.getTimeInMillis(),p);

        am.setRepeating(AlarmManager.RTC_WAKEUP,c.getTimeInMillis(),1000,p);

        Toast.makeText(MainActivity.this, "Alarm set", Toast.LENGTH_SHORT).show();

        am.cancel(p);

    }
}
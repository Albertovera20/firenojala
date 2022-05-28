package com.example.firenojala;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.messaging.FirebaseMessaging;
import com.google.firebase.messaging.FirebaseMessagingService;

public class MainActivity extends AppCompatActivity {

    private TextView infoTextView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        infoTextView=(TextView)findViewById(R.id.nombre);
        if (getIntent().getExtras()!=null){
            for (String key:getIntent().getExtras().keySet()){
                String value =getIntent().getExtras().getString(key);
                infoTextView.append("\n"+key+": "+value);
            }
        }

        FirebaseMessaging.getInstance().getToken().addOnCompleteListener(this, new OnCompleteListener<String>() {
            @Override
            public void onComplete(@NonNull Task<String> task) {
           //     task.getResult();
                Log.w("Tokenmessje",  task.getResult());
            }
        });
    }
}
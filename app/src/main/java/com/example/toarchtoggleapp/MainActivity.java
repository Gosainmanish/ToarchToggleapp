package com.example.toarchtoggleapp;

import android.hardware.camera2.CameraManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.Toast;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {

    CameraManager cm;
    String cameraid;
    
    ToggleButton tb;
  //  ImageView iv; and imageview ko daal xml ke deign ma

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tb = findViewById(R.id.toggleButton);
        tb.setBackgroundDrawable(getDrawable(R.drawable.bulboff));

    //    iv=findViewById(R.id.imageView);
        // toggle button ma jo listener use krenge uska name h setOnCheckedChangeListener
        // & .... compound button is that which contains many functionalities and isChecked - is always true when the torch is ON otherwise OFF

        tb.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                torch(isChecked);
                if(isChecked)
                {
                 tb.setBackgroundDrawable(getDrawable(R.drawable.bulbon));
                }

                else
                {
                    tb.setBackgroundDrawable(getDrawable(R.drawable.bulboff));
                }

            }
        });
    }

    public void torch(boolean mode) {
        try {
            cm = (CameraManager) getSystemService(CAMERA_SERVICE);
            cameraid = cm.getCameraIdList()[0];// in gradle file module :app change minSdkVersion to 23
            cm.setTorchMode(cameraid, mode);

        } catch (Exception e) {
        }


    }
}

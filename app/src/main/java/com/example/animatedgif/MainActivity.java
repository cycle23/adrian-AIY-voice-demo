package com.example.animatedgif;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import com.example.animatedgif.Utils.GifImageView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private GifImageView gifImageView;
    private ImageReceiver imageReceiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        gifImageView = findViewById(R.id.GifImageView);
        gifImageView.setGifImageResource(R.drawable.dance_1_smaller);

        registerImageReceiver();
        new CountDownTimer(90000, 1000) {

            public void onTick(long millisUntilFinished) {
                updateImage();
            }

            public void onFinish() {
                this.start();
            }
        }.start();
    }

    @Override
    public void onClick(View v) {
        updateImage();
    }
    private void updateImage() {
        Intent imageIntent = new Intent();
        imageIntent.setClass(this, ImageIntentService.class);
        imageIntent.putExtra("image_cat", "1");
        startService(imageIntent);
    }
    @Override
    protected void onStop() {
        super.onStop();
        unregisterReceiver(imageReceiver);
    }
    private void registerImageReceiver() {
        imageReceiver = new ImageReceiver();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(ImageIntentService.IMAGE_INFO);

        registerReceiver(imageReceiver, intentFilter);
    }
    private class ImageReceiver extends BroadcastReceiver {
        @Override
        public void onReceive(Context context, Intent intent) {
            String image = intent.getStringExtra("image");
            switch(image) {
                case "iconic":
                    setIfDifferent(R.drawable.dance_1_smaller);
                    break;
                case "marshmallow":
                    setIfDifferent(R.drawable.dance_2_smaller);
                    break;
                case "thanos":
                    setIfDifferent(R.drawable.dance_3_smaller);
                    break;
                case "banana":
                    setIfDifferent(R.drawable.dance_4_smaller);
                    break;
                case "raptor":
                    setIfDifferent(R.drawable.dance_5_smaller);
                    break;
            }
        }

        private void setIfDifferent(int id) {
            if (id != gifImageView.getId()) {
                gifImageView.setGifImageResource(id);
            }
        }
    }

}

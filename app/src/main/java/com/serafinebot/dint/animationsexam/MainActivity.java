package com.serafinebot.dint.animationsexam;

import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toolbar;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @SuppressLint("UseCompatLoadingForDrawables")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.my_toolbar);
        ImageView moonView = toolbar.findViewById(R.id.moonButton);
        ImageView faceView = toolbar.findViewById(R.id.faceButton);

        moonView.setOnClickListener(v -> {
            // smth
        });

        faceView.setOnClickListener(v -> {
            Intent intent = new Intent(this, hello_world.class);
            startActivity(intent);
        });

        ImageView sea = findViewById(R.id.sea);
        LinearLayout sky = findViewById(R.id.sky);
        ImageView sunImage = findViewById(R.id.sunImage);
        sunImage.setScaleType(ImageView.ScaleType.MATRIX);
        Drawable sun = getResources().getDrawable(R.drawable.circle);
        sunImage.setImageDrawable(sun);

        sky.setOnClickListener(v -> {
            sunImage.setY((float) (sky.getHeight() / 2.0 - sunImage.getHeight() / 2.0));
            @SuppressLint("ObjectAnimatorBinding")
            ObjectAnimator animator = ObjectAnimator.ofFloat(sunImage, "translationY", sea.getY())  ;
            animator.setTarget(sunImage);
            animator.setDuration(3000);
            animator.start();

            @SuppressLint("Range") int startColor = Color.parseColor("#357bc1");
            @SuppressLint("Range") int midColor = Color.parseColor("#817d69");
            @SuppressLint("Range") int endColor = Color.parseColor("#df8530");
            @SuppressLint("Range") int nightColor = Color.parseColor("#08192c");
            ValueAnimator backgroundAnimator = ValueAnimator.ofObject(new ArgbEvaluator(), startColor, midColor, endColor, nightColor);
            backgroundAnimator.setDuration(4500);
            backgroundAnimator.addUpdateListener(animation -> sky.setBackgroundColor((Integer) backgroundAnimator.getAnimatedValue()));
            backgroundAnimator.start();
        });
    }
}
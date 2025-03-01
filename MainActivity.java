package com.example.imageswitcher;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.ViewSwitcher;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private ImageSwitcher imageSwitcher;
    private Button nextButton;
    private int[] images = {R.drawable.img, R.drawable.img_1, R.drawable.img_2};
    private int currentImageIndex = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageSwitcher = findViewById(R.id.imageSwitcher);
        nextButton = findViewById(R.id.nextButton);

        imageSwitcher.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                // Return a new ImageView
                ImageView imageView = new ImageView(MainActivity.this);
                imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
                return imageView;
            }
        });

        imageSwitcher.setImageResource(images[currentImageIndex]);

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentImageIndex++;
                if (currentImageIndex >= images.length) {
                    currentImageIndex = 0;
                }
                imageSwitcher.setImageResource(images[currentImageIndex]);
            }
        });
    }
}

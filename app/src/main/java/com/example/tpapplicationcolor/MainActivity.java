package com.example.tpapplicationcolor;

import androidx.appcompat.app.AppCompatActivity;

import android.app.slice.SliceItem;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    ImageView imageView;
    TextView mColoValue;
    View mColorshow;
    Bitmap bitmap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = findViewById(R.id.colorpicker);
        mColoValue = findViewById(R.id.displayValue);
        mColorshow = findViewById(R.id.displaycolor);


        imageView.setDrawingCacheEnabled((true));
        imageView.buildDrawingCache(true);

        imageView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent event) {

                if (event.getAction() == MotionEvent.ACTION_DOWN || event.getAction() == MotionEvent.ACTION_MOVE) {
                    bitmap = imageView.getDrawingCache();
                    int pixel = bitmap.getPixel((int) event.getX(), (int) event.getY());


                    int r = Color.red(pixel);
                    int g = Color.green(pixel);
                    int b = Color.blue(pixel);

                    String hex = "#"+Integer.toHexString(pixel);

                    mColorshow.setBackgroundColor(Color.rgb(r, g, b));

                    mColoValue.setText("RGB:" + r + " ," + g + "," + b + " \nHEX:" +hex);
                }
                return true ;

            }
        });
    }
}
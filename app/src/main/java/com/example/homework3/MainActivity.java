package com.example.homework3;

import android.graphics.Typeface;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import com.varunest.sparkbutton.SparkButton;
import com.varunest.sparkbutton.SparkEventListener;

public class MainActivity extends AppCompatActivity {


    public static TextView quote;
    private SparkButton sparkButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.title_bar);

        //intialise views
        quote = (TextView) findViewById(R.id.quote);
        sparkButton = (SparkButton) findViewById(R.id.sparkButton);

        //sparkbutton library by varunes
        //https://github.com/varunest/SparkButton
        //listener for sparkbutton
        sparkButton.setEventListener (new SparkEventListener() {
            //calls ChuckNorris class on click of the sparkbutton and executes
            @Override
            public void onEvent(ImageView button, boolean buttonState) {
                ChuckNorris chuckNorris = new ChuckNorris();
                chuckNorris.execute();

            }

            //did not use the following events from the library
            @Override
            public void onEventAnimationEnd(ImageView button, boolean buttonState) {
                ;
            }

            @Override
            public void onEventAnimationStart(ImageView button, boolean buttonState) {
                ;
            }


        });

    }

}

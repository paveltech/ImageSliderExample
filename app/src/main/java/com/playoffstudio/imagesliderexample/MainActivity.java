package com.playoffstudio.imagesliderexample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.daimajia.slider.library.Animations.DescriptionAnimation;
import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.DefaultSliderView;
import com.daimajia.slider.library.SliderTypes.TextSliderView;

import static com.playoffstudio.imagesliderexample.R.id.slider;

public class MainActivity extends AppCompatActivity {



    String[] titles = {
            "Android",
            "Beta",
            "Cupcake",
            "Donut"

    };


    String[] imagess = {
            "https://www.w3schools.com/w3images/fjords.jpg",
            "https://i.ytimg.com/vi/EQ_mYstNGwg/maxresdefault.jpg",
            "https://www.w3schools.com/w3images/fjords.jpg",
            "https://i.ytimg.com/vi/EQ_mYstNGwg/maxresdefault.jpg"
    };


    private SliderLayout mDemoSlider;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        mDemoSlider = (SliderLayout)findViewById(slider);


        for (int i=0 ; i<=3 ; i++){


            TextSliderView textSliderView = new TextSliderView(getApplicationContext());
            textSliderView.description(titles[i])
                    .image(imagess[i])
                    .setScaleType(DefaultSliderView.ScaleType.Fit);


            //add your extra information
            mDemoSlider.addSlider(textSliderView);

        }

        mDemoSlider.setPresetTransformer(SliderLayout.Transformer.Tablet);
        //mDemoSlider.setCustomIndicator((PagerIndicator) findViewById(R.id.custom_indicator));
        mDemoSlider.setPresetIndicator(SliderLayout.PresetIndicators.Center_Bottom);
        mDemoSlider.setCustomAnimation(new DescriptionAnimation());
        mDemoSlider.setDuration(4000);





    }

    @Override
    protected void onStop() {
        // To prevent a memory leak on rotation, make sure to call stopAutoCycle() on the slider before activity or fragment is destroyed
        mDemoSlider.stopAutoCycle();
        super.onStop();
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}

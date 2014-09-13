package dwai.clayr;

import android.app.Activity;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ScrollView;

import dwai.clayr.R;

public class DataLookActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_look);




        //Sets the font for the whole layout.
        final Typeface mFont = Typeface.createFromAsset(getAssets(),
                "fonts/proxima.ttf");
        final ViewGroup mContainer = (ViewGroup) findViewById(
                android.R.id.content).getRootView();
        MainActivity.setAppFont(mContainer, mFont, true);

        //This is gonna be the hardest thing I've ever done in my entire life.
        LinearLayout rootLinearLayout = ((LinearLayout)findViewById(R.id.rootLinearLayout));
        WholeBar wholeBar = new WholeBar(this);
        wholeBar.addBarlet(4);
        wholeBar.addBarlet(8);
        wholeBar.addBarlet(12);
        wholeBar.addBarlet(16);
        rootLinearLayout.addView(wholeBar);
        wholeBar.getBarlets().get(3).setPercentageViewed(0.7);
        wholeBar.getBarlets().get(0).setPercentageViewed(0.1);
        wholeBar.getBarlets().get(1).setPercentageViewed(0.1);
        wholeBar.getBarlets().get(2).setPercentageViewed(0.1);
//        for(Barlet b : wholeBar.getBarlets()){
//            b.setPercentageViewed(0.25);
//        }

    }

}

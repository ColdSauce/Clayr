package dwai.clayr;

import android.app.Activity;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
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

        ImageView rect = new ImageView(this);

        //Find max relative to min

        View pushView = new View(this);
        LinearLayout.LayoutParams viewParams = new LinearLayout.LayoutParams(100, ViewGroup.LayoutParams.WRAP_CONTENT);
        viewParams.weight = 0.7f;
        pushView.setLayoutParams(viewParams);

        rect.getLayoutParams().width = (int)TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_PX, 150, getResources().getDisplayMetrics());
        rect.getLayoutParams().height  = (int)TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_PX, 50, getResources().getDisplayMetrics());
        rect.setBackgroundResource(R.drawable.rectangle);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        rect.setLayoutParams(layoutParams);

        LinearLayout.LayoutParams triangleLayoutParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,LinearLayout.LayoutParams.WRAP_CONTENT);
        ImageView triangle = new ImageView(this);
        triangleLayoutParams.width = (int)TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_PX, 50, getResources().getDisplayMetrics());
        triangleLayoutParams.height = (int)TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_PX, 50, getResources().getDisplayMetrics());

        triangle.setRotation(180);

        triangle.setLayoutParams(triangleLayoutParams);


        ((RelativeLayout)findViewById(R.id.triAndRect)).addView(rect);
        ((LinearLayout)findViewById(R.id.layoutInsideScroll)).addView(rect);
        ((LinearLayout)findViewById(R.id.layoutInsideScroll)).addView(triangle);

        WholeBar wholeBar = new WholeBar(this);

        wholeBar.addBarlet(4);
        wholeBar.addBarlet(8);
        wholeBar.addBarlet(12);
        wholeBar.addBarlet(16);
        rootLinearLayout.addView(wholeBar);
        wholeBar.getBarlets().get(0).setPercentageViewed(0.7);
        wholeBar.getBarlets().get(3).setPercentageViewed(0.1);
        wholeBar.getBarlets().get(1).setPercentageViewed(0.1);
        wholeBar.getBarlets().get(2).setPercentageViewed(0.1);








//        for(Barlet b : wholeBar.getBarlets()){
//            b.setPercentageViewed(0.25);
//        }

    }

}

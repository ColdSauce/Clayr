package dwai.clayr;

import android.app.Activity;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.Log;
import android.util.TypedValue;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;

import org.json.JSONException;
import org.json.JSONObject;

import dwai.clayr.R;

public class DataLookActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_look);
        //Sets the font for the whole layout.
        final Typeface mFont = Typeface.createFromAsset(getAssets(), "fonts/proxima.ttf");
        final ViewGroup mContainer = (ViewGroup) findViewById(android.R.id.content).getRootView();
        MainActivity.setAppFont(mContainer, mFont, true);

        //This is gonna be the hardest thing I've ever done in my entire life.
        LinearLayout rootLinearLayout = ((LinearLayout)findViewById(R.id.rootLinearLayout));

        ImageView rect = new ImageView(this);

        //Find max relative to min

        View pushView = new View(this);
        LinearLayout.LayoutParams viewParams = new LinearLayout.LayoutParams(100, ViewGroup.LayoutParams.WRAP_CONTENT);
        viewParams.weight = 0.7f;
        pushView.setLayoutParams(viewParams);

//        rect.getLayoutParams().width = (int)TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_PX, 150, getResources().getDisplayMetrics());
//        rect.getLayoutParams().height  = (int)TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_PX, 50, getResources().getDisplayMetrics());
        rect.setBackgroundResource(R.drawable.rectangle);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        rect.setLayoutParams(layoutParams);

        LinearLayout.LayoutParams triangleLayoutParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,LinearLayout.LayoutParams.WRAP_CONTENT);
        ImageView triangle = new ImageView(this);
        triangleLayoutParams.width = (int)TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_PX, 50, getResources().getDisplayMetrics());
        triangleLayoutParams.height = (int)TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_PX, 50, getResources().getDisplayMetrics());

        triangle.setRotation(180);
        triangle.setLayoutParams(triangleLayoutParams);

        RelativeLayout.LayoutParams pa = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
//         ((RelativeLayout)findViewById(R.id.triAndRect)).setLayoutParams(pa);
//        ((LinearLayout)findViewById(R.id.layoutInsideScroll)).addView(rect);
//        ((LinearLayout)findViewById(R.id.layoutInsideScroll)).addView(triangle);
        JSONObject data = new JSONObject();
        try {
            data = new JSONObject(getIntent().getStringExtra("data"));

            JSONObject ranges = data.getJSONObject("ranges");
            String [] names = {"LOW", "AVG", "MED", "HI"};
            WholeBar wholeBar = new WholeBar(this);
            for (String s : names) {
                JSONObject range = ranges.getJSONObject(s);
                wholeBar.addBarlet(range.getDouble("max"));
            }
            rootLinearLayout.addView(wholeBar);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public void jsonRead(String json) throws JSONException{
        JSONObject jsonObject = new JSONObject(json);



    }

}

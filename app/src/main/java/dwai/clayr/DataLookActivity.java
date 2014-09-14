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

import org.json.JSONException;
import org.json.JSONObject;

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





        String json = "{\n" +
                "    hematocrit: {\n" +
                "        ranges: {\n" +
                "            AVG: {\n" +
                "                max: 50,\n" +
                "                hex: \"379F7A\",\n" +
                "                min: 38.8\n" +
                "            }\n" +
                "        },\n" +
                "        brief_desc: \"pct space RBCs take up\",\n" +
                "        unit: \"%\",\n" +
                "        value: 24.2,\n" +
                "        desc: \"\"\n" +
                "    },\n" +
                "    hemo: {\n" +
                "        ranges: {\n" +
                "            AVG: {\n" +
                "                max: 17.5,\n" +
                "                hex: \"379F7A\",\n" +
                "                min: 13.5\n" +
                "            }\n" +
                "        },\n" +
                "        brief_desc: \"Oxygen capacity of RBCs\",\n" +
                "        unit: \"g/dL\",\n" +
                "        value: 8.6,\n" +
                "        desc: \"\"\n" +
                "    },\n" +
                "    mch: {\n" +
                "        ranges: {\n" +
                "            AVG: {\n" +
                "                max: 34,\n" +
                "                hex: \"379F7A\",\n" +
                "                min: 28\n" +
                "            }\n" +
                "        },\n" +
                "        brief_desc: \"Average mass of a hemoglobin per RBC\",\n" +
                "        unit: \"pg\",\n" +
                "        value: 32.6,\n" +
                "        desc: \"\"\n" +
                "    },\n" +
                "    mchc: {\n" +
                "        ranges: {\n" +
                "            AVG: {\n" +
                "                max: 36,\n" +
                "                hex: \"379F7A\",\n" +
                "                min: 32\n" +
                "            }\n" +
                "        },\n" +
                "        brief_desc: \"concentration of hemoglobin in volume of RBCs\",\n" +
                "        unit: \"g/dL\",\n" +
                "        value: 35.3,\n" +
                "        desc: \"\"\n" +
                "    },\n" +
                "    rdw: {\n" +
                "        ranges: {\n" +
                "            AVG: {\n" +
                "                max: 46,\n" +
                "                hex: \"379F7A\",\n" +
                "                min: 39\n" +
                "            }\n" +
                "        },\n" +
                "        brief_desc: \"measures variation in RBC size\",\n" +
                "        unit: \"fL\",\n" +
                "        value: 19.5,\n" +
                "        desc: \"\"\n" +
                "    },\n" +
                "    wbc: {\n" +
                "        ranges: {\n" +
                "            AVG: {\n" +
                "                max: 10.5,\n" +
                "                hex: \"379F7A\",\n" +
                "                min: 3.5\n" +
                "            }\n" +
                "        },\n" +
                "        brief_desc: \"White Blood Cell count\",\n" +
                "        unit: \"10^3 cells/uL\",\n" +
                "        value: 2.4,\n" +
                "        desc: \"When a person has a bacterial infection, the number of white cells rises very quickly. The number of white blood cells is sometimes used to find an infection or to see how the body is dealing with cancer treatment.\"\n" +
                "    },\n" +
                "    mcv: {\n" +
                "        ranges: {\n" +
                "            AVG: {\n" +
                "                max: 96,\n" +
                "                hex: \"379F7A\",\n" +
                "                min: 84\n" +
                "            }\n" +
                "        },\n" +
                "        brief_desc: \"Average volume of a RBC\",\n" +
                "        unit: \"fL\",\n" +
                "        value: 92.2,\n" +
                "        desc: \"\"\n" +
                "    },\n" +
                "    rbc: {\n" +
                "        ranges: {\n" +
                "            AVG: {\n" +
                "                max: 5.72,\n" +
                "                hex: \"379F7A\",\n" +
                "                min: 4.32\n" +
                "            }\n" +
                "        },\n" +
                "        brief_desc: \"Red Blood Cell count\",\n" +
                "        unit: \"10^6 cells/uL\",\n" +
                "        value: 2.63,\n" +
                "        desc: \"\"\n" +
                "    },\n" +
                "    id: \"1409676792\"\n" +
                "}";





//        for(Barlet b : wholeBar.getBarlets()){
//            b.setPercentageViewed(0.25);
//        }

    }

    public void jsonRead(String json) throws JSONException{
        JSONObject jsonObject = new JSONObject(json);



    }

}

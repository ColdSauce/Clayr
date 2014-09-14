package dwai.clayr;

import android.content.Context;
import android.graphics.Color;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

/**
 * Created by Stefan on 9/13/2014.
 */
public class Barlet extends View {
    private boolean isSelected = false;
    private double min,max;
    private int color;
    private String name;


    public Barlet(Context c,double min, double max,int color, String name){
        super(c);
        this.setId(View.generateViewId());
        this.min = min;
        this.max = max;
        this.color = color;
        this.name = name;
        this.setBackgroundColor(color);
    }
    public void setPercentageViewed(double percentageViewed){
        android.widget.LinearLayout.LayoutParams params = new android.widget.LinearLayout.LayoutParams(
                0,(int)TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_PX, 100, getResources().getDisplayMetrics()),(float)percentageViewed);
        this.setLayoutParams(params);
    }

    public void setSelected(boolean isSelected){
        if(isSelected){
            float dp = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_PX, 70, getResources().getDisplayMetrics());
            this.setMinimumHeight((int)dp);
        }
        this.isSelected = isSelected;
    }

    public boolean isSelected() {
        return isSelected;
    }

    public double getMin() {
        return min;
    }

    public double getMax() {
        return max;
    }

    public int getColor() {
        return color;
    }

    public String getName() {
        return name;
    }

}

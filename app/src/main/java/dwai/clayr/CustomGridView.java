package dwai.clayr;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridLayout;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Stefan on 9/13/2014.
 */
public class CustomGridView {
    private View parentView;
    private List<GridElement> elements = new ArrayList<GridElement>();

    public CustomGridView(LinearLayout v, int maxHeight, int maxWidth) {
        parentView = v;
        parentView = ((LinearLayout) parentView.findViewById(R.id.rootHistoryGrid));
    }

    public void addGridElement(GridElement e) {
        elements.add(e);

        ViewGroup parentViewGroup = ((ViewGroup) parentView);
        if(parentViewGroup.getChildCount() == 0){
            LinearLayout currentLayout = new LinearLayout(parentView.getContext());
            currentLayout.addView(e);
            LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);

            lp.setMargins(20,20,20,0);
            e.setLayoutParams(lp);
            currentLayout.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT));
            ((LinearLayout) parentView).addView(currentLayout);
            return;
        }

        LinearLayout currentLayout = ((LinearLayout) parentViewGroup.getChildAt(parentViewGroup.getChildCount()-1));

        int lastChildNumber = currentLayout.getChildCount();
        if (lastChildNumber % 3 != 0) {
           currentLayout.addView(e);
           LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);

           lp.setMargins(20,20,20,0);
           e.setLayoutParams(lp);
           currentLayout.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT));

//                ((LinearLayout) parentView).addView(currentLayout);
        } else {
            LinearLayout layoutToAdd = new LinearLayout(parentView.getContext());

            layoutToAdd.addView(e);
            LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
            lp.setMargins(20,20,20,0);

            e.setLayoutParams(lp);
            layoutToAdd.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT));

            ((LinearLayout) parentView).addView(layoutToAdd);

        }

//        LinearLayout layoutToAdd = new LinearLayout(parentView.getContext());
//        layoutToAdd.addView(e);
//        e.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT));
//        layoutToAdd.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT));
//        ((LinearLayout)parentView).addView(layoutToAdd);


    }


}


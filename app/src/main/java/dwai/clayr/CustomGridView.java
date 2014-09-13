package dwai.clayr;

import android.content.Context;
import android.graphics.Bitmap;
import android.media.Image;
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
    private LinearLayout parentView;
    private List<GridElement> elements = new ArrayList<GridElement>();
    private ImageView plusButton = null;

    public CustomGridView(LinearLayout v, int maxHeight, int maxWidth) {
        parentView = v;
        parentView = ((LinearLayout) parentView.findViewById(R.id.rootHistoryGrid));
        plusButton = new ImageView(parentView.getContext());
        LinearLayout linearLayout = new LinearLayout(parentView.getContext());

        plusButton.setBackgroundResource(R.drawable.addbutton);
         LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        linearLayout.setLayoutParams(lp);
            lp.setMargins(20,20,20,0);
        plusButton.setLayoutParams(lp);
        linearLayout.addView(plusButton);

        parentView.addView(linearLayout);
//         currentLayout.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT));

    }

    public List<GridElement> getElements(){
        return this.elements;
    }
    public ImageView getPlusButton(){
        return plusButton;
    }
    public void addGridElement(GridElement e) {


        ViewGroup parentViewGroup = ((ViewGroup) parentView);
        if(parentViewGroup.getChildCount() == 0){


            return;
        }

        elements.add(e);
        LinearLayout currentLayout = null;
        if(parentViewGroup.getChildAt(parentViewGroup.getChildCount()-1) instanceof LinearLayout){
            currentLayout = ((LinearLayout) parentViewGroup.getChildAt(parentViewGroup.getChildCount()-1));        }
        else{
            currentLayout = new LinearLayout(parentView.getContext());
        }
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


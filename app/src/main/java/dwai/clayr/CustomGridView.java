package dwai.clayr;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.Log;
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

    public CustomGridView(View v, int maxHeight, int maxWidth) {
        parentView = v;
        parentView = ((LinearLayout) parentView.findViewById(R.id.rootHistoryGrid));
    }

    public void addGridElement(GridElement e) {
        elements.add(e);

        ViewGroup parentViewGroup = ((ViewGroup) parentView);
        for (int i = 0; i < parentViewGroup.getChildCount(); i++) {
            LinearLayout currentLayout = ((LinearLayout) parentViewGroup.getChildAt(i));

            int lastChildNumber = currentLayout.getChildCount();
            if (lastChildNumber % 3 != 0) {
                currentLayout.addView(e);
            } else {
                LinearLayout layoutToAdd = new LinearLayout(parentView.getContext());
                ((ViewGroup) parentView).addView(layoutToAdd);
                layoutToAdd.addView(e);
            }
        }


    }


}


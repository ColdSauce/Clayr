package dwai.clayr;

import android.content.Context;
import android.graphics.Color;
import android.util.Log;
import android.util.TypedValue;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Stefan on 9/13/2014.
 */
public class WholeBar extends LinearLayout {
    private List<Barlet> barlets = new ArrayList<Barlet>();
    private int indexOfSelectedBarlet = 0;
    private Context c;

    public WholeBar(Context c){
        super(c);
        this.c = c;
        float dp = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_PX, 20, getResources().getDisplayMetrics());

        this.setLayoutParams(new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,(int)dp));



    }

    public void setSelected(int index){
        if(index >= barlets.size()){
            return;
        }
        boolean noneSelected = true;
        for(Barlet b : barlets){
            if(b.isSelected()){
                noneSelected = false;
            }
        }
        //Can't have 2  being selected
        if(noneSelected){
           barlets.get(index).setSelected(true);
        }
        else{
            return;
        }
    }

    public List<Barlet> getBarlets(){
        return barlets;
    }

    //Can only add 4!
    public void addBarlet(double max){
        Barlet barletToAdd = null;
        Color color;

        switch (barlets.size()){
            case 0:
                barletToAdd = new Barlet(c,0,max,c.getResources().getColor(R.color.lightBlue),"LOW");

                break;
            case 1:
                barletToAdd = new Barlet(c,barlets.get(0).getMax()+1,max,c.getResources().getColor(R.color.green),"AVG");
                break;
            case 2:
                barletToAdd = new Barlet(c,barlets.get(1).getMax()+1,max,c.getResources().getColor(R.color.orange),"MED");
                break;

            case 3:
                barletToAdd = new Barlet(c,barlets.get(2).getMax()+1,max,c.getResources().getColor(R.color.red),"HI");
                break;
            default:
                 Log.e("errorstuff","SDFJFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFEEEEEEEEEERRRRRRRRRROOOOOOOOOOOOOOORRRRRRRRRRRRRRRR");
                 return;
        }
        this.addView(barletToAdd);
        barlets.add(barletToAdd);
    }
}

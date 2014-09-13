package dwai.clayr;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.Log;
import android.widget.GridLayout;
import android.widget.GridView;
import android.widget.ImageView;

/**
 * Created by Stefan on 9/13/2014.
 */
public class CustomGridView {
    private Context context;
    private int currentCols,currentRows = 0;
    private int currentHeight = 0;
    private int maxHeight = 0;
    private int maxWidth = 0;
    public CustomGridView(Context c,int maxHeight,int maxWidth){
        context = c;
        this.maxHeight = maxHeight;
        this.maxWidth = maxWidth;
    }

    public void addGridElement(GridElement e){
        
    }

    private class GridElement {
        private Bitmap img;
        public GridElement(Bitmap img){
            this.img = img;
        }
        public void showImage(ImageView imageView){
            Log.e("NULL","EITHER THE IMAGE VIEW OR THE BITMAP IS NULL!");
            if(imageView == null || img == null){
                return;
            }
            imageView.setImageBitmap(img);
        }

    }



}

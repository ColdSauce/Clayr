package dwai.clayr;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.Log;
import android.widget.ImageView;

public class GridElement extends ImageView {
    private Bitmap img;
    public GridElement(Context c, Bitmap img){
        super(c);
        this.img = img;

    }
    public void showImage(ImageView imageView){
        Log.e("NULL", "EITHER THE IMAGE VIEW OR THE BITMAP IS NULL!");
        if(imageView == null || img == null){
            return;
        }
        imageView.setImageBitmap(img);
    }

}


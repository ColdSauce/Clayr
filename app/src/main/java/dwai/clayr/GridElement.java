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
        this.setImageBitmap(img);

    }


}


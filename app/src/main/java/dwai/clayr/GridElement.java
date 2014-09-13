package dwai.clayr;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

public class GridElement extends ImageView {
    private Bitmap img;
    public GridElement(Context c, Bitmap img){
        super(c);
        this.img = img;
        img = overlay(img, BitmapFactory.decodeResource(this.getResources(),
                        R.drawable.greenoverlay));
                this.setImageBitmap(img);

        this.setClickable(true);

    }




    public static Bitmap overlay(Bitmap bmp1, Bitmap bmp2)
    {
        try
        {
            int maxWidth = (bmp1.getWidth() > bmp2.getWidth() ? bmp1.getWidth() : bmp2.getWidth());
            int maxHeight = (bmp1.getHeight() > bmp2.getHeight() ? bmp1.getHeight() : bmp2.getHeight());
            Bitmap bmOverlay = Bitmap.createBitmap(maxWidth, maxHeight,  bmp1.getConfig());
            Canvas canvas = new Canvas(bmOverlay);
            canvas.drawBitmap(bmp1, 0, 0, null);
            canvas.drawBitmap(bmp2, 0, 0, null);
            return bmOverlay;

        } catch (Exception e)
        {
            // TODO: handle exception
            e.printStackTrace();
            return null;
        }
    }


}


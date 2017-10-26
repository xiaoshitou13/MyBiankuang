package test.bwie.com.mybiankuang;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.Xfermode;
import android.graphics.drawable.BitmapDrawable;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import static android.R.attr.bitmap;

/**
 * Created by 白玉春 on 2017/10/26.
 */

public class MyView extends android.support.v7.widget.AppCompatImageView {

    private final Paint paint1;
    private final Xfermode xfermode;
    private final Paint mpain;
    private RectF rect;
    private Bitmap bitmap;

    public MyView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);


        paint1 = new Paint();
        paint1.setAntiAlias(true);
        paint1.setStrokeWidth(10);
        paint1.setColor(Color.GRAY);
        paint1.setStyle(Paint.Style.STROKE);
        setLayerType(LAYER_TYPE_SOFTWARE, null);
        xfermode = new PorterDuffXfermode(PorterDuff.Mode.DST_IN);
        mpain = new Paint(Paint.ANTI_ALIAS_FLAG);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        int redaio = 55;



        int width = getWidth();
        int height = getHeight();
        Bitmap.Config config = Bitmap.Config.ARGB_8888;

        Canvas canvas1=null;
        BitmapDrawable drawable = (BitmapDrawable) getDrawable();
        drawable.setBounds(0, 0, width, height);
        drawable.draw(canvas);
        if (bitmap == null){
            Log.i("porterduffviewimage","bitmap==null");
            Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
            rect = new RectF(0,0,width,height);
            bitmap = Bitmap.createBitmap(width, height, config);
            canvas1 = new Canvas(bitmap);
            canvas1.drawOval(rect, paint);

        }

        mpain.setXfermode(xfermode);
        canvas.drawBitmap(bitmap,0,0,mpain);

        canvas.drawArc(rect,width+60,height+60,false,paint1);
    }


}

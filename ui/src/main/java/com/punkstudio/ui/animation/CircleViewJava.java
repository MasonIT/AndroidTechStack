package com.punkstudio.ui.animation;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import com.punkstudio.ui.Utils;

import androidx.annotation.Nullable;

import static com.punkstudio.ConstantKt.PRO_TAG;

/**
 * Date:2020/12/23-2:03 PM
 *
 * @author Mason
 */
public class CircleViewJava extends View {

    private float radius = Utils.Companion.dp2px(50f);
    private final Paint mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);

    {
        Log.d(PRO_TAG, "2222");
        mPaint.setColor(Color.BLUE);
    }

    public CircleViewJava(Context context, @Nullable @org.jetbrains.annotations.Nullable AttributeSet attrs) {
        super(context, attrs);
        Log.d(PRO_TAG, "1111");
    }

    public float getRadius() {
        return radius;
    }

    public void setRadius(float radius) {
        this.radius = radius;
        invalidate();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawCircle((float)getWidth() / 2, (float)getHeight() / 2, radius, mPaint);
    }
}

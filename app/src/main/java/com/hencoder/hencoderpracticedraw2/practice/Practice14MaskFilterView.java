package com.hencoder.hencoderpracticedraw2.practice;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BlurMaskFilter;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.hencoder.hencoderpracticedraw2.R;

public class Practice14MaskFilterView extends View {
    Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    Bitmap bitmap;

    public Practice14MaskFilterView(Context context) {
        super(context);
    }

    public Practice14MaskFilterView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice14MaskFilterView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    {
        setLayerType(LAYER_TYPE_SOFTWARE, null);
        bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.what_the_fuck);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        /**
         * blur 模糊
         *
         * NORMAL: 内外都模糊绘制
         * SOLID: 内部正常绘制，外部模糊
         * INNER: 内部模糊，外部不绘制
         * OUTER: 内部不绘制，外部模糊（什么鬼？
         */
        // 用 Paint.setMaskFilter 来设置不同的 BlurMaskFilter
        BlurMaskFilter blurMaskFilter = new BlurMaskFilter(50, BlurMaskFilter.Blur.NORMAL);
        paint.setMaskFilter(blurMaskFilter);
        // 第一个：NORMAL
        canvas.drawBitmap(bitmap, 100, 50, paint);

        // 第二个：INNER
        BlurMaskFilter blurMaskFilter_inner = new BlurMaskFilter(250, BlurMaskFilter.Blur.INNER);
        paint.setMaskFilter(blurMaskFilter_inner);
        canvas.drawBitmap(bitmap, bitmap.getWidth() + 200, 50, paint);

        // 第三个：OUTER
        BlurMaskFilter blurMaskFilter_outer = new BlurMaskFilter(50, BlurMaskFilter.Blur.OUTER);
        paint.setMaskFilter(blurMaskFilter_outer);
        canvas.drawBitmap(bitmap, 100, bitmap.getHeight() + 100, paint);

        // 第四个：SOLID
        BlurMaskFilter blurMaskFilter_solid = new BlurMaskFilter(50, BlurMaskFilter.Blur.SOLID);
        paint.setMaskFilter(blurMaskFilter_solid);
        canvas.drawBitmap(bitmap, bitmap.getWidth() + 200, bitmap.getHeight() + 100, paint);
    }
}

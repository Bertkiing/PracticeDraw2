package com.hencoder.hencoderpracticedraw2.practice;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.LightingColorFilter;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.hencoder.hencoderpracticedraw2.R;

public class Practice06LightingColorFilterView extends View {
    Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    Bitmap bitmap;

    public Practice06LightingColorFilterView(Context context) {
        super(context);
    }

    public Practice06LightingColorFilterView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice06LightingColorFilterView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    {
        bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.batman);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        // 使用 Paint.setColorFilter() 来设置 LightingColorFilter
        /**
         * 一个「保持原样」的「基本 LightingColorFilter 」，mul 为 0xffffff，add 为 0x000000（也就是0）
         * 去掉某种原色：想去掉原像素中的红色，可以把它的 mul 改为 0x00ffff （红色部分为 0 ）,add 为 0x000000（也就是0）
         * 增强某个颜色，就可以把它的 add 改为 0x003000 （绿色部分为 0x30 ），
         */
        LightingColorFilter colorFilter = new LightingColorFilter(0x00ffff,0x000000);
        paint.setColorFilter(colorFilter);
        // 第一个 LightingColorFilter：去掉红色部分
        canvas.drawBitmap(bitmap, 0, 0, paint);

        // 第二个 LightingColorFilter：增强绿色部分
        LightingColorFilter colorFilter1 = new LightingColorFilter(0xffffff,0x003000);
        paint.setColorFilter(colorFilter1);
        canvas.drawBitmap(bitmap, bitmap.getWidth() + 100, 0, paint);
    }
}

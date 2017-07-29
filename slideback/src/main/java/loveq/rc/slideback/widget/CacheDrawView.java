package loveq.rc.slideback.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.view.View;

/**
 * Created by rc on 2017/7/29.
 * Description:
 */

public class CacheDrawView extends View {

    private View mCacheView;


    public CacheDrawView(Context context) {
        super(context);
    }

    public void drawCacheView(View cacheView) {
        mCacheView = cacheView;
        invalidate();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        if (mCacheView != null) {
            mCacheView.draw(canvas);
        }
    }

    @Override
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        mCacheView = null;
    }
}

package loveq.rc.slideback.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.FrameLayout;

/**
 * Created by rc on 2017/7/29.
 * Description:
 */

public class SlideBackLayout extends FrameLayout {
    public SlideBackLayout(@NonNull Context context, View contentView, View preContentView,
                           Drawable preDecorViewDrawable) {
        super(context);
    }
}

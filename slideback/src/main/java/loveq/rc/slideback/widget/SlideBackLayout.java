package loveq.rc.slideback.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.FrameLayout;

import loveq.rc.slideback.SlideConfig;
import loveq.rc.slideback.callback.OnInternalStateListener;

/**
 * Created by rc on 2017/7/29.
 * Description:
 */

public class SlideBackLayout extends FrameLayout {
    private View mContentView;
    private View mPreContentView;
    private Drawable mPreDecorViewDrawable;
    private OnInternalStateListener mOnInternalStateListener;


    public SlideBackLayout(@NonNull Context context, View contentView, View preContentView,
                           Drawable preDecorViewDrawable, SlideConfig config,
                           OnInternalStateListener onInternalStateListener) {
        super(context);

        mContentView = contentView;
        mPreContentView = preContentView;
        mPreDecorViewDrawable = preDecorViewDrawable;
        mOnInternalStateListener = onInternalStateListener;


    }
}

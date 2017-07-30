package loveq.rc.slideback.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.v4.view.ViewGroupCompat;
import android.support.v4.widget.ViewDragHelper;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

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

    private final String mTestName;
    private int mScreenWidth;
    private static final int MIN_FLING_VELOCITY = 400;

    private float mSlideOutVelocity;
    private ViewDragHelper mDragHelper;
    private float mSlideOutRange;

    private boolean mRotateScreen;
    private CacheDrawView mCacheDrawView;
    private boolean mCloseFlagForWindowFocus;
    private boolean mCloseFlagForDetached;

    public SlideBackLayout(@NonNull Context context, View contentView, View preContentView,
                           Drawable preDecorViewDrawable, SlideConfig config,
                           OnInternalStateListener onInternalStateListener) {
        super(context);

        mContentView = contentView;
        mPreContentView = preContentView;
        mPreDecorViewDrawable = preDecorViewDrawable;
        mOnInternalStateListener = onInternalStateListener;

        initConfig(config);

        if (preContentView instanceof LinearLayout) {
            mTestName = "1号滑动";
        } else {
            mTestName = "2号滑动";
        }
    }

    private void initConfig(SlideConfig config) {
        if (config == null) {
            config = new SlideConfig.Builder().create();
        }
        mScreenWidth = getResources().getDisplayMetrics().widthPixels;

        float density = getResources().getDisplayMetrics().density;
        float mimVel = MIN_FLING_VELOCITY * density;

        ViewGroupCompat.setMotionEventSplittingEnabled(this, false);


    }

    class SlideLeftCallBack extends ViewDragHelper.Callback {

        @Override
        public boolean tryCaptureView(View child, int pointerId) {
            return child == mContentView;
        }

        @Override
        public int clampViewPositionHorizontal(View child, int left, int dx) {
            return Math.max(Math.min(mScreenWidth, left), 0);
        }

        @Override
        public int getViewHorizontalDragRange(View child) {
            return mScreenWidth;
        }

        @Override
        public void onViewReleased(View releasedChild, float xvel, float yvel) {
            if (releasedChild == mContentView) {
                if (xvel > mSlideOutVelocity) {
                    mDragHelper.settleCapturedViewAt(mScreenWidth, 0);
                    invalidate();
                    return;
                }

                if (mContentView.getLeft() < mSlideOutRange) {
                    mDragHelper.settleCapturedViewAt(0, 0);
                } else {
                    mDragHelper.settleCapturedViewAt(mScreenWidth, 0);
                }
                invalidate();
            }
        }

        @Override
        public void onViewDragStateChanged(int state) {
            switch (state) {
                case ViewDragHelper.STATE_IDLE:
                    if (mContentView.getLeft() == 0) {
                        mOnInternalStateListener.onOpen();
                    } else if (mContentView.getLeft() == mScreenWidth) {
                        if (mRotateScreen && mCacheDrawView.getVisibility() == INVISIBLE) {
                            mCacheDrawView.setBackground(mPreDecorViewDrawable);
                            mCacheDrawView.drawCacheView(mPreContentView);
                            mCacheDrawView.setVisibility(VISIBLE);

                            mCloseFlagForDetached = true;
                            mCloseFlagForWindowFocus = true;
                            mPreContentView.setTag("notScreenOrientationChange");
                            mOnInternalStateListener.onClose(true);
                            mPreContentView.postDelayed(new Runnable() {
                                @Override
                                public void run() {
                                    mCacheDrawView.setBackground(mPreDecorViewDrawable);
                                    mCacheDrawView.drawCacheView(mPreContentView);
                                }
                            }, 10);
                        }
                    }
            }
        }
    }
}

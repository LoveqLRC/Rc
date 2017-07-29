package loveq.rc.slideback.callback;

import android.support.annotation.FloatRange;

import loveq.rc.slideback.widget.SlideBackLayout;

/**
 * Created by rc on 2017/7/29.
 * Description:
 */

public interface OnInternalStateListener {
    void onSlide(@FloatRange(from = 0.0, to = 1.0) float percent);

    void onOpen();

    void onClose(boolean finishActivity);

    void onCheckPreActivity(SlideBackLayout slideBackLayout);
}

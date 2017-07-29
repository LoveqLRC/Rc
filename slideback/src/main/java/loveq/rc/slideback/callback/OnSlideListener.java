package loveq.rc.slideback.callback;

import android.support.annotation.FloatRange;

/**
 * Created by rc on 2017/7/29.
 * Description:
 */

public interface OnSlideListener {
    void onSlide(@FloatRange(from = 0.0, to = 1.0) float percent);

    void onOpen();

    void onClose();
}

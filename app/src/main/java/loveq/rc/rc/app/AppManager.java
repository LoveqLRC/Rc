package loveq.rc.rc.app;

import android.util.SparseArray;

/**
 * Author：Rc
 * 0n 2017/7/30 15:51
 */

public class AppManager {
    private static AppManager sInstance;
    private SparseArray<String> mNavActivityOrder;

    private AppManager() {

    }

    public static AppManager getAppManager() {
        if (sInstance == null) {
            synchronized (AppManager.class) {
                if (sInstance == null) {
                    sInstance = new AppManager();
                }
            }
        }
        return sInstance;
    }

    public void clear() {
        if (mNavActivityOrder != null && mNavActivityOrder.size() > 0) {
            mNavActivityOrder.clear();
        }
    }

    public Class getLastNavActivity() throws ClassNotFoundException {
        if (mNavActivityOrder == null || mNavActivityOrder.size() == 0 || mNavActivityOrder
                .size() == 1) {
            return null;
        }
        return Class.forName(mNavActivityOrder.get(mNavActivityOrder.size() - 2));
    }

    public Class getCurrentNavActivity() throws ClassNotFoundException {
        if (mNavActivityOrder == null || mNavActivityOrder.size() == 0) {
            return null;
        }
        return Class.forName(mNavActivityOrder.get(mNavActivityOrder.size() - 1));
    }

    public void orderNavActivity(String className, boolean backPress) {
        if (mNavActivityOrder == null) {
            mNavActivityOrder = new SparseArray<>();
        }
        // 取到类的索引
        final int index = mNavActivityOrder.indexOfValue(className);
        if (!backPress) {
            // 不是返回键的情况，即点击侧栏跳转的情况
            if (index == -1) {
                // 还没有过数据的时候，保存当前的类型
                mNavActivityOrder.put(mNavActivityOrder.size(), className);
            } else {
                // 有过数据的时候，将该类名索引到最高位
                for (int i = index + 1; i < mNavActivityOrder.size(); i++) {
                    mNavActivityOrder.put(i - 1, mNavActivityOrder.valueAt(i));
                }
                mNavActivityOrder.put(mNavActivityOrder.size() - 1, className);
            }
        } else {
            // 返回键的情况，将位置最高的类名放到最低位
            className = mNavActivityOrder.valueAt(mNavActivityOrder.size() - 1);
            for (int i = index; i >= 0; i--) {
                mNavActivityOrder.put(i + 1, mNavActivityOrder.valueAt(i));
            }
            mNavActivityOrder.put(0, className);
        }

    }
}

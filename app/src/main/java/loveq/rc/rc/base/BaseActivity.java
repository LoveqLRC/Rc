package loveq.rc.rc.base;

import android.database.Observable;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.os.StrictMode;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import loveq.rc.rc.BuildConfig;
import loveq.rc.rc.annotation.ActivityFragmentInject;
import loveq.rc.rc.module.settings.ui.SettingsActivity;
import rc.loveq.changeskin.SkinManager;

/**
 * Author：Rc
 * 0n 2017/7/30 16:10
 */

public abstract class BaseActivity<T extends BasePresenter> extends AppCompatActivity implements View.OnClickListener, BaseView {

    protected T mPresenter;
    /**
     * 标示该activity是否可滑动退出,默认false
     */
    protected boolean mEnableSlidr;

    /**
     * 布局的id
     */
    protected int mContentViewId;
    /**
     * 是否存在NavigationView
     */
    protected boolean mHasNavigationView;
    /**
     * 滑动布局
     */
    protected DrawerLayout mDrawerLayout;
    /**
     * 侧滑导航布局
     */
    protected NavigationView mNavigationView;
    /**
     * 菜单的id
     */
    private int mMenuId;

    /**
     * Toolbar标题
     */
    private int mToolbarTitle;

    /**
     * 默认选中的菜单项
     */
    private int mMenuDefaultCheckedItem;

    /**
     * Toolbar左侧按钮的样式
     */
    private int mToolbarIndicator;

    /**
     * 结束Activity的可观测对象
     */
    private Observable<Boolean> mFinishObservable;

    /**
     * 跳转的类
     */
    private Class mClass;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);

        if (getClass().isAnnotationPresent(ActivityFragmentInject.class)) {
            ActivityFragmentInject annotation = getClass().getAnnotation(ActivityFragmentInject.class);
            mContentViewId = annotation.contentViewId();
            mEnableSlidr = annotation.enableSlidr();
            mHasNavigationView = annotation.hasNavigationView();
            mMenuId = annotation.menuId();
            mToolbarTitle = annotation.toolbarTitle();
            mToolbarIndicator = annotation.toolbarIndicator();
            mMenuDefaultCheckedItem = annotation.menuDefaultCheckedItem();
        } else {
            throw new RuntimeException("Class must add annotations of ActivityFragmentInitParams.class");
        }
        if (BuildConfig.DEBUG) {
            StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder().detectAll().penaltyLog().build());
            StrictMode.setVmPolicy(new StrictMode.VmPolicy.Builder().detectAll().penaltyLog().build());
        }

        if (this instanceof SettingsActivity) {
            SkinManager.getInstance().register(this);
        }
        initTheme();
    }

    private void initTheme() {

    }
}

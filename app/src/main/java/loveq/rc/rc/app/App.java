package loveq.rc.rc.app;

import android.app.Application;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.os.StrictMode;

import com.oubowu.slideback.ActivityHelper;
import com.socks.library.KLog;
import com.squareup.leakcanary.LeakCanary;
import com.squareup.leakcanary.RefWatcher;


import org.greenrobot.greendao.query.QueryBuilder;

import loveq.rc.rc.BuildConfig;
import loveq.rc.rc.common.Constant;
import loveq.rc.rc.db.gen.DaoMaster;
import loveq.rc.rc.db.gen.DaoSession;


/**
 * Author：Rc
 * 0n 2017/7/30 10:25
 */

public class App extends Application {

    public DaoSession mDaoSession;
    private static Context sApplicationContext;
    public ActivityHelper mActivityHelper;
    private RefWatcher mRefWatcher;

    @Override
    public void onCreate() {
        super.onCreate();
        if (LeakCanary.isInAnalyzerProcess(this)) {
            // This process is dedicated to LeakCanary for heap analysis.
            // You should not init your app in this process.
            return;
        }
//        enabledStrictMode();
        mRefWatcher = LeakCanary.install(this);
        SkinManager.getInstance().init(this);
        setupDatabase();

        sApplicationContext = this;
        KLog.init(BuildConfig.DEBUG);
        mActivityHelper = new ActivityHelper();
        registerActivityLifecycleCallbacks(mActivityHelper);
    }

    public static ActivityHelper getActivityHelper() {
        return ((App) sApplicationContext).mActivityHelper;
    }

    public static RefWatcher getRefWatcher(Context context) {
        App application = (App) context.getApplicationContext();
        return application.mRefWatcher;
    }

    private void setupDatabase() {
        DaoMaster.DevOpenHelper helper = new DaoMaster.DevOpenHelper(this, Constant.DB_NAME, null);
        SQLiteDatabase db = helper.getWritableDatabase();
        DaoMaster daoMaster = new DaoMaster(db);
        mDaoSession = daoMaster.newSession();
        QueryBuilder.LOG_SQL = BuildConfig.DEBUG;
        QueryBuilder.LOG_VALUES = BuildConfig.DEBUG;
    }

    private static void enabledStrictMode() {
        StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder() //
                .detectAll() //
                .penaltyLog() //
                .penaltyDeath() //
                .build());
    }

    public DaoSession getDaoSession() {
        return mDaoSession;
    }

    public static Context getContext() {
        return sApplicationContext;
    }
}


package loveq.rc.rc.app;

import android.app.Application;
import android.os.StrictMode;

import com.squareup.leakcanary.LeakCanary;

/**
 * Author：Rc
 * 0n 2017/7/30 10:25
 */

public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        if (LeakCanary.isInAnalyzerProcess(this)) {
            // This process is dedicated to LeakCanary for heap analysis.
            // You should not init your app in this process.
            return;
        }
        enabledStrictMode();
        LeakCanary.install(this);
    }

    private static void enabledStrictMode() {
        StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder() //
                .detectAll() //
                .penaltyLog() //
                .penaltyDeath() //
                .build());
    }
}


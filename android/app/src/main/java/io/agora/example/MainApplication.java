package io.agora.example;

import android.app.Application;

import com.avishayil.rnrestart.ReactNativeRestartPackage;
import com.facebook.react.ReactApplication;
import com.facebook.react.ReactNativeHost;
import com.facebook.react.ReactPackage;
import com.facebook.react.shell.MainReactPackage;
import com.facebook.soloader.SoLoader;
import com.masteratul.exceptionhandler.ReactNativeExceptionHandlerPackage;
import com.tencent.bugly.crashreport.CrashReport;

import java.util.Arrays;
import java.util.List;

import io.agora.openlive.AgoraPackage;

public class MainApplication extends Application implements ReactApplication {

    private final ReactNativeHost mReactNativeHost = new ReactNativeHost(this) {
        @Override
        public boolean getUseDeveloperSupport() {
            return BuildConfig.DEBUG;
        }

        @Override
        protected List<ReactPackage> getPackages() {
            return Arrays.<ReactPackage>asList(
                    new MainReactPackage(),
                    new ReactNativeRestartPackage(),
                    new ReactNativeExceptionHandlerPackage(),
                    new AgoraPackage()
            );
        }

        @Override
        protected String getJSMainModuleName() {
            return "index";
        }

    };

    @Override
    public ReactNativeHost getReactNativeHost() {
        return mReactNativeHost;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        SoLoader.init(this, /* native exopackage */ false);
        CrashReport.initCrashReport(getApplicationContext(), "2da5c1fc8d", true);
    }
}

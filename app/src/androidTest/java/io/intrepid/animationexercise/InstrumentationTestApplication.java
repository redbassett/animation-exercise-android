package io.intrepid.animationexercise;

import android.os.AsyncTask;

import org.mockito.Mockito;

import io.intrepid.animationexercise.base.PresenterConfiguration;
import io.intrepid.animationexercise.logging.CrashReporter;
import io.intrepid.animationexercise.rest.RestApi;
import io.intrepid.animationexercise.rest.RetrofitClient;
import io.intrepid.animationexercise.settings.SharePreferencesManager;
import io.intrepid.animationexercise.settings.UserSettings;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class InstrumentationTestApplication extends AnimationexerciseApplication {
    private static RestApi restApiOverride = null;
    private static UserSettings userSettingsOverride = null;

    @Override
    public PresenterConfiguration getPresenterConfiguration() {
        return new PresenterConfiguration(
                // using AsyncTask executor since Espresso automatically waits for it to clear before proceeding
                Schedulers.from(AsyncTask.THREAD_POOL_EXECUTOR),
                AndroidSchedulers.mainThread(),
                userSettingsOverride != null ? userSettingsOverride : SharePreferencesManager.getInstance(this),
                restApiOverride != null ? restApiOverride : RetrofitClient.getApi(),
                Mockito.mock(CrashReporter.class));
    }

    public static void overrideRestApi(RestApi restApi) {
        restApiOverride = restApi;
    }

    public static void clearRestApiOverride() {
        restApiOverride = null;
    }

    public static void overrideUserSettings(UserSettings userSettings) {
        userSettingsOverride = userSettings;
    }

    public static void clearUserSettingsOverride() {
        userSettingsOverride = null;
    }
}

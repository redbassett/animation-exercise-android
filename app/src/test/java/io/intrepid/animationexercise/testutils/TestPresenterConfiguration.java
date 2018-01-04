package io.intrepid.animationexercise.testutils;

import android.support.annotation.NonNull;

import org.mockito.Mockito;

import io.intrepid.animationexercise.base.PresenterConfiguration;
import io.intrepid.animationexercise.logging.CrashReporter;
import rx.schedulers.TestScheduler;

@SuppressWarnings("WeakerAccess")
public class TestPresenterConfiguration extends PresenterConfiguration {
    public static TestPresenterConfiguration createTestConfiguration() {
        CrashReporter crashReporter = Mockito.mock(CrashReporter.class);
        return new TestPresenterConfiguration(crashReporter);
    }

    public TestPresenterConfiguration(@NonNull CrashReporter crashReporter) {
        super(new TestScheduler(), new TestScheduler(), crashReporter);
    }

    @NonNull
    @Override
    public TestScheduler getIoScheduler() {
        return (TestScheduler) super.getIoScheduler();
    }

    @NonNull
    @Override
    public TestScheduler getUiScheduler() {
        return (TestScheduler) super.getUiScheduler();
    }

    /**
     * Helper method for triggering pending Rx events
     */
    public void triggerRxSchedulers() {
        getIoScheduler().triggerActions();
        getUiScheduler().triggerActions();
    }
}

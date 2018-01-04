package io.intrepid.animationexercise.base;

import android.support.annotation.NonNull;

import io.intrepid.animationexercise.logging.CrashReporter;
import rx.Scheduler;

/**
 * Wrapper class for common dependencies that all presenters are expected to have
 */
public class PresenterConfiguration {
    @NonNull
    private final Scheduler ioScheduler;
    @NonNull
    private final Scheduler uiScheduler;
    @NonNull
    private final CrashReporter crashReporter;


    public PresenterConfiguration(@NonNull Scheduler ioScheduler,
                                  @NonNull Scheduler uiScheduler,
                                  @NonNull CrashReporter crashReporter) {
        this.ioScheduler = ioScheduler;
        this.uiScheduler = uiScheduler;
        this.crashReporter = crashReporter;
    }

    @NonNull
    public Scheduler getIoScheduler() {
        return ioScheduler;
    }

    @NonNull
    public Scheduler getUiScheduler() {
        return uiScheduler;
    }

    @NonNull
    public CrashReporter getCrashReporter() {
        return crashReporter;
    }
}

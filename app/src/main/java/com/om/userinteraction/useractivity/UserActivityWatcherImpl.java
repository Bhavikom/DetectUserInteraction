package com.om.userinteraction.useractivity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.om.userinteraction.RootActivity;
import com.om.userinteraction.util.ResumedActivityGetter;

import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

public final class UserActivityWatcherImpl implements UserActivityWatcher {
    private Disposable timerDisposable;
    private final ResumedActivityGetter resumedActivityGetter;
    private static final long MAX_USER_INACTIVITY_TIME_VALUE = 10L;
    private static final TimeUnit MAX_USER_INACTIVITY_TIME_UNIT;
    public void onUserInteracted() {
        this.setupTimer();
    }

    private final void setupTimer() {
        Disposable var10000 = this.timerDisposable;
        if (this.timerDisposable != null) {
            var10000.dispose();
        }

        this.timerDisposable = Observable.timer(MAX_USER_INACTIVITY_TIME_VALUE, MAX_USER_INACTIVITY_TIME_UNIT).subscribe((Consumer)(new Consumer() {
            // $FF: synthetic method
            // $FF: bridge method
            public void accept(Object var1) {
                this.accept((Long)var1);
            }

            public final void accept(Long aLong) {
                Activity currentActivityContext = UserActivityWatcherImpl.this.resumedActivityGetter.getResumedActivity();
                if (currentActivityContext != null && !(currentActivityContext instanceof RootActivity)) {
                    Intent intent = new Intent((Context)currentActivityContext, RootActivity.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    currentActivityContext.startActivity(intent);
                }

            }
        }));
    }

    public UserActivityWatcherImpl(@NotNull ResumedActivityGetter resumedActivityGetter) {
        super();
        Intrinsics.checkParameterIsNotNull(resumedActivityGetter, "resumedActivityGetter");
        this.resumedActivityGetter = resumedActivityGetter;
    }

    static {
        MAX_USER_INACTIVITY_TIME_UNIT = TimeUnit.SECONDS;
    }
    public static final class Companion {
        private Companion() {
        }
    }
}


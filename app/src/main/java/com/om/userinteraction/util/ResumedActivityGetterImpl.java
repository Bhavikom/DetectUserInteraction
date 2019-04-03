package com.om.userinteraction.util;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import kotlin.jvm.internal.Intrinsics;
public final class ResumedActivityGetterImpl implements ResumedActivityGetter, Application.ActivityLifecycleCallbacks {
    private Activity lastResumedActivity;
    private int runningActivitiesNumber;

    @Nullable
    public Activity getResumedActivity() {
        return this.lastResumedActivity;
    }

    public void onActivityCreated(@NotNull Activity activity, @Nullable Bundle bundle) {
        Intrinsics.checkParameterIsNotNull(activity, "activity");
        int var3 = this.runningActivitiesNumber++;
    }

    public void onActivityStarted(@NotNull Activity activity) {
        Intrinsics.checkParameterIsNotNull(activity, "activity");
    }

    public void onActivityResumed(@NotNull Activity activity) {
        Intrinsics.checkParameterIsNotNull(activity, "activity");
        this.lastResumedActivity = activity;
    }

    public void onActivityPaused(@NotNull Activity activity) {
        Intrinsics.checkParameterIsNotNull(activity, "activity");
    }

    public void onActivityStopped(@NotNull Activity activity) {
        Intrinsics.checkParameterIsNotNull(activity, "activity");
    }

    public void onActivitySaveInstanceState(@NotNull Activity activity, @NotNull Bundle bundle) {
        Intrinsics.checkParameterIsNotNull(activity, "activity");
        Intrinsics.checkParameterIsNotNull(bundle, "bundle");
    }

    public void onActivityDestroyed(@NotNull Activity activity) {
        Intrinsics.checkParameterIsNotNull(activity, "activity");
        int var2 = this.runningActivitiesNumber;
        this.runningActivitiesNumber += -1;
        if (this.runningActivitiesNumber == 0) {
            this.lastResumedActivity = (Activity)null;
        }

    }

    public ResumedActivityGetterImpl(@NotNull Application application) {
        super();
        Intrinsics.checkParameterIsNotNull(application, "application");
        application.registerActivityLifecycleCallbacks((Application.ActivityLifecycleCallbacks)this);
    }
}


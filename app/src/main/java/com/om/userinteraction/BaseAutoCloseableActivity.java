package com.om.userinteraction;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import com.om.userinteraction.useractivity.UserActivityWatcher;

import java.util.HashMap;
import javax.inject.Inject;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@SuppressLint({"Registered"})
public class BaseAutoCloseableActivity extends AppCompatActivity {
    @Inject
    @NotNull
    public UserActivityWatcher userActivityWatcher;
    private HashMap _$_findViewCache;

    @NotNull
    public final UserActivityWatcher getUserActivityWatcher() {
        UserActivityWatcher var10000 = this.userActivityWatcher;
        if (this.userActivityWatcher == null) {
            Intrinsics.throwUninitializedPropertyAccessException("userActivityWatcher");
        }

        return var10000;
    }

    public final void setUserActivityWatcher(@NotNull UserActivityWatcher var1) {
        Intrinsics.checkParameterIsNotNull(var1, "<set-?>");
        this.userActivityWatcher = var1;
    }

    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ReturnToMainScreenApplication.applicationComponent.inject(this);
    }
    public void onUserInteraction() {
        super.onUserInteraction();
        UserActivityWatcher var10000 = this.userActivityWatcher;
        if (this.userActivityWatcher == null) {
            Intrinsics.throwUninitializedPropertyAccessException("userActivityWatcher");
        }

        var10000.onUserInteracted();
    }

}

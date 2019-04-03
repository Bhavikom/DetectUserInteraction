package com.om.userinteraction;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class AutoCloseableActivityThree extends BaseAutoCloseableActivity {
    private HashMap _$_findViewCache;

    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.activity_three);
    }

    public final void goToRootActivity(@NotNull View v) {
        Intrinsics.checkParameterIsNotNull(v, "v");
        Intent intent = new Intent((Context)this, RootActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        this.startActivity(intent);
    }

    public View _$_findCachedViewById(int var1) {
        if (this._$_findViewCache == null) {
            this._$_findViewCache = new HashMap();
        }

        View var2 = (View)this._$_findViewCache.get(var1);
        if (var2 == null) {
            var2 = this.findViewById(var1);
            this._$_findViewCache.put(var1, var2);
        }

        return var2;
    }

    public void _$_clearFindViewByIdCache() {
        if (this._$_findViewCache != null) {
            this._$_findViewCache.clear();
        }

    }
}


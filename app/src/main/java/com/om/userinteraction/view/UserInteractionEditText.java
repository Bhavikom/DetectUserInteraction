package com.om.userinteraction.view;

import android.app.Activity;
import android.content.Context;
import android.support.v7.widget.AppCompatEditText;
import android.util.AttributeSet;
import android.view.View;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

public final class UserInteractionEditText extends AppCompatEditText {
    private HashMap _$_findViewCache;

    protected void onTextChanged(@NotNull CharSequence text, int start, int lengthBefore, int lengthAfter) {
        Intrinsics.checkParameterIsNotNull(text, "text");
        super.onTextChanged(text, start, lengthBefore, lengthAfter);
        Context var10000 = this.getContext();
        if (!(var10000 instanceof Activity)) {
            var10000 = null;
        }

        Activity var5 = (Activity)var10000;
        if (var5 != null) {
            var5.onUserInteraction();
        }

    }

    public UserInteractionEditText(@NotNull Context context) {
        super(context);
        Intrinsics.checkParameterIsNotNull(context, "context");

    }

    public UserInteractionEditText(@NotNull Context context, @NotNull AttributeSet attrs) {
        super(context, attrs);
        Intrinsics.checkParameterIsNotNull(context, "context");
        Intrinsics.checkParameterIsNotNull(attrs, "attrs");

    }

    public UserInteractionEditText(@NotNull Context context, @NotNull AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        Intrinsics.checkParameterIsNotNull(context, "context");
        Intrinsics.checkParameterIsNotNull(attrs, "attrs");

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

package com.om.userinteraction.util;

import android.app.Activity;

import org.jetbrains.annotations.Nullable;
public interface ResumedActivityGetter {
    @Nullable
    Activity getResumedActivity();
}
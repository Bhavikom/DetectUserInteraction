package com.wsadurski.returntomainscreen.di

import com.om.userinteraction.useractivity.UserActivityWatcher
import com.om.userinteraction.useractivity.UserActivityWatcherImpl
import com.om.userinteraction.util.ResumedActivityGetter
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by wojciechsadurski on 19.09.2017.
 */

@Module
class ApplicationModule(private val resumedActivityGetter: ResumedActivityGetter) {

    @Provides
    @Singleton
    fun provideUserActivityWatcher(): UserActivityWatcher {
        return UserActivityWatcherImpl(resumedActivityGetter)
    }
}

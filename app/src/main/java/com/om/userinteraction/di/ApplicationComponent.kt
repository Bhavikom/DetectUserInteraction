package com.wsadurski.returntomainscreen.di

import com.om.userinteraction.BaseAutoCloseableActivity
import dagger.Component
import javax.inject.Singleton

/**
 * Created by wojciechsadurski on 19.09.2017.
 */

@Singleton
@Component(modules = [(ApplicationModule::class)])
interface ApplicationComponent {

    fun inject(baseAutoCloseableActivity: BaseAutoCloseableActivity)
}

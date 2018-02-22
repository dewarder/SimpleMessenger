package com.dewarder.messenger.di

import com.dewarder.messenger.Application
import dagger.BindsInstance
import dagger.Component
import dagger.android.support.AndroidSupportInjectionModule

@Component(modules = [
    AndroidSupportInjectionModule::class,
    ActivityModule::class,

    ViewModelModule::class,
    FirebaseModule::class,
    RepositoryModule::class
])
interface ApplicationComponent {

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(application: Application): Builder

        fun build(): ApplicationComponent
    }

    fun inject(application: Application)

}
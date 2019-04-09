package com.treehouse.photoinf

import android.app.Application
import com.treehouse.photoinf.retrofit.AppComponent
import com.treehouse.photoinf.retrofit.DaggerAppComponent

class App : Application() {

    private lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.builder().build();
    }
    fun getComponent() = appComponent
}
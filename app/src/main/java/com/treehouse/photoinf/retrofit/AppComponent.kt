package com.treehouse.photoinf.retrofit

import com.treehouse.photoinf.network.PhotoServices
import dagger.Component
import javax.inject.Singleton

@Component(modules = [NetworkModule::class])
@Singleton
interface AppComponent {
    fun PhotoServices(): PhotoServices
}
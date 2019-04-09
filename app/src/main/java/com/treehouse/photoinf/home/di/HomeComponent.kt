package com.treehouse.photoinf.home.di

import com.treehouse.photoinf.home.MainActivity
import com.treehouse.photoinf.retrofit.AppComponent

import dagger.Component

@Component(dependencies = [AppComponent::class], modules = [HomeModule::class])
@HomeScope
interface HomeComponent {
    fun inject(mainActivity: MainActivity)
}
package com.treehouse.photoinf.home.di

import com.treehouse.photoinf.network.PhotoServices
import com.treehouse.photoinf.home.HomeContract
import com.treehouse.photoinf.home.HomePresenter
import dagger.Module
import dagger.Provides

@Module
class HomeModule(private val view: HomeContract.View) {

    @HomeScope
    @Provides
    fun provideHomePresenter(PhotoServices: PhotoServices)
            : HomeContract.Presenter {
        return HomePresenter(PhotoServices, view)
    }
}
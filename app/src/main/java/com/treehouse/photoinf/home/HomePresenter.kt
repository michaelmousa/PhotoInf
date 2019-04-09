package com.treehouse.photoinf.home

import com.treehouse.photoinf.network.API_KEY
import com.treehouse.photoinf.network.PhotoServices
import com.treehouse.photoinf.network.Photo_SOURCE
import java.net.SocketException
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class HomePresenter  (

    private val photoServices: PhotoServices,
    private val view: HomeContract.View): HomeContract.Presenter {

    private val compositeDisposable = CompositeDisposable()

    override fun getPhotoDetails(format:String, access_token: String) {

        compositeDisposable.add(photoServices.getPhotoDetails(Photo_SOURCE,API_KEY)
            .subscribeOn(Schedulers.io())
            .map { it }
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ view.showResults(it.result) },

                { failure ->
                    if (failure is SocketException) {
                        view.showError("Error")
                    } else {
                        view.showError(failure?.message ?: "An unknown error happened")
                    }}))}}




//list (result)
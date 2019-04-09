package com.treehouse.photoinf.home

import com.treehouse.photoinf.model.Result


interface HomeContract{

    interface View {
        fun showResults(result: List<Result>)
        fun showError(message: String)
    }
    interface Presenter{
        fun getPhotoDetails(format:String, access_token: String)
    }
}
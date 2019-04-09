package com.treehouse.photoinf.network

import com.treehouse.photoinf.model.PhotoData
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

interface PhotoServices {
    @GET(END_POINT)

    fun getPhotoDetails(@Query("_format") format:String,
                       @Query("access-token") access_token:String ): Observable<PhotoData>
}


package com.treehouse.photoinf.model

data class PhotoData(val _meta: Meta, val result: List<Result>)

data class Result(
    val album_id: String,
    val id: String,
    val thumbnail: String,
    val title: String,
    val url: String
)

data class Meta(
    val code: Int,
    val currentPage: Int,
    val message: String,
    val pageCount: Int,
    val perPage: Int,
    val rateLimit: RateLimit,
    val success: Boolean,
    val totalCount: Int
)

data class RateLimit(
    val limit: Int,
    val remaining: Int,
    val reset: Int
)
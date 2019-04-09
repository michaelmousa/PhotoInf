package com.treehouse.photoinf.home
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import android.widget.ImageView
import android.widget.Toast
import com.squareup.picasso.Picasso
import com.treehouse.photoinf.App
import com.treehouse.photoinf.R
import com.treehouse.photoinf.home.di.DaggerHomeComponent
import com.treehouse.photoinf.home.di.HomeModule
import com.treehouse.photoinf.model.PhotoData
import com.treehouse.photoinf.model.Result
import com.treehouse.photoinf.network.API_KEY
import com.treehouse.photoinf.network.Photo_SOURCE
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.item_pass.*
import javax.inject.Inject

class MainActivity : AppCompatActivity(), HomeContract.View {

    private val photoAdapter = PhotoAdapter()
    @Inject
    lateinit var homePresenter: HomeContract.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(com.treehouse.photoinf.R.layout.activity_main)


        DaggerHomeComponent.builder()
            .appComponent((application as App).getComponent())
            .homeModule(HomeModule(this))
            .build()
            .inject(this)

        val layoutManager = LinearLayoutManager(this)

        rvData.layoutManager = layoutManager
        rvData.addItemDecoration(DividerItemDecoration
            (this,layoutManager.orientation))
        rvData.adapter = photoAdapter

        btnShow.setOnClickListener {
            homePresenter.getPhotoDetails(Photo_SOURCE, API_KEY) }
    }
    override fun showError(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()}

    override fun showResults(result: List<Result>) {
        photoAdapter.setData(result)
    }
     }

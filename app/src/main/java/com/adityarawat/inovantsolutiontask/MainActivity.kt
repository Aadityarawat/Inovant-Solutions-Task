package com.adityarawat.inovantsolutiontask

import android.annotation.SuppressLint
import android.graphics.Paint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.core.text.HtmlCompat
import androidx.lifecycle.ViewModelProvider
import androidx.viewpager2.widget.ViewPager2
import com.adityarawat.inovantsolutiontask.Adapter.MyPagerAdapter
import com.adityarawat.inovantsolutiontask.Service.Repository
import com.adityarawat.inovantsolutiontask.Service.Service
import com.adityarawat.inovantsolutiontask.viewModel.MainViewModel
import com.adityarawat.inovantsolutiontask.viewModel.MainViewModelFactory
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import me.relex.circleindicator.CircleIndicator3
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {
    private lateinit var viewPager: ViewPager2
    private lateinit var indicator: CircleIndicator3
    lateinit var mainViewModel: MainViewModel
    lateinit var mdescription : String
    var count = 1

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewPager = findViewById(R.id.viewpager)
        indicator = findViewById(R.id.indicator)

        val adapter = MyPagerAdapter(this)
        viewPager.adapter = adapter

        val updown = findViewById<ImageView>(R.id.updown)
        val textdescription = findViewById<TextView>(R.id.descriptiontv)

        val myTextView = findViewById<TextView>(R.id.learn)
        myTextView.text = "Learn More"
        myTextView.paintFlags = myTextView.paintFlags or Paint.UNDERLINE_TEXT_FLAG

        /*TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            if (position == 0) {
                tab.setIcon(R.drawable.tab_indicator_selected)
                //tab.icon?.setTintList(selectedColorStateList)
            } else {
                tab.setIcon(R.drawable.tab_indicator_default)
                //tab.icon?.setTintList(defaultColorStateList)
            }
        }.attach()*/
        indicator.setViewPager(viewPager)

        val retrofit = Retrofit.Builder()
            .baseUrl("https://klinq.com/rest/V1/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val service = retrofit.create(Service::class.java)
        val repository = Repository(service)

        mainViewModel = ViewModelProvider(this, MainViewModelFactory(repository)).get(MainViewModel::class.java)

        mainViewModel.details.observe(this, {
            Toast.makeText(this,"Success : ${it.status}",Toast.LENGTH_LONG).show()
            mdescription = it.data.description
        })

        updown.setOnClickListener {
            updown.animate().apply {
                duration = 1000
                rotationXBy(180f)
            }
            textdescription.text = HtmlCompat.fromHtml(mdescription, HtmlCompat.FROM_HTML_MODE_COMPACT)
            if (textdescription.visibility == View.VISIBLE) {
                textdescription.visibility = View.GONE
            } else {
                //textdescription.startAnimation(fadeInAnimation)
                textdescription.visibility = View.VISIBLE
            }
        }

        val quantity = findViewById<TextView>(R.id.quntity)
        val sub = findViewById<TextView>(R.id.minus)
        val add = findViewById<TextView>(R.id.add)

        sub.setOnClickListener{
            if(count>0){
                count = count - 1
                quantity.text = count.toString()
            }

        }
        add.setOnClickListener{
            count = count + 1

            quantity.text = count.toString()
        }
    }
}
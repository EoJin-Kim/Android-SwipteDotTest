package com.ej.swiptedottest

import android.database.Cursor
import android.net.Uri
import android.os.Bundle
import android.provider.DocumentsContract
import android.provider.MediaStore
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.viewpager2.widget.ViewPager2
import com.ej.swiptedottest.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    val frag1 = BlankFragment1()
    val frag2 = BlankFragment2()
    val frag3 = BlankFragment3()
    val frag4 = BlankFragment3()
    val frag5 = BlankFragment3()
    val frag6 = BlankFragment3()
    val frag7 = BlankFragment3()
    val fragList = arrayOf(frag1, frag2, frag3,frag4,frag5,frag6,frag7)

    private lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)
        binding.lifecycleOwner = this


        val adapter = FragmentListAdapter(supportFragmentManager, lifecycle, fragList)
        val viewPager = binding.viewPager
        viewPager.adapter = adapter
        val circleIndicator = binding.circleIndicator3

        viewPager.offscreenPageLimit = 1
        val nextItemVisiblePx = resources.getDimension(R.dimen.viewpager_next_item_visible)
        val currentItemHorizontalMarginPx = resources.getDimension(R.dimen.viewpager_current_item_horizontal_margin)
        val pageTranslationX = nextItemVisiblePx + currentItemHorizontalMarginPx
        val pageTransformer = ViewPager2.PageTransformer { page: View, position: Float ->
            page.translationX = -pageTranslationX * position
        }
        viewPager.setPageTransformer(pageTransformer)
        val itemDecoration = HorizontalMarginItemDecoration(
            baseContext,
            R.dimen.viewpager_current_item_horizontal_margin
        )
        viewPager.addItemDecoration(itemDecoration)

        circleIndicator.setViewPager(viewPager)



    }
}
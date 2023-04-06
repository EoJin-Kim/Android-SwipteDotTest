package com.ej.swiptedottest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import com.ej.swiptedottest.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    val frag1 = BlankFragment1()
    val frag2 = BlankFragment2()
    val frag3 = BlankFragment3()
    val fragList = arrayOf(frag1, frag2, frag3)

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
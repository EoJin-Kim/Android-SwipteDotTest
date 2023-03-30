package com.ej.swiptedottest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
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


        val viewPager = binding.viewPager
        val circleIndicator = binding.circleIndicator3

        val tabAdapter = object : FragmentStateAdapter(this) {
            override fun getItemCount(): Int {
                return fragList.size
            }
            override fun createFragment(position: Int): Fragment {
                return fragList[position]
            }
        }
        circleIndicator.setViewPager(viewPager)
        viewPager.adapter = tabAdapter


    }
}
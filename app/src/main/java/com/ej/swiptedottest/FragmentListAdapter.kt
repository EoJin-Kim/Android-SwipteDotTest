package com.ej.swiptedottest

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter

class FragmentListAdapter(fm : FragmentManager, lifecycle: Lifecycle, private val fragList : Array<Fragment>) : FragmentStateAdapter(fm,lifecycle){
    override fun getItemCount(): Int {
        return fragList.size
    }

    override fun createFragment(position: Int): Fragment {
        return fragList[position]
    }
}
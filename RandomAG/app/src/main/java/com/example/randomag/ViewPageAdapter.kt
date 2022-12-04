package com.example.randomag

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class ViewPageAdapter(fragmentActivity: FragmentActivity):
    FragmentStateAdapter(fragmentActivity){
    override fun getItemCount(): Int {
        return 4;
    }

    override fun createFragment(position: Int): Fragment {
       return when(position){
           0->Page1()
           1->Page2()
           2->Page3()
           3->Page4()
           else ->Page1()
       }
    }

}
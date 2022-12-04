package com.example.randomag

import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.preference.PreferenceManager
import kotlinx.android.synthetic.main.fragment_page1.*
import kotlinx.android.synthetic.main.fragment_page2.*
import kotlin.random.Random


class Page2 : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_page2, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val preferences: SharedPreferences =
            PreferenceManager.getDefaultSharedPreferences(requireActivity())
        val gt = preferences.getInt("N", 1);
        if(gt==1){
            kq2.setImageResource(R.drawable.one)
        }else if(gt==2){
            kq2.setImageResource(R.drawable.two)
        }else if(gt==3){
            kq2.setImageResource(R.drawable.three)
        }else if(gt==4){
            kq2.setImageResource(R.drawable.four)
        }else if(gt==5){
            kq2.setImageResource(R.drawable.five)
        }else if(gt==6){
            kq2.setImageResource(R.drawable.six)
        }
        btn_gieo.setOnClickListener {
            var rd = Random
            var so = rd.nextInt(1, 7)
            if(so==1){
                kq2.setImageResource(R.drawable.one)
            }else if(so==2){
                kq2.setImageResource(R.drawable.two)
            }else if(so==3){
                kq2.setImageResource(R.drawable.three)
            }else if(so==4){
                kq2.setImageResource(R.drawable.four)
            }else if(so==5){
                kq2.setImageResource(R.drawable.five)
            }else if(so==6){
                kq2.setImageResource(R.drawable.six)
            }
            val editor = preferences.edit()
            editor.putInt("N", so)
            editor.apply()
            Toast.makeText(context, "Gieo thành công !", Toast.LENGTH_SHORT).show()
        }
    }


}
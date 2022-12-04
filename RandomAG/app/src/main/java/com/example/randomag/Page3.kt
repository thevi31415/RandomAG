package com.example.randomag

import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.preference.PreferenceManager
import kotlinx.android.synthetic.main.fragment_page3.*


class Page3 : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_page3, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
         val preferences: SharedPreferences = PreferenceManager.getDefaultSharedPreferences(requireActivity())

        val head = preferences.getInt("head", 0)
        val tail = preferences.getInt("tail",0)
        headtv.setText("Head: " +head.toString())
        Tailtv.setText("Tail: " + tail.toString())
       btn_dongxu.setOnClickListener {
           val rd =(1..2).random()
           val editor = preferences.edit()
           if(rd==1){
               flipTheCoin(R.drawable.head, "Head")
               Toast.makeText(context, "Gieo thành công !", Toast.LENGTH_SHORT).show()
               var N = preferences.getInt("head", 0);
               editor.putInt("head", N+1)
               editor.apply()
               headtv.setText("Head: " + preferences.getInt("head", 0).toString())

           }else{
               flipTheCoin(R.drawable.tail, "tail")
               Toast.makeText(context, "Gieo thành công !", Toast.LENGTH_SHORT).show()
               editor.putInt("tail", preferences.getInt("tail", 0)+1)
               editor.apply()
               Tailtv.setText("Tail: " + preferences.getInt("tail", 0).toString())
           }



       }

        Reset.setOnClickListener {
            val editor = preferences.edit()
            editor.putInt("head", 0)
            editor.putInt("tail", 0)
            editor.apply()
            headtv.setText("Head: " + preferences.getInt("head", 0).toString())
            Tailtv.setText("Tail: " + preferences.getInt("tail", 0).toString())
        }

    }

    private fun flipTheCoin(imageId: Int, coinSide: String){
       imagecoin.animate().apply {
           duration =1000
           rotationYBy(1800f)
           imagecoin.isClickable =false

       }.withEndAction {
           imagecoin.setImageResource(imageId)
           imagecoin.isClickable =true
       }.start()
    }


}
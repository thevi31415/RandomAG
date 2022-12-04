package com.example.randomag

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Intent
import android.content.SharedPreferences
import android.graphics.Color
import android.net.Uri
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.content.ContextCompat.getSystemService
import androidx.fragment.app.Fragment
import androidx.preference.PreferenceManager
import kotlinx.android.synthetic.main.fragment_page1.*
import kotlin.random.Random


class Page1 : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater?.inflate(R.layout.fragment_page1, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val preferences: SharedPreferences =
            PreferenceManager.getDefaultSharedPreferences(requireActivity())
        /*  val eidt_min = preferences.edit()
           eidt_min.putString("min", "VALUE")
           eidt_min.apply()*/
        val min = preferences.getString("MIN", "").toString()
        val max = preferences.getString("MAX", "")
        val solan = preferences.getString("SOLAN", "")
        val text = preferences.getString("ND", "0")
        edit_min.setText(min)
        edit_max.setText(max)
        edit_solangieo.setText(solan)
        kq1.text = text
        edit_min.addTextChangedListener(
            object : TextWatcher {

                override fun afterTextChanged(s: Editable) {
                    text_min.setTextColor(Color.parseColor("#FF4DED6C"))
                }

                override fun beforeTextChanged(
                    s: CharSequence, start: Int,
                    count: Int, after: Int
                ) {
                    text_min.setTextColor(Color.parseColor("#FF4DED6C"))
                }

                override fun onTextChanged(
                    s: CharSequence, start: Int,
                    before: Int, count: Int
                ) {
                    text_min.setTextColor(Color.parseColor("#FF4CAF50"))
                }

            }
        )
        button1.setOnClickListener {

            /*  var min = edit_min.text.toString().toInt()
              var max = edit_max.text.toString().toInt()
              var solan = edit_solangieo.text.toString().toInt()*/
            if (edit_min.text.toString() == "" || edit_max.text.toString() == "" || edit_solangieo.text.toString() == "") {
                Toast.makeText(context, "Bạn chưa nhập đầy đủ !", Toast.LENGTH_SHORT).show()
            } else {
                var min = edit_min.text.toString().toInt()
                var max = edit_max.text.toString().toInt()
                var solan = edit_solangieo.text.toString().toInt()
                if (min > max) {
                    Toast.makeText(context, "Min phải nhỏ hơn max!", Toast.LENGTH_SHORT).show()
                } else {
                    var rd = Random
                    var so = rd.nextInt(min, max + 1)
                    var S: String = ""
                    for (i in 1..solan)
                    {
                        var s = rd.nextInt(min, max + 1).toString()
                        if (i == 1) {
                            S = s

                        } else{
                            if(i!=solan){
                                S=S + ", " +  s
                            }else{
                                if(i==solan){
                                    S=S + ", " + s
                                }
                            }
                        }

                    }
                    S = S + "\n" + "\n"
                    kq1.setText(S.toString())
                    Toast.makeText(context, "Đã tạo thành công !", Toast.LENGTH_SHORT).show()
                    val editor = preferences.edit()
                    editor.putString("MIN", edit_min.text.toString())
                    editor.putString("MAX", edit_max.text.toString())
                    editor.putString("SOLAN", edit_solangieo.text.toString())
                    editor.putString("ND", kq1.text.toString())
                    editor.apply()

                }

            }

            /*    if(min > max){
                    Toast.makeText(context, "Bạn đã nhập sai vui lòng nhập lại !", Toast.LENGTH_SHORT).show()
                }*/

        }
        btn_copy.setOnClickListener {
            var myClipboard =
                getSystemService(requireContext(), ClipboardManager::class.java) as ClipboardManager
            val clip: ClipData = ClipData.newPlainText("simple text", kq1.text.toString())

            myClipboard.setPrimaryClip(clip)
            Toast.makeText(context, "Copy thành công !", Toast.LENGTH_SHORT).show()
        }


    }


}
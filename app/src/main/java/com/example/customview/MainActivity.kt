package com.example.customview

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.EditText
import com.example.customview.databinding.ActivityMainBinding
import kotlin.math.log


class MainActivity : AppCompatActivity() {

    lateinit var edtText: EditText
    lateinit var binding: ActivityMainBinding
    lateinit var selectedColor: ColorObject
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        edtText = findViewById(R.id.edt_text_color)
        loadColorSpinner()
    }

    private fun loadColorSpinner() {
        selectedColor = ColorList().defaultColor

        binding.colorSpinner.apply {
            adapter = ColorSpinnerAdapter(applicationContext, ColorList().basicColors())
            setSelection(ColorList().colorPosition(selectedColor), false)
            onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
                override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                    selectedColor = ColorList().basicColors()[p2]
                    edtText.setTextColor(Color.parseColor(ColorList().basicColors()[p2].hexHash))
                }

                override fun onNothingSelected(p0: AdapterView<*>?) {
                }
            }
        }
    }
}
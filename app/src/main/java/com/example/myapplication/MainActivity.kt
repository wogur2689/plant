package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button1.setOnClickListener(View.OnClickListener {
            Toast.makeText(
                this,
                "로그인화면",
                Toast.LENGTH_LONG
            ).show()
        })
        binding.button2.setOnClickListener(View.OnClickListener {
            Toast.makeText(
                this,
                "검색",
                Toast.LENGTH_LONG
            ).show()
        })
        binding.button3.setOnClickListener(View.OnClickListener {
            Toast.makeText(
                this,
                "오늘의 식물 추천!",
                Toast.LENGTH_LONG
            ).show()
        })
        binding.button4.setOnClickListener(View.OnClickListener {
            Toast.makeText(
                this,
                "오늘의 날씨!",
                Toast.LENGTH_LONG
            ).show()
        })
    }

}
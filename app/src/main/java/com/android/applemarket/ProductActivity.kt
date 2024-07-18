package com.android.applemarket

import android.content.ClipData.Item
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.Paint
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.android.applemarket.databinding.ActivityProductBinding

class ProductActivity : AppCompatActivity() {
    private lateinit var binding : ActivityProductBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityProductBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding.tvManner.paintFlags = Paint.UNDERLINE_TEXT_FLAG

        binding.ivBack.setOnClickListener {
            finish()
        }

        var test = intent.getParcelableExtra<MyItem>("item")
        test?.let { binding.ivImage.setImageResource(it.image) }
        binding.tvSeller.text = test?.seller
        binding.tvLocation.text = test?.location
        binding.tvName.text = test?.name
        binding.tvDetail.text = test?.detail
        binding.tvMoney2.text = test?.money

    }
}
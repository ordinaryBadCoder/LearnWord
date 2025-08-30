package com.example.firstapp

import android.content.Intent
import android.os.Build
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.firstapp.databinding.ActivityFirstDemoBinding
import com.example.firstapp.databinding.ActivitySecondDemoBinding



class SecondDemoActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySecondDemoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivitySecondDemoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnBack.setOnClickListener {
            val intent = Intent(this@SecondDemoActivity, FirstDemoActivity::class.java)
            startActivity(intent)
        }

        val word: ExtraWord = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            intent.getSerializableExtra("EXTRA_KEY_WORD", ExtraWord::class.java) as ExtraWord
        } else {
            intent.getSerializableExtra("EXTRA_KEY_WORD") as ExtraWord
        }

        binding.tvKeyText.text = word.original

    }

}
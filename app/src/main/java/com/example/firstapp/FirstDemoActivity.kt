package com.example.firstapp

import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.firstapp.databinding.ActivityFirstDemoBinding
import java.io.Serializable


class FirstDemoActivity: AppCompatActivity() {

    private lateinit var binding: ActivityFirstDemoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityFirstDemoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val word = ExtraWord(
            "galaxy",
            "галактика",
        )

        binding.btnNext.setOnClickListener {

            val intent = Intent(this@FirstDemoActivity, SecondDemoActivity::class.java)
            intent.putExtra("EXTRA_KEY_TEXT","hello!")
            intent.putExtra("EXTRA_KEY_NUMBER", 43)

            intent.putExtra("EXTRA_KEY_WORD", word)

            startActivity(intent)
        }



    }
}
data class ExtraWord (
    val original: String,
    val translate: String,
    var learned: Boolean = false,
): Serializable
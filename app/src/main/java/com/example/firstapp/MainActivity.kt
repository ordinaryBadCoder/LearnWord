package com.example.firstapp

import android.graphics.Color
import android.os.Bundle
import android.widget.LinearLayout
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.isVisible
import com.example.firstapp.databinding.ActivityLearnWordBinding
import com.example.firstapp.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private var _binding: ActivityLearnWordBinding? = null
    private val binding
        get() = _binding ?: throw IllegalStateException("Binding for ActivityLearnWordBinding must not be null")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        _binding = ActivityLearnWordBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //Нажатие на корректный ответ
        binding.layoutAnswer3.setOnClickListener {
            markAnswerCorrect(
                binding.layoutAnswer3,
                binding.tvVariantNumber3,
                binding.tvVariantValue3
            )
        }

        //Нажатие на некорректный ответ
        binding.layoutAnswer1.setOnClickListener {
            markAnswerWrong(
                binding.layoutAnswer1,
                binding.tvVariantNumber1,
                binding.tvVariantValue1
            )
        }

        //Нейтральный
        binding.btnContinue.setOnClickListener {
            markAnswerNeutral(
                binding.layoutAnswer3,
                binding.tvVariantNumber3,
                binding.tvVariantValue3
            )
            markAnswerNeutral(
                binding.layoutAnswer1,
                binding.tvVariantNumber1,
                binding.tvVariantValue1
            )
        }
    }

    //Нейтральный
    private fun markAnswerNeutral(
        layoutAnswer: LinearLayout,
        tvVariantNumber: TextView,
        tvVariantValue: TextView,
    ) {
        layoutAnswer.background = ContextCompat.getDrawable(
                this@MainActivity,
                R.drawable.shape_rounded_containers
                )

        tvVariantNumber.setTextColor(
            ContextCompat.getColor(
                this@MainActivity,
                R.color.textVariantsColor
            )
        )

        //Замена нескольких характеристик объекта через apply
        tvVariantValue.apply{
            background = ContextCompat.getDrawable(
                this@MainActivity,
                R.drawable.shape_rounded_variants
            )
            setTextColor(ContextCompat.getColor(
                this@MainActivity,
                R.color.textVariantsColor
            ))
        }

    }

    //Некорректный ответ
    private fun markAnswerWrong(
        layoutAnswer: LinearLayout,
        tvVariantNumber: TextView,
        tvVariantValue: TextView,
    ) {



        //Новая обводка для контейнера
        layoutAnswer.background = ContextCompat.getDrawable(
            this@MainActivity,
            R.drawable.shape_rounded_containers_wrong
        )
        //Новый фон для цифры
        tvVariantNumber.background = ContextCompat.getDrawable(
            this@MainActivity,
            R.drawable.shape_rounded_variants_wrong
        )
        //Новый цвет для цифры
        tvVariantNumber.setTextColor(
            ContextCompat.getColor(
                this@MainActivity,
                R.color.white
            )
        )
        //Новый цвет для ответа
        tvVariantValue.setTextColor(
            ContextCompat.getColor(
                this@MainActivity,
                R.color.wrongAnswerColor
            )
        )

        binding.btnSkip.isVisible = false;

        //Фон не правильного ответа
        binding.layoutResult.setBackgroundColor(
            ContextCompat.getColor(
                this@MainActivity,
                R.color.wrongAnswerColor
            )
        )
        //Иконка не правильного ответа
        binding.ivResultIcon.setImageDrawable(
            ContextCompat.getDrawable(
                this@MainActivity,
                R.drawable.ic_wrong
            )
        )
        //Текст не правильного ответа
        binding.tvResultMessage.text = resources.getString(R.string.wrong_text)
        //Кнопка Продолжить
        binding.btnContinue.setTextColor(
            ContextCompat.getColor(
                this@MainActivity,
                R.color.wrongAnswerColor
            )
        )
        //Отображение панели ответа
        binding.layoutResult.isVisible = true
    }

    // Корректный ответ
    private fun markAnswerCorrect(
        layoutAnswer: LinearLayout,
        tvVariantNumber: TextView,
        tvVariantValue: TextView,
    ) {
        //Новая обводка для контейнера
        layoutAnswer.background = ContextCompat.getDrawable(
            this@MainActivity,
            R.drawable.shape_rounded_containers_correct
        )
        //Новый фон для цифры
        tvVariantNumber.background = ContextCompat.getDrawable(
            this@MainActivity,
            R.drawable.shape_rounded_variants_correct
        )
        //Новый цвет для цифры
        tvVariantNumber.setTextColor(
            ContextCompat.getColor(
                this@MainActivity,
                R.color.white
            )
        )
        //Новый цвет для ответа
        tvVariantValue.setTextColor(
            ContextCompat.getColor(
                this@MainActivity,
                R.color.correctAnswerColor
            )
        )
        binding.btnSkip.isVisible = false;
        //Фон правильного ответа
        binding.layoutResult.setBackgroundColor(
            ContextCompat.getColor(
                this@MainActivity,
                R.color.correctAnswerColor
            )
        )
        //Иконка правильного ответа
        binding.ivResultIcon.setImageDrawable(
            ContextCompat.getDrawable(
                this@MainActivity,
                R.drawable.ic_correct
            )
        )
        //Текст правильного ответа
        binding.tvResultMessage.text = resources.getString(R.string.correct_text)
        //Кнопка Продолжить
        binding.btnContinue.setTextColor(
            ContextCompat.getColor(
                this@MainActivity,
                R.color.correctAnswerColor
            )
        )
        //Отображение панели верного ответа
        binding.layoutResult.isVisible = true
    }
}

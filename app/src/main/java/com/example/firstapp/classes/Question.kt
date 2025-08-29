package com.example.firstapp.classes

data class Question(
    val variants: List<Word>, //список вариантов ответов
    val correctAnswer: Word, // правильный ответ
)

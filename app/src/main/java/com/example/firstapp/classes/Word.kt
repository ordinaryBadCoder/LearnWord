package com.example.firstapp.classes

data class Word (
    val original: String,  //слово с оригинальной формой на английском
    val translate: String, // слово с переводом
    var learned: Boolean = false, // флаг - выучено ли слово
)

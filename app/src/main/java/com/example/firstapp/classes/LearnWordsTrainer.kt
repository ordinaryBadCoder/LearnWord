package com.example.firstapp.classes

import kotlin.random.Random

const val NUMBER_OF_ANSWERS: Int = 4

class LearnWordsTrainer  {
    // список объектов класса Word
    private val dictionary = listOf(
        Word("Artificial Intelligence", "Искуственный интеллект"),
        Word("Blockchain", "Блокчейн"),
        Word("Quantum Computing", "Квантовые вычисления"),
        Word("Cybersecurity", "Кибербезопасность"),
        Word("Augmented Reality", "Дополненная реальность"),
        Word("Cryptocyrrency", "Криптовалюта"),
        Word("Data Analytics","Аналитика данных"),
        Word("Machine Learning", "Машинное обучение"),
        Word("Internet of Things", "Интернет вещей"),
        Word("Cloud Computing","Облачные вычисления"),
        Word("Robotics", "Робототехника"),
        Word("Biotech","Биотехнология"),
        Word("Nanotechnology","Нанотехнология"),
        Word("Digital Transformation","Цифровая трансформация"),
        Word("Cyberattack", "Кибератака"),
        Word("Software Development","Разработка ПО"),
        Word("User Interface","Пользовательский интерфейс"),
        Word("Data encryption", "Шифрование данных"),
        Word("Smart Devices","Умные устройства")
    )

    var currentQuestion: Question? = null // текущий вопрос

    /** Получает следующий вопрос.
     * Возвращает null, если все слова выучены.
     */
    fun getNextQuestion(): Question? {

        //Фильтруем словарь слов, которые еще не были выучены
        val notLeanedList = dictionary.filter {!it.learned}
        //Если все слова выучены - возвращаем null
        if (notLeanedList.isEmpty()) return null

        val questionWords =
            // Если невыученных слов меньше, чем 4, то есть меньше, чем требуется для вопроса
            if (notLeanedList.size < NUMBER_OF_ANSWERS){
                //выбираем слова из списка выученных слов
                val leanedList = dictionary.filter {it.learned}.shuffled()
                notLeanedList.shuffled()
                    .take(NUMBER_OF_ANSWERS) + leanedList
                    .take(NUMBER_OF_ANSWERS - notLeanedList.size)
            } else {
                // выбираем случайные слова из списка невыученных слов
                notLeanedList.shuffled().take(NUMBER_OF_ANSWERS)
            }.shuffled()

        //выбор правильного ответа из списка сформированных слов
        val correctAnswer: Word = questionWords.random()

        // создаем вопрос
        currentQuestion = Question(
            variants = questionWords,
            correctAnswer = correctAnswer
        )

        //возвращаем вопрос
        return currentQuestion
    }

    /** Проверяем ответ пользователя по индексу варианта.
     *  Возвращает true, если ответ правильный, иначе false.
     */
    fun checkAnswer(userAnswerIndex: Int): Boolean {

        return currentQuestion?.let {

            val correctAnswerId = it.variants.indexOf(it.correctAnswer)
            // если ответ пользователя совпадает с верным ответом
            if (correctAnswerId == userAnswerIndex) {
                it.correctAnswer.learned = true // слово помечается как выученное
                true // возвращаем true
            } else { // если ответ не верен
                false // возвращаем false
            }
        } ?: false
    }

}
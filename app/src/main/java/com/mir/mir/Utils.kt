package com.mir.mir
data class Option(
    val key: String,
    val label: String,
    val options: List<String>
)

val options1 = listOf(
    Option(
        key = "goal",
        label = "Я ищу",
        options = listOf(
            "Серьезные отношения",
            "Флирт",
            "Дружба",
            "На одну ночь"
        )
    ),
    Option(
        key = "alcohol",
        label = "Отношение к алкоголю",
        options = listOf(
            "Пью часто",
            "Иногда выпиваю",
            "Не пью",
            "Негативно"
        )
    ),
    Option(
        key = "smoking",
        label = "Отношение к курению",
        options = listOf(
            "Курю",
            "Нормально",
            "Негативно"
        )
    ),
    Option(
        key = "sport",
        label = "Как часто занимаешься спортом",
        options = listOf(
            "Часто занимаюсь",
            "Иногда занимаюсь",
            "Не занимаюсь",
            "Не люблю спорт"
        )
    )
)

val options2 = listOf(
    Option(
        key = "education",
        label = "Образование",
        options = listOf(
            "Высшее",
            "Среднее профессиональное",
            "Основное общее",
            "Незаконченное высшее"
        )
    ),
    Option(
        key = "zodiac",
        label = "Знак зодиака",
        options = listOf(
            "Овен",
            "Телец",
            "Близнецы",
            "Рак",
            "Лев",
            "Дева",
            "Весы",
            "Скорпион",
            "Стрелец",
            "Козерог",
            "Водолей",
            "Рыбы"
        )
    ),
    Option(
        key = "type",
        label = "По типажу я",
        options = listOf(
            "Экстраверт",
            "Интроверт",
            "Амбиверт"
        )
    )
)


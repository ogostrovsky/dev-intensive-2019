package ru.skillbranch.devintensive.models

class Bender (var status:Status = Status.NORMAL, var question: Question = Question.NAME){

    fun askQuestion():String = when (question){
        Question.NAME -> Question.NAME.question
        Question.PROFESSION -> Question.PROFESSION.question
        Question.MATERIAL -> Question.MATERIAL.question
        Question.BDAY -> Question.BDAY.question
        Question.SERIAL -> Question.SERIAL.question
        Question.IDLE -> Question.IDLE.question
    }
    var counter = 0

    fun listenAnswer(answer:String) : Pair<String, Triple<Int, Int, Int>>{

        return if(question.answer.contains(answer.toLowerCase())){
            counter = 0
            question = question.nextQuestion()
            "Отлично - ты справился\n${question.question}" to status.color
        } else if ( counter >= 2) {
            counter = 0
            status = Status.NORMAL
            question = Question.NAME
            "Это неправильный ответ. Давай все по новой\n${question.question}" to status.color
        } else {
            counter++
            status = status.nextStatus()
            "Это неправильный ответ\n${question.question}" to status.color
        }
    }

    enum class Status(val color:Triple<Int, Int, Int>){
        NORMAL (Triple(255,255,255)),
        WARNING (Triple(255,120,0)),
        DANGER (Triple(255,60,60)),
        CRITICAL (Triple(255,0,0));

         fun nextStatus():Status{
             return if(this.ordinal < values().lastIndex){
                 values()[this.ordinal +1]
             } else values()[0]
        }
    }

    enum class Question(val question:String, val answer:List<String>) {
        NAME("Как меня зовут?", listOf("бендер","bender")){
            override fun nextQuestion(): Question = PROFESSION
        },
        PROFESSION("Назови мою профессию?", listOf("сгибальщик","bender")){
            override fun nextQuestion(): Question = MATERIAL
        },
        MATERIAL("Из чего я сделан?", listOf("iron","metal","wood","дерево","металл")){
            override fun nextQuestion(): Question = BDAY
        },
        BDAY("Когда меня создали?", listOf("2993")){
            override fun nextQuestion(): Question = SERIAL
        },
        SERIAL("Мой серийный номер?", listOf("2716057")){
            override fun nextQuestion(): Question = IDLE
        },
        IDLE("На этом все, вопросов больше нет", listOf()){
            override fun nextQuestion(): Question = IDLE
        };
        abstract fun nextQuestion():Question
    }
}
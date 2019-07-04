package ru.skillbranch.devintensive.utils

object Utils {
    fun parseFullName(fullName:String?):Pair<String?, String?>{
        val parts: List<String>? = fullName?.split(" ")

        val firstName = parts?.getOrNull(0)
        val lastName = parts?.getOrNull(1)
        return when (fullName){
            "" -> Pair(null,null)
            " " -> Pair(null,null)
            else -> firstName to lastName

        }
    }

    fun toInitials(firstName: String?, lastName: String?):String? {
        var first: String? = firstName?.toUpperCase()
        var last: String? = lastName?.toUpperCase()
        var f: Char?
        var l: Char?
        if (last != "" && last != " " && last !=null && first != "" && first != " "){
            f = first?.get(0)
            l = last?.get(0)
            return "$f$l" }
            else if (first != "" && first !=" "){
            f = first?.get(0)
            return "$f"}
            else return null
        }

    fun transliteration(payload:String, divider:String = " "):String{

        var fullname= parseFullName(payload)

        // разбиваю полное имя на имя и фамилию и перевожу в нижний регистр
        var name1 = fullname.first
        var name2 = fullname.second
        name1 = name1?.toLowerCase()
        name2 = name2?.toLowerCase()
        // разбиваю имя и фамилию на отдельные карактеры
        var name1array:CharArray? = name1?.toCharArray()
        var name2array:CharArray? = name2?.toCharArray()

        //
        var lenght:Int? = name1array?.size
        var counter:Int = 0

        // транслитерирую имя
        name1 = ""
        while (counter != lenght){
            when (name1array?.get(counter)){
                                      'а' -> name1 += "a"
                                      'б' -> name1 += "b"
                                      'в' -> name1 += "v"
                                      'г' -> name1 += "g"
                                      'д' -> name1 += "d"
                                      'е' -> name1 += "e"
                                      'ё' -> name1 += "e"
                                      'ж' -> name1 += "zh"
                                      'з' -> name1 += "z"
                                      'и' -> name1 += "i"
                                      'й' -> name1 += "i"
                                      'к' -> name1 += "k"
                                      'л' -> name1 += "l"
                                      'м' -> name1 += "m"
                                      'н' -> name1 += "n"
                                      'о' -> name1 += "o"
                                      'п' -> name1 += "p"
                                      'р' -> name1 += "r"
                                      'с' -> name1 += "s"
                                      'т' -> name1 += "t"
                                      'у' -> name1 += "u"
                                      'ф' -> name1 += "f"
                                      'х' -> name1 += "h"
                                      'ц' -> name1 += "c"
                                      'ч' -> name1 += "ch"
                                      'ш' -> name1 += "sh"
                                      'щ' -> name1 += "sh"
                                      'ъ' -> name1 += ""
                                      'ы' -> name1 += "i"
                                      'ь' -> name1 += ""
                                      'э' -> name1 += "e"
                                      'ю' -> name1 += "yu"
                                      'я' -> name1 += "ya"

                                            'a' -> name1 += 'a'
                                            'b' -> name1 += 'b'
                                            'c' -> name1 += 'c'
                                            'd' -> name1 += 'd'
                                            'e' -> name1 += 'e'
                                            'f' -> name1 += 'f'
                                            'g' -> name1 += 'g'
                                            'h' -> name1 += 'h'
                                            'i' -> name1 += 'i'
                                            'j' -> name1 += 'j'
                                            'k' -> name1 += 'k'
                                            'l' -> name1 += 'l'
                                            'm' -> name1 += 'm'
                                            'n' -> name1 += 'n'
                                            'o' -> name1 += 'o'
                                            'p' -> name1 += 'p'
                                            'q' -> name1 += 'q'
                                            'r' -> name1 += 'r'
                                            's' -> name1 += 's'
                                            't' -> name1 += 't'
                                            'u' -> name1 += 'u'
                                            'v' -> name1 += 'v'
                                            'w' -> name1 += 'w'
                                            'x' -> name1 += 'x'
                                            'y' -> name1 += 'y'
                                            'z' -> name1 += 'z'
            }
            counter++
        }
        // транслитерирую фамилию
        name2 = ""
        counter = 0
        lenght = name2array?.size
        while (counter != lenght){
            when (name2array?.get(counter)){
                                      'а' -> name2 += "a"
                                      'б' -> name2 += "b"
                                      'в' -> name2 += "v"
                                      'г' -> name2 += "g"
                                      'д' -> name2 += "d"
                                      'е' -> name2 += "e"
                                      'ё' -> name2 += "e"
                                      'ж' -> name2 += "zh"
                                      'з' -> name2 += "z"
                                      'и' -> name2 += "i"
                                      'й' -> name2 += "i"
                                      'к' -> name2 += "k"
                                      'л' -> name2 += "l"
                                      'м' -> name2 += "m"
                                      'н' -> name2 += "n"
                                      'о' -> name2 += "o"
                                      'п' -> name2 += "p"
                                      'р' -> name2 += "r"
                                      'с' -> name2 += "s"
                                      'т' -> name2 += "t"
                                      'у' -> name2 += "u"
                                      'ф' -> name2 += "f"
                                      'х' -> name2 += "h"
                                      'ц' -> name2 += "c"
                                      'ч' -> name2 += "ch"
                                      'ш' -> name2 += "sh"
                                      'щ' -> name2 += "sh"
                                      'ъ' -> name2 += ""
                                      'ы' -> name2 += "i"
                                      'ь' -> name2 += ""
                                      'э' -> name2 += "e"
                                      'ю' -> name2 += "yu"
                                      'я' -> name2 += "ya"
                                            'a' -> name2 += 'a'
                                            'b' -> name2 += 'b'
                                            'c' -> name2 += 'c'
                                            'd' -> name2 += 'd'
                                            'e' -> name2 += 'e'
                                            'f' -> name2 += 'f'
                                            'g' -> name2 += 'g'
                                            'h' -> name2 += 'h'
                                            'i' -> name2 += 'i'
                                            'j' -> name2 += 'j'
                                            'k' -> name2 += 'k'
                                            'l' -> name2 += 'l'
                                            'm' -> name2 += 'm'
                                            'n' -> name2 += 'n'
                                            'o' -> name2 += 'o'
                                            'p' -> name2 += 'p'
                                            'q' -> name2 += 'q'
                                            'r' -> name2 += 'r'
                                            's' -> name2 += 's'
                                            't' -> name2 += 't'
                                            'u' -> name2 += 'u'
                                            'v' -> name2 += 'v'
                                            'w' -> name2 += 'w'
                                            'x' -> name2 += 'x'
                                            'y' -> name2 += 'y'
                                            'z' -> name2 += 'z'}
            counter++
            }
        name1 = name1.capitalize()
        name2 = name2.capitalize()

        return "$name1$divider$name2"
        }
}
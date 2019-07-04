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
        val first: String? = firstName?.toUpperCase()
        val last: String? = lastName?.toUpperCase()
        val f:Char?
        val l:Char?
        // if both have values
        if (last != "" && last != " " && last !=null && first != "" && first != " " && first !=null){
            f = first.get(0)
            l = last.get(0)
            return "$f$l" }
        // only first has a value
        else if (first != "" && first !=" " && first !=null){
            f = first.get(0)
            return "$f"}
        // only last has a value
        else if (last != "" && last !=" " && last !=null){
            l = last.get(0)
            return "$l"}
        else return null
    }

    fun transliteration(payload:String, divider:String? = " "):String?{

        val fullname= parseFullName(payload)

        // разбиваю полное имя на имя и фамилию и перевожу в нижний регистр
        var name1 = fullname.first
        var name2 = fullname.second
        // разбиваю имя и фамилию на отдельные карактеры
        val name1array:CharArray? = name1?.toCharArray()
        val name2array:CharArray? = name2?.toCharArray()

        //
        var lenght:Int? = name1array?.size
        var counter = 0
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
                'щ' -> name1 += "sh'"
                'ъ' -> name1 += ""
                'ы' -> name1 += "i"
                'ь' -> name1 += ""
                'э' -> name1 += "e"
                'ю' -> name1 += "yu"
                'я' -> name1 += "ya"

                'А' -> name1 += "A"
                'Б' -> name1 += "B"
                'В' -> name1 += "V"
                'Г' -> name1 += "G"
                'Д' -> name1 += "D"
                'Е' -> name1 += "E"
                'Ё' -> name1 += "E"
                'Ж' -> name1 += "Zh"
                'З' -> name1 += "Z"
                'И' -> name1 += "I"
                'Й' -> name1 += "I"
                'К' -> name1 += "K"
                'Л' -> name1 += "L"
                'М' -> name1 += "M"
                'Н' -> name1 += "N"
                'О' -> name1 += "O"
                'П' -> name1 += "P"
                'Р' -> name1 += "R"
                'С' -> name1 += "S"
                'Т' -> name1 += "T"
                'У' -> name1 += "U"
                'Ф' -> name1 += "F"
                'Х' -> name1 += "H"
                'Ц' -> name1 += "C"
                'Ч' -> name1 += "Ch"
                'Ш' -> name1 += "Sh"
                'Щ' -> name1 += "Sh'"
                'Ъ' -> name1 += ""
                'Ы' -> name1 += "I"
                'Ь' -> name1 += ""
                'Э' -> name1 += "E"
                'Ю' -> name1 += "Yu"
                'Я' -> name1 += "Ya"

                'a' -> name1 += "a"
                'b' -> name1 += "b"
                'c' -> name1 += "c"
                'd' -> name1 += "d"
                'e' -> name1 += "e"
                'f' -> name1 += "f"
                'g' -> name1 += "g"
                'h' -> name1 += "h"
                'i' -> name1 += "i"
                'j' -> name1 += "j"
                'k' -> name1 += "k"
                'l' -> name1 += "l"
                'm' -> name1 += "m"
                'n' -> name1 += "n"
                'o' -> name1 += "o"
                'p' -> name1 += "p"
                'q' -> name1 += "q"
                'r' -> name1 += "r"
                's' -> name1 += "s"
                't' -> name1 += "t"
                'u' -> name1 += "u"
                'v' -> name1 += "v"
                'w' -> name1 += "w"
                'x' -> name1 += "x"
                'y' -> name1 += "y"
                'z' -> name1 += "z"

                'A' -> name1 += "A"
                'B' -> name1 += "B"
                'C' -> name1 += "C"
                'D' -> name1 += "D"
                'E' -> name1 += "E"
                'F' -> name1 += "F"
                'G' -> name1 += "G"
                'H' -> name1 += "H"
                'I' -> name1 += "I"
                'J' -> name1 += "J"
                'K' -> name1 += "K"
                'L' -> name1 += "L"
                'M' -> name1 += "M"
                'N' -> name1 += "N"
                'O' -> name1 += "O"
                'P' -> name1 += "P"
                'Q' -> name1 += "Q"
                'R' -> name1 += "R"
                'S' -> name1 += "S"
                'T' -> name1 += "T"
                'U' -> name1 += "U"
                'V' -> name1 += "V"
                'W' -> name1 += "W"
                'X' -> name1 += "X"
                'Y' -> name1 += "Y"
                'Z' -> name1 += "Z"
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
                'щ' -> name2 += "sh'"
                'ъ' -> name2 += ""
                'ы' -> name2 += "i"
                'ь' -> name2 += ""
                'э' -> name2 += "e"
                'ю' -> name2 += "yu"
                'я' -> name2 += "ya"

                'А' -> name2 += "A"
                'Б' -> name2 += "B"
                'В' -> name2 += "V"
                'Г' -> name2 += "G"
                'Д' -> name2 += "D"
                'Е' -> name2 += "E"
                'Ё' -> name2 += "E"
                'Ж' -> name2 += "Zh"
                'З' -> name2 += "Z"
                'И' -> name2 += "I"
                'Й' -> name2 += "I"
                'К' -> name2 += "K"
                'Л' -> name2 += "L"
                'М' -> name2 += "M"
                'Н' -> name2 += "N"
                'О' -> name2 += "O"
                'П' -> name2 += "P"
                'Р' -> name2 += "R"
                'С' -> name2 += "S"
                'Т' -> name2 += "T"
                'У' -> name2 += "U"
                'Ф' -> name2 += "F"
                'Х' -> name2 += "H"
                'Ц' -> name2 += "C"
                'Ч' -> name2 += "Ch"
                'Ш' -> name2 += "Sh"
                'Щ' -> name2 += "Sh'"
                'Ъ' -> name2 += ""
                'Ы' -> name2 += "I"
                'Ь' -> name2 += ""
                'Э' -> name2 += "E"
                'Ю' -> name2 += "Yu"
                'Я' -> name2 += "Ya"

                'a' -> name2 += "a"
                'b' -> name2 += "b"
                'c' -> name2 += "c"
                'd' -> name2 += "d"
                'e' -> name2 += "e"
                'f' -> name2 += "f"
                'g' -> name2 += "g"
                'h' -> name2 += "h"
                'i' -> name2 += "i"
                'j' -> name2 += "j"
                'k' -> name2 += "k"
                'l' -> name2 += "l"
                'm' -> name2 += "m"
                'n' -> name2 += "n"
                'o' -> name2 += "o"
                'p' -> name2 += "p"
                'q' -> name2 += "q"
                'r' -> name2 += "r"
                's' -> name2 += "s"
                't' -> name2 += "t"
                'u' -> name2 += "u"
                'v' -> name2 += "v"
                'w' -> name2 += "w"
                'x' -> name2 += "x"
                'y' -> name2 += "y"
                'z' -> name2 += "z"

                'A' -> name2 += "A"
                'B' -> name2 += "B"
                'C' -> name2 += "C"
                'D' -> name2 += "D"
                'E' -> name2 += "E"
                'F' -> name2 += "F"
                'G' -> name2 += "G"
                'H' -> name2 += "H"
                'I' -> name2 += "I"
                'J' -> name2 += "J"
                'K' -> name2 += "K"
                'L' -> name2 += "L"
                'M' -> name2 += "M"
                'N' -> name2 += "N"
                'O' -> name2 += "O"
                'P' -> name2 += "P"
                'Q' -> name2 += "Q"
                'R' -> name2 += "R"
                'S' -> name2 += "S"
                'T' -> name2 += "T"
                'U' -> name2 += "U"
                'V' -> name2 += "V"
                'W' -> name2 += "W"
                'X' -> name2 += "X"
                'Y' -> name2 += "Y"
                'Z' -> name2 += "Z"
            }
            counter++
        }
        return "$name1$divider$name2"
    }
}


package ru.skillbranch.devintensive.utils

import android.os.Build
import androidx.annotation.RequiresApi

object Utils {
    fun parseFullName(fullName: String?): Pair<String?, String?> {
        var FullName = fullName?.trim()
        FullName = FullName?.replace("\\s+".toRegex(), " ")
        val parts: List<String>? = FullName?.split(" ")
        val firstName = parts?.getOrNull(0)
        val lastName = parts?.getOrNull(1)
        return when (fullName) {
            "" -> Pair(null, null)
            " " -> Pair(null, null)
            else -> firstName to lastName

        }
    }

    fun toInitials(firstName: String?, lastName: String?): String? {
        val first: String? = firstName?.toUpperCase()
        val last: String? = lastName?.toUpperCase()
        val f: Char?
        val l: Char?
        // if both have values
        if (last != "" && last != " " && last != null && first != "" && first != " " && first != null) {
            f = first.get(0)
            l = last.get(0)
            return "$f$l"
        }
        // only first has a value
        else if (first != "" && first != " " && first != null) {
            f = first.get(0)
            return "$f"
        }
        // only last has a value
        else if (last != "" && last != " " && last != null) {
            l = last.get(0)
            return "$l"
        } else return null
    }






    @RequiresApi(Build.VERSION_CODES.N)
    fun transliteration(payload: String?, divider: String = " "): String? {

        // делим на имя и фам обрезаем бока
        var Payload = payload?.trim()
        Payload = Payload?.replace("\\s+".toRegex(),replacement = divider)

        var counter = 0
        var size = Payload?.length
        var result:String =""
        while(counter < size!!){
            result += makedick(Payload!!.get(counter))
            counter++}

        return result

    }

    @RequiresApi(Build.VERSION_CODES.N)
    fun makedick(key:Char):String{
        val dict = HashMap<Char, String>()
        dict.put ('а', "a")
        dict.put ('б', "b")
        dict.put ('в', "v")
        dict.put ('г', "g")
        dict.put ('д', "d")
        dict.put ('е', "e")
        dict.put ('ё', "e")
        dict.put ('ж', "zh")
        dict.put ('з', "z")
        dict.put ('и', "i")
        dict.put ('й', "i")
        dict.put ('к', "k")
        dict.put ('л', "l")
        dict.put ('м', "m")
        dict.put ('н', "n")
        dict.put ('о', "o")
        dict.put ('п', "p")
        dict.put ('р', "r")
        dict.put ('с', "s")
        dict.put ('т', "t")
        dict.put ('у', "u")
        dict.put ('ф', "f")
        dict.put ('х', "h")
        dict.put ('ц', "c")
        dict.put ('ч', "ch")
        dict.put ('ш', "sh")
        dict.put ('щ', "sh'")
        dict.put ('ъ', "")
        dict.put ('ы', "i")
        dict.put ('ь', "")
        dict.put ('э', "e")
        dict.put ('ю', "yu")
        dict.put ('я', "ya")
        dict.put ('А', "A")
        dict.put ('Б', "B")
        dict.put ('В', "V")
        dict.put ('Г', "G")
        dict.put ('Д', "D")
        dict.put ('Е', "E")
        dict.put ('Ё', "E")
        dict.put ('Ж', "Zh")
        dict.put ('З', "Z")
        dict.put ('И', "I")
        dict.put ('Й', "I")
        dict.put ('К', "K")
        dict.put ('Л', "L")
        dict.put ('М', "M")
        dict.put ('Н', "N")
        dict.put ('О', "O")
        dict.put ('П', "P")
        dict.put ('Р', "R")
        dict.put ('С', "S")
        dict.put ('Т', "T")
        dict.put ('У', "U")
        dict.put ('Ф', "F")
        dict.put ('Х', "H")
        dict.put ('Ц', "C")
        dict.put ('Ч', "Ch")
        dict.put ('Ш', "Sh")
        dict.put ('Щ', "Sh'")
        dict.put ('Ъ', "")
        dict.put ('Ы', "I")
        dict.put ('Ь', "")
        dict.put ('Э', "E")
        dict.put ('Ю', "Yu")
        dict.put ('Я', "Ya")


        val value = dict.getOrDefault(key = key,defaultValue = key.toString())
        return value
    }
}



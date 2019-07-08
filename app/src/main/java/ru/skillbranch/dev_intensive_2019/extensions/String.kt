package ru.skillbranch.dev_intensive_2019.extensions

fun String.truncate(droper:Int = 16):String{
    if(this.trim().length > droper) return this.trim().dropLast(this.trim().length-droper).trim()+"..."; return this.trim()
}

fun String.stripHtml():String {
    var x = this.replace(Regex("<.*?>" ), " ")
    x = x.replace(Regex("&.*?;"), "")
    x = x.replace(Regex("\\s+"), " ")
    return x.trim()
}

open class Taro {
    fun enjoyWithAllClassmate() {
        print("enjoy with all classmates")
    }
}

// 継承を利用したAdaptorパターン
class NewTaro: Taro(), Chairperson {
    override fun organizeClass() {
        enjoyWithAllClassmate()
    }
}

// 移譲を利用したAdaptorパターン
class Hanako(private val taro: Taro): Chairperson {
    override fun organizeClass() {
        taro.enjoyWithAllClassmate()
    }
}

interface Chairperson {
    fun organizeClass()
}

fun main(args: Array<String>) {
//    val chairperson = NewTaro()
//    chairperson.organizeClass()
    val chairperson = Hanako(Taro())
    chairperson.organizeClass()
}


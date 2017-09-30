interface Icecream {
    val name: String
    val howSweet: String
}

class VanillaIcecream(): Icecream {
    override val name = "バニラアイスクリーム"
    override val howSweet = "バニラ味"
}

class GreenTeaIcecream(): Icecream {
    override val name = "抹茶アイスクリーム"
    override val howSweet = "抹茶味"
}

class CashewNutsIcecream(private val icecream: Icecream): Icecream {
    override val name: String
        get() = "カシューナッツ ${icecream.name}"
    override val howSweet: String
        get() = icecream.howSweet
}

fun main(args: Array<String>) {
    val ice1 = CashewNutsIcecream(VanillaIcecream())
    val ice2 = CashewNutsIcecream(GreenTeaIcecream())

    println("${ice1.name} ${ice1.howSweet}")
    println("${ice2.name} ${ice2.howSweet}")
}
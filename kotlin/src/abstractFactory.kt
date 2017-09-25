interface Soup
interface Protein
interface Vegetable

class MizutakiSoup: Soup {}
class Chicken: Protein {}
class Mizuna: Vegetable {}

class SukiyakiSoup: Soup {}
class Beaf: Protein {}
class Hakusai: Vegetable {}

abstract class Factory {
    abstract val soup: Soup
    abstract val protein: Protein
    abstract val vegetable: Vegetable
}

enum class HotPotType {
    Mizutaki, Sukiyaki
}


class MizutakiFactory: Factory() {
    override val soup: MizutakiSoup
        get() = MizutakiSoup()
    override val protein: Chicken
        get() = Chicken()
    override val vegetable: Mizuna
        get() = Mizuna()
}

class SukiyakiFactory: Factory() {
    override val soup: SukiyakiSoup
        get() = SukiyakiSoup()
    override val protein: Beaf
        get() = Beaf()
    override val vegetable: Hakusai
        get() = Hakusai()
}

class HotPot {
    lateinit var soup: Soup
    lateinit var protein: Protein
    lateinit var vegetable: Vegetable
}

fun main(args: Array<String>) {
    fun createFactory(type: HotPotType): Factory {
        return when (type) {
            HotPotType.Mizutaki -> MizutakiFactory()
            HotPotType.Sukiyaki -> SukiyakiFactory()
        }
    }

//    val factory = createFactory(HotPotType.Mizutaki)
    val factory = createFactory(HotPotType.Sukiyaki)
    val hotPot = HotPot().apply {
        soup = factory.soup
        protein = factory.protein
        vegetable = factory.vegetable
    }
    println("soup: ${hotPot.soup}, protein: ${hotPot.protein}, vegetable: ${hotPot.vegetable}")
}
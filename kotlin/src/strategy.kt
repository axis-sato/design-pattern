data class Human(val age: Int, val height: Float, val weight: Float)

interface Comparator {
    fun compare(h1: Human, h2: Human): String
}

class AgeComparator: Comparator {
    override fun compare(h1: Human, h2: Human): String {
        return when {
            h1.age > h2.age -> "h1.age > h2.age"
            h1.age == h2.age -> "h1.age == h2.age"
            else -> "h1.age < h2.age"
        }
    }
}

class HeightComparator: Comparator {
    override fun compare(h1: Human, h2: Human): String {
        return when {
            h1.height > h2.height -> "h1.age > h2.age"
            h1.height == h2.height -> "h1.age == h2.age"
            else -> "h1.age < h2.age"
        }
    }
}

class WeightComparator: Comparator {
    override fun compare(h1: Human, h2: Human): String {
        return when {
            h1.weight > h2.weight -> "h1.age > h2.age"
            h1.weight == h2.weight -> "h1.age == h2.age"
            else -> "h1.age < h2.age"
        }
    }
}

class HumanComparision(private val comparator: Comparator) {
    fun compare(h1: Human, h2: Human): String {
        return comparator.compare(h1, h2)
    }
}

fun main(args: Array<String>) {
    val h1 = Human(25, 175.5F, 70.0F)
    val h2 = Human(26, 176.5F, 76.0F)
    val ageComparision = HumanComparision(AgeComparator())
    println("ageComparision: ${ageComparision.compare(h1, h2)}")
    val heightComparision = HumanComparision(HeightComparator())
    println("heightComparision: ${heightComparision.compare(h1, h2)}")
    val weightComparision = HumanComparision(WeightComparator())
    println("weightComparision: ${weightComparision.compare(h1, h2)}")
}
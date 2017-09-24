interface Cloneable {
    fun createClone(): Cloneable
}

class Paper(val name: String): Cloneable {
    override fun createClone(): Paper {
        return Paper(this.name)
    }
}

fun main(args: Array<String>) {
    val prototype1 = Paper("prototype")
    val prototype2 = prototype1.createClone()

    println("prototype1: hasCode = ${prototype1.hashCode()}, name = ${prototype1.name}")
    println("prototype2: hasCode = ${prototype2.hashCode()}, name = ${prototype2.name}")
}
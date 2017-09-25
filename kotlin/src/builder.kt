data class SaltWater(var salt: Double, var water: Double)

interface Builder {
    fun addSolute(soluteAmount: Double)
    fun addSolvent(solventAmount: Double)
    fun abandonSolution(solutionAmount: Double)
    fun getResult(): Any
}

class SaltWaterBuilder: Builder {
   private val saltWater = SaltWater(0.0, 0.0)
    override fun addSolute(saltAmount: Double) {
        saltWater.salt += saltAmount
    }

    override fun addSolvent(waterAmount: Double) {
        saltWater.water += waterAmount
    }

    override fun abandonSolution(solutionAmount: Double) {
    }

    override fun getResult(): Any {
        return saltWater
    }
}

class Director(val builder: Builder) {
    fun construct() {
        builder.addSolvent(100.0)
        builder.addSolute(40.0)
        builder.abandonSolution(70.0)
        builder.addSolvent(100.0)
        builder.addSolute(15.0)
    }
}

fun main(args: Array<String>) {
    val builder = SaltWaterBuilder()
    val dir = Director(builder)
    dir.construct()
    val saltWater = builder.getResult() as SaltWater
    println("salt: ${saltWater.salt}, water: ${saltWater.water}")
}
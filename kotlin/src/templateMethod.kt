interface Cuttable {}
class Wood: Cuttable {}
abstract class WoodCutPrint {
    abstract fun draw(hanzai: Cuttable)
    abstract fun cut(hanzai: Cuttable)
    abstract fun p(hanzai: Cuttable)
    fun createWoodCutPrint() {
        val hanzai = Wood()
        draw(hanzai)
        cut(hanzai)
        p(hanzai)
    }
}

class TanakasWoodCutPrint: WoodCutPrint() {
    override fun draw(hanzai: Cuttable) {
        println("draw!!")
    }
    override fun cut(hanzai: Cuttable) {
        println("cut!!")
    }
    override fun p(hanzai: Cuttable) {
        println("print!!")
    }
}

fun main(args: Array<String>) {
    val cutPrint = TanakasWoodCutPrint()
    cutPrint.createWoodCutPrint()
}
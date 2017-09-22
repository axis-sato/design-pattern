abstract class WoodsCutPrint {
    abstract fun draw(hanzai: Cuttable)
    abstract fun cut(hanzai: Cuttable)
    abstract fun p(hanzai: Cuttable)
    open fun createCutable(): Cuttable {
        return Wood()
    }
    fun createWoodCutPrint() {
        val hanzai = createCutable()
        draw(hanzai)
        cut(hanzai)
        p(hanzai)
    }
}

class ImagawasWoodCutPrint: WoodsCutPrint() {
    override fun createCutable(): Cuttable {
        return Wood()
    }
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
    val cutPrint = ImagawasWoodCutPrint()
    cutPrint.createWoodCutPrint()
}
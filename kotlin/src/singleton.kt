object RegisterNote {
    var count = 0
    fun increment() {
        count += 1
    }
}

fun main(args: Array<String>) {
    val registerNote1 = RegisterNote
    registerNote1.increment()
    println("registerNote1 count: ${registerNote1.count}")
    val registerNote2 = RegisterNote
    println("registerNote2 count: ${registerNote2.count}")
}
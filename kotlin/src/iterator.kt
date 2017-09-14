fun main(args: Array<String>) {
    val student = Student("sato", Sex.Man)
    println("name: ${student.name}, sex: ${student.sex}")
}

enum class Sex {
    Man, Woman
}

class Student(val name: String, val sex: Sex) {
}
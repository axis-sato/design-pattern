import kotlin.reflect.jvm.internal.impl.load.kotlin.JvmType

fun main(args: Array<String>) {
    val me = MyTeacher()
    me.createStudentList()
    me.callStudent()
}

enum class Sex {
    Man, Woman
}

class Student(val name: String, val sex: Sex) {
}

open class StudentList(private var studentCount: Int) {
    private var students: MutableList<Student> = mutableListOf()
    var last = 0

    fun add(student: Student) {
        students.add(last, student)
        last += 1
    }

    fun getStudentAt(index: Int): Student {
        return students[index]
    }
}

abstract class Teacher {
    abstract var studentList: StudentList
    abstract fun createStudentList()
    abstract fun callStudent()
}

class MyTeacher : Teacher() {
    override var studentList: StudentList = StudentList(0)

    override fun createStudentList() {
        studentList = StudentList(5)
        studentList.add(Student("赤井亮太", Sex.Man))
        studentList.add(Student("赤羽里美", Sex.Woman))
        studentList.add(Student("岡田美央", Sex.Woman))
        studentList.add(Student("西森俊介", Sex.Man))
        studentList.add(Student("中ノ森玲菜", Sex.Woman))
    }

    override fun callStudent() {
        (0 until studentList.last)
                .map { studentList.getStudentAt(it) }
                .forEach { println("${it.name} ${it.sex}") }
    }
}

//class MyStudentList(var studentCount: Int): StudentList(studentCount), Aggregate {
//    override fun iterator(): Iterator {
//        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
//    }
//
//}
//
//interface Aggregate {
//    fun iterator(): Iterator
//}
//
//interface Iterator {
//    val hasNext: Boolean
//    fun next(): JvmType.Object
//}

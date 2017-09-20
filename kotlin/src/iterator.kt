enum class Sex {
    Man, Woman
}

data class Student(val name: String, val sex: Sex)

open class StudentList {
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

class MyStudentList: StudentList(), Aggregate {
    override fun iterator(): Iterator {
        return MyStudentIterator(this)
    }
}

class MyStudentIterator(
        private val myStudentList: MyStudentList,
        private var index: Int = 0
): Iterator {
    override val hasNext: Boolean
        get() = myStudentList.last > index

    override val next: Student
        get() {
            val student = myStudentList.getStudentAt(index)
            index += 1
            return student
        }

}

interface Aggregate {
    fun iterator(): Iterator
}

interface Iterator {
    val hasNext: Boolean
    val next: Any
}

abstract class Teacher {
    abstract var studentList: MyStudentList
    abstract fun createStudentList()
    abstract fun callStudent()
}

class MyTeacher : Teacher() {
    override var studentList = MyStudentList()

    override fun createStudentList() {
        studentList = MyStudentList()
        studentList.add(Student("赤井亮太", Sex.Man))
        studentList.add(Student("赤羽里美", Sex.Woman))
        studentList.add(Student("岡田美央", Sex.Woman))
        studentList.add(Student("西森俊介", Sex.Man))
        studentList.add(Student("中ノ森玲菜", Sex.Woman))
    }

    override fun callStudent() {
        val iterator = studentList.iterator()
        while (iterator.hasNext) {
            println((iterator.next as Student).name)
        }
    }
}

fun main(args: Array<String>) {
    val me = MyTeacher()
    me.createStudentList()
    me.callStudent()
}

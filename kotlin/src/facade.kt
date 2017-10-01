class BookList {
    fun search(name: String): String? {
        if (name == "foo") {
            return "foo"
        }
        return null
    }
}

class LendingList {
    fun check(name: String): Boolean {
        return true
    }
}

class Librarian {
    fun search(name: String): String {
        val bookList = BookList()
        val location = bookList.search(name)
        location?.let {
            val lendingList = LendingList()
            return if (lendingList.check(name)) {
                "貸出中です"
            } else {
                it
            }
        }
        return "その本は貯蔵していません"
    }
}

fun main(args: Array<String>) {
    val librarian = Librarian()
    val location = librarian.search("foo")
    println(location)
}
interface DirectoryEntry {
    fun remove()
}

class File(private val name: String): DirectoryEntry {
    override fun remove() {
        println("$name を削除しました")
    }
}

class Directory(
        private val name: String,
        private var entries: MutableList<DirectoryEntry> = mutableListOf()
): DirectoryEntry {
    fun add(entry: DirectoryEntry) {
        entries.add(entry)
    }

    override fun remove() {
        entries.forEach {
            it.remove()
        }
        println("$name を削除しました")
    }
}

class SymbolicLink(private val name: String): DirectoryEntry {
    override fun remove() {
        println("$name を削除しました")
    }
}

fun main(args: Array<String>) {
    val file1 = File("file1")
    val file2 = File("file2")
    val file3 = File("file3")
    val sFile1 = SymbolicLink("sFile1")
    val dir1 = Directory("dir1")
    dir1.add(file1)
    dir1.add(sFile1)
    val dir2 = Directory("dir2")
    dir2.add(file2)
    dir2.add(file3)

    dir1.remove()
    dir2.remove()
}
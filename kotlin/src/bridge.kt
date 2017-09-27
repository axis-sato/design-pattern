open class Sorter(private val sortImple: SortImple) {
    fun sort() {
        sortImple.sort()
    }
}

class TimerSorter(sortImple: SortImple): Sorter(sortImple) {
    fun timerSort() {
        println("start timer")
        sort()
        println("stop timer")
    }
}

interface SortImple {
    fun sort()
}

class QuickSortImple: SortImple {
    override fun sort() {
        println("quick sort")
    }
}

class BubbleSortImple: SortImple {
    override fun sort() {
        println("bubble sort")
    }
}

fun main(args: Array<String>) {
    val quickSort = TimerSorter(QuickSortImple())
    quickSort.timerSort()

    val bubbleSort = TimerSorter(BubbleSortImple())
    bubbleSort.timerSort()
}
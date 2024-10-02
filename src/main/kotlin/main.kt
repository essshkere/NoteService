fun main() {
}

data class Note(
    var id: Int = 0,
    val title: String = "0",
    val text: String = "0",
    var isDeleted: Boolean = false
    val comments: Comment = Comment()
)

data class Comment(
    var id : Int = 0,
    val text: String = "0",
    var isDeleted: Boolean = false
)

// Интерфейс репозитория
interface Repository<T> {
    fun create(item: T): T
    fun read(id: String): T?
    fun update(item: T): T?
    fun delete(id: String): Boolean
}

// Реализация репозитория в памяти
class InMemoryRepository<T>(private val items: MutableList<T> = mutableListOf()) : Repository<T> {

    override fun create(item: T): T {
        items.add(item)
        return item
    }

    override fun read(id: String): T? {
        return items.find { (it as? Note)?.id == id || (it as? Comment)?.id == id }
    }

    override fun update(item: T): T? {
        val index = items.indexOfFirst { (it as? Note)?.id == (item as? Note)?.id || (it as? Comment)?.id == (item as? Comment)?.id }
        return if (index != -1) {
            items[index] = item
            item
        } else {
            null
        }
    }

    override fun delete(id: String): Boolean {
        val item = read(id)
        return if (item != null) {
            when (item) {
                is Note -> {
                    item.isDeleted = true
                    true
                }
                is Comment -> {
                    item.isDeleted = true
                    true
                }
                else -> false
            }
        } else {
            false
        }
    }
}
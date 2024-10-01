fun main() {}

data class Note(
    var noteId: Int,  // айди заметки
    val title: String, // заголовок заметки
    val text: String, // текст заметки
    val privacy: Int, // Уровень доступа к заметке. Возможные значения: 0 — все пользователи, 1 — только друзья, 2 — друзья и друзья друзей, 3 — только пользователь.
    val commentPrivacy: Int, // Уровень доступа к комментированию заметки. Возможные значения:  0 — все пользователи, 1 — только друзья,  2 — друзья и друзья друзей, 3 — только пользователь.
    val comments: Comment = Comment() // комментарии к записи
)

data class Comment(
    var count: Int = 0, // — количество комментариев;
    val canPost: Boolean = false, //— информация о том, может ли текущий пользователь комментировать запись (1 — может, 0 — не может);
    val groupsCanPost: Boolean = false, //— информация о том, могут ли сообщества комментировать запись;
    val canClose: Boolean = false, //— может ли текущий пользователь закрыть комментарии к записи;
    val canOpen: Boolean = false  //— может ли текущий пользователь открыть комментарии к записи.
) {
    override fun toString(): String {
        return "Comment ($count, $canPost, $groupsCanPost, $canClose, $canOpen)"
    }
}

public interface MutableCollections<E> : Collection<E>, MutableIterator<E> {
    fun add(note: Note): Int {

        return note.noteId
    }
    //Создает новую заметку у текущего пользователя.

    fun createComment(comment: Comment): Int {

        return comment.count
    }
    // Добавляет новый комментарий к заметке.

    fun delete(noteId: Int) {

    }

    //Удаляет заметку текущего пользователя.

    fun deleteComment(count: Int) {

    }
    // Удаляет комментарий к заметке.

    fun edit() {

    }
    // Редактирует заметку текущего пользователя.

    fun editComment() {

    }
    // Редактирует указанный комментарий у заметки.

    fun get() {}
    //Возвращает список заметок, созданных пользователем.

    fun getById() {}
    //Возвращает заметку по её id.

    fun getComments() {}

    // Возвращает список комментариев к заметке.
    fun restoreComment() {}
    //Восстанавливает удалённый комментарий.

}
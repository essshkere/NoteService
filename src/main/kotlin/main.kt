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
)

data class CommentDelete(
    var count: Int = 0, // — количество комментариев;
    val canPost: Boolean = false, //— информация о том, может ли текущий пользователь комментировать запись (1 — может, 0 — не может);
    val groupsCanPost: Boolean = false, //— информация о том, могут ли сообщества комментировать запись;
    val canClose: Boolean = false, //— может ли текущий пользователь закрыть комментарии к записи;
    val canOpen: Boolean = false  //— может ли текущий пользователь открыть комментарии к записи.
)

public interface MutableCollections<E> : Collection<E>, MutableIterator<E> {
    fun add(note: E): Boolean

    //Создает новую заметку у текущего пользователя.
    fun createComment(comment: E): Int

    // Добавляет новый комментарий к заметке.
    fun delete(noteId: E)

    //Удаляет заметку текущего пользователя.
    fun deleteComment(count: E)

    // Удаляет комментарий к заметке.
    fun edit(noteId: E)

    // Редактирует заметку текущего пользователя.
    fun editComment(count: E)

    // Редактирует указанный комментарий у заметки.
    fun get()

    //Возвращает список заметок, созданных пользователем.
    fun getById(noteId: E)

    //Возвращает заметку по её id.
    fun getComments(count: E)

    // Возвращает список комментариев к заметке.
    fun restoreComment(count: E)
    //Восстанавливает удалённый комментарий.
}
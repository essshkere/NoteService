fun main() {
    val noteService = NoteService()
    val commentService = CommentService()
    val addedNote = noteService.create(Note())
    val addedComment = commentService.create(Comment())
    val addedNote2 = noteService.create(Note())
    val addedComment2 = commentService.create(Comment())
    val addedNot = noteService.create(Note())
    val addedNot2 = noteService.create(Note())
    val updateNote = noteService.update(Note(1))
    val result = updateNote?.id
    val updateNote2 = noteService.update(Note(200))
    val result2 = updateNote?.text
}

interface Identifiable {
    var id: Int
    var isDeleted: Boolean
    var text: String
}

data class Note(
    override var id: Int = 0,
    val comment: Comment = Comment(),
    override var isDeleted: Boolean = false,
    override var text: String = "0"
) : Identifiable

data class Comment(
    override var id: Int = 0,
    val noteId: Int = 0,
    override var isDeleted: Boolean = false,
    override var text: String = "0"
) : Identifiable

interface Service<T> {
    fun create(item: T): T
    fun read(id: Int): T?
    fun update(item: T): T?
    fun delete(id: Int): Boolean
}

class NoteService(private val notes: MutableList<Note> = mutableListOf()) {
    private var i = 1

    fun create(note: Note): Note {
        note.id = i++
        notes.add(note)
        return note
    }

    fun read(id: Int): Note? {
        return notes.find { it.id == id }
    }

    fun update(note: Note): Note? {
        val index = notes.indexOfFirst { it.id == note.id }
        if (index != -1) {
            notes[index] = note
            return note
        }
        return null
    }

    fun delete(id: Int): Boolean {
        val note = read(id)
        return if (note != null) {
            note.isDeleted = true
            true
        } else {
            false
        }
    }

    fun showNotes() {
        for (note in notes) {
            println("ID: ${note.id}, Текст: ${note.text}")
        }
    }
}

class CommentService(private val comments: MutableList<Comment> = mutableListOf()) {
    private var i = 1

    fun create(comment: Comment): Comment {
        comment.id = i++
        comments.add(comment)
        return comment
    }

    fun read(id: Int): Comment? {
        return comments.find { it.id == id }
    }

    fun update(comment: Comment): Comment? {
        val index = comments.indexOfFirst { it.id == comment.id }
        if (index != -1) {
            comments[index] = comment
            return comment
        }
        return null
    }

    fun delete(id: Int): Boolean {
        val comment = read(id)
        return if (comment != null) {
            comment.isDeleted = true
            true
        } else {
            false
        }
    }

    fun restore(id: Int): Boolean {
        val comment = read(id)
        return if (comment != null) {
            comment.isDeleted = false
            true
        } else {
            false
        }
    }

    fun showComments(noteId: Int) {
        for (comment: Comment in comments) {
            if (noteId == comment.noteId) {
                println("ID: ${comment.id}, Текст: ${comment.text}")
            }
        }
    }
}
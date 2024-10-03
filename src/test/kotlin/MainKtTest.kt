import org.junit.Assert.assertEquals
import org.junit.Test

class MainKtTest {

    @Test
    fun addTest() {
        val noteService = ServiceCRUD<Note>()
        val addedNote = noteService.create(Note())
        val idTest = addedNote.id
        assertEquals(1, idTest)
    }

    @Test
    fun readNoteTestTrue() {
        val noteService = ServiceCRUD<Note>()
        val addedNote = noteService.create(Note())
        val addedNote2 = noteService.create(Note())
        val addedNote3 = noteService.read(1)
        val result = addedNote3?.id
        assertEquals(1, result)
    }
    @Test
    fun readNoteTestNull() {
        val noteService = ServiceCRUD<Note>()
        val addedNote = noteService.create(Note())
        val addedNote2 = noteService.create(Note())
        val addedNote3 = noteService.read(4)
        val result = addedNote3?.id
        assertEquals(null, result)
    }
    @Test
    fun readCommentTestTrue() {
        val commentService = ServiceCRUD<Comment>()
        val addedComment = commentService.create(Comment())
        val addedComment2 = commentService.create(Comment())
        val readComment = commentService.read(1)
        val result = readComment?.id
        assertEquals(1, result)
    }
    @Test
    fun readCommentTestNull() {
        val commentService = ServiceCRUD<Comment>()
        val addedComment = commentService.create(Comment())
        val addedComment2 = commentService.create(Comment())
        val readComment = commentService.read(4)
        val result = readComment?.id
        assertEquals(null, result)
    }
    @Test
    fun updateNoteTestTrue() {
        val noteService = ServiceCRUD<Note>()
        val addedNote = noteService.create(Note())
        val addedNote2 = noteService.create(Note())
        val updateNote = noteService.update(Note(1,"update"))
        val result = updateNote?.text
        assertEquals("update", result)
    }

    @Test
    fun updateCommentTestTrue() {
        val commentService = ServiceCRUD<Comment>()
        val addedComment = commentService.create(Comment())
        val addedComment2 = commentService.create(Comment())
        val updateComment = commentService.update(Comment(1))
        val result = updateComment?.id
        assertEquals(1, result)
    }



}
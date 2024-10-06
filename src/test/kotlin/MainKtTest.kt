import org.junit.Assert.assertEquals
import org.junit.Test

class MainKtTest {

    @Test
    fun addTest() {
        val noteService = NoteService()
        val addedNote = noteService.create(Note())
        val idTest = addedNote.id
        assertEquals(1, idTest)
    }

    @Test
    fun readNoteTestTrue() {
        val noteService = NoteService()
        val addedNote = noteService.create(Note())
        val addedNote2 = noteService.create(Note())
        val addedNote3 = noteService.read(1)
        val result = addedNote3?.id
        assertEquals(1, result)
    }
    @Test
    fun readNoteTestNull() {
        val noteService = NoteService()
        val addedNote = noteService.create(Note())
        val addedNote2 = noteService.create(Note())
        val addedNote3 = noteService.read(4)
        val result = addedNote3?.id
        assertEquals(null, result)
    }
    @Test
    fun readCommentTestTrue() {
        val commentService = CommentService()
        val addedComment = commentService.create(Comment())
        val addedComment2 = commentService.create(Comment())
        val readComment = commentService.read(1)
        val result = readComment?.id
        assertEquals(1, result)
    }
    @Test
    fun readCommentTestNull() {
        val commentService = CommentService()
        val addedComment = commentService.create(Comment())
        val addedComment2 = commentService.create(Comment())
        val readComment = commentService.read(4)
        val result = readComment?.id
        assertEquals(null, result)
    }
    @Test
    fun updateNoteTestTrue() {
        val noteService = NoteService()
        val addedNote = noteService.create(Note())
        val addedNote2 = noteService.create(Note())
        val updateNote = noteService.update(Note(1,text = "update"))
            val result = updateNote?.text
        assertEquals("update", result)
    }
    @Test
    fun updateNoteTestNull() {
        val noteService = NoteService()
        val addedNote = noteService.create(Note())
        val addedNote2 = noteService.create(Note())
        val updateNote = noteService.update(Note(200,text = "update"))
        val result = updateNote?.text
        assertEquals(null, result)
    }

    @Test
    fun updateCommentTestTrue() {
        val commentService = CommentService()
        val addedComment = commentService.create(Comment())
        val addedComment2 = commentService.create(Comment())
        val updateComment = commentService.update(Comment(1 , text = "update"))
        val result = updateComment?.text
        assertEquals( "update", result)
    }
    @Test
    fun updateCommentTestNull() {
        val commentService = CommentService()
        val addedComment = commentService.create(Comment())
        val addedComment2 = commentService.create(Comment())
        val updateComment = commentService.update(Comment(200, text = "update"))
        val result = updateComment?.text
        assertEquals(null, result)
    }


}
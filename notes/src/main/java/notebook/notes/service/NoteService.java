package notebook.notes.service;

import notebook.notes.model.Note;
import notebook.notes.repository.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class NoteService {
    private final NoteRepository noteRepository;

    @Autowired
    public NoteService(NoteRepository noteRepository) {
        this.noteRepository = noteRepository;
    }

    public List<Note> getAllNotes() {
        return noteRepository.findAll();
    }

    public Note getNoteById(Long id) {
        return noteRepository.findById(id).orElse(null);
    }

    public Note createNote(Note note) {
        return noteRepository.save(note);
    }

    public Note updateNote(Long id, Note noteDetails) {
        Note note = noteRepository.findById(id).orElse(null);
        if (note != null) {
            note.setTitle(noteDetails.getTitle());
            note.setContent(noteDetails.getContent());
            note.setCategory(noteDetails.getCategory());
            return noteRepository.save(note);
        }
        return null;
    }

    public void deleteNote(Long id) {
        noteRepository.deleteById(id);
    }

    public List<Note> getNotesByCategory(String category) {
        return noteRepository.findByCategory(category);
    }

    public List<Note> searchNotesByTitle(String title) {
        return noteRepository.findByTitleContainingIgnoreCase(title);
    }
}

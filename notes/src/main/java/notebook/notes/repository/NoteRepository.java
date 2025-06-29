package notebook.notes.repository;

import notebook.notes.model.Note;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface NoteRepository extends JpaRepository<Note, Long> {
    List<Note> findByCategory(String category);

    List<Note> findByTitleContainingIgnoreCase(String title);
}
package kea.alog.release.domain.note;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface NoteRepository extends JpaRepository<Note, Long> {
    List<Note> findAllByPjPk(Long pjPk);

    List<Note> findAllByTeamPk(Long teamPk);

    
}

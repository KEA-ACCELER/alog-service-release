package kea.alog.release.domain.noteimage;

import java.beans.JavaBean;

import org.springframework.stereotype.Component;

import jakarta.persistence.*;
import kea.alog.release.domain.note.Note;
import lombok.*;

@Entity
@Component
@Table(name = "noteimg")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@JavaBean
public class NoteImage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "img_id")
    private Long imageId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "r_pk")
    private Note notePk;

    @Column(name = "file_pk")
    private Long filePk;

    @Builder(toBuilder = true)
    public NoteImage(Note notePk, Long filePk){
        this.notePk = notePk;
        this.filePk = filePk;
    }
}

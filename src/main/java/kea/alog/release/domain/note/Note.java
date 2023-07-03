package kea.alog.release.domain.note;

import java.beans.JavaBean;
import java.io.Serializable;

import org.springframework.stereotype.Component;

import jakarta.persistence.*;
import kea.alog.release.util.BaseTimeEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Component
@Entity
@Table(name = "note")
@NoArgsConstructor(access = lombok.AccessLevel.PROTECTED)
@AllArgsConstructor
@Getter
@JavaBean
public class Note extends BaseTimeEntity implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "note_pk")
    private Long notePk;

    @Column(name = "p_pk")
    private String pPk;

    @Column(name = "team_pk")
    private String teamPk;

    @Column(name = "note_title", length = 100)
    private String noteTitle;

    @Column(name = "note_content", length = 1000)
    private String noteContent;

    @Column(name = "note_version", length = 10)
    private String noteVersion;

    @Column(name = "note_file_link", length =100)
    private String noteFileLink;

    @Builder(toBuilder = true)
    public Note(String noteTitle, String noteContent, String noteVersion, String noteFileLink){
        this.noteTitle = noteTitle;
        this.noteContent = noteContent;
        this.noteVersion = noteVersion;
        this.noteFileLink = noteFileLink;
    }
}

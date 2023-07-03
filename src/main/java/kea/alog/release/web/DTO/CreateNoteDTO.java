package kea.alog.release.web.DTO;

import lombok.Builder;
import lombok.Getter;

@Getter
public class CreateNoteDTO {
    private String noteTitle;
    private String noteContent;
    private String noteVersion;
    private String noteFileLink;

    @Builder
    public CreateNoteDTO(String noteTitle, String noteContent, String noteVersion, String noteFileLink){
        this.noteTitle = noteTitle;
        this.noteContent = noteContent;
        this.noteVersion = noteVersion;
        this.noteFileLink = noteFileLink;
    }
}

package kea.alog.release.web.DTO;

import lombok.Builder;
import lombok.Getter;

@Getter
public class NoteTagDTO {
    private Long noteId;
    private Long tagId;

    @Builder
    public NoteTagDTO(Long noteId, Long tagId){
        this.noteId = noteId;
        this.tagId = tagId;
    }
}

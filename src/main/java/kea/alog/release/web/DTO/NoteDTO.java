package kea.alog.release.web.DTO;

import java.time.LocalDateTime;
import java.util.List;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class NoteDTO {
    @Getter
    @NoArgsConstructor
    public static class SendNoteDTO{
        private String noteTitle;
        private String noteContent;
        private String noteVersion;
        private String noteFileLink;

        @Builder
        public SendNoteDTO(String noteTitle, String noteContent, String noteVersion, String noteFileLink){
            this.noteTitle = noteTitle;
            this.noteContent = noteContent;
            this.noteVersion = noteVersion;
            this.noteFileLink = noteFileLink;
        }

        public boolean ischkData() {
            return noteTitle != null || noteContent != null || noteVersion != null || noteFileLink != null;
        }
    }


    @Getter
    @NoArgsConstructor
    public static class CreateNoteDTO{
        private Long pjPk;
        private Long teamPk;
        private String noteTitle;
        private String noteContent;
        private String noteVersion;
        private String noteFileLink;

        @Builder
        public CreateNoteDTO(Long teamPk, Long pjPk, String noteTitle, String noteContent, String noteVersion, String noteFileLink){
            this.teamPk = teamPk;
            this.pjPk = pjPk;
            this.noteTitle = noteTitle;
            this.noteContent = noteContent;
            this.noteVersion = noteVersion;
            this.noteFileLink = noteFileLink;
        }
    }

    @Getter
    @NoArgsConstructor
    public static class UpdateNoteDTO {
        private Long noteId;
        private Long pjPk;
        private String noteTitle;
        private String noteContent;
        private String noteVersion;
        private String noteFileLink;

        @Builder
        public UpdateNoteDTO(Long noteId, Long pjPk, String noteTitle, String noteContent, String noteVersion, String noteFileLink){
            this.pjPk = pjPk;
            this.noteId = noteId;
            this.noteTitle = noteTitle;
            this.noteContent = noteContent;
            this.noteVersion = noteVersion;
            this.noteFileLink = noteFileLink;
        }
    }
    
    @Getter
    @NoArgsConstructor
    public static class NoteListDTO{
        private long notePk;
        private long pjPk;
        private long teamPk;
        private String noteTitle;
        private String noteContent;
        private String noteVersion;
        private String noteFileLink;
        private LocalDateTime createDate;
        private LocalDateTime modifiedDate;

        @Builder
        public NoteListDTO(long notePk, long pjPk, long teamPk, String noteTitle, String noteContent, String noteVersion, String noteFileLink, LocalDateTime createDate, LocalDateTime modifiedDate) {
            this.notePk = notePk;
            this.pjPk = pjPk;
            this.teamPk = teamPk;
            this.noteTitle = noteTitle;
            this.noteContent = noteContent;
            this.noteVersion = noteVersion;
            this.noteFileLink = noteFileLink;
            this.createDate = createDate;
            this.modifiedDate = modifiedDate;
        }
    }
    @Getter
    @NoArgsConstructor
    public static class RspNoteListDTO{
        private List<NoteListDTO> rspList;
        private int totalPage;

        @Builder
        public RspNoteListDTO(List<NoteListDTO> rspList, int totalPage){
            this.rspList = rspList;
            this.totalPage = totalPage;
        }
    }
}

package kea.alog.release.web.DTO;

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
        private Boolean chkData;

        @Builder
        public SendNoteDTO(String noteTitle, String noteContent, String noteVersion, String noteFileLink, Boolean chkData){
            this.noteTitle = noteTitle;
            this.noteContent = noteContent;
            this.noteVersion = noteVersion;
            this.noteFileLink = noteFileLink;
            this.chkData = chkData;
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
}

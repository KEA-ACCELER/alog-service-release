package kea.alog.release.web.DTO;

import lombok.Builder;
import lombok.Getter;

public class NoteDTO {
    @Getter
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
    }


    @Getter
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

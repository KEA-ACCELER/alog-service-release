package kea.alog.release.web.DTO;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class TagDTO {
    @Getter
    @NoArgsConstructor
    public static class TagContentDTO{
        private String tagContent;

        @Builder
        public TagContentDTO(String tagContent){
            this.tagContent = tagContent;
        }
    }

    @Getter
    public static class UpdateTagDTO{
        private Long tagPk;
        private String tagContent;

        @Builder
        public UpdateTagDTO(Long tagPk, String tagContent){
            this.tagContent = tagContent;
            this.tagPk = tagPk;
        }
    }

}

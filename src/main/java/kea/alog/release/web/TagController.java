package kea.alog.release.web;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kea.alog.release.config.Result;
import kea.alog.release.service.TagService;
import kea.alog.release.web.DTO.TagDTO.TagContentDTO;
import kea.alog.release.web.DTO.TagDTO.TagPrameterDTO;
import kea.alog.release.web.DTO.TagDTO.TagPageingDTO;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/tag")
@RequiredArgsConstructor
public class TagController {
    final TagService tagService;

    @GetMapping("/{tagId}")
    public ResponseEntity<Result> getTag(@PathVariable Long tagId){
        TagContentDTO tag = tagService.getTag(tagId);
        if(tag.isChkData()){
            Result result = Result.builder().isSuccess(true)
                            .message("테그 불러오기 완료")
                            .data(tag).build();
            return ResponseEntity.ok().body(result);
        } else{
            Result result = Result.builder().isSuccess(false)
                            .message("테그 불러오기 실패")
                            .build();
            return ResponseEntity.badRequest().body(result);
        }
    }

    @GetMapping("/tagList/{currentPage}")
    public ResponseEntity<Result> getTagList(@PathVariable Long currentPage){
        TagPageingDTO rspDTO = tagService.getAllList(currentPage);
        // List<TagPrameterDTO> rspTagList = tagService.getAllList(currentPage);
        Result result = Result.builder()
                            .data(rspDTO)
                            .isSuccess(null)
                            .message("태그 리스트 불러오기 완료")
                            .build();
        return ResponseEntity.ok().body(result);
    }

    @PostMapping("/createTag")
    public ResponseEntity<Result> createTag(@RequestBody TagContentDTO request){
        Long tagId = tagService.createTag(request);
        Result result = Result.builder()
                            .isSuccess(true)
                            .message("태그 저장 완료")
                            .data(tagId).build();
        return ResponseEntity.ok().body(result);
    }

    @PutMapping("/updateTag/{tagId}")
    public ResponseEntity<Result> updateTag(@RequestBody TagContentDTO contentDTO, @PathVariable Long tagId){
        Result result;
        if(tagService.updateTag(contentDTO, tagId)){
            result = Result.builder().data(tagId).isSuccess(true).message("수정되었습니다.").build();
            return ResponseEntity.ok().body(result);
        } else {
            result = Result.builder().data(tagId).isSuccess(false).message("실패하였습니다.").build();
            return ResponseEntity.badRequest().body(result);
        }
    }

    @DeleteMapping("/deleteTag/{tagId}")
    public ResponseEntity<Result> deleteTag(@PathVariable Long tagId){
        tagService.deleteTag(tagId);
        Result result = Result.builder()
                            .isSuccess(true)
                            .message("태그 삭제 완료")
                            .build();
        return ResponseEntity.ok().body(result);
    }

}

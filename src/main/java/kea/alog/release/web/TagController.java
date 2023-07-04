package kea.alog.release.web;

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
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/tag")
@RequiredArgsConstructor
public class TagController {
    final TagService tagService;

    @GetMapping("/{tagId}")
    public ResponseEntity<Result> getTag(@PathVariable Long tagId){
        TagContentDTO tag = tagService.getTag(tagId);
        Result result = Result.builder().isSuccess(true)
                            .message("테그 불러오기 완료")
                            .data(tag).build();
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

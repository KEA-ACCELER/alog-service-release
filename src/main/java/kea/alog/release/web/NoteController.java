package kea.alog.release.web;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import kea.alog.release.config.Result;
import kea.alog.release.domain.note.Note;
import kea.alog.release.service.NoteService;
import kea.alog.release.web.DTO.NoteDTO;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/note")
public class NoteController {

    final private NoteService noteService;

    @GetMapping("/{notePk}")
    public ResponseEntity<Result> getNote(@PathVariable Long notePk){
        NoteDTO.SendNoteDTO note = noteService.getNote(notePk);
        Result result = Result.builder()
                            .isSuccess(true)
                            .data(note)
                            .message("노트 불러오기 완료")
                            .build();
        return ResponseEntity.ok().body(result);
    }

    @GetMapping("/list/{pPk}")
    public ResponseEntity<Result> getAllNote(@PathVariable Long pPk){
        Result result;
        List<Note> responseNote = noteService.getAllNote(pPk);
        result = Result.builder()
                        .isSuccess(true)
                        .message("Note 불러오기 완료")
                        .data(responseNote)
                        .build();
        return ResponseEntity.ok().body(result);
    }

    @PostMapping("/createNote")
    public ResponseEntity<Result> createNote(@RequestBody NoteDTO.CreateNoteDTO request){
        Long id = noteService.createNote(request);
        Result result = Result.builder()
                            .isSuccess(true)
                            .message("노트가 저장되었습니다.")
                            .data(id)
                            .build();
        return ResponseEntity.ok().body(result);
    }

    @PutMapping("/updateNote")
    public ResponseEntity<Result> updateNote(@RequestBody NoteDTO.UpdateNoteDTO request){
        boolean chkSave = noteService.updatNote(request);
        if(chkSave){
            Result result = Result.builder()
                            .isSuccess(true)
                            .message("노트가 저장되었습니다.")
                            .build();
            return ResponseEntity.ok().body(result);
        }
        else {
            Result result = Result.builder()
                            .isSuccess(false)
                            .message("노트가 저장되지 않았습니다.")
                            .build();
            return ResponseEntity.badRequest().body(result);
        }
    }

    @DeleteMapping("/deleteNote/{noteId}")
    public ResponseEntity<Result> deleteNote(@PathVariable Long noteId){
        noteService.deleteNote(noteId);
        Result result = Result.builder()
                            .isSuccess(true)
                            .message("노트가 삭제되었습니다.")
                            .build();
        return ResponseEntity.ok().body(result);
    }
}

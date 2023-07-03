package kea.alog.release.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import jakarta.transaction.Transactional;
import kea.alog.release.domain.note.Note;
import kea.alog.release.domain.note.NoteRepository;
import kea.alog.release.web.DTO.CreateNoteDTO;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class NoteService {
    @Autowired
    private final NoteRepository noteRepository;

    @Transactional
    public Note createNote(CreateNoteDTO request) { //Redirect를 url값들로 보내달라.
        Note newNote = Note.builder()
                            .noteTitle(request.getNoteTitle())
                            .noteContent(request.getNoteContent())
                            .noteFileLink(request.getNoteFileLink())
                            .noteVersion(request.getNoteVersion())
                            .build();

        noteRepository.save(newNote);

        return newNote;
    }
    @Transactional
    public Note updatNote(Long noteId){
        Optional<Note> loadNote = noteRepository.findById(noteId);
        if(loadNote.isPresent()){
            Note setNote = loadNote.get();
            setNote.toBuilder()
                .noteTitle(null)
                .build(); //이거 수정해야함

            return setNote;
        } else{
            return null;
        }
    }

}

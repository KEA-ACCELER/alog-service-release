package kea.alog.release.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import kea.alog.release.domain.note.Note;
import kea.alog.release.domain.note.NoteRepository;
import kea.alog.release.web.DTO.NoteDTO;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class NoteService {
    @Autowired
    final private NoteRepository noteRepository;

    @Transactional
    public Long createNote(NoteDTO.CreateNoteDTO request) { //Redirect를 url값들로 보내달라.
        Note newNote = Note.builder()
                            .noteTitle(request.getNoteTitle())
                            .pjPk(request.getPjPk())
                            .teamPk(request.getTeamPk())
                            .noteContent(request.getNoteContent())
                            .noteFileLink(request.getNoteFileLink())
                            .noteVersion(request.getNoteVersion())
                            .build();

        noteRepository.save(newNote);
        return newNote.getNotePk();
    }
    @Transactional
    public boolean updatNote(NoteDTO.UpdateNoteDTO request){
        Optional<Note> loadNote = noteRepository.findById(request.getNoteId());
        if(loadNote.isPresent() && loadNote.get().getPjPk()==request.getPjPk()){
            Note setNote = loadNote.get();
            setNote = setNote.toBuilder()
                            .noteTitle(request.getNoteTitle())
                            .noteContent(request.getNoteContent())
                            .noteVersion(request.getNoteVersion())
                            .noteFileLink(request.getNoteFileLink())
                            .build();
            noteRepository.save(setNote);
            return true;
        } else return false;
    }

    public List<Note> getAllNote(Long pPk){
        List<Note> allNote = noteRepository.findAllByPjPk(pPk);
        return allNote;
    }

    public NoteDTO.SendNoteDTO getNote(Long notePk){
        Optional<Note> optNote = noteRepository.findById(notePk);
        if(optNote.isPresent()){
            Note note = optNote.get();
            NoteDTO.SendNoteDTO noteDTO = NoteDTO.SendNoteDTO.builder()
                                    .noteTitle(note.getNoteTitle())
                                    .noteContent(note.getNoteContent())
                                    .noteVersion(note.getNoteVersion())
                                    .noteFileLink(note.getNoteFileLink())
                                    .chkData(true)
                                    .build();
            return noteDTO;
        } else {
            return NoteDTO.SendNoteDTO.builder().chkData(false).build();
        }
    }

    @Transactional
    public void deleteNote(Long noteId) {
        Optional<Note> optNote = noteRepository.findById(noteId);
        if(optNote.isPresent()){
            noteRepository.delete(optNote.get());
        }
    }
    

}

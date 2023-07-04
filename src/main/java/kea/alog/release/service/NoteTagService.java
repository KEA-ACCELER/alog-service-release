package kea.alog.release.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import kea.alog.release.domain.note.Note;
import kea.alog.release.domain.note.NoteRepository;
import kea.alog.release.domain.noteTag.NoteTag;
import kea.alog.release.domain.noteTag.NoteTagRepository;
import kea.alog.release.domain.tag.Tag;
import kea.alog.release.domain.tag.TagRepository;
import kea.alog.release.web.DTO.NoteTagDTO;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class NoteTagService {
    final private NoteTagRepository noteTagRepository;
    final private NoteRepository noteRepository;
    final private TagRepository tagRepository;

    @Transactional
    public void addTag(NoteTagDTO noteTagDTO) {
        Optional<Tag> tag = tagRepository.findById(noteTagDTO.getTagId());
        Optional<Note> note = noteRepository.findById(noteTagDTO.getNoteId());
        if(tag.isPresent() && note.isPresent()){
            NoteTag noteTag = NoteTag.builder()
                            .notePk(note.get())
                            .tagPk(tag.get())
                            .build();
            noteTagRepository.save(noteTag);
        }
    }

    @Transactional
    public void deleteTag(Long noteTagId){
        Optional<NoteTag> noteTag = noteTagRepository.findById(noteTagId);
        if(noteTag.isPresent()){
            noteTagRepository.delete(noteTag.get());
        }
    }
}

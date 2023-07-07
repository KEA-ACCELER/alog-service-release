package kea.alog.release.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import kea.alog.release.domain.tag.Tag;
import kea.alog.release.domain.tag.TagRepository;
import kea.alog.release.web.DTO.TagDTO.TagContentDTO;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TagService {
    final private TagRepository tagRepository;

    @Transactional
    public Long createTag(TagContentDTO tagContentDTO){
        Tag tag = Tag.builder().tagContent(tagContentDTO.getTagContent()).build();
        tagRepository.save(tag);
        return tag.getTagPk();
    }

    public TagContentDTO getTag(Long tagId){
        Optional<Tag> optTag = tagRepository.findById(tagId);
        if(optTag.isPresent()){
            TagContentDTO sendTag = TagContentDTO.builder().tagContent(optTag.get().getTagContent()).chkData(true).build();
            return sendTag;
        } return TagContentDTO.builder().chkData(false).build();
    }

    @Transactional
    public boolean updateTag(TagContentDTO tagContentDTO, Long tagId){
        Optional<Tag> optTag = tagRepository.findById(tagId);
        if(optTag.isPresent()){
            Tag tag = optTag.get().toBuilder().tagContent(tagContentDTO.getTagContent()).build();
            tagRepository.save(tag);
            return true;
        } else return false;
    }

    @Transactional
    public void deleteTag(Long tagId){
        Optional<Tag> optTag = tagRepository.findById(tagId);
        if(optTag.isPresent()){
            tagRepository.delete(optTag.get());
        }
    }
}

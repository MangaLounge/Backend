package com.readowo.api.publishing.mapping;

import com.readowo.api.mapping.EnhancedModelMapper;
import com.readowo.api.publishing.Dtos.ChapterDtos;
import com.readowo.api.publishing.Dtos.SagaDtos;
import com.readowo.api.publishing.Dtos.SaveChapterDtos;
import com.readowo.api.publishing.Dtos.SaveSagaDtos;
import com.readowo.api.publishing.Models.Chapters;
import com.readowo.api.publishing.Models.Saga;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.util.List;

public class ChaptersMapper implements Serializable {
    @Autowired
    private EnhancedModelMapper mapper;
    public ChapterDtos toResource(Chapters model){
        return mapper.map(model, ChapterDtos.class);
    }
    public Chapters toModel(SaveChapterDtos resource){
        return mapper.map(resource, Chapters.class);
    }
    public List<ChapterDtos> modelList(List<Chapters> chaptersList) {
        return mapper.mapList(chaptersList, ChapterDtos.class);
    }
}

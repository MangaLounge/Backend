package com.readowo.api.publishing.Services.IServices;

import com.readowo.api.publishing.Dtos.SaveChapterDtos;
import com.readowo.api.publishing.Models.Chapters;
import com.readowo.api.publishing.Services.Communication.ChapterResponse;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface IChaptersService {

    List<Chapters> getAllChapters();
    Chapters getChaptersById(Long chaptersId);
    Chapters saveChapters(Chapters chapters);
    ResponseEntity<?> deleteChapters(Long chaptersId);
    Chapters updateChapters(Long id, Chapters chapters);

}

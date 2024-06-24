package com.readowo.api.publishing.controllers;



import com.readowo.api.publishing.Dtos.ChapterDtos;
import com.readowo.api.publishing.Dtos.SagaDtos;
import com.readowo.api.publishing.Dtos.SaveChapterDtos;
import com.readowo.api.publishing.Dtos.SaveSagaDtos;
import com.readowo.api.publishing.Models.Chapters;
import com.readowo.api.publishing.Services.Communication.ChapterResponse;
import com.readowo.api.publishing.Services.IServices.IChaptersService;
import com.readowo.api.publishing.Services.IServices.ISagaService;
import com.readowo.api.publishing.Services.ServicesImpl.ChaptersServiceImpl;
import com.readowo.api.publishing.mapping.ChaptersMapper;
import com.readowo.api.publishing.mapping.SagaMapper;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/api/v1/chapters", produces = "application/json")
public class ChaptersController {
    private final IChaptersService chaptersService;
    private final ChaptersMapper mapper;
    public ChaptersController(IChaptersService chaptersService, ChaptersMapper mapper) {
        this.chaptersService = chaptersService;
        this.mapper = mapper;
    }

    @GetMapping
    public List<ChapterDtos> getAllChapters() {
        return mapper.modelList(chaptersService.getAllChapters());
    }

    @GetMapping("{chaptersId}")
    public ChapterDtos getOneChapter(@PathVariable Long chaptersId) {
        return mapper.toResource(chaptersService.getChaptersById(chaptersId));
    }
    @PostMapping
    public ResponseEntity<ChapterDtos> saveChapters(@RequestBody SaveChapterDtos saveChapterDtos) {
        return new ResponseEntity<>(mapper.toResource(chaptersService.saveChapters(mapper.toModel(saveChapterDtos))), HttpStatus.CREATED);
    }

    @PutMapping("{chaptersId}")
    public ChapterDtos updateChapters(@PathVariable Long chaptersId, @RequestBody SaveChapterDtos saveChapterDtos) {
        return mapper.toResource(chaptersService.updateChapters(chaptersId, mapper.toModel(saveChapterDtos)));
    }
    @DeleteMapping("{chaptersId}")
    public ResponseEntity<?> deleteChapters(@PathVariable Long chaptersId) {
        return chaptersService.deleteChapters(chaptersId);
    }
}

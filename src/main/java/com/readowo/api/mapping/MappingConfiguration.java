package com.readowo.api.mapping;

import com.readowo.api.ReadOwo.mapping.UserMapper;
import com.readowo.api.ReadOwo.mapping.UserProfileMapper;
import com.readowo.api.publishing.Models.Chapters;
import com.readowo.api.publishing.mapping.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration("enhancedModelMapperConfiguration")
public class MappingConfiguration{
    @Bean // Tipo de singleton(?
    public EnhancedModelMapper modelMapper(){
        return new EnhancedModelMapper();
    }
    @Bean
    public UserMapper userMapper(){
        return new UserMapper();
    }
    @Bean
    public UserProfileMapper userProfileMapperMapper(){
        return new UserProfileMapper();
    }
    @Bean
    public SagaMapper sagaMapper(){return new SagaMapper();}
    @Bean
    public LanguageMapper languageMapper(){return new LanguageMapper();}
    @Bean
    public GenreMapper genreMapper(){return new GenreMapper();}
    @Bean
    public BookGenreMapper bookGenreMapper(){return new BookGenreMapper();}
    @Bean
    public ChaptersMapper chaptersMapper(){return new ChaptersMapper();}
    @Bean
    public BookMapper bookMapper(){return new BookMapper();}
}

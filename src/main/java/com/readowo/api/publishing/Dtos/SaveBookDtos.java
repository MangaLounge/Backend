package com.readowo.api.publishing.Dtos;


import lombok.Data;


@Data

public class SaveBookDtos {
    private String Title ;
    private String Synopsis ;
    private String PublishedAt ;
    private String ThumbnailUrl ;
    private Long userProfileId;
    private String language;
    private String saga;
}

package com.f2f.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PageDTO {
    private Long id;
    private String name;
    private String slug;
    private String title;
    private String summary;
    private String language;
    private String meta;
    private String canonicalUrl;
    private List<String> tags;
    private String author;
    private LocalDateTime publishDate;
    private String content;
    private String header;
    private String footer;
}

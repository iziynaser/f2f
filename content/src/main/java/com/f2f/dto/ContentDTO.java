package com.f2f.dto;

import com.f2f.entity.Content;
import com.f2f.entity.Tag;
import lombok.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ContentDTO {
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
}

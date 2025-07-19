package com.f2f.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ReactionCountDTO {
    private String type;  // مثل "FUNNY", "HELPFUL", ...
    private int count;
}

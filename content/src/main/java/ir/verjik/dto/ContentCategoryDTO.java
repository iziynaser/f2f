package ir.verjik.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ContentCategoryDTO {
    private Long id;
    private Long contentId;
    private Long categoryId;
}

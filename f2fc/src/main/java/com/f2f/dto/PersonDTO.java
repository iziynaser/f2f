package com.f2f.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PersonDTO {
    private Long personId;
    private long personCode;
    private Boolean title;
    private String firstName;
    private String lastName;
    private String dateOfBirth;
    private String address;
    private String description;
    // برای ساده سازی فقط شناسه های مرتبط یا فقط رشته‌های ساده را می‌آوریم
    private List<Long> connectionIds;
    private Long loginId;
    private List<Long> groupIds;
    private List<Long> skillIds;
    private List<Long> trainingIds;
    private List<Long> workSheetIds;
    private List<Long> positionIds;
    private List<Long> contactIds;
    private Set<OrderDTO> orders;
}

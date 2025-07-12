package com.f2f.service;

import com.f2f.dto.CommentLikeSummaryDTO;

public interface CommentLikeSummaryService {

    public CommentLikeSummaryDTO getLikeSummaryByTargetId(Long targetId);
}

package ir.verjik.service;

import ir.verjik.dto.CommentLikeSummaryDTO;

public interface CommentLikeSummaryService {

    public CommentLikeSummaryDTO getLikeSummaryByTargetId(Long targetId);
}

package com.f2f.controller;

import com.f2f.dto.CommentDTO;
import com.f2f.dto.CommentResponseDTO;
import com.f2f.eums.CommentSortType;
import com.f2f.service.CommentAnalysisService;
import com.f2f.service.CommentService;
import com.f2f.service.CommentTargetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/store/comments")
public class CommentController {

    private final CommentAnalysisService commentAnalysisService;

    private final CommentService commentService;

    private final CommentTargetService commentTargetService;

    public CommentController(CommentAnalysisService commentAnalysisService, CommentService commentService, CommentTargetService commentTargetService) {
        this.commentAnalysisService = commentAnalysisService;
        this.commentService = commentService;
        this.commentTargetService = commentTargetService;
    }


    @GetMapping("/sorted")
    public ResponseEntity<List<CommentResponseDTO>> getSortedComments(
            @RequestParam(name = "sortBy", defaultValue = "CREATED_ORDER") CommentSortType sortType) {
        return ResponseEntity.ok(commentService.getComments(sortType));
    }

    @ResponseBody
    @RequestMapping("/list")
    public List<CommentResponseDTO> getListOfCommentsForProductId(Long productId){
        List<CommentResponseDTO> commentList = commentService.getListOfCommentsForProductId(productId);
        return commentList;
    }

    @GetMapping("/product/{productId}/count")
    public ResponseEntity<Long> getCommentCount(@PathVariable Long productId) {
        return ResponseEntity.ok(commentAnalysisService.countCommentsForProduct(productId));
    }

    @GetMapping("/product/{productId}/rating")
    public ResponseEntity<Double> getProductRating(@PathVariable Long productId) {
        return ResponseEntity.ok(commentAnalysisService.calculateRatingForProduct(productId));
    }

}

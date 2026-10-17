package ir.verjik.controller;

import ir.verjik.dto.CommentResponseDTO;
import ir.verjik.enums.CommentSortType;
import ir.verjik.service.CommentAnalysisService;
import ir.verjik.service.CommentService;
import ir.verjik.service.CommentTargetService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

package com.f2f.controller;

import com.f2f.dto.CommentDTO;
import com.f2f.dto.CommentResponseDTO;
import com.f2f.eums.CommentSortType;
import com.f2f.service.CommentService;
import com.f2f.service.CommentTargetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/f2f/comments")
public class CommentController {

    @Autowired
    CommentService commentService;

    @Autowired
    CommentTargetService commentTargetService;

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

    @RequestMapping("/count")
    public Object getCommentCount(){
        //KeyValues kv = new KeyValues("result","10");
        //return  kv;
        return new Long("0");
    }
}

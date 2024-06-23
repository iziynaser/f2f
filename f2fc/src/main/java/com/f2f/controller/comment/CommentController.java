package com.f2f.controller.comment;

import com.f2f.dao.comment.CommentDTO;
import com.f2f.dao.comment.CommentDTOS;
import com.f2f.dbc.service.UserAccountService;
import com.f2f.domain.UserAccount;
import com.f2f.entity.common.CommentTarget;
import com.f2f.entity.common.KeyValues;
import com.f2f.entity.product.Product;
import com.f2f.service.comment.CommentService;
import com.f2f.service.comment.CommentTargetService;
import com.f2f.service.product.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/f2f/comments")
public class CommentController {

    @Autowired
    CommentService commentService;

    @Autowired
    ProductService productService;


    @Autowired
    CommentTargetService commentTargetService;

    @Autowired
    UserAccountService userAccountService;

    @ResponseBody
    @PostMapping(value = "/save")
    public CommentDTO createComment(Principal principal, @RequestBody CommentDTOS commentDTO){

        CommentTarget commentTarget ;
        UserAccount userAccount = userAccountService.findByUsername(principal.getName());
        Product p = productService.findProductById(Long.valueOf(commentDTO.getProductId()));

        commentTarget=p.getCommentTarget();
        if(commentTarget==null){
            commentTarget=commentTargetService.returnNewCommentTarget();
            productService.saveCommenttargetForThisProduct(p,commentTarget);
        }
         commentService.createComment(commentDTO,commentTarget,userAccount);
        return null;
    }

    @ResponseBody
    @RequestMapping("/list")
    public List<CommentDTO> getListOfCommentsForProductId(Long productId){
        List<CommentDTO> commentList = commentService.getListOfCommentsForProductId(productId);
        return commentList;
    }
    @RequestMapping("/count")
    public KeyValues getCommentCount(){
        KeyValues kv = new KeyValues("result","10");
        return  kv;
    }
}

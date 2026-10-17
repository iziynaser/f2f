package ir.verjik.dto;


import lombok.Data;

@Data
public class CommentDTO {

    private String subject;
    private String benefits;
    private String disadvatages;
    private String content ;
    private String dateCreated ;
    private String numberOfLikes ;
    private String numberOfDisLikes ;
    private String nickName;

}

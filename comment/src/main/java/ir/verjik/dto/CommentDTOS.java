package ir.verjik.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

@Getter
@Setter
public class CommentDTOS {

    private String title;
    private ArrayList<String> benefits ;
    private ArrayList<String> upsets;
    private String content;
    private String productId ;
}

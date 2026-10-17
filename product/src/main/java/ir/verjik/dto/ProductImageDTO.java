package ir.verjik.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class ProductImageDTO implements Serializable {
    private String description;
    private boolean isUserImage;
    private String name ;
    private String type;
    private String url ;

}

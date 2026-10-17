package ir.verjik.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class ProductMeasureDTO implements Serializable {

    private Long product;
    private float width;
    private Long widthType;
    private float height ;
    private Long heightType;
    private float weight ;
    private Long weightType;
    private float depth ;
    private Long depthType;

}

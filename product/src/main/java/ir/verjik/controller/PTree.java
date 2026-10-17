package ir.verjik.controller;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PTree {
    private String productId;
    private ProductFeatureTreeDTO treeData;
}

package com.f2f.controller;

import com.f2f.dto.FeaturesDTO;
import com.f2f.dto.ProductFeatureGroupDTO;
import com.f2f.dto.ProductFeatureItemDTO;
import com.f2f.dto.ProductFeatureValueDTO;
import com.f2f.entity.Product;
import com.f2f.entity.ProductFeatureGroup;
import com.f2f.entity.ProductFeatureItem;
import com.f2f.entity.ProductFeatureValue;
import com.f2f.service.*;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/f2f/product-feature-group")
@RequiredArgsConstructor
public class ProductFeatureGroupController {

    private final ProductService productService;
    private final ProductFeatureGroupService groupService;
    private final ProductFeatureItemService itemService;
    private final ProductFeatureValueService valueService;


    @GetMapping("/features")
    public ResponseEntity<List<FeaturesDTO>> getProductFeatures(@RequestParam("productId") Long productId) {
        List<FeaturesDTO> features = groupService.getListOfFeatures(productId);
        return ResponseEntity.ok(features);
    }

    @GetMapping("/list")
    public List<ProductFeatureGroupDTO> getAllFeatureGroups() {
        return groupService.findAll();
    }

    @PostMapping("/save")
    public ResponseEntity<PTree> saveFeatureGroupTree(@RequestBody PTree pTree) {
        Product product = productService.findProductById(Long.parseLong(pTree.getProductId()));

        ProductFeatureGroup group = new ProductFeatureGroup(
                pTree.getTreeData().getName(),
                pTree.getTreeData().getValue(),
                0
        );
        group.setProduct(product);
        ProductFeatureGroupDTO savedGroupDTO = groupService.save(group);

        int itemOrder = 0;
        for (ProductFeatureTreeDTO itemDTO : pTree.getTreeData().getChildren()) {
            ProductFeatureItem item = new ProductFeatureItem();
            item.setName(itemDTO.getName());
            item.setFeatureValue(itemDTO.getValue());
            item.setOrders(itemOrder++);
            item.setFeatureGroup(group);

            ProductFeatureItemDTO savedItemDTO = itemService.saveIfNotExists(item, group);

            int valueOrder = 0;
            if (itemDTO.getChildren() != null) {
                for (ProductFeatureTreeDTO valueDTO : itemDTO.getChildren()) {
                    ProductFeatureValue value = new ProductFeatureValue();
                    value.setName(valueDTO.getName());
                    value.setFeatureValue(valueDTO.getValue());
                    value.setFeatureItem(item);
                    value.setOrders(valueOrder++);
                    valueService.saveIfNotExists(value, item);
                }
            }
        }
        return ResponseEntity.ok(pTree);
    }

    @GetMapping("/load")
    public ResponseEntity<PTree> loadProductFeatureGroup(@RequestParam("productId") String productIdStr) {
        Long productId = Long.parseLong(productIdStr);
        Product product = productService.findProductById(productId);
        List<ProductFeatureGroupDTO> groups = groupService.loadGroupsForProduct(product);

        PTree pTree = new PTree();
        pTree.setProductId(productIdStr);

        if (!groups.isEmpty()) {
            ProductFeatureGroupDTO groupDTO = groups.get(0); // فرض یک گروه برای هر محصول
            ProductFeatureTreeDTO groupTree = new ProductFeatureTreeDTO(groupDTO.getName(), groupDTO.getValue());

            List<ProductFeatureTreeDTO> itemTrees = new ArrayList<>();
            for (ProductFeatureItemDTO itemDTO : groupDTO.getItems()) {
                ProductFeatureTreeDTO itemTree = new ProductFeatureTreeDTO(itemDTO.getName(), itemDTO.getValue());

                List<ProductFeatureTreeDTO> valueTrees = new ArrayList<>();
                for (ProductFeatureValueDTO valueDTO : itemDTO.getValues()) {
                    valueTrees.add(new ProductFeatureTreeDTO(valueDTO.getName(), valueDTO.getValue()));
                }
                itemTree.setChildren(valueTrees);
                itemTrees.add(itemTree);
            }
            groupTree.setChildren(itemTrees);
            pTree.setTreeData(groupTree);
        }

        return ResponseEntity.ok(pTree);
    }

    @PostMapping("/initialize")
    public ResponseEntity<Boolean> initializeProductFeatureGroup(@RequestParam("productId") String productIdStr) {
        Long productId = Long.parseLong(productIdStr);
        Product product = productService.findProductById(productId);
        boolean exists = groupService.hasGroupForProduct(product);

        if (!exists) {
            groupService.createDefaultGroupForProduct(product);
        }
        return ResponseEntity.ok(true);
    }
}

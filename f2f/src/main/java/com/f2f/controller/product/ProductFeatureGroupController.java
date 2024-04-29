package com.f2f.controller.product;

import com.f2f.entity.product.*;
import com.f2f.service.product.ProductFeatureGroupService;
import com.f2f.service.product.ProductFeatureItemService;
import com.f2f.service.product.ProductFeatureItemsService;
import com.f2f.service.product.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(value = "/f2f/productFeatureGroup/")
public class ProductFeatureGroupController {

    @Autowired
    ProductService productService;

    @Autowired
    ProductFeatureGroupService productFeatureGroupService;

    @Autowired
    ProductFeatureItemService productFeatureItemService ;

    @Autowired
    ProductFeatureItemsService productFeatureItemsService ;

    @RequestMapping(method = RequestMethod.GET)
    @GetMapping(value = "/list")
    @ResponseBody
    List<ProductFeatureGroup> getListOfProductFeatureGroup(){
        List<ProductFeatureGroup> list = productFeatureGroupService.findAll();
        return list;
    }

    @ResponseBody
    @PostMapping(value = "/save")
    public PTree createProductFeatureGroup(@RequestBody PTree pTree){

        String n = pTree.getTreeData().getName();
        String v = pTree.getTreeData().getValue();
        String productId = pTree.getProductId();

        Product product = productService.findProductById(Long.valueOf(productId));
        ProductFeatureGroup fg = new ProductFeatureGroup(n,v,1);
        fg.setProduct(product);

        ProductFeatureGroup fgs = productFeatureGroupService.save(fg);

        for(int i=0;i<pTree.getTreeData().getChildren().size();i++){
            ProductFeatureTreeDTO pf = pTree.getTreeData().getChildren().get(i);

            ProductFeatureItem pfi = new ProductFeatureItem();
            pfi.setName(pf.getName());
            pfi.setFeatureValue(pf.getValue());
            pfi.setOrders(i);
            pfi.setFeatureGroup(fgs);
            ProductFeatureItem pfis = productFeatureItemService.save(pfi,fgs);

            if(pf.getChildren()!=null)
                for(int j=0;j<pf.getChildren().size();j++){
                    ProductFeatureTreeDTO pfs = pf.getChildren().get(j);
                    ProductFeatureItems pfjs = new ProductFeatureItems();
                    pfjs.setName(pfs.getName());
                    pfjs.setFeatureValue(pfs.getValue());
                    pfjs.setFeatureItem(pfi);
                    pfjs.setOrders(j);
                    productFeatureItemsService.save(pfjs,pfis);
                }
        }
        return pTree;
    }

    @ResponseBody
    @GetMapping("/load")
    public PTree loadProductFeatureGroup(@RequestParam(value = "productId")String productId ){

        PTree pTree = new PTree();
        Product product = productService.findProductById(Long.valueOf(productId));
        pTree.setProductId(productId);

        ProductFeatureGroup pfg = productFeatureGroupService.loadProductFeatureGroupWithProductId(product);
        List<ProductFeatureItem> productFeatureItem =productFeatureItemService.loadProductFeatureItems(pfg);

        ProductFeatureTreeDTO featureTreeDTO = new ProductFeatureTreeDTO();
        featureTreeDTO.setName(pfg.getName());
        featureTreeDTO.setValue(pfg.getFeatureValue());
        pTree.setTreeData(featureTreeDTO);

        for(int i=0;i<productFeatureItem.size();i++){
            List<ProductFeatureTreeDTO> children = new ArrayList<ProductFeatureTreeDTO>();
            ProductFeatureItem pfi =productFeatureItem.get(i);

            ProductFeatureTreeDTO productFeatureDTO =new ProductFeatureTreeDTO(pfi.getName(),pfi.getFeatureValue());
            children.add(productFeatureDTO);

            List<ProductFeatureItems> items = productFeatureItemsService.loadProductFeatureItemsByFeatureItem(pfi);
            for(int j=0;j<items.size();j++){
                List<ProductFeatureTreeDTO> child = new ArrayList<ProductFeatureTreeDTO>();
                ProductFeatureItems pi=items.get(j);
                child.add(new ProductFeatureTreeDTO(pi.getName(),pi.getFeatureValue()));
                productFeatureDTO.setChildren(child);
            }
            featureTreeDTO.setChildren(children);
        }
        return pTree;
    }

    //todo: initialize the product_feature_group at first time when loaded features
    /* also it is a bug from client side or server side
        because when the product is created .. product feature group was not created */
    boolean initializeProductFeatureGroupForProduct(@RequestParam(value = "productId")String productId ){
        Product product = productService.findProductById(Long.valueOf(productId));
        int c = productFeatureGroupService.isThereARecordOnProductFeatureGroupForProduct(product) ;
        if(c==0){
            productFeatureGroupService.save(new ProductFeatureGroup());
        }
        return true ;
    }
}

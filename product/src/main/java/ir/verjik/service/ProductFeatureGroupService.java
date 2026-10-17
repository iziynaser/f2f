package ir.verjik.service;

import ir.verjik.dto.FeaturesDTO;
import ir.verjik.dto.FeaturesDTOImpl;
import ir.verjik.dto.ProductFeatureGroupDTO;
import ir.verjik.entity.Product;
import ir.verjik.entity.ProductFeatureGroup;
import ir.verjik.entity.ProductFeatureItem;
import ir.verjik.entity.ProductFeatureValue;
import ir.verjik.mapper.ProductFeatureMapper;
import ir.verjik.repository.ProductFeatureGroupRepository;
import ir.verjik.repository.ProductFeatureItemRepository;
import ir.verjik.repository.ProductFeatureValueRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductFeatureGroupService {

    private final ProductFeatureGroupRepository groupRepository;
    private final ProductFeatureItemRepository itemRepository;
    private final ProductFeatureValueRepository valueRepository;
    private final ProductFeatureMapper mapper;  // این خط مشکل را رفع می‌کند


    public List<FeaturesDTO> getListOfFeatures(Long productId) {
        List<ProductFeatureGroup> groups = groupRepository.findByProduct_Id(productId);

        List<FeaturesDTO> result = new ArrayList<>();
        for (ProductFeatureGroup group : groups) {
            List<ProductFeatureItem> items = itemRepository.findByFeatureGroupOrderByOrders(group);
            for (ProductFeatureItem item : items) {
                List<ProductFeatureValue> values = valueRepository.findByFeatureItemOrderByOrders(item);
                for (ProductFeatureValue val : values) {
                    FeaturesDTO dto = new FeaturesDTOImpl(
                            group.getId(), group.getName(),
                            item.getId(), item.getName(),
                            val.getId(), val.getName(),
                            val.getFeatureValue()
                    );
                    result.add(dto);
                }
            }
        }
        return result;
    }


    public List<ProductFeatureGroupDTO> findAll() {
        return mapper.toGroupDTOs(groupRepository.findAll());
    }

    public ProductFeatureGroupDTO save(ProductFeatureGroup group) {
        return mapper.toGroupDTO(groupRepository.save(group));
    }

    public ProductFeatureGroupDTO createDefaultGroupForProduct(Product product) {
        ProductFeatureGroup group = new ProductFeatureGroup("مشخصات", "مشخصات", 0);
        group.setProduct(product);
        ProductFeatureGroup saved = groupRepository.save(group);
        return mapper.toGroupDTO(saved);
    }

    public List<ProductFeatureGroupDTO> loadGroupsForProduct(Product product) {
        List<ProductFeatureGroup> groups = groupRepository.findByProduct_IdOrderByOrders(product.getId());
        return mapper.toGroupDTOs(groups);
    }

    public boolean hasGroupForProduct(Product product) {
        return groupRepository.existsByProduct(product);
    }
}

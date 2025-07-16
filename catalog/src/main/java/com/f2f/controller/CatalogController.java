import com.f2f.dbc.dto.CatalogDto;
import com.f2f.dto.ProductDTO;
import com.f2f.entity.Catalog;
import com.f2f.service.CatalogService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/catalog")
public class CatalogController {

    private final CatalogService catalogService;

    public CatalogController(CatalogService catalogService) {
        this.catalogService = catalogService;
    }

    // ایجاد کاتالوگ جدید
//    @PostMapping
//    public ResponseEntity<Catalog> createCatalog(@RequestParam String name) {
//        Catalog created = catalogService.createCatalog(name);
//        return ResponseEntity.status(201).body(created);
//    }

    // اضافه کردن محصول به کاتالوگ
    @PostMapping("/{catalogId}/products/{productId}")
    public ResponseEntity<Catalog> addProductToCatalog(@PathVariable Long catalogId, @PathVariable Long productId) {
        Catalog updated = catalogService.addProductToCatalog(catalogId, productId);
        return ResponseEntity.ok(updated);
    }

    // حذف محصول از کاتالوگ
    @DeleteMapping("/{catalogId}/products/{productId}")
    public ResponseEntity<Catalog> removeProductFromCatalog(@PathVariable Long catalogId, @PathVariable Long productId) {
        Catalog updated = catalogService.removeProductFromCatalog(catalogId, productId);
        return ResponseEntity.ok(updated);
    }

    // دریافت کاتالوگ بر اساس شناسه
    @GetMapping("/{id}")
    public ResponseEntity<Catalog> getCatalogById(@PathVariable Long id) {
        return catalogService.getCatalogById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // دریافت همه کاتالوگ‌ها (فقط DTO شامل id و name)
    @GetMapping
    public ResponseEntity<List<CatalogDto>> getAllCatalogs() {
        List<CatalogDto> catalogs = catalogService.getAllCatalogs();
        return ResponseEntity.ok(catalogs);
    }

    // حذف کاتالوگ
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCatalog(@PathVariable Long id) {
        catalogService.deleteCatalog(id);
        return ResponseEntity.noContent().build();
    }

    // دریافت لیست محصولات یک کاتالوگ
    @GetMapping("/{catalogId}/products")
    public ResponseEntity<List<ProductDTO>> getCatalogProducts(@PathVariable Long catalogId) {
        List<ProductDTO> products = catalogService.getProductsByCatalogId(catalogId);
        return ResponseEntity.ok(products);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Catalog> update(@PathVariable Long id, @RequestBody CatalogDto dto) {
        Catalog updated = catalogService.updateCatalog(id, dto);
        return ResponseEntity.ok(updated);
    }


}

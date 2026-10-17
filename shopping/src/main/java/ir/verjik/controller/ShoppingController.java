package ir.verjik.controller;

import ir.verjik.service.ShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/shopping")
public class ShoppingController {

    @Autowired
    private ShoppingCartService shoppingCartService;

    @PostMapping("/complete/{customerId}")
    public ResponseEntity<String> completeShopping(@PathVariable Long customerId) {
        shoppingCartService.completeShopping(customerId);
        return ResponseEntity.ok("Shopping completed successfully.");
    }
}

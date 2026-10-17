package ir.verjik.service;

import ir.verjik.dao.ShoppingCartRepository;
import ir.verjik.dao.ShoppingRepository;
import ir.verjik.entity.Shopping;
import ir.verjik.entity.ShoppingCart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
public class ShoppingServiceImpl implements ShoppingCartService {

    @Autowired
    private ShoppingCartRepository cartRepo;

    @Autowired
    private ShoppingRepository shoppingRepo;

    @Override
    @Transactional
    public void completeShopping(Long customerId) {
        // سبد فعال را پیدا کن
        ShoppingCart cart = cartRepo.findByCustomerIdAndStatus(customerId, "ACTIVE")
                .orElseThrow(() -> new RuntimeException("No active cart"));

        if (cart.getItems() == null || cart.getItems().isEmpty())
            throw new RuntimeException("Cart is empty");

        // ایجاد رکورد جدید Shopping
        Shopping shopping = new Shopping();
        shopping.setCustomer(cart.getCustomer());
        shopping.setShoppingCart(cart);
        shopping.setStartDate(cart.getCreatedDate());
        shopping.setEndDate(LocalDateTime.now());
        shopping.setStatus("COMPLETED");

        // ذخیره خرید
        shoppingRepo.save(shopping);

        // بروز رسانی وضعیت سبد خرید
        cart.setStatus("COMPLETED");
        cart.setLastUpdatedDate(LocalDateTime.now());
        cartRepo.save(cart);
    }
}

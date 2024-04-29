package com.f2f.persistance.product;

<<<<<<< Updated upstream
import com.f2f.dao.product.ProductFeatureGroupDao;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@DataJpaTest
public class ProdcutFeatureGroupTest {

    @Autowired
    ProductFeatureGroupDao productFeatureGroupDao;

    @Test
    public void contextLoad() throws Exception{
        productFeatureGroupDao.findAll();
    }
=======
//@SpringBootTest
//@DataJpaTest
public class ProdcutFeatureGroupTest {

//    @Autowired
//    ProductFeatureGroupDao productFeatureGroupDao;
//
//    @Test
//    public void contextLoad() throws Exception {
//        productFeatureGroupDao.findAll();
//    }
>>>>>>> Stashed changes
}

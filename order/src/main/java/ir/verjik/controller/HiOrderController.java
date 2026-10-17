package ir.verjik.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("HiOrderController")
@RequestMapping("/order")
public class HiOrderController {
    @GetMapping("/hi")
    public String getAccountList(){
        return "hi order";
    }

}

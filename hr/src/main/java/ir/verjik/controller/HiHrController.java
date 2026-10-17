package ir.verjik.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("HiHrController")
@RequestMapping("/hr")
public class HiHrController {
    @GetMapping("/hi")
    public String getAccountList(){
        return "hi hr";
    }
}

package ir.verjik.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;


@Controller
@CrossOrigin("*")
public class F2fController {
    private Logger log = LoggerFactory.getLogger(this.getClass());

    @ResponseBody
    @RequestMapping("/hello")
    public Map<String, Object> info() {
        Map<String, Object> result = new HashMap<>(16);

        log.info("/f2f/hello is called successfully!!");
        result.put("message","this is a test controller");

        return result;
    }
}

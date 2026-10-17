package ir.verjik.controller;

import ir.verjik.entity.Holiday;
import ir.verjik.service.HolidayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController("HolidayController")
@RequestMapping("/Holiday")
public class HolidayController{

    @Autowired
    HolidayService holidayService;

    @GetMapping("/list")
    public List<Holiday> getHolidayList(){
        List<Holiday> list = holidayService.findAll();
        return list;
    }
}

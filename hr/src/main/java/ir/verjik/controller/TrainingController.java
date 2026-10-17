package ir.verjik.controller;

import ir.verjik.entity.Training;
import ir.verjik.service.TrainingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController("TrainingController")
@RequestMapping("/Training")
public class TrainingController{

    @Autowired
    TrainingService trainingService ;

    @GetMapping("/list")
    public List<Training> getTrainingList(){
        List<Training> list = trainingService.findAll();
        return list;
    }
}

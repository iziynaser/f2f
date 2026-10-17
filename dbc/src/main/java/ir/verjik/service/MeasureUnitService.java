package ir.verjik.service;

import ir.verjik.entity.MeasureUnit;
import ir.verjik.repository.MeasureUnitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.expression.ExpressionException;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component("MeasureUnitService")
public class MeasureUnitService {

    @Autowired
    MeasureUnitRepository measureUnitRepository;

    public List<MeasureUnit> findAll(){
        return (List<MeasureUnit>) measureUnitRepository.findAll();
    }

    public MeasureUnit findById(Long id)  throws Exception {
        Optional<MeasureUnit> measureUnitOptional = measureUnitRepository.findById(id);
        return measureUnitOptional.orElseThrow(() -> new ExpressionException("f2f.not.found"));
    }

}

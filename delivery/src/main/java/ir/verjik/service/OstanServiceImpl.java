package ir.verjik.service;

import ir.verjik.dbc.domain.EntityNotFoundException;
import ir.verjik.entity.Ostan;
import ir.verjik.repository.OstanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OstanServiceImpl implements OstanService {

    @Autowired
    private OstanRepository ostanDao;

    @Override
    public List<Ostan> getInfo() {
        return ostanDao.findAll();
    }

    public Ostan getOne(Long id) {
        return ostanDao.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Ostan not found with id: " + id));
    }
}

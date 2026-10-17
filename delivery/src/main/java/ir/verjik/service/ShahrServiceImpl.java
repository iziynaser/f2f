package ir.verjik.service;

import ir.verjik.dbc.domain.EntityNotFoundException;
import ir.verjik.entity.Ostan;
import ir.verjik.entity.Shahr;
import ir.verjik.repository.OstanRepository;
import ir.verjik.repository.ShahrRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShahrServiceImpl implements ShahrService {

    @Autowired
    private ShahrRepository shahrRepository;

    @Autowired
    private OstanRepository ostanRepository;

    @Override
    public List<Shahr> getInfo(Long ostanId) {
        Ostan ostan = ostanRepository.findById(ostanId)
                .orElseThrow(() -> new EntityNotFoundException("Ostan not found with id: " + ostanId));

        return shahrRepository.getAllByOstan(ostan);
    }

    public Shahr getOne(Long id) {
        return shahrRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Shahr not found with id: " + id));
    }
}

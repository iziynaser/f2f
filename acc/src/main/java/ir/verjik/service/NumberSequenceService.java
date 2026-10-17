package ir.verjik.service;


import ir.verjik.entity.NumberSequence;
import ir.verjik.repository.NumberSequenceRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class NumberSequenceService {

    private final NumberSequenceRepository repository;

    public NumberSequenceService(NumberSequenceRepository repository) {
        this.repository = repository;
    }

    public Long next(String key) {

        NumberSequence seq = repository
                .findForUpdate(key)
                .orElseGet(() -> createSequence(key));

        Long next = seq.getLastNumber() + 1;

        seq.setLastNumber(next);

        return next;
    }

    private NumberSequence createSequence(String key) {

        NumberSequence seq = new NumberSequence();
        seq.setSequenceKey(key);
        seq.setLastNumber(0L);

        return repository.save(seq);
    }
}

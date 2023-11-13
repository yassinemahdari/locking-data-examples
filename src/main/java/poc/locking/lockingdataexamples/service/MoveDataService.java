package poc.locking.lockingdataexamples.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import poc.locking.lockingdataexamples.entity.ExampleGeneratedValue;
import poc.locking.lockingdataexamples.entity.MovedGeneratedValue;
import poc.locking.lockingdataexamples.repository.ExampleGeneratedValueRepository;
import poc.locking.lockingdataexamples.repository.MovedGeneratedValueRepository;

import java.util.UUID;

@RequiredArgsConstructor
@Service
@Slf4j
public class MoveDataService {

    private final ExampleGeneratedValueRepository exampleGeneratedValueRepository;
    private final MovedGeneratedValueRepository movedGeneratedValueRepository;

    @Transactional
    public void moveDataValue() {
        ExampleGeneratedValue exampleGeneratedValue;
        Long generatedValue;
        boolean exists;
        int i = 0;
        do {
            exampleGeneratedValue = exampleGeneratedValueRepository.findRandomValue();
            generatedValue = exampleGeneratedValue.getGeneratedValue();
            exists = !movedGeneratedValueRepository.findAllByMovedGeneratedValue(exampleGeneratedValue.getGeneratedValue()).isEmpty();
            i++;
        } while (exists && i < 1000);
        if (!exists && i < 1000) {
            MovedGeneratedValue movedGeneratedValue = new MovedGeneratedValue();
            movedGeneratedValue.setId(UUID.randomUUID().toString());
            movedGeneratedValue.setMovedGeneratedValue(generatedValue);
            movedGeneratedValueRepository.save(movedGeneratedValue);
            exampleGeneratedValue.setUsed("Y");
            exampleGeneratedValueRepository.save(exampleGeneratedValue);
        } else {
            log.error("error to generate value, limit");
        }
    }

}
package poc.locking.lockingdataexamples.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Service;
import poc.locking.lockingdataexamples.entity.ExampleGeneratedValue;
import poc.locking.lockingdataexamples.repository.ExampleGeneratedValueRepository;

import java.util.UUID;

@ConditionalOnProperty(prefix = "lock-examples", value = "execution-mode", havingValue = "init-data")
@Slf4j
@Service
public class InitializeData implements CommandLineRunner {
    private final ExampleGeneratedValueRepository exampleGeneratedValueRepository;

    public InitializeData(ExampleGeneratedValueRepository exampleGeneratedValueRepository) {
        this.exampleGeneratedValueRepository = exampleGeneratedValueRepository;
    }

    @Override
    public void run(String... args) {
        for (int i = 0; i < 1000; i++) {
            ExampleGeneratedValue exampleGeneratedValue = new ExampleGeneratedValue();
            exampleGeneratedValue.setId(UUID.randomUUID().toString());
            exampleGeneratedValue.setGeneratedValue((long) (i + 1));
            exampleGeneratedValue.setUsed("N");
            exampleGeneratedValueRepository.save(exampleGeneratedValue);
        }
    }
}

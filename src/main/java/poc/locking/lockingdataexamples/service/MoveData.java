package poc.locking.lockingdataexamples.service;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Service;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

@ConditionalOnProperty(prefix = "lock-examples", value = "execution-mode", havingValue = "move-data")
@Service
@RequiredArgsConstructor
@Slf4j
public class MoveData implements CommandLineRunner {

    private final MoveDataService moveDataService;
    private final Executor executor = Executors.newFixedThreadPool(100);

    @Override
    public void run(String... args) throws Exception {
        for (int i = 0; i < 1000; i++) {
            executor.execute(moveDataService::moveDataValue);
        }
    }
}

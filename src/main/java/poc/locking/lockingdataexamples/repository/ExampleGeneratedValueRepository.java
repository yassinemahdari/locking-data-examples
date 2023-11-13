package poc.locking.lockingdataexamples.repository;

import jakarta.persistence.LockModeType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import poc.locking.lockingdataexamples.entity.ExampleGeneratedValue;

import java.util.List;

@Repository
public interface ExampleGeneratedValueRepository extends JpaRepository<ExampleGeneratedValue, String> {
    @Lock(LockModeType.PESSIMISTIC_WRITE)
    @Query("from ExampleGeneratedValue where used = 'N' ORDER BY RANDOM() LIMIT 1")
    ExampleGeneratedValue findRandomValue();
}

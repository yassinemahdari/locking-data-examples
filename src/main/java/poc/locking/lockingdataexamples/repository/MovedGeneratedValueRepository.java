package poc.locking.lockingdataexamples.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import poc.locking.lockingdataexamples.entity.MovedGeneratedValue;

import java.util.List;

@Repository
public interface MovedGeneratedValueRepository extends JpaRepository<MovedGeneratedValue, String> {
    List<MovedGeneratedValue> findAllByMovedGeneratedValue(Long value);
}

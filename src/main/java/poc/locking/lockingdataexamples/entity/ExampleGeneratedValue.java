package poc.locking.lockingdataexamples.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.OptimisticLockType;
import org.hibernate.annotations.OptimisticLocking;

import java.io.Serializable;

@Data
@Table(name = "EXAMPLE_GENERATED_VALUE")
@Entity
public class ExampleGeneratedValue implements Serializable {
    @Id
    private String id;
    @Column(name = "generated_value")
    private Long generatedValue;
    private String used;

}

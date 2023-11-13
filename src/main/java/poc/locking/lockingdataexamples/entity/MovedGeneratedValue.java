package poc.locking.lockingdataexamples.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.io.Serializable;

@Data
@Entity
@Table(name = "MOVED_GENERATED_VALUE")
public class MovedGeneratedValue implements Serializable {
    @Id
    private String id;
    @Column(name = "moved_generated_value")
    private Long movedGeneratedValue;
}
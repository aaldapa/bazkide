package eus.euskolorak.bazkide.infraestructure.out.persistence.jpa.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;

/**
 * @author BICUGUAL
 */

@Data
@NoArgsConstructor
@SuperBuilder
@EqualsAndHashCode(callSuper=false)
@Entity
@Table(name = "t_fee_types")
public class FeeTypeEntity extends AuditableEntity{

    @Id
    @Column(name = "id_fee_type")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idFeeType;

    private String feeName;
    private String description;
    private BigDecimal amount;
    private int initialMonth;
    private int periodicity;
}

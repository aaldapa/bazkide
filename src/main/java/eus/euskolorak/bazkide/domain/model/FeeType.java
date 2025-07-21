package eus.euskolorak.bazkide.domain.model;

import eus.euskolorak.bazkide.domain.enums.PeriodicityEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * @author BICUGUAL
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FeeType {

    private Long idFeeType;
    private String feeName;
    private String description;
    private BigDecimal amount;
    private int initialMonth;
    private PeriodicityEnum periodicity;

}

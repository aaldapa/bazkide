package eus.euskolorak.bazkide.domain.ports.out;

import eus.euskolorak.bazkide.domain.model.FeeType;

import java.util.List;
import java.util.Optional;

/**
 * @author BICUGUAL
 */
public interface FeeTypeRepository {

    List<FeeType> findAll();
    Optional<FeeType> findById(Long idFeeType);
    FeeType save(FeeType feeType);
    void delete(FeeType feeType);

}

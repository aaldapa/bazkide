package eus.euskolorak.bazkide.domain.ports.in;

import eus.euskolorak.bazkide.domain.model.FeeType;

import java.util.List;

/**
 * @author BICUGUAL
 */
public interface FeeTypeService {

    List<FeeType> findAll();
    FeeType findById(Long idFeeType);
    FeeType create(FeeType feeType);
    FeeType update(FeeType feeType);
    void delete(Long idFeeType);
}

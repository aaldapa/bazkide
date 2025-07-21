package eus.euskolorak.bazkide.infraestructure.out.persistence.adapters;

import eus.euskolorak.bazkide.domain.model.FeeType;
import eus.euskolorak.bazkide.domain.ports.out.FeeTypeRepository;
import eus.euskolorak.bazkide.infraestructure.out.persistence.jpa.FeeTypeJpaRepository;
import eus.euskolorak.bazkide.infraestructure.out.persistence.jpa.entities.FeeTypeEntity;
import eus.euskolorak.bazkide.infraestructure.out.persistence.jpa.mappers.FeeTypeMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * @author BICUGUAL
 */

@Slf4j
@RequiredArgsConstructor
@Repository
public class FeeTypeRepositoryBDAdapter implements FeeTypeRepository {

    private final FeeTypeJpaRepository jpaRepository;
    private final FeeTypeMapper mapper;

    @Override
    public List<FeeType> findAll() {
        return mapper.toModels(
                jpaRepository.findAll(Sort.by("idFeeType")));
    }

    @Override
    public Optional<FeeType> findById(Long idFeeType) {
        return jpaRepository.findById(idFeeType)
                .map(mapper::toModel);
    }

    @Override
    public FeeType save(FeeType feeType) {
        FeeTypeEntity feeTypeEntity = jpaRepository.save(mapper.toEntity(feeType));
        return mapper.toModel(feeTypeEntity);
    }

    @Override
    public void delete(FeeType feeType) {
        jpaRepository.delete(mapper.toEntity(feeType));
    }
}

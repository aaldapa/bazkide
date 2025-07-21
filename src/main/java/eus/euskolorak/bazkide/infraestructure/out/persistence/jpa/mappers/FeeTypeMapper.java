package eus.euskolorak.bazkide.infraestructure.out.persistence.jpa.mappers;

import eus.euskolorak.bazkide.domain.enums.PeriodicityEnum;
import eus.euskolorak.bazkide.domain.model.FeeType;
import eus.euskolorak.bazkide.infraestructure.out.persistence.jpa.entities.FeeTypeEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

/**
 * @author BICUGUAL
 */
@Mapper(componentModel = "spring")
public interface FeeTypeMapper {

    @Mapping(target = "createdOn", ignore = true)
    @Mapping(target = "updatedOn", ignore = true)
    @Mapping(target = "createdBy", ignore = true)
    @Mapping(target = "updatedBy", ignore = true)
    FeeTypeEntity toEntity(FeeType model);

    FeeType toModel(FeeTypeEntity entity);

    List<FeeType> toModels(List<FeeTypeEntity> entities);

    // Conversión de número a enum
    default PeriodicityEnum mapPeriodicity(Integer periodicity) {
        if (periodicity == null) {
            return null;
        }
        return PeriodicityEnum.fromValue(periodicity);
    }

    // Conversión de enum a número
    default Integer mapPeriodicityToInteger(PeriodicityEnum periodicityEnum) {
        if (periodicityEnum == null) {
            return PeriodicityEnum.ANUAL.getValue();
        }
        return periodicityEnum.getValue();
    }

}

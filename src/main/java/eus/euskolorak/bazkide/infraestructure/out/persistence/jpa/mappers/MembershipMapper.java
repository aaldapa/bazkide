package eus.euskolorak.bazkide.infraestructure.out.persistence.jpa.mappers;

import eus.euskolorak.bazkide.domain.model.Membership;
import eus.euskolorak.bazkide.infraestructure.out.persistence.jpa.entities.MembershipEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

/**
 * @author BICUGUAL
 */
@Mapper(componentModel = "spring", uses = {MemberMapper.class, FeeTypeMapper.class})
public interface MembershipMapper {

    @Mapping(target = "createdOn", ignore = true)
    @Mapping(target = "updatedOn", ignore = true)
    @Mapping(target = "createdBy", ignore = true)
    @Mapping(target = "updatedBy", ignore = true)
    MembershipEntity toEntity(Membership model);

    Membership toModel(MembershipEntity entity);

    List<Membership> toModels(List<MembershipEntity> entities);

}

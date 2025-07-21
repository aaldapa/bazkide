package eus.euskolorak.bazkide.infraestructure.out.persistence.jpa.mappers;

import eus.euskolorak.bazkide.domain.model.Role;
import eus.euskolorak.bazkide.infraestructure.out.persistence.jpa.entities.RoleEntity;
import org.mapstruct.Mapper;

/**
 * @author BICUGUAL
 */
@Mapper(componentModel = "spring")
public interface RoleMapper {

    Role toModel(RoleEntity entity);
}

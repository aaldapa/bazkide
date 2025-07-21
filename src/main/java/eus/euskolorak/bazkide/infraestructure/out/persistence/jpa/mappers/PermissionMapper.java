package eus.euskolorak.bazkide.infraestructure.out.persistence.jpa.mappers;

import eus.euskolorak.bazkide.domain.model.Permission;
import eus.euskolorak.bazkide.infraestructure.out.persistence.jpa.entities.PermissionEntity;
import org.mapstruct.Mapper;

/**
 * @author BICUGUAL
 */
@Mapper(componentModel = "spring")
public interface PermissionMapper {

    Permission toModel(PermissionEntity entity);

}

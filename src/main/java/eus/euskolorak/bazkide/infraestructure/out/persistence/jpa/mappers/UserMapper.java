package eus.euskolorak.bazkide.infraestructure.out.persistence.jpa.mappers;

import eus.euskolorak.bazkide.domain.model.User;
import eus.euskolorak.bazkide.infraestructure.out.persistence.jpa.entities.UserEntity;
import org.mapstruct.Mapper;

/**
 * @author BICUGUAL
 */
@Mapper(componentModel = "spring")
public interface UserMapper {

    User toModel(UserEntity entity);

}

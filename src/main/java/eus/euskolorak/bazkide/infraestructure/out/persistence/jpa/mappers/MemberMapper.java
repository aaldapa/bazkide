package eus.euskolorak.bazkide.infraestructure.out.persistence.jpa.mappers;

import eus.euskolorak.bazkide.domain.model.Member;
import eus.euskolorak.bazkide.infraestructure.out.persistence.jpa.entities.MemberEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

/**
 * @author BICUGUAL
 */
@Mapper(componentModel = "spring")
public interface MemberMapper {

    @Mapping(target = "contactData.phone1", source = "phone1")
    @Mapping(target = "contactData.phone2", source = "phone2")
    @Mapping(target = "contactData.email", source = "email")
    @Mapping(target = "contactData.address", source = "address")
    Member toModel(MemberEntity entity);

    @Mapping(target = "phone1", source = "contactData.phone1")
    @Mapping(target = "phone2", source = "contactData.phone2")
    @Mapping(target = "email", source = "contactData.email")
    @Mapping(target = "address", source = "contactData.address")
    @Mapping(target = "createdOn", ignore = true)
    @Mapping(target = "updatedOn", ignore = true)
    @Mapping(target = "createdBy", ignore = true)
    @Mapping(target = "updatedBy", ignore = true)
    MemberEntity toEntity(Member model);

    List<Member> toModels(List<MemberEntity> entities);
    List<MemberEntity> toEntities(List<Member> models);

}

package one.digitalinovation.personapi.Mapper;

import one.digitalinovation.personapi.DTO.request.PersonDTO;
import one.digitalinovation.personapi.Entity.Person;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface PersonMapper {

    PersonMapper INSTANCE = Mappers.getMapper(PersonMapper.class);

    @Mapping(target = "birthDate", source = "birthDate", dateFormat = "dd-MM-yyyy")

    Person toModel(PersonDTO personDTO);

    PersonDTO toDTO(Person person);

}

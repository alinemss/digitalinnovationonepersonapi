package one.digitalinovation.personapi.Service;


import one.digitalinovation.personapi.DTO.MessageResponseDTO;
import one.digitalinovation.personapi.DTO.request.PersonDTO;
import one.digitalinovation.personapi.Entity.Person;
import one.digitalinovation.personapi.Mapper.PersonMapper;
import one.digitalinovation.personapi.Repository.PersonRepository;
import one.digitalinovation.personapi.exception.PersonNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PersonService {


    @Autowired
    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public MessageResponseDTO createPerson(PersonDTO personDTO){

        Person personToSave = personMapper.toModel(personDTO);


        //pq usar o MessageResponse?
        Person savedPerson = personRepository.save(personToSave);
        return createMessageResponse(savedPerson.getId(), "Created User ID ");

    }

    public List<PersonDTO> listALl() {
        List<Person> allUsers = personRepository.findAll();
        return allUsers.stream()
                .map(personMapper::toDTO)
                .collect(Collectors.toList());
    }


    public PersonDTO findById(Long id) throws PersonNotFoundException {
        Person person = verifyIfExist(id);
        //Optional<Person> dataPerson = personRepository.findById(id);
        //if (dataPerson.isEmpty()){
        //    throw new PersonNotFoundException(id);
        ///}
        return personMapper.toDTO(person);

    }

    public void delete(Long id) throws PersonNotFoundException {
        verifyIfExist(id);

        personRepository.deleteById(id);

    }

    public MessageResponseDTO updateById(Long id, PersonDTO personDTO) throws PersonNotFoundException {

        verifyIfExist(id);

        Person personToUpdate = personMapper.toModel(personDTO);

        //pq usar o MessageResponse?
        Person updatedPerson = personRepository.save(personToUpdate);
        return createMessageResponse(updatedPerson.getId(), "Updated User ID ");

    }

    private PersonRepository personRepository;

    private final PersonMapper personMapper = PersonMapper.INSTANCE;


    private MessageResponseDTO createMessageResponse(Long id, String message) {
        return MessageResponseDTO
                .builder()
                .message(message + id)
                .build();
    }

    private Person verifyIfExist(Long id) throws PersonNotFoundException {
        return personRepository.findById(id)
                .orElseThrow(() -> new PersonNotFoundException(id));
    }

}

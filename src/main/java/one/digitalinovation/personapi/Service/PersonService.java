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
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PersonService {

    private PersonRepository personRepository;

    private final PersonMapper personMapper = PersonMapper.INSTANCE;

    @Autowired
    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public MessageResponseDTO createPerson(PersonDTO personDTO){

        Person personToSave = personMapper.toModel(personDTO);


        //pq usar o MessageResponse?
        Person savedPerson = personRepository.save(personToSave);
        return MessageResponseDTO
                .builder()
                .message("Created User ID " + savedPerson.getId())
                .build();

    }


    public List<PersonDTO> listALl() {
        List<Person> allUsers = personRepository.findAll();
        return allUsers.stream()
                .map(personMapper::toDTO)
                .collect(Collectors.toList());
    }

    private Person verifyIfExist(Long id) throws PersonNotFoundException {
        return personRepository.findById(id)
                .orElseThrow(() -> new PersonNotFoundException(id));
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
}

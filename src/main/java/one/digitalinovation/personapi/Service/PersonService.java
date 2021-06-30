package one.digitalinovation.personapi.Service;


import one.digitalinovation.personapi.DTO.MessageResponseDTO;
import one.digitalinovation.personapi.Entity.Person;
import one.digitalinovation.personapi.Repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService {

    private PersonRepository personRepository;

    @Autowired
    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public MessageResponseDTO createPerson(Person person){

        //pq usar o MessageResponse?
        Person savedPerson = personRepository.save(person);
        return MessageResponseDTO
                .builder()
                .message("Created User ID " + savedPerson.getId())
                .build();

    }



}

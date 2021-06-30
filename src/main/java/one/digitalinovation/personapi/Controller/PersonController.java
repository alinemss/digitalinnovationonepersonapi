package one.digitalinovation.personapi.Controller;

import one.digitalinovation.personapi.DTO.MessageResponseDTO;
import one.digitalinovation.personapi.Service.PersonService;
import one.digitalinovation.personapi.Entity.Person;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/v1/usuario")
public class PersonController {


    private PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MessageResponseDTO createPerson(@RequestBod Person person){
        return personService.createPerson(person);
    }

    @GetMapping
    public  String teste(){
        return "Api Test";
    }

}

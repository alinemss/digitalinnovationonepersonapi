package one.digitalinovation.personapi.Controller;

import one.digitalinovation.personapi.DTO.MessageResponseDTO;
import one.digitalinovation.personapi.DTO.request.PersonDTO;
import one.digitalinovation.personapi.Service.PersonService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@RestController
@RequestMapping("/api/v1/usuario")
public class PersonController {


    private PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MessageResponseDTO createPerson(@RequestBody @Valid PersonDTO personDTO){
        return personService.createPerson(personDTO);

    }

    @GetMapping
    public  String teste(){
        return "Api Test";
    }

}

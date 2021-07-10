package one.digitalinovation.personapi.Controller;

import one.digitalinovation.personapi.DTO.MessageResponseDTO;
import one.digitalinovation.personapi.DTO.request.PersonDTO;
import one.digitalinovation.personapi.Service.PersonService;
import one.digitalinovation.personapi.exception.PersonNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("/api/v1/usuarios")
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
    public List<PersonDTO> listAll(){
        return personService.listALl();
    };

    @GetMapping("/{id}")
    public PersonDTO findById(@PathVariable Long id) throws PersonNotFoundException {
        return personService.findById(id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletedById(@PathVariable Long id) throws PersonNotFoundException {
        personService.delete(id);
    }

}

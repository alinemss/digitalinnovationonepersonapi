package one.digitalinovation.personapi.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table (name = "users")
@Data
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    @Column(unique = true)
    private String cpf;

    @Column()
    private LocalDate birthDate;


    //Fetch utilizado para melhorar a performance, cascade é estrategia de manipulação
    @OneToMany(fetch = FetchType.LAZY, cascade = {CascadeType.MERGE,CascadeType.PERSIST, CascadeType.REMOVE})
    private List<Phone> phones;

}

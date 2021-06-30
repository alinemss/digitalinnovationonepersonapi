package one.digitalinovation.personapi.Entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import one.digitalinovation.personapi.Enum.PhoneType;

import javax.persistence.*;


@Entity
@AllArgsConstructor
@Builder
@NoArgsConstructor
@Table (name = "phones")
@Data
public class Phone {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private PhoneType type;

    @Column(nullable = false)
    private String number;

}
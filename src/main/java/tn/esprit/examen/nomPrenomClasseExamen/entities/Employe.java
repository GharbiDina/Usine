package tn.esprit.examen.nomPrenomClasseExamen.entities;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Date;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level= AccessLevel.PRIVATE)
@Entity
public class Employe {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    Long id;
    String nom;
    String prenom;
    Date dateNaissance;
    @Enumerated(EnumType.STRING)
    Sexe sexe;
    @OneToOne
    private Contrat contrat;

}

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
public class Contrat {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    Long id;
    float Salaire;
    @Enumerated(EnumType.STRING)
    TypeContrat type;
    Date dateDebut;
    Date dateFin;
}

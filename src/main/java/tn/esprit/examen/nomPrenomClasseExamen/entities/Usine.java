package tn.esprit.examen.nomPrenomClasseExamen.entities;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;
import java.util.Set;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level= AccessLevel.PRIVATE)
@Entity
public class Usine {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    Long id;
    String nom;
    String adresse;
    int telephone;
    @OneToMany(cascade = CascadeType.ALL)
    private List<Employe> Employes;


}

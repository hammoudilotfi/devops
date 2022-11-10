package tn.esprit.rh.achat.entities;

import java.io.Serializable;
import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OperateurRequestModel implements Serializable{

    public OperateurRequestModel(Long idOperateur, String nom, String prenom, String password) {
        super();
        this.idOperateur = idOperateur;
        this.nom = nom;
        this.prenom = prenom;
        this.password = password;
    }
    private static final long serialVersionUID = 1L;
    private Long idOperateur;
    private String nom;
    private String prenom;
    private String password;
    private Set<Facture> factures;



}

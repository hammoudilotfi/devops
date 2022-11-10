package tn.esprit.rh.achat.services;

import tn.esprit.rh.achat.entities.Fournisseur;
import tn.esprit.rh.achat.entities.FournisseurRequestModel;

import java.util.List;

public interface IFournisseurService {

	List<Fournisseur> retrieveAllFournisseurs();

	Fournisseur addFournisseur(FournisseurRequestModel f);

	void deleteFournisseur(Long id);

	Fournisseur updateFournisseur(FournisseurRequestModel f);

	Fournisseur retrieveFournisseur(Long id);
	
	void assignSecteurActiviteToFournisseur(Long idSecteurActivite, Long idFournisseur);

}

package tn.esprit.rh.achat.services;

import tn.esprit.rh.achat.entities.Produit;
import tn.esprit.rh.achat.entities.ProduitRequestModel;

import java.util.List;

public interface IProduitService {

	List<Produit> retrieveAllProduits();

	Produit addProduit(ProduitRequestModel p);

	void deleteProduit(Long id);

	Produit updateProduit(ProduitRequestModel p);

	Produit retrieveProduit(Long id);

	void assignProduitToStock(Long idProduit, Long idStock);

}

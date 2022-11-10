package tn.esprit.rh.achat.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.rh.achat.entities.Produit;
import tn.esprit.rh.achat.entities.ProduitRequestModel;
import tn.esprit.rh.achat.entities.Stock;
import tn.esprit.rh.achat.repositories.CategorieProduitRepository;
import tn.esprit.rh.achat.repositories.ProduitRepository;
import tn.esprit.rh.achat.repositories.StockRepository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class ProduitServiceImpl implements IProduitService {

	@Autowired
	ProduitRepository produitRepository;
	@Autowired
	StockRepository stockRepository;
	@Autowired
	CategorieProduitRepository categorieProduitRepository;

	@Override
	public List<Produit> retrieveAllProduits() {
		List<Produit> produits =  produitRepository.findAll();
		return produits;
	}

	@Transactional
	public Produit addProduit(ProduitRequestModel p) {
		Produit p1=new Produit((long)p.idProduit,p.codeProduit,p.libelleProduit,p.prix);
		produitRepository.save(p1);
		return p1;
	}

	@Override
	public void deleteProduit(Long produitId) {
		produitRepository.deleteById(produitId);
	}

	@Override
	public Produit updateProduit(ProduitRequestModel p) {
		Produit p1=new Produit((long)p.idProduit,p.codeProduit,p.libelleProduit,p.prix);
		return produitRepository.save(p1);
	}

	@Override
	public Produit retrieveProduit(Long produitId) {
		Produit produit = produitRepository.findById(produitId).orElse(null);
		return produit;
	}

	@Override
	public void assignProduitToStock(Long idProduit, Long idStock) {
		/*Optional<Produit> produit = produitRepository.findById(idProduit);
		Stock stock = stockRepository.findById(idStock).orElse(null);
		produit.setStock(stock);
		produitRepository.save(produit);*/
	}


}
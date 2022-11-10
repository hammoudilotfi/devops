package tn.esprit.rh.achat.entities;

import java.util.Date;
import java.util.Set;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class ProduitRequestModel {

	
	public ProduitRequestModel() {
		super();
	}

	public ProduitRequestModel(Long idProduit, String codeProduit, String libelleProduit, float prix) {
		super();
		this.idProduit = idProduit;
		this.codeProduit = codeProduit;
		this.libelleProduit = libelleProduit;
		this.prix = prix;
	}

	private static final long serialVersionUID = 1L;
	
	public Long idProduit;
	public String codeProduit;
	public String libelleProduit;
	public float prix;
	public Date dateCreation;
	public Date dateDerniereModification;
	public Stock stock;
	public Set<DetailFacture> detailFacture;
	public CategorieProduit categorieProduit;

}

package tn.esprit.rh.achat.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.rh.achat.entities.Operateur;
import tn.esprit.rh.achat.entities.OperateurRequestModel;
import tn.esprit.rh.achat.repositories.OperateurRepository;

import java.util.List;

@Service
public class OperateurServiceImpl implements IOperateurService {

	@Autowired
	OperateurRepository operateurRepository;
	@Override
	public List<Operateur> retrieveAllOperateurs() {
		return (List<Operateur>) operateurRepository.findAll();
	}

	@Override
	public Operateur addOperateur(OperateurRequestModel o ) {
		Operateur o1= new Operateur(o.getIdOperateur(),o.getNom(),o.getPrenom(),o.getPassword());
		operateurRepository.save(o1);
		return o1;
	}

	@Override
	public void deleteOperateur(Long id) {
		operateurRepository.deleteById(id);
		
	}

	@Override
	public Operateur updateOperateur(OperateurRequestModel o) {

		return operateurRepository.save( new Operateur(o.getIdOperateur(),o.getNom(),o.getPrenom(),o.getPassword()));

	}

	@Override
	public Operateur retrieveOperateur(Long id) {
		return operateurRepository.findById(id).orElse(null);

	}

}

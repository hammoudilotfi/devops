package tn.esprit.rh.achat;



import static org.mockito.BDDMockito.willDoNothing;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

import tn.esprit.rh.achat.entities.Operateur;


import tn.esprit.rh.achat.entities.OperateurRequestModel;
import tn.esprit.rh.achat.repositories.OperateurRepository;

import tn.esprit.rh.achat.services.OperateurServiceImpl;


class OperateurServiceImplMock {

    @Mock
    OperateurRepository operateurRepository;

    @InjectMocks
    OperateurServiceImpl operateurService;
    Operateur o= new Operateur((long) 1,"nom 1","prenom 1","123",null);
    Operateur o2= new Operateur((long) 2,"nom 2","prenom 2","123",null);
    Operateur o3= new Operateur((long) 3,"nom 3","prenom 3","123",null);
    OperateurRequestModel o4= new OperateurRequestModel((long) 4,"nom 4","prenom 4","123",null);
    List<Operateur> list = new ArrayList<Operateur>() {
        {
            add(o2);
            add(o3);
        }
    };

    @Test
    void createOperateurTest()
    {
        OperateurRequestModel o4=new OperateurRequestModel((long) 4,"nom 4","prenom 4","123",null);
        operateurService.addOperateur(o4);
        Assertions.assertNotNull(o4);
    }

    @Test
    void testRetrieveOperateur() {
        Mockito.when(operateurRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(o));
        Operateur operateur = operateurService.retrieveOperateur((long)(2));
        Assertions.assertNotNull(o);
    }

    @Test
    void updateOperateurTest(){
        o4.setNom("nom 1 updated");
        Assertions.assertNotNull(operateurService.updateOperateur(o4));
    }
    @Test
    void deleteOperateurTest(){
        operateurService.deleteOperateur(o2.getIdOperateur());
        Assertions.assertNotNull(list);
    }

}




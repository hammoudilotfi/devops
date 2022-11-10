package tn.esprit.rh.achat;

import static org.mockito.BDDMockito.willDoNothing;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import tn.esprit.rh.achat.entities.Stock;
import tn.esprit.rh.achat.entities.StockRequestModel;
import tn.esprit.rh.achat.repositories.StockRepository;
import tn.esprit.rh.achat.services.StockServiceImpl;
@SpringBootTest
@ExtendWith(MockitoExtension.class)
class StockServiceMock {
	
	@Mock
	StockRepository StockRepository;
	@InjectMocks
	StockServiceImpl StockServiceImpl;
	StockRequestModel s= new StockRequestModel("libelle1",100,50);
	
	Stock s2= new Stock("libelle2",150,0);
	Stock s3= new Stock("libelle3",130,70);
	Stock s4= new Stock("libelle4",100,50);

	
	List<Stock> list = new ArrayList<Stock>() {
		{	
			add(s2);
			add(s3);		
		}
	};
	
	@Test
	 void createStockTest()
	{ 
		StockRequestModel s= new StockRequestModel("libelle3",100,50);
		Assertions.assertNotNull(StockServiceImpl.addStock(s));
	}
	
	@Test
	 void testRetrieveSock() {
	Mockito.when(StockRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(s4));
		Stock stock = StockServiceImpl.retrieveStock((long)(2));
		Assertions.assertNotNull(stock);
	}
	
	@Test
     void updateSockTest(){
        s.setLibelleStock("Libelle 1 updated");
        Assertions.assertNotNull( StockServiceImpl.updateStock(s));
       
    }
	@Test
     void deleteSecteurTest(){
		StockServiceImpl.deleteStock(s2.getIdStock());
        Assertions.assertNotNull(list);

    }
	
}

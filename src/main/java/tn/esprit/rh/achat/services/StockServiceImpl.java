package tn.esprit.rh.achat.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.rh.achat.entities.Stock;
import tn.esprit.rh.achat.repositories.StockRepository;
import tn.esprit.rh.achat.entities.StockRequestModel;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
@Slf4j
public class StockServiceImpl implements IStockService {

	@Autowired
	StockRepository stockRepository;


	@Override
	public List<Stock> retrieveAllStocks() {
		// récuperer la date à l'instant t1
		log.info("In method retrieveAllStocks");
		List<Stock> stocks = stockRepository.findAll();
		for (Stock stock : stocks) {
			log.info(" Stock : " + stock);
		}
		log.info("out of method retrieveAllStocks");
		// récuperer la date à l'instant t2
		// temps execution = t2 - t1
		return stocks;
	}

	@Override
	public Stock addStock(StockRequestModel s) {
		// récuperer la date à l'instant t1
		log.info("In method addStock");
		//(String libelleStock, Integer qte, Integer qteMin)
		Stock s1 = new Stock(s.getLibelleStock(),s.getQte(),s.getQteMin());
		return stockRepository.save(s1);
		
	}

	@Override
	public void deleteStock(Long stockId) {
		log.info("In method deleteStock");
		stockRepository.deleteById(stockId);

	}

	@Override
	public Stock updateStock(StockRequestModel s) {
		Stock s1 = new Stock(s.getLibelleStock(),s.getQte(),s.getQteMin());
		s1.setIdStock(s.getIdStock());
		log.info("In method updateStock");
		return stockRepository.save(s1);
	}

	@Override
	public Stock retrieveStock(Long stockId) {
		long start = System.currentTimeMillis();
		log.info("In method retrieveStock");
		Stock stock = stockRepository.findById(stockId).orElse(null);
		log.info("out of method retrieveStock");
		 long elapsedTime = System.currentTimeMillis() - start;
		log.info("Method execution time: " + elapsedTime + " milliseconds.");

		return stock;
	}

	@Override
	public String retrieveStatusStock() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
		Date now = new Date();
		String msgDate = sdf.format(now);
		String newLine = System.getProperty("line.separator");
		List<Stock> stocksEnRouge =  stockRepository.retrieveStatusStock();
		StringBuilder bld = new StringBuilder();
		for (int i = 0; i < stocksEnRouge.size(); i++) {
			bld.append(newLine+msgDate+":le stock"+stocksEnRouge.get(i).getLibelleStock()+"a une quantité de "
					+" a une quantité de " + stocksEnRouge.get(i).getQte()
					+ " inférieur à la quantité minimale a ne pas dépasser de " + stocksEnRouge.get(i).getQteMin()+newLine);
			

		}
		  String str = bld.toString();
		log.info(str);
		return str;
	}

}
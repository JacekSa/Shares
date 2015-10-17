package com.jacek.stock;

import java.util.Date;
import java.util.List;

import javax.xml.bind.JAXBException;

/**
 * The class
 * 
 * @author Jacek
 *
 */

public class Utilities {
	
	public static List<TradeTransaction> getTradesFromTimeInterval (List<TradeTransaction> trades , int minutes) {

		Date currentTimeStamp = new Date();

		for (TradeTransaction trade : trades) {

			for (Stock s : trade.getStocks()) {

				if (currentTimeStamp.compareTo(s.getTimestamp()) >= minutes) {

					trade.getStocks().remove(s);

				}

			}

		}
		return trades;
	}

	public static boolean validateStockSymbol(String symbol) throws JAXBException {

		boolean validated = false;
		
		TransactionRepository repo = TransactionRepository.getInstance();

		for (Stock s : repo.getStocks().getStocks()) {

			if (s.getSymbol().trim().equals(symbol.trim())) {

				validated = true;
			}

		}
		return validated;

	}

}

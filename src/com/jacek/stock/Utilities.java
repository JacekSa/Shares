package com.jacek.stock;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class Utilities {
	
	public void removeOldTrades(List<TradeTransaction> trades){
		
		Date now = new Date();
		
		for(TradeTransaction trade : trades) {
			
			for(Stock s : trade.getStocks()){
			 
				
				
			}
			
		}
	}

}

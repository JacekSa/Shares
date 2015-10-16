package com.jacek.stock;

import java.util.Date;
import java.util.List;

 /**
  *  The class 
  * 
  * @author Jacek
  *
  */

public class Utilities {
	
	public static void removeOldTrades(List<TradeTransaction> trades){
		
		Date currentTimeStamp = new Date();
		
		for(TradeTransaction trade : trades) {
			
			for(Stock s : trade.getStocks()){
			 
				if(currentTimeStamp.compareTo(s.getTimestamp()) >= 15){
					
					trade.getStocks().remove(s);
					
				}
				
			}
			
		}
	}

}

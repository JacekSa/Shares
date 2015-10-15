package com.jacek.stock;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * The class represents a single trade .
 * @author Jacek
 *
 */

public class TradeTransaction {
	
	List<Stock> stocks;
	
	public List<Stock> getStocks() {
		return stocks;
	}

	public void setStocks(List<Stock> stocks) {
		this.stocks = stocks;
	}

	public TradeTransaction(){
		stocks = new ArrayList<>();
	}
	
	public void addStock(Stock stock) {
	    stocks.add(stock);
	}
	
	
	
}

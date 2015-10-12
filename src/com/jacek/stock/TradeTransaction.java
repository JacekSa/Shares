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
	
	Date timestamp;
	TradeIndicator indicator;
	List<Stock> stocks;
	
	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

	public TradeIndicator getIndicator() {
		return indicator;
	}

	public void setIndicator(TradeIndicator indicator) {
		this.indicator = indicator;
	}

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

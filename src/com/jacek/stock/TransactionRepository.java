package com.jacek.stock;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;	

/**
 * The class emulates a database.
 * The trades are kept in a collection .
 * The repository is a singleton
 * @author Jacek
 *
 */

public class TransactionRepository {
	
	List<TradeTransaction> trades = new ArrayList<>();
	//List<Stock> stocks = new ArrayList<>();
	
    double allSharedIndex ;
	
	public double getAllSharedIndex() {
		return allSharedIndex;
	}


	public void setAllSharedIndex(double d) {
		this.allSharedIndex = d;
	}

	Stocks stocks;
	
	Unmarshaller unmar;
	
	TradeTransaction transaction = null;
	
	
	private TransactionRepository() throws JAXBException{
		
		try{
	
		JAXBContext jc = JAXBContext.newInstance(Stocks.class);
		unmar = jc.createUnmarshaller();
		stocks = (Stocks) unmar.unmarshal(new File("Stocks.xml"));
			
		
			
		
		} catch (JAXBException e) {
			e.printStackTrace();
			
		}
		
	   	
	}
	
	
  public void saveTransaction(){
		
	trades.add(transaction);
			
	}
	
	
    public void saveStock(Stock stock){
		
		/*
		 *  Go through all the stock and find the matching Symbol
		 * 
		 */
		
		for(int i = 0 ; i<stocks.getStocks().size(); i++){
			
			if(stocks.getStocks().get(i).getSymbol().trim().equals(stock.getSymbol().trim())){
				
			   stock.setLastDivident(stocks.getStocks().get(i).getLastDivident());
			   stock.setFixedDividend(stocks.getStocks().get(i).getFixedDividend());
			   stock.setParValue(stocks.getStocks().get(i).getParValue());
			   stock.setType(stocks.getStocks().get(i).getType());
			   transaction.getStocks().add(stock);
			    	
			}
		}
			
	}
	
	
	public void openTransaction(){
		
		transaction = new TradeTransaction();
			
	}
	
	public void closeTransaction(){
		
		trades.add(transaction);
		transaction = null;
		
	}
	
	
	public List<TradeTransaction> getTrades() {
		return trades;
	}


	public void setTrades(List<TradeTransaction> trades) {
		this.trades = trades;
	}


	public Stocks getStocks() {
		return stocks;
	}


	public void setStocks(Stocks stocks) {
		this.stocks = stocks;
	}


	public Unmarshaller getUnmar() {
		return unmar;
	}


	public void setUnmar(Unmarshaller unmar) {
		this.unmar = unmar;
	}

	private static TransactionRepository instance = null;
	
	
	public static TransactionRepository getInstance() throws JAXBException{
		
		if(instance == null){
		
			 instance = new TransactionRepository();
			
			 return instance;
			 
		} else {
			
			 return instance;
		}
		
		 	
	}
	
	
	
	
	
	

}

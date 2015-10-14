package com.jacek.tests;

import static org.junit.Assert.*;

import javax.xml.bind.JAXBException;

import org.junit.Test;

import com.jacek.stock.Stock;
import com.jacek.stock.TradeTransaction;
import com.jacek.stock.TransactionRepository;

public class Tests {

	@Test
	public void testTransactions() throws JAXBException {

		TransactionRepository repo = TransactionRepository.getInstance();
		TradeTransaction transaction = new TradeTransaction();
		repo.openTransaction();

		Stock stock = new Stock();

		stock.setSymbol("TEA");

		repo.saveStock(stock);

		repo.closeTransaction();

		int i = repo.getTrades().size();

		assertTrue(i == 1);

	}
	
	
	
	@Test
	public void testSto() throws JAXBException {

		TransactionRepository repo = TransactionRepository.getInstance();
		
		repo.openTransaction();

		Stock stock = new Stock();

		stock.setSymbol("TEA");

		repo.saveStock(stock);

		repo.closeTransaction();

		int i = repo.getTrades().get(0).getStocks().size();

		assertTrue(i == 2);

	}
	
	

}

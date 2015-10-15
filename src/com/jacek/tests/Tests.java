package com.jacek.tests;

import static org.junit.Assert.*;

import java.math.BigDecimal;

import javax.xml.bind.JAXBException;

import org.junit.Test;

import com.jacek.stock.DataCalculator;
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
	
	@Test
	public void testDividend() throws JAXBException {

		BigDecimal lastDividend = new BigDecimal(134.09);
		BigDecimal price = new BigDecimal(55.02);
		
		BigDecimal result = new BigDecimal(2.437113776808433220487854856184401463085156322);
		
		Stock stock = new Stock();
		stock.setLastDivident(lastDividend);
		stock.setPrice(price);
		
		new DataCalculator().calculateDividendYieldCommon(stock);
		
		assertTrue(new DataCalculator().calculateDividendYieldCommon(stock).setScale(6,BigDecimal.ROUND_UP).equals(result.setScale(6,BigDecimal.ROUND_UP)));

	}
	
	@Test
	public void testGeometricMean() throws JAXBException {

		BigDecimal lastDividend = new BigDecimal(134.09);
		BigDecimal price = new BigDecimal(55.02);
		
		BigDecimal result = new BigDecimal(2.437113776808433220487854856184401463085156322);
		
		Stock stock = new Stock();
		stock.setLastDivident(lastDividend);
		stock.setPrice(price);
		
		new DataCalculator().calculateDividendYieldCommon(stock);
		
		assertTrue(new DataCalculator().calculateDividendYieldCommon(stock).setScale(6,BigDecimal.ROUND_UP).equals(result.setScale(6,BigDecimal.ROUND_UP)));

	}
	
	

}

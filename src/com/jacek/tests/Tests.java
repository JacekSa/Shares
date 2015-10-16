package com.jacek.tests;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBException;

import org.junit.Test;

import com.jacek.stock.DataCalculatorImpl;
import com.jacek.stock.Stock;
import com.jacek.stock.TradeTransaction;
import com.jacek.stock.TransactionRepository;

public class Tests {

	@Test
	public void testTransactions() throws JAXBException {

		TransactionRepository repo = TransactionRepository.getInstance();

		repo.cleanTrades();

		repo.openTransaction();

		Stock stock = new Stock();

		stock.setSymbol("TEA");

		repo.saveStock(stock);

		repo.closeTransaction();

		int i = repo.getTrades().size();

		assertTrue(i == 1);

	}

	@Test
	public void testStock() throws JAXBException {

		TransactionRepository repo = TransactionRepository.getInstance();

		repo.cleanTrades();

		repo.openTransaction();

		Stock stock = new Stock();

		stock.setSymbol("TEA");

		repo.saveStock(stock);

		repo.closeTransaction();

		int i = repo.getTrades().get(0).getStocks().size();

		assertTrue(i == 1);

	}

	@Test
	public void testDividend() throws JAXBException {

		BigDecimal lastDividend = new BigDecimal(134.09);
		BigDecimal price = new BigDecimal(55.02);

		BigDecimal result = new BigDecimal(2.437113776808433220487854856184401463085156322);

		Stock stock = new Stock();
		stock.setLastDivident(lastDividend);
		stock.setPrice(price);

		new DataCalculatorImpl().calculateDividendYieldCommon(stock);

		assertTrue(new DataCalculatorImpl().calculateDividendYieldCommon(stock).setScale(6, BigDecimal.ROUND_UP)
				.equals(result.setScale(6, BigDecimal.ROUND_UP)));

	}

	@Test
	public void testGeometricMean() throws JAXBException {

		ArrayList<Double> list = new ArrayList<>();
		list.add(new Double(4.5));
		list.add(new Double(8.5));

		double result = 6.184658438426491;

		assertTrue(new DataCalculatorImpl().calcGeometricMean(list) == result);

	}

	@Test
	public void testPEratio() {

		Stock stock = new Stock();
		stock.setPrice(new BigDecimal(100));
		stock.setLastDivident(new BigDecimal(100));

		assertTrue(new DataCalculatorImpl().calculatePERatio(stock)
				.equals(new BigDecimal(1).setScale(0, BigDecimal.ROUND_UP)));

	}

	@Test
	public void testVWSP() {

		Stock stock = new Stock();
		stock.setPrice(new BigDecimal(100));
		stock.setLastDivident(new BigDecimal(100));

		Stock stock2 = new Stock();
		stock2.setPrice(new BigDecimal(100));
		stock2.setLastDivident(new BigDecimal(100));

		List<TradeTransaction> trades = new ArrayList<TradeTransaction>();

		TradeTransaction trans = new TradeTransaction();
		trans.addStock(stock);
		trans.addStock(stock2);

		trades.add(trans);

		assertTrue(
				new DataCalculatorImpl().calcVWSP(trades).equals(new BigDecimal(300).setScale(0, BigDecimal.ROUND_UP)));

	}

	// all share index

	@Test
	public void testAllShareIndex() {

		List<TradeTransaction> trades = new ArrayList<>();

		Stock stock = new Stock();
		stock.setPrice(new BigDecimal(100));
		stock.setLastDivident(new BigDecimal(100));

		Stock stock2 = new Stock();
		stock2.setPrice(new BigDecimal(100));
		stock2.setLastDivident(new BigDecimal(100));

		TradeTransaction trans = new TradeTransaction();
		trans.addStock(stock);

		trans.addStock(stock2);

		trades.add(trans);

		assertTrue(new DataCalculatorImpl().calculateAllShareIndex(trades) == 100.00000000000004);

	}

}

package com.jacek.stock;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import com.jacek.abstraction.DataCalculator;

public class InputController {

	Scanner scanner;
	String transactionType;
	String input;
	boolean transactionsFinished;
	DataCalculator calculator = new DataCalculatorImpl();

	TransactionRepository repo = TransactionRepository.getInstance();

	public InputController() throws Exception {

		scanner = new Scanner(System.in);
		System.out.println("Transaction started  :)");

		repo.openTransaction();
		runTransaction();

		while (!transactionsFinished) {

			while (("Y").equals(input)) {

				runTransaction();

			}

			if (("N").equals(input)) {

				System.out.println(input);

				System.out.println("Transaction was closed");

				repo.saveTransaction();
				repo.closeTransaction();

				System.out.println("Open new transaction ? (Insert \"Y\" or \"N\")");
				input = scanner.nextLine();

				if (("Y").equals(input)) {
					continue;
				} else if (("N").equals(input)) {

					transactionsFinished = true;
					System.exit(0);

				}

			}

		}

	}

	public void runTransaction() throws Exception {

		System.out.println("Sell or buy (Insert \"S\" or \"B\") ");
		input = scanner.nextLine();

		if (("S").equals(input)) {
			transactionType = "S";

		} else if (("B").equals(input)) {
			transactionType = "B";

		} else {
			throw new Exception("Unknown transaction type");
		}

		System.out.println("Type in the Stock symbol : ");
		input = scanner.nextLine();
		Stock stock = new Stock();
		stock.setSymbol(input);
		stock.setTimestamp(new Date());

		System.out.println("Type in the Stock price :");
		BigDecimal bdec = new BigDecimal(scanner.nextLine());
		stock.setPrice(bdec);

		if (transactionType.equals("S"))

			stock.setIndicator(TradeIndicator.Sell);

		else if (transactionType.equals("B")) {

			stock.setIndicator(TradeIndicator.Buy);

		}

		/*
		 * Calculate the dividend etc. and save it in a stock object
		 * 
		 */

		stock.setDividentYield(calculator.calculateDividendYieldCommon(stock));
		stock.setPeRatio(calculator.calculatePERatio(stock));

		List<TradeTransaction> trades = repo.getTrades();

		stock.setVolumeWeightedStockPrice(calculator.calcVWSP(trades));

		Utilities.removeOldTrades(trades);

		repo.setAllSharedIndex(calculator.calculateAllShareIndex(trades));

		repo.openTransaction();
		repo.saveStock(stock);
		System.out.println("Continue transaction (Insert \"Y\" or \"N\") ?");
		input = scanner.nextLine();

	}

}

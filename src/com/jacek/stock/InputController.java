package com.jacek.stock;
import java.util.Scanner;

public class InputController {
	
	Scanner scanner;
	String transactionType;
	
	public InputController() throws Exception{
		
		scanner = new Scanner(System.in);
		System.out.println("Transaction started  :)");
		TradeTransaction transaction = new TradeTransaction();
		System.out.println("Sell or buy (Insert \"S\" or \"B\") ");
		String input = scanner.nextLine();
		
		if(("S").equals(input)){
			transactionType = "S";
			
		} else if(("B").equals(input)){
			transactionType = "B";
			
		} else {
			
			throw new Exception("Unknown transaction type");
		}
		
		System.out.println("Type in the Stock symbol :");
		String symbol = scanner.nextLine();
		Stock stock = new Stock();
		stock.setSymbol(symbol);
		TransactionRepository.getInstance(symbol);
		
		
	}
	
    
	

}

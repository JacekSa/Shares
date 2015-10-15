package com.jacek.stock;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.Scanner;

public class InputController {		
	
	Scanner scanner;
	String transactionType;
	String input;
	boolean transactionsFinished;
	TransactionRepository repo = TransactionRepository.getInstance();
	
	public InputController() throws Exception{
		
		scanner = new Scanner(System.in);
		System.out.println("Transaction started  :)");
		
		repo.openTransaction();
		runTransaction();
		
		while(!transactionsFinished){
		
		while(("Y").equals(input)){
			
		runTransaction();
		
		}
			
		  if(("N").equals(input)){
			
			System.out.println(input);
			
			System.out.println("Transaction was closed");
			
			repo.saveTransaction();
			repo.closeTransaction();
			
			
			System.out.println("Open new transaction ? (Insert \"Y\" or \"N\")");
			input = scanner.nextLine();
			
			if(("Y").equals(input)){
			    continue;
			} else if (("N").equals(input)) {
				
				transactionsFinished = true;
				System.exit(0);
				
			}
			
		  }
			
			
			
		}
		
		
	}
	
	
	public void runTransaction() throws Exception{
		
		System.out.println("Sell or buy (Insert \"S\" or \"B\") ");
	    input = scanner.nextLine();
		
		if(("S").equals(input)){
			transactionType = "S";
			
		} else if(("B").equals(input)){
			transactionType = "B";
			
		} else {
			
			throw new Exception("Unknown transaction type");
		}
		
		System.out.println("Type in the Stock symbol : ");
		input = scanner.nextLine();
		Stock stock = new Stock();
		stock.setSymbol(input);
		
		System.out.println("Type in the Stock price :");
		BigDecimal bdec = new BigDecimal(scanner.nextLine());
		stock.setPrice(bdec);
		
		/*
		 * Calculate the dividend etc. and save it in a stock object
		 * 
		 */
		
		
		repo.openTransaction();
		repo.saveStock(stock);
		System.out.println("Continue transaction (Insert \"Y\" or \"N\") ?");
		input = scanner.nextLine();
		
		
		
	}
	
    
	

}

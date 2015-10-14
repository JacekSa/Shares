package com.jacek.stock;

import java.math.BigDecimal;

/**
 *  The class is a utility for performing all
 *  the stock related calculations
 * 
 * @author Jacek
 *
 */


public class DataCalculator {
	
	
	//dividend yield
	//p/eration
	
	public BigDecimal   calculateDividendYieldCommon(Stock stock){
			
		return new BigDecimal(stock.getLastDivident()).divide(stock.getPrice());
			
	}
	
	public BigDecimal   calculateDividendYieldPreffered(Stock stock){
		
		BigDecimal fixDivid = new BigDecimal(stock.getFixedDividend());
		BigDecimal parValue = new BigDecimal(stock.getParValue());
		
		return fixDivid.multiply(parValue).divide(stock.getPrice());
			
	}
	
	public BigDecimal   calculatePERatio(String price ,String dividend ){
		
		BigDecimal priceDecimal = new BigDecimal(price);
		BigDecimal dividendDecimal = new BigDecimal(price);
		
		BigDecimal ratio = priceDecimal.divide(dividendDecimal);
	
		return ratio;
	
	}
	
	
	public BigDecimal   calculateAllShareIndex(){
		return null;
		
		
	}
	
	
	


}

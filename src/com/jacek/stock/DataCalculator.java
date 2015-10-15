package com.jacek.stock;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 *  The class is a utility for performing all
 *  the stock related calculations
 * 
 * @author Jacek
 *
 */


public class DataCalculator {
	
	
	
	public BigDecimal   calculateDividendYieldCommon(Stock stock){
			
		return stock.getLastDivident().divide(stock.getPrice(),RoundingMode.UP);
			
	}
	
	public BigDecimal   calculateDividendYieldPreffered(Stock stock){
		
		BigDecimal fixDivid = new BigDecimal(stock.getFixedDividend());
		BigDecimal parValue = new BigDecimal(stock.getParValue());
		
		return fixDivid.multiply(parValue).divide(stock.getPrice(),RoundingMode.HALF_DOWN);
			
	}
	
	public BigDecimal calculatePERatio(String price ,String dividend ){
		
		BigDecimal priceDecimal = new BigDecimal(price);
		BigDecimal dividendDecimal = new BigDecimal(price);
		
		BigDecimal ratio = priceDecimal.divide(dividendDecimal,RoundingMode.HALF_DOWN);
	
		return ratio;
	
	}
	
	
	public BigDecimal calculateAllShareIndex(){
		
		return null;
		
	}
	
	
	


}

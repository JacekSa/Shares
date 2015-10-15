package com.jacek.stock;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.math3.stat.descriptive.moment.GeometricMean;
import org.apache.commons.math3.stat.descriptive.summary.SumOfLogs;

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
	
	public BigDecimal calculatePERatio(Stock stock){
		
		BigDecimal priceDecimal = stock.getPrice();
		BigDecimal dividendDecimal = stock.getLastDivident();
		
		BigDecimal ratio = priceDecimal.divide(dividendDecimal,RoundingMode.HALF_DOWN);
	
		return ratio;
	
	}
	
	
	public GeometricMean calculateAllShareIndex(List<TradeTransaction> trades){
		
		double[] values;
		ArrayList<Double> list = new ArrayList<>();
		
		for(TradeTransaction trade : trades) {
			
			for(Stock s : trade.getStocks()){
			  list.add(s.getPrice().doubleValue());
			}
			
		}
		
		return calcGeometricMean(list);
		
	}
	
	
	 public BigDecimal calcVWSP(List<TradeTransaction> trades){
			
		  int quantity = 0;
		  int priceQuanSum = 0;
		  int quantitySum = 0;
		  
		  return new  BigDecimal(quantitySum) ;
		  
			
		}
	
	
	
    public GeometricMean calcGeometricMean(ArrayList<Double> list){
		
	    SumOfLogs logs = new SumOfLogs();
	    
	    Double[] stockArr ;
	    stockArr = (Double[]) list.toArray(new Double[list.size()]);
	    
	    logs.evaluate(ArrayUtils.toPrimitive(stockArr) , 0, stockArr.length);
	
		return new GeometricMean(logs);
		
	}
    
    

	


}

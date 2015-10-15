package com.jacek.stock;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.math3.stat.descriptive.moment.GeometricMean;
import org.apache.commons.math3.stat.descriptive.summary.SumOfLogs;

import com.jacek.abstraction.DataCalculator;

/**
 *  The class is a utility for performing all
 *  the stock related calculations
 * 
 * @author Jacek
 *
 */


public class DataCalculatorImpl implements DataCalculator {
	
	
	
	@Override
	public BigDecimal   calculateDividendYieldCommon(Stock stock){
			
		System.out.println(stock.getLastDivident());
		return stock.getLastDivident().divide(stock.getPrice(),RoundingMode.UP);
			
	}
	
	
	@Override
	public BigDecimal   calculateDividendYieldPreffered(Stock stock){
		
		BigDecimal fixDivid = new BigDecimal(stock.getFixedDividend());
		BigDecimal parValue = new BigDecimal(stock.getParValue());
		
		return fixDivid.multiply(parValue).divide(stock.getPrice(),RoundingMode.HALF_DOWN);
			
	}
	
	
	@Override
	public BigDecimal calculatePERatio(Stock stock){
		
		BigDecimal priceDecimal = stock.getPrice();
		BigDecimal dividendDecimal = stock.getLastDivident();
		
		BigDecimal ratio = priceDecimal.divide(dividendDecimal,RoundingMode.HALF_DOWN);
	
		return ratio;
	
	}
	
	
	
	@Override
	public double calculateAllShareIndex(List<TradeTransaction> trades){
		
		ArrayList<Double> list = new ArrayList<>();
		
		for(TradeTransaction trade : trades) {
			
			for(Stock s : trade.getStocks()){
			  list.add(s.getPrice().doubleValue());
			}
			
		}
		
		return calcGeometricMean(list);
		
	}
	
	
	
	@Override
	public BigDecimal calcVWSP(List<TradeTransaction> trades){
			
		  int quantity = 0;
		  BigDecimal priceQuanSum = null ;
		  int quantitySum = 0;
			
		  Integer i = 0;
			for(TradeTransaction trade : trades) {
				
				for(Stock s : trade.getStocks()){
				 
					priceQuanSum = priceQuanSum.add(s.getPrice().multiply(new BigDecimal(i.toString())));
					i++;
				}
				
			}
		 
		 
		  
		  return new  BigDecimal(quantitySum) ;
		  
			
		}
	
    @Override
	public double calcGeometricMean(ArrayList<Double> list){
		
	    SumOfLogs logs = new SumOfLogs();
	    
	    Double[] stockArr ;
	    stockArr = (Double[]) list.toArray(new Double[list.size()]);
	    
	    logs.evaluate(ArrayUtils.toPrimitive(stockArr) , 0, stockArr.length);
	
	    GeometricMean mean = new GeometricMean();
	    
	    mean.setSumLogImpl(logs);
	    
		return mean.getResult();
		
	}
    
    

	


}

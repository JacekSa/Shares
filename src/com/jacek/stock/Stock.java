package com.jacek.stock;

import java.math.BigDecimal;
import java.util.Date;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(namespace = "com.jacek.stock.Stocks")

public class Stock {
	
 BigDecimal price = null;
 BigDecimal dividentYield = null;
 BigDecimal  peRatio = null;
 BigDecimal  volumeWeightedStockPrice = null;
 String  symbol = null;
 String type;
 BigDecimal lastDivident;
 String fixedDividend;
 String parValue;
 
 Date timestamp;
 TradeIndicator indicator;
 
 public BigDecimal getVolumeWeightedStockPrice() {
	return volumeWeightedStockPrice;
}

public void setVolumeWeightedStockPrice(BigDecimal volumeWeightedStockPrice) {
	this.volumeWeightedStockPrice = volumeWeightedStockPrice;
}


public Date getTimestamp() {
	return timestamp;
}

public void setTimestamp(Date timestamp) {
	this.timestamp = timestamp;
}

public TradeIndicator getIndicator() {
	return indicator;
}

public void setIndicator(TradeIndicator indicator) {
	this.indicator = indicator;
}

public String getType() {
	return type;
}
	
@XmlElement 
public void setType(String type) {
	this.type = type;
}
public BigDecimal getLastDivident() {
	return lastDivident;
}

@XmlElement 
public void setLastDivident(BigDecimal lastDivident) {
	this.lastDivident = lastDivident;
}


public String getFixedDividend() {
	return fixedDividend;
}

@XmlElement 
public void setFixedDividend(String fixedDividend) {
	this.fixedDividend = fixedDividend;
}
public String getParValue() {
	return parValue;
}

@XmlElement 
public void setParValue(String parValue) {
	this.parValue = parValue;
}
	

 
public String getSymbol() {
	return symbol;
}

@XmlElement 
public void setSymbol(String symbol) {
	this.symbol = symbol;
}
public BigDecimal getDividentYield() {
	return dividentYield;
}
public void setDividentYield(BigDecimal dividentYield) {
	this.dividentYield = dividentYield;
}
public BigDecimal getPeRatio() {
	return peRatio;
}
public void setPeRatio(BigDecimal peRatio) {
	this.peRatio = peRatio;
}
public BigDecimal getPrice() {
	return price;
}
public void setPrice(BigDecimal price) {
	this.price = price;
}
	

}

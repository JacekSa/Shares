package com.jacek.stock;

import java.math.BigDecimal;

import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlAccessType;


@XmlRootElement(namespace = "com.jacek.stock.Stocks")

public class Stock {
	
 BigDecimal price = null;
 BigDecimal dividentYield = null;
 BigDecimal  peRatio = null;
 String  symbol = null;
 
 String type;
	String lastDivident;
	String fixedDividend;
	String parValue;

 
 
	public String getType() {
	return type;
}
	
@XmlElement 
public void setType(String type) {
	this.type = type;
}
public String getLastDivident() {
	return lastDivident;
}

@XmlElement 
public void setLastDivident(String lastDivident) {
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
	
 // shares , buy or sell indicator , traded price .
 
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

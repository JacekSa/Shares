package com.jacek.stock;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlAccessType;


/**
 *  The class is mapped to an XML file containing
 *  the stocks
 * 
 * @author Jacek
 *
 */

@XmlRootElement(name="stocks")
public class Stocks {
	
	
	List<Stock> stock = null;

	public List<Stock> getStocks() {
		return stock;
	}

	
	@XmlElement(name = "stock")
	public void setStocks(List<Stock> stocks) {
		this.stock = stocks;
	}
	

}

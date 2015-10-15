package com.jacek.abstraction;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.jacek.stock.Stock;
import com.jacek.stock.TradeTransaction;

public interface DataCalculator {

	BigDecimal calculateDividendYieldCommon(Stock stock);

	BigDecimal calculateDividendYieldPreffered(Stock stock);

	BigDecimal calculatePERatio(Stock stock);

	double calculateAllShareIndex(List<TradeTransaction> trades);

	BigDecimal calcVWSP(List<TradeTransaction> trades);

	double calcGeometricMean(ArrayList<Double> list);

}
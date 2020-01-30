package com.ge.icfp.util;

import java.util.Comparator;

import com.ge.icfp.model.MDM.CashPool;

public class CashPoolSortByCountry  implements Comparator{
	public int compare(Object object1, Object object2)
	{
		CashPool cashPool1 = (CashPool) object1;
		CashPool cashPool2 = (CashPool) object2;
 		return cashPool1.getCountry().compareTo(cashPool2.getCountry());
	}
}

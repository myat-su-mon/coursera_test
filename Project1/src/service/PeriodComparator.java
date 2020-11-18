package service;

import java.util.Comparator;

import view.TimetableView;

public class PeriodComparator implements Comparator<TimetableView>{

	@Override
	public int compare(TimetableView o1, TimetableView o2) {
		return o1.getViewPeriod().compareTo(o2.getViewPeriod());
	}
	
}

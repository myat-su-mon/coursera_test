package service;

import java.util.Comparator;

import view.TimetableView;

public class ComplexComparator implements Comparator<TimetableView>{
	
	private DayComparator dayComparator;
	private PeriodComparator periodComparator;
	
	public ComplexComparator(Class<DayComparator> class1, Class<PeriodComparator> class2) {
		this.dayComparator = new DayComparator();
		this.periodComparator = new PeriodComparator();
	}

	@Override
	public int compare(TimetableView o1, TimetableView o2) {
		int comparisonByDay = dayComparator.compare(o1, o2);
		
		if (comparisonByDay == 0) {
			return periodComparator.compare(o1, o2);
		} else {
			return comparisonByDay;
		}
	}

}

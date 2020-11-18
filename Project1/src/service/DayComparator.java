package service;

import java.util.Comparator;

import view.TimetableView;

public class DayComparator implements Comparator<TimetableView>{

	@Override
	public int compare(TimetableView o1, TimetableView o2) {
		return o1.getViewDay().compareTo(o2.getViewDay());
	}

}

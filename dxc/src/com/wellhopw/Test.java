package com.wellhopw;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Test {
	public static void main(String[] args) {
		int year = 2020;
		Calendar c = new GregorianCalendar();
		c.set(Calendar.YEAR, year);
		c.set(Calendar.MONTH, 0);
		c.set(Calendar.DAY_OF_YEAR, 1);
		c.set(Calendar.DAY_OF_WEEK,Calendar.SUNDAY);
		int days = getYearDates(year);
        //计算第一个周日
		int weekCount = 0;
		int start = c.get(Calendar.DAY_OF_YEAR)%7;
		if (start == 0) {
			start = 7;
		}
		List<Map<String, Object>> allList = new ArrayList<>();
		List<String> list = new ArrayList<String>();
		Format f = new SimpleDateFormat("yyyy-MM-dd");
		for (int i = start; i <= days; i++) {
			c.set(Calendar.DAY_OF_YEAR, i);
			String format = f.format(c.getTime());
			if (i%7 == start%7) {//周日
				weekCount ++;
				if (weekCount != 1) {
					String timeNode = null;
					if ((weekCount-1) < 10) {
						timeNode = "W0" + (weekCount-1);
					} else {
						timeNode = "W" + (weekCount-1);
					}
					Map<String, Object> retMap = new HashMap<>();
					retMap.put("timeNode", timeNode);
					retMap.put("list", list);
					allList.add(retMap);
					list = new ArrayList<>();
				}
				list.add(format);
			} else {
				list.add(format);
			}
			if (days == i) {
				Map<String, Object> retMap = new HashMap<>();
				retMap.put("timeNode", "W" + weekCount);
				retMap.put("list", list);
				allList.add(retMap);
			}
		}
		for (Map<String, Object> obj : allList) {
			System.out.println(obj.get("timeNode") + ":" + obj.get("list"));
		}
		
	}
	
	private static int getYearDates(int year){
		if ((year%4 == 0 && year%100 != 0) || year%400 == 0) {
			return 366;
		}
		return 365;
	}
	
}

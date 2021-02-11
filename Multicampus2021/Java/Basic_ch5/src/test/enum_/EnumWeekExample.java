package test.enum_;

import java.util.Calendar;

public class EnumWeekExample {

	public static void main(String[] args) {
		Week today = null;
		
		Calendar cal = Calendar.getInstance();
		int week = cal.get(Calendar.DAY_OF_WEEK);
		System.out.println(week); // 6: 금요일 
		
		switch(week) {
		case 1:
			today = Week.SUN; break;
		case 2:
			today = Week.MON; break;
		case 3:
			today = Week.TUE; break;
		case 4:
			today = Week.WED; break;
		case 5:
			today = Week.THU; break;
		case 6:
			today = Week.FRI; break;
		case 7:
			today = Week.SAT; break;
			
		}
		System.out.println("오늘 요일: "+today);
		
		if(today == Week.SUN) {
			System.out.println("쉬는 날");
		}else {
			System.out.println("공부");
		}

	}

}

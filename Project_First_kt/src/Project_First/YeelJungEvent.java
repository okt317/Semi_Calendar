package Project_First;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.Date;

public class YeelJungEvent implements ActionListener {
	Calendar		cal				= Calendar.getInstance();
	YeelJungView	yjv				= null;
	YeelJungDialog	searchDialog	= null;
	YJattendance yja = null;
	ChulGyul cg = null;
	MemberDao md = null;
	int date = 0;

	public YeelJungEvent(YeelJungView yjv) {
		this.yjv = yjv;
	}
	
	public YeelJungEvent(YJattendance yja) {
		this.yja=yja;
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		Object obj = ae.getSource();
		MemberDao md = new MemberDao();
		

		if (obj == yjv.jbtn_left) {
			yjv.month--;

			if (yjv.month < 1) {
				yjv.month = 12;
				yjv.year--;
			}
			yjv.RefreshDate();
		}

		if (obj == yjv.jbtn_right) {
			yjv.month++;

			if (yjv.month > 12) {
				yjv.month = 1;
				yjv.year++;
			}
			yjv.RefreshDate();

		}
		if (obj == yjv.jbtn_search) {
			searchDialog = new YeelJungDialog();
		}
		
		if (obj == yjv.jbtn_in) {
			System.out.println("출근");
		}
		
		
		if (obj == yjv.jbtn_attendance) {
			System.out.println(yjv.ID+" "+yjv.name+" "+ yjv.year+" "+yjv.month);
			cg = new ChulGyul(yjv.ID,yjv.name, yjv.year, yjv.month);
		}
		for(int i=0;i<yjv.jbtn_nalja.length;i++) {
			
			if (obj == yjv.jbtn_nalja[i]) {
				date = i-yjv.dayweek+2;
				System.out.println(yjv.month+"월"+date+"일 일정 오픈");
				YJattendance yjt= new YJattendance(yjv.ID,yjv.year,yjv.month,date);
				
			}
		}
		
	}

}

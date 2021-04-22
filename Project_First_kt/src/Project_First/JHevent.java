package Project_First;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Calendar;
import java.util.Date;

public class JHevent implements ActionListener, MouseListener {
	Calendar		cal				= Calendar.getInstance();
	JHcalendar	ylv				= null;
	int	dayOfWeek	= cal.get(Calendar.DAY_OF_WEEK);
//	Date date = new Date();

	public JHevent(JHcalendar ylv) {
		this.ylv = ylv;
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		Object obj = ae.getSource();
		

		if (obj == ylv.jbtn_left) {
			ylv.month--;

			if (ylv.month < 1) {
				ylv.month = 12;
				ylv.year--;
			}
			ylv.RefreshDate();
		}

		if (obj == ylv.jbtn_right) {
			ylv.month++;

			if (ylv.month > 12) {
				ylv.month = 1;
				ylv.year++;
			}
			ylv.RefreshDate();

		}
		if (obj == ylv.jbtn_search) {
		}
		
		if (obj == ylv.jbtn_in) {
			cal.getTime();
			System.out.println(cal.getTime());
		}
		
		if (obj == ylv.jbtn_out) {
			System.out.println("퇴근시간:");
		}
		
		if (obj == ylv.jbtn_attendance) {
			System.out.println("이걸 어쩐다요??");
		}
//		if (obj == ylv.jbtn_nalja) {
//			for(int i = 0 ; i <42 ; i++) {
//				ylv.jbtn_nalja[i];
//			}
//			System.out.println("새창이 나온다요??");
//		}
	
//		System.out.println("나석원 바보");
//		System.out.println("형 화이팅 무야호");
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		System.out.println(ylv.num);
		ylv.jbtn_nalja[ylv.num].append("무야");
		// TODO Auto-generated method stub
	}

	@Override
	public void mousePressed(MouseEvent e) {
		System.out.println("유야호");
		if(e.getClickCount()==2) {
			System.out.println("더블 클릭 한거야");
		}
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}

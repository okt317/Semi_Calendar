package Project_First;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.util.Calendar;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class JHcalendar extends JFrame {

	int				j;
	Calendar		cal				= Calendar.getInstance();
	int				year			= 0;
	int				month			= 0;
	int				nowMonth		= 0;
	int				today			= 0;
	JLabel			jlb				= new JLabel();
	JLabel			jlb_void		= new JLabel("      ");
	JLabel			jlb_void2		= new JLabel("      ");
	JLabel			jlb2			= null;
	JPanel			jp_up			= new JPanel(new FlowLayout());
	JPanel			jp_up2			= new JPanel(new GridLayout(1, 7, 3, 3));
	JPanel			jp_up3			= new JPanel(new BorderLayout());
	JPanel			jp_down			= new JPanel(new GridLayout(0, 7, 3, 3));
	JButton			jbtn_in			= new JButton("출근");
	JButton			jbtn_out		= new JButton("퇴근");
	JButton			jbtn_left		= new JButton("◀");
	JButton			jbtn_right		= new JButton("▶");
	JButton			jbtn_search		= new JButton("검색");
	JButton			jbtn_attendance	= new JButton("출결");
	JTextArea[]		jbtn_nalja		= new JTextArea[42];
	String[]		str_yooill		= { "일", "월", "화", "수", "목", "금", "토" };
	JHevent	yje				= null;
	int num = 0;

	public JHcalendar() {
		yje = new JHevent(this);
		initDisplay();
	}

	public void initDisplay() {

		jp_up.add(jbtn_in);
		jp_up.add(jbtn_out);
		jp_up.add(jlb_void);
		jp_up.add(jbtn_left);
		jp_up.add(jlb);
		jp_up.add(jbtn_right);
		jp_up.add(jlb_void2);
		jp_up.add(jbtn_attendance);
		jp_up.add(jbtn_search);

		for (int i = 0; i < 42; i++) {
			jbtn_nalja[i] = new JTextArea("" + (i + 1));
			jbtn_nalja[i].addMouseListener(yje);
			jp_down.add(jbtn_nalja[i]);
		}

		for (int i = 0; i < str_yooill.length; i++) {
			jlb2 = new JLabel(str_yooill[i]);
			jp_up2.add(jlb2);
			jlb2.setHorizontalAlignment(JLabel.CENTER);

			if (i == 0) {
				jlb2.setForeground(Color.red);
			}
			else if (i == 6) {
				jlb2.setForeground(Color.blue);
			}
		}

		jbtn_left.addActionListener(yje);
		jbtn_right.addActionListener(yje);
		jbtn_search.addActionListener(yje);
		jbtn_in.addActionListener(yje);
		jbtn_out.addActionListener(yje);
		jbtn_attendance.addActionListener(yje);
		

		this.setLayout(new BorderLayout());
		jp_up3.add("North", jp_up);
		jp_up3.add("Center", jp_up2);
		this.add("North", jp_up3);
		this.add("Center", jp_down);
		this.setTitle("일정관리");
		this.setSize(550, 400);
		year = cal.get(Calendar.YEAR);
		month = cal.get(Calendar.MONTH) + 1;
		nowMonth = month;
		today = cal.get(Calendar.DATE);
		RefreshDate();
		this.setLocation(50, 150);
		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);

	}

	void RefreshDate() {

		for (int i = 1; i < jbtn_nalja.length; i++) {
			jbtn_nalja[i].setVisible(true);
		}
		jlb.setText(String.format("%s년  %s월", year, month));

		cal.set(Calendar.YEAR, year); // 입력받은 년도로 세팅
		cal.set(Calendar.MONTH, month); // 입력받은 월로 세팅
		cal.set(year, month - 1, 1); // 입력받은 월의 1일로 세팅
		// month는 0이 1월이므로 -1을 해준다

		int	end			= cal.getActualMaximum(Calendar.DATE);	// 해당 월 마지막 날짜
		int	dayOfWeek	= cal.get(Calendar.DAY_OF_WEEK);		// 해당 날짜의 요일(1:일요일 … 7:토요일)

		int	v			= 0;
		num = dayOfWeek-1;
		for (int i = 1; i <= end; i++) {

			if (i == 1) {

				for (int j = 1; j < dayOfWeek; j++) {
					jbtn_nalja[v].setVisible(false);
					v++;
				}
			}

			if (dayOfWeek % 7 == 1) {
				jbtn_nalja[(v + i - 1)].setForeground(Color.red);
			}
			else if (dayOfWeek % 7 == 0) {
				jbtn_nalja[(v + i - 1)].setForeground(Color.blue);
			}

			jbtn_nalja[(v + i - 1)].setText(String.valueOf(i));

			dayOfWeek++;
		}

		for (int i = 0; i < 42 - (v + end); i++) {
			jbtn_nalja[v + end + i].setVisible(false);
//			System.out.println(v +" " +end+" "+ i);
		}
		
	}

//		if (month == nowMonth) {
//
//			for (int i = 1; i < today; i++) {
//				jbtn_nalja[i].setEnabled(false);
//			}//
//		}
//	}

	public static void main(String[] args) {
		new JHcalendar();

	}
}
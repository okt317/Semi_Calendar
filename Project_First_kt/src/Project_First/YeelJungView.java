package Project_First;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.util.Calendar;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableColumnModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

public class YeelJungView extends JFrame {

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
	JPanel			jp_down			= new JPanel(new GridLayout(6, 7, 3, 3));
	JPanel			jp_cal			= new JPanel(new BorderLayout());
	JButton			jbtn_left		= new JButton("◀");
	JButton			jbtn_right		= new JButton("▶");
	JButton			jbtn_search		= new JButton("검색");
	JButton[]		jbtn_nalja		= new JButton[42];
	String[]		str_yooill		= { "일", "월", "화", "수", "목", "금", "토" };
	Calendar		cal				= Calendar.getInstance();
	
	//사이드
	JPanel			jp_side			= new JPanel(new GridLayout(2,1));
	JPanel			jp_side_btt		= new JPanel(new FlowLayout(0,50,1));
	JPanel			jp_profile		= new JPanel(new BorderLayout());
	JPanel			jp_Center		= new JPanel(null);
	JLabel			jlb_profile		= new JLabel("프로필");
	JLabel			jlb_name		= null;
	JButton			jbtn_in			= new JButton("출근");
	JButton			jbtn_attendance	= new JButton("출결");
//	JLabel			avatar			= new JLabel(new ImageIcon("src\\images\\lion11.png"));
	JLabel			avatar			= null;
	
	JPanel			jp_plan			= new JPanel(null);
	JLabel			jlb_plan		= null;
	DefaultTableModel 	dtm = null;
	JTable				jtb = null;
	JScrollPane			jsp = null;
	TableColumn tc1 = null;
	TableColumn tc2 = null;
	DefaultTableColumnModel dtcm = null;
	
	//DB에서 받은 회원의 정보 초기화
	String	ID		= null;
	String	name	= null;
	String	main	= null;
	String	memo	= null;
	int avt = 0;
	int dayweek = 0;
//	int		yy		= 0;
//	int		mm		= 0;
//	int		dd		= 0;
	//인스턴스화
	YeelJungEvent yje 	= null;
	TimeServer 	  ts 	= null;
	TimeClient 	  tc 	= null;
	MemberDao 	  md 	= null;
	
//	public YeelJungView() {
//	yje = new YeelJungEvent(this);
//		initDisplay();
//	}
	public YeelJungView() {}
	public YeelJungView(MemberDao md) {
		this.md = md;
	}
	//
	
	public void initDisplay(String name, String mem_id, int avt) {
		this.avt = avt;
		this.name = name;
		this.ID = mem_id;
		System.out.println(avt+" "+name+" "+ID);
		yje = new YeelJungEvent(this);
		ts = new TimeServer();
		tc = new TimeClient();
		jp_up.add(jlb_void);
		jp_up.add(jbtn_left);
		jp_up.add(jlb);
		jp_up.add(jbtn_right);
		jp_up.add(jlb_void2);
		jp_up.add(jbtn_search);

		for (int i = 0; i < 42; i++) {
			jbtn_nalja[i] = new JButton("" + (i + 1));
			jbtn_nalja[i].addActionListener(yje);
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
		
		switch (avt) {
		case 1:
			avatar	= new JLabel(new ImageIcon("src\\images\\lion22.png"));
			break;
		case 2:
			avatar	= new JLabel(new ImageIcon("src\\images\\lion33.png"));
			break;
		case 3:
			avatar	= new JLabel(new ImageIcon("src\\images\\lion44.png"));
			break;
		case 4:
			avatar	= new JLabel(new ImageIcon("src\\images\\lion55.png"));
			break;
		default:
			avatar	= new JLabel(new ImageIcon("src\\images\\lion11.png"));
			break;
		}
		
		jbtn_left.addActionListener(yje);
		jbtn_right.addActionListener(yje);
		jbtn_search.addActionListener(yje);
		jbtn_in.addActionListener(yje);
		jbtn_attendance.addActionListener(yje);
		
		jlb_profile.setHorizontalAlignment(jlb_profile.CENTER);
		jlb_name = new JLabel(name+"님");
		jp_side_btt.add(jbtn_in);
		jp_side_btt.add(jbtn_attendance);
		avatar.setBounds(30,30,100,108);
		jlb_name.setBounds(160,70,80,20);
		jp_Center.add(avatar);
		jp_Center.add(jlb_name);
		jp_profile.add("North",jlb_profile);
		jp_profile.add("South",jp_side_btt);
		jp_profile.add("Center",jp_Center);
		String cols[] = {"날짜","제목"};
		dtcm = new DefaultTableColumnModel();
		dtm = new DefaultTableModel(new Object[13][2],cols);
		jtb = new JTable(dtm);
		tc1 = new TableColumn(1,40);
		tc2 = new TableColumn(2,50);
		jsp = new JScrollPane(jtb);
//		dtcm.addColumn(tc1);
//		dtcm.addColumn(tc2);
		
		jsp.setBounds(10, 30, 250, 250);
		jlb_plan = new JLabel("이번 달 일정");
		jlb_plan.setBounds(90,0,100,20);
		jp_plan.add(jlb_plan);
		jp_plan.add(jsp);
		
		jp_side.add(jp_profile);
		jp_side.add(jp_plan);
		
		jp_up3.add("North", jp_up);
		jp_up3.add("Center", jp_up2);
		jp_down.setBounds(50, 50, 500, 500);
		jp_cal.add("North", jp_up3);
		jp_cal.add("Center", jp_down);
		this.setLayout(new BorderLayout());
		this.add(jp_cal);
		this.add("East",jp_side);
		
//		this.setTitle(ts.getTimer());
		year = cal.get(Calendar.YEAR);
		month = cal.get(Calendar.MONTH) + 1;
		nowMonth = month;
		today = cal.get(Calendar.DATE);
		RefreshDate();
		this.setTitle("일정관리");
		this.setSize(900,500);
		this.setLocation(510, 250);
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
		dayweek = dayOfWeek;
		int	v			= 0;

//		System.out.println(end);
//		System.out.println(dayOfWeek);
		
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
		}
//		System.out.println(v);
//		System.out.println(dayweek);
	}
		
//		if (month == nowMonth) {
//
//			for (int i = 1; i < today; i++) {
//				jbtn_nalja[i].setEnabled(false);
//			}//
//		}
//	}
	
	public static void main(String[] args) {
		YeelJungView a = new YeelJungView();
		a.initDisplay("강찬영", "test", 0);
		
	}
}

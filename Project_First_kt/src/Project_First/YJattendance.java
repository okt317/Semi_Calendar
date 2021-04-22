package Project_First;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class YJattendance extends JFrame {
	//일정관리 창
	JScrollPane jcrp = null;
	JButton jbtn_new = null;
	JButton jbtn_sav = null;
	JButton jbtn_del = null;
	JButton jbtn_cls = null;
	JPanel jp_button = null;
	JPanel jp_color = null;
	JPanel jp_north = null;
	JLabel jl_title	= null;
	JLabel jl_body 	= null;
	JTextField jtf_title 	= null;
	JTextArea jta_naeyoung 	= null;
	Font font = new Font("돋움체",Font.BOLD,15);
	//체크박스
	JCheckBox[] jcb_color = new JCheckBox[4];
	String a = "업무";
	String b = "개인";
	String c = "휴가";
	String d = "기타";
	String[] col = {a,b,c,d};
	//삭제창
	JDialog jf_sak = null;
	JPanel	jpl_sak	= null;
	JTextField jtf_sak = null;
	JButton jbtn_sak1 = null;
	JButton jbtn_sak2 = null;
	//DB에서 가져올 값
	String ID = null;
	String main = null;
	String memo = null;
	String title = null;
	
	int YY = 0;;
	int MM = 0;
	int DD = 0;;
	//class 인스턴스화
	YeelJungView yjv 	= null;
	YeelJungEvent yje 	= null;
	LoginForm log_form = null;
	MemberDao md = null;
	YJattendanceEvent yjatEvent = null; 
//	public YJattendance(MemberDao md) {
//		this.md = md;
//	}
	public YJattendance (String id,int yy, int mm, int dd) {
		this.ID = id;
		this.YY = yy;
		this.MM = mm;
		this.DD = dd;
		yje = new YeelJungEvent(this);
		md = new MemberDao();
		md.load_memo(ID,YY,MM,DD);
		initDisplay();
	}
	
//	public YJattendance () {
//		yje = new YeelJungEvent(this);
//		initDisplay();
//	}

	private void initDisplay() {
		jl_title 	= new JLabel(" 제목");
		jl_body 	= new JLabel(" 내용");
		jtf_title	= new JTextField();
		jbtn_new 	= new JButton("입력");
		jbtn_sav 	= new JButton();
		jbtn_del 	= new JButton("삭제");
		jbtn_cls 	= new JButton("닫기");
		jta_naeyoung = new JTextArea();
		jp_button 	= new JPanel(new FlowLayout());
		jp_color 	= new JPanel();
		jp_north	= new JPanel(new GridLayout(4,1,2,2));
		jcrp = new JScrollPane(jta_naeyoung,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS
				   ,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		

		
		jp_button.add(jbtn_new);
		jp_button.add(jbtn_sav);
		jp_button.add(jbtn_del);
		jp_button.add(jbtn_cls);
		yjatEvent = new YJattendanceEvent(this);
		
		  for (int i = 0; i < jcb_color.length; i++) {
			  jcb_color[i] = new JCheckBox(col[i]);
			  jp_color.add(jcb_color[i]);
			  jcb_color[i].setBorderPainted(true);
			  jcb_color[i].addItemListener(yjatEvent);
		  }
		
		jbtn_new.addActionListener(yjatEvent);
		jbtn_sav.addActionListener(yjatEvent);
		jbtn_del.addActionListener(yjatEvent);
		jbtn_cls.addActionListener(yjatEvent);
		jta_naeyoung.setLineWrap(true);
		jta_naeyoung.setBackground(Color.white);
		jta_naeyoung.setEditable(false);
		jtf_title.setEditable(false);
		jl_title.setFont(font);
		jl_body.setFont(font);
		jl_body.setBackground(Color.pink);
		jtf_title.setBackground(Color.white);
		jp_north.add(jp_color);
		jp_north.add(jl_title);
		jp_north.add(jtf_title);
		jp_north.add(jl_body);
		this.setLocation(590, 100);
		this.setLayout(new BorderLayout());
		this.add("North",jp_north);
		this.add("Center",jta_naeyoung);
		this.add("South",jp_button);
		this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
		this.setTitle(MM+"월"+DD+"일 일정");
		this.setSize(500, 500);
		this.setLocation(650,250);
		this.setVisible(true);
		if(md.load_memo != null) {
			System.out.println(md.load_memo);
			jta_naeyoung.setText(md.load_memo);
			jtf_title.setText(md.load_title);
		}
		if(jta_naeyoung.getText().trim().length()==0){
			jbtn_sav.setText("저장");
		}
		else {
			jbtn_sav.setText("수정");
		}
	}
	public void Sakje() {
		jf_sak = new JDialog();
		jpl_sak = new JPanel(new FlowLayout(FlowLayout.CENTER));
		jtf_sak = new JTextField("삭제를 하시겠습니까?");
		jtf_sak.setEditable(false);
		jtf_sak.setHorizontalAlignment(jtf_sak.CENTER);
		jbtn_sak1 = new JButton("예");
		jbtn_sak2 = new JButton("아니오");
		jbtn_sak1.addActionListener(yjatEvent);
		jbtn_sak2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent ae) {
				jf_sak.dispose();
				
			}
		});
		jpl_sak.add(jbtn_sak1);
		jpl_sak.add(jbtn_sak2);
		jf_sak.add("Center",jtf_sak);		
		jf_sak.add("South",jpl_sak);
		jf_sak.setLocation(750, 300);
		jf_sak.setTitle("삭제 창");
		jf_sak.setSize(300,150);
		jf_sak.setVisible(true);
		
	}
	public static void main(String[] args) {
		new YJattendance("test",2021,4,2);
	}

	public JCheckBox[] getJcb_color() {
		return jcb_color;
	}
}
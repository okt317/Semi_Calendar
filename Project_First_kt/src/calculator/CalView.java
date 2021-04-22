package calculator;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class CalView extends JFrame {
//	JLabel j_lable = new JLabel();
	JPanel jp_num  = null; // 숫자 창
	JPanel jp_numbtn  = new JPanel();//숫자 버튼
	JPanel jp_plusbtn  = new JPanel();//연산 버튼
	JPanel jp_info   = new JPanel();//기록
	JTextArea jta_display = new JTextArea();
	JTextArea jta_fake = new JTextArea();
	JTextArea jta_info = new JTextArea("여기는 계산 내용이 기록됩니다"+"\n");
	JScrollPane jsp_display = new JScrollPane(jta_display,JScrollPane.VERTICAL_SCROLLBAR_NEVER,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
	JScrollPane jsp_info = new JScrollPane(jta_info,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
	String[] jbtns_num = {"0","1","2","3","4","5","6","7","8","9"};
	String[] jbtns_plus = {"+","-","*","/","=","C"};
	JButton[] jbtns_n = new JButton[jbtns_num.length];
	JButton[] jbtns_p = new JButton[jbtns_plus.length];
	JOptionPane jop   = new JOptionPane();
//	ArrayList<String> alist = new ArrayList<>();
	
	CalEvent CE = new CalEvent(this);
	
	public CalView() {
		initDisplay();
	}
	
	public void initDisplay() {
		jp_num = new JPanel(new BorderLayout());
		jp_info.setLayout(new BorderLayout());
		jp_numbtn.setLayout(new GridLayout(2,5,1,1));
		jp_plusbtn.setLayout(new GridLayout(2,1,1,1));
		jta_display.setFont(new Font("Thoma",Font.BOLD,40));
		jta_info.setFont(new Font("Thoma",Font.BOLD,15));
		for(int i=0;i<jbtns_num.length;i++){
			jbtns_n[i] = new JButton(jbtns_num[i]);
			jp_numbtn.add(jbtns_n[i]);
			jbtns_n[i].setFont(new Font("Thoma",Font.BOLD,30));
			jbtns_n[i].addActionListener(CE);
		}
		for(int i=0;i<jbtns_plus.length;i++){
			jbtns_p[i] = new JButton(jbtns_plus[i]);
			jp_plusbtn.add(jbtns_p[i]);
			jbtns_p[i].setFont(new Font("Thoma",Font.BOLD,20));
			jbtns_p[i].addActionListener(CE);
		}
		jta_info.setEditable(false);
		jta_display.setEditable(false);
		jp_num.add(jsp_display);
		jp_info.add(jsp_info);
		this.add("North",jp_num);
		this.add("South",jp_numbtn);
		this.add("Center",jp_info);
		this.add("East",jp_plusbtn);
		this.setTitle("계산기");
		this.setSize(500, 350);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	

	public static void main(String[] args) {
		new CalView();
	}
}


package Project_First;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Imsi_Calendar implements ActionListener {
	JFrame jf = null;
	JFrame jf_sak = null;
	JPanel	jpl	= null;
	JPanel	jpl_sak	= null;
	JTextField jtf = null;
	JTextField jtf_title = null;
	JTextArea jta = null;
	JButton jbtn_ins = null;
	JButton jbtn_sav = null;
	JButton jbtn_del = null;
	JButton jbtn_cls = null;
	JButton jbtn_sak1 = null;
	JButton jbtn_sak2 = null;
	JButton jbtn_lab = null;
	JScrollPane jcrp = null;
	
	LoginForm log_form = null;
	MemberDao_old md = null;
	
	String ID = null;
	String main = null;
	String memo = null;
	
	String amu = null;
	
	int yy = 2021;
	int mm = 3;
	int dd = 30;
//	
	
public Imsi_Calendar() {}
public Imsi_Calendar(MemberDao_old md) {
	this.md = md;
}
	
	public void initDisplay(String mem_id) {
		jf = new JFrame("일정 창");
		ID = mem_id;
		jcrp = new JScrollPane(jta,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS
								   ,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		jpl = new JPanel();
		jta = new JTextArea();
		jtf_title = new JTextField();
		jpl.setLayout(new GridLayout(1,4,5,5));
		jbtn_lab = new JButton();
		jbtn_ins = new JButton("입력");
		jbtn_sav = new JButton();
		jbtn_del = new JButton("삭제");
		jbtn_cls = new JButton("닫기");
		jpl.add(jbtn_ins);
		jpl.add(jbtn_sav);
		jpl.add(jbtn_del);
		jpl.add(jbtn_cls);
		jbtn_ins.addActionListener(this);
		jbtn_sav.addActionListener(this);
		jbtn_del.addActionListener(this);
		jbtn_cls.addActionListener(this);
		jf.setDefaultCloseOperation(jf.EXIT_ON_CLOSE);
		jta.setEditable(false);
		jf.add(jta);
		jf.add("South",jpl);
		jf.setLocation(500, 100);
		jf.setSize(350,450);
		jf.setVisible(true);
		if(md.load_memo != null) {
			System.out.println(md.load_memo);
			jta.setText(md.load_memo);
			
		}
		if(jta.getText().trim().length()==0){
			jbtn_sav.setText("저장");
		}
		else {
			jbtn_sav.setText("수정");
		}
			
//		amu = md.load_memo;
//		ld = new Loading();
//		ld.loading();
				
		
	}
	
	public void sakje() {
		jf_sak = new JFrame("삭제 창");
		jpl_sak = new JPanel(new FlowLayout(FlowLayout.CENTER));
		jtf = new JTextField("삭제를 하시겠습니까?");
		jtf.setEditable(false);
		jtf.setHorizontalAlignment(jtf.CENTER);
		jbtn_sak1 = new JButton("예");
		jbtn_sak2 = new JButton("아니오");
		jbtn_sak1.addActionListener(this);
		jbtn_sak2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent ae) {
				jf_sak.dispose();
				
			}
		});
		jpl_sak.add(jbtn_sak1);
		jpl_sak.add(jbtn_sak2);
		jf_sak.add("Center",jtf);		
		jf_sak.add("South",jpl_sak);
		jf_sak.setLocation(500, 300);
		jf_sak.setSize(300,150);
		jf_sak.setVisible(true);
		
	}

//	public static void main(String[] args) {
//		new Imsi_Calendar();
//		

//	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		String label = e.getActionCommand();
//		md = new MemberDao();
		if(obj==jbtn_ins) {
			System.out.println(obj);
			jta.setEditable(true);
			
			
		}
		else if((obj==jbtn_sav)&&(
				jta.getText().trim().length()>0)) {
				jta.setEditable(false);
				memo = jta.getText();
				System.out.println(ID+" "+yy+" "+mm+" "+dd+" "+memo);
				String msg = md.cal_ins_sj2(ID,yy,mm,dd,memo);
				System.out.println(msg);
				if("저장".equals(label)) {
					JOptionPane.showMessageDialog(log_form, msg+"님의 일정이 추가되었습니다" );
				}
				else {
					JOptionPane.showMessageDialog(log_form, msg+"님의 일정이 수정되었습니다" );
				}
				jbtn_sav.setText("수정");
		}
		else if((obj==jbtn_del)&&
				jta.getText().trim().length()>0) {
			sakje();
			}
		else if(obj==jbtn_sak1) {
			jta.setText("");
			memo = null;
			System.out.println(ID+" "+yy+" "+mm+" "+dd);
			String msg = md.cal_del(ID,yy,mm,dd);
			System.out.println(msg);
			JOptionPane.showMessageDialog(log_form, msg+"님의 일정이 삭제되었습니다" );
			jf_sak.dispose();
			jbtn_sav.setText("저장");
//			jf.dispose();
//			initDisplay(ID);
//			//삭제 시 버튼명을 다시 수정에서 저장으로 리셋하기 위해서
			}
		else if(("닫기".equals(label))) {
			
			jf.dispose();
//			JButton b = (JButton)e.getSource();
//			if("가자".equals(label)) {
//				System.out.println("싫어");
//				jbtn_cls.setText("닫기");
//			
//			}else {
//				jbtn_cls.setText("가자");
//			}
//			jf.dispose();
			}
		
	}

}

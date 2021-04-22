package Project_First;


import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.DefaultCellEditor;
import javax.swing.DefaultListSelectionModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableColumnModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

public class ChulGyul extends JFrame implements ActionListener {
	//선언부
//	JLabel jlb_inwon = 
//			new JLabel ("ID : ",JLabel.RIGHT);
//	JTextField jtf_inwon = new JTextField(15);
//	JButton jbtn_ins = new JButton("입력");
	JButton jbtn_exit = new JButton("나가기");
//	JPanel jp1 = new JPanel();
	JPanel jp2 = new JPanel();
	JLabel jlb_name =  null;
	JLabel jlb_2 =  null;
	JLabel jlb_year =  null;
	JLabel jlb_4 =  null;
	JLabel jlb_month =  null;
	JLabel jlb_6 =  null;
	JLabel jlb_count =  null;
	DefaultTableModel dtm = null;
	DefaultTableColumnModel dtcm = null;
	DefaultListSelectionModel dlsm = null;
	JTable jt = null;
	JScrollPane jsp = null;
	TableColumn tc = null;
	TableColumn tc1 = null;
	TableColumn tc2 = null;
	DefaultTableCellRenderer dtcr = null;
	DefaultTableCellRenderer dtcr1 = null;
	DefaultTableCellRenderer dtcr2 = null;
	JTextField jtf = null;
	JTextField jtf1 = null;
	JTextField jtf2 = null;

	String name = null;
	String ID = null;
	String year_str = null;
	String mon_str = null;;
	String count = null;;
	int year_int = 2021;
	int mon_int = 4;
	
	ChulGyulDao cgd = null;
	
	ChulGyul(String ID, String name, int yy, int mm){
		this.ID = ID;
		this.name = name;
		this.year_int = yy;
		this.mon_int = mm;
		this.initDisplay();
	}
//	ChulGyul (ChulGyulDao cgd){
//		this.cgd = cgd;
//	}
	//화면처리부
	public void initDisplay(){
		year_str = Integer.toString(year_int);
		mon_str = Integer.toString(mon_int);
		jlb_name  = new JLabel(name);
		jlb_2 	  = new JLabel("님의 ");
		jlb_year  = new JLabel(Integer.toString(year_int));
		jlb_4 	  = new JLabel("년");
		jlb_month = new JLabel(Integer.toString(mon_int));
		jlb_6 	  = new JLabel("월 출석현황 : ");
		jlb_count = new JLabel();
//		jtf_inwon.addActionListener(this);
//		jbtn_ins.addActionListener(this);
		jbtn_exit.addActionListener(this);
//		jp1.setLayout(new FlowLayout());
		jp2.setLayout(new FlowLayout());
//		jp1.add(jlb_inwon);
//		jp1.add(jtf_inwon);
//		jp1.add(jbtn_ins);
		jp2.add(jlb_name);
		jp2.add(jlb_2);
		jp2.add(jlb_year);
		jp2.add(jlb_4);
		jp2.add(jlb_month);
		jp2.add(jlb_6);
		jp2.add(jlb_count);
		jp2.add(jbtn_exit);
//		this.add("North",jp1);
		this.add("South",jp2);
		this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
		this.setTitle("출결관리");
		this.setSize(500,250);
		this.setLocation(700, 250);
		this.setVisible(true);
		logic();
	}
	
		public void logic() {
		dtm = new DefaultTableModel(31,4);
		dtcm = new DefaultTableColumnModel();
		dlsm = new DefaultListSelectionModel();
		jt = new JTable(dtm,dtcm,dlsm);
		jsp = new JScrollPane(jt);
		//날짜
		dtcr = new DefaultTableCellRenderer();
		jtf = new JTextField();
		DefaultCellEditor dce = new DefaultCellEditor(jtf);
		tc = new TableColumn(1,120,dtcr,dce);
		tc.setHeaderValue("날짜");
		dtcm.addColumn(tc);
		//출근시간
		dtcr1 = new DefaultTableCellRenderer();
		jtf1 = new JTextField();
		DefaultCellEditor dce1 = new DefaultCellEditor(jtf);
		tc1 = new TableColumn(2,75,dtcr1,dce1);
		tc1.setHeaderValue("출근시간");
		dtcm.addColumn(tc1);
		//퇴근시간
		dtcr2 = new DefaultTableCellRenderer();
		jtf2 = new JTextField();
		DefaultCellEditor dce2 = new DefaultCellEditor(jtf);
		tc2 = new TableColumn(3,75,dtcr2,dce2);
		tc2.setHeaderValue("퇴근시간");
		dtcm.addColumn(tc2);
		jt.setEnabled(false);
		this.add("Center",jsp);
		this.validate(); 
		this.pack();
//		int a = 0;
//		int b = 0;
//		for(int i=0;i<3;i++){
//			for(int j=0;j<3;j++){
//				a = i;
//				b = j+1;
//				dtm.setValueAt(data[i][j], a, b);
//				
//			}
//		}
		cgd = new ChulGyulDao();
		ArrayList attendlist = new ArrayList<>();
		attendlist = 
				cgd.getChulGyulList(ID,year_int,mon_int);
		for(int i=0;i<cgd.ymd.length;i++){
			dtm.setValueAt(cgd.ymd[i], i, 1);
			dtm.setValueAt(cgd.fst[i], i, 2);
			dtm.setValueAt(cgd.lst[i], i, 3);
				
		}
		count = Integer.toString(cgd.ymd.length);
		jlb_count.setText(count);
	}
	//메인메소드
	public static void main(String[] args) {
		JFrame.setDefaultLookAndFeelDecorated(true);
//		ChulGyul sja = new ChulGyul();
//		sja.initDisplay();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
//		if(	e.getSource()==jtf_inwon ||
//			e.getSource()==jbtn_ins){
//		}////////////// end of if ////////////
		if(e.getSource()==jbtn_exit){
			dispose();
		}
		/*
		else if(e.getSource()==jbtn_account){
			//총점과 석차
			int[][] imsi = new int[num][2];//총점과 석차가 들어갈 공간
			for(int i=0;i<num;i++){
				int tot = Integer.parseInt((String)dtm.getValueAt(i, 2)) 
				         + Integer.parseInt((String)dtm.getValueAt(i, 3))
				         + Integer.parseInt((String)dtm.getValueAt(i, 4));
				float avg = tot / 3.0f;
				char ch = 0 ;//학점
				switch((int)(avg / 10)){
					case 10:
					case 9:  ch = 'A';  break;
					case 8:  ch = 'B';  break;
					case 7:  ch = 'C';  break;
					case 6:  ch = 'D';  break;
					default: ch = 'F';
				}
				dtm.setValueAt(String.valueOf(tot), i, 5);
				dtm.setValueAt(String.valueOf(avg), i, 6);
				dtm.setValueAt(ch + "", i, 7);
				imsi[i][0] = tot;
				imsi[i][1] = 1;//석차를 1로 설정
			}
			//석차를 매겨줌
			for(int i=0;i<num; i++){
				for(int j=0;j<num;j++){
					if(imsi[i][0] < imsi[j][0]){
						imsi[i][1]++;
					}
				}
			}
			for(int i=0;i<num;i++){
				dtm.setValueAt(String.valueOf(imsi[i][1]), i, 8);
			}
			
		}////////////// end of 처리 버튼 구현 */
		/*
		else if(e.getSource()==jbtn_add) {
		String[][] data = {
				 {"홍길동","80","75","85"}
				,{"이성계","90","85","80"}
				,{"강감찬","70","75","70"}
		};
		int a = 0;
		int b = 0;
		for(int i=0;i<3;i++){
			for(int j=0;j<4;j++){
				a = i;
				b = j+1;
				dtm.setValueAt(data[i][j], a, b);
				
				}
			}
		}
		*/
	}////////////////// end of actionPerformed

}
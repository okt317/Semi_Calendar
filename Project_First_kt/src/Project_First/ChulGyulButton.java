package Project_First;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class ChulGyulButton extends JDialog{
	JButton chul = new JButton("출근");
	JButton toi = new JButton("퇴근");
	JPanel jp = new JPanel();
	ChulGyulDao cgd = null;
	YeelJungView yjv = null;
	YeelJungEvent yje = null;
	
	int Y =  0;
	int M =  0;
	int D =  0;
	String now = "";
	
	SimpleDateFormat format1 = 
			new SimpleDateFormat("yyyy MM dd HH:mm");
	SimpleDateFormat format2 = 
			new SimpleDateFormat("MM월 dd일 HH시 mm분");
	
	Date time = new Date();
	
	String time1 = format1.format(time);
	String time2 = format2.format(time);
	
	String[] tokens = time1.split(" "); 
	
	public void tiktok() {
//		System.out.println(time1);
		for(int i=0;i<tokens.length;i++){
//			System.out.println(tokens[i]);
		}
		Y = Integer.parseInt(tokens[0]);
		M =  Integer.parseInt(tokens[1]);
		D =  Integer.parseInt(tokens[2]);
		now = tokens[3]; 
//		System.out.println(Y+M+D+now);
	}
	
	ChulGyulButton(String id, YeelJungView yjv){
		this.yjv = yjv;
		tiktok();
		cgd = new ChulGyulDao();
//		System.out.println(Y+" "+M+" "+D+" "+now);
		String msg = cgd.cal_chul(id, Y, M, D, now);
		if("출근완료".equals(msg)){
			JOptionPane.showMessageDialog(null,time2+" 출근이 확인되었습니다 ");
			yjv.jbtn_in.setText("퇴근");
		}else if("퇴근완료".equals(msg)) {
			JOptionPane.showMessageDialog(null,time2+" 퇴근이 확인되었습니다 ");
		}else if("중복".equals(msg)) {
			JOptionPane.showMessageDialog(null,"이미 처리되었습니다",M+"월"+D+"일 퇴근 완료",JOptionPane.ERROR_MESSAGE);
		}
	}
	
//	public static void main(String[] args) {
//	}
}

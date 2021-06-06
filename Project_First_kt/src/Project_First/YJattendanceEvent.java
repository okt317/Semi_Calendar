package Project_First;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JCheckBox;
import javax.swing.JOptionPane;

public class YJattendanceEvent implements ActionListener, ItemListener {
	YeelJungView yjv = null;
	YJattendance yjat = null;
	MemberDao md = null;
	String st = null;
	int vv = 0;
	public YJattendanceEvent(YJattendance YJattendance,YeelJungView yjv) {
		this.yjat = YJattendance;
		this.yjv = yjv;
		
	}
	@Override
	public void itemStateChanged(ItemEvent ie) {
		Object obj = ie.getSource();
		if(ie.getStateChange() == ie.SELECTED) {
//			System.out.println("야호");
			for(JCheckBox box:yjat.jcb_color) {
				if(!box.isSelected()) {
					box.setEnabled(false);
				}
			}
//			for(JCheckBox box2:yjatt.jcb_color) {
//				if(box2.isSelected()) {
//					yjatt.getJcb_color()[vv].setText(box2.getActionCommand());
//					System.out.println("무야");
//				}
//			}
		}
		if(ie.getStateChange() == ie.DESELECTED) {
//			System.out.println("야호");
			for(JCheckBox box:yjat.jcb_color) {
				if(!box.isSelected()) {
					box.setEnabled(true);
				}
				
			}
		}
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		Object obj = ae.getSource();
		String label = ae.getActionCommand();
		md = new MemberDao();
		if(obj==yjat.jbtn_new) {
			yjat.jta_naeyoung.setEditable(true);
			yjat.jtf_title.setEditable(true);
			
			
		}
		else if(obj==yjat.jbtn_sav){
			if((yjat.jta_naeyoung.getText().trim().length()>0)&&
					(yjat.jtf_title.getText().trim().length()==0)) {
				yjat.memo = yjat.jta_naeyoung.getText();
				yjat.title = yjat.jtf_title.getText()+" ";
			}
			else if((yjat.jta_naeyoung.getText().trim().length()==0)&&
					(yjat.jtf_title.getText().trim().length()>0)) {
				yjat.memo = yjat.jta_naeyoung.getText()+" ";
				yjat.title = yjat.jtf_title.getText();
			}
			else if((yjat.jta_naeyoung.getText().trim().length()>0)&&
					(yjat.jtf_title.getText().trim().length()>0)) {
				yjat.memo = yjat.jta_naeyoung.getText()+" ";
				yjat.title = yjat.jtf_title.getText();
			}
			else {
				JOptionPane.showMessageDialog(null,"제목 또는 내용을 입력해주세요" );
				return;
			}
				yjat.jta_naeyoung.setEditable(false);
				yjat.jtf_title.setEditable(false);
//				System.out.println(yjat.ID+" "+yjat.YY+" "
//						+yjat.MM+" "+yjat.DD+" "+yjat.memo+" "+yjat.title);
				String msg = md.cal_ins_upd(yjat.ID,yjat.YY,yjat.MM
										,yjat.DD,yjat.memo, yjat.title);
//				System.out.println(msg);
				if("저장".equals(label)) {
					JOptionPane.showMessageDialog(null, msg+"님의 일정이 추가되었습니다" );
				}
				else {
					JOptionPane.showMessageDialog(null, msg+"님의 일정이 수정되었습니다" );
				}
				yjat.jbtn_sav.setText("수정");
				yjv.YeelJung_Load();
				
		}
		else if((obj==yjat.jbtn_del)&&(
				yjat.jta_naeyoung.getText().trim().length()>0
				||yjat.jtf_title.getText().trim().length()>0)) {
			yjat.Sakje();
				}
		else if(obj==yjat.jbtn_sak1) {
			yjat.jta_naeyoung.setText("");
			yjat.jtf_title.setText("");
			yjat.memo = null;
			yjat.title = null;
			String msg = md.cal_del(yjat.ID,yjat.YY,yjat.MM,yjat.DD);
//			System.out.println(msg);
			yjat.jf_sak.dispose();
			JOptionPane.showMessageDialog(null, msg+"님의 일정이 삭제되었습니다" );
			yjat.jbtn_sav.setText("저장");
			yjv.YeelJung_Load();
			}
		else if(("닫기".equals(label))) {
			yjat.dispose();
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

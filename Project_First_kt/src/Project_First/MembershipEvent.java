package Project_First;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class MembershipEvent implements ActionListener {
	MemberAvatar mav = null;
	MemberShip ms = null;
	public MembershipEvent(MemberAvatar mav){
		this.mav = mav;
		
	}
	public MembershipEvent(MemberShip ms){
		this.ms = ms;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		Object obj = ae.getSource();
		if(obj == mav.pic[0]) {
			JOptionPane.showMessageDialog(null, "라이언1로 바뀌었습니다");
			mav.dispose();
//			ms.jtf_id.setEditable(false);
//			System.out.println(ms.avatar);
//			ms.avatar.setIcon(mav.img[0]);
//			ms.avatar = new JLabel(mav.img[0]);
		}
		if(obj == mav.pic[1]) {
			JOptionPane.showMessageDialog(null, "라이언2로 바뀌었습니다");
			mav.dispose();
//			ms.avatar = new JLabel(mav.img[1]);
		}
		if(obj == mav.pic[2]) {
			JOptionPane.showMessageDialog(null, "라이언3로 바뀌었습니다");
			mav.dispose();
		}
		if(obj == mav.pic[3]) {
			JOptionPane.showMessageDialog(null, "라이언4로 바뀌었습니다");
			mav.dispose();
		if(obj == mav.pic[4]) {
			JOptionPane.showMessageDialog(null, "라이언5로 바뀌었습니다");
			mav.dispose();
		}
			
		}
		// TODO Auto-generated method stub
		
	}

}

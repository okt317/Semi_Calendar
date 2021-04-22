
package Project_First;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class MembershipEvent implements ActionListener {
	MemberAvatar mav = null;
	MemberShip ms = null;
	public MembershipEvent(MemberAvatar mav, MemberShip ms){
		this.mav = mav;
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
			ms.pic_avatar.setIcon(mav.img[0]);
			ms.avatar = 0;
		}
		else if(obj == mav.pic[1]) {
			JOptionPane.showMessageDialog(null, "라이언2로 바뀌었습니다");
			mav.dispose();
			ms.pic_avatar.setIcon(mav.img[1]);
			ms.avatar = 1;
		}
		else if(obj == mav.pic[2]) {
			JOptionPane.showMessageDialog(null, "라이언3로 바뀌었습니다");
			mav.dispose();
			ms.pic_avatar.setIcon(mav.img[2]);
			ms.avatar = 2;
		}
		else if(obj == mav.pic[3]) {
			JOptionPane.showMessageDialog(null, "라이언4로 바뀌었습니다");
			mav.dispose();
			ms.pic_avatar.setIcon(mav.img[3]);
			ms.avatar = 3;
		}
		else if(obj == mav.pic[4]) {
			JOptionPane.showMessageDialog(null, "라이언5로 바뀌었습니다");
			mav.dispose();
			ms.pic_avatar.setIcon(mav.img[4]);
			ms.avatar = 4;
		
			
		}
		// TODO Auto-generated method stub
		
	}

}

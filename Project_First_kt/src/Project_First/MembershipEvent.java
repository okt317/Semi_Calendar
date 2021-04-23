package Project_First;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class MembershipEvent implements ActionListener {
	MemberAvatar mav = null;
	MemberShip ms = null;
	public MembershipEvent(MemberAvatar mav, MemberShip memberShip){
		this.mav = mav;
		this.ms = memberShip;
		
	}
//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//
//	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		Object obj = ae.getSource();
		//ms = new MemberShip();
		if(obj == mav.pic[0]) {
			JOptionPane.showMessageDialog(null, "라이언1로 바뀌었습니다");
			ms.jp_center.remove(ms.avatar);
			ms.jp_center.revalidate();
			ms.jp_center.add(ms.avatar = new JLabel(new ImageIcon("src\\images\\lion11.png")));
			ms.avatar.setBounds(140, 60, 100, 108);
			ms.jp_center.repaint();
			mav.dispose();
		}
		if(obj == mav.pic[1]) {
			JOptionPane.showMessageDialog(null, "라이언2로 바뀌었습니다");
			System.out.println("여긴 오나?");
			System.out.println(mav.img[1]);
			ms.jp_center.remove(ms.avatar);
			ms.jp_center.revalidate();
			ms.jp_center.add(ms.avatar = new JLabel(new ImageIcon("src\\images\\lion22.png")));
			ms.avatar.setBounds(140, 60, 100, 108);
			ms.jp_center.repaint();
			mav.dispose();
		}
		if(obj == mav.pic[2]) {
			JOptionPane.showMessageDialog(null, "라이언3로 바뀌었습니다");
			ms.jp_center.remove(ms.avatar);
			ms.jp_center.revalidate();
			ms.jp_center.add(ms.avatar = new JLabel(new ImageIcon("src\\images\\lion33.png")));
			ms.avatar.setBounds(140, 60, 100, 108);
			ms.jp_center.repaint();
			mav.dispose();
		}
		if(obj == mav.pic[3]) {
			JOptionPane.showMessageDialog(null, "라이언4로 바뀌었습니다");
			ms.jp_center.remove(ms.avatar);
			ms.jp_center.revalidate();
			ms.jp_center.add(ms.avatar = new JLabel(new ImageIcon("src\\images\\lion44.png")));
			ms.avatar.setBounds(140, 60, 100, 108);
			ms.jp_center.repaint();
			mav.dispose();
		}
		if(obj == mav.pic[4]) {
			JOptionPane.showMessageDialog(null, "라이언5로 바뀌었습니다");
			ms.jp_center.remove(ms.avatar);
			ms.jp_center.revalidate();
			ms.jp_center.add(ms.avatar = new JLabel(new ImageIcon("src\\images\\lion55.png")));
			ms.avatar.setBounds(140, 60, 100, 108);
			ms.jp_center.repaint();
			mav.dispose();
		}
			
		}
		// TODO Auto-generated method stub
		
	}



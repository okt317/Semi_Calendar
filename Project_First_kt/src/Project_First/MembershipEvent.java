
package Project_First;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class MembershipEvent implements ActionListener {
	MemberAvatar mav = null;
	MemberShip ms = null;
<<<<<<< HEAD
	public MembershipEvent(MemberAvatar mav, MemberShip memberShip){
=======
	public MembershipEvent(MemberAvatar mav, MemberShip ms){
>>>>>>> refs/remotes/origin/kyungtaek
		this.mav = mav;
<<<<<<< HEAD
		this.ms = memberShip;
=======
		this.ms = ms;
>>>>>>> refs/remotes/origin/kyungtaek
		
	}
<<<<<<< HEAD
//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//
//	}
=======
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
>>>>>>> refs/remotes/origin/kyungtaek

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
<<<<<<< HEAD
=======
			ms.pic_avatar.setIcon(mav.img[0]);
			ms.avatar = 0;
>>>>>>> refs/remotes/origin/kyungtaek
		}
		else if(obj == mav.pic[1]) {
			JOptionPane.showMessageDialog(null, "라이언2로 바뀌었습니다");
			System.out.println("여긴 오나?");
			System.out.println(mav.img[1]);
			ms.jp_center.remove(ms.avatar);
			ms.jp_center.revalidate();
			ms.jp_center.add(ms.avatar = new JLabel(new ImageIcon("src\\images\\lion22.png")));
			ms.avatar.setBounds(140, 60, 100, 108);
			ms.jp_center.repaint();
			mav.dispose();
<<<<<<< HEAD
=======
			ms.pic_avatar.setIcon(mav.img[1]);
			ms.avatar = 1;
>>>>>>> refs/remotes/origin/kyungtaek
		}
		else if(obj == mav.pic[2]) {
			JOptionPane.showMessageDialog(null, "라이언3로 바뀌었습니다");
			ms.jp_center.remove(ms.avatar);
			ms.jp_center.revalidate();
			ms.jp_center.add(ms.avatar = new JLabel(new ImageIcon("src\\images\\lion33.png")));
			ms.avatar.setBounds(140, 60, 100, 108);
			ms.jp_center.repaint();
			mav.dispose();
			ms.pic_avatar.setIcon(mav.img[2]);
			ms.avatar = 2;
		}
		else if(obj == mav.pic[3]) {
			JOptionPane.showMessageDialog(null, "라이언4로 바뀌었습니다");
			ms.jp_center.remove(ms.avatar);
			ms.jp_center.revalidate();
			ms.jp_center.add(ms.avatar = new JLabel(new ImageIcon("src\\images\\lion44.png")));
			ms.avatar.setBounds(140, 60, 100, 108);
			ms.jp_center.repaint();
			mav.dispose();
<<<<<<< HEAD
		}
		if(obj == mav.pic[4]) {
=======
			ms.pic_avatar.setIcon(mav.img[3]);
			ms.avatar = 3;
		}
		else if(obj == mav.pic[4]) 
		{
>>>>>>> refs/remotes/origin/kyungtaek
			JOptionPane.showMessageDialog(null, "라이언5로 바뀌었습니다");
			ms.jp_center.remove(ms.avatar);
			ms.jp_center.revalidate();
			ms.jp_center.add(ms.avatar = new JLabel(new ImageIcon("src\\images\\lion55.png")));
			ms.avatar.setBounds(140, 60, 100, 108);
			ms.jp_center.repaint();
			mav.dispose();
			ms.pic_avatar.setIcon(mav.img[4]);
			ms.avatar = 4;
		
			
		}
		// TODO Auto-generated method stub
		
	}



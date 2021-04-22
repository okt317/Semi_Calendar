package Project_First;

import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;

public class MemberAvatar extends JDialog {
	
	//선언부
	String imgPath = "src\\images\\";
	String imgfile[] = {"lion11.png","lion22.png","lion33.png","lion44.png","lion55.png"};
	JPanel jp_emoticon = new JPanel();
	GridLayout gl_emoticon = new GridLayout(1,5,2,2);
	ImageIcon img[] = new ImageIcon[imgfile.length];
	JButton pic[] = new JButton[imgfile.length];
	MemberShip ms = null;
	MembershipEvent mse = null;
	//생성자
	public MemberAvatar() {
	}
	public MemberAvatar(MembershipEvent mse) {
		this.mse = mse;
	}
	public MemberAvatar(MemberShip ms) {
		this.ms = ms;
		this.initDisplay();
	}
	//화면처리부
	public void initDisplay() {
//		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		mse = new MembershipEvent(this, ms);
		jp_emoticon.setLayout(gl_emoticon);
		for(int i=0;i<imgfile.length;i++) {
			img[i] = new ImageIcon(imgPath+imgfile[i]);
			pic[i] = new JButton(img[i]);
			jp_emoticon.add(pic[i]);
			pic[i].addActionListener(mse);
			
		}
		this.add("Center",jp_emoticon);
		this.setLocation(920, 250);
		this.setSize(600,200);
		this.setVisible(true);
	}
	//메인메소드
	public static void main(String[] args) {
		MemberAvatar mav = new MemberAvatar();

	}

}

package Project_First; //04.04

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class LoginTest implements ActionListener{
   JFrame jf 	= new JFrame();//프레임선언
   JPanel jp 	= new JPanel();//페널 
   JButton btn_login = new JButton("입장"); //버튼
   JButton btn_new	 = new JButton("신규");
   JLabel name_label = new JLabel("출결관리 프로젝트");
   JLabel pw_label   = new JLabel("비밀번호"); // 비멀번호는 라벨이름
   JLabel id_label 	 = new JLabel("아이디"); //라벨은 아이디
   JTextField id_jtf 			= new JTextField("test"); // 한줄 입력창 만들기
   JPasswordField passwordtext  = new JPasswordField("123"); //  암호값 가져오기
   public JCheckBox checkBox_pw = new JCheckBox("비밀번호 보이기");
   String msg = "";
    
   Font font = new Font("궁서체",Font.BOLD,15);
   Font font1 = new Font("궁서체",Font.BOLD,18);
   //이미지관련
   JLabel jl_image = null;
   String imgPath 	 = "src\\images\\";
   ImageIcon ig = new ImageIcon (imgPath+"pp.png");//(imgPath + "main.png");
   Image img = ig.getImage();
   Image changeImg = img.getScaledInstance(400, 200, Image.SCALE_SMOOTH);
   ImageIcon changeIcon = new ImageIcon(changeImg);
    
   MemberShip ms = null;
   YeelJungView yjv = null;
    
   public static void main(String[] args) { //메인
       LoginTest log = new  LoginTest();
       log.initDisplay();
   }

//   class MyPanel extends JPanel{
//         public void paintComponent(Graphics g) {
//            g.drawImage(img.getImage1(),0,0,null);
//            setOpaque(false);
//            super.paintComponent(g);
//                     
//         }
//            }
      public void initDisplay() {

      jf.setTitle("출결 관리 ");
      jf.add(jp); //패널을 넣는다
      jp.add(name_label);
      jp.add(id_label); // 라벨을 넣는다 패널에
      jp.add(id_jtf); // 입력창도 패널에 박는다
      jp.add(pw_label);//라벨을 패널에 박는다
      jp.add(passwordtext);
      jp.add(btn_login); //패널에 박는다
      jp.add(btn_new);
      jp.add(checkBox_pw);

      btn_login.addActionListener(this);
      btn_new.addActionListener(this);
      checkBox_pw.addActionListener(this);
      name_label.setBounds(100,25,180,50);
      name_label.setFont(font1);
      id_label.setBounds(70, 90, 80, 25); //절대위치 지정
      pw_label.setBounds(70,120,80,25);//절대위치 지정  비밀번호 라벨
      btn_new.setBounds(80,200,80,25);
      btn_login.setBounds(180,200,80,25);
      id_jtf.setBounds(170,90,150,25); //절대위치
      passwordtext.setBounds(170,120,150,25); // 절대 위치 지정
      checkBox_pw.setBounds(170,150,150,25);
      jf.setSize(400,500);//사이즈크기
      jp.setLayout(null); // 배치관리자를 null로 설정한다.    
      jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//종료
      jf.setLocation(700, 250);
      jf.setVisible(true);//보여진다.
      btn_login.setFont(font);
      btn_new.setFont(font);
      pw_label .setFont(font);
      id_label.setFont(font);
//      name_label.setFont(font);
   ///////////////////////
      jl_image = new JLabel();
      jl_image.setIcon(changeIcon);
      jf.add("South",jl_image);
      
      passwordtext.setEchoChar('*');
   
      }
      /////////
      

    @Override
      public void actionPerformed(ActionEvent e) {
         Object      obj         = e.getSource();
 		if(btn_new==obj) {
			ms = new MemberShip();
//				this.dispose();
			}
		else if(btn_login==obj) {
			MemberDao md = new MemberDao();
			if("".equals(id_jtf.getText()) || "".equals(passwordtext.getText())){
				JOptionPane.showMessageDialog(null, "아이디와 비번을 확인하세요");
				return;
			}
			try {
				String mem_id = id_jtf.getText();
				String mem_pw = passwordtext.getText();
				String msg = md.login(mem_id, mem_pw);
				if("비밀번호가 틀립니다".equals(msg)){
					JOptionPane.showMessageDialog(null, "비밀번호가 맞지 않습니다","",JOptionPane.WARNING_MESSAGE);
					passwordtext.setText("");
					return;
				}
				else if("아이디가 존재하지 않습니다".equals(msg)){
					JOptionPane.showMessageDialog(null, "아이디가 존재하지 않습니다","",JOptionPane.WARNING_MESSAGE);
					id_jtf.setText("");
					return;
				}
				else {
					yjv = new YeelJungView(md);
					String name = md.load_profile(mem_id);
					JOptionPane.showMessageDialog(null, name+"님이 로그인 되었습니다");
					jf.dispose();
					yjv.initDisplay(name,mem_id);
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
         else  { //체크박스
            if(checkBox_pw.isSelected()) {
            passwordtext.setEchoChar((char)0);
         }
      else
         passwordtext.setEchoChar('*');      
     
         }
    }

}
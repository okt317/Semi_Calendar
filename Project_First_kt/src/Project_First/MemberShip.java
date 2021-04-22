package Project_First;


import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class MemberShip extends JDialog implements ActionListener {
   // 선언부
   JPanel		jp_center		= new JPanel();
   JLabel		jlb_id			= new JLabel("아이디");
   JTextField   jtf_id			= new JTextField(10);
   JLabel		jlb_pw			= new JLabel("패스워드");
   JPasswordField	jtf_pw		= new  JPasswordField(10);
   JLabel		jlb_nickName   	= new JLabel("닉네임");
   JTextField	jtf_nickName   	= new JTextField(20);
   JLabel		jlb_name      	= new JLabel("성명");
   JTextField   jtf_name      	= new JTextField(30);
   JLabel       jlb_gender      = new JLabel("성별");
   String[]     genderList      = { "남자", "여자" };
   JComboBox   	jcb_gender      = new JComboBox(genderList);
   JCheckBox 	checkBox_pw 	= new JCheckBox("비밀번호 보이기");
   JLabel		jlb_avatar		= new JLabel("대표 아바타 설정");
   JLabel		avatar			= null;
   JButton		jbtn_avatar		= new JButton("아바타 변경");
//   JButton		jbtn_avatar		= null;
   Font			font 			= new Font("궁서체", 1, 14);
 
   JScrollPane	jsp				= null;
   JPanel		jp_south		= new JPanel();
   JButton		jbtn_ins		= new JButton("등록");
   JButton		jbtn_close		= new JButton("닫기");
   JButton		jbtn_equals		= new JButton("중복확인");
   
   MemberAvatar mav			= null;
   MembershipEvent mse = null;
   
   int 			gender			= 0;
//   ZipCodeSearch zcs = new ZipCodeSearch(this);

   // 생성자
   public MemberShip() {
      initDisplay();
   }
//   public MemberShip(MembershipEvent mse) {
//	   this.mse = mse;
//   }
   public static void main(String[] args) {      
	   new MemberShip();
//	   MemberShip ms = new MemberShip();
//	   ms.initDisplay();
   }
   

   // 화면처리부
   public void initDisplay() {
	  avatar = new JLabel(new ImageIcon("src\\images\\lion11.png"));

	  jbtn_equals.addActionListener(this);
      jbtn_ins.addActionListener(this);
      jbtn_close.addActionListener(this);
      jbtn_avatar.addActionListener(this);
      jp_center.setLayout(null);
      jlb_avatar.setBounds(145, 20, 150, 20);
      avatar.setBounds(140, 60, 100, 108);
      jbtn_avatar.setBounds(120, 180, 150, 20);
      jlb_id.setBounds(20, 230, 100, 20);
      jbtn_equals.setBounds(250,230,100,20);
      jtf_id.setBounds(120, 230, 120, 20);
      jlb_pw.setBounds(20, 255, 100, 20);
      jtf_pw.setBounds(120, 255, 120, 20);
      jlb_nickName.setBounds(20, 280, 100, 20);
      jtf_nickName.setBounds(120, 280, 150, 20);
      jlb_name.setBounds(20, 305, 100, 20);
      jtf_name.setBounds(120, 305, 150, 20);
      jlb_gender.setBounds(20, 330, 100, 20);
      jcb_gender.setBounds(120, 330, 150, 20);
      jcb_gender.	setFont(font);
      jlb_id.		setFont(font);
      jlb_pw.		setFont(font);
      jlb_nickName.	setFont(font);
      jlb_name .	setFont(font);
      jbtn_ins .	setFont(font);
      jbtn_close .	setFont(font);
      jbtn_equals .	setFont(font);
      
      jp_center.add(avatar);
      jp_center.add(jlb_avatar);
      jp_center.add(jbtn_avatar);
      jp_center.add(jlb_id);
      jp_center.add(jtf_id);
      jp_center.add(jlb_pw);
      jp_center.add(jtf_pw);
      jp_center.add(jlb_nickName);
      jp_center.add(jtf_nickName);
      jp_center.add(jlb_name);
      jp_center.add(jtf_name);
      jp_center.add(jlb_gender);
      jp_center.add(jcb_gender);
      jp_center.add(jbtn_equals);
     
      jp_south.setLayout(new FlowLayout(FlowLayout.RIGHT));
      jp_south.add(jbtn_ins);
      jp_south.add(jbtn_close);
      this.add("South", jp_south);
      jsp = new JScrollPane(jp_center);
      this.add("Center", jsp);
      this.setTitle("회원가입");
      this.setSize(400, 500);
      this.setLocation(500, 200);
      this.setVisible(true);
     // jtf_pw.setEchoChar('*');     
   
   }
   ///아아디에 특수문자
   public int idCheck(String id) {
      int idCheck = 0;
      if(IDspecialCharacter(id) == 0) {
         idCheck = 1;
      }
      return idCheck;
   }
   //////////////
   public int IDspecialCharacter(String id) {//특수문자 있으면 1 없으면 0 반환하기
      String text[] = 
         { "#", "!","$","%","^","&","*","(",")","-",
               "_","+","=",",","[","]","{","}",":",";","'","?","<",">"};
      int result = 0;
      for(int i=0; i<text.length; i++) { 
         if(id.indexOf(text[i]) == -1) {
            result = 1; }
         else { 
            break; } 
         } 
      return result;
   }
 //////////
   
   //////////////////////////////
   public int SpecialCharacters(String sc_pw) //비밀번호 특수문자 제한 메소드
   	{
	  int check= 0; 
      char alpha; 
      int code; 
      for(int i=0; i<sc_pw.length(); i++) 
      	{ alpha = sc_pw.charAt(i); 
      	code = (int)alpha; 
      		if(code>=0 && code<=32 || 
      				code>=36 && code<=47 || code>=58 && code<=63 ||
      				code>=91 && code <=96 || code>=123 && code <= 127) 
      		{ check = 1; } } 
      return check;
   	}
//////////////////////
   
 /////////////////////  
   @Override
   public void actionPerformed(ActionEvent e) {
      boolean   isRefused   = false;
      Object   obj         = e.getSource();
      
     if (obj == jbtn_ins) { //등록 누를때        
        String  id_limit = jtf_id.getText();
        String  pw_limit = jtf_pw.getText();
        
    if ("".equals(jtf_id.getText())  ||
    		"".equals(jtf_name.getText()) || 
            "".equals(jtf_nickName.getText()) || 
            "".equals(jtf_pw.getText())
                              ) {
            JOptionPane.showMessageDialog(this, "모든 정보를 입력해주십시오");
         }
    else  if(SpecialCharacters(jtf_name.getText())== 1) {
         JOptionPane.showMessageDialog(this, "이름에 특수문자는 불가합니다.");             
      }
    
    else  if( pw_limit.length() < 4 ||  pw_limit.length() > 10){
       JOptionPane.showMessageDialog(this, "비밀번호는 4자리 이상, 10자리 이하만 가능 합니다.");       
    }
    
    else  if(id_limit.length() < 2 || id_limit.length() > 10){
       JOptionPane.showMessageDialog(this, "아이디는 2자리 이상, 10자리 이하만 가능 합니다.");
    }
    
    else  {         
            if ("남자".equals(jcb_gender.getSelectedItem())) {
               gender = 0;
            }
            else {
               gender = 1;
            }
            if (isRefused != true) {
               JOptionPane.showMessageDialog(this, "회원가입 성공");
               this.dispose();
            }
            else {
               JOptionPane.showMessageDialog(this, "중복된 아이디입니다");
               jtf_id.setText("");
            }
         }
      }///end of ins

      else if (obj == jbtn_close) {
         this.dispose();
      }
      else if (obj == jbtn_equals) {
         
         
      }else if (obj == jbtn_avatar) {
    	  System.out.println(avatar);
    	  mav = new MemberAvatar();
    	  
          
      }
     
   }}    

     

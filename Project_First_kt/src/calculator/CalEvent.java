package calculator;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
// 브랜치로 수정사항 올려보기
// 하나더 추가
// 하나 또 추가
public class CalEvent implements ActionListener{
	CalView CV = null;
	int fnum = 0;
	int snum = 0;
	int btn_num = 0;
	int nan_int = 0;
	double nan = 0.0;
	String plus = null;
	String gap = null;
	String btn_str = null;
	String nan_str = null;
	char pl = 0;
	char sosu = 0;
	
	
	public CalEvent(CalView CV) {
		this.CV = CV;
	}
	
	public void reset() {
		CV.jta_display.setText("");
		CV.jta_info.setText("");
		plus = null;
		fnum = 0;
		snum = 0;
	}
	
	@Override
	public void actionPerformed(ActionEvent ae) {
		Object obj = ae.getSource();
		String label = ae.getActionCommand();
		try {
			//// 버튼의 숫자 확인
			if( obj != CV.jbtns_p[0]&&obj != CV.jbtns_p[1]&&obj != CV.jbtns_p[2]
					&&obj != CV.jbtns_p[3]&&obj != CV.jbtns_p[4]&&obj != CV.jbtns_p[5]) {
				CV.jta_fake.setText(label);
				btn_str = CV.jta_fake.getText();
				btn_num = Integer.parseInt(btn_str);
				System.out.println(btn_str+btn_num);
				}/// 확인 끝
			/// 버튼 오픈
			for(int i = 0;i<CV.jbtns_n.length;i++) {
				CV.jbtns_n[i].setEnabled(true);
				}/// 버튼 오픈 끝
			if("=".equals(label)&&(snum>0)) { ////// 정답 확인
				/// 더하기 
				if(pl == '+') { 
					gap = Integer.toString(fnum+snum);
					if(9<gap.length()) {// 숫자 초과 시 
						CV.jop.showMessageDialog(CV, "숫자는 최대 9자리까지 입니다");
						this.reset();
					} else {
						CV.jta_info.append(Integer.toString(snum) + "=" + gap + "\n");
						CV.jta_display.setText(gap);
						fnum = fnum+snum;
						}// 더하기 끝
					/// 빼기
					} else if(pl == '-') {
						gap = Integer.toString(fnum-snum);
						CV.jta_info.append(Integer.toString(snum) + "=" + gap + "\n");
						CV.jta_display.setText(gap);
						fnum = fnum-snum;//빼기 끝
					/// 곱하기
					} else if(pl == '*') {
						gap = Integer.toString(fnum*snum);
						if(9<gap.length()) {// 숫자 초과 시
						CV.jop.showMessageDialog(CV, "숫자는 최대 9자리까지 입니다");
						this.reset();
					}else {
						CV.jta_info.append(Integer.toString(snum) + "=" + gap + "\n");
						CV.jta_display.setText(gap);
						fnum = fnum*snum;
						} //곱하기 끝
					/// 나누기
					} else if(pl == '/') {
						nan = ((double)fnum/(double)snum);
						nan_int = fnum/snum;
						gap = Double.toString(nan);
						nan_str = Integer.toString(nan_int);
						System.out.println("나눈값 소수점은 " + gap + " 나눈값 정수는 " + nan_str);
//						sosu = gap.charAt(gap.length()-(gap.length()-nan_str.length())+1);
						sosu = gap.charAt(nan_str.length()+1);
						System.out.println("소수점은 " + sosu + " 나눈 값은 "+(gap.length()-(gap.length()-nan_str.length())) );
						if(sosu < '5') {//반올림
							gap = Integer.toString(fnum/snum);
						}else {
							gap = Integer.toString((fnum/snum)+1);
						}
						CV.jta_info.append(Integer.toString(snum) + "=" + nan + "\n");
						CV.jta_display.setText(gap);
						fnum = Integer.parseInt(gap);
						}// 나누기 끝
					plus = null;
					snum = 0;
				}////// end of if 정답확인
			/// 리셋
			else if("C".equals(label)) { 
				this.reset();
			/// 리셋 끝
			/// 첫 번째 수 설정
			} else if((obj == CV.jbtns_n[btn_num]) &&(plus==null)) {
				CV.jta_display.setText(CV.jta_display.getText()+label);
				fnum = Integer.parseInt(CV.jta_display.getText());
				System.out.println("fnum은" + fnum);
			/// 첫번째 수 설정 끝
			/// 연산 기호 설정
			} else if((obj == CV.jbtns_p[0]||obj == CV.jbtns_p[1]||obj == CV.jbtns_p[2]||obj == CV.jbtns_p[3])
					&&(fnum>0)&&(plus==null)) { 
				CV.jta_display.setText(CV.jta_display.getText()+label);
				plus = CV.jta_display.getText();
				pl = plus.charAt(plus.length()-1);
				System.out.println("plus" + plus + "pl" + pl);
				CV.jta_display.setText("");
				CV.jta_info.append(Integer.toString(fnum)+Character.toString(pl));
			/// 연산 기호 설정 끝
			/// 두 번째 수 설정
			} else if((obj == CV.jbtns_n[btn_num])&&(plus!=null)&&(fnum>0)) {
				CV.jta_display.setText(CV.jta_display.getText()+label);
				snum = Integer.parseInt(CV.jta_display.getText());
				System.out.println("fnum은" + fnum+ pl +"snum은" + snum);
			}
			/// 두번째 수 설정 끝
			// 예외처리
		} catch (NumberFormatException ne) {
			CV.jop.showMessageDialog(CV, "숫자는 최대 9자리까지 입니다");
			for(int i = 0;i<CV.jbtns_n.length;i++) {
			CV.jbtns_n[i].setEnabled(false);
			}
		} catch (ArithmeticException aee) {
			CV.jop.showMessageDialog(CV, "무한대");
			this.reset();
		  	
			
//		switch (key) {
//		case value:
//			
//			break;
//
//		default:
//			break;
//		}	
		
		
		
		
		
		
		
		
		}
		  catch (Exception e) {
			e.printStackTrace();
			
			// TODO: handle exception
		}
		
		
	}
}

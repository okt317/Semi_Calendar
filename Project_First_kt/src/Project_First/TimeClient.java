package Project_First;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.Socket;

import javax.swing.JLabel;

/*
 * 소켓 
 * 네트워크에서 정보가 들어가고 나가는 지점에 대한 유일한 식별자
 * 32비트의 숫자로 구성되며 짝수번 수켓은 정보를 받아들이는 용도로
 * 홀수번 소켓은 정보를 보내는 용도로 사용됨.
 * 
 * TCP포트번호: 물리적인 장치를 꽂는 장소는 아니다. 용도에 따라 쓰는 숫자 값.
 * 서버에서 돌아가는 특정 프로그램을 나타내는 16비트 숫자
 * 웹서버 - 80
 * 텔넷서버 - 23
 * FTP서버 - 20
 * SMTP서버 - 25
 * 
 * 같은 포트에서 여러 프로그램이 돌아갈 수 있나요?
 * BindException이 발생함.
 * 
 * netstat -ano | findstr 3000검색
 * taskkill /pid 42356 /f
 */
public class TimeClient extends Thread {

	JLabel jlb_time = null;
	YeelJungView yv = null;
	
	public TimeClient() {

	}

	public TimeClient(JLabel jlb_time) {
		this.jlb_time = jlb_time;
	}

	String timeStr = null;

	@Override
	public void run() {// 콜백메소드 - 사용자가 아니라 시스템 레벨에서 자동 호출되는 메소드임.
		Socket socket = null;
		BufferedReader br = null;
		yv = new YeelJungView();
		boolean isFlag = false;
		try {
			socket = new Socket("localhost", 7375);// local port 7375
			br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			// InputStream is = new InputStreamReader((socket.getInputStream()));
			// 내 소켓에 대한 포트번호는 따로 할당.
			while (!isFlag) {
				while ((timeStr = br.readLine()) != null) {
					System.out.println(timeStr);
//					yv.setTitle(timeStr); // @@@@@@@@@@@@@@@이걸열면@@@@@@@@@@
//					jlb_time.setText(timeStr);
					try {
						sleep(1000);
					} catch (Exception e) {
						System.out.println("넌 누구냐?");
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		TimeClient tc = new TimeClient();
		tc.start();// run메소드 호출해줌.

	}

}

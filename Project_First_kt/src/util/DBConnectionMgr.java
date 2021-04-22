package util;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DBConnectionMgr {
   private final static String _DRIVER = "oracle.jdbc.driver.OracleDriver";
//   private final static String _URL    = "jdbc:oracle:thin:@172.30.1.51:1521:orcl11";
//   private final static String _URL    = "jdbc:oracle:thin:@192.168.0.22:1521:orcl11";
   private final static String _URL    = "jdbc:oracle:thin:@localhost:1521:orcl11";
   private final static String _USER   = "SCOTT";
//   private final static String _USER   = "GOBUK";
   private final static String _PW     = "tiger";
   private static DBConnectionMgr dbMgr = null;
   Connection con = null;
   private DBConnectionMgr() {}
   //게으른 인스턴스화 - 선언과 생성이 따로 쓰여졌을때
   public static DBConnectionMgr getInstance() {
      if(dbMgr == null) {
         dbMgr = new DBConnectionMgr();
      }
      return dbMgr;
   }
   public Connection getConnection() {
      try {
         Class.forName(_DRIVER);
         con = DriverManager.getConnection(_URL, _USER, _PW);
         /* 트랜잭션처리
         con.setAutoCommit(true);//켜둔다
         con.setAutoCommit(false);//꺼둔다
         con.commit();
         con.rollback();
         */
      } catch (ClassNotFoundException ce) {
         // TODO: handle exception
         System.out.println("드라이버 클래스를 찾을 수 없습니다.");
      } catch (Exception e) {
         System.out.println("오라클 서버와 연결 실패!!!.");
      }
      return con;
   }
   //사용한 자원 반납하기
   //이것을 하지 않으면 오라클 서버에 접속할 때 세션 수의 제한 때문에 오라클서버를 재기동해야 할 수도 있음.
   //SELECT일 때 사용함.
  public void freeConnection(Connection con, PreparedStatement pstmt, ResultSet rs) {
      try {
         if(rs !=null) rs.close();
         if(pstmt !=null) pstmt.close();
         if(con !=null) con.close();
      } catch (Exception e) {
         // TODO: handle exception
      }
   }
   //사용한 자원 반납하기
   //자원 반납할 때는 생성된 객체의 역순으로 반납할 것.
   public void freeConnection(Connection con, PreparedStatement pstmt) {
	   try {
		   if(pstmt !=null) pstmt.close();
		   if(con !=null) con.close();
	   } catch (Exception e) {
		   // TODO: handle exception
	   }
   }
   public void freeConnection(Connection con, CallableStatement cstmt) {
	   try {
		   if(cstmt !=null) cstmt.close();
		   if(con !=null) con.close();
	   } catch (Exception e) {
		   // TODO: handle exception
	   }
   }
   /*
    * 주의: 사용한 자원은 반드시 명시적으로 반납할 것 
    * 안하면 오라클 서버로 세션을 종료 당함. 오라클 서버의 세션 수가 정해져 있다. - DBA결정
    */
   public void freeConnection(Connection con, CallableStatement cstmt, ResultSet rs) {
	   try {
		   if(rs !=null) rs.close();
		   if(cstmt !=null) cstmt.close();
		   if(con !=null) con.close();
	   } catch (Exception e) {
		   // TODO: handle exception
	   }
   }
}

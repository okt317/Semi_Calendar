package Project_First;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import util.DBConnectionMgr;


public class MemberDao {
	Connection			con		= null;
	CallableStatement	cstmt	= null;
	PreparedStatement	pstmt	= null;
	ResultSet			rs		= null;
	DBConnectionMgr dbmgr = null;
	String load_name = null;
	String load_memo = null;
	String load_title = null;
	public String login(String p_id, String p_pw) {
		dbmgr = DBConnectionMgr.getInstance();
		String msg = "";
		try {
			con = dbmgr.getConnection();
			cstmt = con.prepareCall("{call cal_login(?,?,?)}");
			cstmt.setString(1, p_id);
			cstmt.setString(2, p_pw);
			cstmt.registerOutParameter(3, java.sql.Types.VARCHAR);
			int result = 0;
			result = cstmt.executeUpdate();
			System.out.println(result);
			if(result==1) {
				msg = cstmt.getString(3);
			}
			System.out.println(cstmt.getString(3));
		} catch (SQLException se) {
			
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			dbmgr.freeConnection(con, cstmt);
		}
		return msg;
	}
	public String gaip(String p_id, String p_pw, String p_name) {
		dbmgr = DBConnectionMgr.getInstance();
		String msg = "";
		try {
			con = dbmgr.getConnection();
			cstmt = con.prepareCall("{call cal_gaip(?,?,?,?)}");
			cstmt.setString(1, p_id);
			cstmt.setString(2, p_pw);
			cstmt.setString(3, p_name); 
			cstmt.registerOutParameter(4, java.sql.Types.VARCHAR);
			int result = 0;
			result = cstmt.executeUpdate();
			if(result==1) {
				msg = cstmt.getString(4);
			}
			System.out.println(cstmt.getString(4));
		} catch (SQLException se) {
			
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			dbmgr.freeConnection(con, cstmt);
		}
		return msg;
	}
	public String cal_ins_upd(String p_id, int yy, int mm, int dd
			, String memo, String tit) {
		dbmgr = DBConnectionMgr.getInstance();
		String msg = "";
		int result = 0;
		try {
			con = dbmgr.getConnection();
			cstmt = con.prepareCall("{call cal_ins_upd(?,?,?,?,?,?,?)}");
			cstmt.setString(1, p_id);
			cstmt.setInt(2, yy);
			cstmt.setInt(3, mm);
			cstmt.setInt(4, dd);
			cstmt.setString(5, memo);
			cstmt.setString(6, tit);
			cstmt.registerOutParameter(7, java.sql.Types.VARCHAR);
			result = cstmt.executeUpdate();
			System.out.println(result);
			msg = cstmt.getString(7);
		} catch (SQLException se) {
			
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			dbmgr.freeConnection(con, cstmt);
		}
		return msg;
	}
	public String cal_del(String p_id, int yy, int mm, int dd) {
		dbmgr = DBConnectionMgr.getInstance();
		String msg = "";
		int result = 0;
		try {
			con = dbmgr.getConnection();
			cstmt = con.prepareCall("{call cal_del(?,?,?,?,?)}");
			cstmt.setString(1, p_id);
			cstmt.setInt(2, yy);
			cstmt.setInt(3, mm);
			cstmt.setInt(4, dd);
			cstmt.registerOutParameter(5, java.sql.Types.VARCHAR);
			result = cstmt.executeUpdate();
			System.out.println(result);
			msg = cstmt.getString(5);
		} catch (SQLException se) {
			
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			dbmgr.freeConnection(con, cstmt);
		}
		return msg;
	}
	public String load_profile(String p_id) {
		dbmgr = DBConnectionMgr.getInstance();
		String sql = "";
		sql += "select mem_name from member_calendar";
		sql += " where mem_id=?         ";
		try {
			con = dbmgr.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, p_id);
			rs = pstmt.executeQuery();
			rs.next();
			load_name = rs.getString("mem_name");
			System.out.println(load_name+"님이 확인되었습니다");
		} catch (SQLException se) {
			System.out.println("오류1");
		} catch (Exception e) {
			System.out.println("오류2");
			// TODO: handle exception
		}finally {
			dbmgr.freeConnection(con, cstmt, rs);
		}
		return load_name;
	}
	public void load_memo(String p_id, int yy, int mm, int dd) {
		dbmgr = DBConnectionMgr.getInstance();
		String sql = "";
		sql += "select memo,title from calendar";
		sql += " where mem_id=?         ";
		sql += " and  year=?              ";
		sql += " and month=?              ";
		sql += " and day=?                ";
		try {
			con = dbmgr.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, p_id);
			pstmt.setInt(2, yy);
			pstmt.setInt(3, mm);
			pstmt.setInt(4, dd);
//			System.out.println(sql);
			rs = pstmt.executeQuery();
			System.out.println("여기12");
			rs.next();
			System.out.println("여기13");
			load_memo = rs.getString("memo");
			load_title = rs.getString("title");
//			load_memo2 = load_memo;
			System.out.println(load_memo);
		} catch (SQLException se) {
			System.out.println("불러올 메모가 없습니다");
		} catch (Exception e) {
			System.out.println("오류2");
			// TODO: handle exception
		}finally {
			dbmgr.freeConnection(con, cstmt, rs);
		}
	}
	
	public static void main(String[] args) {
//		MemberDao md = new MemberDao();
//		md.cal_load2("test", 21, 3, 11);
//		System.out.println(md.load_memo);
//		md.login("test", "123");
	}
}

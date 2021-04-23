package Project_First;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;

import util.DBConnectionMgr;


public class ChulGyulDao {
	Connection			con		= null;
	CallableStatement	cstmt	= null;
	PreparedStatement	pstmt	= null;
	ResultSet			rs		= null;
	DBConnectionMgr dbmgr = null;
	String load_memo = null;
	String[] ymd = null;
	String[] fst = null;
	String[] lst = null;
	public String cal_chul(String p_id, int yy, int mm, int dd
			, String now) {
		dbmgr = DBConnectionMgr.getInstance();
		String msg = "";
		int result = 0;
		try {
			con = dbmgr.getConnection();
			cstmt = con.prepareCall("{call cal_chulgyul"
					+ "(?,?,?,?,?,?)}");
			cstmt.setString(1, p_id);
			cstmt.setInt(2, yy);
			cstmt.setInt(3, mm);
			cstmt.setInt(4, dd);
			cstmt.setString(5, now);
			System.out.println("여기1");
			cstmt.registerOutParameter(6, java.sql.Types.VARCHAR);
			System.out.println("여기2");
			result = cstmt.executeUpdate();
			System.out.println("여기3");
			System.out.println(result);
			msg = cstmt.getString(6);
		} catch (SQLException se) {
			System.out.println("오류1");
		} catch (Exception e) {
			System.out.println("오류2");
			// TODO: handle exception
		}finally {
			dbmgr.freeConnection(con, cstmt);
		}
		return msg;
	}
	public ArrayList getChulGyulList(String p_id, int yy, int mm){
		dbmgr = DBConnectionMgr.getInstance();
		System.out.println("getZipCodeList 호출성공 "+yy+" "+mm);
		ArrayList attendlist = new ArrayList<>();
		StringBuilder sql = new StringBuilder();
		sql.append("select year, month, day, f_time, l_time ");
		sql.append(" from ATTENDANCE                     ");
		sql.append(" where mem_id = ?                    ");
		sql.append(" and year = ?                        ");
		sql.append(" and month =?                        ");
		sql.append(" order by day                     ");
		try {
		con = dbmgr.getConnection();
		pstmt = con.prepareStatement(sql.toString());
		pstmt.setString(1, p_id);
		pstmt.setInt(2, yy);
		pstmt.setInt(3, mm);
		rs = pstmt.executeQuery();
//		ChulGyulVO CGVO = null;
		Vector<String> v = new Vector<>();
		Vector<String> v1 = new Vector<>();
		Vector<String> v2 = new Vector<>();
		while(rs.next()) { 
//			CGVO = new ChulGyulVO();
//			CGVO.setYear(rs.getInt("year"));
//			CGVO.setMonth(rs.getInt("month"));
//			CGVO.setDay(rs.getInt("day"));
//			CGVO.setChul(rs.getString("first"));
//			CGVO.setToi(rs.getString("last"));
//			CGVO.setYymmdd(rs.getInt("year")+"년"
//							+rs.getInt("month")+"월"
//							+rs.getInt("day")+"일");
//			attendlist.add(CGVO);
			String amu = rs.getInt("year")+"년 "
					+rs.getInt("month")+"월 "
					+rs.getInt("day")+"일";
			v.add(amu);
			String amu1 = rs.getString("f_time");
			v1.add(amu1);
			String amu2 = rs.getString("l_time");
			v2.add(amu2);
				}
			ymd = new String[v.size()];
			fst = new String[v1.size()];
			lst = new String[v2.size()];
			v.copyInto(ymd);
			v1.copyInto(fst);
			v2.copyInto(lst);
		} catch (SQLException se) {
			System.out.println("[[query]] : "+sql.toString());
			System.out.println("[[SQLException]] : "+se.toString());
		} catch (Exception e) {
			System.out.println("[[Exception]] : "+e.toString());
		}finally {
			dbmgr.freeConnection(con, pstmt, rs);
				}
		return attendlist;
	}
	
	public static void main(String[] args) {
		ChulGyulDao cgd = new ChulGyulDao();
//		md.cal_load2("test", 21, 3, 11);
//		System.out.println(md.load_memo);
//		md.login("test", "123");
		ArrayList attendlist = 
				cgd.getChulGyulList("test",2021,04);
		
		for(int i = 0;i<cgd.ymd.length;i++) {
			System.out.println(cgd.ymd[i]+" "
							+cgd.fst[i]+" "
							+cgd.lst[i]);
		}
	}
}

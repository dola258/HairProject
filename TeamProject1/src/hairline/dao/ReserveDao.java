package hairline.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import hairline.db.DBConn;
import hairline.vo.ReserveVo;
import oracle.jdbc.OracleCallableStatement;

public class ReserveDao {

	public List<ReserveVo> getReserveList(String cname) {
		List<ReserveVo> list = new ArrayList<ReserveVo>();
		
		Connection conn = null;
		CallableStatement cstmt = null;
		ResultSet rs = null;
		
		try {
			DBConn db = new DBConn();
			conn = db.getConnection();
			String sql = "{ CALL PKG_HAIR.CUSTOMERS(?, ?) } "; 
			cstmt = conn.prepareCall(sql);
			cstmt.setString(1, cname);
			cstmt.registerOutParameter(2, oracle.jdbc.OracleTypes.CURSOR);
			cstmt.execute();
			
			OracleCallableStatement ocstmt = (OracleCallableStatement) cstmt; 
			rs = ocstmt.getCursor(2);
			while( rs.next() ) {
				ReserveVo vo = new ReserveVo();
				vo.setIdx(rs.getInt("IDX"));
				vo.setCname(rs.getString("CNAME"));
				vo.setCtel(rs.getString("CTEL"));
				vo.setCbirth(rs.getString("CBIRTH"));
				vo.setRegdate(rs.getString("REGDATE"));
				vo.setDid(rs.getString("DID"));
				vo.setSpecifics(rs.getString("SPECIFICS"));
				list.add(vo);
				
			}
			
		} catch( SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if( rs    != null ) rs.close();
				if( cstmt != null ) cstmt.close();
				if( conn  != null ) conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return list;
	}

	public List<ReserveVo> getRes_List(String rdate) {
		List<ReserveVo> list = new ArrayList<ReserveVo>();
		
		Connection conn = null;
		CallableStatement cstmt = null;
		ResultSet rs = null;
		
		try {
			DBConn db = new DBConn();
			conn = db.getConnection();	 
			String sql = "{ CALL PKG_HAIR.RESERVE_LIST(?, ?) } "; 
			cstmt = conn.prepareCall(sql);
			cstmt.setString(1, rdate);
			cstmt.registerOutParameter(2, oracle.jdbc.OracleTypes.CURSOR);
			cstmt.execute();
			
			OracleCallableStatement ocstmt = (OracleCallableStatement) cstmt; 
			rs = ocstmt.getCursor(2);
			
			while( rs.next() ) {
				int idx = rs.getInt("IDX");
				String cname = rs.getString("CNAME");
				String ctel = rs.getString("CTEL");
				String dname = rs.getString("DNAME");
				String hname = rs.getString("HNAME");
				String datetime = rs.getString("DATETIME");
				
				ReserveVo vo = new ReserveVo(idx, "", cname, ctel, "", dname, "", hname, "", "", datetime);
				list.add(vo);
			}
		}catch( SQLException e) {
				e.printStackTrace();
			} finally {
				try {
					if( rs    != null ) rs.close();
					if( cstmt != null ) cstmt.close();
					if( conn  != null ) conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			
			return list;
		}

	public void getReserveInsert(String idx, String did, String ctel, String hcode, String datetime) {
		Connection conn = null;
		CallableStatement cstmt = null;
		
		try {
			DBConn  db = new DBConn();
			conn       = db.getConnection();
			String sql = " { CALL PKG_HAIR.RESERVE_INSERT(?, ?, ?, ?, ?) } ";
			cstmt = conn.prepareCall(sql);
			cstmt.setString(1, idx);
			cstmt.setString(2, ctel);
			cstmt.setString(3, did);
			cstmt.setString(4, hcode);
			cstmt.setString(5, datetime);
			
			cstmt.executeUpdate();
			
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(cstmt !=null && !cstmt.isClosed() ) cstmt.close();
				if(conn  !=null && !conn.isClosed() )  conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	
		
	}

	public void getReserveUpdate(String idx, String did, String hcode, String rdate, String time, String otime) {

		Connection         conn    =  null;
		CallableStatement  cstmt   =  null;
		
		try {
			DBConn   db  =  new DBConn();
			conn         =  db.getConnection();
			String  sql  =  "{ CALL PKG_HAIR.RESERVE_UPDATE(?,?,?,?,?,?) }";
			cstmt        =  conn.prepareCall(sql);
			
			cstmt.setString(1, idx);
			cstmt.setString(2, did);
			cstmt.setString(3, hcode);
			cstmt.setString(4, rdate);
			cstmt.setString(5, time);
			cstmt.setString(6, otime);
			
			cstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}  finally {
			try {
				if( cstmt != null ) cstmt.close();
				if( conn  != null ) conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	
	}

	public void getReserveDelete(String idx, String rdate, String otime) {

		Connection         conn    =  null;
		CallableStatement  cstmt   =  null;
		
		try {
			DBConn   db  =  new DBConn();
			conn         =  db.getConnection();
			String  sql  =  "{ CALL PKG_HAIR.RESERVE_DELETE(?,?,?) }";
			cstmt        =  conn.prepareCall(sql);
			
			cstmt.setString(1, idx);
			cstmt.setString(2, rdate);
			cstmt.setString(3, otime);
		
			cstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}  finally {
			try {
				if( cstmt != null ) cstmt.close();
				if( conn  != null ) conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	
	}
	


		
	}



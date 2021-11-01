package hairline.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLType;
import java.sql.Types;

import hairline.db.DBConn;
import hairline.vo.DesignerVo;
import oracle.jdbc.internal.OracleCallableStatement;

public class DesignerDao {
	Connection conn = null;
	CallableStatement cstmt = null;
	ResultSet rs = null;

	// 로그인 확인
	public int getLoginCheck(String uid, String upw) {
		int ok = 0;

		try {
			DBConn db = new DBConn();
			conn = db.getConnection();
			String sql = " { CALL PKG_HAIR.GETPW(?, ?) } ";
			cstmt = conn.prepareCall(sql);
			cstmt.setString(1, uid);
			cstmt.registerOutParameter(2, Types.VARCHAR);
			
			cstmt.executeQuery();
			
			String pw = cstmt.getString(2);
			
				System.out.println(pw);
				if(pw.equals(upw)) {
					System.out.println("로그인 성공");
					ok = 1;
				} else  {
					System.out.println("암호 불일치");
					ok = 2;
				} 
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if( rs != null ) rs.close();
				if( cstmt != null ) cstmt.close();
				if( conn != null ) conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return ok;
	}

	public DesignerVo getforsession(String uid) {
		DesignerVo designervo = null;
		String sql = " { CALL PKG_HAIR.GET_DESIGNER(?,?) } ";
			
		try {
			DBConn db = new DBConn();
			conn = db.getConnection();
			cstmt = conn.prepareCall(sql);
			cstmt.setString(1, uid);
			cstmt.registerOutParameter(2, oracle.jdbc.OracleTypes.CURSOR);
			cstmt.execute();
			
			OracleCallableStatement ostmt = (OracleCallableStatement) cstmt;
			rs = ostmt.getCursor(2);
			
			if(rs.next()) {
				String db_did = rs.getString("DID");
				String db_pw = rs.getString("PW");
				String db_dname = rs.getString("DNAME");
				String db_tel = rs.getString("DTEL");
				String db_birth = rs.getString("DBIRTH");
				String db_email = rs.getString("EMAIL");
				String db_wname = rs.getString("WPNAME");
				
				designervo = new DesignerVo(db_did, db_pw, db_dname, db_birth, db_email, db_tel, db_wname);
				System.out.println(designervo + "<================");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if( rs != null ) rs.close();
				if( cstmt != null ) cstmt.close();
				if( conn != null ) conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return designervo;
	}


	// 디자이너 추가
	public  void designerInsert(String in_did, String in_pw, String in_dname, 
			String in_dtel, String in_dbirth, String in_email, String in_wpname) {
		
		try {
			DBConn  db = new DBConn();
			conn       = db.getConnection();
			String sql = " { CALL PKG_HAIR.DESIGNER_INSERT(?, ?, ?, ?, ?, ?, ? ) } ";
			cstmt = conn.prepareCall(sql);
			cstmt.setString(1, in_did);
			cstmt.setString(2, in_pw);
			cstmt.setString(3, in_dname);
			cstmt.setString(4, in_dtel);
			cstmt.setString(5, in_dbirth);
			cstmt.setString(6, in_email);
			cstmt.setString(7, in_wpname);
			
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

	public String getDupCheckId(String did) {
		String result = null;
		try {
			DBConn db = new DBConn();
			conn = db.getConnection();
			String sql = " { CALL PKG_HAIR.DESIGNER_IDCHECK(?, ?) } ";
			cstmt = conn.prepareCall(sql);
			cstmt.setString(1, did);
			cstmt.registerOutParameter(2, Types.VARCHAR);
			
			cstmt.executeQuery();
			
			String o_did = cstmt.getString(2);
			
			if( !o_did.equals("nodata") ) {
				result = "중복된 아이디입니다.";
			} else {
				result = "가입 가능한 아이디입니다.";
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if( rs != null ) rs.close();
				if( cstmt != null ) cstmt.close();
				if( conn != null ) conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}

	public String getDupCheckEmail(String email) {
		String result = null;

		try {
			DBConn db = new DBConn();
			conn = db.getConnection();
			String sql = " { CALL PKG_HAIR.DESIGNER_EMAILCHECK(?, ?) } ";
			cstmt = conn.prepareCall(sql);
			cstmt.setString(1, email);
			cstmt.registerOutParameter(2, Types.VARCHAR);
			
			cstmt.executeQuery();
			
			String o_email = cstmt.getString(2);
			
			if( !o_email.equals("nodata") ) {
				result = "중복된 이메일입니다.";
			} else {
				result = "가입 가능한 이메일입니다.";
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if( rs != null ) rs.close();
				if( cstmt != null ) cstmt.close();
				if( conn != null ) conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}

	public String getDupCheckDtel(String dtel) {
		String result = null;

		try {
			DBConn db = new DBConn();
			conn = db.getConnection();
			String sql = " { CALL PKG_HAIR.DESIGNER_DTELCHECK(?, ?) } ";
			cstmt = conn.prepareCall(sql);
			cstmt.setString(1, dtel);
			cstmt.registerOutParameter(2, Types.VARCHAR);
			
			cstmt.executeQuery();
			
			String o_dtel = cstmt.getString(2);
			
			if( !o_dtel.equals("nodata") ) {
				result = "중복된 전화번호입니다.";
			} else {
				result = "가입 가능한 전화번호입니다.";
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if( rs != null ) rs.close();
				if( cstmt != null ) cstmt.close();
				if( conn != null ) conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}

	public String getFindID(String name, String birth, String email) {
		String result = null;
		try {
			DBConn db = new DBConn();
			conn = db.getConnection();
			String sql = " { CALL PKG_HAIR.DESIGNER_FINDID(?, ?, ?, ?) } ";
			cstmt = conn.prepareCall(sql);
			cstmt.setString(1, name);
			cstmt.setString(2, birth);
			cstmt.setString(3, email);
			cstmt.registerOutParameter(4, Types.VARCHAR);
			
			cstmt.executeQuery();
			
			String o_designer = cstmt.getString(4);
			
			if( o_designer.equals("nodata") ) {
				result = "가입된 회원이 아닙니다";
			} else {
				result =  name + "님 이메일로 ID가 전송되었습니다";
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if( rs != null ) rs.close();
				if( cstmt != null ) cstmt.close();
				if( conn != null ) conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}

	public String getFindPW(String name, String birth, String email) {
		String result = null;
		try {
			DBConn db = new DBConn();
			conn = db.getConnection();
			String sql = " { CALL PKG_HAIR.DESIGNER_FINDPW(?, ?, ?, ?) } ";
			cstmt = conn.prepareCall(sql);
			cstmt.setString(1, name);
			cstmt.setString(2, birth);
			cstmt.setString(3, email);
			cstmt.registerOutParameter(4, Types.VARCHAR);
			
			cstmt.executeQuery();
			
			String o_designer = cstmt.getString(4);
			
			if( o_designer.equals("nodata") ) {
				result = "가입된 회원이 아닙니다";
			} else {
				result =  name + "님 이메일로 PW가 전송되었습니다";
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if( rs != null ) rs.close();
				if( cstmt != null ) cstmt.close();
				if( conn != null ) conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}
	
	
}

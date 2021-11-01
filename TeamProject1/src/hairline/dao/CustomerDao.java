package hairline.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import hairline.db.DBConn;
import hairline.vo.CustomerVo;
import oracle.jdbc.OracleCallableStatement;

public class CustomerDao {
	// 고객 목록 조회
	// 고객번호, 고객명, 고객연락처, 고객생년월일, 담당자, 등록일, 마지막헤어, 특징
		public List<CustomerVo> getCustomerList() {
			
			List<CustomerVo>    list  = new ArrayList<CustomerVo>();
			Connection        	conn  = null; 
			CallableStatement 	cstmt = null;
			ResultSet         	rs    = null;
			
		    try {
				DBConn  db   =  new DBConn();
				conn         =  db.getConnection();
				String sql = " { CALL PKG_HAIR.CUSTOMER_LIST(?) } ";
				cstmt = conn.prepareCall(sql);
				cstmt.registerOutParameter(1, oracle.jdbc.OracleTypes.CURSOR);
				cstmt.execute();
				
				OracleCallableStatement ocstmt = (OracleCallableStatement) cstmt; 
				rs = ocstmt.getCursor(1);
				//rs = pstmt.executeQuery();  // PreparedStatement 사용

				while( rs.next() ) {
					int      idx        =  rs.getInt("idx");
					String	 cname		=  rs.getString("cname");
					String   ctel       =  rs.getString("ctel");
					String   cbirth     =  rs.getString("cbirth");   
					String   dname	    =  rs.getString("dname");
					String 	 regdate    =  rs.getString("regdate");
					String   hcode  	=  rs.getString("hcode");
					String   specifics 	=  rs.getString("specifics");
					
					CustomerVo  customerVo    =  new CustomerVo(idx, cname, ctel,
							cbirth, dname, regdate, hcode, "");
					list.add(customerVo);
					System.out.println(list +"\n" + "^^^^^^^^^^^^^^^^^^^^^^");
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			}  finally {
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

		
		
	public static void deleteRow(String idx) {
		Connection         conn  = null;
		CallableStatement  cstmt = null;
		
		try {
			DBConn  db  =  new DBConn();
			conn        =  db.getConnection();
			String sql  = "{CALL  PKG_HAIR.CUSTOMER_DELETE(?) }";
			cstmt       =  conn.prepareCall(sql);
			
			cstmt.setInt(1, Integer.parseInt(idx) );
			
			cstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if( cstmt != null ) cstmt.close();
				if( conn  != null ) conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}			
	}



	public CustomerVo customerInfo(String idx) {
		CustomerVo     customerVo = null;
		Connection          conn  = null;
		CallableStatement   cstmt = null;
		ResultSet           rs    = null;
		
		try {
			DBConn   db   =  new DBConn();
			conn          =  db.getConnection();
			String   sql  =  "{CALL  PKG_HAIR.CUSTOMER_INFO(?, ?) }";
			cstmt         =  conn.prepareCall( sql );
			cstmt.setInt(1,  Integer.parseInt( idx ));
			cstmt.registerOutParameter(2, 
					oracle.jdbc.OracleTypes.CURSOR );
			cstmt.executeQuery();
			
			OracleCallableStatement ocstmt = (OracleCallableStatement) cstmt;
			rs  =  ocstmt.getCursor( 2 );
			
			if( rs.next() ) {
						
				int      idxnum     =  rs.getInt("idx");
				String	 cname		=  rs.getString("cname");
				String   ctel       =  rs.getString("ctel");
				String   cbirth     =  rs.getString("cbirth");   
				String   dname	    =  rs.getString("dname");
				String 	 regdate    =  rs.getString("regdate");
				String   hcode  	=  rs.getString("hcode");
				String   specifics 	=  rs.getString("specifics");
				
				customerVo = new CustomerVo(idxnum, cname, ctel,
						cbirth, dname, regdate, hcode, specifics);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if( cstmt != null ) cstmt.close();
				if( conn  != null ) conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return customerVo;
	}


	
	
		public void customerRegister(CustomerVo vo) {
			
			Connection        conn    = null;
			CallableStatement cstmt   = null;
			
			try {
				DBConn db  = new DBConn();
				conn       = db.getConnection();
				String sql = "{CALL PKG_HAIR.CUSTOMER_REGISTER(?,?,?,?,?) }";
				cstmt      = conn.prepareCall(sql);
				
				cstmt.setString(1, vo.getCname() );
				cstmt.setString(2, vo.getCtel() );
				cstmt.setString(3, vo.getCbirth() );
				cstmt.setString(4, vo.getDname() );
				cstmt.setString(5, vo.getSpecifics() );
				
				cstmt.executeUpdate();
				
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				try {
					if( cstmt != null ) cstmt.close();
					if( conn  != null ) conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
					
		}


		public void customerUpdate(String idx, String cname, String ctel, String cbirth, String specifics, String did) {
			Connection         conn    =  null;
			CallableStatement  cstmt   =  null;
			
			try {
				DBConn   db  =  new DBConn();
				conn         =  db.getConnection();
				String  sql  =  "{ CALL PKG_HAIR.CUSTOMER_UPDATE(?,?,?,?,?,?) }";
				cstmt        =  conn.prepareCall(sql);
				
				cstmt.setString(1, idx);
				cstmt.setString(2, cname);
				cstmt.setString(3, ctel);
				cstmt.setString(4, cbirth);
				cstmt.setString(5, specifics);
				cstmt.setString(6, did);
				
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



		public List<CustomerVo> getSearchCustomerList(String in_cname) {

			List<CustomerVo>    list  = new ArrayList<CustomerVo>();
			Connection        	conn  = null; 
			CallableStatement 	cstmt = null;
			ResultSet         	rs    = null;
			
		    try {
				DBConn  db   =  new DBConn();
				conn         =  db.getConnection();
				String sql = " { CALL PKG_HAIR.SEARCH_CUSTOMER_LIST(?,?) } ";
				cstmt = conn.prepareCall(sql);
				cstmt.setString(1, in_cname);
				cstmt.registerOutParameter(2, oracle.jdbc.OracleTypes.CURSOR);
				cstmt.execute();
				
				OracleCallableStatement ocstmt = (OracleCallableStatement) cstmt; 
				rs = ocstmt.getCursor(2);

				while( rs.next() ) {
					int      idx        =  rs.getInt("idx");
					String	 cname		=  rs.getString("cname");
					String   ctel       =  rs.getString("ctel");
					String   cbirth     =  rs.getString("cbirth");   
					String   dname	    =  rs.getString("dname");
					String 	 regdate    =  rs.getString("regdate");
					String   hcode  	=  rs.getString("hcode");
					String   specifics 	=  rs.getString("specifics");
					
					CustomerVo  customerVo    =  new CustomerVo(idx, cname, ctel,
							cbirth, dname, regdate, hcode, "");
					list.add(customerVo);
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			}  finally {
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




}

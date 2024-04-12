
package org.myeongdong.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.myeongdong.dto.Qna;



public class QnaDAO {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		public List<Qna> getQnaList(){
			List<Qna> qnaList = new ArrayList<>();
			OracleDB oracle = new OracleDB();
			try {
				con = oracle.connect();
				pstmt = con.prepareStatement(SqlLang.LATEST_QNA);
				rs = pstmt.executeQuery();
				while(rs.next()) {
					Qna qna = new Qna(
							rs.getInt("no"),
							rs.getInt("PLEVEL"),
							rs.getInt("PARNO"),
							rs.getString("TITLE"),
							rs.get
							
							);
					qnaList.add(qna);
				}
			} catch(Exception e){
				e.printStackTrace();
			} finally {
				oracle.close(con, pstmt, rs);
			}
			return qnaList;
		}
		
		public Notice getNotice(int no) {
			Notice noti = new Notice();
			OracleDB oracle = new OracleDB();
			
			try {
				con = oracle.connect();
				pstmt = con.prepareStatement(SqlLang.VISITED_UPD_NOTICE);
				pstmt.setInt(1, no);
				pstmt.executeUpdate();
				pstmt = null;
				pstmt = con.prepareStatement(SqlLang.SELECT_NOTICE_BYNO);
				pstmt.setInt(1, no);
				rs = pstmt.executeQuery();
				if(rs.next()) {
					noti.setNo(rs.getInt("no"));
					noti.setTitle(rs.getString("title"));
					noti.setContent(rs.getString("content"));
					noti.setResdate(rs.getString("resdate"));
					noti.setVisited(rs.getInt("visited"));
				}
			} catch(Exception e) {
				e.printStackTrace();
			} finally {
				oracle.close(con, pstmt, rs);
			}
			return noti;
		}
		
		public int insNotice(Notice noti) {
			int cnt = 0;
			OracleDB oracle = new OracleDB();
			try {
				con = oracle.connect();
				pstmt = con.prepareStatement(OracleDB.INS_NOTICE);
				pstmt.setString(1, noti.getTitle());
				pstmt.setString(2, noti.getContent());
				cnt = pstmt.executeUpdate();
			} catch(Exception e) {
				e.printStackTrace();
			} finally {
				oracle.close(con, pstmt);
			}
			return cnt;
		}
		
		public int editProNotice(Notice noti) {
			int cnt = 0;
			OracleDB oracle = new OracleDB();
			try {
				con = oracle.connect();
				pstmt = con.prepareStatement(SqlLang.UPD_NOTICE);
				pstmt.setString(1, noti.getTitle());
				pstmt.setString(2, noti.getContent());
				pstmt.setInt(3, noti.getNo());
				cnt = pstmt.executeUpdate();
			} catch(Exception e) {
				e.printStackTrace();
			} finally {
				oracle.close(con, pstmt);
			}
			return cnt;
		}
		
		public int delNotice(int no){
			int cnt = 0;
			OracleDB oracle = new OracleDB();
			try {
				con = oracle.connect();
				pstmt = con.prepareStatement(SqlLang.DEL_NOTICE);
				pstmt.setInt(1, no);
				cnt = pstmt.executeUpdate();
			} catch(Exception e) {
				e.printStackTrace();
			} finally {
				oracle.close(con, pstmt);
			}
			return cnt;
		}

		public Notice getNotice2(int no) {
			Notice noti = new Notice();
			OracleDB oracle = new OracleDB();
			
			try {
				con = oracle.connect();
				pstmt = null;
				pstmt = con.prepareStatement(SqlLang.SELECT_NOTICE_BYNO);
				pstmt.setInt(1, no);
				rs = pstmt.executeQuery();
				if(rs.next()) {
					noti.setNo(rs.getInt("no"));
					noti.setTitle(rs.getString("title"));
					noti.setContent(rs.getString("content"));
					noti.setResdate(rs.getString("resdate"));
					noti.setVisited(rs.getInt("visited"));
				}
			} catch(Exception e) {
				e.printStackTrace();
			} finally {
				oracle.close(con, pstmt, rs);
			}
			return noti;
		}
	}
	



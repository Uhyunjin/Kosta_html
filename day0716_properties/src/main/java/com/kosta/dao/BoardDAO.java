package com.kosta.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.kosta.db.ConnectionProvider;
import com.kosta.vo.BoardVO;

public class BoardDAO {
	
	public int delete(int no, String pwd) {
		int re=-1;
		String sql="delete board where no=? and pwd=?";
		try {
			Connection conn=ConnectionProvider.getConnection();
			PreparedStatement pstmt=conn.prepareStatement(sql);

			pstmt.setInt(1, no);
			pstmt.setString(2, pwd);
			
			re=pstmt.executeUpdate();
			ConnectionProvider.close(pstmt, conn);
			
		} catch (Exception e) {
			System.out.print(e.getMessage());
		}
		return re;
	}
	
	public int update(BoardVO vo) {
		int re=-1;
		String sql="update board set title=?,content=?,fname=?,fsize=? where no=? and pwd=?";
		try {
			Connection conn=ConnectionProvider.getConnection();
			PreparedStatement pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, vo.getTitle());
			pstmt.setString(2, vo.getContent());
			pstmt.setString(3, vo.getFname());
			pstmt.setInt(4, vo.getFsize());
			pstmt.setInt(5, vo.getNo());
			pstmt.setString(6, vo.getPwd());
			
			re=pstmt.executeUpdate();
			ConnectionProvider.close(pstmt, conn);
			
		} catch (Exception e) {
			System.out.print(e.getMessage());
		}
		return re;
	}
	
	public BoardVO findByNo(int no) {
		BoardVO vo=null;
		String sql="select * from board where no=?";
		try {
			Connection conn=ConnectionProvider.getConnection();
			PreparedStatement pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, no);
			ResultSet rs=pstmt.executeQuery();
			if (rs.next()) {
				vo=new BoardVO(no,
							  rs.getString(2),	
							  rs.getString(3),	
							  rs.getString(4),	
							  rs.getString(5),	
							  rs.getDate(6),	
							  rs.getInt(7),
							  rs.getString(8),	
							  rs.getInt(9)	
						);
			}
			ConnectionProvider.close(rs, pstmt, conn);
		} catch (Exception e) {
			System.out.print(e.getMessage());
		}
		return vo;
	}
	
	//새로운 게시물 번호를 발행해주는 메서드
	public int getNextNo() {
		int no=0;
		String sql="select nvl(max(no),0)+1 from board";
		try {
			Connection conn=ConnectionProvider.getConnection();
			PreparedStatement pstmt=conn.prepareStatement(sql);
			ResultSet rs=pstmt.executeQuery();
			if (rs.next()) {
				no=rs.getInt(1);
			}
			ConnectionProvider.close(rs, pstmt, conn);
		} catch (Exception e) {
			System.out.print(e.getMessage());
		}
		return no;
	}
	
	
	public int insert(BoardVO vo) {
		int re=-1;
		String sql="insert into board values(?,?,?,?,?,sysdate,0,?,?)";
		int no=getNextNo();
		try {
			Connection conn=ConnectionProvider.getConnection();
			PreparedStatement pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, no);
			pstmt.setString(2, vo.getTitle());
			pstmt.setString(3, vo.getWriter());
			pstmt.setString(4, vo.getPwd());
			pstmt.setString(5, vo.getContent());
			pstmt.setString(6, vo.getFname());
			pstmt.setInt(7, vo.getFsize());
			re=pstmt.executeUpdate();
			ConnectionProvider.close(pstmt, conn);
		} catch (Exception e) {
			System.out.print(e.getMessage());
		}
		return re;
	}
	
	public ArrayList<BoardVO> findAll(){
		ArrayList<BoardVO> list=new ArrayList<BoardVO>();
		String sql="select * from board order by no";
		try {
			Connection conn=ConnectionProvider.getConnection();
			Statement stmt=conn.createStatement();
			ResultSet rs=stmt.executeQuery(sql);
			while (rs.next()) {
				list.add(new BoardVO(rs.getInt(1),
									 rs.getString(2),
									 rs.getString(3),
									 rs.getString(4),
									 rs.getString(5),
									 rs.getDate(6),
									 rs.getInt(7),
									 rs.getString(8),	
									 rs.getInt(9)	
									 ));				
			}
			
			ConnectionProvider.close(rs, stmt, conn);
		} catch (Exception e) {
			System.out.print(e.getMessage());
		}
		return list;
	}

}

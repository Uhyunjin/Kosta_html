package com.kosta.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.kosta.db.ConnectionProvider;
import com.kosta.vo.MemberVO;

public class MemberDAO {
	
	//로그인 시 아이디와 암호를 매개변수로 전달받아 회원의 정보가 올바른지 판별하는 메서드
	//아이디도 맞고, 암호도 맞으면 1
	//아이디는 있는데, 암호가 틀리면 0
	//아이디도 없으면 -1
	public int isMember(String id, String pwd) {
		int re=-1;
		String sql="select pwd from member where id=?";
		try {
			Connection conn=ConnectionProvider.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			ResultSet rs=pstmt.executeQuery();
			if (rs.next()) {
				String dbPwd=rs.getString(1);
				if (dbPwd.equals(pwd)) {
					re=1;
				}else {
					re=0;
				}
			}
			ConnectionProvider.close(rs, pstmt, conn);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return re;
	}
	
	//id를 사용할 수 있는지 판별하는 메서드
	//사용가능:1 이미존재하는아이디:0
	public int idCheck(String id) {
		int re=1;
		try {
			String sql="select * from member where id=?";
			Connection conn=ConnectionProvider.getConnection();
			PreparedStatement pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, id);
			ResultSet rs=pstmt.executeQuery();
			if (rs.next()) {
				re=0;				
			}
			ConnectionProvider.close(rs, pstmt, conn);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return re;		
	}

	
	public int insert(MemberVO vo){
		
		int re=-1;
		String sql="insert into member values(?,?,?)";
		try {
			Connection conn=ConnectionProvider.getConnection();
			PreparedStatement pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, vo.getId());
			pstmt.setString(2, vo.getPwd());
			pstmt.setString(3, vo.getName());
			re=pstmt.executeUpdate();
			ConnectionProvider.close(pstmt, conn);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return re;
		
	}
}

package com.kosta.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.kosta.db.ConnectionProvider;
import com.kosta.vo.GoodsVO;

public class GoodsDAO {
	
	public int delete(int no) {
		int re=-1;
		String sql="delete goods set item=?,price=?qty=?,fname=?where no=?";
		try {
			Connection conn=ConnectionProvider.getConnection();
			PreparedStatement pstmt=conn.prepareStatement(sql);

			pstmt.setInt(1, no);
			re=pstmt.executeUpdate();
			ConnectionProvider.close(pstmt, conn);
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return re;
	}
	
	public int update(GoodsVO vo) {
		int re=-1;
		String sql="update goods set item=?,price=?qty=?,fname=? where no=?";
		try {
			Connection conn=ConnectionProvider.getConnection();
			PreparedStatement pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, vo.getItem());
			pstmt.setInt(2, vo.getPrice());
			pstmt.setInt(3, vo.getQty());
			pstmt.setString(4, vo.getFname());
			pstmt.setInt(5, vo.getNo());
			re=pstmt.executeUpdate();
			ConnectionProvider.close(pstmt, conn);
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return re;
	}
	
	
	public int insert(GoodsVO vo) {
		int re=-1;
		String sql="insert into goods values(seg_goods.nextval, ?,?,?,?)";
		try {
			Connection conn=ConnectionProvider.getConnection();
			PreparedStatement pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, vo.getItem());
			pstmt.setInt(2, vo.getPrice());
			pstmt.setInt(3, vo.getQty());
			pstmt.setString(4, vo.getFname());
			re=pstmt.executeUpdate();
			ConnectionProvider.close(pstmt, conn);
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return re;
	}
	
	public ArrayList<GoodsVO> findAll(){
		ArrayList<GoodsVO> list = new ArrayList<GoodsVO>();
		String sql="select * from goods order by no";
		try {
			Connection conn=ConnectionProvider.getConnection();
			PreparedStatement pstmt=conn.prepareStatement(sql);
			ResultSet rs=pstmt.executeQuery();
			while(rs.next()) {
				list.add(new GoodsVO(rs.getInt(1),
									  rs.getString(2),
									  rs.getInt(3),
									  rs.getInt(4),
									  rs.getString(5)
									  
						));
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return list;
	}
	
	public GoodsVO findByNo(int no) {
		GoodsVO vo=null;
		String sql="select * from goods where no=?";
		try {
			Connection conn=ConnectionProvider.getConnection();
			PreparedStatement pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, no);;
			ResultSet rs=pstmt.executeQuery();
			if(rs.next()) {
				vo=new GoodsVO(rs.getInt(1),
									  rs.getString(2),
									  rs.getInt(3),
									  rs.getInt(4),
									  rs.getString(5)
									  
						);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return vo;
		
	}
	
}

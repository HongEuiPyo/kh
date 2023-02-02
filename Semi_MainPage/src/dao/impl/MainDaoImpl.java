package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import common.JDBCTemplate;
import dao.face.MainDao;
import dto.OfficialCocktail;

public class MainDaoImpl implements MainDao{
	
	private PreparedStatement ps = null;
	private ResultSet rs = null;
	
	@Override
	public OfficialCocktail selectBestCocktail1(Connection conn) {
		
		OfficialCocktail best1 = null;
		
		String sql ="";
		sql += "SELECT official_cocktail_name, attach_no FROM (";
		sql += "SELECT official_cocktail_name, attach_no, official_cocktail_vote FROM officialcocktail";
		sql += "ORDER BY official_cocktail_vote DESC)";
		sql += "WHERE ROWNUM <= 3";
		
		try {
			ps = conn.prepareStatement(sql);
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				best1 = new OfficialCocktail();
				
				best1.setOfficial_cocktail_name(rs.getString("official_cocktail_name"));
				best1.setAttach_no(rs.getInt("attach_no"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}	
		return best1;		
	}
	
	@Override
	public OfficialCocktail selectBestCocktail2(Connection conn) {
		
		OfficialCocktail best2 = null;
		
		String sql ="";
		sql += "SELECT official_cocktail_name, attach_no FROM (";
		sql += "SELECT official_cocktail_name, attach_no, official_cocktail_vote FROM officialcocktail";
		sql += "ORDER BY official_cocktail_vote DESC)";
		sql += "WHERE ROWNUM <= 3";
		
		try {
			ps = conn.prepareStatement(sql);
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				best2 = new OfficialCocktail();
				
				best2.setOfficial_cocktail_name(rs.getString("official_cocktail_name"));
				best2.setAttach_no(rs.getInt("attach_no"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}	
		return best2;		
	}
	public OfficialCocktail selectBestCocktail3(Connection conn) {
		
		OfficialCocktail best3 = null;
		
		String sql ="";
		sql += "SELECT official_cocktail_name, attach_no FROM (";
		sql += "SELECT official_cocktail_name, attach_no, official_cocktail_vote FROM officialcocktail";
		sql += "ORDER BY official_cocktail_vote DESC)";
		sql += "WHERE ROWNUM <= 3";
		
		try {
			ps = conn.prepareStatement(sql);
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				best3 = new OfficialCocktail();
				
				best3.setOfficial_cocktail_name(rs.getString("official_cocktail_name"));
				best3.setAttach_no(rs.getInt("attach_no"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}	
		return best3;		
	}
		
	}
	


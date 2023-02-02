package service.impl;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;

import common.JDBCTemplate;
import dao.face.MainDao;
import dao.impl.MainDaoImpl;
import dto.OfficialCocktail;
import service.face.MainService;

public class MainServiceImpl implements MainService {

	private MainDao mainDao = new MainDaoImpl();
	
	@Override
	public OfficialCocktail getBest1(HttpServletRequest req) {
		
		try {
			req.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
					e.printStackTrace();
		}
		
		OfficialCocktail best1 = null;
		best1 = mainDao.selectBestCocktail1(JDBCTemplate.getConnection());
		
		return best1;
		
	}
	
	@Override
	public OfficialCocktail getBest2(HttpServletRequest req) {
		
		try {
			req.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
					e.printStackTrace();
		}
		
		OfficialCocktail best2 = null;
		best2 = mainDao.selectBestCocktail2(JDBCTemplate.getConnection());
		
		return best2;
		
	}
	
	@Override
	public OfficialCocktail getBest3(HttpServletRequest req) {
		
		try {
			req.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
					e.printStackTrace();
		}
		
		OfficialCocktail best3 = null;
		best3 = mainDao.selectBestCocktail3(JDBCTemplate.getConnection());
		
		return best3;
		
	}
	
}

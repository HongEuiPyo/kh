package service.face;

import javax.servlet.http.HttpServletRequest;

import dto.OfficialCocktail;

public interface MainService {

	OfficialCocktail getBest1(HttpServletRequest req);
	
	
	OfficialCocktail getBest2(HttpServletRequest req);
	
	
	OfficialCocktail getBest3(HttpServletRequest req);

}

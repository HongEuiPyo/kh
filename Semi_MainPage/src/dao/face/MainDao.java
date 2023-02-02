package dao.face;

import java.sql.Connection;

import dto.OfficialCocktail;

public interface MainDao {

	OfficialCocktail selectBestCocktail1(Connection conn);
	
	OfficialCocktail selectBestCocktail2(Connection conn);
	
	OfficialCocktail selectBestCocktail3(Connection conn);

}

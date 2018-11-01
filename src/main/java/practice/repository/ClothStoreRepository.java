package practice.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import practice.domain.Clothes;

/**
 * shopsテーブルにアクセスするリポジトリ.
 * 
 * @author yu.terauchi
 *
 */
@Repository
public class ClothStoreRepository {
	@Autowired
	private NamedParameterJdbcTemplate template;

	private static final RowMapper<Clothes> CLOTHES_ROW_MAPPER = (rs, i) -> {
		Clothes cloth = new Clothes();
		cloth.setId(rs.getInt("id"));
		cloth.setCategory(rs.getString("category"));
		cloth.setGenre(rs.getString("genre"));
		cloth.setGender(rs.getInt("gender"));
		cloth.setColor(rs.getString("color"));
		cloth.setPrice(rs.getInt("price"));
		cloth.setSize(rs.getString("size"));
		return cloth;
	};



	/**
	 * 洋服詳細の検索.
	 * 
	 * @param color 色
	 * @param gender　性別
	 * @return　検索した洋服詳細
	 */
	public List<Clothes> findByColorAndGender(String color,String gender) {
		String sql = "SELECT id,category,genre,gender,color,price,size FROM shops WHERE color =:color AND gender =:gender ORDER BY color DESC;";
		SqlParameterSource param = new MapSqlParameterSource().addValue("color", color).addValue("gender", Integer.parseInt(gender));
		List<Clothes> clothList = template.query(sql, param, CLOTHES_ROW_MAPPER);
		return clothList;
	}
}

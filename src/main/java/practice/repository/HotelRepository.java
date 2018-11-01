package practice.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import practice.domain.Hotels;

/**
 * Hotelsテーブルにアクセスするリポジトリ.
 * 
 * @author yu.terauchi
 *
 */
@Repository
public class HotelRepository {
	@Autowired
	private NamedParameterJdbcTemplate template;

	private static final RowMapper<Hotels> HOTELSROWMAPPER = (rs, i) -> {
		Hotels hotel = new Hotels();
		hotel.setId(rs.getInt("id"));
		hotel.setAreaName(rs.getString("area_name"));
		hotel.setHotelName(rs.getString("hotel_name"));
		hotel.setAddress(rs.getString("address"));
		hotel.setNearestStation(rs.getString("nearest_station"));
		hotel.setParking(rs.getString("parking"));
		hotel.setPrice(rs.getInt("price"));
		return hotel;
	};

	// 今回は主キー検索でない
	// public Hotels load(Integer price) {
	// String sql = "SELECT hotel_name,nearest_station,price FROM hotels WHERE price
	// <=:price ";
	// SqlParameterSource param = new MapSqlParameterSource().addValue("price",
	// price);
	// Hotels hotel = template.queryForObject(sql, param, HOTELSROWMAPPER);
	// return hotel;
	// }

	/**
	 * ホテル情報検索.
	 * 
	 * @param price 価格
	 * @return　1行分のホテルに関する情報
	 */
	public List<Hotels> findByUnderPrice(Integer price) {
		String sql = "SELECT id,area_name,hotel_name,address,nearest_station,price,parking FROM hotels WHERE price <=:price ORDER BY price DESC;";
		SqlParameterSource param = new MapSqlParameterSource().addValue("price", price);
		List<Hotels> hotelList = template.query(sql, param, HOTELSROWMAPPER);
		return hotelList;
	}
}
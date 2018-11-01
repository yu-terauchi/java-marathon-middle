package practice.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import practice.domain.BaseballTeam;

/**
 * baseball_teamsテーブルにアクセスするリポジトリクラス.
 * 
 * @author yu.terauchi
 *
 */
@Repository
public class baseballRepository {

	@Autowired
	private NamedParameterJdbcTemplate template;

	private static final RowMapper<BaseballTeam> BASEBALLTEAMROWMAPPER = (rs, i) -> {
		BaseballTeam baseballTeam = new BaseballTeam();
		baseballTeam.setId(rs.getInt("id"));
		baseballTeam.setLeagueName(rs.getString("league_name"));
		baseballTeam.setTeamName(rs.getString("team_name"));
		baseballTeam.setHeadquarters(rs.getString("headquarters"));
		baseballTeam.setInauguration(rs.getString("inauguration"));
		baseballTeam.setHistory(rs.getString("history"));
		return baseballTeam;
	};

	/**
	 * 受け取った引数をもとに1行文のデータを読み込むloadメソッド
	 * 
	 * @param id リクエストパラメータとして受け取った数値
	 * @return　１行分のデータ
	 */
	public BaseballTeam load(Integer id) {
		String sql = "SELECT id,league_name,team_name,headquarters,inauguration,history FROM baseball_teams WHERE id =:id ";
		SqlParameterSource param = new MapSqlParameterSource().addValue("id", id);
		BaseballTeam baseballTeam = template.queryForObject(sql, param, BASEBALLTEAMROWMAPPER);
		return baseballTeam;
	}

	/**
	 * 全件検索をするfindAllメソッド
	 * 
	 * @return　全件検索で読み出したテーブル内のすべてのデータ
	 */
	public List<BaseballTeam> findAll() {
		String sql = "SELECT id,league_name,team_name,headquarters,inauguration,history FROM baseball_teams";
		List<BaseballTeam> baseballTeamList = template.query(sql, BASEBALLTEAMROWMAPPER);
		return baseballTeamList;
	}
}

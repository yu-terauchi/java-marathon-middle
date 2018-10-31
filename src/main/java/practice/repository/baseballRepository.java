package practice.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import practice.domain.teamProf;

/**
 * baseball_teamsテーブルにアクセスするリポジトリクラス.
 * 
 * @author yu.terauchi
 *
 */
@Repository
@Transactional
public class baseballRepository {

	@Autowired
	private NamedParameterJdbcTemplate template;

	private static final RowMapper<teamProf> TEAMPROFROWMAPPER = (rs, i) -> {
		teamProf prof = new teamProf();
		prof.setId(rs.getInt("id"));
		prof.setLeagueName(rs.getString("league_name"));
		prof.setTeamName(rs.getString("team_name"));
		prof.setHeadquarters(rs.getString("headquarters"));
		prof.setInauguration(rs.getString("inauguration"));
		prof.setHistory(rs.getString("history"));
		return prof;
	};

	public teamProf load(Integer id) {
		String sql = "SELECT id,league_name,team_name,headquarters,inauguration,history FROM baseball_teams WHERE id =:id ";
		SqlParameterSource param = new MapSqlParameterSource().addValue("id", id);
		teamProf prof = template.queryForObject(sql, param, TEAMPROFROWMAPPER);
		return prof;
	}
}

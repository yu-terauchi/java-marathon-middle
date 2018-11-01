package practice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import practice.domain.BaseballTeam;
import practice.repository.baseballRepository;

/**
 * 一覧画面よりurlに組み込まれたリクエストパラメータを受け取りbaseball_teamsテーブルにアクセスし、
 * 入手したデータを参照画面に出力するコントローラ.
 * 
 * @author yu.terauchi
 *
 */
@Controller
@Transactional
@RequestMapping("/baseball")
public class BaseballController {

	@Autowired
	private baseballRepository baseballRepository;

	/**
	 * 一覧画面を表示します.
	 * 
	 * @return 一覧画面
	 */
	@RequestMapping("/toLink")
	public String toLink(Model model) {
		List<BaseballTeam> baseballTeamList = baseballRepository.findAll();
		model.addAttribute("baseballTeamList", baseballTeamList);
		System.out.println("一覧画面に飛びます");
		return "/5km/listBaseball";
	}

	/**
	 * 受け取ったidをもとDBにアクセスし、データをとってきて出力画面にフォワードします.
	 * 
	 * @param id 各球団のid
	 * @param model モデル
	 * @return 1球団のデータを収めたオブジェクトをスコープに格納
	 */
	@RequestMapping("/toReference")
	public String toReference(String id, Model model) {

		BaseballTeam baseballTeam = baseballRepository.load(Integer.parseInt(id));
		System.out.println("DBから取り出した一行データをリポジトリからオブジェクトbaseballTeamとして受け取ってきたよ");

		model.addAttribute("baseballTeam", baseballTeam);
		System.out.println("リクエストスコープにオブジェクトデータを格納");

		System.out.println("参照画面に飛びます");
		return "/5km/teamProf";
	}

}

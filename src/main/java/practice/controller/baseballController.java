package practice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import practice.domain.teamProf;
import practice.repository.baseballRepository;

/**
 * 一覧画面よりurlに組み込まれたリクエストパラメータを受け取りbaseball_teamsテーブルにアクセスし、
 * 入手したデータを参照画面に出力するコントローラ.
 * 
 * @author yu.terauchi
 *
 */
@Controller
@RequestMapping("/baseball")
public class baseballController {

	@Autowired
	private baseballRepository baseballRepository;

	/**
	 * 一覧画面を表示します.
	 * 
	 * @return 一覧画面
	 */
	@RequestMapping("/toLink")
	public String toLink() {
		System.out.println("一覧画面に飛びます");
		return "/5km/listBaseball";
	}

	/**
	 * 受け取ったidをもとDBにアクセスし、データをとってきて出力画面にフォワードします.
	 * 
	 * @param id　各球団のid
	 * @param model　モデル
	 * @return 1球団のデータを収めたオブジェクトをスコープに格納
	 */
	@RequestMapping("/toReference")
	public String toReference(Integer id, Model model) {

		teamProf prof = baseballRepository.load(id);
		System.out.println("DBから取り出した一行データをリポジトリからオブジェクトprofとして受け取ってきたよ");

		model.addAttribute("prof", prof);
		System.out.println("リクエストスコープにオブジェクトデータを格納");

		System.out.println("参照画面に飛びます");
		return "/5km/teamProf";
	}

}

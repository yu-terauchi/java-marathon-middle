package practice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import practice.domain.Clothes;
import practice.repository.ClothStoreRepository;

/**
 * shopsテーブルを操作するコントローラ.
 * 
 * @author yu.terauchi
 *
 */
@Controller
@RequestMapping("/clothStore")
public class ClothStoreController {
	
	@Autowired
	private ClothStoreRepository clothStoreRepository;

	/**
	 * 検索画面へ.
	 * 
	 * @return 検索画面
	 */
	@RequestMapping("/toInput")
	public String toInput() {
		System.out.println("検索画面へ");
		return "/15km/selectColor";
	}

	/**
	 * 色と性別の情報を掛け合わせて検索するメソッド.
	 * 
	 * @param model　モデル
	 * @param color　色
	 * @param gender　性別
	 * @return　洋服詳細
	 */
	@RequestMapping("/toOutput")
	public String toOutput(Model model,String color,String gender) {
		
		System.out.println("リストをこれから受け取ります");
		
		List<Clothes> clothList = clothStoreRepository.findByColorAndGender(color,gender);
		model.addAttribute("clothList", clothList);
		System.out.println("検索画面に追加表示" + clothList);
	
		return "/15km/selectColor";
	}
}

//public String toOutput(Model model,@Validated ClothesForm clothesForm, BindingResult result) {
//	if(result.hasErrors()) {
//		return toInput();
//			}
	//List<Clothes> clothList = clothStoreRepository.findByColorAndGender(clothesForm.getColor(),clothesForm.getGender());
	//model.addAttribute("clothList", clothList);
	//System.out.println("検索画面に追加表示");
	//
	//return "/15km/selectColor";
	//}
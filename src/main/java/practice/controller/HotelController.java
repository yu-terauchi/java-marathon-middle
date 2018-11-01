package practice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;

import practice.domain.Hotels;
import practice.form.HotelForm;
import practice.repository.HotelRepository;

/**
 * 価格の値で、hotelsテーブルに検索をかけるコントローラ.
 * 
 * @author yu.terauchi
 *
 */
@Controller
@RequestMapping("/Hotel")
public class HotelController {

	@Autowired
	private HotelRepository hotelRepository;

	/**
	 * 初めに検索画面に飛ぶメソッド
	 * 
	 * @return 検索画面
	 */
	@RequestMapping("/toInput")
	public String toInput() {
		System.out.println("検索画面に飛びます");
		return "/10km/searchHotel";
	}

	/**
	 * hotelsテーブルにアクセスして受け取ったリクエストパラメータで検索をかける.
	 * 
	 * @param model　モデル
	 * @param price　値段
	 * @return　検索画面/表示画面
	 */
	@RequestMapping("/toOutput")
	public String toOutput(Model model, @Validated HotelForm hotelForm, BindingResult result) {

		if(result.hasErrors()) {
			return toInput();
		}
		
		List<Hotels> hotelList = hotelRepository.findByUnderPrice(Integer.parseInt(hotelForm.getPrice()));
		model.addAttribute("hotelList", hotelList);
		System.out.println("検索画面に追加表示");
		return "/10km/searchHotel";
	}

}

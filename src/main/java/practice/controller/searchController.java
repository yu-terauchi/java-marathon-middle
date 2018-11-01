package practice.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/search")
public class searchController {
	
	@RequestMapping("/toInput")
	public String toInput() {
		System.out.println("検索画面に飛びます");
		return "/10km/searchHotel";
	}
	
	public String toOutput() {
		return "/10km/sdsfsfr";
	}

}

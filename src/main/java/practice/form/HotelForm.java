package practice.form;

import javax.validation.constraints.NotBlank;

import org.springframework.web.bind.annotation.RequestMapping;


/**
 * リクエストパラメータを当てはめるフォーム
 * 
 * @author yu.terauchi
 *
 */
@RequestMapping("/hotelform")
public class HotelForm {

	/**価格*/
	@NotBlank(message = "価格を入力してください")
	private String price;

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}




}

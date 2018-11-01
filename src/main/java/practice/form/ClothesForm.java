package practice.form;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 価格情報格納用フォームクラス.
 * 
 * @author yu.terauchi
 *
 */
@RequestMapping("/clothesform")
public class ClothesForm {

	/** 価格 */
	@NotBlank(message = "色を選んでください")
	private String color;
	@NotEmpty(message = "いづれかを選んでください")
	private String gender;

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

}

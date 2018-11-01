package practice.domain;

import javax.validation.constraints.NotBlank;

/**
 * hotelsテーブルから受け取った値を当てはめるドメイン
 * 
 * @author yu.terauchi
 *
 */
public class Hotels {
	/**ID*/
	private Integer id;
	/**地区*/
	private String areaName;
	/**ホテル名*/
	private String hotelName;
	/**所在地*/
	private String address;
	/**最寄り駅*/
	private String nearestStation;
	/**価格*/
	@NotBlank(message = "価格を入力してください")
	private Integer price;
	/**駐車場*/
	private String parking;

	@Override
	public String toString() {
		return "Hotels [id=" + id + ", areaName=" + areaName + ", hotelName=" + hotelName + ", address=" + address
				+ ", nearestStation=" + nearestStation + ", price=" + price + ", parking=" + parking + "]";
	}

	public Hotels() {

	}

	public Hotels(Integer id, String areaName, String hotelName, String address, String nearestStation, Integer price,
			String parking) {
		super();
		this.id = id;
		this.areaName = areaName;
		this.hotelName = hotelName;
		this.address = address;
		this.nearestStation = nearestStation;
		this.price = price;
		this.parking = parking;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAreaName() {
		return areaName;
	}

	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}

	public String getHotelName() {
		return hotelName;
	}

	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getNearestStation() {
		return nearestStation;
	}

	public void setNearestStation(String nearestStation) {
		this.nearestStation = nearestStation;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public String getParking() {
		return parking;
	}

	public void setParking(String parking) {
		this.parking = parking;
	}

}

package practice.domain;

public class Hotels {
	private Integer id;
	private String areaName;
	private String hotelName;
	private String address;
	private String nearestStation;
	private Integer price;
	private boolean parking;
	
	@Override
	public String toString() {
		return "Hotels [id=" + id + ", areaName=" + areaName + ", hotelName=" + hotelName + ", address=" + address
				+ ", nearestStation=" + nearestStation + ", price=" + price + ", parking=" + parking + "]";
	}

	
	
	public Hotels() {
		
	}
	public Hotels(Integer id, String areaName, String hotelName, String address, String nearestStation, Integer price,
			boolean parking) {
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

	public boolean isParking() {
		return parking;
	}

	public void setParking(boolean parking) {
		this.parking = parking;
	}
	
}

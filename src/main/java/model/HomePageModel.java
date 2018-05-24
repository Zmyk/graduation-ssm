/**
 * 
 */
package model;

/**
 * @author zhang
 *
 */
public class HomePageModel {
	private String good_id;
	private String good_name;
	private int price;
	private String date;
	private String url;
	
	
	public HomePageModel() {
		super();
	}


	public HomePageModel(String good_id, String good_name, int price, String date, String url) {
		super();
		this.good_id = good_id;
		this.good_name = good_name;
		this.price = price;
		this.date = date;
		this.url = url;
	}


	public String getGood_id() {
		return good_id;
	}


	public void setGood_id(String good_id) {
		this.good_id = good_id;
	}


	public String getGood_name() {
		return good_name;
	}


	public void setGood_name(String good_name) {
		this.good_name = good_name;
	}


	public int getPrice() {
		return price;
	}


	public void setPrice(int price) {
		this.price = price;
	}


	public String getDate() {
		return date;
	}


	public void setDate(String date) {
		this.date = date;
	}


	public String getUrl() {
		return url;
	}


	public void setUrl(String url) {
		this.url = url;
	}
	
}

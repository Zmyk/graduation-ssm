/**
 * 
 */
package model;

/**
 * @author zhang
 *
 */

public class FavorateView {
	private String date;
	private String good_name;
	private String good_id;
	private int price;
	private String url;
	public FavorateView() {
		super();
	}
	public FavorateView(String date, String good_name, String good_id, int price,String url) {
		super();
		this.date = date;
		this.good_name = good_name;
		this.good_id = good_id;
		this.price = price;
		this.url = url;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getGood_name() {
		return good_name;
	}
	public void setGood_name(String good_name) {
		this.good_name = good_name;
	}
	public String getGood_id() {
		return good_id;
	}
	public void setGood_id(String good_id) {
		this.good_id = good_id;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	
}

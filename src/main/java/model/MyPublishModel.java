/**
 * 
 */
package model;

/**
 * @author zhang
 *
 */
public class MyPublishModel {
	private String good_id;
	private String good_name;
	private int price;
	private String date;
	private String url;
	private int audit_state;
	private int is_solded;
	public MyPublishModel() {
		super();
	}
	public MyPublishModel(String good_id, String good_name, int price, String date, String url, int audit_state,int is_solded) {
		super();
		this.good_id = good_id;
		this.good_name = good_name;
		this.price = price;
		this.date = date;
		this.url = url;
		this.audit_state = audit_state;
		this.is_solded = is_solded;
	}
	public int getIs_solded() {
		return is_solded;
	}
	public void setIs_solded(int is_solded) {
		this.is_solded = is_solded;
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
	public int getAudit_state() {
		return audit_state;
	}
	public void setAudit_state(int audit_state) {
		this.audit_state = audit_state;
	}
	
}

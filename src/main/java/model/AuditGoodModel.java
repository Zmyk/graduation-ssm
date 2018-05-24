/**
 * 
 */
package model;

/**
 * @author zhang
 *
 */
public class AuditGoodModel {
	private String date;
	private String good_name;
	private String good_id;
	private int price;
	private String url;
	private int audit_state;
	public AuditGoodModel() {
		super();
	}
	public AuditGoodModel(String date, String good_name, String good_id, int price, String url, int audit_state) {
		super();
		this.date = date;
		this.good_name = good_name;
		this.good_id = good_id;
		this.price = price;
		this.url = url;
		this.audit_state = audit_state;
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
	public int getAudit_state() {
		return audit_state;
	}
	public void setAudit_state(int audit_state) {
		this.audit_state = audit_state;
	}
	
}

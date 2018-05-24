/**
 * 
 */
package model;

/**
 * @author zhang
 *
 */
public class MessageModel {
	private String good_id;
	private String u_phone;
	private String content;
	private String date;
	private String good_name;
	public MessageModel() {
		super();
	}
	public MessageModel(String good_id, String u_phone, String content, String date, String good_name) {
		super();
		this.good_id = good_id;
		this.u_phone = u_phone;
		this.content = content;
		this.date = date;
		this.good_name = good_name;
	}
	public String getGood_id() {
		return good_id;
	}
	public void setGood_id(String good_id) {
		this.good_id = good_id;
	}
	public String getU_phone() {
		return u_phone;
	}
	public void setU_phone(String u_phone) {
		this.u_phone = u_phone;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
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
	
}

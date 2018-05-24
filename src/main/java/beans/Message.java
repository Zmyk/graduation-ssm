/**
 * 
 */
package beans;

/**
 * @author zhang
 *
 */
public class Message {
	private String good_id;
	private String u_phone;
	private String content;
	private String date;
	public Message() {
		super();
	}
	public Message(String good_id, String u_phone, String content,String date) {
		super();
		this.good_id = good_id;
		this.u_phone = u_phone;
		this.content = content;
		this.date = date;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
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
	
}

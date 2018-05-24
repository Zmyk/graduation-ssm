/**
 * 
 */
package beans;

/**
 * @author zhang
 *
 */
public class Favorate {
	private String u_phone;
	private String good_id;
	private String date;
	public Favorate() {
		super();
	}
	public Favorate(String u_phone, String good_id, String date) {
		super();
		this.u_phone = u_phone;
		this.good_id = good_id;
		this.date = date;
	}
	public String getU_phone() {
		return u_phone;
	}
	public void setU_phone(String u_phone) {
		this.u_phone = u_phone;
	}
	public String getGood_id() {
		return good_id;
	}
	public void setGood_id(String good_id) {
		this.good_id = good_id;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	
}

/**
 * 
 */
package beans;

/**
 * @author zhang
 *
 */
public class Good {
	private String good_id;
	private String publish_user_phone;
	private String contact_phone;
	private String good_name;
	private String good_desc;
	private int price;
	private int origin_price;
	private int good_type_id;
	private String addr;
	private int view_count;
	private int is_solded;
	private int audit_state;
	private String date;
	private String qq;
	public Good(){}
	public Good(String good_id, String publish_user_phone, String contact_phone, String good_name, String good_desc,
			int price, int origin_price, int good_type_id, String addr, int view_count, int is_solded, int audit_state,
			String date, String qq) {
		super();
		this.good_id = good_id;
		this.publish_user_phone = publish_user_phone;
		this.contact_phone = contact_phone;
		this.good_name = good_name;
		this.good_desc = good_desc;
		this.price = price;
		this.origin_price = origin_price;
		this.good_type_id = good_type_id;
		this.addr = addr;
		this.view_count = view_count;
		this.is_solded = is_solded;
		this.audit_state = audit_state;
		this.date = date;
		this.qq = qq;
	}
	public Good(String good_id, String publish_user_phone, String contact_phone, String good_name, String good_desc,
			int price, int origin_price, int good_type_id, String addr, String date, String qq) {
		super();
		this.good_id = good_id;
		this.publish_user_phone = publish_user_phone;
		this.contact_phone = contact_phone;
		this.good_name = good_name;
		this.good_desc = good_desc;
		this.price = price;
		this.origin_price = origin_price;
		this.good_type_id = good_type_id;
		this.addr = addr;
		this.date = date;
		this.qq = qq;
	}
	public String getGood_id() {
		return good_id;
	}
	public void setGood_id(String good_id) {
		this.good_id = good_id;
	}
	public String getPublish_user_phone() {
		return publish_user_phone;
	}
	public void setPublish_user_phone(String publish_user_phone) {
		this.publish_user_phone = publish_user_phone;
	}
	public String getContact_phone() {
		return contact_phone;
	}
	public void setContact_phone(String contact_phone) {
		this.contact_phone = contact_phone;
	}
	public String getGood_name() {
		return good_name;
	}
	public void setGood_name(String good_name) {
		this.good_name = good_name;
	}
	public String getGood_desc() {
		return good_desc;
	}
	public void setGood_desc(String good_desc) {
		this.good_desc = good_desc;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getOrigin_price() {
		return origin_price;
	}
	public void setOrigin_price(int origin_price) {
		this.origin_price = origin_price;
	}
	public int getGood_type_id() {
		return good_type_id;
	}
	public void setGood_type_id(int good_type_id) {
		this.good_type_id = good_type_id;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public int getView_count() {
		return view_count;
	}
	public void setView_count(int view_count) {
		this.view_count = view_count;
	}
	public int getIs_solded() {
		return is_solded;
	}
	public void setIs_solded(int is_solded) {
		this.is_solded = is_solded;
	}
	public int getAudit_state() {
		return audit_state;
	}
	public void setAudit_state(int audit_state) {
		this.audit_state = audit_state;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getQq() {
		return qq;
	}
	public void setQq(String qq) {
		this.qq = qq;
	}
	
	
}

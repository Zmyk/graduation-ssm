/**
 * 
 */
package model;

import java.util.ArrayList;

public class GoodDetail {
//	private int view_count;
	private String good_id;
	private String good_name;
	private int price;
	private int origin_price;
	private String date;
	private String qq;
	private String contact_phone;
	private String u_name;
	private String good_desc;
	private ArrayList<String> url;
	
	
	
	public GoodDetail() {
		super();
	}



	public GoodDetail(String good_id,String good_name, int price, int origin_price, String date, String qq,
			String contact_phone, String u_name, String good_desc, ArrayList<String> url) {
		super();
//		this.view_count = view_count;
		this.good_id = good_id;
		this.good_name = good_name;
		this.price = price;
		this.origin_price = origin_price;
		this.date = date;
		this.qq = qq;
		this.contact_phone = contact_phone;
		this.u_name = u_name;
		this.good_desc = good_desc;
		this.url = url;
	}



//	public int getView_count() {
//		return view_count;
//	}



//	public void setView_count(int view_count) {
//		this.view_count = view_count;
//	}

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



	public int getOrigin_price() {
		return origin_price;
	}



	public void setOrigin_price(int origin_price) {
		this.origin_price = origin_price;
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



	public String getContact_phone() {
		return contact_phone;
	}



	public void setContact_phone(String contact_phone) {
		this.contact_phone = contact_phone;
	}



	public String getU_name() {
		return u_name;
	}



	public void setU_name(String u_name) {
		this.u_name = u_name;
	}



	public String getGood_desc() {
		return good_desc;
	}



	public void setGood_desc(String good_desc) {
		this.good_desc = good_desc;
	}



	public ArrayList<String> getUrl() {
		return url;
	}



	public void setUrl(ArrayList<String> url) {
		this.url = url;
	}
	
	
	
}

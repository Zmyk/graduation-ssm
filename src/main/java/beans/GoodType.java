/**
 * 
 */
package beans;

/**
 * @author zhang
 *
 */
public class GoodType {
	private int id;
	private String type_name;
	public GoodType(int id, String type_name) {
		super();
		this.id = id;
		this.type_name = type_name;
	}
	public GoodType() {
		super();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getType_name() {
		return type_name;
	}
	public void setType_name(String type_name) {
		this.type_name = type_name;
	}
	
	
}

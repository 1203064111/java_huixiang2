package tst.project.bean.product;

import java.io.Serializable;

/**

**

*/

public class FootprintBean implements Serializable{
	private static final long serialVersionUID = 1L;
	private int footprint_id;//
	private String member_id;//
	private String product_id;//
	private String is_delete;//
	private String create_time;//
	private String update_time;//
	public int getFootprint_id(){
		return footprint_id;
	}
	public FootprintBean setFootprint_id(int footprint_id){
		this.footprint_id= footprint_id;
		return this;
	}
	public String getMember_id(){
		return member_id;
	}
	public FootprintBean setMember_id(String member_id){
		this.member_id= member_id;
		return this;
	}
	public String getProduct_id(){
		return product_id;
	}
	public FootprintBean setProduct_id(String product_id){
		this.product_id= product_id;
		return this;
	}
	public String getIs_delete(){
		return is_delete;
	}
	public FootprintBean setIs_delete(String is_delete){
		this.is_delete= is_delete;
		return this;
	}
	public String getCreate_time(){
		return create_time;
	}
	public FootprintBean setCreate_time(String create_time){
		this.create_time= create_time;
		return this;
	}
	public String getUpdate_time(){
		return update_time;
	}
	public FootprintBean setUpdate_time(String update_time){
		this.update_time= update_time;
		return this;
	}
}

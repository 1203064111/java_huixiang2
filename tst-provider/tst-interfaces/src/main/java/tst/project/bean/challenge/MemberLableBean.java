package tst.project.bean.challenge;
import java.io.Serializable;

public class MemberLableBean implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int lable_id;//id
	private int member_id;//用户id
	private int product_class_id;//产品分类标签id
	private int lable_grade;//标签喜好值
	private String update_time;
	private String create_time;
	private int is_delete;
	public int getLable_id() {
		return lable_id;
	}
	public MemberLableBean setLable_id(int lable_id) {
		this.lable_id = lable_id;
		return this;
	}
	public int getMember_id() {
		return member_id;
	}
	public MemberLableBean setMember_id(int member_id) {
		this.member_id = member_id;
		return this;
	}
	public int getProduct_class_id() {
		return product_class_id;
	}
	public MemberLableBean setProduct_class_id(int product_class_id) {
		this.product_class_id = product_class_id;
		return this;
	}
	
	public String getUpdate_time() {
		return update_time;
	}
	public MemberLableBean setUpdate_time(String update_time) {
		this.update_time = update_time;
		return this;
	}
	public String getCreate_time() {
		return create_time;
	}
	public MemberLableBean setCreate_time(String create_time) {
		this.create_time = create_time;
		return this;
	}
	public int getIs_delete() {
		return is_delete;
	}
	public MemberLableBean setIs_delete(int is_delete) {
		this.is_delete = is_delete;
		return this;
	}
	public int getLable_grade() {
		return lable_grade;
	}
	public MemberLableBean setLable_grade(int lable_grade) {
		this.lable_grade = lable_grade;
		return this;
	}
	
	

}

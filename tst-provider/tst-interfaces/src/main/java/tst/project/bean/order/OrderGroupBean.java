package tst.project.bean.order;

import java.io.Serializable;

/**

**

*/

public class OrderGroupBean implements Serializable{
	private static final long serialVersionUID = 1L;
	private int order_group_id;//
	private String member_id;//
	private String product_id;//
	private String need_count;//
	private String now_count;//
	private String group_state;//0:未开始 1:进行中 2:已结束 3:失败
	private String group_state_show;//0:未开始 1:进行中 2:已结束 3:失败
	private String end_time;//活动结束时间
	private String need_time;
	private String is_delete;//
	private String create_time;//
	private String update_time;//
	public int getOrder_group_id(){
		return order_group_id;
	}
	public OrderGroupBean setOrder_group_id(int order_group_id){
		this.order_group_id= order_group_id;
		return this;
	}
	public String getMember_id(){
		return member_id;
	}
	public OrderGroupBean setMember_id(String member_id){
		this.member_id= member_id;
		return this;
	}
	public String getProduct_id(){
		return product_id;
	}
	public OrderGroupBean setProduct_id(String product_id){
		this.product_id= product_id;
		return this;
	}
	public String getNeed_count(){
		return need_count;
	}
	public OrderGroupBean setNeed_count(String need_count){
		this.need_count= need_count;
		return this;
	}
	public String getNow_count(){
		return now_count;
	}
	public OrderGroupBean setNow_count(String now_count){
		this.now_count= now_count;
		return this;
	}
	public String getGroup_state(){
		return group_state;
	}
	public OrderGroupBean setGroup_state(String group_state){
		this.group_state= group_state;//0:未开始 1:进行中 2:已结束 3:失败
		this.group_state_show="1".equals(group_state)?"进行中":
							"2".equals(group_state)?"已结束":
							"3".equals(group_state)?"失败":"未开始";
		return this;
	}
	
	public String getGroup_state_show() {
		return group_state_show;
	}
	public OrderGroupBean setGroup_state_show(String group_state_show) {
		this.group_state_show = group_state_show;
		return this;
	}
	public String getEnd_time(){
		return end_time;
	}
	public OrderGroupBean setEnd_time(String end_time){
		this.end_time= end_time;
		return this;
	}
	
	public String getNeed_time() {
		return need_time;
	}
	public OrderGroupBean setNeed_time(String need_time) {
		this.need_time = need_time;
		return this;
	}
	public String getIs_delete(){
		return is_delete;
	}
	public OrderGroupBean setIs_delete(String is_delete){
		this.is_delete= is_delete;
		return this;
	}
	public String getCreate_time(){
		return create_time;
	}
	public OrderGroupBean setCreate_time(String create_time){
		this.create_time= create_time;
		return this;
	}
	public String getUpdate_time(){
		return update_time;
	}
	public OrderGroupBean setUpdate_time(String update_time){
		this.update_time= update_time;
		return this;
	}
}

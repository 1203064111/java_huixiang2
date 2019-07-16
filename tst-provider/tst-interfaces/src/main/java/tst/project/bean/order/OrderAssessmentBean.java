package tst.project.bean.order;

import java.io.Serializable;

/**

**

*/

public class OrderAssessmentBean implements Serializable{
	private static final long serialVersionUID = 1L;
	private int assessment_id;//
	private String member_id;//用户id
	private String member_nick_name;//用户昵称
	private String member_img;//用户头像
	private String order_merchants_id;//商家订单id
	private String order_product_id;//
	private String product_id;//产品id
	private String assessment_desc;//评价内容
	private String assessment_imgs;//评价图片路径 逗号相隔
	private String assessment_type;//goods:评价订单商品  merchants:评价订单商家
	private String assessment_star1;//星级1
	private String assessment_star2;//星级2
	private String assessment_star3;//星级3
	private String is_delete;//
	private String create_time;//
	private String update_time;//
	public int getAssessment_id(){
		return assessment_id;
	}
	public OrderAssessmentBean setAssessment_id(int assessment_id){
		this.assessment_id= assessment_id;
		return this;
	}
	public String getMember_id(){
		return member_id;
	}
	public OrderAssessmentBean setMember_id(String member_id){
		this.member_id= member_id;
		return this;
	}
	
	public String getMember_nick_name() {
		return member_nick_name;
	}
	public OrderAssessmentBean setMember_nick_name(String member_nick_name) {
		this.member_nick_name = member_nick_name;
		return this;
	}
	
	public String getMember_img() {
		return member_img;
	}
	public OrderAssessmentBean setMember_img(String member_img) {
		this.member_img = member_img;
		return this;
	}
	public String getOrder_merchants_id(){
		return order_merchants_id;
	}
	public OrderAssessmentBean setOrder_merchants_id(String order_merchants_id){
		this.order_merchants_id= order_merchants_id;
		return this;
	}
	public String getOrder_product_id(){
		return order_product_id;
	}
	public OrderAssessmentBean setOrder_product_id(String order_product_id){
		this.order_product_id= order_product_id;
		return this;
	}
	public String getProduct_id(){
		return product_id;
	}
	public OrderAssessmentBean setProduct_id(String product_id){
		this.product_id= product_id;
		return this;
	}
	public String getAssessment_desc(){
		return assessment_desc;
	}
	public OrderAssessmentBean setAssessment_desc(String assessment_desc){
		this.assessment_desc= assessment_desc;
		return this;
	}
	public String getAssessment_imgs(){
		return assessment_imgs;
	}
	public OrderAssessmentBean setAssessment_imgs(String assessment_imgs){
		this.assessment_imgs= assessment_imgs;
		return this;
	}
	public String getAssessment_type(){
		return assessment_type;
	}
	public OrderAssessmentBean setAssessment_type(String assessment_type){
		this.assessment_type= assessment_type;
		return this;
	}
	public String getAssessment_star1(){
		return assessment_star1;
	}
	public OrderAssessmentBean setAssessment_star1(String assessment_star1){
		this.assessment_star1= assessment_star1;
		return this;
	}
	public String getAssessment_star2(){
		return assessment_star2;
	}
	public OrderAssessmentBean setAssessment_star2(String assessment_star2){
		this.assessment_star2= assessment_star2;
		return this;
	}
	public String getAssessment_star3(){
		return assessment_star3;
	}
	public OrderAssessmentBean setAssessment_star3(String assessment_star3){
		this.assessment_star3= assessment_star3;
		return this;
	}
	public String getIs_delete(){
		return is_delete;
	}
	public OrderAssessmentBean setIs_delete(String is_delete){
		this.is_delete= is_delete;
		return this;
	}
	public String getCreate_time(){
		return create_time;
	}
	public OrderAssessmentBean setCreate_time(String create_time){
		this.create_time= create_time;
		return this;
	}
	public String getUpdate_time(){
		return update_time;
	}
	public OrderAssessmentBean setUpdate_time(String update_time){
		this.update_time= update_time;
		return this;
	}
}

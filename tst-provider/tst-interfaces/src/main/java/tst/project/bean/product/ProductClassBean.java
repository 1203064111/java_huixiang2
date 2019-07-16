package tst.project.bean.product;

import java.io.Serializable;
import java.util.List;

/**

**

*/

public class ProductClassBean implements Serializable{
	private static final long serialVersionUID = 1L;
	private int class_id;//
	private String class_ids;//
	private String class_name;//商品分类名称
	private String class_img;//分类图标
	private String class_state;//分类状态 1：上架 0：下架
	private String parent_id;//父id  -1第一级
	private String class_uuid;//分类的唯一标识
	private String class_parent_uuid;//分类的唯一标识路径  比如一级分类的uuid是1  二级的是2  三级的是3 则第三级的parent_uuid就是1#2#3
	private String sort;//权重 排序
	private String is_delete;//
	private String create_time;//
	private String update_time;//
	
	private String start_time;
	private String end_time;
	private List<ProductClassBean> productClassBeans;
	
	public int getClass_id(){
		return class_id;
	}
	public ProductClassBean setClass_id(int class_id){
		this.class_id= class_id;
		return this;
	}
	
	public String getClass_ids() {
		return class_ids;
	}
	public ProductClassBean setClass_ids(String class_ids) {
		this.class_ids = class_ids;
		return this;
	}
	public String getClass_name(){
		return class_name;
	}
	public ProductClassBean setClass_name(String class_name){
		this.class_name= class_name;
		return this;
	}
	public String getClass_img(){
		return class_img;
	}
	public ProductClassBean setClass_img(String class_img){
		this.class_img= class_img;
		return this;
	}
	public String getClass_state(){
		return class_state;
	}
	public ProductClassBean setClass_state(String class_state){
		this.class_state= class_state;
		return this;
	}
	public String getParent_id(){
		return parent_id;
	}
	public ProductClassBean setParent_id(String parent_id){
		this.parent_id= parent_id;
		return this;
	}
	public String getClass_uuid(){
		return class_uuid;
	}
	public ProductClassBean setClass_uuid(String class_uuid){
		this.class_uuid= class_uuid;
		return this;
	}
	public String getClass_parent_uuid(){
		return class_parent_uuid;
	}
	public ProductClassBean setClass_parent_uuid(String class_parent_uuid){
		this.class_parent_uuid= class_parent_uuid;
		return this;
	}
	public String getSort(){
		return sort;
	}
	public ProductClassBean setSort(String sort){
		this.sort= sort;
		return this;
	}
	public String getIs_delete(){
		return is_delete;
	}
	public ProductClassBean setIs_delete(String is_delete){
		this.is_delete= is_delete;
		return this;
	}
	public String getCreate_time(){
		return create_time;
	}
	public ProductClassBean setCreate_time(String create_time){
		this.create_time= create_time;
		return this;
	}
	public String getUpdate_time(){
		return update_time;
	}
	public ProductClassBean setUpdate_time(String update_time){
		this.update_time= update_time;
		return this;
	}
	
	public String getStart_time() {
		return start_time;
	}
	public ProductClassBean setStart_time(String start_time) {
		this.start_time = start_time;
		return this;
	}
	public String getEnd_time() {
		return end_time;
	}
	public ProductClassBean setEnd_time(String end_time) {
		this.end_time = end_time;
		return this;
	}
	public List<ProductClassBean> getProductClassBeans() {
		return productClassBeans;
	}
	public ProductClassBean setProductClassBeans(List<ProductClassBean> productClassBeans) {
		this.productClassBeans = productClassBeans;
		return this;
	}
	
	
}

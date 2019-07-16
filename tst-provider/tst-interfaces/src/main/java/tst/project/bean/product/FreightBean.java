package tst.project.bean.product;

import java.io.Serializable;
import java.util.List;

/**

**

*/

public class FreightBean implements Serializable{
	private static final long serialVersionUID = 1L;
	private int freight_id;//
	private String freight_ids;//
	private String merchants_id;//商家id
	private String freight_name;//运费模板名称
	private String freight_way;//1:买家承担运费 2:卖家承担运费
	private String freight_way_show;//1:买家承担运费 2:卖家承担运费
	private String freight_type;//1:按件 2:按重 3:按体积
	private String freight_type_show;//1:按件 2:按重 3:按体积
	private String freight_range;//默认范围 如果按件 就是默认多少件  如果按体重 就是默认多少kg  如果按体积 就是默认多少平方米
	private String freight_price;//运费最小价格
	private String freight_add_range;//增加运费范围 如果按件 就是每增加多少件  如果按体重 就是每增加多少kg  如果按体积 就是每增加多少平方米
	private String freight_add_price;//增加运费价格
	private String sort;//权重
	private String is_delete;//0：未删除 1：删除
	private String create_time;//
	private String update_time;//
	private List<FreightCityBean> freightCityBeans;//运费各省市价格
	private List<FreightFreeBean> freightFreeBeans;//免运费省市
	public int getFreight_id(){
		return freight_id;
	}
	public FreightBean setFreight_id(int freight_id){
		this.freight_id= freight_id;
		return this;
	}
	
	public String getFreight_ids() {
		return freight_ids;
	}
	public FreightBean setFreight_ids(String freight_ids) {
		this.freight_ids = freight_ids;
		return this;
	}
	public String getMerchants_id(){
		return merchants_id;
	}
	public FreightBean setMerchants_id(String merchants_id){
		this.merchants_id= merchants_id;
		return this;
	}
	public String getFreight_name(){
		return freight_name;
	}
	public FreightBean setFreight_name(String freight_name){
		this.freight_name= freight_name;
		return this;
	}
	public String getFreight_way(){
		return freight_way;
	}
	public FreightBean setFreight_way(String freight_way){
		this.freight_way= freight_way;//1:买家承担运费 2:卖家承担运费
		this.freight_way_show="1".equals(freight_way)?"买家承担运费":"卖家承担运费";
		return this;
	}
	
	public String getFreight_way_show() {
		return freight_way_show;
	}
	public FreightBean setFreight_way_show(String freight_way_show) {
		this.freight_way_show = freight_way_show;
		return this;
	}
	public String getFreight_type(){
		return freight_type;
	}
	public FreightBean setFreight_type(String freight_type){
		this.freight_type= freight_type;//1:按件 2:按重 3:按体积
		this.freight_type_show="1".equals(freight_type)?"按件":
								"2".equals(freight_type)?"按重量":"按体积";
		return this;
	}
	
	public String getFreight_type_show() {
		return freight_type_show;
	}
	public FreightBean setFreight_type_show(String freight_type_show) {
		this.freight_type_show = freight_type_show;
		return this;
	}
	public String getFreight_range(){
		return freight_range;
	}
	public FreightBean setFreight_range(String freight_range){
		this.freight_range= freight_range;
		return this;
	}
	public String getFreight_price(){
		return freight_price;
	}
	public FreightBean setFreight_price(String freight_price){
		this.freight_price= freight_price;
		return this;
	}
	public String getFreight_add_range(){
		return freight_add_range;
	}
	public FreightBean setFreight_add_range(String freight_add_range){
		this.freight_add_range= freight_add_range;
		return this;
	}
	public String getFreight_add_price(){
		return freight_add_price;
	}
	public FreightBean setFreight_add_price(String freight_add_price){
		this.freight_add_price= freight_add_price;
		return this;
	}
	public String getSort(){
		return sort;
	}
	public FreightBean setSort(String sort){
		this.sort= sort;
		return this;
	}
	public String getIs_delete(){
		return is_delete;
	}
	public FreightBean setIs_delete(String is_delete){
		this.is_delete= is_delete;
		return this;
	}
	public String getCreate_time(){
		return create_time;
	}
	public FreightBean setCreate_time(String create_time){
		this.create_time= create_time;
		return this;
	}
	public String getUpdate_time(){
		return update_time;
	}
	public FreightBean setUpdate_time(String update_time){
		this.update_time= update_time;
		return this;
	}
	public List<FreightCityBean> getFreightCityBeans() {
		return freightCityBeans;
	}
	public FreightBean setFreightCityBeans(List<FreightCityBean> freightCityBeans) {
		this.freightCityBeans = freightCityBeans;
		return this;
	}
	public List<FreightFreeBean> getFreightFreeBeans() {
		return freightFreeBeans;
	}
	public FreightBean setFreightFreeBeans(List<FreightFreeBean> freightFreeBeans) {
		this.freightFreeBeans = freightFreeBeans;
		return this;
	}
}

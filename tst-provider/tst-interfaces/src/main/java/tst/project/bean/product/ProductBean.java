package tst.project.bean.product;

import java.io.Serializable;
import java.util.List;

/**

**

*/

public class ProductBean implements Serializable{
	private static final long serialVersionUID = 1L;
	private int product_id;//
	private String product_ids;//
	private String product_name;//产品名称
	private String product_desc;//产品简介
	private String product_img;//产品图片
	private String product_imgs;//产品的轮播图逗号隔开
	private String product_type;//产品类型 1:正常商品 2:完税跨境商品 3:跨境商品 4:挑战商品
	private String product_type_show;//产品类型 1:正常商品 2:完税跨境商品 3:跨境商品
	private String product_url_desc;//产品图文详情
	private String product_address;//产品产地
	private String product_origin_price;//产品原价(区间)
	private String product_origin_min_price;//产品原价最小价
	private String product_origin_max_price;//产品原价最大价
	private String product_now_price;//产品现价(区间)
	private String product_now_min_price;//产品现价最小价
	private String product_now_max_price;//产品现价最大价
	private String group_price;//团购价(区间)
	private String group_min_price;//团购最大价
	private String group_max_price;//团购最大价
	
	private String profit_price;//销售可得价格(区间)
	private String profit_min_price;//销售可得最小价格
	private String profit_max_price;//销售可得最大价格
	private String product_stock;//产品库存
	private String freight_id;//运费模板id
	private String freight_name;//运费内容
	private String product_weight;//产品重量
	private String product_volume;//产品体积
	private String service_ids;//产品包含服务标签的id 逗号隔开
	private String class_id;//分类id
	private String class_parent_id;//分类的父id
	private String class_name;//分类名称
	private String class_uuid;//商品的唯一标识
	private String class_parent_uuid;//分类的唯一标识路径  比如一级分类的uuid是1  二级的是2  三级的是3 则第三级的parent_uuid就是1#2#3
	private String is_group;//是否可团购 此版本默认都是2人团
	private String group_need_count;//拼团需要人数
	private String group_need_time;//拼团时间(小时)
	private String is_promotion;//是否是促销产品
	private String is_recommand;//是否推荐
	private String product_state;//
	private String member_id;//用户id
	private String is_collection;//是否收藏 0:未收藏 1:收藏
	private String is_delete;//
	private String sort;//权重 排序 越大越在前
	private String sort_type;
	private String specification_count;//规格数量
	private String product_sales;//产品销量
	
	private String product_way;//1:线上商城产品 2:售货机产品
	private String is_online;//是否线上商品  1:是 0:不是
	private String create_time;//
	private String update_time;//
	private List<ServiceBean> serviceBeans;//服务列表
	private List<ProductSpecificationBean> productSpecificationBeans;//产品规格列表
	
	

	public String getProduct_sales() {
		return product_sales;
	}
	public ProductBean setProduct_sales(String product_sales) {
		this.product_sales = product_sales;
		return this;
	}
	public int getProduct_id(){
		return product_id;
	}
	public ProductBean setProduct_id(int product_id){
		this.product_id= product_id;
		return this;
	}
	
	public String getProduct_ids() {
		return product_ids;
	}
	public ProductBean setProduct_ids(String product_ids) {
		this.product_ids = product_ids;
		return this;
	}
	public String getProduct_name(){
		return product_name;
	}
	public ProductBean setProduct_name(String profuct_name){
		this.product_name= profuct_name;
		return this;
	}
	
	public String getProduct_desc() {
		return product_desc;
	}
	public ProductBean setProduct_desc(String product_desc) {
		this.product_desc = product_desc;
		return this;
	}
	public String getProduct_img(){
		return product_img;
	}
	public ProductBean setProduct_img(String product_img){
		this.product_img= product_img;
		return this;
	}
	public String getProduct_imgs(){
		return product_imgs;
	}
	public ProductBean setProduct_imgs(String product_imgs){
		this.product_imgs= product_imgs;
		return this;
	}
	public String getProduct_type(){
		return product_type;
	}
	public ProductBean setProduct_type(String product_type){
		this.product_type= product_type;///产品类型 1:正常商品 2:完税跨境商品 3:跨境商品
		this.product_type_show="1".equals(product_type)?"正常商品":
								"2".equals(product_type)?"完税跨境商品":"跨境商品";
		return this;
	}
	
	public String getProduct_type_show() {
		return product_type_show;
	}
	public ProductBean setProduct_type_show(String product_type_show) {
		this.product_type_show = product_type_show;
		return this;
	}
	public String getProduct_url_desc(){
		return product_url_desc;
	}
	public ProductBean setProduct_url_desc(String product_url_desc){
		this.product_url_desc= product_url_desc;
		return this;
	}
	
	public String getProduct_address() {
		return product_address;
	}
	public ProductBean setProduct_address(String product_address) {
		this.product_address = product_address;
		return this;
	}
	public String getProduct_origin_price(){
		return product_origin_price;
	}
	public ProductBean setProduct_origin_price(String product_origin_price){
		this.product_origin_price= product_origin_price;
		return this;
	}
	public String getProduct_origin_min_price(){
		return product_origin_min_price;
	}
	public ProductBean setProduct_origin_min_price(String product_origin_min_price){
		this.product_origin_min_price= product_origin_min_price;
		return this;
	}
	public String getProduct_origin_max_price(){
		return product_origin_max_price;
	}
	public ProductBean setProduct_origin_max_price(String product_origin_max_price){
		this.product_origin_max_price= product_origin_max_price;
		return this;
	}
	public String getProduct_now_price(){
		return product_now_price;
	}
	public ProductBean setProduct_now_price(String product_now_price){
		this.product_now_price= product_now_price;
		return this;
	}
	public String getProduct_now_min_price(){
		return product_now_min_price;
	}
	public ProductBean setProduct_now_min_price(String product_now_min_price){
		this.product_now_min_price= product_now_min_price;
		return this;
	}
	public String getProduct_now_max_price(){
		return product_now_max_price;
	}
	public ProductBean setProduct_now_max_price(String product_now_max_price){
		this.product_now_max_price= product_now_max_price;
		return this;
	}
	
	public String getGroup_price() {
		return group_price;
	}
	public ProductBean setGroup_price(String group_price) {
		this.group_price = group_price;
		return this;
	}
	public String getGroup_min_price() {
		return group_min_price;
	}
	public ProductBean setGroup_min_price(String group_min_price) {
		this.group_min_price = group_min_price;
		return this;
	}
	public String getGroup_max_price() {
		return group_max_price;
	}
	public ProductBean setGroup_max_price(String group_max_price) {
		this.group_max_price = group_max_price;
		return this;
	}
	public String getProfit_price(){
		return profit_price;
	}
	public ProductBean setProfit_price(String profit_price){
		this.profit_price= profit_price;
		return this;
	}
	public String getProfit_min_price(){
		return profit_min_price;
	}
	public ProductBean setProfit_min_price(String profit_min_price){
		this.profit_min_price= profit_min_price;
		return this;
	}
	public String getProfit_max_price(){
		return profit_max_price;
	}
	public ProductBean setProfit_max_price(String profit_max_price){
		this.profit_max_price= profit_max_price;
		return this;
	}
	
	public String getProduct_stock() {
		return product_stock;
	}
	public ProductBean setProduct_stock(String product_stock) {
		this.product_stock = product_stock;
		return this;
	}
	public String getFreight_id(){
		return freight_id;
	}
	public ProductBean setFreight_id(String freight_id){
		this.freight_id= freight_id;
		return this;
	}
	
	
	public String getFreight_name() {
		return freight_name;
	}
	public ProductBean setFreight_name(String freight_name) {
		this.freight_name = freight_name;
		return this;
	}
	public String getProduct_weight() {
		return product_weight;
	}
	public ProductBean setProduct_weight(String product_weight) {
		this.product_weight = product_weight;
		return this;
	}
	public String getProduct_volume() {
		return product_volume;
	}
	public ProductBean setProduct_volume(String product_volume) {
		this.product_volume = product_volume;
		return this;
	}
	public String getService_ids(){
		return service_ids;
	}
	public ProductBean setService_ids(String service_ids){
		this.service_ids= service_ids;
		return this;
	}
	public String getClass_id(){
		return class_id;
	}
	public ProductBean setClass_id(String class_id){
		this.class_id= class_id;
		return this;
	}
	
	public String getClass_parent_id() {
		return class_parent_id;
	}
	public ProductBean setClass_parent_id(String class_parent_id) {
		this.class_parent_id = class_parent_id;
		return this;
	}
	public String getClass_name() {
		return class_name;
	}
	public ProductBean setClass_name(String class_name) {
		this.class_name = class_name;
		return this;
	}
	public String getClass_uuid(){
		return class_uuid;
	}
	public ProductBean setClass_uuid(String class_uuid){
		this.class_uuid= class_uuid;
		return this;
	}
	public String getClass_parent_uuid(){
		return class_parent_uuid;
	}
	public ProductBean setClass_parent_uuid(String class_parent_uuid){
		this.class_parent_uuid= class_parent_uuid;
		return this;
	}
	public String getIs_group(){
		return is_group;
	}
	public ProductBean setIs_group(String is_group){
		this.is_group= is_group;
		return this;
	}
	
	
	public String getGroup_need_count() {
		return group_need_count;
	}
	public ProductBean setGroup_need_count(String group_need_count) {
		this.group_need_count = group_need_count;
		return this;
	}
	public String getGroup_need_time() {
		return group_need_time;
	}
	public ProductBean setGroup_need_time(String group_need_time) {
		this.group_need_time = group_need_time;
		return this;
	}
	public String getIs_promotion(){
		return is_promotion;
	}
	public ProductBean setIs_promotion(String is_promotion){
		this.is_promotion= is_promotion;
		return this;
	}
	public String getIs_recommand() {
		return is_recommand;
	}
	public ProductBean setIs_recommand(String is_recommand) {
		this.is_recommand = is_recommand;
		return this;
	}
	public String getProduct_state() {
		return product_state;
	}
	public ProductBean setProduct_state(String product_state) {
		this.product_state = product_state;
		return this;
	}
	
	public String getMember_id() {
		return member_id;
	}
	public ProductBean setMember_id(String member_id) {
		this.member_id = member_id;
		return this;
	}
	public String getIs_collection() {
		return is_collection;
	}
	public ProductBean setIs_collection(String is_collection) {
		this.is_collection = is_collection;
		return this;
	}
	public String getIs_delete(){
		return is_delete;
	}
	public ProductBean setIs_delete(String is_delete){
		this.is_delete= is_delete;
		return this;
	}
	public String getSort(){
		return sort;
	}
	public ProductBean setSort(String sort){
		this.sort= sort;
		return this;
	}
	
	public String getSort_type() {
		return sort_type;
	}
	public ProductBean setSort_type(String sort_type) {
		this.sort_type = sort_type;
		return this;
	}
	public String getSpecification_count() {
		return specification_count;
	}
	public ProductBean setSpecification_count(String specification_count) {
		this.specification_count = specification_count;
		return this;
	}
	
	public String getProduct_way() {
		return product_way;
	}
	public ProductBean setProduct_way(String product_way) {
		this.product_way = product_way;
		return this;
	}
	public String getIs_online() {
		return is_online;
	}
	public ProductBean setIs_online(String is_online) {
		this.is_online = is_online;
		return this;
	}
	public String getCreate_time(){
		return create_time;
	}
	public ProductBean setCreate_time(String create_time){
		this.create_time= create_time;
		return this;
	}
	public String getUpdate_time(){
		return update_time;
	}
	public ProductBean setUpdate_time(String update_time){
		this.update_time= update_time;
		return this;
	}
	
	public List<ServiceBean> getServiceBeans() {
		return serviceBeans;
	}
	public ProductBean setServiceBeans(List<ServiceBean> serviceBeans) {
		this.serviceBeans = serviceBeans;
		return this;
	}
	public List<ProductSpecificationBean> getProductSpecificationBeans() {
		return productSpecificationBeans;
	}
	public ProductBean setProductSpecificationBeans(List<ProductSpecificationBean> productSpecificationBeans) {
		this.productSpecificationBeans = productSpecificationBeans;
		return this;
	}
}

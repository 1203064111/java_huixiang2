package tst.project.bean.product;

import java.io.Serializable;

/**

**

*/

public class GoodsBean implements Serializable{
	private static final long serialVersionUID = 1L;
	private int goods_id;//
	private String goods_ids;//
	private String goods_name;//商品名称
	private String goods_sku;//商品sku
	private String goods_img;//商品图片
	private String goods_price;//商品价格
	private String goods_stock;//商品库存
	private String goods_type;//商品类型 1:正常商品 2:完税跨境商品 3:跨境商品
	private String goods_type_show;//商品类型 1:正常商品 2:完税跨境商品 3:跨境商品
	private String record_id;
	private String record_status;//备案状态（0:未提交 1：待审核 2:已拒绝 3：审核通过 4审核中）
	private String record_status_show;//备案状态（0:未提交 1：待审核 2:已拒绝 3：审核通过 4审核中）
	private String cost_price;//成本价
	
	private String sort;//排序字段
	private String sort_type;//排序方式
	private String is_delete;//
	private String create_time;//
	private String update_time;//
	
	public int getGoods_id(){
		return goods_id;
	}
	public GoodsBean setGoods_id(int goods_id){
		this.goods_id= goods_id;
		return this;
	}

	public String getRecord_id() {
		return record_id;
	}

	public void setRecord_id(String record_id) {
		this.record_id = record_id;
	}

	public String getGoods_ids() {
		return goods_ids;
	}
	public GoodsBean setGoods_ids(String goods_ids) {
		this.goods_ids = goods_ids;
		return this;
	}
	public String getGoods_name(){
		return goods_name;
	}
	public GoodsBean setGoods_name(String goods_name){
		this.goods_name= goods_name;
		return this;
	}
	public String getGoods_sku(){
		return goods_sku;
	}
	public GoodsBean setGoods_sku(String goods_sku){
		this.goods_sku= goods_sku;
		return this;
	}
	public String getGoods_img(){
		return goods_img;
	}
	public GoodsBean setGoods_img(String goods_img){
		this.goods_img= goods_img;
		return this;
	}
	public String getGoods_price(){
		return goods_price;
	}
	public GoodsBean setGoods_price(String goods_price){
		this.goods_price= goods_price;
		return this;
	}
	public String getGoods_stock(){
		return goods_stock;
	}
	public GoodsBean setGoods_stock(String goods_stock){
		this.goods_stock= goods_stock;
		return this;
	}
	public String getGoods_type(){
		return goods_type;
	}
	public GoodsBean setGoods_type(String goods_type){
		this.goods_type= goods_type;
		this.goods_type_show="1".equals(goods_type)?"正常商品":
							"2".equals(goods_type)?"完税跨境商品":"跨境商品";
		return this;
	}
	
	public String getGoods_type_show() {
		return goods_type_show;
	}
	public GoodsBean setGoods_type_show(String goods_type_show) {
		this.goods_type_show = goods_type_show;
		return this;
	}
	
	public String getRecord_status() {
		return record_status;
	}
	public GoodsBean setRecord_status(String record_status) {
		this.record_status = record_status;//备案状态（0:未提交 1：待审核 2:已拒绝 3：审核通过）
		this.record_status_show = "0".equals(record_status)?"未提交":
									"1".equals(record_status)?"待审核":
									"2".equals(record_status)?"已拒绝":
									"3".equals(record_status)?"审核通过":"未提交";
		return this;
	}
	public String getRecord_status_show() {
		return record_status_show;
	}
	public GoodsBean setRecord_status_show(String record_status_show) {
		this.record_status_show = record_status_show;
		return this;
	}
	
	public String getCost_price() {
		return cost_price;
	}
	public GoodsBean setCost_price(String cost_price) {
		this.cost_price = cost_price;
		return this;
	}
	
	public String getSort() {
		return sort;
	}
	public GoodsBean setSort(String sort) {
		this.sort = sort;
		return this;
	}
	public String getSort_type() {
		return sort_type;
	}
	public GoodsBean setSort_type(String sort_type) {
		this.sort_type = sort_type;
		return this;
	}
	public String getIs_delete(){
		return is_delete;
	}
	public GoodsBean setIs_delete(String is_delete){
		this.is_delete= is_delete;
		return this;
	}
	public String getCreate_time(){
		return create_time;
	}
	public GoodsBean setCreate_time(String create_time){
		this.create_time= create_time;
		return this;
	}
	public String getUpdate_time(){
		return update_time;
	}
	public GoodsBean setUpdate_time(String update_time){
		this.update_time= update_time;
		return this;
	}
	
}

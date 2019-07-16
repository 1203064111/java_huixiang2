package tst.project.bean.product;

import java.io.Serializable;

/**

**

*/

public class GoodsBatchBean implements Serializable{
	private static final long serialVersionUID = 1L;
	private int batch_id;//
	private String batch_no;//批次号
	private String purchase_id;//采购id
	private String goods_id;//商品id
	private String goods_name;//商品名称
	private String batch_price;//这批次的商品价格
	private String batch_stock;//这批次的实际入库商品库存
	private String batch_now_stock;//本批次 现有的库存
	private String batch_unqualified_stock;//本批次 不合格库存数
	private String purchase_stock;//本批次 采购库存
	private String logistics_price;//物流费用
	private String taxation_price;//税费
	private String is_delete;//
	private String create_time;//
	private String update_time;//
	public int getBatch_id(){
		return batch_id;
	}
	public GoodsBatchBean setBatch_id(int batch_id){
		this.batch_id= batch_id;
		return this;
	}
	public String getBatch_no(){
		return batch_no;
	}
	public GoodsBatchBean setBatch_no(String batch_no){
		this.batch_no= batch_no;
		return this;
	}
	
	public String getPurchase_id() {
		return purchase_id;
	}
	public GoodsBatchBean setPurchase_id(String purchase_id) {
		this.purchase_id = purchase_id;
		return this;
	}
	public String getGoods_id(){
		return goods_id;
	}
	public GoodsBatchBean setGoods_id(String goods_id){
		this.goods_id= goods_id;
		return this;
	}
	
	public String getGoods_name() {
		return goods_name;
	}
	public GoodsBatchBean setGoods_name(String goods_name) {
		this.goods_name = goods_name;
		return this;
	}
	public String getBatch_price(){
		return batch_price;
	}
	public GoodsBatchBean setBatch_price(String batch_price){
		this.batch_price= batch_price;
		return this;
	}
	public String getBatch_stock(){
		return batch_stock;
	}
	public GoodsBatchBean setBatch_stock(String batch_stock){
		this.batch_stock= batch_stock;
		return this;
	}
	
	public String getBatch_now_stock() {
		return batch_now_stock;
	}
	public GoodsBatchBean setBatch_now_stock(String batch_now_stock) {
		this.batch_now_stock = batch_now_stock;
		return this;
	}
	public String getBatch_unqualified_stock() {
		return batch_unqualified_stock;
	}
	public GoodsBatchBean setBatch_unqualified_stock(String batch_unqualified_stock) {
		this.batch_unqualified_stock = batch_unqualified_stock;
		return this;
	}
	public String getPurchase_stock() {
		return purchase_stock;
	}
	public GoodsBatchBean setPurchase_stock(String purchase_stock) {
		this.purchase_stock = purchase_stock;
		return this;
	}
	
	public String getLogistics_price() {
		return logistics_price;
	}
	public GoodsBatchBean setLogistics_price(String logistics_price) {
		this.logistics_price = logistics_price;
		return this;
	}
	public String getTaxation_price() {
		return taxation_price;
	}
	public GoodsBatchBean setTaxation_price(String taxation_price) {
		this.taxation_price = taxation_price;
		return this;
	}
	public String getIs_delete(){
		return is_delete;
	}
	public GoodsBatchBean setIs_delete(String is_delete){
		this.is_delete= is_delete;
		return this;
	}
	public String getCreate_time(){
		return create_time;
	}
	public GoodsBatchBean setCreate_time(String create_time){
		this.create_time= create_time;
		return this;
	}
	public String getUpdate_time(){
		return update_time;
	}
	public GoodsBatchBean setUpdate_time(String update_time){
		this.update_time= update_time;
		return this;
	}
}

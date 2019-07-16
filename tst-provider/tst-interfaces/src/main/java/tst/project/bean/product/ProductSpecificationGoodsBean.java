package tst.project.bean.product;

import java.io.Serializable;

/**

**

*/

public class ProductSpecificationGoodsBean implements Serializable{
	private static final long serialVersionUID = 1L;
	private int specification_goods_id;//
	private String product_id;//产品id
	private String specification_id;//规格id
	private String goods_id;//商品id
	private String goods_name;//商品名称
	private String goods_stock;//商品库存
	private String goods_num;//打包商品数量
	private String cost_price;//成本价
	private String specification_uuid;//记录本次处理的规格uuid  用于处理商品库存归还
	private String is_delete;//
	private String create_time;//
	private String update_time;//
	public int getSpecification_goods_id(){
		return specification_goods_id;
	}
	public ProductSpecificationGoodsBean setSpecification_goods_id(int specification_goods_id){
		this.specification_goods_id= specification_goods_id;
		return this;
	}
	public String getProduct_id(){
		return product_id;
	}
	public ProductSpecificationGoodsBean setProduct_id(String product_id){
		this.product_id= product_id;
		return this;
	}
	public String getSpecification_id(){
		return specification_id;
	}
	public ProductSpecificationGoodsBean setSpecification_id(String specification_id){
		this.specification_id= specification_id;
		return this;
	}
	public String getGoods_id(){
		return goods_id;
	}
	public ProductSpecificationGoodsBean setGoods_id(String goods_id){
		this.goods_id= goods_id;
		return this;
	}
	
	public String getGoods_name() {
		return goods_name;
	}
	public ProductSpecificationGoodsBean setGoods_name(String goods_name) {
		this.goods_name = goods_name;
		return this;
	}
	public String getGoods_stock() {
		return goods_stock;
	}
	public ProductSpecificationGoodsBean setGoods_stock(String goods_stock) {
		this.goods_stock = goods_stock;
		return this;
	}
	public String getGoods_num(){
		return goods_num;
	}
	public ProductSpecificationGoodsBean setGoods_num(String goods_num){
		this.goods_num= goods_num;
		return this;
	}
	
	public String getCost_price() {
		return cost_price;
	}
	public ProductSpecificationGoodsBean setCost_price(String cost_price) {
		this.cost_price = cost_price;
		return this;
	}
	public String getSpecification_uuid() {
		return specification_uuid;
	}
	public ProductSpecificationGoodsBean setSpecification_uuid(String specification_uuid) {
		this.specification_uuid = specification_uuid;
		return this;
	}
	public String getIs_delete(){
		return is_delete;
	}
	public ProductSpecificationGoodsBean setIs_delete(String is_delete){
		this.is_delete= is_delete;
		return this;
	}
	public String getCreate_time(){
		return create_time;
	}
	public ProductSpecificationGoodsBean setCreate_time(String create_time){
		this.create_time= create_time;
		return this;
	}
	public String getUpdate_time(){
		return update_time;
	}
	public ProductSpecificationGoodsBean setUpdate_time(String update_time){
		this.update_time= update_time;
		return this;
	}
}

package tst.project.bean.product;

import java.io.Serializable;
import java.util.List;

/**

**

*/

public class ProductSpecificationBean implements Serializable{
	private static final long serialVersionUID = 1L;
	private int specification_id;//
	private String product_id;//产品id
	private String specification_name;//规格名称
	private String specification_img;//规格图片
	private String specification_stock;//规格库存
	private String specification_origin_price;//规格原价(根据商品计算出来)
	private String specification_price;//规格价格
	private String group_price;//团购价
	private String profit_price;//销售可得价格(让利给店铺)
	private String is_delete;//
	private String create_time;//
	private String update_time;//
	private List<ProductSpecificationGoodsBean> productSpecificationGoodsBeans;//产品规格商品列表
	
	public int getSpecification_id() {
		return specification_id;
	}
	public ProductSpecificationBean setSpecification_id(int specification_id) {
		this.specification_id = specification_id;
		return this;
	}
	public String getProduct_id(){
		return product_id;
	}
	public ProductSpecificationBean setProduct_id(String product_id){
		this.product_id= product_id;
		return this;
	}
	public String getSpecification_name(){
		return specification_name;
	}
	public ProductSpecificationBean setSpecification_name(String specification_name){
		this.specification_name= specification_name;
		return this;
	}
	public String getSpecification_img(){
		return specification_img;
	}
	public ProductSpecificationBean setSpecification_img(String specification_img){
		this.specification_img= specification_img;
		return this;
	}
	public String getSpecification_stock(){
		return specification_stock;
	}
	public ProductSpecificationBean setSpecification_stock(String specification_stock){
		this.specification_stock= specification_stock;
		return this;
	}
	public String getSpecification_origin_price(){
		return specification_origin_price;
	}
	public ProductSpecificationBean setSpecification_origin_price(String specification_origin_price){
		this.specification_origin_price= specification_origin_price;
		return this;
	}
	public String getSpecification_price(){
		return specification_price;
	}
	public ProductSpecificationBean setSpecification_price(String specification_price){
		this.specification_price= specification_price;
		return this;
	}
	public String getGroup_price(){
		return group_price;
	}
	public ProductSpecificationBean setGroup_price(String group_price){
		this.group_price= group_price;
		return this;
	}
	public String getProfit_price(){
		return profit_price;
	}
	public ProductSpecificationBean setProfit_price(String profit_price){
		this.profit_price= profit_price;
		return this;
	}
	public String getIs_delete(){
		return is_delete;
	}
	public ProductSpecificationBean setIs_delete(String is_delete){
		this.is_delete= is_delete;
		return this;
	}
	public String getCreate_time(){
		return create_time;
	}
	public ProductSpecificationBean setCreate_time(String create_time){
		this.create_time= create_time;
		return this;
	}
	public String getUpdate_time(){
		return update_time;
	}
	public ProductSpecificationBean setUpdate_time(String update_time){
		this.update_time= update_time;
		return this;
	}
	public List<ProductSpecificationGoodsBean> getProductSpecificationGoodsBeans() {
		return productSpecificationGoodsBeans;
	}
	public ProductSpecificationBean setProductSpecificationGoodsBeans(List<ProductSpecificationGoodsBean> productSpecificationGoodsBeans) {
		this.productSpecificationGoodsBeans = productSpecificationGoodsBeans;
		return this;
	}
}

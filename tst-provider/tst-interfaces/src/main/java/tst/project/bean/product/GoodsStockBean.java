package tst.project.bean.product;

import java.io.Serializable;

/**

**

*/

public class GoodsStockBean implements Serializable{
	private static final long serialVersionUID = 1L;
	private int stock_id;//
	private String goods_id;//
	private String stock_type;//1:新增批次 2:批次改动增加  3:批次改动减少 4:组成产品减库存 5:产品释放赠库存
	private String stock_type_show;//1:新增批次 2:批次改动增加  3:批次改动减少 4:组成产品减库存 5:产品释放赠库存
	private String goods_stock;//
	private String batch_id;
	private String product_id;
	private String is_delete;//
	private String create_time;//
	private String update_time;//
	public int getStock_id(){
		return stock_id;
	}
	public GoodsStockBean setStock_id(int stock_id){
		this.stock_id= stock_id;
		return this;
	}
	public String getGoods_id(){
		return goods_id;
	}
	public GoodsStockBean setGoods_id(String goods_id){
		this.goods_id= goods_id;
		return this;
	}
	public String getStock_type(){
		return stock_type;
	}
	public GoodsStockBean setStock_type(String stock_type){
		this.stock_type= stock_type;//1:新增批次 2:批次改动增加  3:批次改动减少 4:组成产品减库存 5:产品释放赠库存
		this.stock_type_show="1".equals(stock_type)?"新增批次":
							"2".equals(stock_type)?"批次改动增加":
							"3".equals(stock_type)?"批次改动减少":
							"4".equals(stock_type)?"组成产品减库存":"产品释放赠库存";
		return this;
	}
	public String getStock_type_show() {
		return stock_type_show;
	}
	public GoodsStockBean setStock_type_show(String stock_type_show) {
		this.stock_type_show = stock_type_show;
		return this;
	}
	public String getGoods_stock(){
		return goods_stock;
	}
	public GoodsStockBean setGoods_stock(String goods_stock){
		this.goods_stock= goods_stock;
		return this;
	}
	
	public String getBatch_id() {
		return batch_id;
	}
	public GoodsStockBean setBatch_id(String batch_id) {
		this.batch_id = batch_id;
		return this;
	}
	public String getProduct_id() {
		return product_id;
	}
	public GoodsStockBean setProduct_id(String product_id) {
		this.product_id = product_id;
		return this;
	}
	public String getIs_delete(){
		return is_delete;
	}
	public GoodsStockBean setIs_delete(String is_delete){
		this.is_delete= is_delete;
		return this;
	}
	public String getCreate_time(){
		return create_time;
	}
	public GoodsStockBean setCreate_time(String create_time){
		this.create_time= create_time;
		return this;
	}
	public String getUpdate_time(){
		return update_time;
	}
	public GoodsStockBean setUpdate_time(String update_time){
		this.update_time= update_time;
		return this;
	}
}

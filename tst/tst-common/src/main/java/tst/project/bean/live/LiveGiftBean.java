package tst.project.bean.live;

public class LiveGiftBean {
	private int gift_id;
	private String gift_name;//礼物名称
	private String gift_img;//礼物图标
	private String gift_price;//礼物单价
	private String gift_price_unit_img;//礼物单位图标
	private String gift_state;//0:下架 1:上架
	private String sort;//权重
	private String create_time;//
	private String update_time;//
	private String is_delete;//
	public int getGift_id() {
		return gift_id;
	}
	public LiveGiftBean setGift_id(int gift_id) {
		this.gift_id = gift_id;
		return this;
	}
	public String getGift_name() {
		return gift_name;
	}
	public LiveGiftBean setGift_name(String gift_name) {
		this.gift_name = gift_name;
		return this;
	}
	public String getGift_img() {
		return gift_img;
	}
	public LiveGiftBean setGift_img(String gift_img) {
		this.gift_img = gift_img;
		return this;
	}
	public String getGift_price() {
		return gift_price;
	}
	public LiveGiftBean setGift_price(String gift_price) {
		this.gift_price = gift_price;
		return this;
	}
	public String getGift_price_unit_img() {
		return gift_price_unit_img;
	}
	public LiveGiftBean setGift_price_unit_img(String gift_price_unit_img) {
		this.gift_price_unit_img = gift_price_unit_img;
		return this;
	}
	public String getGift_state() {
		return gift_state;
	}
	public LiveGiftBean setGift_state(String gift_state) {
		this.gift_state = gift_state;
		return this;
	}
	public String getSort() {
		return sort;
	}
	public LiveGiftBean setSort(String sort) {
		this.sort = sort;
		return this;
	}
	public String getCreate_time() {
		return create_time;
	}
	public LiveGiftBean setCreate_time(String create_time) {
		this.create_time = create_time;
		return this;
	}
	public String getUpdate_time() {
		return update_time;
	}
	public LiveGiftBean setUpdate_time(String update_time) {
		this.update_time = update_time;
		return this;
	}
	public String getIs_delete() {
		return is_delete;
	}
	public LiveGiftBean setIs_delete(String is_delete) {
		this.is_delete = is_delete;
		return this;
	}
}

package tst.project.bean.setting;

import java.io.Serializable;

/**

**

*/

public class BannerBean implements Serializable{
	private static final long serialVersionUID = 1L;
	private int banner_id;//
	private String banner_ids;
	private String banner_title;//标题
	private String banner_img;//图片路径
	private String banner_type;//0:无跳转 1:商品 2:外链
	private String sort;//排序
	private String is_delete;//1:删除
	private String create_time;//
	private String update_time;//
	private String banner_url;//外链网址
	private String product_id;//
	private String product_name;//

	public int getBanner_id() {
		return banner_id;
	}

	public void setBanner_id(int banner_id) {
		this.banner_id = banner_id;
	}

	public String getBanner_ids() {
		return banner_ids;
	}

	public void setBanner_ids(String banner_ids) {
		this.banner_ids = banner_ids;
	}

	public String getBanner_title() {
		return banner_title;
	}

	public void setBanner_title(String banner_title) {
		this.banner_title = banner_title;
	}

	public String getBanner_img() {
		return banner_img;
	}

	public void setBanner_img(String banner_img) {
		this.banner_img = banner_img;
	}

	public String getBanner_type() {
		return banner_type;
	}

	public void setBanner_type(String banner_type) {
		this.banner_type = banner_type;
	}

	public String getSort() {
		return sort;
	}

	public void setSort(String sort) {
		this.sort = sort;
	}

	public String getIs_delete() {
		return is_delete;
	}

	public void setIs_delete(String is_delete) {
		this.is_delete = is_delete;
	}

	public String getCreate_time() {
		return create_time;
	}

	public void setCreate_time(String create_time) {
		this.create_time = create_time;
	}

	public String getUpdate_time() {
		return update_time;
	}

	public void setUpdate_time(String update_time) {
		this.update_time = update_time;
	}

	public String getBanner_url() {
		return banner_url;
	}

	public void setBanner_url(String banner_url) {
		this.banner_url = banner_url;
	}

	public String getProduct_id() {
		return product_id;
	}

	public void setProduct_id(String product_id) {
		this.product_id = product_id;
	}

	public String getProduct_name() {
		return product_name;
	}

	public BannerBean setProduct_name(String product_name) {
		this.product_name = product_name;
		return this;
	}
	
}

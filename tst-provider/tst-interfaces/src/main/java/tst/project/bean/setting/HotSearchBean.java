package tst.project.bean.setting;

import java.io.Serializable;

public class HotSearchBean implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int search_id;
	private String search_ids;
	private String search_name;
	private String sort;//权重
	private String is_delete;
	private String update_time;
	private String create_time;
	
	
	public String getSearch_ids() {
		return search_ids;
	}
	public HotSearchBean setSearch_ids(String search_ids) {
		this.search_ids = search_ids;
		return this;
	}
	public String getSort() {
		return sort;
	}
	public HotSearchBean setSort(String sort) {
		this.sort = sort;
		return this;
	}
	public int getSearch_id() {
		return search_id;
	}
	public HotSearchBean setSearch_id(int search_id) {
		this.search_id = search_id;
		return this;
	}
	public String getSearch_name() {
		return search_name;
	}
	public HotSearchBean setSearch_name(String search_name) {
		this.search_name = search_name;
		return this;
	}
	public String getIs_delete() {
		return is_delete;
	}
	public HotSearchBean setIs_delete(String is_delete) {
		this.is_delete = is_delete;
		return this;
	}
	public String getUpdate_time() {
		return update_time;
	}
	public HotSearchBean setUpdate_time(String update_time) {
		this.update_time = update_time;
		return this;
	}
	public String getCreate_time() {
		return create_time;
	}
	public HotSearchBean setCreate_time(String create_time) {
		this.create_time = create_time;
		return this;
	}
	
	

}

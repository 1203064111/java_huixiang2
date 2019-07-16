package tst.project.bean.setting;

import java.io.Serializable;

public class FixedRewardModelBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int model_id;//id
	private String model_ids;
	private String model_name;//模板名称
	private String model_state;//模板状态
	private String model_type;//模板类型 fixed固定值 sales销售分成
	private String update_time;
	private String create_time;
	private int is_delete;
	public int getModel_id() {
		return model_id;
	}
	public FixedRewardModelBean setModel_id(int model_id) {
		this.model_id = model_id;
		return this;
	}
	public String getModel_ids() {
		return model_ids;
	}
	public FixedRewardModelBean setModel_ids(String model_ids) {
		this.model_ids = model_ids;
		return this;
	}
	public String getModel_name() {
		return model_name;
	}
	public FixedRewardModelBean setModel_name(String model_name) {
		this.model_name = model_name;
		return this;
	}
	public String getModel_state() {
		return model_state;
	}
	public FixedRewardModelBean setModel_state(String model_state) {
		this.model_state = model_state;
		return this;
	}
	public String getUpdate_time() {
		return update_time;
	}
	public FixedRewardModelBean setUpdate_time(String update_time) {
		this.update_time = update_time;
		return this;
	}
	public String getCreate_time() {
		return create_time;
	}
	public FixedRewardModelBean setCreate_time(String create_time) {
		this.create_time = create_time;
		return this;
	}
	public int getIs_delete() {
		return is_delete;
	}
	public FixedRewardModelBean setIs_delete(int is_delete) {
		this.is_delete = is_delete;
		return this;
	}
	public String getModel_type() {
		return model_type;
	}
	public FixedRewardModelBean setModel_type(String model_type) {
		this.model_type = model_type;
		return this;
	}

	



}

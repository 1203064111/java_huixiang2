package tst.project.bean.setting;

import java.io.Serializable;

public class RewardTemplateBean implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int template_id;//
	private String template_ids;
	private int rank_start;//排名前区间
	private int rank_end;//排名后区间
	private int rank_percent;// 排名 所获百分比
	private int parent_id;//上级模板id
	private int is_delete;
	private String update_time;
	private String create_time;
	public int getTemplate_id() {
		return template_id;
	}
	public RewardTemplateBean setTemplate_id(int template_id) {
		this.template_id = template_id;
		return this;
	}
	public String getTemplate_ids() {
		return template_ids;
	}
	public RewardTemplateBean setTemplate_ids(String template_ids) {
		this.template_ids = template_ids;
		return this;
	}
	public int getRank_start() {
		return rank_start;
	}
	public RewardTemplateBean setRank_start(int rank_start) {
		this.rank_start = rank_start;
		return this;
	}
	public int getRank_end() {
		return rank_end;
	}
	public RewardTemplateBean setRank_end(int rank_end) {
		this.rank_end = rank_end;
		return this;
	}
	public int getRank_percent() {
		return rank_percent;
	}
	public RewardTemplateBean setRank_percent(int rank_percent) {
		this.rank_percent = rank_percent;
		return this;
	}
	public int getParent_id() {
		return parent_id;
	}
	public RewardTemplateBean setParent_id(int parent_id) {
		this.parent_id = parent_id;
		return this;
	}
	public int getIs_delete() {
		return is_delete;
	}
	public RewardTemplateBean setIs_delete(int is_delete) {
		this.is_delete = is_delete;
		return this;
	}
	public String getUpdate_time() {
		return update_time;
	}
	public RewardTemplateBean setUpdate_time(String update_time) {
		this.update_time = update_time;
		return this;
	}
	public String getCreate_time() {
		return create_time;
	}
	public RewardTemplateBean setCreate_time(String create_time) {
		this.create_time = create_time;
		return this;
	}
	
	
	

}

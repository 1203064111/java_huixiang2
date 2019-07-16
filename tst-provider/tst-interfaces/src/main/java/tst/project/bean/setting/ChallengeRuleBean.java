package tst.project.bean.setting;

import java.io.Serializable;

public class ChallengeRuleBean implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int rule_id;//规则id
	private String rule_ids;
	private String rule_name;//规则名称
	private String rule_img;//规则封面
	private String video;//视频路劲
	private String state;//状态 0下架 1上架
	private String rule_desc;//规则描述
	private int is_delete;
	private String update_time;
	private String create_time;
	
	
	
	public String getRule_desc() {
		return rule_desc;
	}
	public ChallengeRuleBean setRule_desc(String rule_desc) {
		this.rule_desc = rule_desc;
		return this;
	}
	public String getRule_img() {
		return rule_img;
	}
	public ChallengeRuleBean setRule_img(String rule_img) {
		this.rule_img = rule_img;
		return this;
	}
	public int getRule_id() {
		return rule_id;
	}
	public String getRule_ids() {
		return rule_ids;
	}
	public ChallengeRuleBean setRule_ids(String rule_ids) {
		this.rule_ids = rule_ids;
		return this;
	}
	public ChallengeRuleBean setRule_id(int rule_id) {
		this.rule_id = rule_id;
		return this;
	}
	public String getRule_name() {
		return rule_name;
	}
	public ChallengeRuleBean setRule_name(String rule_name) {
		this.rule_name = rule_name;
		return this;
	}
	public String getVideo() {
		return video;
	}
	public ChallengeRuleBean setVideo(String video) {
		this.video = video;
		return this;
	}
	public String getState() {
		return state;
	}
	public ChallengeRuleBean setState(String state) {
		this.state = state;
		return this;
	}
	public int getIs_delete() {
		return is_delete;
	}
	public ChallengeRuleBean setIs_delete(int is_delete) {
		this.is_delete = is_delete;
		return this;
	}
	public String getUpdate_time() {
		return update_time;
	}
	public ChallengeRuleBean setUpdate_time(String update_time) {
		this.update_time = update_time;
		return this;
	}
	public String getCreate_time() {
		return create_time;
	}
	public ChallengeRuleBean setCreate_time(String create_time) {
		this.create_time = create_time;
		return this;
	}
	

}

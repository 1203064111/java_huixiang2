package tst.project.bean.setting;

import java.io.Serializable;

public class MemberRewardBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int reward_id;//id
	private String reward_ids;
	private int rank;//名次
	private String reward_type;//fixed 固定奖金 sales 销售分成
	private String reward_value;//奖金金额
	private String member_id;//得奖用户id
	private String member_account;//
	private String state;//打款状态 0未打款1已打款
	private int challenge_id;//挑战id
	private String update_time;
	private String create_time;
	private int is_delete;
	
	
	public String getMember_account() {
		return member_account;
	}
	public MemberRewardBean setMember_account(String member_account) {
		this.member_account = member_account;
		return this;
	}
	public String getState() {
		return state;
	}
	public MemberRewardBean setState(String state) {
		this.state = state;
		return this;
	}
	public int getReward_id() {
		return reward_id;
	}
	public MemberRewardBean setReward_id(int reward_id) {
		this.reward_id = reward_id;
		return this;
	}
	public String getReward_ids() {
		return reward_ids;
	}
	public MemberRewardBean setReward_ids(String reward_ids) {
		this.reward_ids = reward_ids;
		return this;
	}
	public int getRank() {
		return rank;
	}
	public MemberRewardBean setRank(int rank) {
		this.rank = rank;
		return this;
	}
	public String getReward_type() {
		return reward_type;
	}
	public MemberRewardBean setReward_type(String reward_type) {
		this.reward_type = reward_type;
		return this;
	}
	public String getReward_value() {
		return reward_value;
	}
	public MemberRewardBean setReward_value(String reward_value) {
		this.reward_value = reward_value;
		return this;
	}
	public String getMember_id() {
		return member_id;
	}
	public MemberRewardBean setMember_id(String member_id) {
		this.member_id = member_id;
		return this;
	}
	public int getChallenge_id() {
		return challenge_id;
	}
	public MemberRewardBean setChallenge_id(int challenge_id) {
		this.challenge_id = challenge_id;
		return this;
	}
	public String getUpdate_time() {
		return update_time;
	}
	public MemberRewardBean setUpdate_time(String update_time) {
		this.update_time = update_time;
		return this;
	}
	public String getCreate_time() {
		return create_time;
	}
	public MemberRewardBean setCreate_time(String create_time) {
		this.create_time = create_time;
		return this;
	}
	public int getIs_delete() {
		return is_delete;
	}
	public MemberRewardBean setIs_delete(int is_delete) {
		this.is_delete = is_delete;
		return this;
	}
	




}

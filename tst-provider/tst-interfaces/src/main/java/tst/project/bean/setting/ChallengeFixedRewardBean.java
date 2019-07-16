package tst.project.bean.setting;

import java.io.Serializable;

public class ChallengeFixedRewardBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int reward_id;//id
	private String reward_ids;
	private int rank_start;//排名前区间
	private int rank_end;//排名后区间
	private String rank_value;//排名对应的值
	private int challenge_id;//挑战id
	private String update_time;
	private String create_time;
	private int is_delete;
	public int getReward_id() {
		return reward_id;
	}
	public ChallengeFixedRewardBean setReward_id(int reward_id) {
		this.reward_id = reward_id;
		return this;
	}
	public String getReward_ids() {
		return reward_ids;
	}
	public ChallengeFixedRewardBean setReward_ids(String reward_ids) {
		this.reward_ids = reward_ids;
		return this;
	}
	public int getRank_start() {
		return rank_start;
	}
	public ChallengeFixedRewardBean setRank_start(int rank_start) {
		this.rank_start = rank_start;
		return this;
	}
	public int getRank_end() {
		return rank_end;
	}
	public ChallengeFixedRewardBean setRank_end(int rank_end) {
		this.rank_end = rank_end;
		return this;
	}
	public String getRank_value() {
		return rank_value;
	}
	public ChallengeFixedRewardBean setRank_value(String rank_value) {
		this.rank_value = rank_value;
		return this;
	}
	
	public int getChallenge_id() {
		return challenge_id;
	}
	public ChallengeFixedRewardBean setChallenge_id(int challenge_id) {
		this.challenge_id = challenge_id;
		return this;
	}
	public String getUpdate_time() {
		return update_time;
	}
	public ChallengeFixedRewardBean setUpdate_time(String update_time) {
		this.update_time = update_time;
		return this;
	}
	public String getCreate_time() {
		return create_time;
	}
	public ChallengeFixedRewardBean setCreate_time(String create_time) {
		this.create_time = create_time;
		return this;
	}
	public int getIs_delete() {
		return is_delete;
	}
	public ChallengeFixedRewardBean setIs_delete(int is_delete) {
		this.is_delete = is_delete;
		return this;
	}




}

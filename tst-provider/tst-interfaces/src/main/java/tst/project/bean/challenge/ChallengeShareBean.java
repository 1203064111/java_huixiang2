package tst.project.bean.challenge;
import java.io.Serializable;

public class ChallengeShareBean implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int share_id;//id
	private int member_id;//用户id
	private String update_time;
	private String create_time;
	private int challenge_id;//挑战视频id
	private int is_delete;
	public int getMember_id() {
		return member_id;
	}
	public ChallengeShareBean setMember_id(int member_id) {
		this.member_id = member_id;
		return this;
	}
	public String getUpdate_time() {
		return update_time;
	}
	public ChallengeShareBean setUpdate_time(String update_time) {
		this.update_time = update_time;
		return this;
	}
	public String getCreate_time() {
		return create_time;
	}
	public ChallengeShareBean setCreate_time(String create_time) {
		this.create_time = create_time;
		return this;
	}
	public int getChallenge_id() {
		return challenge_id;
	}
	public ChallengeShareBean setChallenge_id(int challenge_id) {
		this.challenge_id = challenge_id;
		return this;
	}
	
	public int getShare_id() {
		return share_id;
	}
	public ChallengeShareBean setShare_id(int share_id) {
		this.share_id = share_id;
		return this;
	}
	public int getIs_delete() {
		return is_delete;
	}
	public ChallengeShareBean setIs_delete(int is_delete) {
		this.is_delete = is_delete;
		return this;
	}



}

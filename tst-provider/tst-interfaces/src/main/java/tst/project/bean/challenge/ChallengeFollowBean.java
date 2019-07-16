package tst.project.bean.challenge;
import java.io.Serializable;

public class ChallengeFollowBean implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int follow_id;//id
	private int member_id;//下级用户id
	private int parent_member_id;//上级用户id
	private String update_time;
	private String create_time;
	private int is_delete;
	
	
	public int getFollow_id() {
		return follow_id;
	}
	public ChallengeFollowBean setFollow_id(int follow_id) {
		this.follow_id = follow_id;
		return this;
	}
	public int getParent_member_id() {
		return parent_member_id;
	}
	public ChallengeFollowBean setParent_member_id(int parent_member_id) {
		this.parent_member_id = parent_member_id;
		return this;
	}
	public int getMember_id() {
		return member_id;
	}
	public ChallengeFollowBean setMember_id(int member_id) {
		this.member_id = member_id;
		return this;
	}
	public String getUpdate_time() {
		return update_time;
	}
	public ChallengeFollowBean setUpdate_time(String update_time) {
		this.update_time = update_time;
		return this;
	}
	public String getCreate_time() {
		return create_time;
	}
	public ChallengeFollowBean setCreate_time(String create_time) {
		this.create_time = create_time;
		return this;
	}
	
	public int getIs_delete() {
		return is_delete;
	}
	public ChallengeFollowBean setIs_delete(int is_delete) {
		this.is_delete = is_delete;
		return this;
	}



}

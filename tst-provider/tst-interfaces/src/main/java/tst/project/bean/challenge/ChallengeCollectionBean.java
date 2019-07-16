package tst.project.bean.challenge;
import java.io.Serializable;

public class ChallengeCollectionBean implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int collection_id;//id
	private int member_id;//用户id
	private String update_time;
	private String create_time;
	private int challenge_id;//挑战视频id
	private int is_delete;
	public int getMember_id() {
		return member_id;
	}
	public ChallengeCollectionBean setMember_id(int member_id) {
		this.member_id = member_id;
		return this;
	}
	public String getUpdate_time() {
		return update_time;
	}
	public ChallengeCollectionBean setUpdate_time(String update_time) {
		this.update_time = update_time;
		return this;
	}
	public String getCreate_time() {
		return create_time;
	}
	public ChallengeCollectionBean setCreate_time(String create_time) {
		this.create_time = create_time;
		return this;
	}
	public int getChallenge_id() {
		return challenge_id;
	}
	public ChallengeCollectionBean setChallenge_id(int challenge_id) {
		this.challenge_id = challenge_id;
		return this;
	}
	
	
	public int getCollection_id() {
		return collection_id;
	}
	public ChallengeCollectionBean setCollection_id(int collection_id) {
		this.collection_id = collection_id;
		return this;
	}
	public int getIs_delete() {
		return is_delete;
	}
	public ChallengeCollectionBean setIs_delete(int is_delete) {
		this.is_delete = is_delete;
		return this;
	}



}

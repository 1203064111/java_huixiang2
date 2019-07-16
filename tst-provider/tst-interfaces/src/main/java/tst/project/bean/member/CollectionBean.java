package tst.project.bean.member;

import java.io.Serializable;

/**

**

*/

public class CollectionBean implements Serializable{
	private static final long serialVersionUID = 1L;
	private int member_collection_id;//
	private String member_id;//用户id
	private String collection_id;//收藏id
	private String collection_type;//收藏类型 1:商品 2:店铺用户id
	private String is_delete;//
	private String create_time;//
	private String update_time;//
	public int getMember_collection_id(){
		return member_collection_id;
	}
	public CollectionBean setMember_collection_id(int member_collection_id){
		this.member_collection_id= member_collection_id;
		return this;
	}
	public String getMember_id(){
		return member_id;
	}
	public CollectionBean setMember_id(String member_id){
		this.member_id= member_id;
		return this;
	}
	public String getCollection_id(){
		return collection_id;
	}
	public CollectionBean setCollection_id(String collection_id){
		this.collection_id= collection_id;
		return this;
	}
	public String getCollection_type(){
		return collection_type;
	}
	public CollectionBean setCollection_type(String collection_type){
		this.collection_type= collection_type;
		return this;
	}
	public String getIs_delete(){
		return is_delete;
	}
	public CollectionBean setIs_delete(String is_delete){
		this.is_delete= is_delete;
		return this;
	}
	public String getCreate_time(){
		return create_time;
	}
	public CollectionBean setCreate_time(String create_time){
		this.create_time= create_time;
		return this;
	}
	public String getUpdate_time(){
		return update_time;
	}
	public CollectionBean setUpdate_time(String update_time){
		this.update_time= update_time;
		return this;
	}
}

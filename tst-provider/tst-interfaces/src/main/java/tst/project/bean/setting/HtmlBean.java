package tst.project.bean.setting;

import java.io.Serializable;

/**

**

*/

public class HtmlBean implements Serializable{
	private static final long serialVersionUID = 1L;
	private int html_id;//
	private String html_name;//标题
	private String html_url_desc;//图文内容详情
	private String sort;//
	private String is_delete;//
	private String create_time;//
	private String update_time;//
	public int getHtml_id(){
		return html_id;
	}
	public HtmlBean setHtml_id(int html_id){
		this.html_id= html_id;
		return this;
	}
	public String getHtml_name(){
		return html_name;
	}
	public HtmlBean setHtml_name(String html_name){
		this.html_name= html_name;
		return this;
	}
	public String getHtml_url_desc(){
		return html_url_desc;
	}
	public HtmlBean setHtml_url_desc(String html_url_desc){
		this.html_url_desc= html_url_desc;
		return this;
	}
	public String getSort(){
		return sort;
	}
	public HtmlBean setSort(String sort){
		this.sort= sort;
		return this;
	}
	public String getIs_delete(){
		return is_delete;
	}
	public HtmlBean setIs_delete(String is_delete){
		this.is_delete= is_delete;
		return this;
	}
	public String getCreate_time(){
		return create_time;
	}
	public HtmlBean setCreate_time(String create_time){
		this.create_time= create_time;
		return this;
	}
	public String getUpdate_time(){
		return update_time;
	}
	public HtmlBean setUpdate_time(String update_time){
		this.update_time= update_time;
		return this;
	}
}

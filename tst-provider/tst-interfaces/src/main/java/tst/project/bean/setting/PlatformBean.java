package tst.project.bean.setting;

import java.io.Serializable;

/**

**

*/

public class PlatformBean implements Serializable{
	private static final long serialVersionUID = 1L;
	private int platform_id;//
	private String platform_name;//平台名称
	private String platform_logo;//平台logo
	private String platform_version;//平台版本号
	private String platform_desc;//平台简介
	private String platfrom_copyright;//平台版权信息
	private String platfrom_copyright_company;//版权归属公司
	private String is_delete;//
	private String create_time;//
	private String update_time;//
	public int getPlatform_id(){
		return platform_id;
	}
	public PlatformBean setPlatform_id(int platform_id){
		this.platform_id= platform_id;
		return this;
	}
	public String getPlatform_name(){
		return platform_name;
	}
	public PlatformBean setPlatform_name(String platform_name){
		this.platform_name= platform_name;
		return this;
	}
	public String getPlatform_logo(){
		return platform_logo;
	}
	public PlatformBean setPlatform_logo(String platform_logo){
		this.platform_logo= platform_logo;
		return this;
	}
	public String getPlatform_version(){
		return platform_version;
	}
	public PlatformBean setPlatform_version(String platform_version){
		this.platform_version= platform_version;
		return this;
	}
	public String getPlatform_desc(){
		return platform_desc;
	}
	public PlatformBean setPlatform_desc(String platform_desc){
		this.platform_desc= platform_desc;
		return this;
	}
	public String getPlatfrom_copyright(){
		return platfrom_copyright;
	}
	public PlatformBean setPlatfrom_copyright(String platfrom_copyright){
		this.platfrom_copyright= platfrom_copyright;
		return this;
	}
	public String getPlatfrom_copyright_company(){
		return platfrom_copyright_company;
	}
	public PlatformBean setPlatfrom_copyright_company(String platfrom_copyright_company){
		this.platfrom_copyright_company= platfrom_copyright_company;
		return this;
	}
	public String getIs_delete(){
		return is_delete;
	}
	public PlatformBean setIs_delete(String is_delete){
		this.is_delete= is_delete;
		return this;
	}
	public String getCreate_time(){
		return create_time;
	}
	public PlatformBean setCreate_time(String create_time){
		this.create_time= create_time;
		return this;
	}
	public String getUpdate_time(){
		return update_time;
	}
	public PlatformBean setUpdate_time(String update_time){
		this.update_time= update_time;
		return this;
	}
}

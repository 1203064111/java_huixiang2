package tst.project.bean;

public class JDBCBean {
	private String Field;//字段名
	private String type;//数据类型
	private String Collation;//编码
	private String Null;//是否为空
	private String key;
	private String Default;
	private String Extra;
	private String Comment;//备注
	
	private String TABLE_NAME;
	private String TABLE_COMMENT;
	
	
	
	
	public String getTABLE_NAME() {
		return TABLE_NAME;
	}
	public void setTABLE_NAME(String tABLE_NAME) {
		TABLE_NAME = tABLE_NAME;
	}
	public String getTABLE_COMMENT() {
		return TABLE_COMMENT;
	}
	public void setTABLE_COMMENT(String tABLE_COMMENT) {
		TABLE_COMMENT = tABLE_COMMENT;
	}
	public String getField() {
		return Field;
	}
	public void setField(String field) {
		Field = field;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getCollation() {
		return Collation;
	}
	public void setCollation(String collation) {
		Collation = collation;
	}
	public String getNull() {
		return Null;
	}
	public void setNull(String null1) {
		Null = null1;
	}
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public String getDefault() {
		return Default;
	}
	public void setDefault(String default1) {
		Default = default1;
	}
	public String getExtra() {
		return Extra;
	}
	public void setExtra(String extra) {
		Extra = extra;
	}
	public String getComment() {
		return Comment;
	}
	public void setComment(String comment) {
		Comment = comment;
	}
}

/**
 * 
 */
package tst.project.page;

import java.io.Serializable;

import org.apache.ibatis.session.RowBounds;

/**
 * @author sjb
 * 
 */
public class PageBean extends RowBounds implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int defaultLimit = 10;
	// 总记录数
	private int total;
	// 查询的起始位置
	private int offset;
	private int page;
	private int pageSize;
	
	private Object object;
	private Object object2;

	public int getDefaultLimit() {
		return defaultLimit;
	}

	public void setDefaultLimit(int defaultLimit) {
		this.defaultLimit = defaultLimit;
	}

	public Object getObject() {
		return object;
	}

	public PageBean setObject(Object object) {
		this.object = object;
		return this;
	}
	
	

	public Object getObject2() {
		return object2;
	}

	public PageBean setObject2(Object object2) {
		this.object2 = object2;
		return this;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public void setOffset(int offset) {
		this.offset = offset;
	}

	public int getPage() {
		return page==0?1:page;
	}

	public PageBean setPage(int page) {
		this.page=page;
		return this;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public int getOffset() {
		return offset;
	}


	public int getPageSize() {
		return pageSize==0?defaultLimit:pageSize;
	}

	public PageBean setPageSize(int pageSize) {
		this.pageSize = pageSize;
		return this;
	}

	public void setMeToDefault() {
		this.offset = NO_ROW_OFFSET;
		this.pageSize = NO_ROW_LIMIT;
	}

	public int getSelectCount() {
		return pageSize + offset;
	}
}

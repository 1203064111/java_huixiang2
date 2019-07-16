package tst.project.dao.controller;

import tst.project.annotation.Mapper;
import tst.project.bean.product.RecordAttachedBean;
import tst.project.bean.product.RecordBean;
import tst.project.page.PageBean;

import java.util.List;

@Mapper
public interface RecordDaoC {
	/**
	 * 添加备案附件信息
	 * @param recordAttachedBean
	 * @return
	 */
	public List<RecordAttachedBean> getRecordAttacheds(RecordAttachedBean recordAttachedBean);
	/**
	 * 删除备案附件信息
	 * @param recordAttachedBean
	 * @return
	 */
	public int deleteRecordAttacheds(RecordAttachedBean recordAttachedBean);
	/**
	 * 修改备案附件信息
	 * @param recordAttachedBean
	 * @return
	 */
	public int updateRecordAttached(RecordAttachedBean recordAttachedBean);
	/**
	 * 添加备案附件信息
	 * @param recordAttachedBean
	 * @return
	 */
	public int insertRecordAttached(RecordAttachedBean recordAttachedBean);
	
    public List<RecordBean> getRecords(RecordBean recordBean, PageBean pageBean);

    public RecordBean getRecordDetail(RecordBean recordBean);

    public int deleteRecord(RecordBean recordBean);

    public int updateRecord(RecordBean recordBean);

    public int insertRecord(RecordBean recordBean);

    public int refusedRecord(RecordBean recordBean);

    public int throughRecord(RecordBean recordBean);

    public List<RecordBean> getRecordsThrough(RecordBean recordBean, PageBean pageBean);
}

package tst.project.controller;

import java.util.List;

import tst.project.bean.product.RecordAttachedBean;
import tst.project.bean.product.RecordBean;
import tst.project.page.PageBean;

/**
 * @author lhw
 */
public interface IRecordServiceC {
    /**
     * 获取备案列表
     *
     * @param recordBean
     * @param pageBean
     * @return
     */
    public Object getRecords(RecordBean recordBean, PageBean pageBean);

    /**
     * 获取备案详情
     *
     * @param recordBean
     * @return
     */
    public Object getRecordDetail(RecordBean recordBean);

    /**
     * 删除备案信息
     *
     * @param recordBean
     * @return
     */
    public Object deleteRecord(RecordBean recordBean);

    /**
     * 更新备案信息
     *
     * @param recordBean
     * @return
     */
    public Object updateRecord(RecordBean recordBean,List<RecordAttachedBean> recordAttachedBeans);

    /**
     * 插入备案信息
     *
     * @param recordBean
     * @return
     */
    public Object insertRecord(RecordBean recordBean,List<RecordAttachedBean> recordAttachedBeans);

    /**
     *
     * 拒绝审核
     * @param recordBean
     * @return
     */
    public Object refusedRecord(RecordBean recordBean);

    /**
     * 通过审核
     * @param recordBean
     * @return
     */
    public Object throughRecord(RecordBean recordBean);


    /**
     * 查询审核通过的备案号
     * @param recordBean
     * @param pageBean
     * @return
     */
    public Object getRecordsThrough(RecordBean recordBean, PageBean pageBean);
}

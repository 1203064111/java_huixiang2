package tst.project.service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tst.project.aspect.AppException;
import tst.project.bean.product.RecordAttachedBean;
import tst.project.bean.product.RecordBean;
import tst.project.controller.IRecordServiceC;
import tst.project.dao.controller.RecordDaoC;
import tst.project.page.PageBean;
import tst.project.utils.HaiguanUtils;
import tst.project.utils.TimeUtils;

import java.util.List;
import java.util.UUID;

@Service
@Transactional(rollbackFor= AppException.class)
public class RecordServiceC implements IRecordServiceC {

    @Autowired
    RecordDaoC recordDaoC;

    @Value("${haiguan_code}")
	private String haiguan_code;
    
    @Value("${haiguan_password}")
	private String haiguan_password;
    
    @Value("${img_path}")
	private String img_path;
    
    @Override
    public Object getRecords(RecordBean recordBean, PageBean pageBean) {
        List<RecordBean> recordBeans=recordDaoC.getRecords(recordBean, pageBean);
        return pageBean.setObject(recordBeans);
    }

    @Override
    public Object getRecordDetail(RecordBean recordBean) {
    	RecordBean recordBean2=recordDaoC.getRecordDetail(recordBean);
    	if(recordBean2!=null){
    		List<RecordAttachedBean> recordAttachedBeans=recordDaoC
    				.getRecordAttacheds(new RecordAttachedBean().setRecord_id(recordBean2.getRecord_id()+""));
    		recordBean2.setRecordAttachedBeans(recordAttachedBeans);
    	}
        return recordBean2;
    }

    @Override
    public Object deleteRecord(RecordBean recordBean) {
        // TODO Auto-generated method stub
        int num = recordDaoC.deleteRecord(recordBean);
        if (num <= 0) {
            throw new AppException("删除失败!");
        }
        return num;
    }

    @Override
    public Object updateRecord(RecordBean recordBean,List<RecordAttachedBean> recordAttachedBeans) {
        // TODO Auto-generated method stub
        int num=recordDaoC.updateRecord(recordBean);
        if(num<=0){
            throw new AppException("修改失败!");
        }
        
        String uuid=UUID.randomUUID().toString();
        recordDaoC.deleteRecordAttacheds(new RecordAttachedBean().setRecord_id(recordBean.getRecord_id()+""));
        if(recordAttachedBeans!=null){
        	for (int i = 0; i < recordAttachedBeans.size(); i++) {
        		RecordAttachedBean recordAttachedBean=recordAttachedBeans.get(i);
        		if(recordAttachedBean.getAttached_id()==0){
        			num=recordDaoC.insertRecordAttached(recordAttachedBean
            				.setRecord_id(recordBean.getRecord_id()+"")
            				.setGUID(uuid)
            				.setGUID_HEAD(uuid));
                    if(num<=0){
                        throw new AppException("附件插入失败!");
                    }
        		}else{
        			num=recordDaoC.updateRecordAttached(recordAttachedBean
            				.setRecord_id(recordBean.getRecord_id()+"")
            				.setGUID(uuid)
            				.setGUID_HEAD(uuid));
                    if(num<=0){
                        throw new AppException("附件插入失败!");
                    }
        		}
        		
    		}
        }
        
        if("1".equals(recordBean.getRecord_status())){
        	String SenderId=haiguan_code;//华龙用户名
    		String password=haiguan_password;
    		
    		String ActionType="1";//1:添加新备案 2:修改备案信息
    		
    		String GUID=uuid;
    		String ESHOP_ENT_CODE=haiguan_code;
    		String ESHOP_ENT_NAME=haiguan_code;
    		
    		String EXTERNAL_NO="";
    		String SKU=recordBean.getRecord_sku();//商品货号
    		String CIQ_CODE=recordBean.getRecord_ciq_code();//CIQ编码
    		String GOODS_NAME=recordBean.getRecord_goods_name();//商品名称
    		String BIZ_TYPE=recordBean.getRecord_business_types();//业务类型
    		String GOODS_SPEC=recordBean.getRecord_goods_specification();//规格型号
    		String DECLARE_UNIT=recordBean.getRecord_the_notification();//申报计量单位
    		String LEGAL_UNIT=recordBean.getRecord_legal_units();//法定计量单位
    		String CONV_LEGAL_UNIT_NUM=recordBean.getRecord_reduced_num();//法定计量单位折算数量
    		String HS_CODE=recordBean.getRecord_hs_code();//商品HS编码
    		String IN_AREA_UNIT=recordBean.getRecord_measuring_unit();//入区计量单位
    		String CONV_IN_AREA_UNIT_NUM=recordBean.getRecord_measuring_unit_code();//入区计量单位折算数量
    		String ORIGIN_COUNTRY_CODE=recordBean.getRecord_country_code();//国家地区代码
    		String IS_CNCA_POR=recordBean.getRecord_in_china();//国外生产企业是否在中国注册备案（食药监局、国家认监委）
    		String CHECK_ORG_CODE=recordBean.getRecord_inspection_code();//施检机构的代码
    		String SUPPLIER_NAME=recordBean.getRecord_supplier_name();//供应商名称
    		String PRODUCER_NAME=recordBean.getRecord_enterprise_name();//生产企业名称
    		String IS_CNCA_POR_DOC=recordBean.getRecord_is_attachment();//是否存在食药监局、国家认监委备案附件
    		String IS_ORIGIN_PLACE_CERT=recordBean.getRecord_is_origin();//是否存在原产地证书
    		String IS_TEST_REPORT=recordBean.getRecord_is_report();//是否存在境外官方及第三方机构的检测报告
    		String IS_LEGAL_TICKET=recordBean.getRecord_is_legal();//是否存在合法采购证明（国外进货发票或小票）
    		String IS_MARK_EXCHANGE=recordBean.getRecord_is_translation();//是否存外文标签的中文翻译件
    		
    		String SEND_ENT_CODE=haiguan_code;//发送企业代码
    		
    		String GOODS_TYPE_CODE=recordBean.getRecord_product_code();//商品分类代码
    		String PRODUCT_BRAND=recordBean.getRecord_product_brand();//产品品牌
    		String GOODS_NAME_ENGLISH=recordBean.getRecord_english_name();//英文原名
    		String GOODS_NAME_CHIESE=recordBean.getRecord_translation_name();//中文翻译名
    		String IS_LAW_REVIEW=recordBean.getRecord_is_inspection();//是否法检
    		String PER_INDEX=recordBean.getRecord_performance_indicators();//性能指标
    		String AUTH_INFO=recordBean.getRecord_authentication_information();//认证信息
    		String LICENSE_CODE=recordBean.getRecord_license();//许可证号 
    		String BAR_CODE=recordBean.getRecord_barcode();//商品条形码 
    		String VALIDITY=recordBean.getRecord_period_validity();//产品有效期 
    		String BASESTRADE_MODE=recordBean.getRecord_main_ingredients();//主要成份 
    		String PURPOSE=recordBean.getRecord_use();//用途 
    		String STANDARD=recordBean.getRecord_applicable_standards();//适用标准 
    		String REMARK=recordBean.getRecord_other();//其他
    		
    		String SKU_ATTA="";
    		 if(recordAttachedBeans!=null){
            	for (int i = 0; i < recordAttachedBeans.size(); i++) {
            		RecordAttachedBean recordAttachedBean=recordAttachedBeans.get(i);
            		String CERT_CLOB=HaiguanUtils.getImgStr(img_path+recordAttachedBean.getCERT_CLOB());
            		SKU_ATTA+="<SKU_ATTA>"
            				+ "<GUID>"+recordAttachedBean.getGUID()+"</GUID>"
            				+ "<GUID_HEAD>"+recordAttachedBean.getGUID_HEAD()+"</GUID_HEAD>"
            				+ "<BIZ_TYPE_CODE>"+recordAttachedBean.getBIZ_TYPE_CODE()+"</BIZ_TYPE_CODE>"
            				+ "<ATTACHED_SEQ_NO>"+recordAttachedBean.getATTACHED_SEQ_NO()+"</ATTACHED_SEQ_NO>"
            				+ "<CERT_TYPE_CODE>"+recordAttachedBean.getCERT_TYPE_CODE()+"</CERT_TYPE_CODE>"
            				+ "<CERT_CLOB>"+CERT_CLOB+"</CERT_CLOB>"
            				+ "<FILE_NAME>"+recordAttachedBean.getFILE_NAME()+"</FILE_NAME>"
            				+ "<FILE_TYPE>"+recordAttachedBean.getFILE_TYPE()+"</FILE_TYPE>"
            				+ "<STORE_DATE>"+recordAttachedBean.getSTORE_DATE()+"</STORE_DATE>"
            			+ "</SKU_ATTA>";
        		}
    	    }
    		
    		String xml = 
    			"<DTC_Message>"
    				+ "<MessageHead>"
    					+ "<MessageType>SKU_INFO</MessageType>"
    					+ "<MessageId>"+GUID+"</MessageId>"
    					+ "<ActionType>"+ActionType+"</ActionType>"
    					+ "<MessageTime>2019-04-04 13:54:46</MessageTime>"
    					+ "<SenderId>"+SenderId+"</SenderId>"
    					+ "<ReceiverId>CQITC</ReceiverId>"
    					+ "<UserNo>"+SenderId+"</UserNo>"
    					+ "<Password>"+password+"</Password>"
    				+ "</MessageHead>"
    				+ "<MessageBody>"
    				+ "<DTCFlow>"
    					+ "<SKU_INFO>"
    						+ "<GUID>"+GUID+"</GUID>"
    						+ "<ESHOP_ENT_CODE>"+ESHOP_ENT_CODE+"</ESHOP_ENT_CODE>"
    						+ "<ESHOP_ENT_NAME>"+ESHOP_ENT_NAME+"</ESHOP_ENT_NAME>"
    						+ "<EXTERNAL_NO />"
    						+ "<SKU>"+SKU+"</SKU>"
    						+ "<GOODS_NAME>"+GOODS_NAME+"</GOODS_NAME>"
    						+ "<GOODS_SPEC>"+GOODS_SPEC+"</GOODS_SPEC>"
    						+ "<DECLARE_UNIT>"+DECLARE_UNIT+"</DECLARE_UNIT>"
    						+ "<LEGAL_UNIT>"+LEGAL_UNIT+"</LEGAL_UNIT>"
    						+ "<CONV_LEGAL_UNIT_NUM>"+CONV_LEGAL_UNIT_NUM+"</CONV_LEGAL_UNIT_NUM>"
    						+ "<HS_CODE>"+HS_CODE+"</HS_CODE>"
    						+ "<IN_AREA_UNIT>"+IN_AREA_UNIT+"</IN_AREA_UNIT>"
    						+ "<CONV_IN_AREA_UNIT_NUM>"+CONV_IN_AREA_UNIT_NUM+"</CONV_IN_AREA_UNIT_NUM>"
//    						+ "<IS_EXPERIMENT_GOODS>"+IS_EXPERIMENT_GOODS+"</IS_EXPERIMENT_GOODS>"
    						+ "<ORIGIN_COUNTRY_CODE>"+ORIGIN_COUNTRY_CODE+"</ORIGIN_COUNTRY_CODE>"
    						+ "<IS_CNCA_POR>"+IS_CNCA_POR+"</IS_CNCA_POR>"
    						+ "<CHECK_ORG_CODE>"+CHECK_ORG_CODE+"</CHECK_ORG_CODE>"
    						+ "<PRODUCER_NAME>"+PRODUCER_NAME+"</PRODUCER_NAME>"
    						+ "<IS_CNCA_POR_DOC>"+IS_CNCA_POR_DOC+"</IS_CNCA_POR_DOC>"
    						+ "<IS_ORIGIN_PLACE_CERT>"+IS_ORIGIN_PLACE_CERT+"</IS_ORIGIN_PLACE_CERT>"
    						+ "<IS_TEST_REPORT>"+IS_TEST_REPORT+"</IS_TEST_REPORT>"
    						+ "<IS_LEGAL_TICKET>"+IS_LEGAL_TICKET+"</IS_LEGAL_TICKET>"
    						+ "<IS_MARK_EXCHANGE>"+IS_MARK_EXCHANGE+"</IS_MARK_EXCHANGE>"
    						+ "<SEND_ENT_CODE>"+SEND_ENT_CODE+"</SEND_ENT_CODE>"
    						+ "<GOODS_TYPE_CODE>"+GOODS_TYPE_CODE+"</GOODS_TYPE_CODE>"
    						+ "<PRODUCT_BRAND>"+PRODUCT_BRAND+"</PRODUCT_BRAND>"
    						+ "<GOODS_NAME_ENGLISH>"+GOODS_NAME_ENGLISH+"</GOODS_NAME_ENGLISH>"
    						+ "<GOODS_NAME_CHIESE>"+GOODS_NAME_CHIESE+"</GOODS_NAME_CHIESE>"
    						+ "<GOODS_TYPE_CODE>"+GOODS_TYPE_CODE+"</GOODS_TYPE_CODE>"
    						+ "<PRODUCT_BRAND>"+PRODUCT_BRAND+"</PRODUCT_BRAND>"
    						+ "<GOODS_NAME_ENGLISH>"+GOODS_NAME_ENGLISH+"</GOODS_NAME_ENGLISH>"
    						+ "<GOODS_NAME_CHIESE>"+GOODS_NAME_CHIESE+"</GOODS_NAME_CHIESE>"
    						+ "<IS_LAW_REVIEW>"+IS_LAW_REVIEW+"</IS_LAW_REVIEW>"
    						+ "<PER_INDEX>"+PER_INDEX+"</PER_INDEX>"
    						+ "<AUTH_INFO>"+AUTH_INFO+"</AUTH_INFO>"
    						+ "<LICENSE_CODE>"+LICENSE_CODE+"</LICENSE_CODE>"
    						+ "<BAR_CODE>"+BAR_CODE+"</BAR_CODE>"
    						+ "<VALIDITY>"+VALIDITY+"</VALIDITY>"
    						+ "<TRADE_MODE>"+VALIDITY+"</TRADE_MODE>"
    						+ "<PURPOSE>"+PURPOSE+"</PURPOSE>"
    						+ "<STANDARD>"+STANDARD+"</STANDARD>"
    						+ "<REMARK>"+REMARK+"</REMARK>"
    						+ "<CIQ_CODE>"+CIQ_CODE+"</CIQ_CODE>"
    						+ "<BIZ_TYPE>"+BIZ_TYPE+"</BIZ_TYPE>"
    					+ "</SKU_INFO>"
    					+ SKU_ATTA
    					+ "</DTCFlow>"
    					+ "</MessageBody>"
    				+ "</DTC_Message>";
    		HaiguanUtils.recordGoods(xml);
        }
        return num;
    }

    @Override
    public Object insertRecord(RecordBean recordBean,List<RecordAttachedBean> recordAttachedBeans) {
        // TODO Auto-generated method stub
    	String uuid=UUID.randomUUID().toString();
    	
        int num=recordDaoC.insertRecord(recordBean);
        if(num<=0){
            throw new AppException("插入失败!");
        }
        
        if(recordAttachedBeans!=null){
        	for (int i = 0; i < recordAttachedBeans.size(); i++) {
        		RecordAttachedBean recordAttachedBean=recordAttachedBeans.get(i);
        		num=recordDaoC.insertRecordAttached(recordAttachedBean
        				.setRecord_id(recordBean.getRecord_id()+"")
        				.setGUID(uuid)
        				.setGUID_HEAD(uuid));
                if(num<=0){
                    throw new AppException("附件插入失败!");
                }
    		}
        }
        
        if("1".equals(recordBean.getRecord_status())){
        	String SenderId=haiguan_code;//华龙用户名
    		String password=haiguan_password;
    		
    		String ActionType="1";//1:添加新备案 2:修改备案信息
    		
    		String GUID=uuid;
    		String ESHOP_ENT_CODE=haiguan_code;
    		String ESHOP_ENT_NAME=haiguan_code;
    		
    		String EXTERNAL_NO="";
    		String SKU=recordBean.getRecord_sku();//商品货号
    		String CIQ_CODE=recordBean.getRecord_ciq_code();//CIQ编码
    		String GOODS_NAME=recordBean.getRecord_goods_name();//商品名称
    		String BIZ_TYPE=recordBean.getRecord_business_types();//业务类型
    		String GOODS_SPEC=recordBean.getRecord_goods_specification();//规格型号
    		String DECLARE_UNIT=recordBean.getRecord_the_notification();//申报计量单位
    		String LEGAL_UNIT=recordBean.getRecord_legal_units();//法定计量单位
    		String CONV_LEGAL_UNIT_NUM=recordBean.getRecord_reduced_num();//法定计量单位折算数量
    		String HS_CODE=recordBean.getRecord_hs_code();//商品HS编码
    		String IN_AREA_UNIT=recordBean.getRecord_measuring_unit();//入区计量单位
    		String CONV_IN_AREA_UNIT_NUM=recordBean.getRecord_measuring_unit_code();//入区计量单位折算数量
    		String ORIGIN_COUNTRY_CODE=recordBean.getRecord_country_code();//国家地区代码
    		String IS_CNCA_POR=recordBean.getRecord_in_china();//国外生产企业是否在中国注册备案（食药监局、国家认监委）
    		String CHECK_ORG_CODE=recordBean.getRecord_inspection_code();//施检机构的代码
    		String SUPPLIER_NAME=recordBean.getRecord_supplier_name();//供应商名称
    		String PRODUCER_NAME=recordBean.getRecord_enterprise_name();//生产企业名称
    		String IS_CNCA_POR_DOC=recordBean.getRecord_is_attachment();//是否存在食药监局、国家认监委备案附件
    		String IS_ORIGIN_PLACE_CERT=recordBean.getRecord_is_origin();//是否存在原产地证书
    		String IS_TEST_REPORT=recordBean.getRecord_is_report();//是否存在境外官方及第三方机构的检测报告
    		String IS_LEGAL_TICKET=recordBean.getRecord_is_legal();//是否存在合法采购证明（国外进货发票或小票）
    		String IS_MARK_EXCHANGE=recordBean.getRecord_is_translation();//是否存外文标签的中文翻译件
    		
    		String SEND_ENT_CODE=haiguan_code;//发送企业代码
    		
    		String GOODS_TYPE_CODE=recordBean.getRecord_product_code();//商品分类代码
    		String PRODUCT_BRAND=recordBean.getRecord_product_brand();//产品品牌
    		String GOODS_NAME_ENGLISH=recordBean.getRecord_english_name();//英文原名
    		String GOODS_NAME_CHIESE=recordBean.getRecord_translation_name();//中文翻译名
    		String IS_LAW_REVIEW=recordBean.getRecord_is_inspection();//是否法检
    		String PER_INDEX=recordBean.getRecord_performance_indicators();//性能指标
    		String AUTH_INFO=recordBean.getRecord_authentication_information();//认证信息
    		String LICENSE_CODE=recordBean.getRecord_license();//许可证号 
    		String BAR_CODE=recordBean.getRecord_barcode();//商品条形码 
    		String VALIDITY=recordBean.getRecord_period_validity();//产品有效期 
    		String BASESTRADE_MODE=recordBean.getRecord_main_ingredients();//主要成份 
    		String PURPOSE=recordBean.getRecord_use();//用途 
    		String STANDARD=recordBean.getRecord_applicable_standards();//适用标准 
    		String REMARK=recordBean.getRecord_other();//其他
    		
    		String SKU_ATTA="";
    		 if(recordAttachedBeans!=null){
            	for (int i = 0; i < recordAttachedBeans.size(); i++) {
            		RecordAttachedBean recordAttachedBean=recordAttachedBeans.get(i);
            		SKU_ATTA+="<SKU_ATTA>"
            				+ "<GUID>"+recordAttachedBean.getGUID()+"</GUID>"
            				+ "<GUID_HEAD>"+recordAttachedBean.getGUID_HEAD()+"</GUID_HEAD>"
            				+ "<BIZ_TYPE_CODE>"+recordAttachedBean.getBIZ_TYPE_CODE()+"</BIZ_TYPE_CODE>"
            				+ "<ATTACHED_SEQ_NO>"+recordAttachedBean.getATTACHED_SEQ_NO()+"</ATTACHED_SEQ_NO>"
            				+ "<CERT_TYPE_CODE>"+recordAttachedBean.getCERT_TYPE_CODE()+"</CERT_TYPE_CODE>"
            				+ "<CERT_CLOB>"+recordAttachedBean.getCERT_CLOB()+"</CERT_CLOB>"
            				+ "<FILE_NAME>"+recordAttachedBean.getFILE_NAME()+"</FILE_NAME>"
            				+ "<FILE_TYPE>"+recordAttachedBean.getFILE_TYPE()+"</FILE_TYPE>"
            				+ "<STORE_DATE>"+recordAttachedBean.getSTORE_DATE()+"</STORE_DATE>"
            			+ "</SKU_ATTA>";
        		}
    	    }
    		
    		String xml = 
    			"<DTC_Message>"
    				+ "<MessageHead>"
    					+ "<MessageType>SKU_INFO</MessageType>"
    					+ "<MessageId>"+GUID+"</MessageId>"
    					+ "<ActionType>"+ActionType+"</ActionType>"
    					+ "<MessageTime>2019-04-04 13:54:46</MessageTime>"
    					+ "<SenderId>"+SenderId+"</SenderId>"
    					+ "<ReceiverId>CQITC</ReceiverId>"
    					+ "<UserNo>"+SenderId+"</UserNo>"
    					+ "<Password>"+password+"</Password>"
    				+ "</MessageHead>"
    				+ "<MessageBody>"
    				+ "<DTCFlow>"
    					+ "<SKU_INFO>"
    						+ "<GUID>"+GUID+"</GUID>"
    						+ "<ESHOP_ENT_CODE>"+ESHOP_ENT_CODE+"</ESHOP_ENT_CODE>"
    						+ "<ESHOP_ENT_NAME>"+ESHOP_ENT_NAME+"</ESHOP_ENT_NAME>"
    						+ "<EXTERNAL_NO />"
    						+ "<SKU>"+SKU+"</SKU>"
    						+ "<GOODS_NAME>"+GOODS_NAME+"</GOODS_NAME>"
    						+ "<GOODS_SPEC>"+GOODS_SPEC+"</GOODS_SPEC>"
    						+ "<DECLARE_UNIT>"+DECLARE_UNIT+"</DECLARE_UNIT>"
    						+ "<LEGAL_UNIT>"+LEGAL_UNIT+"</LEGAL_UNIT>"
    						+ "<CONV_LEGAL_UNIT_NUM>"+CONV_LEGAL_UNIT_NUM+"</CONV_LEGAL_UNIT_NUM>"
    						+ "<HS_CODE>"+HS_CODE+"</HS_CODE>"
    						+ "<IN_AREA_UNIT>"+IN_AREA_UNIT+"</IN_AREA_UNIT>"
    						+ "<CONV_IN_AREA_UNIT_NUM>"+CONV_IN_AREA_UNIT_NUM+"</CONV_IN_AREA_UNIT_NUM>"
//    						+ "<IS_EXPERIMENT_GOODS>"+IS_EXPERIMENT_GOODS+"</IS_EXPERIMENT_GOODS>"
    						+ "<ORIGIN_COUNTRY_CODE>"+ORIGIN_COUNTRY_CODE+"</ORIGIN_COUNTRY_CODE>"
    						+ "<IS_CNCA_POR>"+IS_CNCA_POR+"</IS_CNCA_POR>"
    						+ "<CHECK_ORG_CODE>"+CHECK_ORG_CODE+"</CHECK_ORG_CODE>"
    						+ "<PRODUCER_NAME>"+PRODUCER_NAME+"</PRODUCER_NAME>"
    						+ "<IS_CNCA_POR_DOC>"+IS_CNCA_POR_DOC+"</IS_CNCA_POR_DOC>"
    						+ "<IS_ORIGIN_PLACE_CERT>"+IS_ORIGIN_PLACE_CERT+"</IS_ORIGIN_PLACE_CERT>"
    						+ "<IS_TEST_REPORT>"+IS_TEST_REPORT+"</IS_TEST_REPORT>"
    						+ "<IS_LEGAL_TICKET>"+IS_LEGAL_TICKET+"</IS_LEGAL_TICKET>"
    						+ "<IS_MARK_EXCHANGE>"+IS_MARK_EXCHANGE+"</IS_MARK_EXCHANGE>"
    						+ "<SEND_ENT_CODE>"+SEND_ENT_CODE+"</SEND_ENT_CODE>"
    						+ "<GOODS_TYPE_CODE>"+GOODS_TYPE_CODE+"</GOODS_TYPE_CODE>"
    						+ "<PRODUCT_BRAND>"+PRODUCT_BRAND+"</PRODUCT_BRAND>"
    						+ "<GOODS_NAME_ENGLISH>"+GOODS_NAME_ENGLISH+"</GOODS_NAME_ENGLISH>"
    						+ "<GOODS_NAME_CHIESE>"+GOODS_NAME_CHIESE+"</GOODS_NAME_CHIESE>"
    						+ "<GOODS_TYPE_CODE>"+GOODS_TYPE_CODE+"</GOODS_TYPE_CODE>"
    						+ "<PRODUCT_BRAND>"+PRODUCT_BRAND+"</PRODUCT_BRAND>"
    						+ "<GOODS_NAME_ENGLISH>"+GOODS_NAME_ENGLISH+"</GOODS_NAME_ENGLISH>"
    						+ "<GOODS_NAME_CHIESE>"+GOODS_NAME_CHIESE+"</GOODS_NAME_CHIESE>"
    						+ "<IS_LAW_REVIEW>"+IS_LAW_REVIEW+"</IS_LAW_REVIEW>"
    						+ "<PER_INDEX>"+PER_INDEX+"</PER_INDEX>"
    						+ "<AUTH_INFO>"+AUTH_INFO+"</AUTH_INFO>"
    						+ "<LICENSE_CODE>"+LICENSE_CODE+"</LICENSE_CODE>"
    						+ "<BAR_CODE>"+BAR_CODE+"</BAR_CODE>"
    						+ "<VALIDITY>"+VALIDITY+"</VALIDITY>"
    						+ "<TRADE_MODE>"+VALIDITY+"</TRADE_MODE>"
    						+ "<PURPOSE>"+PURPOSE+"</PURPOSE>"
    						+ "<STANDARD>"+STANDARD+"</STANDARD>"
    						+ "<REMARK>"+REMARK+"</REMARK>"
    						+ "<CIQ_CODE>"+CIQ_CODE+"</CIQ_CODE>"
    						+ "<BIZ_TYPE>"+BIZ_TYPE+"</BIZ_TYPE>"
    					+ "</SKU_INFO>"
    					+ SKU_ATTA
    					+ "</DTCFlow>"
    					+ "</MessageBody>"
    				+ "</DTC_Message>";
    		HaiguanUtils.recordGoods(xml);
        }
        
			
        return num;
    }

    @Override
    public Object refusedRecord(RecordBean recordBean) {
        // TODO Auto-generated method stub
        int num=recordDaoC.refusedRecord(recordBean);
        if(num<=0){
            throw new AppException("拒绝失败!");
        }
        return num;
    }

    @Override
    public Object throughRecord(RecordBean recordBean) {
        // TODO Auto-generated method stub
        int num=recordDaoC.throughRecord(recordBean);
        if(num<=0){
            throw new AppException("通过失败!");
        }
        return num;
    }


    @Override
    public Object getRecordsThrough(RecordBean recordBean, PageBean pageBean) {
        List<RecordBean> recordBeans=recordDaoC.getRecordsThrough(recordBean, pageBean);
        return pageBean.setObject(recordBeans);
    }
}

package tst.project.controller;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.sql.Clob;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

import javax.sql.rowset.serial.SerialException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.fastjson.JSON;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

import tst.project.aspect.AppController;
import tst.project.bean.product.RecordAttachedBean;
import tst.project.bean.product.RecordBean;
import tst.project.page.PageBean;
import tst.project.utils.Base64Utils;
import tst.project.utils.JDBCUtils;

@Controller
@RequestMapping("/recordController/v1.0")
public class RecordController {

	@Autowired
	IRecordServiceC recordServiceC;

	@RequestMapping("/getRecords")
	@AppController(isVerSystemToken = true, isPage = true)
	public Object getRecords(RecordBean recordBean, PageBean pageBean) throws Exception {
		return recordServiceC.getRecords(recordBean, pageBean);
	}

	@RequestMapping("/getRecordsThrough")
	@AppController(isVerSystemToken = true, isPage = true)
	public Object getRecordsThrough(RecordBean recordBean, PageBean pageBean) throws Exception {
		return recordServiceC.getRecordsThrough(recordBean, pageBean);
	}

	@RequestMapping("/getRecordDetail")
	@AppController(isVerSystemToken = true)
	public Object getRecordDetail(RecordBean recordBean) throws Exception {
		return recordServiceC.getRecordDetail(recordBean);
	}

	@RequestMapping("/deleteRecord")
	@AppController(isVerSystemToken = true)
	public Object deleteRecord(RecordBean recordBean) throws Exception {
		return recordServiceC.deleteRecord(recordBean);
	}

	@RequestMapping("/refusedRecord")
	@AppController(isVerSystemToken = true)
	public Object refusedRecord(RecordBean recordBean) throws Exception {
		return recordServiceC.refusedRecord(recordBean);
	}

	@RequestMapping("/throughRecord")
	@AppController(isVerSystemToken = true)
	public Object throughRecord(RecordBean recordBean) throws Exception {
		return recordServiceC.throughRecord(recordBean);
	}

	@RequestMapping("/updateRecord")
	@AppController(isVerSystemToken = true)
	public Object updateRecord(RecordBean recordBean, String attacheds) throws Exception {
		return recordServiceC.updateRecord(recordBean, JSON.parseArray(attacheds, RecordAttachedBean.class));
	}

	@RequestMapping("/insertRecord")
	@AppController(isVerSystemToken = true)
	public Object insertRecord(RecordBean recordBean, String attacheds) throws Exception {
		return recordServiceC.insertRecord(recordBean, JSON.parseArray(attacheds, RecordAttachedBean.class));
	}
	
}

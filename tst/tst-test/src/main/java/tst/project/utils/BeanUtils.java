package tst.project.utils;

import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.poi.hwpf.HWPFDocument;
import org.apache.poi.hwpf.model.FieldsDocumentPart;
import org.apache.poi.hwpf.usermodel.Field;
import org.apache.poi.hwpf.usermodel.Fields;
import org.apache.poi.hwpf.usermodel.Paragraph;
import org.apache.poi.hwpf.usermodel.Range;
import org.apache.poi.hwpf.usermodel.Table;
import org.apache.poi.hwpf.usermodel.TableCell;
import org.apache.poi.hwpf.usermodel.TableIterator;
import org.apache.poi.hwpf.usermodel.TableRow;

import com.alibaba.fastjson.JSON;
import com.mysql.jdbc.Connection;

import tst.project.bean.JDBCBean;

public class BeanUtils {
	public String getPath() {
		return getClass().getResource("/").getFile().toString();
	}

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws Exception {
		createJavaBean("package tst.project.bean.product;", "RecordBean", "tst_record");
	}

	public static boolean createJavaBean(String package_name,String name,String tables) throws Exception{
		Connection conn = null;
		String sql = "SHOW FULL FIELDS FROM "+tables+";";

		String username = "tst";
		String password = "tst1234567";
		String url = "jdbc:mysql://139.196.178.64:3306/tst_huixiang2?characterEncoding=utf-8";
		conn = JDBCUtils.startConn(conn,url,username,password);
		String json = JDBCUtils.queryColumns(conn, sql);

		System.out.println(json);

		List<JDBCBean> jdbcBeans =JSON.parseArray(json, JDBCBean.class); // new Gson().fromJson(json, new TypeToken<List<JDBCBean>>() {}.getType());

		File f = new File(new BeanUtils().getPath() + name + ".java");
		if (!f.exists()) {
			f.createNewFile();
		}

		System.out.println(new BeanUtils().getPath());
		
		FileOutputStream out = new FileOutputStream(new BeanUtils().getPath() + name + ".java");
		OutputStreamWriter outWriter = new OutputStreamWriter(out, "UTF-8");
		BufferedWriter bufWrite = new BufferedWriter(outWriter);
		bufWrite.write(package_name + "\r\n\n");

		bufWrite.write("import java.io.Serializable;\r\n\n");
		
		bufWrite.write("/**\r\n\n");
		bufWrite.write("**\r\n\n");
		bufWrite.write("*/\r\n\n");
		
		
		bufWrite.write("public class " + name + " implements Serializable{" + "\r\n");
		bufWrite.write("	private static final long serialVersionUID = 1L;\r\n");
		
		for (int i = 0; i < jdbcBeans.size(); i++) {
			String type=jdbcBeans.get(i).getExtra().equals("auto_increment")?"int":"String";
			
			bufWrite.write("	private "+type+" " + jdbcBeans.get(i).getField() + ";//" + jdbcBeans.get(i).getComment()
					+ "\r\n");
		}
		for (int i = 0; i < jdbcBeans.size(); i++) {
			String type=jdbcBeans.get(i).getExtra().equals("auto_increment")?"int":"String";

			
			String Field=jdbcBeans.get(i).getField();
			String a=Field.substring(0,1).toUpperCase();
			String b=Field.substring(1,Field.length());
			
			bufWrite.write("	public "+type+" get" + a +b+ "(){\r\n");

			bufWrite.write("		return " + Field + ";\r\n");

			bufWrite.write("	}\r\n");

			bufWrite.write("	public " + name + " set" + a +b+ "("+type+" " + Field+  "){\r\n");
			bufWrite.write("		this." + Field + "= "  + Field+ ";\r\n");
			bufWrite.write("		return this;\r\n");

			bufWrite.write("	}\r\n");
		}

		bufWrite.write("}" + "\r\n");
		bufWrite.close();
		outWriter.close();
		out.close();
		
		
		return true;
	}
	
	

	/**
	 * 实现对word读取和修改操作
	 * 
	 * @param filePath
	 *            word模板路径和名称
	 * @param map
	 *            待填充的数据，从数据库读取
	 */
	public static void readwriteWord(String filePath, Map<String, String> map) {
		// 读取word模板
		// String fileDir = new
		// File(base.getFile(),"http://www.cnblogs.com/http://www.cnblogs.com/../doc/").getCanonicalPath();
		FileInputStream in = null;
		try {
			in = new FileInputStream(new File(filePath));
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
		HWPFDocument hdt = null;
		try {
			hdt = new HWPFDocument(in);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		Fields fields = hdt.getFields();
		Iterator<Field> it = fields.getFields(FieldsDocumentPart.MAIN).iterator();
		while (it.hasNext()) {
			System.out.println(it.next().getType());
		}

		// 读取word文本内容
		Range range = hdt.getRange();
		TableIterator tableIt = new TableIterator(range);
		// 迭代文档中的表格
		int ii = 0;
		while (tableIt.hasNext()) {
			Table tb = (Table) tableIt.next();
			ii++;
			System.out.println("第" + ii + "个表格数据...................");
			// 迭代行，默认从0开始
			for (int i = 0; i < tb.numRows(); i++) {
				TableRow tr = tb.getRow(i);
				// 只读前8行，标题部分
				if (i >= 8)
					break;
				// 迭代列，默认从0开始
				for (int j = 0; j < tr.numCells(); j++) {
					TableCell td = tr.getCell(j);// 取得单元格
					// 取得单元格的内容
					for (int k = 0; k < td.numParagraphs(); k++) {
						Paragraph para = td.getParagraph(k);
						String s = para.text();
						System.out.println(s);
					} // end for
				} // end for
			} // end for
		} // end while
			// System.out.println(range.text());

		// 替换文本内容
		for (Map.Entry<String, String> entry : map.entrySet()) {
			// range.replaceText(entry.getKey(), entry.getValue());
			range.insertBefore(entry.getValue());
		}
		ByteArrayOutputStream ostream = new ByteArrayOutputStream();
		String fileName = "" + System.currentTimeMillis();
		fileName += ".doc";
		FileOutputStream out = null;
		try {
			out = new FileOutputStream(new BeanUtils().getPath() + fileName, true);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			hdt.write(ostream);
		} catch (IOException e) {
			e.printStackTrace();
		}
		// 输出字节流
		try {
			out.write(ostream.toByteArray());
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			ostream.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

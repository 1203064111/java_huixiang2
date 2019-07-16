package tst.project.utils;

import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

import com.alibaba.fastjson.JSON;
import com.lowagie.text.Document;
import com.lowagie.text.Element;
import com.lowagie.text.Font;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.BaseFont;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.rtf.RtfWriter2;
import com.mysql.jdbc.Connection;

import tst.project.bean.JDBCBean;

public class WordUtils {

	public String getPath() {
		return getClass().getResource("/").getFile().toString();
	}
	
	public static void main(String[] args) {
		createWord("标准集团数据库文档");
		
	}
	
	public static boolean createWord(String title) {
		try {
			Document document = new Document(PageSize.A4);
			File file = new File(new WordUtils().getPath() + title+".doc");
			RtfWriter2.getInstance(document, new FileOutputStream(file));
			document.open();
			
			BaseFont bfChinese = BaseFont.createFont(BaseFont.HELVETICA, BaseFont.WINANSI, BaseFont.NOT_EMBEDDED);
			
			
			
			Font titleFont = new Font(bfChinese, 20, Font.BOLD);
			Paragraph titleParagraph = new Paragraph(title);
			titleParagraph.setAlignment(Element.ALIGN_CENTER);
			titleParagraph.setFont(titleFont);
			document.add(titleParagraph);//标题
			
			
	                   
	       
			
			Connection conn = null;
			String sql = "select table_name,table_comment from information_schema.tables where table_schema = 'tst_fanbiao';";
			
			conn = JDBCUtils.startConn(conn);
			
			String json = JDBCUtils.queryArray(conn, sql);
						
			List<JDBCBean> jdbcBeans =JSON.parseArray(json, JDBCBean.class); 
			
			for (int i = 0; i < jdbcBeans.size(); i++) {
				Font contextFont = new Font(bfChinese, 16, Font.BOLD);
				String contextString =(i+1)+":"+jdbcBeans.get(i).getTABLE_COMMENT()+"("+jdbcBeans.get(i).getTABLE_NAME()+")";
				Paragraph context = new Paragraph(contextString);
				context.setAlignment(Element.ALIGN_LEFT);
			    context.setSpacingBefore(5);// 离上一段落（标题）空的行数
			    context.setFirstLineIndent(20);// 设置第一行空的列数
			    context.setFont(contextFont);// 设置字体
			    document.add(context);
			}
			for (int i = 0; i < 10; i++) {
				Paragraph titleParagraph111 = new Paragraph("");
				titleParagraph111.setAlignment(Element.ALIGN_CENTER);
				titleParagraph111.setFont(titleFont);
				document.add(titleParagraph111);//标题
			}
			

			for (int i = 0; i < jdbcBeans.size(); i++) {
				Font contextFont = new Font(bfChinese, 16, Font.BOLD);
				String contextString =jdbcBeans.get(i).getTABLE_COMMENT()+"("+jdbcBeans.get(i).getTABLE_NAME()+")";
	
				Paragraph context = new Paragraph(contextString);
				context.setAlignment(Element.ALIGN_LEFT);
			    context.setSpacingBefore(5);// 离上一段落（标题）空的行数
			    context.setFirstLineIndent(20);// 设置第一行空的列数
			    context.setFont(contextFont);// 设置字体
			    document.add(context);
			    
			  //创建PdfTable对象  
			    //添加表格内容  
			    PdfPTable table=new PdfPTable(5);    
		        table.setTotalWidth(360); //设置各列的列宽  
		        Font font=new Font(bfChinese,13,Font.NORMAL);  
		        
		        table.addCell(new PdfPCell(new Paragraph("字段名",font))); 			        
		        table.addCell(new PdfPCell(new Paragraph("字段类型",font))); 
		        table.addCell(new PdfPCell(new Paragraph("字段解释",font))); 		        
		        table.addCell(new PdfPCell(new Paragraph("默认值",font))); 	        
		        table.addCell(new PdfPCell(new Paragraph("是否为空",font))); 
		        
		        String sql_table = "SHOW FULL FIELDS FROM "+jdbcBeans.get(i).getTABLE_NAME()+";";
				String json_table = JDBCUtils.queryColumns(conn, sql_table);
				List<JDBCBean> tableBeans =JSON.parseArray(json_table, JDBCBean.class); 
				for (int j = 0; j < tableBeans.size(); j++) {
					JDBCBean jdbcBean=tableBeans.get(j);
			        table.addCell(new PdfPCell(new Paragraph(jdbcBean.getField(),font))); 
			        table.addCell(new PdfPCell(new Paragraph(jdbcBean.getType(),font))); 
			        table.addCell(new PdfPCell(new Paragraph(jdbcBean.getComment(),font))); 
			        table.addCell(new PdfPCell(new Paragraph(jdbcBean.getDefault(),font))); 
			        table.addCell(new PdfPCell(new Paragraph(jdbcBean.getNull(),font))); 
				}        		 
		        document.add(table);
			}
			
		    
		    document.close();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
			return false;
		}

		return true;
	}

	
	//获取指定内容与字体的单元格  
    public static PdfPCell getPDFCell(String string, Font font)   
    {  
        //创建单元格对象，将内容与字体放入段落中作为单元格内容  
        PdfPCell cell=new PdfPCell(new Paragraph(string,font));  
          
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);  
        cell.setVerticalAlignment(Element.ALIGN_MIDDLE);  
          
        //设置最小单元格高度  
        cell.setMinimumHeight(25);  
        return cell;  
    }  
}

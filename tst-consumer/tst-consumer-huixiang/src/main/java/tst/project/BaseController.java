package tst.project;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.util.WebUtils;

import tst.project.utils.TimeUtils;
import tst.project.utils.UUIDUtils;

public class BaseController {
	@Value("${img_path}")
	private String img_path;
	
	@Value("${img_url}")
	private String img_url;
	
	
	
	public List<String> saveFiles(HttpServletRequest request, String key) {
		InputStream inputStream = null;
		String fileName = "";
		OutputStream os = null;
		try {
			List<String> seStrings=new ArrayList<String>();
			String contentType = request.getContentType();

			if (contentType != null && contentType.toLowerCase().startsWith("multipart/")) {
				String new_path = TimeUtils.getCurrentTime("yyyyMMdd") + "/";
				String path = img_path + new_path;
				
				MultipartHttpServletRequest multipartRequest = WebUtils.getNativeRequest(request,
						MultipartHttpServletRequest.class);
				List<MultipartFile> files = multipartRequest.getFiles(key);
				if (files == null) {
					return null;
				}
				for (int i = 0; i < files.size(); i++) {
					MultipartFile file=files.get(i);
					
					inputStream = file.getInputStream();

					UUIDUtils uusUtils = new UUIDUtils(1);
					String original_filename = file.getOriginalFilename();
					int a = original_filename.lastIndexOf(".");
					fileName = uusUtils.nextId(false, 10) + original_filename.substring(a, original_filename.length());
					
					// 2、保存到临时文件
					// 1K的数据缓冲
					byte[] bs = new byte[1024];
					// 读取到的数据长度
					int len;
					// 输出的文件流保存到本地文件

					File tempFile = new File(path);
					if (!tempFile.exists()) {
						tempFile.mkdirs();
					}
					os = new FileOutputStream(tempFile.getPath() + File.separator + fileName);
					// 开始读取
					while ((len = inputStream.read(bs)) != -1) {
						os.write(bs, 0, len);
					}
					
					seStrings.add(img_url+new_path + fileName);
				}
			}
			
			return seStrings;
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			// 完毕，关闭所有链接
			try {
				if (inputStream != null) {
					os.close();
					inputStream.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
				return null;
			}
		}

	}
	public String saveFile(HttpServletRequest request, String key) {
		return saveFile(request,key,true);
	}
	public String saveFile(HttpServletRequest request, String key,boolean is_url) {
		InputStream inputStream = null;
		String fileName = "";
		OutputStream os = null;
		try {
			String new_path = TimeUtils.getCurrentTime("yyyyMMdd") + "/";
			String path = img_path + new_path;
			String contentType = request.getContentType();
			if (contentType != null && contentType.toLowerCase().startsWith("multipart/")) {
				MultipartHttpServletRequest multipartRequest = WebUtils.getNativeRequest(request,
						MultipartHttpServletRequest.class);
								
				MultipartFile file = multipartRequest.getFile(key);
				if (file == null) {
					return null;
				}
				inputStream = file.getInputStream();

				UUIDUtils uusUtils = new UUIDUtils(1);
				String original_filename = file.getOriginalFilename();
				int a = original_filename.lastIndexOf(".");
				fileName = uusUtils.nextId(false, 10) + original_filename.substring(a, original_filename.length());
			}
			// 2、保存到临时文件
			// 1K的数据缓冲
			byte[] bs = new byte[1024];
			// 读取到的数据长度
			int len;
			// 输出的文件流保存到本地文件

			File tempFile = new File(path);
			if (!tempFile.exists()) {
				tempFile.mkdirs();
			}
			os = new FileOutputStream(tempFile.getPath() + File.separator + fileName);
			// 开始读取
			while ((len = inputStream.read(bs)) != -1) {
				os.write(bs, 0, len);
			}
			if(is_url){
				return img_url+new_path + fileName;	
			}else{
				return new_path + fileName;
			}
			
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			// 完毕，关闭所有链接
			try {
				if (inputStream != null) {
					os.close();
					inputStream.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
				return null;
			}
		}

	}

}

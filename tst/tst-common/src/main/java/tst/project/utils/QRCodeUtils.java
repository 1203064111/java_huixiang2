package tst.project.utils;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.awt.image.ColorModel;
import java.awt.image.WritableRaster;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Hashtable;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.DecodeHintType;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.Result;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.HybridBinarizer;

public class QRCodeUtils {

	private static final String CHARSET = "utf-8";

	/**
	 * 从二维码中，解析数据
	 * 
	 * @param file
	 *            二维码图片文件
	 * @return 返回从二维码中解析到的数据值
	 * @throws Exception
	 */
	public static String decode(File file) throws Exception {
		BufferedImage image;
		image = ImageIO.read(file);
		if (image == null) {
			return null;
		}
		BufferedImageLuminanceSource source = new BufferedImageLuminanceSource(
				image);
		BinaryBitmap bitmap = new BinaryBitmap(new HybridBinarizer(source));
		Result result;
		Hashtable hints = new Hashtable();
		hints.put(DecodeHintType.CHARACTER_SET, CHARSET);
		result = new MultiFormatReader().decode(bitmap, hints);
		String resultStr = result.getText();
		return resultStr;
	}

	/**
	 * 
	 * 生成商家二维码（taoyuan）
	 */
	private static final int BLACK = 0xFF000000;
	private static final int WHITE = 0xFFFFFFFF;

	public static BufferedImage toBufferedImage(BitMatrix matrix) {
		int width = matrix.getWidth();
		int height = matrix.getHeight();
		BufferedImage image = new BufferedImage(width, height,
				BufferedImage.TYPE_INT_RGB);
		for (int x = 0; x < width; x++) {
			for (int y = 0; y < height; y++) {
				image.setRGB(x, y, matrix.get(x, y) ? BLACK : WHITE);
			}
		}
		return image;
	}

	public static void writeToFile(BitMatrix matrix, String format, File file)
			throws IOException {
		BufferedImage image = toBufferedImage(matrix);
		if (!ImageIO.write(image, format, file)) {
			throw new IOException("Could not write an image of format "
					+ format + " to " + file);
		}
	}

	public static void writeToStream(BitMatrix matrix, String format,
			OutputStream stream) throws IOException {
		BufferedImage image = toBufferedImage(matrix);
		if (!ImageIO.write(image, format, stream)) {
			throw new IOException("Could not write an image of format "
					+ format);
		}
	}

	public static String createImage(String content,String inputPath) throws Exception {
		
		//content = "张小伟"; // 二维码内容
		int width = 300; // 二维码图片宽度a
		int height = 300; // 二维码图片高
		String format = "jpg";// 二维码的图片格式

		Hashtable<EncodeHintType, String> hints = new Hashtable<EncodeHintType, String>();
		hints.put(EncodeHintType.CHARACTER_SET, "utf-8"); // 内容所使用字符集编码

		BitMatrix bitMatrix = new MultiFormatWriter().encode(content,
				BarcodeFormat.QR_CODE, width, height, hints);
//		HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
//		String basePath = request.getSession().getServletContext().getRealPath("/");
		
		String fileName=TimeUtils.getCurrentTime("yyyyMMddHHmmss")+new Random().nextInt(Integer.MAX_VALUE)+".jpg";
		// 生成二维码
		File outputFile = new File(inputPath+fileName);
		MatrixToImageWriter.writeToFile(bitMatrix, format, outputFile);
		return fileName;
	}
	public static String createImage1(String content) throws Exception {
		
		//content = "张小伟"; // 二维码内容
		int width = 300; // 二维码图片宽度
		int height = 300; // 二维码图片高度
		String format = "jpg";// 二维码的图片格式

		Hashtable<EncodeHintType, String> hints = new Hashtable<EncodeHintType, String>();
		hints.put(EncodeHintType.CHARACTER_SET, "utf-8"); // 内容所使用字符集编码

		BitMatrix bitMatrix = new MultiFormatWriter().encode(content,
				BarcodeFormat.QR_CODE, width, height, hints);
		//HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
		String basePath = "";
		String fileName="/Users/lx/Desktop/a.jpg";
		// 生成二维码
		File outputFile = new File(basePath+fileName);
		MatrixToImageWriter.writeToFile(bitMatrix, format, outputFile);
		return fileName;
	}
	public static void main(String[] args) throws Exception {

	
		StringBuffer buffer = new StringBuffer();
//		buffer.append("{\"name\":" + "\""+ merchantsBean.getMerchants_name()   +"\""    +",\"merchants_id\":"     +"\""+ merchantsBean.getMerchants_id()  +"\""  +  "},");
//		buffer.deleteCharAt(buffer.length()-1);
		String qrPath=QRCodeUtils.createImage1("www.baidu.com");
		
		System.out.println(qrPath);
		String str = decode(new File("/Users/lx/Desktop/a.jpg"));
		System.out.println(str);
	}

	/**
	 * 二维码和其他图片或者文字合成
	 * 
	 * @param desc
	 *            合成的文字
	 * @param compose_img
	 *            合成的图片
	 * @param qrcode
	 *            合成的二维码
	 */
	public static boolean composeQrcode(String compose_img, String qrcode,
			String out) {
		try {
			// 读取第一张图片
			File fileOne = new File(qrcode);
			BufferedImage ImageOneTemp = ImageIO.read(fileOne);

			BufferedImage ImageOne = modifyImageYe(ImageOneTemp, "", 150, 20,
					15, Color.BLACK);
			if (ImageOne == null) {
				return false;
			}
			int width = ImageOne.getWidth();// 图片宽度
			int height = ImageOne.getHeight();// 图片高度
			// 从图片中读取RGB
			int[] ImageArrayOne = new int[width * height];
			ImageArrayOne = ImageOne.getRGB(0, 0, width, height, ImageArrayOne,
					0, width);

			// //对第二张图片做相同的处理
			// File fileTwo = new File(compose_img);
			// BufferedImage ImageTemp = ImageIO.read(fileTwo);
			// BufferedImage ImageTwo = resizeImg(ImageTemp,80,80);
			// int widthTwo = ImageTwo.getWidth();//图片宽度
			// int heightTwo = ImageTwo.getHeight();//图片高度
			// int[] ImageArrayTwo = new int[widthTwo*heightTwo];
			// ImageArrayTwo =
			// ImageTwo.getRGB(0,0,widthTwo,heightTwo,ImageArrayTwo,0,widthTwo);

			// 生成新图片
			BufferedImage ImageNew = new BufferedImage(width, height,
					BufferedImage.TYPE_INT_RGB);
			ImageNew.setRGB(0, 0, width, height, ImageArrayOne, 0, width);// 设置左半部分的RGB
			// ImageNew.setRGB((width-widthTwo)/2,(height-heightTwo)/2,widthTwo,heightTwo,ImageArrayTwo,0,widthTwo);//设置右半部分的RGB
			File outFile = new File(out);
			ImageIO.write(ImageNew, "jpg", outFile);// 写图片
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage() + "============");
			return false;
		}

		return true;

	}

	/**
	 * 二维码和其他图片或者文字合成（顺手平 团购二维码）
	 * 
	 * @param desc
	 *            合成的文字
	 * @param compose_img
	 *            合成的图片
	 * @param qrcode
	 *            合成的二维码
	 */
	public static boolean composeQrcodeLenongV2(HttpServletRequest request,
			String white_backgroup, String qrcode_img, String out) {
		try {
			// 读取第一张图片
			File fileOne = new File(request.getSession().getServletContext()
					.getRealPath("/")
					+ white_backgroup);
			BufferedImage ImageOne = ImageIO.read(fileOne);

			if (ImageOne == null) {
				return false;
			}
			int width = ImageOne.getWidth();// 图片宽度
			int height = ImageOne.getHeight();// 图片高度
			// 从图片中读取RGB
			int[] ImageArrayOne = new int[width * height];
			ImageArrayOne = ImageOne.getRGB(0, 0, width, height, ImageArrayOne,
					0, width);

			File file3 = new File(request.getSession().getServletContext()
					.getRealPath("/")
					+ qrcode_img);
			BufferedImage ImageTemp3 = ImageIO.read(file3);
			BufferedImage Image3 = resizeImg(ImageTemp3, 50, 50);
			int width3 = Image3.getWidth();// 图片宽度
			int height3 = Image3.getHeight();// 图片高度
			int[] ImageArray3 = new int[width3 * height3];
			ImageArray3 = Image3.getRGB(0, 0, width3, height3, ImageArray3, 0,
					width3);

			// 生成新图片
			BufferedImage ImageNew = new BufferedImage(width, height,
					BufferedImage.TYPE_INT_RGB);
			ImageNew.setRGB(0, 0, width, height, ImageArrayOne, 0, width);// 设置左半部分的RGB
			ImageNew.setRGB((width - width3) / 2, (height - height3) / 2,
					width3, height3, ImageArray3, 0, width3);// 设置右半部分的RGB

			File outFile = new File(request.getSession().getServletContext()
					.getRealPath("/")
					+ out);
			ImageIO.write(ImageNew, "jpg", outFile);// 写图片
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage() + "============");
			return false;
		}

		return true;

	}

	/**
	 * 二维码和其他图片或者文字合成（顺手平 团购二维码）
	 * 
	 * @param desc
	 *            合成的文字
	 * @param compose_img
	 *            合成的图片
	 * @param qrcode
	 *            合成的二维码
	 */
	public static boolean composeQrcodeLenong(HttpServletRequest request,
			String white_backgroup, String qrcode_img, String out) {
		try {
			// 读取第一张图片
			File fileOne = new File(request.getSession().getServletContext()
					.getRealPath("/")
					+ white_backgroup);
			BufferedImage ImageOne = ImageIO.read(fileOne);

			if (ImageOne == null) {
				return false;
			}
			int width = ImageOne.getWidth();// 图片宽度
			int height = ImageOne.getHeight();// 图片高度
			// 从图片中读取RGB
			int[] ImageArrayOne = new int[width * height];
			ImageArrayOne = ImageOne.getRGB(0, 0, width, height, ImageArrayOne,
					0, width);

			File file3 = new File(request.getSession().getServletContext()
					.getRealPath("/")
					+ qrcode_img);
			BufferedImage ImageTemp3 = ImageIO.read(file3);
			BufferedImage Image3 = resizeImg(ImageTemp3, 300, 300);
			int width3 = Image3.getWidth();// 图片宽度
			int height3 = Image3.getHeight();// 图片高度
			int[] ImageArray3 = new int[width3 * height3];
			ImageArray3 = Image3.getRGB(0, 0, width3, height3, ImageArray3, 0,
					width3);

			// 生成新图片
			BufferedImage ImageNew = new BufferedImage(width, height,
					BufferedImage.TYPE_INT_RGB);
			ImageNew.setRGB(0, 0, width, height, ImageArrayOne, 0, width);// 设置左半部分的RGB
			ImageNew.setRGB((width - width3) / 2, (height - height3) / 2 + 100,
					width3, height3, ImageArray3, 0, width3);// 设置右半部分的RGB

			File outFile = new File(request.getSession().getServletContext()
					.getRealPath("/")
					+ out);
			ImageIO.write(ImageNew, "jpg", outFile);// 写图片
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage() + "============");
			return false;
		}

		return true;

	}

	/**
	 * 将源图片的BufferedImage对象生成缩略图
	 * 
	 * @param source
	 *            源图片的BufferedImage对象
	 * @param targetW
	 *            缩略图的宽
	 * @param targetH
	 *            缩略图的高
	 * @return
	 */
	public static BufferedImage resizeImg(BufferedImage source, int targetW,
			int targetH) {
		int type = source.getType();
		BufferedImage target = null;
		double sx = (double) targetW / source.getWidth();
		double sy = (double) targetH / source.getHeight();
		if (sx > sy) {
			sx = sy;
			targetW = (int) (sx * source.getWidth());
		} else {
			sy = sx;
			targetH = (int) (sy * source.getHeight());
		}

		if (type == BufferedImage.TYPE_CUSTOM) {
			ColorModel cm = source.getColorModel();
			WritableRaster raster = cm.createCompatibleWritableRaster(targetW,
					targetH);
			boolean alphaPremultiplied = cm.isAlphaPremultiplied();
			target = new BufferedImage(cm, raster, alphaPremultiplied, null);
		} else {
			target = new BufferedImage(targetW, targetH, type);
		}
		Graphics2D g = target.createGraphics();
		g.setRenderingHint(RenderingHints.KEY_RENDERING,
				RenderingHints.VALUE_RENDER_QUALITY);
		g.drawRenderedImage(source, AffineTransform.getScaleInstance(sx, sy));
		g.dispose();
		return target;
	}

	/**
	 * 修改图片,返回修改后的图片缓冲区（只输出一行文本）
	 */
	public static BufferedImage modifyImageYe(BufferedImage img, String desc,
			int width, int height, int fontsize, Color c) {
		try {
			Font font = new Font("宋体", Font.PLAIN, fontsize);
			int w = img.getWidth();
			int h = img.getHeight();
			Graphics2D g = img.createGraphics();
			g.setBackground(Color.WHITE);
			g.setColor(c);// 设置字体颜色
			if (font != null)
				g.setFont(font);
			// g.setStroke(new BasicStroke(1));
			drawString(g, desc, width, height);
			g.dispose();
		} catch (Exception e) {
			System.out.println(e.getMessage() + "===========------------");
			return null;
		}
		return img;
	}

	/**
	 * 修改图片,返回修改后的图片缓冲区（只输出一行文本）
	 */
	public static BufferedImage modifyImageYeNoCenter(BufferedImage img,
			String desc, int width, int height, int fontsize, Color c) {
		try {
			Font font = new Font("宋体", Font.PLAIN, fontsize);
			int w = img.getWidth();
			int h = img.getHeight();
			Graphics2D g = img.createGraphics();
			g.setBackground(Color.WHITE);
			g.setColor(c);// 设置字体颜色
			if (font != null)
				g.setFont(font);
			// g.setStroke(new BasicStroke(1));
			g.drawString(desc, width, height);
			g.dispose();
		} catch (Exception e) {
			System.out.println(e.getMessage() + "===========------------");
			return null;
		}
		return img;
	}

	public static void drawString(Graphics2D g, String str, int xPos, int yPos) {
		int strWidth = g.getFontMetrics().stringWidth(str);
		g.drawString(str, xPos - strWidth / 2, yPos);
	}

	
	/**
	 * 
	 * @param full_path    保存二维码的基础全路径
	 * @param fileName 保存二维码的图片名称
	 * @param desc  保存到二维码里的内容
	 * @return
	 */
	public static Boolean CreateQrcode(String full_path,String path,
			String fileName, String desc) {
		try {
			File f = new File(full_path+ path);
			if (!f.exists()) {
				f.mkdirs();
			}

			int width = 300;
			int height = 300;
			String format = "png";
			Hashtable hints = new Hashtable();
			hints.put(EncodeHintType.CHARACTER_SET, "utf-8");
			BitMatrix bitMatrix = new MultiFormatWriter().encode(desc,
					BarcodeFormat.QR_CODE, width, height, hints);
			File outputFile = new File(full_path+ path + "/" + fileName);
			MatrixToImageWriter.writeToFile(bitMatrix, format, outputFile);

			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

}

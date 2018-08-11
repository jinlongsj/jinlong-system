package com.jinlong.system.common.utils.validatecode;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Random;

import javax.imageio.ImageIO;

import com.sun.image.codec.jpeg.ImageFormatException;
import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGImageEncoder;

/**
 * 验证码生成器
 * 
 * @author dsna
 * 
 */
/**
 * @author Administrator
 *
 */
@SuppressWarnings("restriction")
public class ValidateCode {
	// 图片的宽度�?
	private int width = 160;
	// 图片的高度�?
	private int height = 40;
	// 验证码字符个�?
	private int codeCount = 5;
	// 验证码干扰线�?
	private int lineCount = 150;
	

	// 验证�?
	private String code = null;
	// 验证码图片Buffer
	private BufferedImage buffImg = null;

	private char[] codeSequence = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H',
			'I', 'J', 'K', 'L', 'M', 'N', 'P', 'Q', 'R', 'S', 'T', 'U', 'V',
			'W', 'X', 'Y', 'Z', '1', '2', '3', '4', '5', '6', '7', '8', '9' };

	public ValidateCode() {
		this.createCode();
	}

	/**
	 * 
	 * @param width
	 *            图片�?
	 * @param height
	 *            图片�?
	 */
	public ValidateCode(int width, int height) {
		this.width = width;
		this.height = height;
		this.createCode();
	}

	/**
	 * 
	 * @param width
	 *            图片�?
	 * @param height
	 *            图片�?
	 * @param codeCount
	 *            字符个数
	 * @param lineCount
	 *            干扰线条�?
	 */
	public ValidateCode(int width, int height, int codeCount, int lineCount) {
		this.width = width;
		this.height = height;
		this.codeCount = codeCount;
		this.lineCount = lineCount;
		this.createCode();
	}

	public void createCode() {
		int x = 0, fontHeight = 0, codeY = 0;
		int red = 0, green = 0, blue = 0;

		x = width / (codeCount);// 每个字符的宽�?
		fontHeight = height - 1;// 字体的高�?
		codeY = height - 4;

		// 图像buffer
		buffImg = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		Graphics2D g = buffImg.createGraphics();
		// 生成随机�?
		Random random = new Random();
		// 将图像填充为白色
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, width, height);
		// 创建字体
		ImgFontByte imgFont = new ImgFontByte();
		Font font = imgFont.getFont(fontHeight);
		g.setFont(font);

		for (int i = 0; i < lineCount; i++) {
			int xs = random.nextInt(width);
			int ys = random.nextInt(height);
			int xe = xs + random.nextInt(width / 8);
			int ye = ys + random.nextInt(height / 8);
			red = random.nextInt(255);
			green = random.nextInt(255);
			blue = random.nextInt(255);
			g.setColor(new Color(red, green, blue));
			g.drawLine(xs, ys, xe, ye);
		}

		// randomCode记录随机产生的验证码
		StringBuffer randomCode = new StringBuffer();
		// 随机产生codeCount个字符的验证码�?
		for (int i = 0; i < codeCount; i++) {
			String strRand = String.valueOf(codeSequence[random
					.nextInt(codeSequence.length)]);
			// 产生随机的颜色�?，让输出的每个字符的颜色值都将不同�?
			red = random.nextInt(151);
			green = random.nextInt(151);
			blue = random.nextInt(151);
			g.setColor(new Color(red, green, blue));
			g.drawString(strRand, (i) * x, codeY);
			// 将产生的四个随机数组合在�?���?
			randomCode.append(strRand);
		}
		// 将四位数字的验证码保存到Session中�?
		code = randomCode.toString();
	}

	public void write(String path) throws IOException {
		OutputStream sos = new FileOutputStream(path);
		this.write(sos);
	}
	
	/**
	 * servlet中使�?
	 * @param sos
	 * @throws IOException
	 */
	public void write(OutputStream sos) throws IOException {
		ImageIO.write(buffImg, "jpeg", sos);
		sos.close();
	}
	/**
	 * strus2中使用inputstream 将图片传入jsp  anthor: yoj
	 * @return
	 * @anthor: yoj
	 */
	public InputStream getIS(){
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		JPEGImageEncoder encode = JPEGCodec.createJPEGEncoder(bos);
		try {
			encode.encode(buffImg);
		} catch (ImageFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		byte[] bytes = bos.toByteArray();
		return new ByteArrayInputStream(bytes);
	}
	
	

	public String getCode() {
		return code;
	}

	
	class ImgFontByte {
		public Font getFont(int fontHeight) {
			try {
				Font baseFont = Font.createFont(Font.TRUETYPE_FONT,
						new ByteArrayInputStream(hex2byte(getFontByteStr())));
				return baseFont.deriveFont(Font.PLAIN, fontHeight);
			} catch (Exception e) {
				return new Font("Arial", Font.PLAIN, fontHeight);
			}
		}

		private byte[] hex2byte(String str) {
			if (str == null)
				return null;
			str = str.trim();
			int len = str.length();
			if (len == 0 || len % 2 == 1)
				return null;

			byte[] b = new byte[len / 2];
			try {
				for (int i = 0; i < str.length(); i += 2) {
					b[i / 2] = (byte) Integer.decode(
							"0x" + str.substring(i, i + 2)).intValue();
				}
				return b;
			} catch (Exception e) {
				return null;
			}
		}

		/**
		 * ttf字体文件的十六进制字符串
		 * 
		 * @return
		 */
		private String getFontByteStr() {
			// 返回null无字�?
			// return null;
			// 字体16进制文件
			return "0001000000100040000400";
//			return "0001000000100040000400c04f532f327d8175d4000087740000005650434c5461e3d9fb000087cc00000036636d036";
		}
	}

}

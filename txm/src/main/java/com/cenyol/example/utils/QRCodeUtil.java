package com.cenyol.example.utils;

import java.awt.BasicStroke;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Shape;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Hashtable;
import java.util.Random;

import javax.imageio.ImageIO;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.DecodeHintType;
import com.google.zxing.EncodeHintType;
import com.google.zxing.LuminanceSource;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.Result;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.HybridBinarizer;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import com.sun.javafx.geom.RoundRectangle2D;

/**
 *
 * 
 */
public class QRCodeUtil {
	private static final String CHARSET = "utf-8";
	private static final String FORMAT = "JPG";
	private static final int BLACK = 0xff000000;
	private static final int WHITE = 0xFFFFFFFF;
	//
	private static final int QRCODE_SIZE = 300;
	private static final int LOGO_WIDTH = 60;
	private static final int LOGO_HEIGHT = 60;

	private static BufferedImage createImage(String content, String logoPath, boolean needCompress) throws Exception {
		Hashtable<EncodeHintType, Object> hints = new Hashtable<EncodeHintType, Object>();
		hints.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.H);
		hints.put(EncodeHintType.CHARACTER_SET, CHARSET);
		BitMatrix bitMatrix = new MultiFormatWriter().encode(content, BarcodeFormat.QR_CODE, QRCODE_SIZE, QRCODE_SIZE,
				hints);
		int width = bitMatrix.getWidth();
		int height = bitMatrix.getHeight();
		BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		for (int x = 0; x < width; x++) {
			for (int y = 0; y < height; y++) {
				image.setRGB(x, y, bitMatrix.get(x, y) ? BLACK : WHITE);
			}
		}
		if (logoPath == null || "".equals(logoPath)) {
			return image;
		}
		//
		QRCodeUtil.insertImage(image, logoPath, needCompress);
		return image;

	}

	/**
	 * LOGO
	 * @param source
	 *
	 * @param logoPath
	 *            LOGO
	 * @param needCompress
	 *
	 * @throws Exception
	 */
	private static void insertImage(BufferedImage source, String logoPath, boolean needCompress) throws Exception {
		File file = new File(logoPath);
		if (!file.exists()) {
			throw new Exception("logo file not found.");
		}
		Image src = ImageIO.read(new File(logoPath));
		int width = src.getWidth(null);
		int height = src.getHeight(null);
		// LOGO
		if (needCompress) {
			if (width > LOGO_WIDTH) {
				width = LOGO_WIDTH;
			}
			if (height > LOGO_HEIGHT) {
				height = LOGO_HEIGHT;
			}
			Image image = src.getScaledInstance(width, height, Image.SCALE_SMOOTH);
			BufferedImage tag = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
			Graphics g = tag.getGraphics();
			g.drawImage(image, 0, 0, null); //
			g.dispose();
			src = image;
			// LOGO
			Graphics2D graph = source.createGraphics();
			int x = (QRCODE_SIZE - width) / 2;
			int y = (QRCODE_SIZE - height) / 2;
			graph.drawImage(src, x, y, width, height, null);
			graph.drawRoundRect(x, y, width, height, 6, 6);

			graph.setStroke(new BasicStroke(3f));
			graph.drawRect(x, y, width, height);
			graph.dispose();
		}
	}

	/**
	 *
	 * @param content
	 *
	 * @param logoPath
	 *            LOGO
	 * @param destPath
	 *
	 * @param needCompress
	 *
	 * @throws Exception
	 */
	public static String encode(String content, String logoPath, String destPath, boolean needCompress)
			throws Exception {
		BufferedImage image = QRCodeUtil.createImage(content, logoPath, needCompress);
		mkdirs(destPath);
		String fileName = new Random().nextInt(99999999) + "." + FORMAT.toLowerCase();
		ImageIO.write(image, FORMAT, new File(destPath + "/" + fileName));
		return fileName;
	}

	/**
	 *
	 * @param content
	 *
	 * @param logoPath
	 *            LOGO
	 * @param destPath
	 *
	 * @param fileName
	 *
	 * @param needCompress
	 *            LOGO
	 * @throws Exception
	 */
	public static String encode(String content, String logoPath, String destPath, String fileName, boolean needCompress)
			throws Exception {
		BufferedImage image = QRCodeUtil.createImage(content, logoPath, needCompress);
		mkdirs(destPath);
		fileName = fileName.substring(0, fileName.indexOf(".") > 0 ? fileName.indexOf(".") : fileName.length()) + "."
				+ FORMAT.toLowerCase();
		ImageIO.write(image, FORMAT, new File(destPath + "/" + fileName));
		return fileName;
	}

	/**
	 *
	 * @param content
	 *
	 * @param logoPath
	 *
	 * @param destPath
	 *
	 * @throws Exception
	 */
	public static String encode(String content, String logoPath, String destPath) throws Exception {
		return QRCodeUtil.encode(content, logoPath, destPath, false);
	}

	/**
	 *
	 * @param content
	 *
	 * @param destPath
	 *
	 * @param needCompress
	 *            LOGO
	 * @throws Exception
	 */
	public static String encode(String content, String destPath, boolean needCompress) throws Exception {
		return QRCodeUtil.encode(content, null, destPath, needCompress);
	}

	/**
	 *
	 * @param content
	 *
	 * @param destPath
	 *
	 * @throws Exception
	 */
	public static String encode(String content, String destPath) throws Exception {
		return QRCodeUtil.encode(content, null, destPath, false);
	}

	/**
	 *
	 * @param content
	 *
	 * @param logoPath
	 *
	 * @param output
	 *
	 * @param needCompress
	 *
	 * @throws Exception
	 */
	public static void encode(String content, String logoPath, OutputStream output, boolean needCompress)
			throws Exception {
		BufferedImage image = QRCodeUtil.createImage(content, logoPath, needCompress);
		ImageIO.write(image, FORMAT, output);
	}

	/**
	 *
	 * @param content
	 *
	 * @param output
	 *
	 * @throws Exception
	 */
	public static void encode(String content, OutputStream output) throws Exception {
		QRCodeUtil.encode(content, null, output, false);
	}

	/**
	 *
	 * @param file
	 *
	 * @return
	 * @throws Exception
	 */
	public static String decode(File file) throws Exception {
		BufferedImage image;
		image = ImageIO.read(file);
		if (image == null) {
			return null;
		}
		BufferedImageLuminanceSource source = new BufferedImageLuminanceSource(image);
		// LuminanceSource source = new BufferedImageLuminanceSource(image);
		BinaryBitmap bitmap = new BinaryBitmap(new HybridBinarizer(source));
		Result result;
		Hashtable<DecodeHintType, Object> hints = new Hashtable<DecodeHintType, Object>();
		hints.put(DecodeHintType.CHARACTER_SET, CHARSET);
		result = new MultiFormatReader().decode(bitmap, hints);
		String resultStr = result.getText();
		return resultStr;
	}

	/**
	 *
	 * @param path
	 *
	 * @return
	 * @throws Exception
	 */
	public static String decode(String path) throws Exception {
		return QRCodeUtil.decode(new File(path));
	}

	/**
	 *
	 * @param destPath
	 *
	 */
	public static void mkdirs(String destPath) {
		File file = new File(destPath);
		if (!file.exists() && !file.isDirectory()) {
			file.mkdirs();
		}
	}

	/**
	 *
	 * @author wuhongbo
	 * @param str
	 * @param width
	 * @param height
	 * @return
	 */
	public static BufferedImage getBarcode(String str, Integer width, Integer height) {

		if (width == null || width < 200) {
			width = 200;
		}

		if (height == null || height < 50) {
			height = 50;
		}

		try {
			//
			Hashtable<EncodeHintType, String> hints = new Hashtable<EncodeHintType, String>();
			hints.put(EncodeHintType.CHARACTER_SET, CHARSET);

			BitMatrix bitMatrix = new MultiFormatWriter().encode(str, BarcodeFormat.CODE_128, width, height, hints);

			return toBufferedImage(bitMatrix);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 *
	 * @author wuhongbo
	 * @param matrix
	 * @return
	 */
	private static BufferedImage toBufferedImage(BitMatrix matrix) {
		int width = matrix.getWidth();
		int height = matrix.getHeight();
		BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
		for (int x = 0; x < width; x++) {
			for (int y = 0; y < height; y++) {
				image.setRGB(x, y, matrix.get(x, y) ? BLACK : WHITE);
			}
		}
		return image;
	}

	/**
	 *
	 * @author wuhongbo
	 * @param str
	 * @param height
	 * @param file
	 * @throws IOException
	 */
	public static void getBarcodeWriteFile(String str, Integer width, Integer height, File file) throws IOException {
		BufferedImage image = getBarcode(str, width, height);
		ImageIO.write(image, "png", file);
	}
}

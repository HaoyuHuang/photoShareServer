package com.photoShare.beans.photos;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;

import javax.imageio.ImageIO;

public class PhotoFactory {

	// 图片宽和高的最大尺寸
	public static final int IMAGEMAXBIG = 2000;

	// 图片宽和高的最小尺寸
	public static final int IMAGEMINBIG = 10;

	// 按原图大小生成新图
	public static final int CREATENEWIMAGETYPE_0 = 0;

	// 按指定的大小生成新图
	public static final int CREATENEWIMAGETYPE_1 = 1;

	// 按原图宽高比例生成新图-按指定的宽度
	public static final int CREATENEWIMAGETYPE_2 = 2;

	// 按原图宽高比例生成新图-按指定的高度
	public static final int CREATENEWIMAGETYPE_3 = 3;

	// 按原图宽高比例生成新图-按指定的宽和高中较大的尺寸
	public static final int CREATENEWIMAGETYPE_4 = 4;

	// 按原图宽高比例生成新图-按指定的宽和高中较小的尺寸
	public static final int CREATENEWIMAGETYPE_5 = 5;

	/**
	 * 
	 * @param _file
	 *            原图片
	 * @param createType
	 *            处理类型
	 * @param newW
	 *            新宽度
	 * @param newH
	 *            新高度
	 * @param newImgName
	 *            新名称
	 * @return
	 * @throws Exception
	 */
	public static String createNewImage(File _file, int createType, int newW,
			int newH, String newImgName) throws Exception {
		if (_file == null)
			return null;
		String fileName = _file.getPath();
		String curPath = fileName.substring(0, fileName.lastIndexOf('\\') + 1);
		newImgName = curPath + newImgName;
		if (fileName == null || "".equals(fileName)
				|| fileName.lastIndexOf(".") == -1)
			return null;

		String fileExtName = fileName.substring(
				(fileName.lastIndexOf(".") + 1), fileName.length());
		if (newW < IMAGEMINBIG)
			newW = IMAGEMINBIG;
		else if (newW > IMAGEMAXBIG)
			newW = IMAGEMAXBIG;

		if (newH < IMAGEMINBIG)
			newH = IMAGEMINBIG;
		else if (newH > IMAGEMAXBIG)
			newH = IMAGEMAXBIG;

		// 得到原图信息
		if (!_file.exists() || !_file.isAbsolute() || !_file.isFile()
				|| !checkImageFile(fileExtName))
			return null;
		if ((new File(newImgName)).exists()) {
			System.out.println("file [" + newImgName + "] already exists");
			throw new Exception();
		}
		Image src = ImageIO.read(_file);
		int w = src.getWidth(null);
		int h = src.getHeight(null);

		// 确定目标图片的大小
		int nw = w;
		int nh = h;
		if (createType == CREATENEWIMAGETYPE_0) {
		} else if (createType == CREATENEWIMAGETYPE_1) {
			nw = newW;
			nh = newH;
		} else if (createType == CREATENEWIMAGETYPE_2) {
			nw = newW;
			nh = (int) ((double) h / (double) w * nw);
		} else if (createType == CREATENEWIMAGETYPE_3) {
			nh = newH;
			nw = (int) ((double) w / (double) h * nh);
		} else if (createType == CREATENEWIMAGETYPE_4) {
			if ((double) w / (double) h >= (double) newW / (double) newH) {
				nh = newH;
				nw = (int) ((double) w / (double) h * nh);
			} else {
				nw = newW;
				nh = (int) ((double) h / (double) w * nw);
			}
		} else if (createType == CREATENEWIMAGETYPE_5) {
			if ((double) w / (double) h <= (double) newW / (double) newH) {
				nh = newH;
				nw = (int) ((double) w / (double) h * nh);
			} else {
				nw = newW;
				nh = (int) ((double) h / (double) w * nw);
			}
		}

		// 构造目标图片
		BufferedImage tag = new BufferedImage(nw, nh,
				BufferedImage.TYPE_INT_RGB);

		// 得到目标图片输出流
		FileOutputStream out = new FileOutputStream(newImgName);

		// 根据需求画出目标图片 方式1
		tag.getGraphics().drawImage(src, 0, 0, nw, nh, null);

		// 将画好的目标图输出到输出流 方式1
		ImageIO.write(tag, "jpg", new File(newImgName));

		out.close();
		return newImgName;
	}

	public static boolean checkImageFile(String extName) {

		if ("jpg".equalsIgnoreCase(extName))
			return true;
		if ("gif".equalsIgnoreCase(extName))
			return true;
		if ("bmp".equalsIgnoreCase(extName))
			return true;
		if ("jpeg".equalsIgnoreCase(extName))
			return true;
		if ("png".equalsIgnoreCase(extName))
			return true;
		return false;
	}
}
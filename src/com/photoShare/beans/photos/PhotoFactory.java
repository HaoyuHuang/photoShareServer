package com.photoShare.beans.photos;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;

import javax.imageio.ImageIO;

public class PhotoFactory {

	// ͼƬ��͸ߵ����ߴ�
	public static final int IMAGEMAXBIG = 2000;

	// ͼƬ��͸ߵ���С�ߴ�
	public static final int IMAGEMINBIG = 10;

	// ��ԭͼ��С������ͼ
	public static final int CREATENEWIMAGETYPE_0 = 0;

	// ��ָ���Ĵ�С������ͼ
	public static final int CREATENEWIMAGETYPE_1 = 1;

	// ��ԭͼ��߱���������ͼ-��ָ���Ŀ��
	public static final int CREATENEWIMAGETYPE_2 = 2;

	// ��ԭͼ��߱���������ͼ-��ָ���ĸ߶�
	public static final int CREATENEWIMAGETYPE_3 = 3;

	// ��ԭͼ��߱���������ͼ-��ָ���Ŀ�͸��нϴ�ĳߴ�
	public static final int CREATENEWIMAGETYPE_4 = 4;

	// ��ԭͼ��߱���������ͼ-��ָ���Ŀ�͸��н�С�ĳߴ�
	public static final int CREATENEWIMAGETYPE_5 = 5;

	/**
	 * 
	 * @param _file
	 *            ԭͼƬ
	 * @param createType
	 *            ��������
	 * @param newW
	 *            �¿��
	 * @param newH
	 *            �¸߶�
	 * @param newImgName
	 *            ������
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

		// �õ�ԭͼ��Ϣ
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

		// ȷ��Ŀ��ͼƬ�Ĵ�С
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

		// ����Ŀ��ͼƬ
		BufferedImage tag = new BufferedImage(nw, nh,
				BufferedImage.TYPE_INT_RGB);

		// �õ�Ŀ��ͼƬ�����
		FileOutputStream out = new FileOutputStream(newImgName);

		// �������󻭳�Ŀ��ͼƬ ��ʽ1
		tag.getGraphics().drawImage(src, 0, 0, nw, nh, null);

		// �����õ�Ŀ��ͼ���������� ��ʽ1
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
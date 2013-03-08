package com.photoShare.request.service.impl;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import org.apache.commons.io.FileUtils;

import com.photoShare.request.service.IFileTools;

public class FileTools implements IFileTools {

	public File mkdirs(String path) {
		File file = new File(path);
		if (!file.exists()) {
			file.mkdirs();
		}
		return file;
	}

	public File createFile(String path, String name) {
		File file = new File(path, name);
		if (!file.exists()) {
			try {
				file.createNewFile();
			} catch (IOException e) {
				return null;
			}
		}
		return file;
	}

	@Override
	public String write(File origFile, String destPath) {
		// TODO Auto-generated method stub
		try {
			String uuid = UUID.randomUUID().toString().replaceAll("-", "");
			File destFile = new File(destPath, uuid);
			FileUtils.copyFile(origFile, destFile);
			return uuid;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}

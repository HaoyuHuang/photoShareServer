package com.photoShare.request.service;

import java.io.File;

public interface IFileTools {
	public File mkdirs(String path);

	public File createFile(String path, String name);

	public String write(File origFile, String destDest);

}

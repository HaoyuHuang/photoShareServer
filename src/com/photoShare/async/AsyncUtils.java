package com.photoShare.async;

import java.io.File;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import com.photoShare.beans.photos.PhotoFactory;
import com.photoShare.beans.photos.PhotoType;
import com.photoShare.hiber.domain.photo.TPhoto;
import com.photoShare.server.Server;

public class AsyncUtils {

	private static AsyncUtils async = new AsyncUtils();

	public static AsyncUtils getInstance() {
		return async;
	}

	private Executor pool = Executors.newCachedThreadPool();

	public void processImage(final File file,
			final AbstractAsyncListener<String> listener, final PhotoType type) {
		pool.execute(new Runnable() {

			public void run() {
				try {
					String oImage = file.getName();
					System.out.println(oImage);
					String newImage = "";
					switch (type) {
					case TINY:
						newImage = "tiny" + oImage;
						break;
					case MIDDLE:
						newImage = "middle" + oImage;
						break;
					case LARGE:
						newImage = "large" + oImage;
						break;
					default:
					}
					PhotoFactory.createNewImage(file,
							PhotoFactory.CREATENEWIMAGETYPE_1, type.getWidth(),
							type.getHeight(), newImage);
					if (listener != null) {
						listener.onComplete(newImage);
					}
				} catch (Exception e) {
					if (listener != null) {
						listener.onFault(e);
					}
				}
			}
		});
	}

	public void processImages(final TPhoto photo, final File file,
			final AbstractAsyncListener<String> listener) {
		pool.execute(new Runnable() {

			public void run() {
				PhotoType[] types = PhotoType.values();
				for (final PhotoType type : types) {

					try {
						String oImage = file.getName();
						System.out.println(oImage);
						String newImage = "";
						switch (type) {
						case TINY:
							newImage = "tiny" + oImage;
							System.out.println(newImage);
							String path = PhotoFactory.createNewImage(file,
									PhotoFactory.CREATENEWIMAGETYPE_1,
									type.getWidth(), type.getHeight(), newImage);
							System.out.println(path);
							photo.setFSmallSizeUrl(path
									.substring(Server.SERVER_CLASS_PATH
											.length() - 1));
							break;
						case MIDDLE:
							newImage = "middle" + oImage;
							System.out.println(newImage);
							path = PhotoFactory.createNewImage(file,
									PhotoFactory.CREATENEWIMAGETYPE_1,
									type.getWidth(), type.getHeight(), newImage);
							System.out.println(path);
							photo.setFSmallSizeUrl(path
									.substring(Server.SERVER_CLASS_PATH
											.length() - 1));
							break;
						case LARGE:
							newImage = "large" + oImage;
							System.out.println(newImage);
							path = PhotoFactory.createNewImage(file,
									PhotoFactory.CREATENEWIMAGETYPE_1,
									type.getWidth(), type.getHeight(), newImage);
							System.out.println(path);
							photo.setFSmallSizeUrl(path
									.substring(Server.SERVER_CLASS_PATH
											.length() - 1));
							break;
						default:
						}

					} catch (Exception e) {
						if (listener != null) {
							listener.onFault(e);
						}
					}
				}
				if (listener != null) {
					listener.onComplete("");
				}
			}
		});
	}
}

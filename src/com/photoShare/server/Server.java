package com.photoShare.server;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class Server {
	public static String SERVER_URL = "http://169.254.64.26:8080/Spring3Struts2";

	public static String SERVER_CLASS_PATH = "";

	public final static String PROJECT_NAME = "photoShare";

	public static void init(String classpath) {
		try {
			InetAddress addr = InetAddress.getLocalHost();
			System.out.println(addr.getHostAddress());
			SERVER_URL = "http://" + addr.getHostAddress() + ":8080/"
					+ PROJECT_NAME;
			SERVER_CLASS_PATH = classpath;
			System.out.println(SERVER_URL);
			System.out.println(SERVER_CLASS_PATH);
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

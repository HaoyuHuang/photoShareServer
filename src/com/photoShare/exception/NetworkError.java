package com.photoShare.exception;

/**
 * 灏佽鏈嶅姟鍣ㄨ繑鍥炵殑閿欒缁撴灉
 */
public class NetworkError extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public static final String ERROR_CODE = "error_code";

	public static final String ERROR_MSG = "error_msg";

	/** 閿欒鐮侊細鍙傛暟涓虹┖ */
	public static final int ERROR_CODE_NULL_PARAMETER = -1;

	/**
	 * 閿欒鐮侊細鏃犳硶鑾峰彇鏁版嵁
	 */
	public static final int ERROR_REFRESH_DATA = -2;

	/**
	 * 閿欒鐮侊細娉ㄥ唽澶辫触
	 */
	public static final int ERROR_SIGN_UP = -3;

	/**
	 * 閿欒鐮侊細鐧婚檰澶辫触
	 */
	public static final int ERROR_SIGN_IN = -5;
	/**
	 * 閿欒鐮侊細閭欢涓虹┖
	 */
	public static final int ERROR_MAIL_NULL = -7;
	/**
	 * 閿欒鐮侊細瀵嗙爜涓虹┖
	 */
	public static final int ERROR_PWD_NULL = -11;
	/**
	 * 閿欒鐮侊細鐢ㄦ埛鍚嶄负绌�
	 */
	public static final int ERROR_NAME_NULL = -13;
	/**
	 * 閿欒鐮侊細绗斿悕涓虹┖
	 */
	public static final int ERROR_PSEUDO_NAME_NULL = -17;
	/**
	 * 閿欒鐮侊細璺熼殢澶辫触
	 */
	public static final int ERROR_FOLLOW = -19;
	/**
	 * 閿欒鐮侊細璧炲け璐�
	 */
	public static final int ERRPR_LIKE = -23;
	/**
	 * 閿欒鐮侊細鍙戝竷鐓х墖澶辫触
	 */
	public static final int ERROR_PHOTO = -29;
	/**
	 * 閿欒鐮侊細璇勮澶辫触
	 */
	public static final int ERROR_COMMENT = -31;
	/**
	 * 閿欒鐮侊細淇敼璧勬枡澶辫触
	 */
	public static final int ERROR_EDIT_PROFILE = -37;

	/**
	 * 閿欒鐮侊細缃戠粶涓嶉�
	 */
	public static final int ERROR_NETWORK = -41;

	/**
	 * 閿欒鐮侊細鏈櫥闄�
	 */
	public static final int ERROR_SIGN_IN_NULL = -47;

	public static final int ERROR_SIGN_UP_MAIL_EXIST = -83;

	public static final int ERROR_FIND_FRIENDS = -91;

	/** 閿欒鐮侊細鍙傛暟瓒呭嚭浜嗛檺鍒�<br> */
	public static final int ERROR_CODE_PARAMETER_EXTENDS_LIMIT = 2;

	/** 閿欒鐮侊細闈炴硶鍙傛暟 */
	public static final int ERROR_CODE_ILLEGAL_PARAMETER = 3;

	/** 閿欒鐮侊細鏃犳硶瑙ｆ瀽鏈嶅姟鍣ㄥ搷搴斿瓧绗︿覆 */
	public static final int ERROR_CODE_UNABLE_PARSE_RESPONSE = 5;

	/** 閿欒鐮侊細鏈煡閿欒 */
	public static final int ERROR_CODE_UNKNOWN_ERROR = 9;

	/** */
	public static final int ERROR_CODE_LOG_ERROR = 13;

	/**
	 * 鏈嶅姟鍣ㄨ繑鍥炵殑閿欒浠ｇ爜
	 */
	private int errorCode;

	/** 鍘熷鍝嶅簲URL */
	private String orgResponse;

	public NetworkError() {
		super();
	}

	public NetworkError(NetworkError error) {
		this.errorCode = error.getErrorCode();
		this.orgResponse = error.getOrgResponse();
	}

	public NetworkError(String errorMessage) {
		super(errorMessage);
	}

	public NetworkError(int errorCode, String errorMessage, String orgResponse) {
		super(errorMessage);
		this.errorCode = errorCode;
		this.orgResponse = orgResponse;
	}

	public String getOrgResponse() {
		return orgResponse;
	}

	public int getErrorCode() {
		return errorCode;
	}

	@Override
	public String toString() {
		return "errorCode:" + this.errorCode + "\nerrorMessage:"
				+ this.getMessage() + "\norgResponse:" + this.orgResponse;
	}

	/**
	 * 灏嗘湇鍔″櫒杩斿洖鐨別rrorMessage杞崲涓哄瓧绗︿覆
	 * 
	 * @param errorCode
	 *            鏈嶅姟鍣ㄨ繑鍥炵殑閿欒浠ｇ爜
	 * @param errorMessage
	 *            鏈嶅姟鍣ㄨ繑鍥炵殑閿欒瀛楃涓诧紝鍜岄敊璇唬鐮佷竴涓�搴�
	 * @return
	 */
	public static String interpretErrorMessage(int errorCode,
			String errorMessage) {
		switch (errorCode) {
		// 鍥剧墖灏哄澶皬锛屾殏鏃跺皢杩欑鎯呭喌鐩存帴杩斿洖涓婁紶澶辫触锛屾棩鍚庡彲鑳戒細寮曡捣闂
		case 300:
			errorMessage = "";
			break;
		// 涓婁紶鐓х墖澶辫触
		case 20101:
			// 杩欓噷瀵规枃妗堝仛浜嗛�褰撲慨鏀癸紝浣挎彁绀轰俊鎭洿鍔犵畝娲佹槗鎳�
			// errorMessage = "涓婁紶鐓х墖澶辫触锛岃绋嶅悗閲嶈瘯";
			errorMessage = "璇风◢鍚庨噸璇�";
			break;
		// 涓婁紶鐓х墖绫诲瀷閿欒鎴栨湭鐭�
		case 20102:
		case 20103:
			errorMessage = "鏆備笉鏀寔姝ゆ牸寮忕収鐗囷紝璇烽噸鏂伴�鎷�";
			break;
		default:
			break;
		}
		return errorMessage;
	}
}

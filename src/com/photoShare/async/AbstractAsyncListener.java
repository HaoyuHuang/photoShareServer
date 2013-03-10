package com.photoShare.async;

import java.lang.reflect.Constructor;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public abstract class AbstractAsyncListener<T> {

	/**
	 * ��response�������Ϊ��Ծ��������bean
	 * 
	 * @param response
	 *            ������ɺ����Ӧ�ַ���
	 * @return �������ɹ������ؽ�����Ķ��󣬷��򷵻�null
	 */
	@SuppressWarnings("unchecked")
	public T parse(String response) {
		Class<?> c = this.getGenericType();
		try {
			Constructor<T> constructor = (Constructor<T>) c
					.getDeclaredConstructor(String.class);
			T result = constructor.newInstance(response);
			return result;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * ��ȡT������
	 * 
	 * @param index
	 * @return
	 */
	private Class<?> getGenericType() {
		Type genType = getClass().getGenericSuperclass();
		if (!(genType instanceof ParameterizedType)) {
			return Object.class;
		}
		Type[] params = ((ParameterizedType) genType).getActualTypeArguments();
		if (params.length < 1) {
			throw new RuntimeException("Index outof bounds");
		}
		if (!(params[0] instanceof Class)) {
			return Object.class;
		}
		return (Class<?>) params[0];
	}

	/**
	 * ������ɺ��Զ�����ʽ���ط���������Ӧ�Ľ��
	 * 
	 * @param bean
	 *            ���������ص���Ӧ�ַ���������õ��Ķ���
	 * 
	 */
	public abstract void onComplete(final T bean);
	
	/**
	 * 
	 * @param fault
	 */
	public abstract void onFault(final Throwable fault);
}

/*******************************************************************************
 * 2008-2014 Public Domain
 * Contributors
 * Marco Lopes (marcolopes@netc.pt)
 *******************************************************************************/
package org.dma.java.utils.klass;

import java.lang.reflect.Method;

public final class MethodUtils {


	public static Object invoke(String className, String methodName, Class[] parameterTypes, Object...args) throws Exception {

		Class klass=Class.forName(className);
		Method method=klass.getDeclaredMethod(methodName, parameterTypes);

		return method.invoke(klass, args);

	}


	public static Object invoke(String className, String methodName, Object...args) throws Exception {

		Class[] parameterTypes=new Class[args.length];
		for(int i=0; i<args.length; i++){
			parameterTypes[i]=args[i].getClass();
		}

		return invoke(className, methodName, parameterTypes, args);

	}


	public static void main(String[] args) throws Exception {

		System.out.println(
			invoke("java.lang.Integer", "valueOf", "10"));

	}


}
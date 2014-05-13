package common.util;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.support.AopUtils;
import org.springframework.util.MethodInvoker;

/**
 * 
 * @author wangliang_gz@hotmail.com
 * @version 1.0
 */
public class MethodUtils {
	static final Logger LOGGER = LoggerFactory.getLogger(MethodUtils.class);

	static public Object invokeMethod(Object obj, String methodName,
			Object[] args) throws InvocationTargetException,
			IllegalAccessException {
		if (AopUtils.isJdkDynamicProxy(obj)) {
			if (args == null) {
				args = new Object[0];
			}
			int arguments = args.length;
			Class parameterTypes[] = new Class[arguments];
			for (int i = 0; i < arguments; i++) {
				parameterTypes[i] = args[i].getClass();
			}
			Class _targetClass = AopUtils.getTargetClass(obj);
			if (_targetClass == null) {
				_targetClass = obj.getClass();
			}
			Class[] _targetInterfaces = _targetClass.getInterfaces();
			Method method = null;
			for (int i = 0; i < _targetInterfaces.length; i++) {
				method = org.apache.commons.beanutils.MethodUtils
						.getMatchingAccessibleMethod(_targetInterfaces[i],
								methodName, parameterTypes);
				if (method != null) {
					break;
				}
			}
			if (method == null) {
				method = org.apache.commons.beanutils.MethodUtils
						.getMatchingAccessibleMethod(_targetClass, methodName,
								parameterTypes);
			}
			if (method == null) {
				throw new NoSuchMethodError();
			}

			Object _rusult = null;
			try {
				_rusult = java.lang.reflect.Proxy.getInvocationHandler(obj)
						.invoke(obj, method, args);
			} catch (IllegalArgumentException e) {
				LOGGER.error(e.getMessage(),e);
				throw e;
			} catch (Throwable e) {
				LOGGER.error(e.getMessage(),e);
				throw new InvocationTargetException(e);
//				throw new InvocationTargetException(ExceptionUtils
//						.getRootCause(e));
			}
			return _rusult;

		} else {
			try {
				MethodInvoker invoker = new MethodInvoker();
				invoker.setTargetObject(obj);
				invoker.setArguments(args);
				invoker.setTargetMethod(methodName);
				invoker.prepare();
				return invoker.invoke();
			} catch (ClassNotFoundException e) {
				LOGGER.error(e.getMessage(),e);
				throw new InvocationTargetException(e);
			} catch (NoSuchMethodException e) {
				LOGGER.error(e.getMessage(),e);
				throw new InvocationTargetException(e);
			} catch (InvocationTargetException e) {
				LOGGER.error(e.getMessage(),e);
				throw e;
			} catch (IllegalAccessException e) {
				LOGGER.error(e.getMessage(),e);
				throw e;
			}
		}
	}

}

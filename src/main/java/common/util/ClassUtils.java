package common.util;

import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.StringUtils;

/**
 * @author wangliang_gz@hotmail.com
 * @version 1.0
 */
public final class ClassUtils {
	private ClassUtils() {

	}

	public static Class forName(String classPackages, String shortClassName,
			Class defaultIfNotFound) throws ClassNotFoundException,
			LinkageError {
		Class clazz = null;
		String[] _classPackages = null;
		if (classPackages != null) {
			_classPackages = classPackages.split(",");
		}
		if (StringUtils.indexOf(shortClassName, ".") != -1
				|| (ArrayUtils.isEmpty(_classPackages))) {
			clazz = org.springframework.util.ClassUtils.forName(shortClassName);
		} else {
			for (int i = 0; i < _classPackages.length; i++) {
				String packageName = _classPackages[i];
				if (StringUtils.isNotBlank(packageName)) {
					packageName = packageName.trim();
					if (!packageName.endsWith(".")) {
						packageName = packageName + ".";
					}
					String fullClassName = packageName + shortClassName;
					try {
						clazz = org.springframework.util.ClassUtils
								.forName(fullClassName);
					} catch (ClassNotFoundException e) {
						continue;
					} catch (LinkageError e) {
						continue;
					}
					if (clazz != null) {
						return clazz;
					}
				}
			}
		}
		if (clazz == null)
			clazz = defaultIfNotFound;

		return clazz;
	}

}

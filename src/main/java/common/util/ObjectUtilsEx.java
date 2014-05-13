package common.util;
/**
 * 
 * @author wangliang_gz@hotmail.com
 * @version 1.1.0
 */
import java.beans.PropertyDescriptor;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;

public class ObjectUtilsEx {

	public static Map beanToMap(Object obj) {
		Map map = new HashMap();
		if (obj != null) {
			BeanWrapper wrapper = new BeanWrapperImpl(obj);
			PropertyDescriptor[] xx = wrapper.getPropertyDescriptors();
			for (int i = 0; i < xx.length; i++) {
				PropertyDescriptor yy = xx[i];
				String propertyName = yy.getName();
				if (wrapper.isReadableProperty(propertyName)) {
					map.put(propertyName, wrapper
							.getPropertyValue(propertyName));
				}
			}

		}
		return map;
	}
	
	public static Map beanToMap(Object obj,String p) {
		Map map = new HashMap();
		if (obj != null) {
			BeanWrapper wrapper = new BeanWrapperImpl(obj);
			PropertyDescriptor[] xx = wrapper.getPropertyDescriptors();
			for (int i = 0; i < xx.length; i++) {
				PropertyDescriptor yy = xx[i];
				String propertyName = yy.getName();
				if (wrapper.isReadableProperty(propertyName)) {
					map.put(p+propertyName, wrapper
							.getPropertyValue(propertyName));
				}
			}

		}
		return map;
	}
}

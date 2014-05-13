package common.util;

import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.apache.commons.lang.ObjectUtils;
import org.apache.commons.lang.StringUtils;

/**
 * @author liang.wang@footmarktech.com
 * @version 1.0
 */
public class CollectionUtils {
	
	public static void main(String[] args){
		Map map = new HashMap();
		map.put("xx", new Date());
		boolean xx = CollectionUtils.isBlank(map, "xx");
		System.out.println(xx);
	}
	
	
	public static boolean isBlank(java.util.Map _map ,String _key){
		if(_map ==null)return true;
		if(_key ==null) return true;
		Object val = _map.get(_key);
		if(val ==null){
			return true;
		}else{
			if(val instanceof String){
				String valStr = ObjectUtils.toString(val);
				return StringUtils.isBlank(valStr);
			}
			return false;
		}
		
		
	}
	
	
	public static Map findValuesOfType(java.util.Map _map, Class type)
			throws IllegalArgumentException {
		if (_map == null) {
			return Collections.EMPTY_MAP;
		}

		Class typeToUse = (type != null ? type : Object.class);
		Map _mapResult = new HashMap();

		Iterator _it = _map.keySet().iterator();
		while (_it.hasNext()) {
			Object _k = _it.next();
			Object _v = _map.get(_k);
			if (typeToUse.isInstance(_v)) {
				_mapResult.put(_k, _v);
			}
		}
		return _mapResult;
	}

	public static boolean isEmpty(Collection collection) {
		return org.springframework.util.CollectionUtils.isEmpty(collection);
	}

	public static boolean isEmpty(Map map) {
		return org.springframework.util.CollectionUtils.isEmpty(map);
	}
	
	public static Object firstResult(Collection c, Object safeNotNull) {
		if (org.springframework.util.CollectionUtils.isEmpty(c)) {
			return safeNotNull;
		}
		Object result = c.iterator().next();
		if (result == null)
			return safeNotNull;
		return result;
	}

	public static Object firstResult(Collection c) {
		return firstResult(c, null);
	}
}

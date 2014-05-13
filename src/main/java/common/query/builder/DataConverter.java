package common.query.builder;

/**
 * @author wangliang_gz@hotmail.com
 * @version 1.0
 */
public interface DataConverter {
	public Object convert(Object arg0, String arg1) throws Exception;
}
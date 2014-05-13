package common.hibernate3.type;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.hibernate.type.StringType;
/**
 * @author wangliang_gz@hotmail.com
 * @version 1.0
 */
public class TrimStringType extends StringType{

	private static final long serialVersionUID = 38194227984079624L;
	public Object get(ResultSet rs, String name) throws SQLException{
		Object obj = super.get(rs, name);
		if(obj ==null) return obj;
		String temp =  ((String)obj).trim();
		return temp;
    }
	
	public String getName() { return "trimString"; }

}

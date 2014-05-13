package common.hibernate3.type;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.usertype.UserType;
/**
 * @author wangliang_gz@hotmail.com
 * @version 1.0
 */
public class BigDecimalUserType implements UserType {
	private static final int[] SQL_TYPES = { Hibernate.BIG_DECIMAL.sqlType() };

	public Object assemble(Serializable cached, Object owner)
			throws HibernateException {
		throw new UnsupportedOperationException();
	}

	public Object deepCopy(Object value) throws HibernateException {
		return value;
	}

	public Serializable disassemble(Object value) throws HibernateException {
		throw new UnsupportedOperationException();
	}

	public boolean equals(Object x, Object y) throws HibernateException {
		return x == y
				|| (x != null && y != null && ((BigDecimal) x)
						.compareTo((BigDecimal) y) == 0);
	}

	public int hashCode(Object x) throws HibernateException {
		return ((BigDecimal) x).hashCode();
	}

	public boolean isMutable() {
		return false;
	}

	public Object nullSafeGet(ResultSet rs, String[] names, Object owner)
			throws HibernateException, SQLException {
		
		if (rs==null||names==null||owner==null||names.length==0)
			return new BigDecimal(0); 
		
		Object  value = rs.getObject(names[0]);
        if (!rs.wasNull()) { 
        	return value;
        } 
        return new BigDecimal(0); 

	}

	public void nullSafeSet(PreparedStatement st, Object value, int index)
			throws HibernateException, SQLException {
		Hibernate.BIG_DECIMAL.nullSafeSet(st, value, index);

	}

	public Object replace(Object original, Object target, Object owner)
			throws HibernateException {
		return original;
	}

	public Class returnedClass() {
		return BigDecimal.class;
	}

	public int[] sqlTypes() {
		return SQL_TYPES;
	}

}

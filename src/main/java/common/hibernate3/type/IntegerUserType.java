package common.hibernate3.type;

import java.io.Serializable;
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
public class IntegerUserType implements UserType {
	private static final int[] SQL_TYPES = { Hibernate.INTEGER.sqlType() };

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
				|| (x != null && y != null && ((Integer) x)
						.compareTo((Integer) y) == 0);
	}

	public int hashCode(Object x) throws HibernateException {
		return ((Integer) x).intValue();
	}

	public boolean isMutable() {
		return false;
	}

	public Object nullSafeGet(ResultSet rs, String[] names, Object owner)
			throws HibernateException, SQLException {
		Object  value = rs.getObject(names[0]);
       
        if (!rs.wasNull()) { 
        	return value;
        } 
        return new Integer(0); 

	}

	public void nullSafeSet(PreparedStatement st, Object value, int index)
			throws HibernateException, SQLException {
		Hibernate.INTEGER.nullSafeSet(st, value, index);

	}

	public Object replace(Object original, Object target, Object owner)
			throws HibernateException {
		return original;
	}

	public Class returnedClass() {
		return Integer.class;
	}

	public int[] sqlTypes() {
		return SQL_TYPES;
	}

}

package common.hibernate3.id;

import java.io.Serializable;
import java.util.Properties;

import org.hibernate.HibernateException;
import org.hibernate.MappingException;
import org.hibernate.dialect.Dialect;
import org.hibernate.engine.SessionImplementor;
import org.hibernate.id.Configurable;
import org.hibernate.id.IdentifierGenerationException;
import org.hibernate.id.IdentifierGenerator;
import org.hibernate.id.UUIDHexGenerator;
import org.hibernate.type.Type;
/**
 * @author wangliang_gz@hotmail.com
 * @version 1.0
 * if no Assigned use uuid.hex
 */
public class Assigned1 implements IdentifierGenerator, Configurable {

	private String entityName;

	public Serializable generate(SessionImplementor session, Object obj) throws HibernateException {
		Serializable id = session.getEntityPersister( entityName, obj ) 
				.getIdentifier( obj, session.getEntityMode() );
		
		if(id == null){
			id = new UUIDHexGenerator().generate(session, obj);
		}
		
		if (id==null) {
			throw new IdentifierGenerationException(
				"ids for this class must be manually assigned before calling save(): " + 
				entityName
			);
		}
		
		return id;
	}

	public void configure(Type type, Properties params, Dialect d)
	throws MappingException {
		entityName = params.getProperty(ENTITY_NAME);
		if (entityName==null) {
			throw new MappingException("no entity name");
		}
	}
}

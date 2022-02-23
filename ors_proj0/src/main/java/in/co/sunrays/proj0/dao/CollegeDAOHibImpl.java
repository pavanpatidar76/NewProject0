package in.co.sunrays.proj0.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import in.co.sunrays.proj0.dto.CollegeDTO;
import in.co.sunrays.proj0.dto.UserDTO;


/**
 * College Data Access Object provides Database CRUD operations. It is implemented
 * by plain Hibernate 3 API with Spring ORM.
 * 
 * All methods propagate unchecked DataAccessException. It is a generic
 * exception handling provided by Spring-DAO.
 * 
 * If DataAccessException is propagated from method then declarative transaction
 * is rolled back by Spring AOP.
 * 
 * This is plain Hibernate 3 API implementation of DAO
 * @author pavan
 *
 */
@Repository
public class CollegeDAOHibImpl implements CollegeDAOInt {
	
	/** The sessionfactory. */
	@Autowired
	private SessionFactory sessionfactory = null;
	
	/** The log. */
	private static Logger log = Logger.getLogger(CollegeDAOHibImpl.class);
	/**
	 * AddMethod
	 */
	public long add(CollegeDTO dto) {
		log.debug("College add method started");
		long pk=0;
		pk=(Long) sessionfactory.getCurrentSession().save(dto);
log.debug("College Add method ended");
		return pk;
	}


	/**
	 *Update Method
	 */
	public void update(CollegeDTO dto) {
		log.debug("college update started");
		sessionfactory.getCurrentSession().merge(dto);
		log.debug("college update ended");
		
	}

	/**
	 *Delete Method
	 */
	public void delete(long id) {
		log.debug("college delete started");
		System.out.println("in College delete 3-->>>>>>>>>>>>>>>");
	   	 
		sessionfactory.getCurrentSession().delete(id);
		System.out.println("in College delete 4-->>>>>>>>>>>>>>>");
	   	 
		log.debug("college delete ended");
		
	}

	
	/**
	 *Find By Nmae
	 */
	public CollegeDTO findByName(String name) {

		log.debug("college update started");
		CollegeDTO dto=null;
		List list=sessionfactory.getCurrentSession().createCriteria(CollegeDTO.class)
		.add(Restrictions.like("name", name)).list();
		if(list.size()==1){
	dto=(CollegeDTO)list.get(0);
		}
		log.debug("college update ended");
		return dto;
	}

	
	/**
	 *Find By PK
	 */
	public CollegeDTO findByPK(long pk) {
		log.debug("College Dao FindById Started");
	 CollegeDTO dto = null;
		dto = (CollegeDTO) sessionfactory.getCurrentSession().get(CollegeDTO.class, pk);
		log.debug("College Dao FindById End");
		return dto;
	}

	
	/**
	 *Search
	 */
	public List search(CollegeDTO dto, int pageNo, int pageSize) {
		log.debug("College Dao Search Started");
		List list = null;
		Criteria criteria = sessionfactory.getCurrentSession().createCriteria(CollegeDTO.class);
		if (dto != null) {
			if (dto.getId() > 0) {
				criteria.add(Restrictions.eq("id", dto.getId()));
			}
			if (dto.getName() != null && dto.getName().length() > 0) {
				criteria.add(Restrictions.like("name", dto.getName() + "%"));
			}
          }

		// if page size is greater than zero the apply pagination
		if (pageSize > 0) {
			criteria.setFirstResult((pageNo - 1) * pageSize);
			criteria.setMaxResults(pageSize);
		}

		list = criteria.list();
		log.debug("college Dao Search End");
		return list;

	}

	
	/**
	 *Search
	 */
	public List search(CollegeDTO dto) {
		// TODO Auto-generated method stub
		return search(dto,0,0);
	}

}

package in.co.sunrays.proj0.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import in.co.sunrays.proj0.dao.CourseDAOInt;
import in.co.sunrays.proj0.dto.CourseDTO;
import in.co.sunrays.proj0.exception.DuplicateRecordException;

/**
 * The Class CourseServiceSpringImpl.
 * @author pavan
 *
 */
@Service
public class CourseServiceSpringImpl implements CourseServiceInt {
	
	/** The dao. */
	@Autowired
	CourseDAOInt dao;
	
	/** The log. */
	private static Logger log = Logger.getLogger(CourseServiceSpringImpl.class);
	
	
	/**
	 *The Add
	 */
	@Transactional(propagation = Propagation.REQUIRES_NEW, readOnly = false)
	public long add(CourseDTO dto) throws DuplicateRecordException {

    	log.debug("CourseServiceSpringImpl Add Started");
    	CourseDTO dtoExist = dao.findByName(dto.getName());
        if (dtoExist != null) {
            throw new DuplicateRecordException("Course Name already exists");
        }
        long pk = dao.add(dto);
        log.debug("CourseServiceSpringImpl Add End");
        return pk;
	}
	
	
	/**
	 *Update Method
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void update(CourseDTO dto) throws DuplicateRecordException {
		log.debug("CourseServiceSpringImpl update Started");
    	dao.update(dto);
    	log.debug("CourseServiceSpringImpl update End");
	}
	
	
	/**
	 *Delete 
	 */
	@Transactional(propagation = Propagation.REQUIRES_NEW, readOnly = false)
	public void delete(long id) {
		log.debug("CourseServiceSpringImpl delete Started");
   	 dao.delete(id);
   	log.debug("CourseServiceSpringImpl delete End");
		
	}
	
	
	/**
	 *Find By Name
	 */
	@Transactional(readOnly = false)
	public CourseDTO findByName(String courseName) {
		log.debug("CourseServiceSpringImpl findByName Started");
		CourseDTO dto = dao.findByName(courseName);
    	log.debug("CourseServiceSpringImpl findByName End");
    	return dto;
	}
	
	/**
	 *FInd By Id
	 */
	@Transactional(readOnly = false)
	public CourseDTO findById(long id) {
		log.debug("CourseServiceSpringImpl findById Started");
		CourseDTO dto = dao.findByPK(id);
    	log.debug("CourseServiceSpringImpl findById End");
    	return dto;
	}
	
	/**
	 *Search
	 */
	@Transactional( readOnly = false)
	public List<CourseDTO> search(CourseDTO dto, int pageNo, int pageSize) {
		return dao.search(dto, pageNo, pageSize);
	}
	
	
	/**
	 *Search
	 */
	@Transactional(readOnly = false)
	public List<CourseDTO> search(CourseDTO dto) {
		return dao.search(dto);
	}

}

package in.co.sunrays.proj0.test;

import java.util.Iterator;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import in.co.sunrays.proj0.dto.RoleDTO;
import in.co.sunrays.proj0.service.RoleServiceInt;

@RunWith(SpringJUnit4ClassRunner.class)
@Configuration
@ContextConfiguration("file:src/main/webapp/WEB-INF/Dispatcher-servlet.xml")

public class RoleTest {
	
	
	@Autowired
	private RoleServiceInt c;
	
	
	@Test
	public void testAdd() {
			
			RoleDTO dto = new RoleDTO();
		
			dto.setName("adminastrator");
			dto.setCreatedBy("root");
			dto.setModifiedBy("root");
			dto.setDescription("Administrator"); 
			
			System.out.println("in test add");
			
			try {
			 c.add(dto);
			 
			 System.out.println("in try");
			
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("in catch");
				e.printStackTrace();
				
			//	fail("Role already exist");
				
			}
		
	}
		
	 @Ignore
	 public void testupdate() {
			
			RoleDTO dto = new RoleDTO();
			
			dto.setId(1);
			
			
			dto.setCreatedBy("akash");
			dto.setModifiedBy("akash");
		   
			try {
			 c.update(dto);
			
			} catch (Exception e) {
				// TODO: handle exception
				
		e.printStackTrace();
				
			}
		
	}
		
	 @Ignore
	 public void delete() {
		 	
		
		 
			try {
				c.delete(2);
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
				//fail();
			}
			
		}
//	 @Test
//		public void findByName() {
//			CourseDTO dto = new CourseDTO();
//			dto.setName("Admin");
//			try {
//				RoleDTO dtoget = c.findByName(dto.getName());
//				
//		
//				
//				System.out.println(dtoget.getCreatedBy());
//				System.out.println(dtoget.getId());
//				System.out.println(dtoget.getKey());
//				System.out.println(dtoget.getModifiedBy());
//				System.out.println(dtoget.getRoleName());
//		
//			} catch (Exception e) {
//				// TODO: handle exception
//				fail("name does not exist");
//			}
//		}
		@Ignore
		public void findByPK() {
			RoleDTO dto = new RoleDTO();
			dto.setId(2L);
			try {
				RoleDTO dtoget = c.findById(dto.getId());
				
				
				System.out.println(dtoget.getCreatedBy());
				System.out.println(dtoget.getId());
				System.out.println(dtoget.getKey());
				System.out.println(dtoget.getModifiedBy());
				System.out.println(dtoget.getName());
				
			} catch (Exception e) {
				// TODO: handle exception
			//	fail("name does not exist");
			}	
		}
		
		@Ignore
		public void testSearch() {
			
			RoleDTO dto = new RoleDTO();
			try {
				List l = c.search(dto, 0, 10);
				
				Iterator it = l.iterator();
				while (it.hasNext()) {
					RoleDTO dtoget = (RoleDTO) it.next();
					
					System.out.println(dtoget.getCreatedBy());
					System.out.println(dtoget.getId());
					System.out.println(dtoget.getKey());
					System.out.println(dtoget.getModifiedBy());
					System.out.println(dtoget.getName());
					
					
				}
				
			} catch (Exception e) {
				// TODO: handle exception
				//fail(" Search fail");
			}
			
		}
		
		@Ignore
		public void testSearch2() {
			
			RoleDTO dto = new RoleDTO();
			try {
				List<RoleDTO> dt = c.search(dto);
				Iterator it = dt.iterator();
				while (it.hasNext()) {
					RoleDTO dtoget = (RoleDTO) it.next();
					
					System.out.println(dtoget.getCreatedBy());
					System.out.println(dtoget.getId());
					System.out.println(dtoget.getKey());
					System.out.println(dtoget.getModifiedBy());
					System.out.println(dtoget.getName());
					System.out.println(dtoget.getDescription());
					System.out.println(dtoget.getModifiedDateTime());
					
				}
			} catch (Exception e) {
				// TODO: handle exception
			//	fail("Search fail");
			}
		
		
		}
	

	
}

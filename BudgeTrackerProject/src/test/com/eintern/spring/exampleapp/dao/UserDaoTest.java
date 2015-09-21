package test.com.eintern.spring.exampleapp.dao;

import static org.junit.Assert.assertEquals;

import java.util.Date;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.eintern.budgetracker.dao.UserDAO;
import com.eintern.budgetracker.entity.Expense;
import com.eintern.budgetracker.entity.Revenue;
import com.eintern.budgetracker.entity.User;

public class UserDaoTest {
	@Test
	public void testUserDao() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext(
				"appConfig.xml");
		User u = new User();
		u.setName(Math.random() + "TEST");
		u.setPassword(Math.random() + "TESTP");
		u.setUsername(Math.random() + "TESTU");
		u.setUsername(Math.random() + "TESTE");
		UserDAO uDao = (UserDAO) ctx.getBean(UserDAO.class);
		Long id = null;
		try {
			id = uDao.saveUser(u);
			User pU = uDao.getUserByName(u.getName());
			assertEquals(id, pU.getId());
			assertEquals(u.getName(), pU.getName());
			assertEquals(u.getPassword(), pU.getPassword());
		} finally {
			if (id != null)
				uDao.deleteById(id);
		}
	}
	
	@Test
	public void testExpenses(){
		ApplicationContext ctx = new ClassPathXmlApplicationContext("appConfig.xml");
		Expense e = new Expense();
		e.setAmount(500.69);
		e.setDateSpent(new Date(1500000));
		e.setExpenseType("Project");
		UserDAO dao = (UserDAO) ctx.getBean(UserDAO.class);
		Long id = null;
		try{
			id = dao.addExpense(e);
			Expense ee = dao.getExpenseByID(e.getId());
			assertEquals(id, ee.getId());
			assertEquals(e.getExpenseType(), ee.getExpenseType() );
			assertEquals(e.getDateSpent(), ee.getDateSpent());
			assertEquals(e.getAmount(), ee.getAmount(), 0);
		}
		finally{
			if(id != null)
				System.out.println("done");
		}
	}
	
	@Test
	public void testRevenues(){
		ApplicationContext ctx = new ClassPathXmlApplicationContext("appConfig.xml");
		Revenue r = new Revenue();
		r.setAmount(500.69);
		r.setDatePaid(new Date(1500000));
		r.setClient("JPMorgan");
		UserDAO dao = (UserDAO) ctx.getBean(UserDAO.class);
		Long id = null;
		try{
			id = dao.addRevenue(r);
			Revenue rr = dao.getRevenueByID(r.getId());
			assertEquals(id, rr.getId());
			assertEquals(r.getClient(), rr.getClient() );
			assertEquals(r.getDatePaid(), rr.getDatePaid());
			assertEquals(r.getAmount(), rr.getAmount(), 0);
		}
		finally{
			if(id != null)
				System.out.println("done");
		}
	}
}

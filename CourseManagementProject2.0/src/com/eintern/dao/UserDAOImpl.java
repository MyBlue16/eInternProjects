package com.eintern.dao;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

public class UserDAOImpl {

	SessionFactory factory;
	Session session;

	public void setup() {
		factory = new Configuration().configure().buildSessionFactory();
		session = factory.openSession();
	}

	public int authenticateUser(String username, String password) {
		int permission = -1;

		Criteria userCriteria = session.createCriteria(Account.class)
				.add(Restrictions.eq("username", username))
				.add(Restrictions.eq("password", password));

		List<Account> userList = userCriteria.list();
		Iterator<Account> it = userList.iterator();

		if (!userList.isEmpty()) {
			Account a = it.next();
			String role = a.getRole();
			if (role.equals("Admin")) {
				permission = 0;
			} else if (role.equals("Stud")) {
				permission = 2;
			} else {
				permission = 1;
			}
		}

		return permission;
	}

	public boolean addAdministrator(String name, String username,
			String password, String email) {
		boolean flag = false;

		try {
			Administrator newAdmin = new Administrator();

			newAdmin.setName(name);
			newAdmin.setEmail(email);

			Account newAccount = new Account();
			newAccount.setUsername(username);
			newAccount.setPassword(password);
			newAccount.setRole("Admin");

			newAdmin.setAccout(newAccount);
			newAccount.setAdmin(newAdmin);

			session.beginTransaction();
			session.saveOrUpdate(newAdmin);
			session.getTransaction().commit();

			flag = true;
		} catch (HibernateException e) {
			e.printStackTrace();
			
		}
		return flag;
	}

	public boolean removeAdmin(int adminID) {
		boolean flag = false;
		try {
			Criteria adminCriteria = session
					.createCriteria(Administrator.class).add(
							Restrictions.eq("id", adminID));
			List<Administrator> admin = adminCriteria.list();
			Iterator<Administrator> it = admin.iterator();
			Administrator toRemove = null;
			while (it.hasNext()) {
				toRemove = it.next();
			}

			if (toRemove != null) {
				session.beginTransaction();
				session.delete(toRemove);
				session.getTransaction().commit();
				flag = true;
			}
		} catch (HibernateException e) {

			e.printStackTrace();
		}
		return flag;
	}

	public ArrayList<Administrator> getAllAdmins() {
		ArrayList<Administrator> adminList = new ArrayList<Administrator>();

		try {

			List<Administrator> userList = session.createCriteria(
					Administrator.class).list();
			Iterator<Administrator> it = userList.iterator();
			while (it.hasNext()) {
				adminList.add(it.next());
			}
		} catch (HibernateException e) {
			e.printStackTrace();
		}

		return adminList;

	}

	public boolean addStudent(String name, String username, String password,
			String email, String classification, String major) {
		boolean flag = false;
		try {
			Student newStud = new Student();
			Account newAccount = new Account();

			newAccount.setUsername(username);
			newAccount.setPassword(password);
			newAccount.setRole("Stud");

			newStud.setName(name);
			newStud.setEmail(email);
			newStud.setMajor(major);
			newStud.setClassification(classification);

			newAccount.setStud(newStud);
			newStud.setAccount(newAccount);

			session.beginTransaction();
			session.saveOrUpdate(newStud);
			session.getTransaction().commit();
			flag = true;
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return flag;
	}

	public boolean removeStudent(int studID) {
		boolean flag = false;
		try {
			Criteria studCriteria = session.createCriteria(Student.class).add(
					Restrictions.eq("id", studID));
			List<Student> student = studCriteria.list();
			Iterator<Student> it = student.iterator();
			Student toRemove = null;
			while (it.hasNext()) {
				toRemove = it.next();
			}

			if (toRemove != null) {
				session.beginTransaction();
				session.delete(toRemove);
				session.getTransaction().commit();
				flag = true;
			}
		} catch (HibernateException e) {

			e.printStackTrace();
		}
		return flag;

	}

	public ArrayList<Student> getAllStudents() {
		ArrayList<Student> studentList = new ArrayList<Student>();

		try {

			List<Student> userList = session.createCriteria(Student.class)
					.list();
			Iterator<Student> it = userList.iterator();
			while (it.hasNext()) {
				studentList.add(it.next());
			}
		} catch (HibernateException e) {
			e.printStackTrace();
		}

		return studentList;

	}

	public boolean addAdvisor(String name, String username, String password,
			String email, String department) {
		boolean flag = false;

		try {
			Advisor newAdvisor = new Advisor();
			Account newAccount = new Account();

			newAdvisor.setName(name);
			newAdvisor.setDept(department);
			newAdvisor.setEmail(email);

			newAccount.setUsername(username);
			newAccount.setPassword(password);
			newAccount.setRole("Advisor");

			newAccount.setAdvisor(newAdvisor);
			newAdvisor.setAccount(newAccount);

			session.beginTransaction();
			session.saveOrUpdate(newAdvisor);
			session.getTransaction().commit();
			flag = true;
		} catch (HibernateException e) {
			e.printStackTrace();
		}

		return flag;
	}

	public boolean removeAdvisor(int advisorID) {
		boolean flag = false;
		try {
			Criteria advisCriteria = session.createCriteria(Advisor.class).add(
					Restrictions.eq("id", advisorID));
			List<Advisor> advisor = advisCriteria.list();
			Iterator<Advisor> it = advisor.iterator();
			Advisor toRemove = null;
			while (it.hasNext()) {
				toRemove = it.next();
			}

			if (toRemove != null) {
				session.beginTransaction();
				session.delete(toRemove);
				session.getTransaction().commit();
				flag = true;
			}
		} catch (HibernateException e) {

			e.printStackTrace();
		}
		return flag;
	}

	public ArrayList<Advisor> getAllAdvisors() {

		ArrayList<Advisor> advisorList = new ArrayList<Advisor>();

		try {

			List<Advisor> userList = session.createCriteria(Advisor.class)
					.list();
			Iterator<Advisor> it = userList.iterator();
			while (it.hasNext()) {
				advisorList.add(it.next());
			}
		} catch (HibernateException e) {
			e.printStackTrace();
		}

		return advisorList;
	}

	public boolean approveStudent(String id, String approved) {
		boolean flag = false;
		try {
			if (approved.equals("yes")) {
				Criteria userCriteria = session.createCriteria(Student.class)
						.add(Restrictions.eq("id", Integer.parseInt(id)));

				List<Student> userList = userCriteria.list();
				Iterator<Student> it = userList.iterator();
				Student nowApproved = new Student();
				while (it.hasNext()) {
					// Search for student and set his approval
					nowApproved = it.next();
					nowApproved.setApproved(true);
				}

				session.beginTransaction();
				session.update(nowApproved);
				session.getTransaction().commit();
			}
			flag = true;
		} catch (HibernateException e) {
			e.printStackTrace();
		}

		return flag;
	}

	public boolean addMajor(String degreeName, Integer numClasses) {
		boolean flag = false;

		try {

			Major newMajor = new Major();

			newMajor.setname(degreeName);
			newMajor.setNumClassesToDegree(numClasses);
			Set<Courses> set = new HashSet<Courses>();
			newMajor.setRequiredCourses(set);

			session.beginTransaction();
			session.saveOrUpdate(newMajor);
			session.getTransaction().commit();

			flag = true;
		} catch (HibernateException e) {
			e.printStackTrace();

		}

		return flag;

	}

	public boolean removeMajor(String name) {
		boolean flag = false;

		try {

			Criteria majorCriteria = session.createCriteria(Major.class).add(
					Restrictions.eq("name", name));
			List<Major> major = majorCriteria.list();
			Iterator<Major> it = major.iterator();
			Major toRemove = null;

			while (it.hasNext()) {
				toRemove = it.next();
			}

			if (toRemove != null) {
				session.beginTransaction();
				session.delete(toRemove);
				session.getTransaction().commit();
				flag = true;
			}

		} catch (HibernateException e) {

			e.printStackTrace();
		}

		return flag;

	}

	public ArrayList<Major> getAllMajors() {
		ArrayList<Major> majorsList = new ArrayList<Major>();

		try {

			List<Major> userList = session.createCriteria(Major.class).list();
			Iterator<Major> it = userList.iterator();
			while (it.hasNext()) {
				majorsList.add(it.next());
			}
		} catch (HibernateException e) {
			e.printStackTrace();
		}

		return majorsList;
	}

	public boolean addCourse(String name, String id, String department,
			String location, String semester, String size, String start,
			String end) {
		boolean flag = false;

		try {
			Courses newCourse = new Courses();
			newCourse.setCourseName(name);
			newCourse.setCapSize(Integer.parseInt(size));
			newCourse.setStartTime(start);
			newCourse.setEndTime(end);
			newCourse.setId(Integer.parseInt(id));
			newCourse.setLocation(location);
			newCourse.setSemesterOffered(semester);

			Criteria majorCriteria = session.createCriteria(Major.class).add(
					Restrictions.eq("name", department));
			List<Major> majorsList = majorCriteria.list();
			Iterator<Major> it = majorsList.iterator();
			if (it.hasNext()) {
				Major m = it.next();
				m.getRequiredCourses().add(newCourse);
				newCourse.setMajors(m);

				session.beginTransaction();
				session.saveOrUpdate(newCourse);
				session.getTransaction().commit();

				flag = true;
			}
		} catch (HibernateException e) {

			e.printStackTrace();
		}

		return flag;

	}

	public boolean removeCourse(int courseID) {
		boolean flag = false;

		try {

			Criteria courseCriteria = session.createCriteria(Courses.class)
					.add(Restrictions.eq("id", courseID));
			List<Courses> course = courseCriteria.list();
			Iterator<Courses> it = course.iterator();
			Courses toRemove = null;

			while (it.hasNext()) {
				toRemove = it.next();
			}

			if (toRemove != null) {
				session.beginTransaction();
				session.delete(toRemove);
				session.getTransaction().commit();
				flag = true;
			}

		} catch (HibernateException e) {

			e.printStackTrace();
		}

		return flag;
	}

	public ArrayList<Courses> getAllCourses() {
		ArrayList<Courses> courseList = new ArrayList<Courses>();

		try {

			List<Courses> userList = session.createCriteria(Courses.class)
					.list();
			Iterator<Courses> it = userList.iterator();
			while (it.hasNext()) {
				courseList.add(it.next());
			}
		} catch (HibernateException e) {
			e.printStackTrace();
		}

		return courseList;

	}

	public boolean registerForClass(int id, int[] crns) {
		boolean flag = false;
		try {
			Criteria studCriteria = session.createCriteria(Student.class).add(
					Restrictions.eq("id", id));
			List<Student> sl = studCriteria.list();
			Iterator<Student> it = sl.iterator();
			if (it.hasNext()) {
				Student toUpdate = it.next();

				if (!toUpdate.isApproved()) {

					for (int i = 0; i < crns.length; i++) {
						if (crns[i] != 0) {
							Criteria courseCriteria = session.createCriteria(
									Courses.class).add(
									Restrictions.eq("id", crns[i]));
							List<Courses> course = courseCriteria.list();
							Iterator<Courses> courseIT = course.iterator();
							if (courseIT.hasNext()) {
								toUpdate.getClassSchedule()
										.add(courseIT.next());
							}
						}
					}
					session.beginTransaction();
					session.saveOrUpdate(toUpdate);
					session.getTransaction().commit();
					flag = true;
				}
			}
		} catch (HibernateException e) {
			e.printStackTrace();
		}

		return flag;
	}

	public boolean dropClass(int id, int crn) {
		boolean flag = false;
		try {
			Criteria studCriteria = session.createCriteria(Student.class).add(
					Restrictions.eq("id", id));
			Criteria classCriteria = session.createCriteria(Courses.class).add(
					Restrictions.eq("id", crn));

			List<Student> stdList = studCriteria.list();
			Iterator<Student> sIt = stdList.iterator();
			if (sIt.hasNext()) {
				List<Courses> clist = classCriteria.list();
				Iterator<Courses> cIt = clist.iterator();
				Student toUpdate = sIt.next();

				if (cIt.hasNext()) {
					toUpdate.getClassSchedule().remove(cIt.next());

					session.beginTransaction();
					session.saveOrUpdate(toUpdate);
					session.getTransaction().commit();

					flag = true;
				}
			}
		} catch (HibernateException e) {

			e.printStackTrace();
		}

		return flag;

	}

	public void teardown() {
		session.close();
		factory.close();
	}

}

package all.controller.admin;

import java.util.List;

import javax.persistence.Entity;
import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import all.entity.User;

@Transactional
@Entity
@Controller
@RequestMapping("admin/")
public class usersController {
	@Autowired
	SessionFactory factory;
	
	@RequestMapping("users")
	public String admin(ModelMap model) {
		Session ses = factory.getCurrentSession();
		String sql = " FROM User";
		Query q = ses.createQuery(sql);
		List<User> list = q.list();
		model.addAttribute("users", list);
		return "admin/users";
	}
	
	@RequestMapping(value="insertUsers", method=RequestMethod.GET)
	public String insert(ModelMap model) {
		model.addAttribute("user", new User());
		return "admin/users";
	}
	
	@RequestMapping(value="insertUsers", method=RequestMethod.POST)
	public String acceptInsert(ModelMap model, @ModelAttribute("user")User u, BindingResult errors) {
		if(u.getId() <= 0) {
			errors.rejectValue("id", "user", "nhap id");
		}
		if(u.getUsername().trim().length() == 0) {
			errors.rejectValue("username", "user", "nhap username");
		}
		if(u.getPassword().trim().length() == 0) {
			errors.rejectValue("password", "user", "nhap password");
		}
		if(u.getEmail().trim().length() == 0) {
			errors.rejectValue("email", "user", "nhap email");
		}
		if(errors.hasErrors()) {
		}
		else {
			Session session = factory.openSession();
			Transaction t = session.beginTransaction();
			try {
				session.save(u);
				t.commit();
				model.addAttribute("message", "Insert successful");
			} catch (Exception e) {
				t.rollback();
				model.addAttribute("message", "Failed");
			} finally {
				session.close();
			}
		}
		return "redirect:/admin/users.htm";
	}
	
	@RequestMapping(value="deleteUsers/{id}")
	public String edit(ModelMap model, @PathVariable("id")int id) {
		Session ses = factory.openSession();
		String sql = "DELETE FROM User WHERE ID=:id";
		Query q = ses.createQuery(sql);
		q.setParameter("id", id);
		q.executeUpdate();
		return "redirect:/admin/users.htm";
	}
}

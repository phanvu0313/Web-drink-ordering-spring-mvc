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

import all.entity.Type;

@Transactional
@Entity
@Controller
@RequestMapping("admin/")
public class typesController {
	@Autowired
	SessionFactory factory;

	@RequestMapping("types")
	public String admin(ModelMap model) {
		Session ses = factory.getCurrentSession();
		String sql = " FROM Type";
		Query q = ses.createQuery(sql);
		List<Type> list = q.list();
		model.addAttribute("typesList", list);
		return "admin/types";
	}
	
	@RequestMapping(value="insertTypes", method=RequestMethod.GET)
	public String insert(ModelMap model) {
		model.addAttribute("type", new Type());
		return "admin/types";
	}
	
	@RequestMapping(value="insertTypes", method=RequestMethod.POST)
	public String acceptInsert(ModelMap model, @ModelAttribute("type")Type type, BindingResult errors) {
		if(type.getNametype().trim().length() == 0) {
			errors.rejectValue("name", "type", "nhap name");
		}
		
		if(errors.hasErrors()) {
		}
		else {
			Session session = factory.openSession();
			Transaction t = session.beginTransaction();
			try {
				session.save(type);
				t.commit();
				model.addAttribute("message", "Insert successful");
			} catch (Exception e) {
				t.rollback();
				model.addAttribute("message", "Failed");
			} finally {
				session.close();
			}
		}
		return "redirect:/admin/types.htm";
	}
	
	@RequestMapping(value="deleteTypes/{idtype}")
	public String delete(ModelMap model, @PathVariable("idtype")int idtype) {
		Session ses = factory.openSession();
		String sql = "DELETE FROM Type WHERE IDTYPE=:idtype";
		Query q = ses.createQuery(sql);
		q.setParameter("idtype", idtype);
		q.executeUpdate();
		return "redirect:/admin/types.htm";
	}
}

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

import all.entity.Response;

@Transactional
@Entity
@Controller
@RequestMapping("admin/")
public class responseController {
	@Autowired
	SessionFactory factory;
	
	@RequestMapping("responses")
	public String admin(ModelMap model) {
		Session ses = factory.getCurrentSession();
		String sql = " FROM Response";
		Query q = ses.createQuery(sql);
		List<Response> list = q.list();
		model.addAttribute("responses", list);
		return "admin/responses";
	}
	
	@RequestMapping(value="insertResponses", method=RequestMethod.POST)
	public String acceptInsert(ModelMap model, @ModelAttribute("response")Response r, BindingResult errors) {
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();
		try {
			session.save(r);
			t.commit();
			model.addAttribute("message", "Insert successful");
		} catch (Exception e) {
			t.rollback();
			model.addAttribute("message", "Failed");
		} finally {
			session.close();
		}
		return "redirect:/admin/responses.htm";
	}
	
	@RequestMapping(value="deleteResponses/{idres}")
	public String delete(ModelMap model, @PathVariable("idres")int idres) {
		Session ses = factory.openSession();
		String sql = "DELETE FROM Response WHERE IDRES=:idres";
		Query q = ses.createQuery(sql);
		q.setParameter("idres", idres);
		q.executeUpdate();
		return "redirect:/admin/responses.htm";
	}
}

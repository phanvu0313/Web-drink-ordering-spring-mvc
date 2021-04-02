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

import all.entity.Category;
import all.entity.Type;

@Transactional
@Entity
@Controller
@RequestMapping("admin/")
public class categoriesController {
	@Autowired
	SessionFactory factory;
	
	@ModelAttribute("listIDTypes")
	public List<Type> getTypes(ModelMap model) {
		Session ses = factory.getCurrentSession();
		String hql = "FROM Type";
		Query query = ses.createQuery(hql);
		List<Type> list = query.list();
		model.addAttribute("listIDTypes", list);
		return list;
	}
	
	@RequestMapping("categories")
	public String admin(ModelMap model) {
		Session ses = factory.getCurrentSession();
		String sql = " FROM Category";
		Query q = ses.createQuery(sql);
		List<Category> list = q.list();
		model.addAttribute("categories", list);
		return "admin/categories";
	}
	
	
	@RequestMapping(value="insertCategories", method=RequestMethod.GET)
	public String insert(ModelMap model) {
		model.addAttribute("category", new Category());
		return "admin/categories";
	}
	
	@RequestMapping(value="insertCategories", method=RequestMethod.POST)
	public String acceptInsert(ModelMap model, @ModelAttribute("category")Category c, BindingResult errors) {
		if(c.getNamecate().trim().length() == 0) {
			errors.rejectValue("namecate", "category", "nhap name");
		}
		if(c.getPrices() < 0) {
			errors.rejectValue("prices", "category", "nhap gia");
		}
		if(c.getDiscount() < 0) {
			errors.rejectValue("discount", "category", "nhap discount");
		}
		else if(c.getDiscount() > 100) {
			errors.rejectValue("discount", "category", "nhap discount");
		}
		if(c.getReviews().trim().length() == 0) {
			errors.rejectValue("reviews", "category", "nhap reviews");
		}
		if(errors.hasErrors()) {
		}
		else {
			Session session = factory.openSession();
			Transaction t = session.beginTransaction();
			try {
				session.save(c);
				t.commit();
				model.addAttribute("message", "Insert successful");
			} catch (Exception e) {
				t.rollback();
				model.addAttribute("message", "Failed");
			} finally {
				session.close();
			}
		}
		return "redirect:/admin/categories.htm";
	}
	
	@RequestMapping(value="deleteCategories/{idcate}")
	public String delete(ModelMap model, @PathVariable("idcate")int idcate) {
		Session ses = factory.openSession();
		String sql = "DELETE FROM Category WHERE IDCATE=:idcate";
		Query q = ses.createQuery(sql);
		q.setParameter("idcate", idcate);
		q.executeUpdate();
		return "redirect:/admin/categories.htm";
	}
}

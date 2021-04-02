package all.controller.user;

import java.util.List;

import javax.persistence.Entity;
import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import all.entity.Category;

@Transactional
@Entity
@Controller
public class toolBarController {
	@Autowired
	SessionFactory factory;
	
	@RequestMapping("isNew")
	public String isNew(ModelMap model) {
		model.addAttribute("isNew", "active");
		Session ses = factory.getCurrentSession();
		String sql = "FROM Category WHERE NEWITEMS='True'";
		Query q = ses.createQuery(sql);
		List<Category> list = q.list();
		model.addAttribute("products", list);
		model.addAttribute("url", "isNew");
		return "user/store";
	}
	
	@RequestMapping("isSelling")
	public String isSelling(ModelMap model) {
		model.addAttribute("selling", "active");
		Session ses = factory.getCurrentSession();
		String sql = "FROM Category WHERE DISCOUNT > 0 ORDER BY NEWID()";
		Query q = ses.createQuery(sql);
		List<Category> list = q.list();
		model.addAttribute("products", list);
		model.addAttribute("url", "isSelling");
		return "user/store";
	}
	
	@RequestMapping("ios")
	public String ios(ModelMap model) {
		model.addAttribute("ios", "active");
		Session ses = factory.getCurrentSession();
		String sql = "FROM Category WHERE IDTYPE=1";
		Query q = ses.createQuery(sql);
		List<Category> list = q.list();
		model.addAttribute("products", list);
		model.addAttribute("url", "ios");
		return "user/store";
	}
	
	@RequestMapping("android")
	public String android(ModelMap model) {
		model.addAttribute("android", "active");
		Session ses = factory.getCurrentSession();
		String sql = "FROM Category WHERE IDTYPE=2 OR IDTYPE=3";
		Query q = ses.createQuery(sql);
		List<Category> list = q.list();
		model.addAttribute("products", list);
		model.addAttribute("url", "android");
		return "user/store";
	}
	
	@RequestMapping("contact")
	public String contact(ModelMap model) {
		model.addAttribute("contact", "active");
		return "user/contact";
	}
}

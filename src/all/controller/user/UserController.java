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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import all.entity.Category;
@Transactional
@Entity
@Controller	
@RequestMapping("")
public class UserController {
	@Autowired
	SessionFactory factory;
	
	@RequestMapping("/home")
	public String home(ModelMap model) {
		
		
		Session ses = factory.getCurrentSession();
		String sql = "FROM Category WHERE NEWITEMS='True'";	
		Query q = ses.createQuery(sql);
		List<Category> list = q.list();
		model.addAttribute("newProducts", list);
		
		
		
		return "main";
	}
	
	@RequestMapping("/aboutus")
	public String aboutus() {
		return "aboutus";
	}
	
	@RequestMapping("/products")
	public String products(ModelMap model) {
		
		Session ses = factory.getCurrentSession();
		String sql = "FROM Category";	
		Query q = ses.createQuery(sql);
		List<Category> list = q.list();
		model.addAttribute("allProducts", list);
		return "products";
	}
	
	@RequestMapping("/caphe")
	public String caphe(ModelMap model) {
		Session ses = factory.getCurrentSession();
		String sql = "FROM Category WHERE IDTYPE=1";	
		Query q = ses.createQuery(sql);
		List<Category> list = q.list();
		model.addAttribute("cfProducts", list);
		return "caphe";
	}
	
	@RequestMapping("/daxay")
	public String daxay(ModelMap model) {
		Session ses = factory.getCurrentSession();
		String sql = "FROM Category WHERE IDTYPE=3";	
		Query q = ses.createQuery(sql);
		List<Category> list = q.list();
		model.addAttribute("daxayProducts", list);
		return "daxay";
	}
	
	
	@RequestMapping("/tra")
	public String tra(ModelMap model) {
		Session ses = factory.getCurrentSession();
		String sql = "FROM Category WHERE IDTYPE=2";	
		Query q = ses.createQuery(sql);
		List<Category> list = q.list();
		model.addAttribute("traProducts", list);
		return "tra";
	}
	@RequestMapping("/giohang")
	public String giohang() {
		
		return "giohang";
	}
	@RequestMapping("/test")
	public String test() {
		
		return "test";
	}
	
}

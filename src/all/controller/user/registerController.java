package all.controller.user;

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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import all.entity.User;
import all.bean.Mailer;

@Transactional
@Entity
@Controller
public class registerController {
	@Autowired
	Mailer mailer;
	@Autowired
	SessionFactory factory;
	
	@RequestMapping(value="newRegister", method=RequestMethod.GET) 
	public String register(ModelMap model) {
		model.addAttribute("user", new User());
		return "user/register";
	}
	
	
	@RequestMapping(value="newRegister", method=RequestMethod.POST)
	public String register(ModelMap model, @ModelAttribute("user") User user, @RequestParam("email")String to, 
			BindingResult errors, @RequestParam("password")String password, @RequestParam("password1")String password1
			, @RequestParam("checkbox")boolean checkbox) {
		if(user.getUsername().trim().length() < 8) {
			errors.rejectValue("username", "user", "tai khoan khong duoc duoi 8 ky tu");
		}
		else if (user.getUsername().trim().length() > 100) {
			errors.rejectValue("username", "user", "tai khoan khong duoc tren 100 ky tu");
		}
		
		if(user.getPassword().trim().length() == 0) {
			errors.rejectValue("password", "user", "mat khau khong duoc de trong");
		}
		else if (user.getPassword().trim().length() < 6) {
			errors.rejectValue("password", "user", "mat khau khong duoc duoi 6 ky tu");
		}
		
		if(!password.equals(password1)) {
			errors.rejectValue("password", "user", "mat khau khong trung khop");
		}
		
		String regex = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
		if(user.getEmail().trim().length() == 0) {
			errors.rejectValue("email", "user", "email khong duoc de trong");
		}
		else if(user.getEmail().trim().matches(regex) == false){
			errors.rejectValue("email", "user", "email khong dung dinh dang");
		}
		
		if(checkbox == false) {
			model.addAttribute("checkbox", "hay dong y cac dieu khoan");
		}
		
		if(errors.hasErrors()) {
		}
		else {
			
			Session ses = factory.getCurrentSession();
			String sql = "EXEC SP_SINHIDUSER";
			Query q = ses.createSQLQuery(sql);
			List<Integer> ID = q.list();
			int id = ID.get(0);
			id = id + 1;
			user.setId(id);
			
			Session session = factory.openSession();
			Transaction t = session.beginTransaction();
			try {
				session.save(user);
				String from = "truongquynh2525@gmail.com";
				String subject = "TheGioiDiDong";
				String body = "Thank for beliving in my service";
				mailer.send(from, to, subject, body);
				model.addAttribute("message", "Insert successful");
				t.commit();
			} catch (Exception e) {
				t.rollback();
				model.addAttribute("message", "Failed");
				e.printStackTrace();
			} finally {
				session.close();
			}
			return "redirect:/index.htm";
		}
		return "user/register";
	}
}

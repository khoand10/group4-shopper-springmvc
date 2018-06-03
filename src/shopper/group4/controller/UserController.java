package shopper.group4.controller;

import java.lang.reflect.Method;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import shopper.group4.entity.Admin;
import shopper.group4.entity.Users;
import shopper.group4.service.UsersService;

@Controller
@RequestMapping("/home/")
public class UserController {
	@Autowired
	private UsersService userService;
	
	@RequestMapping("login")
	public String login(@CookieValue(value="user",defaultValue="null",required=false)String uname,HttpSession session
			) {
		if("".equals(uname) || "null".equals(uname)
				) {
			return "home/login";
		}else {
		session.setAttribute("user",userService.getUsers(uname));
		return "redirect:index.htm";
		}
	}
	
	@RequestMapping(value="check-login",method=RequestMethod.POST)
	public String checkLogin(HttpSession sessionn,@RequestParam("username")String username,
			@RequestParam("password")String password, ModelMap model,
			HttpServletResponse response,
			@Validated @ModelAttribute("student") Users usererror,  BindingResult errors
			){
		//Users user=userService.checkLogin(username, password);
		Users user = userService.getUsers(username);
		if(null!=user) {
			Cookie cookie = new Cookie("user", username);
			response.addCookie(cookie);
			sessionn.setAttribute("user",user);
			return "home/index";
		}else {
			if(errors.hasErrors()){
				model.addAttribute("message", "Vui lòng sửa các lỗi sau đây !");
			}
			else{
				model.addAttribute("message", "Chúc mừng, bạn đã nhập đúng !");
			}
			return "redirect:login.htm";
		} 
	}
	
	@RequestMapping(value="info",method=RequestMethod.GET)
	public String getInfo() {
		return "home/info";
	}
	
	@RequestMapping(value="register",method=RequestMethod.POST)
	public String register(Users user,ModelMap model
//			@RequestParam("uname") String uname,@RequestParam("pass")String pass,
//			@RequestParam("email") String email,@RequestParam("phone")String phone,
//			@RequestParam("address")String address,@RequestParam("fullname")String fullname,
//			@RequestParam("birthday")Date birthday
			) {
		try {
			userService.addUsers(user);
			model.addAttribute("message","Create acount success");
		} catch (Exception e) {
			model.addAttribute("message","Create acount fail");
		}
		return "home/login";
	}
	@RequestMapping("logout")
	public String logout(HttpSession session,HttpServletResponse response) {
		Cookie cookie = new Cookie("user", null);
		response.addCookie(cookie);
		session.removeAttribute("user");
		return "home/login";
	}
	
	@RequestMapping("admin/login")
	public String login() {
		return "admin/login";
	}
	
	@RequestMapping("admin/check-login-admin")
	public String returnIndexAdmin(@RequestParam("username")String uname,@RequestParam("password")String pass,
			HttpSession session
			) {
		Admin admin= userService.getAdmin(uname);
		if(null==admin) {
			return "redirect:check-login-admin.htm";
		}else {
		if(pass.equals(admin.getPassword())) {
			session.setAttribute("admin", admin);
			return "admin/index";
		}else {
			return "redirect:check-login-admin.htm";
		}
		}
	}
	
	@RequestMapping("admin/user")
	public String loadUserAdmin(ModelMap model,HttpSession session) {
		List<Users>list=userService.getAllUsers();
		session.setAttribute("listuser",list);
		model.addAttribute("userdetail",new Users());
		return "admin/user";
	}
	@RequestMapping(value = "admin/edit/{uname}", method = RequestMethod.GET)
	public String addCountry(@ModelAttribute("uname") String uname, ModelMap model) {
		model.addAttribute("userdetail",userService.getUsers(uname));
		List<Users>list=userService.getAllUsers();
		model.addAttribute("listuser",list);
		return "admin/user";
	}
	@RequestMapping(value = "admin/delete/{uname}", method = RequestMethod.GET)
	public String delete(@PathVariable("uname") String uname) {
		userService.delete(uname);
		return "redirect:admin/user.htm";
	}
	@RequestMapping(value ="admin/add", method = RequestMethod.POST)
	public String addCountry(@ModelAttribute("userdetail") Users user) {
		Users user1 = userService.getUsers(user.getUsername());
		if(user1==null) {
			userService.addUsers(user);
		}else {
			userService.updateUsers(user);
		}
		return "redirect:user.htm";

}
	@RequestMapping(value ="admin/logout",method = RequestMethod.GET)
	public String logout(HttpSession session) {
		session.removeAttribute("admin");
		return "admin/login";
	}
	
}



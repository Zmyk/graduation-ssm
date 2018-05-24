/**
 * 
 */
package controller;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.aliyuncs.exceptions.ClientException;

import beans.Admin;
import beans.User;
import services.AdminServices;
import services.GoodServices;

/**
 * @author zhang
 *
 */
@Controller
@RequestMapping(value = "/admin")
public class AdminController {
	
	@Autowired
	AdminServices adminServices;
	
	@RequestMapping(value = "/login",method=RequestMethod.POST)
	@ResponseBody
	public HashMap<String, String> login(@RequestParam(value="name",required=false) String name,@RequestParam(value="password",required=false) String password,HttpServletResponse response,HttpServletRequest request) throws ClientException, IOException{
		response.addHeader("Access-Control-Allow-Origin", "*");
		Admin admin = new Admin();
		admin.setAdmin_name(name);
		admin.setAdmin_password(password);
		HashMap<String, String> s = new HashMap<String, String>();
		if(adminServices.isLogin(admin)){
			request.getSession().setAttribute("admin", name);
			s.put("state", "success");
		}
		else{
			s.put("state","false");
		}
		return s;
	}

}

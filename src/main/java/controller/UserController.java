/**
 * 
 */
package controller;

import java.io.IOException;
import java.util.ArrayList;
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

import beans.Message;
import beans.User;
import services.GoodServices;
import services.UserServices;
import utils.CommonUtil;

/**
 * @author zhang
 *
 */
@Controller
@RequestMapping(value = "/user")
public class UserController {
	
	@Autowired
	UserServices userServices;
	@Autowired
	GoodServices goodServices;
	
	@RequestMapping(value = "/register",method=RequestMethod.POST)
	@ResponseBody
	public HashMap<String, String> getCheckCode(@RequestParam(value="phoneNumber",required=false) String phoneNumber,@RequestParam(value="password",required=false) String password,@RequestParam(value="checkCode",required=false) String checkCode,HttpServletResponse response,HttpServletRequest request) throws ClientException, IOException{
		response.addHeader("Access-Control-Allow-Origin", "*");
		String sessionCheckCode = (String) request.getSession().getAttribute("checkCode");
		String registerPhone = (String) request.getSession().getAttribute("registerPhone");
		User user = new User();
		String add_name = phoneNumber.substring(7, 11);
		user.setU_name("用户" + add_name);
		user.setU_password(password);
		user.setU_phone(phoneNumber);
		HashMap<String, String> s = new HashMap<String, String>();
		if(userServices.isRegister(registerPhone, phoneNumber, checkCode, sessionCheckCode, user)){
			request.getSession().removeAttribute("checkCode");
			request.getSession().removeAttribute("registerPhone");
			s.put("state", "success");
		}
		else{
			s.put("state","false");
		}
		return s;
	}
	
	@RequestMapping(value = "/resetPassword",method=RequestMethod.POST)
	@ResponseBody
	public HashMap<String, String> resetPassword(@RequestParam(value="phoneNumber",required=false) String phoneNumber,@RequestParam(value="password",required=false) String password,@RequestParam(value="checkCode",required=false) String checkCode,HttpServletResponse response,HttpServletRequest request) throws ClientException, IOException{
		response.addHeader("Access-Control-Allow-Origin", "*");
		String sessionCheckCode = (String) request.getSession().getAttribute("checkCode");
		String registerPhone = (String) request.getSession().getAttribute("registerPhone");
		User user = new User();
		user.setU_password(password);
		user.setU_phone(phoneNumber);
		HashMap<String, String> s = new HashMap<String, String>();
		if(userServices.isresetPassword(registerPhone, phoneNumber, checkCode, sessionCheckCode, user)){
			request.getSession().removeAttribute("checkCode");
			request.getSession().removeAttribute("registerPhone");
			s.put("state", "success");
		}
		else{
			s.put("state","false");
		}
		return s;
	}
	
	@RequestMapping(value = "/login",method=RequestMethod.POST)
	@ResponseBody
	public HashMap<String, String> login(@RequestParam(value="phoneNumber",required=false) String phoneNumber,@RequestParam(value="password",required=false) String password,HttpServletResponse response,HttpServletRequest request) throws ClientException, IOException{
		response.addHeader("Access-Control-Allow-Origin", "*");
		User user = new User();
		user.setU_password(password);
		user.setU_phone(phoneNumber);
		HashMap<String, String> s = new HashMap<String, String>();
		if(userServices.isLogin(user)){
			request.getSession().setAttribute("login_user", userServices.getU_name(phoneNumber));
			request.getSession().setAttribute("u_phone",phoneNumber);
			s.put("state", "success");
		}
		else{
			s.put("state","false");
		}
		return s;
	}
	
	@RequestMapping(value = "/getUser",method=RequestMethod.POST)
	@ResponseBody
	public HashMap<String, Object> getUser(HttpServletResponse response,HttpServletRequest request) throws ClientException, IOException{
		response.addHeader("Access-Control-Allow-Origin", "*");
		HashMap<String, Object> s = new HashMap<String, Object>();
		ArrayList<User> userList;
		if((userList=userServices.getUser())!=null){
			s.put("state", "success");
			s.put("userList", userList);
		}
		else{
			s.put("state","false");
		}
		return s;
	}
	
	@RequestMapping(value = "/closure",method=RequestMethod.POST)
	@ResponseBody
	public HashMap<String, Object> closure(@RequestParam(value="u_phone",required=false) String u_phone,HttpServletResponse response,HttpServletRequest request) throws ClientException, IOException{
		response.addHeader("Access-Control-Allow-Origin", "*");
		HashMap<String, Object> s = new HashMap<String, Object>();
		if(userServices.isClosure(u_phone) && goodServices.isClosure(u_phone)){
			s.put("state", "success");
		}
		else{
			s.put("state","false");
		}
		return s;
	}
	
	@RequestMapping(value = "/getClosureUser",method=RequestMethod.POST)
	@ResponseBody
	public HashMap<String, Object> getClosureUser(HttpServletResponse response,HttpServletRequest request) throws ClientException, IOException{
		response.addHeader("Access-Control-Allow-Origin", "*");
		HashMap<String, Object> s = new HashMap<String, Object>();
		ArrayList<User> closureUserList;
		if((closureUserList=userServices.getClosureUser())!=null){
			s.put("state", "success");
			s.put("closureUserList", closureUserList);
		}
		else{
			s.put("state","false");
		}
		return s;
	}
	
	@RequestMapping(value = "/delClosureUser",method=RequestMethod.POST)
	@ResponseBody
	public HashMap<String, Object> delClosureUser(@RequestParam(value="u_phone",required=false) String u_phone,HttpServletResponse response,HttpServletRequest request) throws ClientException, IOException{
		response.addHeader("Access-Control-Allow-Origin", "*");
		HashMap<String, Object> s = new HashMap<String, Object>();
		System.out.println(goodServices.delClosure(u_phone));
		if(userServices.delClosureUser(u_phone)&&goodServices.delClosure(u_phone)){
			s.put("state", "success");
		}
		else{
			s.put("state","false");
		}
		return s;
	}
}

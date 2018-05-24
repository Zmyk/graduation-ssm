/**
 * 
 */
package controller;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.aliyuncs.exceptions.ClientException;


/**
 * @author zhang
 *
 */
@Controller
@RequestMapping(value = "/session")
public class SessionController {
	@RequestMapping(value = "/getLoginUser",method=RequestMethod.POST)
	@ResponseBody
	public HashMap<String, String> getLoginUser(HttpServletResponse response,HttpServletRequest request) throws ClientException, IOException{
		response.addHeader("Access-Control-Allow-Origin", "*");
		String login_user = (String) request.getSession().getAttribute("login_user");
		HashMap<String, String> s = new HashMap<String, String>();
		if(login_user!=null){
			s.put("state", "success");
			s.put("login_user", login_user);
		}
		else{
			s.put("state","false");
		}
		return s;
		
	}
	
	@RequestMapping(value = "/deleteLoginUser",method=RequestMethod.POST)
	@ResponseBody
	public HashMap<String, String> deleteLoginUser(HttpServletResponse response,HttpServletRequest request) throws ClientException, IOException{
		response.addHeader("Access-Control-Allow-Origin", "*");
		request.getSession().removeAttribute("login_user");
		HashMap<String, String> s = new HashMap<String, String>();
		if(request.getSession().getAttribute("login_user")==null){
			s.put("state", "success");
		}
		else{
			s.put("state","false");
		}
		return s;
	}
	
	@RequestMapping(value = "/getLoginAdmin",method=RequestMethod.POST)
	@ResponseBody
	public HashMap<String, String> getLoginAdmin(HttpServletResponse response,HttpServletRequest request) throws ClientException, IOException{
		response.addHeader("Access-Control-Allow-Origin", "*");
		String admin = (String) request.getSession().getAttribute("admin");
		HashMap<String, String> s = new HashMap<String, String>();
		if(admin!=null){
			s.put("state", "success");
			s.put("admin", admin);
		}
		else{
			s.put("state","false");
		}
		return s;
		
	}
	@RequestMapping(value = "/deleteAdmin",method=RequestMethod.POST)
	@ResponseBody
	public HashMap<String, String> deleteAdmin(HttpServletResponse response,HttpServletRequest request) throws ClientException, IOException{
		response.addHeader("Access-Control-Allow-Origin", "*");
		request.getSession().removeAttribute("admin");
		HashMap<String, String> s = new HashMap<String, String>();
		if(request.getSession().getAttribute("admin")==null){
			s.put("state", "success");
		}
		else{
			s.put("state","false");
		}
		return s;
	}
}

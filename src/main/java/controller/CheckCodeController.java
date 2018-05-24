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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.aliyuncs.exceptions.ClientException;

import services.CheckCodeServices;

/**
 * @author zhang
 *
 */
@Controller
@RequestMapping(value = "/checkCode")
public class CheckCodeController {
	@RequestMapping(value = "/getCheckCode",method=RequestMethod.POST)
	@ResponseBody
	public HashMap<String, String> getCheckCode(@RequestParam(value="phoneNumber",required=false) String phoneNumber,HttpServletResponse response,HttpServletRequest request) throws ClientException, IOException{
		response.addHeader("Access-Control-Allow-Origin", "*");
		HashMap<String, String> s = new HashMap<String, String>();	
		if(CheckCodeServices.getCheckCode(phoneNumber,request)){
			s.put("state", "success");
		}
		else{
			s.put("state","false");
		}
		return s;
	}

}

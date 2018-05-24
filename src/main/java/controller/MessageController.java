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
import model.MessageModel;
import services.MessageServices;
import services.UserServices;
import utils.CommonUtil;

/**
 * @author zhang
 *
 */
@Controller
@RequestMapping(value = "/message")
public class MessageController {
	@Autowired
	MessageServices messageServices;
	
	@RequestMapping(value = "/addMessage",method=RequestMethod.POST)
	@ResponseBody
	public HashMap<String, String> addMessage(@RequestParam(value="good_id",required=false) String good_id,@RequestParam(value="content",required=false) String content,HttpServletResponse response,HttpServletRequest request) throws ClientException, IOException{
		response.addHeader("Access-Control-Allow-Origin", "*");
		String date = CommonUtil.getDate();
		Message message = new Message(good_id,(String)request.getSession().getAttribute("u_phone"),content,date);
		HashMap<String, String> s = new HashMap<String, String>();
		if(messageServices.addMessage(message)){
			s.put("state", "success");
		}
		else{
			s.put("state","false");
		}
		return s;
	}
	@RequestMapping(value = "/getReceivedMessage",method=RequestMethod.POST)
	@ResponseBody
	public HashMap<String, Object> getReceivedMessage(HttpServletResponse response,HttpServletRequest request) throws ClientException, IOException{
		response.addHeader("Access-Control-Allow-Origin", "*");
		String publish_user_phone = (String) request.getSession().getAttribute("u_phone");
		ArrayList<MessageModel> message = new ArrayList<MessageModel>();
		HashMap<String, Object> s = new HashMap<String, Object>();
		if((message = messageServices.getReceivedMessage(publish_user_phone))!=null){
			if(!message.isEmpty()){
				s.put("message", message);
				s.put("state", "success");
			}
			else{
				s.put("state", "false");
			}
		}
		else{
			s.put("state","false");
		}
		return s;
	}
	
	@RequestMapping(value = "/getPublishMessage",method=RequestMethod.POST)
	@ResponseBody
	public HashMap<String, Object> getPublishMessage(HttpServletResponse response,HttpServletRequest request) throws ClientException, IOException{
		response.addHeader("Access-Control-Allow-Origin", "*");
		String u_phone = (String) request.getSession().getAttribute("u_phone");
		ArrayList<MessageModel> message = new ArrayList<MessageModel>();
		HashMap<String, Object> s = new HashMap<String, Object>();
		if((message = messageServices.getPublishMessage(u_phone))!=null){
			if(!message.isEmpty()){
				s.put("message", message);
				s.put("state", "success");
			}
			else{
				s.put("state", "false");
			}
		}
		else{
			s.put("state","false");
		}
		return s;
	}
}

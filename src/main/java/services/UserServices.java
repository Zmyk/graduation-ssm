/**
 * 
 */
package services;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import beans.Good;
import beans.Message;
import beans.User;
import mapper.UserMapper;
import utils.CommonUtil;

/**
 * @author zhang
 *
 */
@Service
public class UserServices {

	@Autowired
	UserMapper usermapper;
	
	public boolean isLogin(User login_user) {
		if(usermapper.findByPhoneAndPassword(login_user.getU_phone(),login_user.getU_password())!=null)
		{
			return true;
		}
		return false;
	}
	
	public String getU_name(String u_phone){
		return usermapper.findByPhone(u_phone).getU_name();
	}
	
	public boolean isRegister(String registerPhone,String phoneNumber,String checkCode,String sessionCheckCode,User user){
		return CheckCodeServices.isComparedCorrect(registerPhone,phoneNumber) && usermapper.findByPhone(phoneNumber)==null && CheckCodeServices.isComparedCorrect(checkCode, sessionCheckCode) && usermapper.save(user) == 1;
	}

	
	public boolean isresetPassword(String registerPhone, String phoneNumber, String checkCode, String sessionCheckCode, User user) {	
		return CheckCodeServices.isComparedCorrect(registerPhone,phoneNumber) && usermapper.findByPhone(phoneNumber)!=null && CheckCodeServices.isComparedCorrect(checkCode, sessionCheckCode) && usermapper.resetPassword(user) == 1;
	}


	
	
	

}

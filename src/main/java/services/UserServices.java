/**
 * 
 */
package services;


import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
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
		return CommonUtil.isComparedCorrect(registerPhone,phoneNumber) && usermapper.findByPhone(phoneNumber)==null && CommonUtil.isComparedCorrect(checkCode, sessionCheckCode) && usermapper.save(user) == 1;
	}

	
	public boolean isresetPassword(String registerPhone, String phoneNumber, String checkCode, String sessionCheckCode, User user) {	
		return CommonUtil.isComparedCorrect(registerPhone,phoneNumber) && usermapper.findByPhone(phoneNumber)!=null && CommonUtil.isComparedCorrect(checkCode, sessionCheckCode) && usermapper.resetPassword(user) == 1;
	}
	public ArrayList<User> getUser() {
		return usermapper.getUser();
	}
	public boolean isClosure(String u_phone) {
		return usermapper.isClosure(u_phone) == 1;
	}
	public ArrayList<User> getClosureUser() {
		return usermapper.getClosureUser();
	}
	public boolean delClosureUser(String u_phone) {
		return usermapper.isDelClosureUser(u_phone) == 1;
	}


	
	
	

}

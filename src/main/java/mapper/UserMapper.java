package mapper;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import beans.Message;
import beans.User;
@Component
public interface UserMapper {
	int save(User user);
	User findByPhone(@Param("u_phone")String u_phone);
	User findByPhoneAndPassword(@Param("u_phone")String u_phone,@Param("u_password")String u_password);
	List<User> findAll();
	int resetPassword(User user);
	ArrayList<User> getUser();
	int isClosure(@Param("u_phone")String u_phone);
	ArrayList<User> getClosureUser();
	int isDelClosureUser(@Param("u_phone")String u_phone);
}

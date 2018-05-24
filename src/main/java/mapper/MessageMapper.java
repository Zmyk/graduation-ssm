/**
 * 
 */
package mapper;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import beans.Message;
import model.MessageModel;

/**
 * @author zhang
 *
 */
@Component
public interface MessageMapper {
	int addMessage(Message message);
	ArrayList<MessageModel> getReceivedMessage(@Param("publish_user_phone")String publish_user_phone);
	ArrayList<MessageModel> getPublishMessage(@Param("u_phone")String u_phone);
}

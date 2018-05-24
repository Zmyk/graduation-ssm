/**
 * 
 */
package services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import beans.Message;
import mapper.MessageMapper;
import model.MessageModel;

/**
 * @author zhang
 *
 */
@Service
public class MessageServices {
	
	@Autowired
	MessageMapper messagemapper;
	
	public boolean addMessage(Message message) {
		return messagemapper.addMessage(message)==1;
	}
	
	public ArrayList<MessageModel> getReceivedMessage(String publish_user_phone) {
		return messagemapper.getReceivedMessage(publish_user_phone);
	}

	public ArrayList<MessageModel> getPublishMessage(String u_phone) {
		return messagemapper.getPublishMessage(u_phone);
	}
}

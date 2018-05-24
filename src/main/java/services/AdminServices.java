/**
 * 
 */
package services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import beans.Admin;
import mapper.AdminMapper;

/**
 * @author zhang
 *
 */
@Service
public class AdminServices {
	@Autowired
	AdminMapper adminmapper;

	/**
	 * @param admin
	 * @return
	 */
	public boolean isLogin(Admin admin) {
		if(adminmapper.findByNameAndPassword(admin.getAdmin_name(),admin.getAdmin_password())!=null)
		{
			return true;
		}
		return false;
	}

}

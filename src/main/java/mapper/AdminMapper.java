/**
 * 
 */
package mapper;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import beans.Admin;

/**
 * @author zhang
 *
 */
@Component
public interface AdminMapper {

	/**
	 * @param admin
	 * @return
	 */
	Admin findByNameAndPassword(@Param("admin_name")String name,@Param("admin_password")String password);

}

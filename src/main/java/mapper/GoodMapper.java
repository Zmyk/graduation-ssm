/**
 * 
 */
package mapper;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import beans.Favorate;
import beans.Good;
import beans.GoodType;
import model.AuditGoodModel;
import model.FavorateView;
import model.GoodDetail;
import model.HomePageModel;
import model.MyPublishModel;

/**
 * @author zhang
 *
 */
@Component
public interface GoodMapper {
	int save(Good good);
	int saveImageUrl(@Param("id")String id,@Param("url")String url);
	ArrayList<HomePageModel> getInSoldGood();
	ArrayList<GoodType> getGoodType();
	ArrayList<HomePageModel> getSearchGoodByName(@Param("str")String str);
	ArrayList<HomePageModel> getSearchGoodByType(@Param("type_id")int type_id);
	GoodDetail getGoodDetailWithoutUrl(@Param("good_id")String good_id);
	ArrayList<String> getGoodDetailUrl(@Param("good_id")String good_id);
	int AddFavorate(@Param("good_id")String good_id,@Param("u_phone")String u_phone,@Param("date")String date,@Param("favorateid")String favorateid);
	Favorate getFavorateByGoodIdAndUphone(@Param("good_id")String good_id, @Param("u_phone")String u_phone);
	ArrayList<FavorateView> getFavorateByUphone(@Param("u_phone")String u_phone);
	int DeleteFavorate(@Param("favorateid")String favorateid);
	ArrayList<MyPublishModel> getPublishByUphone(@Param("u_phone")String u_phone);
	int DeletePublish(@Param("good_id")String good_id);
	ArrayList<AuditGoodModel> getAuditGood();
	int isAccept(@Param("good_id")String good_id);
	int isRefuse(@Param("good_id")String good_id);

}

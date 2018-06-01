/**
 * 
 */
package services;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import beans.Admin;
import beans.Favorate;
import beans.Good;
import beans.GoodType;
import mapper.GoodMapper;
import model.AuditGoodModel;
import model.FavorateView;
import model.GoodDetail;
import model.HomePageModel;
import model.MyPublishModel;

/**
 * @author zhang
 *
 */
@Service
public class GoodServices {
	@Autowired
	GoodMapper goodmapper;
	
	public boolean uploadPicture(MultipartFile[] file, String path, String good_id) {
		File targetFile = null;
		boolean state = false;
		for (MultipartFile multipartFile : file) {
			String fileName = multipartFile.getOriginalFilename();// 获取文件名加后缀
			if (fileName != null && fileName != "") {
				String fileF = fileName.substring(fileName.lastIndexOf("."), fileName.length());// 文件后缀
				fileName = new Date().getTime() + "_" + new Random().nextInt(1000) + fileF;// 新的文件名
				SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd");// 设置日期格式
				String fileAdd = df.format(new Date()).toString();
				// 先判断文件是否存在
				File file1 = new File(path + "/" + fileAdd);
				// 如果文件夹不存在则创建
				if (!file1.exists() && !file1.isDirectory()) {
					file1.mkdir();
				}
				targetFile = new File(file1, fileName);
				try {
					System.out.println(targetFile);
					goodmapper.saveImageUrl(good_id, fileAdd+"/"+fileName);
					multipartFile.transferTo(targetFile);
					state = true;
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		return state;
	}
	
	public boolean savePublishGood(Good good) {
		return goodmapper.save(good)==1;
	}


	public ArrayList<HomePageModel> getInSoldGood() {
		return goodmapper.getInSoldGood();
		
	}


	public ArrayList<GoodType> getGoodType() {
		
		return goodmapper.getGoodType();
	}

	public ArrayList<HomePageModel> getSearchGoodByName(String str) {
		return goodmapper.getSearchGoodByName(str);
	}

	public ArrayList<HomePageModel> getSearchGoodByType(int type_id) {
		return goodmapper.getSearchGoodByType(type_id);
	}
	public GoodDetail getGoodDetail(String good_id) {
		GoodDetail goodDetail = new GoodDetail();
		goodDetail = goodmapper.getGoodDetailWithoutUrl(good_id);
		goodDetail.setUrl(goodmapper.getGoodDetailUrl(good_id));
		return goodDetail;
	}

	public boolean isAddFavorate(String good_id,String u_phone,String date,String favorateid) {
		return goodmapper.AddFavorate(good_id,u_phone,date,favorateid)==1;
	}

	public boolean getFavorateByGoodIdAndUphone(String good_id, String u_phone) {
		return goodmapper.getFavorateByGoodIdAndUphone(good_id,u_phone)!=null;
	}

	public ArrayList<FavorateView> getFavorateByUphone(String u_phone) {

		return goodmapper.getFavorateByUphone(u_phone);
	}
	public boolean isdeleteFavorate(String favorateid) {
		return goodmapper.DeleteFavorate(favorateid)==1;
	}
	public ArrayList<MyPublishModel> getPublishByUphone(String u_phone) {
		return goodmapper.getPublishByUphone(u_phone);
	}
	public boolean isdeletePublish(String good_id) {
		return goodmapper.DeletePublish(good_id)==1;
	}
	public ArrayList<AuditGoodModel> getAuditGood() {
		return goodmapper.getAuditGood();
	}
	public boolean isAccept(String good_id) {
		return goodmapper.isAccept(good_id)==1;
	}
	public boolean isRefuse(String good_id) {
		return goodmapper.isRefuse(good_id)==1;
	}
	public boolean isClosure(String u_phone) {
		return goodmapper.isClosure(u_phone) != 0;
	}
	public boolean delClosure(String u_phone) {
		return goodmapper.isDelClosure(u_phone) != 0;
	}


}

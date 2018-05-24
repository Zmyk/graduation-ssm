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
import org.springframework.web.multipart.MultipartFile;

import com.aliyuncs.exceptions.ClientException;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import beans.Favorate;
import beans.Good;
import beans.GoodType;
import model.AuditGoodModel;
import model.FavorateView;
import model.GoodDetail;
import model.HomePageModel;
import model.MyPublishModel;
import services.GoodServices;
import utils.CommonUtil;

/**
 * @author zhang
 *
 */
@Controller
@RequestMapping(value = "/good")
public class GoodController {
	
	@Autowired
	GoodServices goodServices;
	
	@RequestMapping(value = "/publish",method=RequestMethod.POST)
	@ResponseBody
	public HashMap<String, String> publish(@RequestParam(value="file",required=false) MultipartFile[] file,@RequestParam(value="good_name",required=false) String good_name,@RequestParam(value="good_desc",required=false) String good_desc,@RequestParam(value="price",required=false) int price,@RequestParam(value="origin_price",required=false) int origin_price,@RequestParam(value="good_type",required=false) int good_type_id,@RequestParam(value="addr",required=false) String addr,@RequestParam(value="phone",required=false) String contact_phone,@RequestParam(value="qq",required=false) String qq,HttpServletResponse response,HttpServletRequest request) throws ClientException, IOException{
		response.addHeader("Access-Control-Allow-Origin", "*");
		String good_id = CommonUtil.getUniqueSign();
		String publish_user_phone = (String) request.getSession().getAttribute("u_phone");
		String date = CommonUtil.getDate();
		System.out.println(good_type_id);
		Good good = new Good(good_id, publish_user_phone, contact_phone, good_name, good_desc, price, origin_price, good_type_id, addr, date, qq);	
		String path = "E:/image";
		HashMap<String, String> s = new HashMap<String, String>(); 
		if(goodServices.uploadPicture(file, path,good_id) && goodServices.savePublishGood(good)){
			s.put("state", "success");
		}
		else{
			s.put("state","false");
		}
		return s;
	}
	
	@RequestMapping(value = "/getInSoldGood",method=RequestMethod.POST)
	@ResponseBody
	public HashMap<String, Object> getInSoldGood(@RequestParam(value="pn",required=false) int pn,HttpServletResponse response,HttpServletRequest request) throws ClientException, IOException{
		response.addHeader("Access-Control-Allow-Origin", "*");
		PageHelper.startPage(pn,12);	    
		ArrayList<HomePageModel> inSoldGoodList;
		HashMap<String, Object> s = new HashMap<String, Object>(); 
		if((inSoldGoodList = goodServices.getInSoldGood())!=null){// && !goodServices.getInSoldGood().isEmpty()
			if(!inSoldGoodList.isEmpty()){
				PageInfo<HomePageModel> pageInfo = new PageInfo<HomePageModel>(inSoldGoodList,5);  
				s.put("state", "success");
				s.put("inSoldGood", pageInfo);
			}
			else{
				s.put("state","false");
			}
		}
		else{
			s.put("state","false");
		}
		return s;
	}
	
	@RequestMapping(value = "/getGoodType",method=RequestMethod.POST)
	@ResponseBody
	public HashMap<String, Object> getGoodType(HttpServletResponse response,HttpServletRequest request) throws ClientException, IOException{
		response.addHeader("Access-Control-Allow-Origin", "*");
		ArrayList<GoodType> goodTypeList;
		HashMap<String, Object> s = new HashMap<String, Object>(); 
		if((goodTypeList=goodServices.getGoodType())!=null){
			s.put("state", "success");
			s.put("goodTypeList", goodTypeList);
		}
		else{
			s.put("state","false");
		}
		return s;
	}
	
	@RequestMapping(value = "/getSearchGoodByName",method=RequestMethod.POST)
	@ResponseBody
	public HashMap<String, Object> getSearchGoodByName(@RequestParam(value="pn",required=false) int pn,@RequestParam(value="str",required=false) String str,HttpServletResponse response,HttpServletRequest request) throws ClientException, IOException{
		response.addHeader("Access-Control-Allow-Origin", "*");
		PageHelper.startPage(pn,15);
		ArrayList<HomePageModel> searchGoodList;
		HashMap<String, Object> s = new HashMap<String, Object>(); 
		if((searchGoodList = goodServices.getSearchGoodByName(str))!=null){
			if(!searchGoodList.isEmpty()){
				PageInfo<HomePageModel> pageInfo = new PageInfo<HomePageModel>(searchGoodList,5);
				s.put("state", "success");
				s.put("searchGoodList", pageInfo);
			}
			else{
				s.put("state","false");
			}
		}
		else{
			s.put("state","false");
		}
		return s;
	}
	
	@RequestMapping(value = "/getSearchGoodByType",method=RequestMethod.POST)
	@ResponseBody
	public HashMap<String, Object> getSearchGoodByType(@RequestParam(value="pn",required=false) int pn,@RequestParam(value="type_id",required=false) int type_id,HttpServletResponse response,HttpServletRequest request) throws ClientException, IOException{
		response.addHeader("Access-Control-Allow-Origin", "*");
		PageHelper.startPage(pn,15);
		ArrayList<HomePageModel> searchGoodList;
		HashMap<String, Object> s = new HashMap<String, Object>(); 
		if((searchGoodList = goodServices.getSearchGoodByType(type_id))!=null){
			if(!searchGoodList.isEmpty()){
				PageInfo<HomePageModel> pageInfo = new PageInfo<HomePageModel>(searchGoodList,5);
				s.put("state", "success");
				s.put("searchGoodList", pageInfo);
			}
			else{
				s.put("state","false");
			}
		}
		else{
			s.put("state","false");
		}
		return s;
	}
	@RequestMapping(value = "/getGoodDetail",method=RequestMethod.POST)
	@ResponseBody
	public HashMap<String, Object> getGoodDetail(@RequestParam(value="good_id",required=false) String good_id,HttpServletResponse response,HttpServletRequest request) throws ClientException, IOException{
		response.addHeader("Access-Control-Allow-Origin", "*");
		GoodDetail goodDetail;
		HashMap<String, Object> s = new HashMap<String, Object>(); 
		if((goodDetail = goodServices.getGoodDetail(good_id))!=null){
			s.put("state", "success");
			s.put("goodDetail", goodDetail);	
		}
		else{
			s.put("state","false");
		}
		return s;
	}
	@RequestMapping(value = "/addFavorate",method=RequestMethod.POST)
	@ResponseBody
	public HashMap<String, Object> addFavorate(@RequestParam(value="good_id",required=false) String good_id,HttpServletResponse response,HttpServletRequest request) throws ClientException, IOException{
		response.addHeader("Access-Control-Allow-Origin", "*");
		HashMap<String, Object> s = new HashMap<String, Object>(); 
		String u_phone = (String) request.getSession().getAttribute("u_phone");
		String date = CommonUtil.getDate();
		String favorateid = u_phone+good_id;
		if(goodServices.isAddFavorate(good_id,u_phone,date,favorateid)){
			s.put("state", "success");	
		}
		else{
			s.put("state","false");
		}
		return s;
	}
	@RequestMapping(value = "/getFavorateByGoodIdAndUphone",method=RequestMethod.POST)
	@ResponseBody
	public HashMap<String, Object> getFavorateByGoodIdAndUphone(@RequestParam(value="good_id",required=false) String good_id,HttpServletResponse response,HttpServletRequest request) throws ClientException, IOException{
		response.addHeader("Access-Control-Allow-Origin", "*");
		HashMap<String, Object> s = new HashMap<String, Object>(); 
		String u_phone = (String) request.getSession().getAttribute("u_phone");
		if(goodServices.getFavorateByGoodIdAndUphone(good_id,u_phone)){
			s.put("state", "success");
		}
		else{
			s.put("state","false");
		}
		return s;
	}
	@RequestMapping(value = "/getFavorateByUphone",method=RequestMethod.POST)
	@ResponseBody
	public HashMap<String, Object> getFavorateByUphone(HttpServletResponse response,HttpServletRequest request) throws ClientException, IOException{
		response.addHeader("Access-Control-Allow-Origin", "*");
		HashMap<String, Object> s = new HashMap<String, Object>(); 
		String u_phone = (String) request.getSession().getAttribute("u_phone");
//		String u_phone = "18362081186";
		ArrayList<FavorateView> favorate = new ArrayList<FavorateView>();
		if((favorate=goodServices.getFavorateByUphone(u_phone))!=null){
			if(!favorate.isEmpty()){
				s.put("favorate", favorate);
				s.put("state", "success");
			}
			else{
				s.put("state","false");
			}
		}
		else{
			s.put("state","false");
		}
		return s;
	}
	@RequestMapping(value = "/deleteFavorate",method=RequestMethod.POST)
	@ResponseBody
	public HashMap<String, Object> deleteFavorate(@RequestParam(value="good_id",required=false) String good_id,HttpServletResponse response,HttpServletRequest request) throws ClientException, IOException{
		response.addHeader("Access-Control-Allow-Origin", "*");
		HashMap<String, Object> s = new HashMap<String, Object>(); 
		String u_phone = (String) request.getSession().getAttribute("u_phone");
		String favorateid = u_phone+good_id;
		if(goodServices.isdeleteFavorate(favorateid)){
			s.put("state", "success");
		}
		else{
			s.put("state","false");
		}
		return s;
	}
	@RequestMapping(value = "/getPublishByUphone",method=RequestMethod.POST)
	@ResponseBody
	public HashMap<String, Object> getPublishByUphone(HttpServletResponse response,HttpServletRequest request) throws ClientException, IOException{
		response.addHeader("Access-Control-Allow-Origin", "*");
		HashMap<String, Object> s = new HashMap<String, Object>(); 
		String u_phone = (String) request.getSession().getAttribute("u_phone");
		ArrayList<MyPublishModel> publish = new ArrayList<MyPublishModel>();
		if((publish=goodServices.getPublishByUphone(u_phone))!=null){
			if(!publish.isEmpty()){
				s.put("state", "success");
				s.put("publish", publish);
			}
			
		}
		else{
			s.put("state","false");
		}
		return s;
	}
	@RequestMapping(value = "/deletePublish",method=RequestMethod.POST)
	@ResponseBody
	public HashMap<String, Object> deletePublish(@RequestParam(value="good_id",required=false) String good_id,HttpServletResponse response,HttpServletRequest request) throws ClientException, IOException{
		response.addHeader("Access-Control-Allow-Origin", "*");
		HashMap<String, Object> s = new HashMap<String, Object>(); 
		if(goodServices.isdeletePublish(good_id)){
			s.put("state", "success");
		}
		else{
			s.put("state","false");
		}
		return s;
	}
	@RequestMapping(value = "/getAuditGood",method=RequestMethod.POST)
	@ResponseBody
	public HashMap<String, Object> getAuditGood(HttpServletResponse response,HttpServletRequest request) throws ClientException, IOException{
		response.addHeader("Access-Control-Allow-Origin", "*");
		ArrayList<AuditGoodModel> auditgood = new ArrayList<AuditGoodModel>();
		HashMap<String, Object> s = new HashMap<String, Object>(); 
		if((auditgood=goodServices.getAuditGood())!=null){
			if(!auditgood.isEmpty()){
				s.put("auditgood", auditgood);
				s.put("state", "success");
			}
			else{
				s.put("state","false");
			}
		}
		else{
			s.put("state","false");
		}
		return s;
	}
	
	@RequestMapping(value = "/isAccept",method=RequestMethod.POST)
	@ResponseBody
	public HashMap<String, Object> isAccept(@RequestParam(value="good_id",required=false) String good_id,HttpServletResponse response,HttpServletRequest request) throws ClientException, IOException{
		response.addHeader("Access-Control-Allow-Origin", "*");
		HashMap<String, Object> s = new HashMap<String, Object>(); 
		if(goodServices.isAccept(good_id)){
			s.put("state", "success");
		}
		else{
			s.put("state","false");
		}
		return s;
	}
	@RequestMapping(value = "/isRefuse",method=RequestMethod.POST)
	@ResponseBody
	public HashMap<String, Object> isRefuse(@RequestParam(value="good_id",required=false) String good_id,HttpServletResponse response,HttpServletRequest request) throws ClientException, IOException{
		response.addHeader("Access-Control-Allow-Origin", "*");
		HashMap<String, Object> s = new HashMap<String, Object>(); 
		if(goodServices.isRefuse(good_id)){
			s.put("state", "success");
		}
		else{
			s.put("state","false");
		}
		return s;
	}
	
}

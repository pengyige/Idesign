package top.yigege.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import top.yigege.domain.Works;
import top.yigege.json.result.GlobalState;
import top.yigege.json.result.StateResult;
import top.yigege.service.WorksService;
@Controller
@RequestMapping("/Works")
public class WorksController {
	
	@Resource
	private WorksService worksService;
	public void setWorksService(WorksService worksService) {
		this.worksService = worksService;
	}

	/**
	 * 添加作品
	 * @param works
	 * @return
	 */
	@RequestMapping(value="/addWorks",method=RequestMethod.POST)
	public @ResponseBody StateResult addWorks(Works works) {
		StateResult stateResult = new StateResult();
		try {
			works.setTime(new Date());
			worksService.addWorks(works);
			stateResult.setCode(GlobalState.SUCCESS);
			stateResult.setMessage("添加成功");
			
		}catch(Exception e) {
			e.printStackTrace();
			stateResult.setCode(GlobalState.ERROR);
			stateResult.setMessage("发生异常");
	
		}

		return stateResult;
	}
	
	
	
	/**
	 * 返回所有作品
	 * @param works
	 * @return
	 */
	@RequestMapping(value="/getAllWorks",method=RequestMethod.POST)
	public @ResponseBody Object getAllWorks(){
		Map<String,Object> jsonResult = new HashMap<String, Object>();
		StateResult stateResult = new StateResult();
		try {
			List<Works> listWorks = worksService.getAllWoks();
			
			return listWorks;
		}catch(Exception e) {
			stateResult.setCode(GlobalState.ERROR);
			stateResult.setMessage("发生异常");
			return stateResult;
		}
		
	}
	
	/**
	 * 返回查询到的所有作品
	 * @param works
	 * @return
	 */
	@RequestMapping(value="/getFindWokrs",method=RequestMethod.POST)
	public @ResponseBody Object getFindWokrs(String remark) {
		Map<String,Object> jsonResult = new HashMap<String, Object>();
		StateResult stateResult = new StateResult();
		try {
			List<Works> listWorks = worksService.getFindWoksByRemark(remark);
			
			return listWorks;
		}catch(Exception e) {
			stateResult.setCode(GlobalState.ERROR);
			stateResult.setMessage("发生异常");
			return stateResult;
		}
	}
	
	/**
	 * 通过姓名返回该用户所有作品
	 * @param name
	 * @return
	 */
	@RequestMapping(value="/getWorksByName",method=RequestMethod.POST)
	public @ResponseBody Map<String,Object> getWorksByName(String name){
		Map<String,Object> jsonMap = new HashMap<String,Object>();
		StateResult stateResult = new StateResult();
		jsonMap.put("stateResult",stateResult );
		try {
			List<Works> listWorks = worksService.getWorksByName(name);
			stateResult.setCode(GlobalState.SUCCESS);
			stateResult.setMessage("添加成功!");
			jsonMap.put("allworks", listWorks);
			return jsonMap;
		}catch(Exception e) {
			stateResult.setCode(GlobalState.ERROR);
			stateResult.setMessage("发生异常");
			return jsonMap;
		}
	}
	
	
	/**
	 * 上传作品图片(通过imagepath字段保存作品本人头像和作品图片)
	 * @throws IOException 
	 * @throws IllegalStateException 
	 */
	@RequestMapping(value="/worksFileUpload",method=RequestMethod.POST)
	public @ResponseBody Map<String,Object> worksFileUpload(HttpServletRequest request) throws IllegalStateException, IOException{
		Map<String,Object> jsonMap = new HashMap<String,Object>();
		StringBuilder imagepaths = new StringBuilder();
        //获取项目路径
     /*   String basePath =  request.getSession().getServletContext().getRealPath("");*/
        
        //将当前上下文初始化给  CommonsMutipartResolver （多部分解析器）
       CommonsMultipartResolver multipartResolver=new CommonsMultipartResolver(
               request.getSession().getServletContext());
       //检查form中是否有enctype="multipart/form-data"
       
       if(multipartResolver.isMultipart(request))
       {
           //将request变成多部分request
           MultipartHttpServletRequest multiRequest=(MultipartHttpServletRequest)request;
          //获取multiRequest 中所有的文件名
           Iterator iter=multiRequest.getFileNames();
            
           while(iter.hasNext())
           {
               //一次遍历所有文件
               MultipartFile file=multiRequest.getFile(iter.next().toString());
               if(!file.isEmpty())
               {
            	   String filename = String.valueOf(new Date().getTime())+file.getOriginalFilename();
                   String path="/usr/local/tomcat8.5/apache-tomcat-8.5.30/upload/"+filename;
                   //上传
                   File createfile = new File(path);
                   if(createfile.exists()) {
                	   createfile.delete();
                   }
                   file.transferTo(createfile);
                   imagepaths.append(filename+";");
               }
                
           }
          
       }
  
       //去掉最后一个分号
       String result = imagepaths.substring(0, imagepaths.length()-1);
		jsonMap.put("result", result);
		return jsonMap;
	}

	
	
	/**
	 * 通过Id获取作品
	 * @param worksId
	 * @return
	 */
	@RequestMapping(value="/getWorksByWorksId",method=RequestMethod.POST)
	public @ResponseBody Works getWorksByWorksId(String worksId) {
		Works works = null ;
		works = worksService.getWorksByWorksId(worksId);
		return works;
	}
	
	
	
	/**
	 * 通过Id为作品点赞
	 * @param worksId
	 * @return
	 */
	@RequestMapping(value="/starWorksByWorksId",method=RequestMethod.POST)
	public @ResponseBody StateResult starWorksByWorksId(String worksId) {
		StateResult stateResult = new StateResult();
		try {
			
			worksService.starWorks(worksId);
			stateResult.setCode(GlobalState.SUCCESS);
			return stateResult;
		}catch(Exception e) {
			stateResult.setCode(GlobalState.ERROR);
			stateResult.setMessage("发生异常");
			return stateResult;
		}
		
	}
	
}

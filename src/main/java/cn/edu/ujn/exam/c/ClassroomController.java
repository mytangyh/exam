package cn.edu.ujn.exam.c;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import cn.edu.ujn.exam.dao.Classroom;
import cn.edu.ujn.exam.page.Page;
import cn.edu.ujn.exam.service.IClassroomService;


@Controller
@RequestMapping(value = "/classroom")
public class ClassroomController {
	
	@Autowired
	private IClassroomService classroomService;
	@RequestMapping(value = "/show",method = RequestMethod.GET)
	public ModelAndView show(ModelAndView mav) {
		mav.setViewName("classroom");
		return mav;
		
	}
	
	@RequestMapping(value = "/get_list",method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> getList(
			@RequestParam(value = "roomname",required = false,defaultValue = "") String roomname,
			Page page1) {
		Map<String, Object> ret=new HashMap<String, Object>();
		Map<String, Object> queryMap=new HashMap<String, Object>();
		queryMap.put("roomname", "%"+roomname+"%");
		queryMap.put("offset", page1.getOffset());
		queryMap.put("pageSize", page1.getRows());
		ret.put("rows", classroomService.findByName(queryMap));
		ret.put("total", classroomService.getTotal(queryMap));
		return ret;
		
	}
	@RequestMapping(value = "/add",method = RequestMethod.POST)
	@ResponseBody
	public Map<String, String> add(Classroom classroom) {
		Map<String, String> ret=new HashMap<String, String>();
		if (classroom==null) {
			ret.put("type", "error");
			ret.put("msg", "数据绑定出错，请联系开发人员！");
			return ret;
		}
		
		if (classroomService.insert(classroom)<=0) {
			ret.put("type", "error");
			ret.put("msg", "添加失败");
			return ret;
		}
		ret.put("type", "success");
		ret.put("msg", "添加成功");
		
		return ret;
		
	}
	@RequestMapping(value = "/edit",method = RequestMethod.POST)
	@ResponseBody
	public Map<String, String> edit(Classroom classroom) {
		Map<String, String> ret=new HashMap<String, String>();
		if (classroom==null) {
			ret.put("type", "error");
			ret.put("msg", "数据绑定出错，请联系开发人员！");
			return ret;
		}
		
		if (classroomService.edit(classroom)<=0) {
			ret.put("type", "error");
			ret.put("msg", "修改失败");
			return ret;
		}
		ret.put("type", "success");
		ret.put("msg", "修改成功");
		
		return ret;
		
	}
	@RequestMapping(value = "/delete",method = RequestMethod.POST)
	@ResponseBody
	public Map<String, String> delete(
			@RequestParam(value = "ids[]",required = true) Long[] ids) {
		Map<String, String> ret=new HashMap<String, String>();
		
		if (ids ==null) {
			ret.put("type", "error");
			ret.put("msg", "请选择要删除的数据！");
			return ret;
		}
		if (classroomService.delete(ids)<=0) {
			ret.put("type", "error");
			ret.put("msg", "删除失败");
			return ret;
		}
		ret.put("type", "success");
		ret.put("msg", "删除成功");
		return ret;
		
	}
}

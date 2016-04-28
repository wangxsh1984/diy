package org.controller.demo;

import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.model.demo.DemoModel;
import org.service.demo.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/demo")
public class DemoController {
	Logger log = Logger.getLogger(this.getClass().getName());
	@Autowired
	private DemoService demoService;

	@RequestMapping("/goDemo")
	public String goDemo(Map<String, List<DemoModel>> map) {
		log.info("--------------------goDemo----------------------");
		List<DemoModel> demoList = demoService.searchByQBC();// .searchDemo();
		map.put("demoList", demoList);
		return "demo/demo";
	}

	@ResponseBody
	@RequestMapping(value = "/goAjax", method = RequestMethod.POST)
	public String goAjax(@RequestBody String map) {
		log.info("--------------------goAjax----------------------");
		log.info((String) map);
		return "{\"success\":\"aaa成功\"}";
	}

}

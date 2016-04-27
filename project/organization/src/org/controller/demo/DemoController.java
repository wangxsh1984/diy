package org.controller.demo;

import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import org.model.demo.DemoModel;
import org.service.demo.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/demo")
public class DemoController {
	Logger log = Logger.getLogger(this.getClass().getName());
	@Autowired
	private DemoService demoService;

	@RequestMapping("/goDemo")
	public String goDemo(Map map) {
		log.info("--------------------goDemo----------------------");
		List<DemoModel> demoList = demoService.searchDemo();
		map.put("demoList", demoList);
		return "demo/demo";
	}
}

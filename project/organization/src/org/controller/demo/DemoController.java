package org.controller.demo;

import java.util.logging.Logger;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/demo")
public class DemoController {
	Logger log = Logger.getLogger(this.getClass().getName());

	@RequestMapping("/goDemo")
	public String goDemo() {
		log.info("--------------------goDemo----------------------");
		return "demo/demo";
	}
}

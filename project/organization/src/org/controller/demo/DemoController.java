package org.controller.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/demo")
public class DemoController {
	@RequestMapping("/goDemo")
	public String goDemo() {
		return "demo/demo";
	}
}

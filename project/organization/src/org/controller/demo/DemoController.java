package org.controller.demo;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import org.model.demo.DemoModel;
import org.service.demo.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

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

	@ResponseBody
	@RequestMapping("/fileUpload")
	public String fileUpload(MultipartFile file) {
		File newFile = new File("D://upfile.png");
		try {
			InputStream is = file.getInputStream();
			byte[] b = new byte[(int) file.getSize()];
			int read = 0;
			int i = 0;
			while ((read = is.read()) != -1) {
				b[i] = (byte) read;
				i++;
			}
			OutputStream os = new FileOutputStream(newFile);
			os.write(b);
			os.flush();
			os.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "{\"success\":\"aaa成功\"}";
	}

}

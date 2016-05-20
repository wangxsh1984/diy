package org.controller.organization;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.model.organization.OrgModel;
import org.service.organization.OrgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/org")
public class OrgController {
	@Autowired
	private OrgService orgService;

	@RequestMapping("/getOrgs")
	public ModelAndView getOrgs(String parentId) {
		List<OrgModel> orgList = orgService.orgList(parentId);
		Map<String, List<OrgModel>> reslutMap = new HashMap<String, List<OrgModel>>();
		reslutMap.put("orgList", orgList);
		return new ModelAndView("organization/orgList", reslutMap);
	}

	@RequestMapping("/preAddOrg")
	public ModelAndView preAddOrg(@RequestParam("parentId") String parentId) {
		Map<String, String> reslutMap = new HashMap<String, String>();
		reslutMap.put("parentId", parentId);
		return new ModelAndView("organization/orgAdd", reslutMap);
	}

	@RequestMapping("/addOrg")
	public String addOrg(OrgModel org) {
		orgService.addOrg(org);
		return "organization/orgList";
	}
}

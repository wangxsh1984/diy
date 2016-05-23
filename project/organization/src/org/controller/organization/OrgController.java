package org.controller.organization;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.model.organization.OrgModel;
import org.service.organization.OrgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/org")
public class OrgController {
	@Autowired
	private OrgService orgService;

	@RequestMapping("/showOrgTree")
	public String showOrgTree() {
		return "organization/orgTree";
	}

	@ResponseBody
	@RequestMapping(value = "/getOrgs", method = RequestMethod.POST)
	public String getOrgs(@RequestParam("parentId") String parentId) {
		List<OrgModel> orgList = orgService.orgList(parentId);
		String result = "{\"orgList\":[";
		for (OrgModel org : orgList) {
			result = result + "{\"orgName\":\"" + org.getOrgName()
					+ "\",\"orgId\":\"" + org.getId() + "\"},";
		}
		result = result.substring(0, result.length() - 1);
		result = result + "]}";
		return result;
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

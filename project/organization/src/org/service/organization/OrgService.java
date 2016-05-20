package org.service.organization;

import java.util.List;

import org.model.organization.OrgModel;

public interface OrgService {
	public List<OrgModel> orgList(String parentId);

	public String addOrg(OrgModel org);
}

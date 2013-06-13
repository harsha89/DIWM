/**
 * The contents of this file are subject to the OpenMRS Public License
 * Version 1.0 (the "License"); you may not use this file except in
 * compliance with the License. You may obtain a copy of the License at
 * http://license.openmrs.org
 *
 * Software distributed under the License is distributed on an "AS IS"
 * basis, WITHOUT WARRANTY OF ANY KIND, either express or implied. See the
 * License for the specific language governing rights and limitations
 * under the License.
 *
 * Copyright (C) OpenMRS, LLC.  All Rights Reserved.
 */

package org.openmrs.module.dataintegrityworkflow.web.controller;

import au.com.bytecode.opencsv.CSVWriter;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openmrs.api.context.Context;
import org.openmrs.messagesource.MessageSourceService;
import org.openmrs.module.dataintegrity.*;
import org.openmrs.util.OpenmrsUtil;
import org.openmrs.web.WebConstants;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.WebRequest;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
public class IntegrityCheckController {
	private static final String EDIT_VIEW = "/module/dataintegrity/editCheck";
	private static final String VIEW_VIEW = "/module/dataintegrity/viewCheck";
	private static final String LIST_VIEW = "/module/dataintegrity/listChecks";
	private static final String SUCCESS_VIEW = "redirect:list.htm";
	
	private final Log log = LogFactory.getLog(this.getClass());
	
	private DataIntegrityService getDataIntegrityService() {
        return (DataIntegrityService)Context.getService(DataIntegrityService.class);
    }

	@RequestMapping(value="/module/dataintegrity/view.htm")
	public String viewCheck(@RequestParam(value="checkId", required=true) Integer checkId, ModelMap modelMap) {
		DataIntegrityService service = Context.getService(DataIntegrityService.class);
		modelMap.put("check", service.getIntegrityCheck(checkId));
		return VIEW_VIEW;
	}
}

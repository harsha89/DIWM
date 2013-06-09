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
package org.openmrs.module.dataintegrityworkflow.impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openmrs.api.context.Context;
import org.openmrs.module.dataintegrity.DataIntegrityService;
import org.openmrs.module.dataintegrity.IntegrityCheck;
import org.openmrs.module.dataintegrityworkflow.DataIntegrityWorkflowService;
import org.openmrs.module.dataintegrityworkflow.db.DataIntegrityWorkflowDAO;

import java.util.List;

/**
 * @author: harsha
 */
public class DataIntegrityWorkflowServiceImpl implements DataIntegrityWorkflowService {

    /**
     * dao for use with this service implementation
     */
    private DataIntegrityWorkflowDAO dao;
    protected final Log log = LogFactory.getLog(getClass());

    /**
     * @see org.openmrs.module.dataintegrityworkflow.DataIntegrityWorkflowService#setDataIntegrityDAO(org.openmrs.module.dataintegrityworkflow.db.DataIntegrityWorkflowDAO)
     */
    public void setDataIntegrityWorkflowDAO(DataIntegrityWorkflowDAO dao) {
        this.dao = dao;
    }

    /**
     * @see org.openmrs.module.dataintegrityworkflow.DataIntegrityWorkflowService#getDataIntegrityDAO()
     */
    public DataIntegrityWorkflowDAO getDataIntegrityDAO() {
        return this.dao;
    }

    public List<IntegrityCheck> getAllIntegrityChecks()
    {
       return Context.getService(DataIntegrityService.class).getAllIntegrityChecks();
    }
}
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
package org.openmrs.module.dataintegrityworkflow;

import org.openmrs.module.dataintegrity.IntegrityCheck;
import org.openmrs.module.dataintegrity.db.DataIntegrityDAO;
import org.openmrs.module.dataintegrityworkflow.db.DataIntegrityWorkflowDAO;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author: harsha
 */
@Transactional
public interface DataIntegrityWorkflowService {
    /**
     * sets the data integrity workflow DAO
     *
     * @param dao
     */
    public void setDataIntegrityWorkflowDAO(DataIntegrityWorkflowDAO dao);

    /**
     * returns the data integrity workflow DAO
     *
     * @return
     */
    public DataIntegrityWorkflowDAO getDataIntegrityDAO();

    public List<IntegrityCheck> getAllIntegrityChecks();
}

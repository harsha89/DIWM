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
package org.openmrs.module.dataintegrityworkflow.db;

import org.hibernate.SessionFactory;
import org.openmrs.User;
import org.openmrs.module.dataintegrityworkflow.IntegrityRecordStageChange;
import org.openmrs.module.dataintegrityworkflow.IntegrityWorkflowRecord;
import org.openmrs.module.dataintegrityworkflow.RecordAssignee;
import org.openmrs.module.dataintegrityworkflow.WorkflowStage;

/**
 * @author: harsha
 */
public interface DataIntegrityWorkflowDAO {
    /**
     * set the session factory
     *
     * @param sessionFactory
     */
    public void setSessionFactory(SessionFactory sessionFactory);

    /**
     * get the session factory
     *
     * @return the session factory
     */
    public SessionFactory getSessionFactory();

    public void saveIntegrityWorkflowRecord(IntegrityWorkflowRecord integrityWorkflowRecord);

    public void saveWorkflowStage(WorkflowStage workflowStage);

    public void saveWorkflowAssignee(RecordAssignee recordAssignee);

    public void saveIntegrityRecordStageChange(IntegrityRecordStageChange integrityRecordStageChange);


    public IntegrityWorkflowRecord getIntegrityWorkflowRecord(int recordId);

    public IntegrityWorkflowRecord getAllIntegrityWorkflowRecords();

    public IntegrityWorkflowRecord getIntegrityWorkflowRecordByCurrentUser(User user);

}

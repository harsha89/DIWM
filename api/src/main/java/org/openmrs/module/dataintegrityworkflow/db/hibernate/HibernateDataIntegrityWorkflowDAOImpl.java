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
package org.openmrs.module.dataintegrityworkflow.db.hibernate;

import org.hibernate.SessionFactory;
import org.openmrs.User;
import org.openmrs.module.dataintegrityworkflow.*;
import org.openmrs.module.dataintegrityworkflow.db.DataIntegrityWorkflowDAO;

import java.util.List;

/**
 * @author: harsha
 */
public class HibernateDataIntegrityWorkflowDAOImpl implements DataIntegrityWorkflowDAO {
    /**
     * the session factory to use in this DAO
     */
    private SessionFactory sessionFactory;

    /**
     * @see DataIntegrityWorkflowDAO#setSessionFactory(SessionFactory)
     */
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    /**
     * @see DataIntegrityWorkflowDAO#getSessionFactory()
     */
    public SessionFactory getSessionFactory() {
        return this.sessionFactory;
    }

    public void saveIntegrityWorkflowRecord(IntegrityWorkflowRecord integrityWorkflowRecord) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    public void saveWorkflowStage(WorkflowStage workflowStage) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    public void saveWorkflowAssignee(RecordAssignee recordAssignee) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    public void saveIntegrityRecordStageChange(IntegrityRecordStageChange integrityRecordStageChange) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    public void saveIntegrityRecordComment(IntegrityRecordComment integrityRecordComment) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    public IntegrityWorkflowRecord getIntegrityWorkflowRecord(int integrityCheckResultId) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public IntegrityWorkflowRecord getAllIntegrityWorkflowRecords() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public List<IntegrityWorkflowRecord> getAssignedIntegrityWorkflowRecordsOfCurrentUser(User assignedUser) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public List<IntegrityWorkflowRecord> getAllAssignedIntegrityWorkflowRecordsOfCurrentUser(User assigneduser) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public List<RecordAssignee> getAllAssignmentsOfUser(User user) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public RecordAssignee getCurrentAssignmentOfUser(User user) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public List<IntegrityRecordComment> getIntegrityRecordComments(int integrityWorkflowRecordId) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public void updateIntegrityRecordComment(IntegrityRecordComment integrityRecordComment) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    public void updateIntegrityWorkflowRecord(IntegrityWorkflowRecord integrityWorkflowRecord) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    public void updateWorkflowAssignee(RecordAssignee recordAssignee) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    public void deleteIntegrityRecordComment(IntegrityRecordComment integrityRecordComment) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

}

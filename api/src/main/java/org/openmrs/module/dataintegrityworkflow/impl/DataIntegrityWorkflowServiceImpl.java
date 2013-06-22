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
import org.openmrs.User;
import org.openmrs.api.context.Context;
import org.openmrs.module.dataintegrity.DataIntegrityService;
import org.openmrs.module.dataintegrity.IntegrityCheck;
import org.openmrs.module.dataintegrity.IntegrityCheckResult;
import org.openmrs.module.dataintegrityworkflow.*;
import org.openmrs.module.dataintegrityworkflow.db.DataIntegrityWorkflowDAO;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * @author: harsz89
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

    public IntegrityCheck getIntegrityCheck(Integer checkId) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
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

    public List<IntegrityWorkflowRecordWithCheckResult> getAllIntegrityWorkflowRecordWithCheckResult(int checkId) {
        IntegrityCheck integrityCheck=Context.getService(DataIntegrityService.class).getIntegrityCheck(checkId);
        Set<IntegrityCheckResult> results=integrityCheck.getIntegrityCheckResults();
        List<IntegrityWorkflowRecord> integrityWorkflowRecords=dao.getAllIntegrityWorkflowRecords();
        List<IntegrityWorkflowRecordWithCheckResult> integrityWorkflowRecordWithCheckResultList=new ArrayList<IntegrityWorkflowRecordWithCheckResult>();
        IntegrityWorkflowRecordWithCheckResult  integrityWorkflowRecordWithCheckResult;
        for(IntegrityCheckResult integrityCheckResult:results)
        {
            for(IntegrityWorkflowRecord integrityWorkflowRecord:integrityWorkflowRecords)
            {
                if(integrityCheckResult.getIntegrityCheckResultId().equals(integrityWorkflowRecord.getIntegrityCheckResult().getIntegrityCheckResultId()))
                {
                    integrityWorkflowRecordWithCheckResult=new IntegrityWorkflowRecordWithCheckResult();
                    integrityWorkflowRecordWithCheckResult.setIntegrityCheckResult(integrityCheckResult);
                    integrityWorkflowRecordWithCheckResult.setIntegrityWorkflowRecord(integrityWorkflowRecord);
                    integrityWorkflowRecordWithCheckResultList.add(integrityWorkflowRecordWithCheckResult);
                    break;
                }
            }
        }
        return integrityWorkflowRecordWithCheckResultList;
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
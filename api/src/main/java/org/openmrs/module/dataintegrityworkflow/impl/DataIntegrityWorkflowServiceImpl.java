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
import java.util.Date;
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
     * @see org.openmrs.module.dataintegrityworkflow.DataIntegrityWorkflowService#setDataIntegrityWorkflowDAO(org.openmrs.module.dataintegrityworkflow.db.DataIntegrityWorkflowDAO)
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
        return Context.getService(DataIntegrityService.class).getIntegrityCheck(checkId);
    }

    public void saveIntegrityWorkflowRecord(IntegrityWorkflowRecord integrityWorkflowRecord) {
        dao.saveIntegrityWorkflowRecord(integrityWorkflowRecord);
    }

    public void saveWorkflowStage(WorkflowStage workflowStage) {
        dao.saveWorkflowStage(workflowStage);
    }

    public int saveWorkflowAssignee(RecordAssignee recordAssignee) {
        return dao.saveWorkflowAssignee(recordAssignee);
    }

    public void saveIntegrityRecordStageChange(IntegrityRecordStageChange integrityRecordStageChange) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    public void saveIntegrityRecordComment(IntegrityRecordComment integrityRecordComment) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    public RecordAssignee getRecordAssigneeById(int assigneeId) {
        return dao.getRecordAssigneeById(assigneeId);
    }

    public IntegrityWorkflowRecord getIntegrityWorkflowRecord(int integrityCheckResultId) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public IntegrityWorkflowRecord getIntegrityWorkflowRecordByResult(IntegrityCheckResult integrityCheckResult) {
        return dao.getIntegrityWorkflowRecordByResult(integrityCheckResult);
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

    public WorkflowStage getWorkflowStage(int stageId) {
        return dao.getWorkflowStage(stageId);
    }

    public RecordAssignee getWorkflowRecordAssigneeByUserAndWorkflowRecord(IntegrityWorkflowRecord integrityWorkflowRecord, User assignUser) {
        return dao.getWorkflowRecordAssigneeByUserAndWorkflowRecord(integrityWorkflowRecord,assignUser);
    }

    public List<IntegrityWorkflowRecordWithCheckResult> getAllIntegrityWorkflowRecordWithCheckResult(int checkId) {
        IntegrityCheck integrityCheck=Context.getService(DataIntegrityService.class).getIntegrityCheck(checkId);
        Set<IntegrityCheckResult> results=integrityCheck.getIntegrityCheckResults();
        List<IntegrityWorkflowRecord> integrityWorkflowRecords=dao.getAllIntegrityWorkflowRecordsForCheck(checkId);
        List<IntegrityWorkflowRecordWithCheckResult> integrityWorkflowRecordWithCheckResultList=new ArrayList<IntegrityWorkflowRecordWithCheckResult>();
        IntegrityWorkflowRecordWithCheckResult  integrityWorkflowRecordWithCheckResult;
        for(IntegrityCheckResult integrityCheckResult:results)
        {
            boolean found=false;
            integrityWorkflowRecordWithCheckResult=new IntegrityWorkflowRecordWithCheckResult();
            if(integrityWorkflowRecords!=null){
            for(IntegrityWorkflowRecord integrityWorkflowRecord:integrityWorkflowRecords)
            {
                if(integrityCheckResult.getIntegrityCheckResultId().equals(integrityWorkflowRecord.getIntegrityCheckResult().getIntegrityCheckResultId()))
                {
                    integrityWorkflowRecordWithCheckResult.setIntegrityCheckResult(integrityCheckResult);
                    integrityWorkflowRecordWithCheckResult.setIntegrityWorkflowRecord(integrityWorkflowRecord);
                    integrityWorkflowRecordWithCheckResultList.add(integrityWorkflowRecordWithCheckResult);
                    found=true;
                    break;
                }
            }
            }
            if(!found)
            {
                integrityWorkflowRecordWithCheckResult.setIntegrityCheckResult(integrityCheckResult);
                integrityWorkflowRecordWithCheckResultList.add(integrityWorkflowRecordWithCheckResult);
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
        dao.updateIntegrityWorkflowRecord(integrityWorkflowRecord);
    }

    public void updateWorkflowAssignee(RecordAssignee recordAssignee) {
        dao.updateWorkflowAssignee(recordAssignee);
    }

    public void deleteIntegrityRecordComment(IntegrityRecordComment integrityRecordComment) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    public List<IntegrityWorkflowRecord> getAllIntegrityWorkflowRecordsForCheck(int checkId) {
        return dao.getAllIntegrityWorkflowRecordsForCheck(checkId);
    }

    public void assignRecords(String[] recordIdList,int checkId,String user) {

        DataIntegrityWorkflowService integrityWorkflowService=Context.getService(DataIntegrityWorkflowService.class);
        User assignUser=Context.getUserService().getUserByUsername(user);
            List<IntegrityWorkflowRecord> integrityWorkflowRecords=integrityWorkflowService.getAllIntegrityWorkflowRecordsForCheck(checkId);
            for(IntegrityWorkflowRecord integrityWorkflowRecord:integrityWorkflowRecords) {
                for(String recordId:recordIdList)
                {
                    if(integrityWorkflowRecord.getIntegrityCheckResult().getIntegrityCheckResultId()==Integer.parseInt(recordId)) {
                        if(integrityWorkflowRecord.getPreviousRecordAssignees().size()==0) {
                            int assigneeId;
                            int assginmentId;
                            RecordAssignee recordAssignee=new RecordAssignee();
                            recordAssignee.setAssignee(assignUser);
                            recordAssignee.setIntegrityWorkflowRecord(integrityWorkflowRecord);
                            assigneeId=integrityWorkflowService.saveWorkflowAssignee(recordAssignee);
                            recordAssignee=integrityWorkflowService.getRecordAssigneeById(assigneeId);
                            IntegrityRecordAssignment integrityRecordAssignment=new IntegrityRecordAssignment();
                            integrityRecordAssignment.setAssignBy(Context.getUserContext().getAuthenticatedUser());
                            integrityRecordAssignment.setAssignedDate(new Date());
                            integrityRecordAssignment.setCurrentStage(integrityWorkflowService.getWorkflowStage(1));
                            integrityRecordAssignment.setRecordAssignee(recordAssignee);
                            assginmentId=integrityWorkflowService.saveIntegrityRecordAssignment(integrityRecordAssignment);
                            integrityRecordAssignment=integrityWorkflowService.getIntegrityRecordAssignmentByAssignee(recordAssignee);
                            recordAssignee.setCurrentIntegrityRecordAssignment(integrityRecordAssignment);
                            integrityWorkflowService.updateWorkflowAssignee(recordAssignee);
                            integrityWorkflowRecord.setCurrentAssignee(recordAssignee);
                            integrityWorkflowRecord.setLastUpdated(new Date());
                            integrityWorkflowService.updateIntegrityWorkflowRecord(integrityWorkflowRecord);
                        } else {
                            boolean isAssigneeFound=false;
                            for(RecordAssignee assignee:integrityWorkflowRecord.getPreviousRecordAssignees())
                            {
                                if(assignee.getAssignee().equals(assignUser))
                                {
                                    isAssigneeFound=true;
                                    if(!assignee.equals(integrityWorkflowRecord.getCurrentAssignee()))
                                    {
                                        IntegrityRecordAssignment integrityRecordAssignment=new IntegrityRecordAssignment();
                                        integrityRecordAssignment.setAssignBy(Context.getUserContext().getAuthenticatedUser());
                                        integrityRecordAssignment.setAssignedDate(new Date());
                                        integrityRecordAssignment.setCurrentStage(integrityWorkflowService.getWorkflowStage(0));
                                        integrityRecordAssignment.setRecordAssignee(assignee);
                                        assignee.setCurrentIntegrityRecordAssignment(integrityRecordAssignment);
                                        integrityWorkflowService.saveWorkflowAssignee(assignee);
                                        RecordAssignee previousRecordAssignee=integrityWorkflowRecord.getCurrentAssignee();
                                        if(previousRecordAssignee!=null){
                                        IntegrityRecordAssignment previousAssigneeAssignment=previousRecordAssignee.getCurrentIntegrityRecordAssignment();
                                        previousAssigneeAssignment.setUnassignBy(Context.getUserContext().getAuthenticatedUser());
                                        previousAssigneeAssignment.setUnassignDate(new Date());
                                        previousRecordAssignee.setCurrentIntegrityRecordAssignment(previousAssigneeAssignment);
                                        integrityWorkflowService.saveWorkflowAssignee(previousRecordAssignee);
                                        }
                                        integrityWorkflowRecord.setCurrentAssignee(assignee);
                                        integrityWorkflowService.saveIntegrityWorkflowRecord(integrityWorkflowRecord);

                                    }
                                    break;
                                }
                            }
                            if(!isAssigneeFound) {
                                RecordAssignee recordAssignee=new RecordAssignee();
                                recordAssignee.setAssignee(assignUser);
                                recordAssignee.setIntegrityWorkflowRecord(integrityWorkflowRecord);
                                integrityWorkflowService.saveWorkflowAssignee(recordAssignee);
                                IntegrityRecordAssignment integrityRecordAssignment=new IntegrityRecordAssignment();
                                integrityRecordAssignment.setAssignBy(Context.getUserContext().getAuthenticatedUser());
                                integrityRecordAssignment.setAssignedDate(new Date());
                                integrityRecordAssignment.setCurrentStage(integrityWorkflowService.getWorkflowStage(0));
                                recordAssignee=integrityWorkflowService.getWorkflowRecordAssigneeByUserAndWorkflowRecord(integrityWorkflowRecord,assignUser);
                                integrityRecordAssignment.setRecordAssignee(recordAssignee);
                                recordAssignee.setCurrentIntegrityRecordAssignment(integrityRecordAssignment);
                                integrityWorkflowService.saveWorkflowAssignee(recordAssignee);
                                RecordAssignee previousRecordAssignee=integrityWorkflowRecord.getCurrentAssignee();
                                IntegrityRecordAssignment previousAssigneeAssignment=previousRecordAssignee.getCurrentIntegrityRecordAssignment();
                                previousAssigneeAssignment.setUnassignBy(Context.getUserContext().getAuthenticatedUser());
                                previousAssigneeAssignment.setUnassignDate(new Date());
                                previousRecordAssignee.setCurrentIntegrityRecordAssignment(previousAssigneeAssignment);
                                integrityWorkflowService.saveWorkflowAssignee(previousRecordAssignee);
                                integrityWorkflowRecord.setCurrentAssignee(recordAssignee);
                                integrityWorkflowService.saveIntegrityWorkflowRecord(integrityWorkflowRecord);
                            }
                        }
                    }
                }
            }

    }

    public void removeRecords(String[] recordIdList, int checkId) {
        DataIntegrityWorkflowService integrityWorkflowService=Context.getService(DataIntegrityWorkflowService.class);
        List<IntegrityWorkflowRecord> integrityWorkflowRecords=integrityWorkflowService.getAllIntegrityWorkflowRecordsForCheck(checkId);
        for(String recordId:recordIdList)
        {
            for(IntegrityWorkflowRecord integrityWorkflowRecord:integrityWorkflowRecords)
            {
                if(integrityWorkflowRecord.getIntegrityCheckResult().getIntegrityCheckResultId()==Integer.parseInt(recordId)) {
                    RecordAssignee  recordAssignee=integrityWorkflowRecord.getCurrentAssignee();
                    IntegrityRecordAssignment integrityRecordAssignment=recordAssignee.getCurrentIntegrityRecordAssignment();
                    integrityRecordAssignment.setUnassignDate(new Date());
                    integrityRecordAssignment.setUnassignBy(Context.getUserContext().getAuthenticatedUser());
                    recordAssignee.setCurrentIntegrityRecordAssignment(integrityRecordAssignment);
                    integrityWorkflowService.saveWorkflowAssignee(recordAssignee);
                    integrityWorkflowRecord.setCurrentAssignee(null);
                    integrityWorkflowService.saveIntegrityWorkflowRecord(integrityWorkflowRecord);
                }
            }
        }
    }

    public int saveIntegrityRecordAssignment(IntegrityRecordAssignment integrityRecordAssignment) {
        return dao.saveIntegrityRecordAssignment(integrityRecordAssignment);
    }

    public void createWorkflowRecordsIfNotExists(String[] recordIdList,int checkId) {
        DataIntegrityWorkflowService integrityWorkflowService=Context.getService(DataIntegrityWorkflowService.class);
        int checkResultId;
        IntegrityCheck integrityCheck=integrityWorkflowService.getIntegrityCheck(checkId);
        for(IntegrityCheckResult integrityCheckResult:integrityCheck.getIntegrityCheckResults())
        {
            for(String recordId:recordIdList)
            {
                checkResultId=Integer.parseInt(recordId);
                if(checkResultId==integrityCheckResult.getIntegrityCheckResultId())
                {
                    if(integrityWorkflowService.getIntegrityWorkflowRecordByResult(integrityCheckResult)==null)
                    {
                        IntegrityWorkflowRecord integrityWorkflowRecord=new IntegrityWorkflowRecord();
                        integrityWorkflowRecord.setIntegrityCheckResult(integrityCheckResult);
                        integrityWorkflowRecord.setIntegrityCheckId(checkId);
                        integrityWorkflowRecord.setLastUpdated(new Date());
                        integrityWorkflowService.saveIntegrityWorkflowRecord(integrityWorkflowRecord);
                    }
                }
            }
        }
    }

    public IntegrityRecordAssignment getIntegrityRecordAssignmentByAssignee(RecordAssignee recordAssignee) {
        return dao.getIntegrityRecordAssignmentByAssignee(recordAssignee);
    }
}
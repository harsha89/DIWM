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

import org.openmrs.BaseOpenmrsObject;
import org.openmrs.User;

import java.util.Date;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * User: harsha
 * Date: 6/1/13
 * Time: 7:16 PM
 * To change this template use File | Settings | File Templates.
 */
public class RecordAssignee extends BaseOpenmrsObject {
    private Integer recordAssigneeId;
    private User assignee;
    private User assignedBy;
    private Date assignedDate;
    private User unAssignedBy;
    private Date unAssignedDate;
    private Set<IntegrityRecordStageChange> integrityRecordStageChnages;
    private WorkflowStage currentStage;
    private IntegrityWorkflowRecord integrityWorkflowRecord;
    private boolean isAssigned;

    public Integer getId() {
        return this.getRecordAssigneeId();
    }

    public void setId(Integer recordAssigneeId) {
        this.setRecordAssigneeId(recordAssigneeId);
    }

    public User getAssignee() {
        return assignee;
    }

    public void setAssignee(User assignee) {
        this.assignee = assignee;
    }

    public User getAssignedBy() {
        return assignedBy;
    }

    public void setAssignedBy(User assignedBy) {
        this.assignedBy = assignedBy;
    }

    public Date getAssignedDate() {
        return assignedDate;
    }

    public void setAssignedDate(Date assignedDate) {
        this.assignedDate = assignedDate;
    }

    public User getUnAssignedBy() {
        return unAssignedBy;
    }

    public void setUnAssignedBy(User unAssignedBy) {
        this.unAssignedBy = unAssignedBy;
    }

    public Date getUnAssignedDate() {
        return unAssignedDate;
    }

    public void setUnAssignedDate(Date unAssignedDate) {
        this.unAssignedDate = unAssignedDate;
    }

    public Set<IntegrityRecordStageChange> getIntegrityRecordStageChnages() {
        return integrityRecordStageChnages;
    }

    public void setIntegrityRecordStageChnages(Set<IntegrityRecordStageChange> integrityRecordStageChnages) {
        this.integrityRecordStageChnages = integrityRecordStageChnages;
    }

    public WorkflowStage getCurrentStage() {
        return currentStage;
    }

    public void setCurrentStage(WorkflowStage currentStage) {
        this.currentStage = currentStage;
    }

    public IntegrityWorkflowRecord getIntegrityWorkflowRecord() {
        return integrityWorkflowRecord;
    }

    public void setIntegrityWorkflowRecord(IntegrityWorkflowRecord integrityWorkflowRecord) {
        this.integrityWorkflowRecord = integrityWorkflowRecord;
    }

    public boolean isAssigned() {
        return isAssigned;
    }

    public void setAssigned(boolean assigned) {
        isAssigned = assigned;
    }

    public Integer getRecordAssigneeId() {
        return recordAssigneeId;
    }

    public void setRecordAssigneeId(Integer recordAssigneeId) {
        this.recordAssigneeId = recordAssigneeId;
    }
}

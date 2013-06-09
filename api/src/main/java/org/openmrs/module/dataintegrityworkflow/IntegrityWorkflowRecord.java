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
import org.openmrs.module.dataintegrity.IntegrityCheckColumn;
import org.openmrs.module.dataintegrity.IntegrityCheckResult;

import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * User: harsha
 * Date: 6/9/13
 * Time: 6:58 PM
 * To change this template use File | Settings | File Templates.
 */
public class IntegrityWorkflowRecord extends BaseOpenmrsObject{
    private int integrityRecordWorkflowDetailId;
    private RecordAssignee currentAssignee;
    private Set<RecordAssignee> previousRecordAssignees;
    private Set<IntegrityRecordComment> integrityRecordComments;
    private IntegrityCheckResult integrityCheckResult;
    private Set<IntegrityCheckColumn> integrityCheckColumns;

    public Integer getId() {
        return getIntegrityRecordWorkflowDetailId();
    }

    public void setId(Integer integrityRecordWorkflowDetailId) {
        this.setIntegrityRecordWorkflowDetailId(integrityRecordWorkflowDetailId);
    }

    public RecordAssignee getCurrentAssignee() {
        return currentAssignee;
    }

    public void setCurrentAssignee(RecordAssignee currentAssignee) {
        this.currentAssignee = currentAssignee;
    }

    public Set<RecordAssignee> getPreviousRecordAssignees() {
        return previousRecordAssignees;
    }

    public void setPreviousRecordAssignees(Set<RecordAssignee> previousRecordAssignees) {
        this.previousRecordAssignees = previousRecordAssignees;
    }

    public Set<IntegrityRecordComment> getIntegrityRecordComments() {
        return integrityRecordComments;
    }

    public void setIntegrityRecordComments(Set<IntegrityRecordComment> integrityRecordComments) {
        this.integrityRecordComments = integrityRecordComments;
    }

    public IntegrityCheckResult getIntegrityCheckResult() {
        return integrityCheckResult;
    }

    public void setIntegrityCheckResult(IntegrityCheckResult integrityCheckResult) {
        this.integrityCheckResult = integrityCheckResult;
    }

    public Set<IntegrityCheckColumn> getIntegrityCheckColumns() {
        return integrityCheckColumns;
    }

    public void setIntegrityCheckColumns(Set<IntegrityCheckColumn> integrityCheckColumns) {
        this.integrityCheckColumns = integrityCheckColumns;
    }

    public int getIntegrityRecordWorkflowDetailId() {
        return integrityRecordWorkflowDetailId;
    }

    public void setIntegrityRecordWorkflowDetailId(int integrityRecordWorkflowDetailId) {
        this.integrityRecordWorkflowDetailId = integrityRecordWorkflowDetailId;
    }
}

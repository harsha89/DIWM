package org.openmrs.module.dataintegrityworkflow;

import org.openmrs.BaseOpenmrsObject;
import org.openmrs.User;
import org.openmrs.module.dataintegrity.IntegrityCheckResult;

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
    private User assignBy;
    private Set<IntegrityRecordStageChange> integrityRecordStageChnages;
    private WorkflowStage currentStage;
    private IntegrityCheckResult integrityCheckResult;
    private boolean isAssigned;

    public Integer getId() {
        return this.recordAssigneeId;
    }

    public void setId(Integer integer) {
        this.recordAssigneeId=integer;
    }
}

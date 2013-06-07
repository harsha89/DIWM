package org.openmrs.module.dataintegrityworkflow;

import org.openmrs.BaseOpenmrsObject;
import org.openmrs.User;

import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: harsha
 * Date: 6/1/13
 * Time: 2:09 PM
 * To change this template use File | Settings | File Templates.
 */
public class IntegrityRecordStageChange extends BaseOpenmrsObject{
    private String stagenChangeId;
    private RecordAssignee recordAssignee;
    private User changeBy;
    private Date changeDate;
    private WorkflowStage fromWorkflowStage;
    private WorkflowStage toWorkflowStage;
    public Integer getId() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public void setId(Integer integer) {
        //To change body of implemented methods use File | Settings | File Templates.
    }
}

package org.openmrs.module.dataintegrityworkflow;

import org.openmrs.module.dataintegrity.IntegrityCheckResult;

/**
 * Created with IntelliJ IDEA.
 * User: harsha
 * Date: 6/10/13
 * Time: 8:20 PM
 * To change this template use File | Settings | File Templates.
 */
public class IntegrityWorkflowRecordWithCheckResult {
    private IntegrityCheckResult integrityCheckResult;
    private IntegrityWorkflowRecord integrityWorkflowRecord;

    public IntegrityCheckResult getIntegrityCheckResult() {
        return integrityCheckResult;
    }

    public void setIntegrityCheckResult(IntegrityCheckResult integrityCheckResult) {
        this.integrityCheckResult = integrityCheckResult;
    }

    public IntegrityWorkflowRecord getIntegrityWorkflowRecord() {
        return integrityWorkflowRecord;
    }

    public void setIntegrityWorkflowRecord(IntegrityWorkflowRecord integrityWorkflowRecord) {
        this.integrityWorkflowRecord = integrityWorkflowRecord;
    }
}

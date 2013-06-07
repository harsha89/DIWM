package org.openmrs.module.dataintegrityworkflow;

import org.openmrs.BaseOpenmrsData;
import org.openmrs.module.dataintegrity.IntegrityCheckResult;

/**
 * Created with IntelliJ IDEA.
 * User: harsha
 * Date: 6/1/13
 * Time: 7:23 PM
 * To change this template use File | Settings | File Templates.
 */
public class IntegrityRecordComment extends BaseOpenmrsData{

    private Integer integrityRecordCommentId;
    private IntegrityCheckResult integrityCheckResult;
    private String comment;

    public Integer getId() {
        return this.integrityRecordCommentId;
    }

    public void setId(Integer integer) {
        this.integrityRecordCommentId=integer;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}

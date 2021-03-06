<%@ include file="/WEB-INF/template/include.jsp" %>

<openmrs:require privilege="Manage Record Assignees" otherwise="/login.htm" redirect="/module/dataintegrityworkflow/viewChecks.form" />

<%@ include file="/WEB-INF/template/header.jsp" %>

<openmrs:htmlInclude file="/moduleResources/dataintegrityworkflow/demo_table_jui.css" />
<openmrs:htmlInclude file="/moduleResources/dataintegrityworkflow/jquery.dataTables.min.js" />
<openmrs:htmlInclude file="/moduleResources/dataintegrityworkflow/css/module.css"/>
<openmrs:htmlInclude file="/moduleResources/dataintegrityworkflow/js/module.js"/>

<h2><c:out value="${check.name}"/>-<spring:message code="dataintegrityworkflow.record.list"/></h2>
<div>
    <form id="scheduleForm" method="post">
        <input type="hidden" name="checkId" value="${check.id}"/>
        <table cellspacing="0" cellpadding="2" id="table" class="display">
            <thead>
            <tr>
                <th width="50" id="checkboxColumn"><input type="checkbox" id="selectAllCheckBox" value="0"/></th>
                <th width="200"><spring:message code="dataintegrityworkflow.recordId"/></th>
                <th width="300"><spring:message code="dataintegrityworkflow.status"/></th>
                <th width="300"><spring:message code="dataintegrityworkflow.assignee"/></th>
                <th width="300"><spring:message code="dataintegrityworkflow.stage"/></th>
                <th width="300"><spring:message code="dataintegrityworkflow.lastupdated"/></th>
                <th width="300"><spring:message code="dataintegrityworkflow.summary"/></th>
            </tr>
            </thead>
                <tbody id="formContent">
                <c:forEach items="${records}" var="record" varStatus="loopStatus">
                    <tr class="row" id="${record.integrityCheckResult.integrityCheckResultId}">
                        <td>
                            <input type="checkbox" size="3" name="recordId" class="checkboxRow" value="${record.integrityCheckResult.integrityCheckResultId}" />
                        </td>
                        <td><a href="<openmrs:contextPath/>/module/dataintegrityworkflow/viewRecord.form?recordId=<c:out value="${record.integrityCheckResult.integrityCheckResultId}"/>&checkId="${check.id}">RECORD-<c:out value="${record.integrityCheckResult.integrityCheckResultId}"/></a> </td>
                        <td class="status"><c:out value="${record.integrityCheckResult.status}"/></td>
                        <td>
                            <c:if test="${not empty record.integrityWorkflowRecord.currentAssignee}">
                            <c:out value="${record.integrityWorkflowRecord.currentAssignee}"/>
                                <span><a href="#" onclick=""></a></span>
                            </c:if>
                        </td>
                        <td>
                            <c:if test="${not empty record.integrityWorkflowRecord.currentAssignee}">
                                <c:out value="${record.integrityWorkflowRecord.currentAssignee.currentIntegrityRecordAssignment.currentStage}"/>
                            </c:if>
                        </td>
                        <td>
                            <c:choose><c:when test="${not empty record.integrityWorkflowRecord.lastUpdated}">
                                <openmrs:formatDate date="${record.integrityWorkflowRecord.lastUpdated}" type="long"/>
                            </c:when>
                                <c:otherwise>
                                    <openmrs:formatDate date="${record.integrityCheckResult.lastSeen.dateCreated}" type="long"/>
                                </c:otherwise>
                            </c:choose>
                        </td>
                        <td>
                            <a href="<openmrs:contextPath/>/module/dataintegrityworkflow/viewRecordSummary.form?recordId=<c:out value="${record.integrityCheckResult.integrityCheckResultId}"/>&checkId="${check.id}"><spring:message code="dataintegrityworkflow.record.summary"/></a>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
        </table>
        <div>
            <table  id="actionRow">
                <tr>
                    <td id="assign">
                        <button type="button" onclick="showDiv('assign');"><spring:message code="dataintegrityworkflow.assign"/> </button>
                    </td>
                    <td id="remove">
                        <button type="button" onclick="showDiv('remove');"><spring:message code="dataintegrityworkflow.removeAssignees"/></button>
                    </td>
                    <td id="checkSummary">
                        <button type="button" onclick="window.location.href = '/module/dataintegrityworkflow/viewCheckSummary.form?checkId=<c:out value="${check.id}"/>';"><spring:message code="dataintegrityworkflow.checkSummary"/></button>
                    </td>
                </tr>
            </table>
        </div>
        <div id="assignDiv" style="clear: both" class="show_hide slidingDiv">
            <table>
                <tr>
                    <td>
                        <spring:message code="dataintegrityworkflow.assign"/>
                    </td>
                    <td>
                        <select name="assignmentOptions" id="assignmentOpt">
                            <option value="selected">Selected</option>
                            <option value="all">All</option>
                            <%-- <option value="allAndFuture">All and future</option>--%>
                        </select>
                    </td>
                    <td>
                        <spring:message code="dataintegrityworkflow.recordsTo"/></span>
                    </td>
                    <td>
                        <select name="selectUser" id="selectUsr">
                            <c:forEach items="${users}" var="user">
                                <option value="<c:out value="${user}"/>"><c:out value="${user}"/></option>
                            </c:forEach>
                        </select>
                    </td>
                    <td>
                        <input type="submit" name="action" value="<spring:message code="dataintegrityworkflow.records.assign"/>" onclick="return checkForAssignAssignees();"/>
                    </td>
                </tr>
            </table>
        </div>
        <div id="removeDiv" class="show_hide slidingDiv" >
            <table>
                <tr>
                    <td><spring:message code="dataintegrityworkflow.removeAssignmentsFrom"/></td>
                    <td>
                        <select name="removeOptions" id="removeOpt">
                            <%--<option value="all">All</option>--%>
                            <option value="selected">Selected</option>
                            <%--<option value="allAndFuture">All and future</option>--%>
                        </select>
                    </td>
                    <td>
                        <spring:message code="dataintegrityworkflow.records"/>
                    </td>
                    <td>
                        <input type="submit" name="action" value="<spring:message code="dataintegrityworkflow.records.remove"/>" onclick="return checkForRemoveAssignees();"/>
                    </td>
                </tr>
            </table>
        </div>
    </form>
</div>

<%@ include file="/WEB-INF/template/footer.jsp" %>
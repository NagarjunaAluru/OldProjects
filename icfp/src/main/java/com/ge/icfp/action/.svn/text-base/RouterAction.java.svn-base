package com.ge.icfp.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.ge.icfp.model.DealRequest;
import com.ge.icfp.model.InboxReply;
import com.ge.icfp.model.MsgHeader;
import com.ge.icfp.model.MyAssignData;
import com.ge.icfp.model.MyTaskData;
import com.ge.icfp.model.WorkItem;
import com.hydus.wff.common.bw.ServiceClient;
import com.hydus.wff.core.exception.HWFServiceException;
import com.hydus.wff.core.exception.HWFStubException;
import com.hydus.wff.core.session.SessionManager;
import static com.ge.icfp.common.constants.ICFPConstants.*;
/**
 * This will redirect the request from email Link to 
 * the appropriate page based on the workflow stage.
 * 
 * @author prithivi.dhamotharan
 *
 */
public class RouterAction extends ICFPBaseAction {
	
	private static final String READ_ONLY = "readOnly";
	private static final String HAS_EITHER_BEEN_PROCESSED_ALREADY_OR_NOT_PENDING_FOR_YOUR_ACTION = " has either been processed already or not pending for your action";
	private static final String DEAL = "Deal# ";
	private static final String ROUTE = "route";
	private static final String WORK_ITEM = "workItem";
	private static final String TASK_ASSIGNER = "taskAssigner";
	private static final String GETINBOXFORDEAL = "GETINBOXFORDEAL";
	private static final String HWF_ROUTER_1001 = "HWF.ROUTER.1001";
	private static final String DEALID = "DEALID";
	/**
	 * Spring injecting bean
	 */
	private ServiceClient serviceClient = null;
	
	/**
	 * Build the URL based on the workflow stage
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws ICFPException 
	 * @throws HWFStubException 
	 * @throws HWFServiceException 
	 */
	public ActionForward load(ActionMapping mapping, ActionForm form,
		        HttpServletRequest request, HttpServletResponse response) throws ICFPException, HWFServiceException, HWFStubException {
		 
		 String id = request.getParameter(DEALID);
		 String userid = SessionManager.getUserID(request);
		 
		 boolean isIDEmpty = StringUtils.isEmpty(id);	
		 boolean isUserEmpty = StringUtils.isEmpty(userid);
		 
		 if( isIDEmpty || isUserEmpty ){
			 throw new ICFPException(HWF_ROUTER_1001);
		 }		 
		 List<String> roles = SessionManager.getRoles(request);
		 String roleName = getRoles(roles);
		 MsgHeader header = new MsgHeader();
		 header.setOpcode(MYTASKS);
		 header.setAuditCreator( userid );
		 header.setRoleName(roleName);
		 
		 DealRequest dealRequest = new DealRequest();
		 dealRequest.setUniqueId(id);
		 dealRequest.setMsgHeader( header );
		 
		 InboxReply reply = serviceClient.invokeService(GETINBOXFORDEAL, dealRequest, InboxReply.class);
		 
		 MyAssignData unassign = reply.getMyAssignData();
		 MyTaskData mytask = reply.getMyTaskData();
		 
		 boolean isAvailable = false;
		 
		 for(WorkItem item : unassign.getWorkItems()){
			 
			 if( id.equals( item.getBusinessRequestID()) ){
				 isAvailable = true;
				 request.setAttribute(TASK_ASSIGNER, true);
				 request.setAttribute(WORK_ITEM, item);
				 break;
			 }
		 }
		 
		 if( !isAvailable ){
			 
			for( WorkItem item: mytask.getWorkItems() ){
				
				if( id.equals( item.getBusinessRequestID() )){
					isAvailable = true;
					request.setAttribute(WORK_ITEM, item);
					request.setAttribute(TASK_ASSIGNER, false);
					break;
				}
			}
		 }
		 
		 if( isAvailable ){
			 return mapping.findForward(ROUTE);
		 }else{
			 request.setAttribute(DEALID, id);
			 request.setAttribute(FAILUREMSG, 
					 RouterAction.DEAL + id + HAS_EITHER_BEEN_PROCESSED_ALREADY_OR_NOT_PENDING_FOR_YOUR_ACTION);
			 return mapping.findForward(READ_ONLY);
		 }
	 }
	/**
	 * Return role name as comma seperated string
	 * @param roles
	 * @param roleName
	 * @return
	 * @throws ICFPException 
	 */
	private String getRoles(List<String> roles ) throws ICFPException {
		if(roles == null || roles.size() == 0){
			throw new  ICFPException(HWF_INBOX_1001);
		}
		StringBuilder roleBuilder = new StringBuilder();
		int roleCount = roles.size();
		int counter = 0;
		for(String eachRole : roles) {
			roleBuilder.append(eachRole);
			if(counter < roleCount - 1) {
				roleBuilder.append(",");
			}
		}
		return roleBuilder.toString();
	}
	public ServiceClient getServiceClient() {
		return serviceClient;
	}

	public void setServiceClient(ServiceClient serviceClient) {
		this.serviceClient = serviceClient;
	}
	
	

}

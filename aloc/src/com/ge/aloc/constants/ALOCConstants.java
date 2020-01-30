/*
 * Copyright © 2012-2013 GE. ALL RIGHTS RESERVED.
 * FileName: ALOCConstants.java
 * Purpose: ALOCConstants used for the all the constants.
 */
package com.ge.aloc.constants;

import java.util.regex.Pattern;

public final class ALOCConstants {
	
	public static final String APP_CONFIG_FILE = "aloc";
	
	public static final String PROP_GELIB_ALOC_ADMIN_FOLDERID = "aloc.gelib.admin.folderId";
	// Attachment Meta fields
	public static final String PROP_GELIBMATTR_REQUESTID = "gelib.meta.attr.requestID";
	public static final String PROP_GELIBMATTR_INSTRUMENTTYPE = "gelib.meta.attr.instrumentType";
	public static final String PROP_GELIBMATTR_INSTRUMENTPURPOSE = "gelib.meta.attr.instrumentPurpose";
	public static final String PROP_GELIBMATTR_POLENAME = "gelib.meta.attr.poleName";
	public static final String PROP_GELIBMATTR_CLOSEDDATE = "gelib.meta.attr.closureDate";
	public static final String PROP_GELIBMATTR_SITENAME = "gelib.meta.attr.siteName";
	public static final String PROP_GELIBMATTR_GOLDID= "gelib.meta.attr.LegalEntityGoldId";
	public static final String PROP_GELIBMATTR_USERID= "gelib.meta.attr.userID";

	//constants for screen mode
	public static final String EDIT = "EDIT";
	public static final String VIEW = "VIEW";

	public static final String DashBoard_Y = "Y";
	public static final String DashBoard_N = "N";

	// OPCodes
	public static final String STATICDATA = "STATICDATA";
	public static final String MDM = "MDM";
	public static final String MDMSTATICDATA = "MDMSTATICDATA";
	public static final String MORRATE = "MORRATE";
	public static final String GOLDIDINFO = "GOLDIDINFO";
	

	//public constants
	public static final String SOURCE = "source";
	public static final String MYTASKS = "MYTASKS";
	public static final String SUCCESS = "success";
	public static final String SUCCESSDRAFT = "successDraft";
	public static final String SUCCESSMODEL = "successModel";
	public static final String ACTIONLOGSUCCESS = "actionLogSuccess";
	public static final String ADVANCESEARCHPAGE = "advanceSearchPage";
	public static final String ERROR = "error";
	public static final String ERROR_CAP = "ERROR";
	public static final String FAILUREMSG = "failureMsg";
	public static final String INSERT = "INSERT";
	public static final String SUCCESSMSG = "successMsg";
	public static final String PORTAL_SUCCESSMSG = "portalSuccessMsg";
	public static final String UPDATE = "UPDATE";
	public static final String GET = "GET";
	public static final String SEARCH = "SEARCH";
	public static final String DELETE = "DELETE";
	public static final String SEARCHCRITERIA = "searchCriteria";
	public static final String SEARCHTEXT = "searchText";
	public static final String ACTION = "action";
	public static final String AUDIT = "audit";
	public static final String BANKSITESELECT = "bankSiteSelect";
	public static final String REQUESTID = "requestId";
	public static final String ALOCRECORDNUMBER = "alocrecordNumber";
	public static final String FXRATESXL = "FXRates.xls";
	public static final String DEFVIWPAGE = "defViewPage";
	public static final String CREATEREQUEST = "createRequest";
	public static final String APPROVERAMOUNT = "approverAmount";
	
	public static final String AMENDMENTORRIDERID = "AmendmentOrRiderId";
	public static final String ISRESUBMITPAGE = "isResubmitPage";
	public static final String ISIRREADONLYPAGE = "isIRReadonlyPage";
	public static final String NOTICLAUSEFLAG = "notiClauseFlag";
	public static final String CUREPERIODFLAG = "curePeriodFlag";
	public static final String DRDOWNAPPRFLAG = "drDownApprFlag";

	//Attachments
	public static final String ATTACHMENTS_BY_TYPE = "attachmentsByType";
	public static final String ROLE_BASED_ATTACHMENT_DOWNLOAD = "roleBasedAttachmentDownload";
	public static final String TAXONOMY_REQUEST_ATTACHMENTS = "taxonomyRequestAttachments";
	public static final String TAXONOMY_CLOSURE_ATTACHMENTS = "taxonomyClosureAttachments";
	
	public static final String ATTACHMENT_REQUIRE_EDITS = "atmtRequireEdits";
	public static final String ATTACHMENT_SENDBACK_NOTES = "atmtSendBackNotes";

	//format section  
	public static final String STANDARDFORMAT = "standardFormat";
	public static final String MODIFIEDFORMAT = "modifiedStandardFormat";
	public static final String STANDARD_FORMATTXT = "StandardFormat.doc";
	public static final String MODIFIED_FORMATTXT = "ModifiedStandardFormat.doc";
	public static final String STANDARD_FORMATDOC = "StandardFormat.doc";
	public static final String MODIFIED_FORMATDOC = "ModifiedStandardFormat.doc";
	public static final String ALLOWEDTYPEPDF = "application/pdf";	

	public static final String ID = "id";
	public static final String FORWARD_HOMEPAGE = "homePage";
	public static final String NO = "no";
	public static final String YES = "yes";
	public static final String TRUE = "True";
	public static final String ALL = "all";
	public static final String MM_DD_YYYY = "MM/dd/yyyy";
	public static final String APPLICATION_VND_MS_EXCEL = "application/vnd.ms-excel";
	
	public static final String EN = "en";
	public static final String US = "US";
	public static final String COULD_NOT_FETCH_PROPERTY = "Could not fetch property \'";	
	public static final String ON_BEAN = "\' on bean \'";
	public static final String COULD_NOT_SET_PROPERTY = "Could not set property \'";
	public static final String COULD_NOT_FETCH_PROPERTIES_OF_BEAN = "Could not fetch properties of bean \'";
	public static final String COULD_NOT_CLEAN_BLANK_PROPERTIES_OF_MODEL = "Could not clean blank properties of model \'";
	public static final String WITH_VALUE ="\' with value ";
	public static final String CLASS= "class";
	public static final String META_CLASS= "metaClass";
	public static final String SNPRATING = "SNPRATING";
	public static final String FINALRATING = "FINALRATING";
	public static final String RANGE = "RANGE";
	public static final String TRUE_SMALL = "true";
	public static final String ORIGINALCCYAMOUNT = "originalCCYAmount";
	public static final String YES_CAP = "Yes";
	public static final String NO_CAP = "No";
	public static final String OTHER_SMALL = "Other";
	
	public static final String BANK_NAME = "Bank Name";
	public static final String INCREASE = "Increase";
	public static final String DECREASE = "Decrease";
	public static final String Y_CAP = "Y";
	public static final String N_CAP = "N";

	//Site Admin related Constants
	public static final String OPEN_SITE_PAGE = "openSitePage";
	public static final String SECTION_CONTROLLER_PAGE = "sectionControllerPage";
	public static final String OPEN_SITEADMIN_PAGE = "openSiteAdminPage";
	public static final String OPEN_CREATESITE_PAGE = "openCreateSite";
	public static final String OPEN_ACTIVE_SITE = "openActiveSite";
	public static final String RESULT = "result";
	public static final String VAL = "val";
	public static final String NAMES = "Name";
	public static final String CACHE_CONTROL = "Cache-control";
	public static final String NOCACHE_NOSTORE = "no-cache, no-store";
	public static final String PRAGMA = "Pragma";
	public static final String NO_CACHE = "no-cache";
	public static final String EXPIRES = "Expires";
	public static final String MONE = "-1";
	public static final String SITENAME = "siteName";
	public static final String SITENAMEVAL = "siteNameVal";
	public static final String SITEPREFIX = "sitePrefix";
	public static final String SITEPREFIXVAL = "sitePrefixVal";
	public static final String AVAILBLEAPPROVERS = "availbleApprovers";
	public static final String ALLSELECTEDAPPROVERS = "allSelectedApprovers";
	public static final String COMMA = ",";
	public static final String TILDA = "~";
	public static final String COLON = ":";
	public static final String SEMICOLON_SPACE = "; ";
	public static final String COMMA_SPACE = ", ";
	public static final String NEXT_LINE = "\n";
	public static final String EMPTYSPACE_HYPEN_EMPTYSPACE = " - ";
	public static final String EMPTY_STRING = "";
	public static final String TO = " to ";
	public static final String FEE_PAYMENT_RUN = "Fee Payment Run - ";
	public static final String APMDETAILS_MANAGER_BEAN = "apmDetailsManager";
	public static final String EMPTY_SPACE_STRING = " ";
	public static final String PARENT_SITEID = "parentSiteId";
	public static final String BUSINESS_SITE = "businessSite";
	public static final String CHILD_SITES = "childSites";
	public static final String SITE_CODE = "siteCode";
	public static final String DESIGNATION = "designation";
	public static final String PREFIX = "prefix";
	public static final String DESC = "desc";
	public static final String OPENBUSINESSADMIN = "openBusinessAdmin";
	public static final String OPEN_BUSINESSADMIN_DETAILS = "openBusinessAdminDetails";
	public static final String THIRTY_NINE = "39";
	public static final String GROUP_ID = "groupId";
	public static final String CURRENT_DELEGATES = "currentDelegates";
	public static final String ADMIN_APPROVERS = "adminApprovers";
	public static final String SELECT_SITENAME = "selectSiteName";
	public static final String SECTIONID_COPY = "sectionIdCopy";
	public static final String COPY_SITE = "copySite";
	public static final String AVAILABLEAPPROVERS = "availableApprovers";
	public static final String BUSINESS_SELECTED_APPROVERS = "businessSelectedApprovers";
	public static final String ADMIN_AVAILABLE_APPROVERS = "adminAvailableApprovers";
	public static final String SITE_GROUPS = "siteGroups";
	public static final String SEL_APPROVERS = "selApprovers";
	public static final String ADMIN_INSERT_APPROVERS = "adminInsertApprovers";
	public static final String ADMIN_REMOVE_APPROVERS = "adminRemoveApprovers";
	public static final String COMMA_DELETE = ",DELETE";
	public static final String MODIFY_SITE_TYPE = "modifysiteTypes";
	public static final String SITE_ID= "siteId";
	public static final String MODIFY_SITE = "modifySite";
	public static final String SITE = "Site: ";
	public static final String SITE_CREATE_SUCCESS = " has been saved successfully";
	public static final String SITE_UPDATE_SUCCESS = " has been updated successfully";
	public static final String BUNDLE_CREATE_SUCCESS = "Bundle created successfully";
	public static final String NOT_SUPPORTED_COLLECTION = "This operation is not supported by this collection";
	public static final String SITE_TYPE = "siteType";
	public static final String CREATE_CURRENT_DELEGATES = "createCurrentDelegates";
	public static final String CREATE_ADMIN_APPROVERS = "createAdminApprovers";
	public static final String SHOW_GROUPS = "showGroups";
	public static final String VALID = "Valid";
	public static final String GROUP_VALIDATION_MSG = "More than 20 groups for the same site cannot be created.";
	public static final String OPEN_PORTAL_PAGE = "openPortalPage";
	public static final String DELEGATION_INPUT = "delegationInput";
	public static final String INPUT = "input";
	public static final String DLOC_INPUT = "dLocInput";
	public static final String SB_INPUT = "sbInput";
	public static final String RIDER_INPUT = "riderInput";
	public static final String VALIDATE_AND_SAVE_SECTION = "validateAndSaveSection";
	public static final String SEL_APP = "selApp";
	public static final String DELEGATES = "delegates";

	public static final String APPLY_SECTION = "applySection";
	public static final String BANKGUARANTEE_SECTION_PAGE = "bankGuaranteeSectionPage";
	public static final String DOCLOC_SECTION_PAGE = "docLOCSectionPage";
	public static final String MIMETYPE_TEXT_STRING= "text/string";
	public static final String CURRCODE = "currCode";
	public static final String COUNTRYCODE = "countryCode";
	public static final String VIEWMODEDOCLOC = "viewModeDocLoc";
	public static final String APPLYDOCLOCSECTION = "applyDocLocSection";
	public static final String EDITDOCLOCSECTION = "editDocLocSection";
	public static final String BANKGUARANTEEEDIT = "bankGuaranteeEdit";
	public static final String BANKGUARANTEE_REQUEST_PAGE = "BankGuaranteeRequestPage";
	public static final String LOC_REQUEST_PAGE = "LOCRequestPage";
	public static final String SURETYBOND_REQUEST_PAGE = "SuretyBondRequestPage";
	public static final String DOCUMENT_LOC_REQUEST_PAGE = "DocumentLOCRequestPage";
	public static final String AMENDMENT_REQUEST_PAGE = "AmendmentRequestPage";
	public static final String AUTO_AMENDMENT_REQUEST_PAGE = "AutoAmendmentRequestPage";
	public static final String SURETYBOND_SECTION_PAGE = "suretyBondSectionPage";
	public static final String AMENDMENT_SECTION_PAGE = "AmendmentSectionPage";
	public static final String RIDER_REQUEST_PAGE = "RiderRequestPage";
	public static final String RIDER_SECTION_PAGE = "RiderSectionPage";

	/*
	 * Lookup Action Constants Starts.
	 */
	public static final String LEGALENTITYLOOKUPPAGE = "legalEntityLookupPage";
	public static final String NAMEADDRESSLOOKUPPAGE = "nameAddressLookupPage";
	public static final String BUSINESSCONTACTPERSONLOOKUPPAGE = "businessContactPersonLookupPage";
	public static final String GEREFERENCELOOKUPPAGE = "geReferenceLookupPage";
	public static final String BANKDETAILSLOOKUPPAGE = "bankDetailsLookupPage";
	public static final String REQUESTORLOOKUPPAGE = "requestorLookupPage";
	public static final String BUCVALUE = "bucValue";
	public static final String ADNVALUE = "adnValue";
	public static final String IBSMESSAGE = "IBSMessage";
	public static final String IBSMESSAGEID = "IBSMessageId";
	public static final String CONTACT = "Contact";
	public static final String PHONE = "Phone";
	public static final String CSOVALUE = "csoValue";
	public static final String LEGOLDIDVALUE = "leGoldIdValue";
	public static final String ISCSOLEVALID = "isCSOLEValid";
	public static final String RESULTMESSAGE = "resultMessage";
	public static final String BLOCKEDBUCNAME = "BlockedBUCName";
	public static final String BLOCKEDBUCPHONE = "BlockedBUCPhone";
	public static final String USERDETAILSLOOKUPPAGE = "userDetailsLookupPage";

	///Attachment related CONSTANTS

	public static final Pattern SPL_CHAR_PATTERN = Pattern.compile("[<>:/\\|*'%.+=#]");
	public static final Pattern ALLOWED_CHAR_PATTERN = Pattern.compile("[^\\w@$_&\\s-]");
	public static final String HEADER_CONTENT_DISPOSITION = "Content-Disposition";
	public static final String CONTENT_DISPOSITION_VALUE = "attachment; filename=";

	public static final String  ATTACHMENT = " Attachment ";	
	public static final String  FOR_THE_REQUEST = " for the request "; 
	public static final String  OF_THE_REQUEST = " of the request"; 
	public static final String  CREATED_IN_DATABASE = " has been created successfully in database ";
	public static final String  WITH_ID =  "with ID";
	public static final String  IN_FOLDER = "in Folder ID";
	public static final String  INVALID_ATTACHMENT= "Invalid attachment";
	public static final String  SUCCESSFULLY_UPLOADED = "Successfully uploaded file ";	
	public static final String  UPLOADING_FILE = "Uploading file ";
	public static final String  SUCCESSFULLY_DELETED = " has been deleted successfully.";
	public static final String  WITH_GEFILE_ID = ATTACHMENT +" with GEFileID";
	public static final String  DELETING_FILE = "Deleting the file ";
	public static final String  REPOSITORY_ID_NOT_NULL = "Repository ID should not be null or empty";
	public static final String  SUCCESSFULLY_DELETED_THE_FILE ="Successfully Deleted the file ";
	public static final String  ERROR_DOWNLOADING_FILE ="Error while downloading the file";
	public static final String  OPERATION_NOT_SUPPORT_BY_COLLECTION ="This operation is not supported by this collection";
	public static final String  TESTCASE_FIALED_ERROR_MESSAGE = "Test case failed with error message : ";
	public static final String  ERROR_WHILE_DELETING_FILE= "Error while deleting file from the GE Library:"; 
	public static final String  ERROR_WHILE_CREATING_FILE= "Error while creating the file";
	public static final String  ERROR_CLOSING_STREAM_WHILE_DOWNLOAD_FILE= "Error in closing the response stream while downloading the attachment ";

	public static final String STATUS_SUCCESS = "SUCCESS";	
	public static final String OTHER_ATTACHMENT_SUCCESS = "otherAttachmentSuccess";
	public static final String ISSUER_ATTACHMENT_SUCCESS = "issuerAttachmentSuccess";
	public static final String CLOSURE_ATTACHMENT_SUCCESS = "closureAttachmentSuccess";
	public static final String OPCODE_CREATEREQUEST = "CREATEREQUEST";
	public static final String OPCODE_REQUESTDETAILS = "REQUESTDETAILS";
	public static final String ISSUER_BANKREFNO_EXISTED = "Reference Number Existed";
	public static final String ISSUER_ACTIONS_ERROR_FILED = "requestDetailsBO.attachmentBOList";
	public static final String ISSUER_BANKREFNO_ERROR_MSG = "Bank Reference Number should be unique. Please try again with different number.";
	

	public static final String PARAM_GELIBFILEID = "geLibFileId";
	public static final String PARAM_ATTACHMENT_TYPE = "attachmentType";
	public static final String PARAM_INDEX_ID = "indexId";

	public static final String JSON_PROP_STATUS = "status";
	public static final String JSON_STATUS_SUCCESS = "SUCCESS";
	public static final String JSON_STATUS_FAILURE = "FAIL";
	public static final String JSON_PROP_ERROR_CODE = "errorCode";
	public static final String JSON_PROP_ERROR_MSG = "errorMsg";
	public static final String JSON_PROP_DATA = "data";
	public static final String JSON_PROP_ID = "id";
	public static final String JSON_PROP_NAME = "name";
	public static final String JSON_PROP_PREFIX = "prefix";
	public static final String JSON_PROP_SSOID = "ssoId";
	public static final String JSON_PROP_FIRSTNAME = "firstName";
	public static final String JSON_PROP_LASTNAME = "lastName";
	public static final String JSON_PROP_APPROVE_LEVELID = "approveLevelId";
	public static final String JSON_PROP_LEVELSREQUIRED = "levelsrequired";
	public static final String JSON_AGREEMENT_TYPEID = "agTypeID";
	public static final String JSON_AGREEMENT_TYPENAME = "agTypeName";
	public static final String JSON_DEFEALT_AGREEMENT_TYPEID = "defaultagID";
	public static final String JSON_PROP_GROUPNAME = "groupName";
	public static final String RESOURCE_TYPE = "resourceType";
	public static final String GLOSSARY = "glossary";
	public static final String USER_MANUAL = "userManual";

	public static final String DEFAULT_VIEW = "defaultView";

	public static final String FILTER_VALUE = "filterValue";
	public static final int PAGE_INCREMENT = 100;
	public static final String BONDTYPE = "bondType";
	public static final String WINNINGBANK = "WinningBank";
	public static final String ISSUINGBANKBRANCH = "IssuingBankBranch";
	public static final String BANKREFNUM = "BankReferenceNumber";
	public static final String BANKNAMES = "BankNames";
	public static final String LOADNONSUBMITBUNDLES = "loadNonSubmitBundles";
	public static final String LOOKUPNUM = "lookUpNumber";
	public static final String DOC_BUSINESS_CONTACT_PERSON = "documentBusinessConatctPerson";
	public static final String DATEFORAMTE = "ddhhmmss";
	public static final Object HYPEN = "-";
	public static final Object EQUAL = "=";
	public static final String REQUESTID_EQUALS = "requestId=";
	public static final String REFERER ="referer";
	public static final String EMAIL_REQUEST = "emailRequest";
	public static final int EMAIL_REQUEST_LENGTH = 2;
	public static final String EMAIL_TAXONOMY_REQUEST = "emailTaxonomyRequest";
	public static final String OUTSTANDING = "OUTSTANDING";
	public static final String TAXONOMY_ATTACHMENTS = "taxonomyAttachments";
	public static final String INSIDEUS = "insideUS";
	public static final String OUTSIDEUS = "outsideUS";
	public static final String SLOC = "sloc";
	public static final String BG = "bg";
	public static final String DD_MM_YYYY = "dd/MM/yyyy";
	public static final String ECONOMOICEXPIRYDATE = "econoExpiryDt";
	public static final String EXPIRYDATE = "expiryDt";
	public static final String OPENREQUESTOR = "requestor";
	public static final String OPENAMENDMENTREQUESTOR = "amendmentRequestor";
	public static final String OPENRIDERREQUESTOR = "riderRequestor";
	public static final String SELECTED_APPROVERS = "selectedApprovers";
	public static final String OPENBUSINESSAPPROVER = "businessapprover";
	public static final String OPENTREASURYANALYST = "treasuryAnalyst";
	public static final String OPENTREASURYAPPROVER = "treasuryApprover";
	public static final String OPENTREASURYBIDMEMO = "treasuryBidMemo";
	public static final String HISTORICAL_TAB = "historicalTab";
	public static final String OPENPOSTAWARD="postAward";
	public static final String OPENTREASURYBIDREPLY = "treasuryBidReply";
	public static final String EFFECTIVEDT = "effectiveDt";
	public static final String EXPIRATIONDT ="expirationDt";
	public static final String OPENTREASURYBIDISSUE = "treasuryBidIssue";
	public static final String TREASURYBIDAWARD = "treasuryBidAward";
	public static final String RIGHT_BANK_RECORDS = "rightBankRecords";
	public static final String BID_MEMO = "BIDMEMO";
	public static final String NEW_MEMO = "NEWMEMO";
	public static final String BID_REPLY = "BIDREPLY";
	public static final String EVL_REPLY = "EVLREPLY";
	public static final String PRICING_ACCEPT_FLAG = "Y";
	public static final String PRICING_REJECT_FLAG = "N";
	public static final String ANLAPROV = "ANLAPROV";
	public static final String SENDBACK = "SENDBACK";
	public static final String TAXONOMY = "Taxonomy";	
	public static final String APPLICATION = "Application";
	public static final String BIDREPLY = "BidReply";
	public static final String TREASURYAPPROVER = "TreasuryApprover";
	public static final String PRICINGACCEPT = "Accept";
	public static final String PRICINGREJECT = "Reject";
	public static final String AMENDMENTS = "AMENDMENTS";
	public static final String OPENREQUEST = "OPENREQUEST";
	public static final String AUDITLOG = "AUDITLOG";
	public static final String TRANSACTIONLOG = "TRANSACTIONLOG";
	public static final String RIDERS = "RIDERS";
	public static final String LINKTRANSACTIONS = "LINKTRANSACTIONS";
	public static final String BUNDLETRANSACTIONS = "BUNDLETRANSACTIONS";
	public static final String FEEHISTORY = "FEEHISTORY";
	public static final String COMBIDREPLIES = "COMBIDREPLIES";
	public static final String CURRBANKFEE = "CURRBANKFEE";
	public static final String ISSUER = "issuer";
	public static final String CLOSURE = "closure";
	public static final String UPDATEDATA = "UPDATEDATA";
	public static final String UPDATE_REPORTING_DATA = "updateReportingData";
	public static final String REREQUEST = "reRequest";
	public static final String UPDATETAXONOMY = "updateTaxonomy";
	public static final String FORMATTYPE = "formatType";
	public static final String SAVECURRBANKFEES = "saveCurrBankFees";
	public static final String FORMAT = "Format";


	//Surety Name Management Constants
	public static final String EDITSURETYSUCCESS = "editSuretySuccess";
	public static final String INSURTSURETY = "insert";
	public static final String UPDATESURETY = "update";
	public static final String DELETESURETY = "delete";
	public static final String SURETYID = "suretyId";
	public static final String SURETYNAME = "suretyName";
	public static final String SURETYSTATUS = "suretyStatus";
	public static final String SURETYNAMES = "SuretyNameList";
	public static final String GETSURETYSUCCESS = "openDeleteSuccess";
	public static final String UPDATESURETYSUCCESS = "updateCancelSuccess";
	public static final String ADDSURETYSUCCESS = "addEditSuccess";
	public static final String SURETYNAMEVAL = "suretyNameVal";
	public static final String SURETYEXISTS = "SuretyExists";
	public static final String SURETYMASSTATUS = "suretyMaster.suretyStatus";
	public static final String SURETYMASSURID = "suretyMaster.suretyId";
	public static final String SURETY_ERROR ="Error while retreiving Surety Name Details";
	public static final String SURETYNAME_LENGTH="100";

	//Pole Name Management Constants
	public static final String POLEID = "poleId";
	public static final String POLENAME = "poleName";
	public static final String POLESTATUS = "poleStatus";
	public static final String POLENAMES = "PoleNameList";
	public static final String GETPOLESUCCESS = "openDeletePoleSuccess";
	public static final String UPDATEPOLESUCCESS = "updateCancelPoleSuccess";
	public static final String ADDPOLESUCCESS = "addPoleSuccess";
	public static final String POLENAMEID = "poleNameMgmt.poleId";
	public static final String POLE_ERROR ="Error while retreiving Pole Name Details";

	//Block BUC Management Constants
	public static final String BUCID = "bucId";
	public static final String ADNID = "adnId";
	public static final String SEARCHSUCCESS = "searchSuccess";
	public static final String UNBLOCKSUCCESS = "unBlockSuccess";
	public static final String BLOCKBUCLIST = "businessUnitCodeList";
	public static final String ALLADN="ALL";
	public static final String BLOCKBUCMETHOD = "blockBUC";
	public static final String BLOCKBUCADN = "BUCADN";
	public static final String ADDBLOCKBUC = "addBlockBUCSuccess";
	public static final String INVALIDBUCFEILD = "addBlockBUCSuccess";

	//Surety Name Management Constants
	public static final String GETFEEHISTORY = "editSuretySuccess";

	//bundle related constants
	public static final String SUCCESSMODAL = "modal";
	public static final String BUNDLEID = "bundleId";
	public static final String AMP_BUNDLEID = "amp;bundleId";
	public static final String GETBUNDLE="GETBUNDLES";
	public static final String BUNDLESEARCH ="BUNDLESEARCH";

	//link related constants
	public static final String LINKID = "linkId";
	public static final String REQUEST_ID = "requestId1";
	public static final String DV_SUCCESS_MSG = "Default View Saved Successfully";
	public static final String TRACKCHANGES = "trackSectionId";
	public static final String EDITSECTIONLIST = "editSectionList";
	public static final String FALSE = "false";  

	//Search and Advance Search
	public static final String SITEID = "siteId";
	public static final String SEARCHCRITERIATYPE = "searchCriteriaType";
	public static final String SEARCHCRITERIATEXT = "searchCriteriaText";
	public static final String ADVANCESEARCHCRITERIATEXT = "advanceSearchCriteriaText";
	public static final String DASHBOARDTYPE = "dashboardType";
	public static final String SUBMIT = "submit";
	public static final String DOWNLAODPDF = "downloadPDFFile";
	public static final String AWARDSUBMIT = "selectWinnerForBidAward";
	public static final String FINANCECHECK="financialCheck";
	public static final String INDUSTRIALCHECK="industrialCheck";
	public static final String SEARCH_DOT = "Search...";
	public static final String CONTACTPERSONNAME = "businessContactPersonName";
	public static final String BANK_ISSUE = "Bank Issue";
	
	public static final String SEARCH_ADN = "ADN: ";
	public static final String SEARCH_ALOC_RECORD_NO = "ALOC Record Number: ";
	public static final String SEARCH_APPLICANT_NAME = "Applicant Name: ";
	public static final String SEARCH_BANK_REF_NO = "Bank Reference number: ";
	public static final String SEARCH_BENEFICIARY_NAME = "Beneficiary Name: ";
	public static final String SEARCH_BUC = "BUC: ";
	public static final String SEARCH_CURRENCY = "Currency: ";
	public static final String SEARCH_FOREIGN_EXP_DATE = "Foriegn expiry date: ";
	public static final String SEARCH_INSTRUMENT_AMOUNT = "Instrument Amount: ";
	public static final String SEARCH_FROM_INSTRUMENT_AMOUNT = "Instrument Amount-From: ";
	public static final String SEARCH_TO_INSTRUMENT_AMOUNT = "Instrument Amount-To: ";
	public static final String SEARCH_PAYMENT_AMT_GT = "Payment amount greater than: ";
	public static final String SEARCH_PAYMENT_BANK = "Payment bank: ";
	public static final String SEARCH_PAYMENT_CURRENCY = "Payment currency: ";
	public static final String SEARCH_PAYMENT_DATE = "Payment date: ";
	public static final String SEARCH_FROM_PAYMENT_DATE = "Payment date-From: ";
	public static final String SEARCH_TO_PAYMENT_DATE = "Payment date-To: ";
	public static final String SEARCH_STATE_COUNTRY = "State,Country of issuance: ";
	public static final String SPACE_AND_SPACE = " and ";
	public static final String FEEHISTORY_SEARCH = "FeeHistorySearch";	

	//TimeBO constants
	public static final String AM = "AM";
	public static final String PM = "PM";
	

	public static final String AMENDMENT = "AMENDMENT";
	public static final String RIDER = "RIDER";

	//Admin Portal Related Constants
	public static final String PORTALLINKTYPE = "portalLinkType";
	public static final String FORMATPAGE = "standardFormatPage";
	public static final String STANDARDGEFORMAT = "GE Standard Format";
	public static final String STANDARDFORMATDATE = "MMM-dd-yyyyHH:mm";
	public static final String CSV_DATEFORMAT = "MMM-dd-yyyy-HHmmss";
	public static final String GESTANDARDFORMATMANAGEMENT = "getStdFormatManagement";
	public static final String OPENREIMBURSEMENTLIST = "openReimbursementAgreement";
	public static final String STANDARDFORMATDATA = "standardFormatData";
	public static final String REIMBURSEMENTDATA = "reimbursementData";
	public static final String EFFECTED_TRANCATIONS = " Effected Transactions  : ";
	public static final String EFFECTED_SITES = " Effected Sites  : ";

	//Model Maintenance Constants
	public static final String BANKGUARANTEE_MODEL_REQUEST_PAGE = "BankGuaranteeModelRequestPage";
	public static final String LOC_MODEL_REQUEST_PAGE = "LOCModelRequestPage";
	public static final String SURETYBOND_MODEL_REQUEST_PAGE = "SuretyBondModelRequestPage";
	public static final String MODEL_REQUEST_ID = "requestId";
	//Reports Constants
	public static final String ALLSITELIST = "allSiteList";
	public static final String ALLBANKLIST = "allBankList";
	public static final String REPORTSBANKSLIST = "reportsBankList";
	public static final String BUSINESSCONTACTLIST = "businessContactList";
	public static final String ADDRESSSDTLSLIST = "addrressDetailsList";
	public static final String FINANCIAL_BUSINESS = "Financial Business";
	public static final String INDUSTRIAL_BUSINESS = "Industrial Business";
	public static final String FINANCIAL = "Financial";
	public static final String CONTIGENT_REPORT_XLSFILE = "ContigentReport.xls";
	public static final String CONTIGENTLIABILITYPATH = "ContigentLiability-";
	public static final String MOR_RATE = "MOR";
	public static final String BLOOMBERG_RATE = "BLOOMBERG";
	public static final String XLSFILE = ".xls";
	public static final String SELECTEDCURRENCY = "selectedCurrency";
	public static final String SELECTEDNOMONTHS = "selectedNoMonths";
	public static final String SINGLEQUOTE_STIRNG = "'";
	public static final String REPORTCURRENCY = "REPORTCURRENCY";
	public static final String INSTRUMENT_TYPES = "instrumentTypes";
	public static final String INSTRUMENT_PURPOSE_ID = "instrumentPurposeId";
	
	//Reports URL Constants
	public static final String ALOC_SPOTFIREURL_SERVER = "ALOC_SpotfireURL_SERVER";
	public static final String ALOC_DOMAIN_URL = "ALOC_Domain_URL";
	public static final String ALOC_CONTIGENT_LIABILITY_URL= "ALOC_Contigent_Liability_URL";
	public static final String ALOC_CONTIGENT_BUC_URL = "ALOC_Contigent_BUC_URL";
	public static final String ALOC_ISSUANCE_EXPIRATION_URL= "ALOC_ISSUANCE_EXPIRATION_URL";
	public static final String ALOC_CYCLETIME_URL= "ALOC_CYCLETIME_URL";
	public static final String ALOC_BIDSUCCESS_URL= "ALOC_BIDSUCCESS_URL";
	public static final String ALOC_AVG_FEESPAID_URL = "ALOC_AVERAGEFEEPAID_URL";
	public static final String ALOC_BIDSUCCESS_GRAPH_URL = "ALOC_BIDSUCCESS_GRAPH_URL";
	public static final String ALOC_GCFO_URL= "ALOC_GCFO_URL";
	public static final String ALOC_ECSO_URL= "ALOC_ECSO_URL";
	public static final String ALOC_USER_URL= "ALOC_USER_URL";
	public static final String ALOC_FEESPAID_SP_URL= "ALOC_FEESPAID_SP_URL";
	public static final String ALOC_FEESPAID_GRAPH_URL= "ALOC_FEESPAID_GRAPH_URL";
	public static final String ALOC_FEESPAID_GRAPH1_URL= "ALOC_FEESPAID_GRAPH1_URL";
	public static final String ALOC_AGING_URL= "ALOC_AGING_URL";
	public static final String ALOC_FEEQUOTE_URL = "ALOC_FEEQUOTE_URL";
	public static final String ALOC_FEEPROJECTION_URL = "ALOC_FEEPROJECTION_URL";
	
	public static final String CONTIGENT_REPORT_TEMPLATE_LOCATION = "templates/ContigentLiabilityReport.xls";
	public static final String AGING_REPORT_TEMPLATE_LOCATION ="templates/AgingReport.xls"; 
	public static final String BIDSUCCESS_REPORT_TEMPLATE= "templates/BidSuccessReport.xls";
	public static final String CYCLETIME_REPORT_TEMPLATE= "templates/CycleTimeReport.xls";
	public static final String ECSO_REPORT_TEMPLATE= "templates/ECSOReport.xls";
	public static final String FEEPAID_REPORT_TEMPLATE= "templates/FeesPaidReport.xls";
	public static final String GCFO_REPORT_TEMPLATE= "templates/GCFOReport.xls";
	public static final String ISSUANCEEXPIRATION_REPORT_TEMPLATE= "templates/IssuanceExpirationReport.xls";
	public static final String USER_REPORT_TEMPLATE= "templates/UserReport.xls";
	public static final String FEEQUOTATION_REPORT_TEMPLATE= "templates/FeeQuotationReport.xls";
	public static final String AVERAGEFEEPAID_REPORT_TEMPLATE = "templates/AverageFeePaidReport.xls"; 
	public static final String FEEPROJECTION_REPORT_TEMPLATE = "templates/FeeProjectionReport.xls";
	public static final String CONTIGENT_REPORT_EXT_TEMPLATE_LOCATION = "templates/ContigentLiabilityReport2.xls";

	public static final String CYCLETIMEREPORT = "Cycle Time Report";
	public static final String BIDSUCCESSREPORT = "Bid Success Report";
	public static final String AGINGREPORT = "Aging Report";
	public static final String FEESPAIDREPORT = "Fees Paid Report";
	public static final String ISSUANCEEXPIRATIONREPORT = "Issuance and Expiration Report";
	public static final String ECSOREPORT = "ECSO Report";
	public static final String GCFOREPORT = "GCFO Report";
	public static final String USERREPORT = "User Report";
	public static final String FEEQUOTATIONREPORT = "Fee Quotation and Forcast Report";
	public static final String ISREPORTSFLAG = "isReports";
	public static final String AVERAGEFEESPAIDREPORT = "Avg Fees Paid Report";
	public static final String FEEPROJECTIONREPORT = "Fee Projection Report";
	public static final String CONTINGENTREPORT = "Contingent Report";
	public static final String MONTHS = "Months";

	//APM module related constants
	public static final String ALOC_RECORD_NUMBER = "ALOCRecordNumber";
	public static final String FXRATEHISTORY = "FXRATEHISTORY";
	public static final String CURRENCYSETUP = "CURRENCYSETUP";
	public static final String UPDATEDBUCID ="updatedBUCVal";
	public static final String UPDATEDADNID ="updatedADNVal";
	public static final String FEEPERIODID="feePeriodId";
	public static final String FORMATEPATTERN="MM/dd/yyyy";
	public static final String FORMAT_INV_PATTERN="dd MMM yyyy";
	public static final String CONTENTDESC="Content-Disposition";
	public static final String ATTACHMENTFILE="attachment; filename=\"";
	public static final String SLASH="\"";
	public static final String XLPATH="templates/FXRateReport.xls";
	public static final String FXRATEEXCEPTION="exception occured while writing fx rates to xl";
	public static final String PAYMENT_PERIOD_DETAILS="PaymentPeriodDetails";
	public static final String FXRATE_YEAR="fxRateYearList";
	public static final String CURRENCY_SETUP_DETAILS="CurrencySetUpDetails";
	public static final String FXRATEHISTORY_DETAILS="FxRateHistoryDetails";
	public static final String CURINDEX="curIndex";
	public static final String CSV_REPORTS = "Payment Run CSV file.xls";
	public static final String FEEHISTORY_CSV = "FeeHistory_CSV.xls";
	public static final String CREDITS_CARRYOVERS_EXPORT = "CreditsandCarryOversReport.xls";
	public static final String SB_APPLICATION_CSV = "SuretyBond.xls";
	public static final String RIDER_APPLICATION_CSV = "SuretyRider.xls";
	public static final String SB_CSV_XLPATH="templates/Surety bond Application.xls";
	public static final String RIDER_CSV_XLPATH="templates/Surety Rider Application.xls";
	public static final String CSV_XLPATH="templates/Payment Run CSV file.xls";
	public static final String CREDITS_XLPATH="templates/CreditsandCarryOversReport.xls";
	public static final String BOOKMARKS_REPLACEMENT_EMPTY_DOCUMENT="templates/empty.doc";
	public static final String CALCULATE_FEE_DETAILS = "CalculateFeeDetails";
	public static final String USERSPECIFICSITES = "userSpecificSites";
	public static final String FEE_HISTORY_DETAILS = "FeeHistoryDetails";
	public static final String FXFROMYEAR="FXfromyear";
	public static final String FXTOYEAR="FXtoyear";
	public static final String FEE_PAYMENT_RUN_DETAILS = "FeePaymentRunDetails";
	public static final String BANK_MDMID = "bankMDMId";
	public static final String BANNK_NAME = "bankName";

	public static final String CURRENCY_CONFIG_ID="currencyConfigId";
	public static final String CUR_CODE="curCode";
	public static final String RATE_DIRECTION="rateDirection";
	public static final String TICKER_SYMBOL="tickerSymbol";
	public static final String DECIMAL_PRECISION="decimalPrecision";
	public static final String APM_PAYMENT_CUR_FLAG="APMPaymentCurrencyFlag";
	public static final String BUC="BUC";
	public static final String ADN="ADN";
	public static final String CURR_NAME="currName";
	public static final String MULTIPLY="Multiply";
	public static final String DIVIDE="Divide";
	public static final String M="M";
	public static final String D="D";
	public static final String Y="Y";
	public static final String N="N";
	public static final String CONFIG_ID="configId";
	public static final String DEF_VIEW_TYPE="defViewType";
	public static final String TOP_LEVEL="topLevel";
	public static final String DOMESTICS="domestic";
	public static final String DOMESTIC = "DOMESTIC";
	public static final String FORIGNS = "foreign";
	public static final String FOREIGN = "FOREIGN";
	public static final String FULL = "full";
	public static final String FULLSUMMARY = "FULLSUMMARY";
	public static final String CURRENCY_ERROR ="Error while retreiving Currency Setup Details";

	public static final String APM_INVOICE_XLS="APM Invoice.xls";
	public static final String TEMPLATESOR_APM_INVOICE_TEMP = "templates/APM Invoice Template.xls";
	public static final String APM_INVOICE_TEMPLATE = "templates/Fee Research Invoice.xls";
	public static final String APM_INVOICE_DATEFORMAT = "MMyy";
	public static final String APM_FEEHISTORY_XLS="Fee History.xls";
	public static final String TEMPLATE_APM_FEEHISTORY = "templates/Fee History.xls";

	public static final String PAYMENT_IDS = "paymentsIds";
	public static final String PAYMENT_ID = "PaymentId";
	public static final String ALOC_REC_NOS = "alocRecNos";
	public static final String MOD = "Mod";
	public static final String INVOICE_IOERROR_MSG = "IO error while downloading FeeHistory details";
	public static final String INVOICE_ERROR_MSG = "Error while downloading FeeHistory details";
	public static final String INVOICE_CLOSING_ERRORMSG = "Error in closing the stream while downloading FeeHistory details";

	public static final String STARTDATE="startdate";
	public static final String STARTDATEONE="startdateTwo";
	public static final String ENDDATE="enddate";
	public static final String ENDDATEONE="enddateTwo";
	public static final String REVALUEDATE="reValuedate";
	public static final String REVALUEDATEONE="reValuedateTwo";
	public static final String CUTOFDATE="cutOfdate";
	public static final String CUTOFDATEONE="cutOfdate";
	public static final String USDAMOUNT="usdamount";
	public static final String USDAMOUNTONE="usdamountTwo";
	public static final String DAYCOUNT="dayCount";
	public static final String DAYCOUNTONE="dayCountTwo";
	public static final String PAYMENT_CONFIG_ID="configID";
	public static final String PAYMENT_CONFIG_IDONE="configIDTwo";
	public static final String PAYMENT_DATEPATTERN="dd MMM yyyy";
	public static final String FEE_HISTORY_DATEPATTERN="dd MMM yyyy";
	public static final String IBSFILE="ibsFile";
	public static final String WEBCASHFILE="webcashFile";
	public static final String STATICDATAREFRESHONCACHE = "Refreshing static data on the cache";
	public static final String SAVE_PAYMENTPERIOD = "savePaymentPeriod";
	public static final String GETYEARS="GETYEARS";
	public static final String FILTERPERIODS="FILTERPERIODS";
	public static final String DOWNLOADFXRATES="DOWNLOADFXRATES";
	public static final String APMCONFIGID ="apmConfigID";
	public static final String NA ="N/A";
	public static final String APMSEARCH="Search...";
	public static final String CURR_BANKFEES_SUCCESS_MSG = "Current Bank Fees has been saved successfully";

	// instrument Names
	public static final String BANKGUARANTEE = "Bank Guarantee";
	public static final String STANDBY_LETTER_OF_CREDIT = "Standby Letter Of Credit";
	public static final String SURETY_BOND = "Surety Bond";
	public static final String DOCUMENTARY_LETTER_OF_CREDIT_CONFIRMATION = "Documentary Letter Of Credit Confirmation";

	//Standard Format Management Screen	
	public static final String FORMATAUDITTRAILID = "auditTrailId";
	public static final String INSTRUMENT_TYPE_ID = "typeId";
	public static final String STANDARDFORMATID = "standardFormatId";
	public static final String FILEEXTENSIONS = "Wrong file type, .DOC, .PDF Extensions are valid.";
	public static final String ADD = "add"; 	
	public static final String AGREEMENTLIST = "agreementList";	

	public static final String SUCCESSFULLY_EXPORTED_THE_PDF_FOR_REQUEST = "Successfully Exported the PDF for Request ";
	public static final String EXPORTING_PDF_FOR_REQUEST = "Exporting PDF for Request ";

	//treasuryAdminPortal
	public static final String TREASURYADMINPORTAL = "treasuryAdminPortal";
	public static final String RECORDSRETENTION = "recordsRetention";
	public static final String RECORDSRETENTIONAPPR = "recordsRetentionAppr";
	public static final String RETENTIONVALUES ="retentionsValues";
	public static final String OPENPERGEREPORT ="openRecordsPurgeReport";
	public static final String USERANNCOUNCEMENT ="userAnnouncement";
	public static final String OPENRETENTIONMGNT ="openRecordsRetentionManagement";
	public static final String USERANNOUCEMENTROLES ="userAccnoucementRoles";
	public static final String ACTIVEANNOUNCEMENTS ="activeAnnouncements";
	public static final String ANNOUNCEMENTTYPE ="announcementType";
	public static final String ACTIVEANNOUNCEMENTINDEX ="activeAnnouncementIndex";
	public static final String USERANNOUNCEMENTID ="userAnnouncementId";
	public static final String OPEN_REIMBURSEMENT_PAGE = "openReimbursementPage";
	public static final String RETENTION_UPDATE_SUCCESS = "Record retention has been saved successfully";
	public static final String USER_ANNOUNCEMENT_SUCCESS = "User Announcement has been saved successfully";
	public static final String AMENDMENT_SUCCESS_MSG = "Amendment has been saved successfully";
	public static final String STANDARD_FMT_SUCCESS_MSG = "Standard format management template has been saved successfully";
	public static final String REIMBURSEMENT_AGMT_SUCCESS_MSG = "Reimbursement agreement has been saved successfully";

	public static final String SWIFTMSGMONITOR ="swiftMsgMonitor";
	public static final String SWIFTSEARCH ="swiftSearch";
	public static final String SWIFTRESEND ="reSend";
	public static final String APPROVE ="Approve";
	public static final String REJECT ="Reject";
	public static final String SWIFT ="SWIFT";
	
	//amendment workflow management
	public static final String UPDATEAMENDMENTAMONT = "update";
	public static final String AMENDMENTWORKFLOWMGT = "amendmentWorkflowMgmt";
	public static final String BUSINESSHOMEPAGE = "businessHomePage";
	public static final String TREASURYHOMEPAGE = "treasuryHomePage";
	public static final String BANKHOMEPAGE = "bankHomePage";
	public static final String BROKERHOMEPAGE = "brokerHomePage";

	public static final String LESSTHAN = "< ";
	public static final String GREATETHAN = " > ";
	public static final String CONTRACTBONDS = "ContractBonds";

	//Dashboard Tab Return
	public static final String MYTRANSACTIONS_TAB = "MyTransactionTab";
	public static final String ALLREQUESTS_TAB = "AllRequestTab";
	public static final String DRAFTS_TAB = "DraftTab";
	public static final String BANKBID_TAB = "BankBidTab";
	public static final String BANKPENDINGISS_TAB = "BankPendingIssTab";
	public static final String BANKHISTTRANS_TAB = "BankHistoricTransTab";
	public static final String MYTRANSACTION = "MYTRANSACTIONS";
	public static final String ALLREQUESTS = "ALLREQUESTS";

	// DashBoard glance Constants
	public static final String GLANCEPARAM = "glanceParam";
	public static final String BID = "BID";
	public static final String PERFORMANCE="PERFORMANCE RETENTION AND OTHER";
	public static final String  FINANCIALS="FINANCIAL";
	public static final String ADVANCE_PAYMENT="ADVANCE PAYMENT";
	public static final String GLANCE_DETAILS="glanceDetails";
	public static final String DASHBOARD_TABS_COUNT="dashBoardTabsCount";
	public static final String DASHBOARD_HEADEROPCODE="msgHeader";
	public static final String DASHBOARD_USERANOUNCEMENT="inboxUserAnnouncements";
	public static final String IS_FINANCIAL_BUSINESS="isFinancialBusiness";
	public static final String IS_INDUSTRIAL_BUSINESS="isIndustrialBusiness";

	//EAS Constants
	public static final String USER_ID = "userId";
	public static final String USER_ID_VALID = "userIdVal";
	public static final int NUM_THREE = 3;
	public static final int NUM_ZERO = 0;
	public static final int NUM_ONE  = 1;
	public static final String USER_BANK  = "UserBank";
	public static final int NUM_FOUR = 4;
	
	//ValidateAmendmentRider
	public static final String AMENDRIDEROPTION = "amendRiderOption";
	public static final String AMENDRIDERVALUE = "amendRiderValue";
	public static final String ALOCRECORDNO = "AlocRecordNo";
	public static final String INSTRUMENTTYPE = "InstrumentType";
	public static final String INSTRUMENTTYPEID = "InstrumentTypeId";
	public static final String HELP_FILE_TYPE = "helpFileType";
	public static final String WFSTAGE = "WFStage";
	public static final String WFSTAGEID = "WFStageId";
	public static final String ISSUERREFERENCENUMBER = "issuerReferenceNumber";
	public static final String ALOCRECNO = "alocRecNo";
	public static final String BANKREFERENCENUMBER = "bankReferenceNumber";
	public static final String BONDREFERENCENUMBER = "bondReferenceNumber";

	//Validate Close Transaction
	public static final String CLOSETRANSOPTION = "closeTransOption";
	public static final String CLOSETRANSVALUE = "closeTransValue";
	public static final String WFID = "wfid";
	public static final String QUEUENAME = "queueName";
	public static final String PROCEDURENAME = "procedureName";
	public static final String LOGTYPE="logType";

	// EAS User Operations constants
	public static final String BNK_NAME_USR_ROLE_SEP = "#";
	public static final String MSG_USER_CREATED_SUCCESS = "user.created.success";
	public static final String MSG_USERID_EMAIL_SUCCESS = "email.userIdAndPassword.success";
	public static final String MSG_PASSWORD_RESET_SUCCESS = "password.reset.success";
	public static final String EAS_MAIL_ADDRESS = "easDetails.easCredentials.emailAddress";
	public static final String EAS_USERID = "easDetails.easCredentials.userId";
	public static final String USERID = "UserID";
	public static final String USER = "USER";

	//GLOSSAY CONSTANTS
	public static final String BG_ATTACHMENT_NAME ="BG_ATTACHMENT_NAME";
	public static final String BG_FILE_ID="BG_FILE_ID";
	public static final String SBLC_ATTACHMENT_NAME="SBLC_ATTACHMENT_NAME";
	public static final String SBLC_FILE_ID="SBLC_FILE_ID";
	public static final String SB_ATTACHMENT_NAME="SB_ATTACHMENT_NAME";
	public static final String SB_FILE_ID="SB_FILE_ID";
	public static final String DLOC_ATTACHMENT_NAME="DLOC_ATTACHMENT_NAME";
	public static final String DLOC_FILE_ID="DLOC_FILE_ID";
	
	//HELP FILE CONSTANTS
	public static final String BANKFEEPAYMENT_HELP_FILE_NAME ="BANKFEEPAYMENT_HELP_FILE_NAME";
	public static final String BANKFEEPAYMENT_HELP_FILE_ID="BANKFEEPAYMENT_HELP_FILE_ID";
	public static final String SURETYBONDFEEPAYMENT_HELP_FILE_NAME ="SURETYBONDFEEPAYMENT_HELP_FILE_NAME";
	public static final String SURETYBONDFEEPAYMENT_HELP_FILE_ID="SURETYBONDFEEPAYMENT_HELP_FILE_ID";
	public static final String FEECALCULATIONSAMPLE_HELP_FILE_NAME="FEECALCULATIONSAMPLE_HELP_FILE_NAME";
	public static final String FEECALCULATIONSAMPLE_HELP_FILE_ID="FEECALCULATIONSAMPLE_HELP_FILE_ID";
	public static final String GLOSSARY_HELP_FILE_NAME="GLOSSARY_HELP_FILE_NAME";
	public static final String GLOSSARY_HELP_FILE_ID="GLOSSARY_HELP_FILE_ID";
	public static final String POLICY_HELP_FILE_NAME="POLICY_HELP_FILE_NAME";
	public static final String POLICY_HELP_FILE_ID="POLICY_HELP_FILE_ID";
	public static final String FORMATRESDFLAGS_HELP_FILE_NAME ="FORMATRESDFLAGS_HELP_FILE_NAME";
	public static final String FORMATRESDFLAGS_HELP_FILE_ID="FORMATRESDFLAGS_HELP_FILE_ID";
	public static final String PARTICIPATINGBANKS_HELP_FILE_NAME="PARTICIPATINGBANKS_HELP_FILE_NAME";
	public static final String PARTICIPATINGBANKS_HELP_FILE_ID="PARTICIPATINGBANKS_HELP_FILE_ID";	
	public static final String BANKSFORTPT_HELP_FILE_NAME="BANKSFORTPT_HELP_FILE_NAME";
	public static final String BANKSFORTPT_HELP_FILE_ID="BANKSFORTPT_HELP_FILE_ID";
	public static final String PRIVATEBANKS_HELP_FILE_NAME="PRIVATEBANKS_HELP_FILE_NAME";
	public static final String PRIVATEBANKS_HELP_FILE_ID="PRIVATEBANKS_HELP_FILE_ID";
	public static final String SITEADMINS_HELP_FILE_NAME="SITEADMINS_HELP_FILE_NAME";
	public static final String SITEADMINS_HELP_FILE_ID="SITEADMINS_HELP_FILE_ID";	
	public static final String USERMANUAL_HELP_FILE_NAME="USERMANUAL_HELP_FILE_NAME";
	public static final String USERMANUAL_HELP_FILE_ID="USERMANUAL_HELP_FILE_ID";
	public static final String USERROLES_HELP_FILE_NAME="USERROLES_HELP_FILE_NAME";
	public static final String USERROLES_HELP_FILE_ID="USERROLES_HELP_FILE_ID";
	
	public static final String BID_REPLY_FLAG = "Bid";
	public static final String BUNDLE_USD_CURRENCY = "USD";
	public static final String AMDAMOUNT = "amdData";
	public static final String BID_ISSUE = "bidIssue";
	
	public static final String ALOC_UNDERSCORE = "aloc-";
	public static final String DOCS_ZIP = "-docs.zip";
	public static final String HELP = "Help";
	public static final String ZIP_EXTENSION = ".zip";
	public static final String PDF_EXTENSION = ".pdf";
	public static final String UNDERSCORE = "_";
	public static final String ERROR_WHILE_DOWNLOADING_THE_FILE = "Error while downloading the files";
	public static final String AS_ZIP = " as ZiP";
	public static final String ERROR_WHILE_CLOSING_ZIPOUTPUT_STREAM = "Error while closing the ZipOutputStream while handling the request for the files";
	public static final String GLANCECOUNT="glancecount";
	
	public static final String OBLIGEE = "Obligee";
	public static final String PRINCIPAL = "Principal";
	public static final String TPAPPLICANT = "tpApplicantDetails";
	public static final String CUSTOMER = "customer";
	public static final String APPLICANT = "Applicant";
	public static final String CUSTBENFICIARY = "CustBenficiary";
	public static final String SHIPMENTCOUNTRY = "instShipCountry";
	public static final String ORIGINGOODS = "instOriginGoods";
	public static final String BUCONTACTPERSON = "buContactPerson";
	public static final String PERCENTAGE = "%";
	public static final String PREVIOS_FORMAT_TYPEID = "formatTypeId";
	public static final String BANKBIDPROCESS = "bankBiddashboard";
	public static final String TREASURYBROKERDASHBOARD = "brokerDashboard";
	public static final String TREASURYBIDDASHBOARD="treasuryDahboard";
	
	public static final String VALIDATENUMBER_REGEXP = "^-?\\d{1,14}(?>\\.\\d{0,2})?$";
	public static final String VALIDATE_ZIPFORMAT_REGEXP_CHR = "^[a-zA-Z ]*$";
	public static final String VALIDATE_ZIPFORMAT_REGEXP_NUM = "^[A-Za-z0-9- ]*$";
	public static final String BANKLOOKUP_HYPEN = "-";

	public static final String OTP = "otp";

	public static final String INVALID_OTP = "Invalid One Time Password";

	public static final String INVALID_USERID = "Invalid userId; user not found";

	public static final String IDM_STATUS = "IDM_STATUS";

	public static final String APPROVED = "APPROVED";
	public static final String BUSAPROV = "BUSAPROV";
	public static final String PDF_ERROR_IN_CLOSING_FILE = "Error in closing the output stream while generating report";
	public static final String OF_THE_TYPE = " of the type";
	public static final String PDF_ERROR_WHILE_REPORTGENERATING = "Error in closing the output stream while generating report for the deal ";
	public static final String ERROR_WHILE_ACCESSING = "Error while accessing the outputstream of HttpServletResponse";
	public static final String ERROR_WHILE_CLOSING_STREAM = "Error in closing the output stream while generating report for the request ";
	public static final String ERROR_WHILE_GENERATING_PDFREPORT = "Error while generating PDF report ";
	public static final String ERROR_WHILE_CLOSING_PDFBODY = "Error while closing the PDF Body Writer";
	public static final String TABLE_OF_CONTENT = "Table of content";
	
	//Surety Bond Application CSV
	public static final int COLUMN_ONE  = 1;
	public static final int NUM_TWO  = 2;
	public static final String INPERSON_PICKUP  = "In-person pick-up";
	public static final String PHYSICAL_DELIVERY = "Physical delivery (via courier or certified post)";
	public static final String PRINCIPALDETAILS = "PrincipalDetails";
	public static final String OBLIGEEDETAILS = "ObligeeDetails";
	public static final String OBLIGEE_DETAILS = "Obligee Details";
	public static final String PRINCIPAL_DETAILS = "Prinipal Details";
	public static final String BIDMEMO_BIDREPLY = "BidMemo BidReply";
	
	public static final int ROW_ONE  = 1;
	public static final int ROW_TWO  = 2;
	public static final int ROW_THREE  = 3;
	public static final int ROW_FOUR  = 4;
	public static final int ROW_FIVE  = 5;
	public static final int ROW_SIX  = 6;
	public static final int ROW_SEVEN  = 7;
	public static final int ROW_EIGHT  = 8;
	public static final int ROW_NINE  = 9;
	public static final int ROW_TEN  = 10;
	public static final int ROW_ELEVEN  = 11;
	public static final int ROW_TWELVE  = 12;
	public static final int ROW_THIRTEEN  = 13;
	public static final int ROW_FOURTEEN  = 14;
	public static final int ROW_FIFTEEN  = 15;
	public static final int ROW_SIXTEEN  = 16;
	public static final int ROW_SEVENTEEN  = 17;
	public static final int ROW_EIGHTEEN  = 18;
	public static final int ROW_NINTEEN  = 19;
	public static final int ROW_TWENTY  = 20;
	public static final int ROW_TWENTYONE  = 21;
	public static final int ROW_TWENTYTWO  = 22;
	public static final int ROW_TWENTYTHREE  = 23;
	public static final int ROW_TWENTYFOUR  = 24;
	public static final int ROW_TWENTYFIVE  = 25;
	public static final int ROW_TWENTYSIX  = 26;
	public static final int ROW_TWENTYSEVEN  = 27;
	public static final int ROW_TWENTYEIGHT  = 28;
	public static final int ROW_TWENTYNINE  = 29;
	public static final int ROW_THIRTY  = 30;
	public static final int ROW_THIRTYONE  = 31;
	public static final int ROW_THIRTYTWO  = 32;
	public static final int ROW_THIRTYTHREE  = 33;
	public static final int ROW_THIRTYFOUR  = 34;
	public static final int ROW_THIRTYFIVE  = 35;
	public static final int ROW_THIRTYSIX  = 36;
	public static final int ROW_THIRTYSEVEN  = 37;
	public static final int ROW_THIRTYEIGHT  = 38;
	public static final int ROW_THIRTYNINE  = 39;
	public static final int ROW_FORTY  = 40;
	public static final int ROW_FORTYONE  = 41;
	public static final int ROW_FORTYTWO  = 42;
	public static final int ROW_FORTYTHREE  = 43;
	public static final int ROW_FORTYFOUR  = 44;
	public static final int ROW_FORTYFIVE  = 45;
	public static final int ROW_FORTYSIX  = 46;
	public static final int ROW_FORTYSEVEN  = 47;
	public static final int ROW_FORTYEIGHT  = 48;
	public static final int ROW_FORTYNINE  = 49;
	public static final int ROW_FIFTY  = 50;
	public static final int ROW_FIFTYONE  = 51;
	public static final int ROW_FIFTYTWO  = 52;
	public static final int ROW_FIFTYTHREE  = 53;
	public static final int ROW_FIFTYFOUR  = 54;
	public static final int ROW_FIFTYFIVE  = 55;
	public static final int ROW_FIFTYSIX  = 56;
	public static final int ROW_FIFTYSEVEN  = 57;
	public static final int ROW_FIFTYEIGHT  = 58;
	public static final int ROW_FIFTYNINE  = 59;
	public static final int ROW_SIXTY  = 60;
	public static final int ROW_SIXTYONE  = 61;
	public static final int ROW_SIXTYTWO  = 62;
	public static final int ROW_SIXTYTHREE  = 63;
	public static final int ROW_SIXTYFOUR  = 64;
	public static final int ROW_SIXTYFIVE  = 65;
	public static final int ROW_SIXTYSIX  = 66;
	public static final int ROW_SIXTYSEVEN  = 67;
	public static final int ROW_SIXTYEIGHT  = 68;
	public static final int ROW_SIXTYNINE  = 69;
	public static final int ROW_SEVENTY  = 70;
	public static final int ROW_SEVENTYONE  = 71;
	public static final int ROW_SEVENTYTWO  = 72;
	public static final int ROW_SEVENTYTHREE  = 73;
	public static final int ROW_SEVENTYFOUR  = 74;
	public static final int ROW_SEVENTYFIVE  = 75;
	public static final int ROW_SEVENTYSIX  = 76;
	public static final int ROW_SEVENTYSEVEN  = 77;
	public static final int ROW_SEVENTYEIGHT  = 78;
	public static final int ROW_SEVENTYNINE  = 79;
	public static final int ROW_EIGHTY  = 80;
	public static final int ROW_EIGHTYONE  = 81;
	public static final int ROW_EIGHTYTWO  = 82;
	public static final int ROW_EIGHTYTHREE  = 83;
	public static final int ROW_EIGHTYFOUR  = 84;
	public static final int ROW_EIGHTYFIVE  = 85;
	public static final int ROW_EIGHTYSIX  = 86;
	public static final int ROW_EIGHTYSEVEN  = 87;
	public static final int ROW_EIGHTYEIGHT  = 88;
	public static final int ROW_EIGHTYNINE  = 89;
	public static final int ROW_NINETY  = 90;
	public static final int ROW_NINETYONE  = 91;
	public static final int ROW_NINETYTWO  = 92;
	public static final int ROW_NINETYTHREE  = 93;
	public static final int ROW_NINETYFOUR  = 94;
	public static final int ROW_NINETYFIVE  = 95;
	public static final int ROW_NINETYSIX  = 96;
	public static final int ROW_NINETYSEVEN  = 97;
	public static final int ROW_NINETYEIGHT  = 98;
	public static final int ROW_NINETYNINE  = 99;
	public static final int ROW_HUNDRED  = 100;
	public static final int ROW_HUNDRED_AND_ONE  = 101;
	public static final int ROW_HUNDRED_AND_TWO  = 102;
	public static final int ROW_HUNDRED_AND_THREE  = 103;
	public static final int ROW_HUNDRED_AND_FOUR  = 104;
	public static final int ROW_HUNDRED_AND_FIVE  = 105;
	public static final int ROW_HUNDRED_AND_SIX  = 106;
	public static final int ROW_HUNDRED_AND_SEVEN  = 107;
	public static final int ROW_HUNDRED_AND_EIGHT  = 108;
	public static final int ROW_HUNDRED_AND_NINE  = 109;
	public static final int ROW_HUNDRED_AND_TEN  = 110;
	public static final int ROW_HUNDRED_AND_ELEVEN  = 111;
	public static final int ROW_HUNDRED_AND_TWELVE  = 112;
	public static final int ROW_HUNDRED_AND_THIRTEEN  = 113;
	public static final int ROW_HUNDRED_AND_FOURTEEN  = 114;
	public static final int ROW_HUNDRED_AND_FIFTEEN  = 115;
	public static final int ROW_HUNDRED_AND_SIXTEEN  = 116;
	public static final int ROW_HUNDRED_AND_SEVENTEEN = 117;
	public static final int ROW_HUNDRED_AND_EIGHTEEN  = 118;
	public static final int ROW_HUNDRED_AND_NINTEEN  = 119;
	public static final int ROW_HUNDRED_AND_TWENTY  = 120;
	public static final int ROW_HUNDRED_AND_TWENTYONE = 121;
	public static final int ROW_ZERO  = 0;
	
	public static final String  ACTION_ID_SELECT_BANKS = "36";
	public static final String SERVELET_OUTPUTSTREAM_ERROR = "Error while closing the ServletOutputStream";
	public static final String AS_CSV = " as CSV";
	
	public static final String BIDREPLY_OPTOUT = "Optout";
	public static final String NUMBER_FOURZERO="0000";
	
	public static final String AVAILABLESITES="availableSites";
	public static final String START_DATE = "Start Date : ";
	public static final String END_DATE = "End Date : ";
	public static final String TEXT_XML = "text/xml";

	public static final String VALIDATE_DECIMAL_FOURTEEN = "^-?\\d{1,1}(?>\\.\\d{0,12})?$";

	//ReplaceBookmarks
	public static final String DATE_FORMAT="dd-MMM-yyyy";
	public static final String CURRENCY_FORMAT="###,###.00";
	public static final String INSTRUMENT_TYPE = "Instrument Type";
	public static final String INSTRUMENT_PURPOSE = "Instrument Purpose";
	public static final String ALOC_RECORDNUMBER = "ALOC Record Number";
	public static final String ISSUE_DATE = "Issue Date";
	public static final String EXPIRATION_DATE = "Expiration Date";
	public static final String BENEFICIARY_NAME = "Beneficiary Name";
	public static final String BENEFICIARY_ADDRESS = "Beneficiary Address";
	public static final String APPLICANT_NAME = "Applicant Name";
	public static final String APPLICANT_ADDRESS = "Applicant Address";
	public static final String INSTRUMENT_AMOUNT_INWORDS = "Instrument Amount in Words";
	public static final String INSTRUMENT_AMOUNT = "Instrument Amount";
	public static final String BID_NUMBER = "Bid Number";
	public static final String PROJECT_DESCRIPTION = "Project Description";
	public static final String PRAPOSAL_NUMBER = "Proposal Number";
	public static final String CONTRACT_NUMBER = "Contract Number";
	public static final String CONTRACT_DATE = "Contract Date";
	public static final String ADVANCE_PAYMENT_AMOUNT = "Advance Payment Amount";
	public static final String RETENSION_PAYMENT_AMOUNT = "Retention Payment Amount";
	public static final String CURRENCY_CODE = "Currency Code";
	public static final String CONTRACT_AMOUNT = "Contract Amount";
	public static final String BOND_TYPE = "Bond Type";
	public static final String BOND_SUBTYPE = "Bond Sub-Type";
	public static final String PRINCIPAL_NAME = "Principal Name";
	public static final String PRINCIPAL_ADDRESS = "Principal Address";
	public static final String OBLIGEE_NAME = "Obligee Name";
	public static final String OBLIGEE_ADDRESS = "Obligee Address";
	public static final String BID_BOND_AMOUNT = "Bid Bond Amount";
	public static final String BID_BOND_CURRENCY_CODE = "Bid Bond Currency Code";
	public static final String EXACT_PROJECT_DESCRIPTION = "Exact Project Description";
	public static final String CONTRACT_CURRENCY_CODE = "Contract Currency Code";
	public static final String GE_REFERENCE_ONE = "GE Reference (1)";
	public static final String BOND_CURRENCY_CODE = "Bond Currency Code";
	public static final String BOND_AMOUNT = "Bond Amount";
	public static final String BOND_AMOUNT_INWORDS = "Bond Amount in Words";
	public static final String PERFORMANCE_BOND_AMOUNT = "Performance Bond Amount";
	public static final String PERFORMANCE_BONDAMOUNT_INWORDS = "Performance Bond Amount in Words";
	public static final String ISSUING_BANK = "Issuing Bank";
	public static final String WHERE = "WHERE";
	public static final String BETWEEN ="between";
	public static final String AND = "AND";
	public static final String INSTRUMENT_ID = "instrument_id";
	public static final String IN = "in";
	public static final String REQUESTOR_TYPE = "requestorType";
	public static final String BUSINESSSITE_NAMES = "businessSitesNames";
	public static final String SUCCESSMYREPORT = "successMyReport";
	public static final String SUCCESSPUBLISHEDREPORT = "successPublishedReport";
	public static final String DELETEDTEMPLATE = "DeletedTemplate";
	public static final String EAMIL_ALREADY_EXIST = "Email address already exist";
	public static final String USER_ALREADY_EXIST = "UserId already exist";

	public static final String WORKINGSECTION = "WorkingSection";
	public static final String ATMT_METADATA = "metadata";
	
	public static final String AMOUNT_CHECK= "[0-9]+";
	public static final String SELWINNER_FROMDASHBOARD = "fromDashboard";
	public static final String SELWINNER_FROMREQUEST = "fromRequest";
	
	public static final String ENABLED = "Enabled";
	public static final String A = "A";
	public static final String E = "E";
	
	public static final int NUM_INSTRTYPE_SIX = 6;
	
	public static final String USER_ERROR_CODE = "1454";
	public static final int MIN_HOURS = 0;
	public static final int MAX_HOURS = 10;
	public static final int MIN_MINUTES = 0;
	public static final int MAX_MINUTES = 10;
	public static final int ANTE_MERIDIAN = 0;
	public static final int POST_MERIDIAN = 1;	
	public static final int BIDBOND_ID = 1;
	public static final int ADVANCEPAYMENT = 4;
	public static final int CONTRACTBOND_ID = 2;
	public static final int MIN_SIZE = 0;
	public static final int SITELIST_MINSIZE = 1;	
	public static final int ATTACHMENT_MINSIZE = 1;
	
	//Global Constants
	public static final int BUC_START_INDEX  = 0;
	public static final String ADD_OR_EDIT_SELECTION = "addOrEditSelection";
	public static final String ERROR_WHILE_CLOSINGTHEDOCUMENT = "Error while closeing the document";
	public static final String ERROR_WHILE_CLOSINGTHE_OUTPUTSTREAM = "Error while closeing the OutputStream";
	public static final int FORMAT_START_INDEX  = 0;
	public static final int DOCUMENT_PAGESIZES  = 50;
	public static final String FILENAME_BG_ = "BG_";
	public static final String FILENAME_SBLC_ = "SBLC_";
	public static final String FILENAME_SURETY_ = "SURETY_";
	public static final String FILENAME_DOCLC_ = "DOCLC_";
	public static final String LESS_THAN = "<";
	public static final String GREATER_THAN = ">";
	public static final int SURETY_NAME_LENGTH  = 100;
	public static final int ATTACHMENTS_START_INDEX  = 0;
	public static final int ATTACHMENTS_BASE_COUNT  = 0;
	public static final int ATTACHMENTS_MIN_COUNT  = 1;
	public static final int FILEUPLOAD_BASE_LENGTH  = 0;
	public static final int DOWNLOAD_DOC_MIN_SIZE  = 1;
	public static final int DOWNLOAD_DOC_BASE_INDEX = 0;
	public static final int PREVIOUS_PAGE_START_INDEX = 0;
	public static final int LEGALENTITIES_BASE_SIZE = 0;
	public static final int BANKDETAILS_LIST_SIZE = 0;
	public static final int IBS_BASE_INDEX = 0;
	public static final int WEBCASH_BASE_INDEX = 0;
	public static final int SELSITES_BASE_SIZE = 0;
	public static final int CUSTOMFIELD_INCREASE_INDEX = 1;
	public static final int APPROVERGROUP_MAX_SIZE = 20;
	public static final int REQUESTDETAILS_BASE_INDEX = 0;
	public static final int DELEGATION_APPROVER_BASEINDEX = 0;
	public static final int START_INDEX = 0;
	public static final int PAYMENTPERIOD_MIN_SIZE  = 0;
	public static final int FILENAME_MAX_LENGTH  = 100;
	public static final int UPLOADEDFILE_MAXSIZE  = 104857600;
	public static final int SUB_DIVISION_BOND_ID  = 8;
	public static final int PARENTSITE_BASE_INDEX  = 0;
	public static final int BASE_VALUE  = 0;
	public static final int COUNT_MIN_VALUE  = 2;
	public static final int BASE_NEGATIVE_VALUE  = -1;
	public static final int MIN_VALUE  = 1;
	public static final int MIN_INDEX  = 0;
	public static final int SECOND_VALUE  = 2;
	public static final int THIRD_VALUE  = 3;
	public static final int FOURTH_VALUE  = 4;
	public static final int MATCHER_GROUP_VAL = 1;
	public static final int INSTRUMENTS_MIN_SIZE = 2;
	public static final int INSTRUMENTS_BASE_SIZE = 1;
	public static final String SPACE_COLON_SPACE = " : ";
	public static final String ERRORLOG_SLASH = "\'";
	public static final String DEFAULT_OPCODE = "Y";
	public static final int PAYMENTPERIOD_BASE_INDEX  = 0;
	public static final int CURRENCYSETUP_BASE_INDEX  = 0;
	public static final int MDM_RATES_BASE_INDEX = 0;
	public static final String COOKIE = "Cookie: ";
	public static final String COOKIE_PATH = " (path=";
	public static final String COOKIE_DOMAIN = ", domain=";
	public static final String COOKIE_CLOSEBRACE = ")";
	public static final String EAS_SERVICE_ERRORCODE = "EAS Service Error: Error Code = ";
	public static final String EAS_ERROR_MESSAGE = " Error Message = ";
	public static final String EAS_USER = "User \'";
	public static final String BASE_STRING_VALUE  = "0";
	public static final String DOCTYPE_OTHER  = "2";
	public static final String DOCTYPE_FORMAT  = "1";
	public static final String DOCTYPE_ISSUER  = "3";
	public static final String ISSUANCE_TYPE_DIRECT  = "Direct";
	public static final String ISSUANCE_TYPE_INDIRECT  = "Indirect";
	public static final String DEFAULT_ISSUANCE_TYPE_ID  = "2";
	public static final String INSTRUMENTPURPOSE_MAX_ADDEDVAL  = "99";
	public static int CUST_BOND_ID = 5;
	public static int COURT_BOND_ID = 4;
	public static int LICENCE_BOND_ID = 3;
	public static final String STANDARD_FORMAT  = "1";
	public static final String MODIFIED_FORMAT  = "2";
	public static final String NON_STANDARD_FORMAT  = "3";
	public static final int RULE_ID  = 6;
	public static final String MAX_AGE = "1";
	public static final String SITE_TYPE_ID = "1";
	public static final String FORMAT_TEPLATE_HTML = "<html>";
	public static final String FORMAT_TEPLATE_HEAD = "<head>";
	public static final String FORMAT_TEPLATE_STYLE = "<style type=\"text/css\">";
	public static final String FORMAT_TEPLATE_DISPLAY = ".CT-hide .del, .CT-hide .del { display: none; }";
	public static final String FORMAT_TEPLATE_COLOR = ".CT-hide .ins, .CT-hide .ins { color: #333333; background: none !important; border: none !important; }";
	public static final String FORMAT_TEPLATE_BORDER = ".ins,.del { -webkit-border-radius: 3px; border-radius: 3px; color: #000; padding: 1px 0 2px; }";
	public static final String FORMAT_TEPLATE_INSCOLOR = ".ins { color : #f00; background-color:#ffffff; }";
	public static final String FORMAT_TEPLATE_TEXTDECORATION = ".del { text-decoration: line-through; color: #555; background-color:#ffffff; }";
	public static final String FORMAT_TEPLATE_STYLECLOSE = "</style>";
	public static final String FORMAT_TEPLATE_HEADCLOSE = "</head>";
	public static final String FORMAT_TEPLATE_BODY = "<body>";
	public static final String FORMAT_TEPLATE_BODYCLOSE = "</body>";
	public static final String FORMAT_TEPLATE_HTMLCLOSE = "</html>";
	public static final String CREATED_DATE = "createdDate";
	public static final String DATE_COLON = "Date : ";
	
	public static final String FEE_STR_END_VALUE = "1.0";
	
	public static final String FEE_STR_START_VALUE = "0";
	
	public static final String TOTAL = "total";
	
	public static final int LESS_AMOUNT = -1;
	public static final double BASE_AMOUNT = 0.0;
	
	public static final int EXCEL_START_INDEX  = 2;

	public static final String VALIDATE_PHONENUMBER_REGEXP = "^[+]?[0-9- ]*$";
	public static final String VALIDATE_CREDITNUMBER_REGEXP = "^[0-9a-zA-Z-/ ]*$";
	public static final String NOTAPPLICABLE = "n/a";
	public static final int MAX_VALUE = 10;
	
	public static final String HTML_REMOVE_REGX = "\\<.*?\\>";
	public static final String HTML_NBSP = "&.*?;";

	public static final int MAX_YEAR = 2050;
	
	public static final String YYYY_MM_DD = "yyyyMMdd";
	
	public static final int FEE_PROJ_REPORT_NUM_ONE = 1;
	public static final int FEE_PROJ_REPORT_NUM_TWO = 2;
	public static final int FEE_PROJ_REPORT_NUM_THREE = 3;
	public static final int FEE_PROJ_REPORT_NUM_FOUR = 4;

	public static final int THREE_COLUMNS = 3;
	public static final int FOUR_COLUMNS = 4;

	public static final int TERM_MIN_VALUE = 0;
	public static final int TERM_MAX_VALUE = 100;
	public static final int MAX_WIDTH = 100;
	public static final int SEED_VALUE = 100;
	
	public static final String ADHOC_REPORT_WRITER_OBJECT_ERROR_MSG ="Error while closing the Writer Object for Adhoc Report Search Fields";
	
	public static final String REPORT_ZIP_OUTPUT_STREAM_ERROR_MSG = "Error while closing the ZipOutputStream while handling the request for the files";
	public static final String REPORT_EXCEL_TEMPLATE_ERROR_MSG = "Error while closing the Excel Template file";
	public static final String REPORT_BID_SUCCESS_LOGGER_MSG = "Inside of the assignBidSuccessReport Helper method";
	public static final String REPORT_AGING_LOGGER_MSG = "Inside of the assignAgingReport Helper method";
	public static final String REPORT_FEES_PAID_LOGGER_MSG = "Inside of the assignFeesPaidReport Helper method";
	public static final String REPORT_ISSUANCE_LOGGER_MSG = "Inside of the assignIssuanceExpirationReport Helper method";
	public static final String REPORT_ECSO_LOGGER_MSG = "Inside of the assignECSOReport Helper method";
	public static final String REPORT_GCFO_LOGGER_MSG = "Inside of the assignGCFOReport Helper method";
	public static final String REPORT_USER_LOGGER_MSG = "Inside of the assignUserReport Helper method";
	public static final String REPORT_FEE_QUOTATION_LOGGER_MSG = "Inside of the assignFeeQuotationReport Helper method";
	public static final String REPORT_CYCLE_TIME_LOGGER_MSG = "Inside of the assignCycleTimeReport Helper method";
	public static final String REPORT_AVG_FEES_PAID_LOGGER_MSG = "Inside of the assignAvgFeePaidReport Helper method";
	public static final String REPORT_FEE_PROJECTION_LOGGER_MSG = "Inside of the assignFeeProjectionReport Helper method";
	public static final String REPORT_EXCEL_GENERATE_ERROR_MSG = "Error while generating the excel report";
	public static final String REPORT_OUTPUT_STRAEM_CLOSE_ERROR_MSG = "Error while closing the OutputStream for the report";
	public static final String REPORT_TEMPLATE_MSG = "Template \'";
	public static final String REPORT_TEMPLATE_CLASSPATH_MSG = "\' not found in the classpath";
	
	public static final char REPORT_COMMA = ',';
	public static final char REPORT_OPEN_BRACKET = '[';
	public static final char REPORT_CLOSE_BRACKET = ']';
	public static final char REPORT_EMPTY_CHAR = ' ';
	public static final String REPORT_XLSHEET_NAME = "fileName";
	public static final int NUM_SEVEN = 7;
	public static final int NUM_FIVE = 5;
	public static final String REPORT_DOLLAR = "$";
	
	public static final String  BUNDLE_HOLD = "Bundle Hold";
	
	public static final String  BIDMIN_SECOUNDS = "00";
	public static final String  BID_TIMEZONE = "EST";
	public static final int  BIDMAX_HOURS = 12;
	public static final int  BIDMAX_MINUTES = 60;

	public static final String ROLES_NOT_FOUND = "rolesNotFound";
	
	public static final int  DOC_ROW= 4;
	public static final int  SURETY_ROW= 3;
	public static final int  RIDER_ROW= 6;	
	public static final int  BIDS_ROW= 1;
	public static final int  ADVANCE_ROW= 12;
	public static final int  PERFOR_THIRTEEN = 13;
	public static final int  PERFOR_FOURTEEN= 14;
	public static final int  PERFOR_ROW= 16;	
	public static final int  FINANCIAL_ROW= 15;
	
	public static final String REQ_ATTR_ISEXTERNAL = "externalRequest";
	public static final String ATMTS_BYSESSION = "atmtsFlag";
	public static final String ISSUANCE_SAVE = "issuanceSave";
	
	public static final String VALIDATE_DELEGATION = "ValidateDelegation";
	public static final String DELEG_VALID_ROWS_SAME = "Delegation Setup already exists for this Instruments for row number(s) : ";
	public static final String DELEG_INSTR_RANGE_DIFF = "delegInstrRangeDiff";
	public static final String DELEG_VALIDATION_MSG= "Delegation Configuration not completed for row number(s) : ";
	public static final String DELEG_VALIDATE_MANDATORY = "All Fields Mandatory for row number(s) : ";
	public static final String DELEG_VALIDATE_POSITIVE = "Instrument Amount must be Positive for row number(s) : ";
	public static final String DELEG_VALIDATE_AMT_INVALID = "Instrument Amount is Invalid for row number(s) : ";
	public static final String DELEG_VALIDATE_BASE_END_AMT = "Instrument Base Amount must be less than End Amount for row number(s) : ";
	
	public static final String ISSUINGBANKNAMES = "issuingBankNames";
	public static final String SURETYCOMPNAMES = "suretyCompNames";
	
	public static final String CURRBANKFEES_AUDITLOG = "CurrBankFeesAuditLog";
	public static final String UPDATEREPORTING_AUDITLOG = "UpdateReportingAuditLog";	
	public static final String REPORTS_ACCESS_FLAG = "reportsAccessFlag";
	public static final String STRING_DECIMAL_VALUE = "#0.00";

}

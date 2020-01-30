/*
 * Copyright © 2012-2013 GE. ALL RIGHTS RESERVED.
 * FileName: OTPMailSender.java
 * Purpose: OTPMailSender used to send the Mail to the User
 */
package com.ge.aloc.ext;

import java.io.InputStream;
import java.io.StringWriter;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Templates;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import org.apache.log4j.Logger;
import org.w3c.dom.Document;
import org.w3c.dom.Node;

import com.ge.aloc.exception.ALOCRuntimeException;
import com.hydus.hwf.util.StringUtils;

/**
 * This class prepares the One Time Password email content and sends the mail.
 * 
 * This class uses XSL template to prepare email content, so that mail content can be changed easily.
 * 
 * @author chaitanya.n
 */
public class OTPMailSender {

	private static final Logger LOGGER = Logger.getLogger(OTPMailSender.class);

	private static final String USR_CRED_NODE = "userCredentials";
	private static final String USRIR_NODE = "userId";
	private static final String OTP_NODE = "otp";

	private String sender;
	private String subject;
	private Properties configuration;
	private String userId;
	private String password;
	private String contentXSLTFile;

	private DocumentBuilder docBuilder;
	private Templates contentXSLTTemplates;
	private Authenticator authenticator;

	/**
	 * This method validates and initialises the resources. 
	 */
	public void init() {
		if(StringUtils.isBlank(sender)) {
			throw new ALOCRuntimeException(ALOCRuntimeException.EC_CONFIG, "Sender address is not configured");
		}

		if(StringUtils.isBlank(subject)) {
			throw new ALOCRuntimeException(ALOCRuntimeException.EC_CONFIG, "OTP Mail subject is not configured");
		}

		if(configuration == null || configuration.isEmpty()) {
			throw new ALOCRuntimeException(ALOCRuntimeException.EC_CONFIG, "Mail configuration is not set");
		} else {
			if(LOGGER.isDebugEnabled()) {
				LOGGER.debug("Configured Mail Properties: \n" + configuration);
			}
		}

		if(contentXSLTFile == null) {
			throw new ALOCRuntimeException(ALOCRuntimeException.EC_CONFIG, "XSLT file for mail content generation is not configured");
		}

		// Initialising Document Builder
		try {
			docBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
		} catch (ParserConfigurationException pce) {
			throw new ALOCRuntimeException(ALOCRuntimeException.EC_CONFIG, "Error while creating DocumentBuilder", pce);
		}

		// Trying for XSLT file with context ClassLoader
		InputStream xsltFileInStream = Thread.currentThread().getContextClassLoader().getResourceAsStream(contentXSLTFile);

		if(xsltFileInStream == null) {
			StringBuilder errMsg = new StringBuilder().append("Could not load the XSLT file \'").append(contentXSLTFile).append("\' for the mail content generation");
			throw new ALOCRuntimeException(ALOCRuntimeException.EC_CONFIG, errMsg.toString());
		}

		StreamSource source = new StreamSource(xsltFileInStream);
		TransformerFactory transformerFactory = TransformerFactory.newInstance();
		try {
			contentXSLTTemplates = transformerFactory.newTemplates(source);
		} catch (TransformerConfigurationException e) {
			throw new ALOCRuntimeException(ALOCRuntimeException.EC_CONFIG, "Could not create Templates of mail contenet XSLT file");
		}

		// Create Authenticator
		if(StringUtils.isNotBlank(userId)) {
			authenticator = new Authenticator() {
				public PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication(userId, password);
				}
			};
		}
	}

	/**
	 * Method to send  mail to the User
	 * 
	 * @param toAddress
	 * @param userId
	 * @param password
	 * @throws UserOperationException 
	 */
	public void send(String toAddress, String userId, char[] password) throws UserOperationException {
		String mailContent = createContent(userId, password);

		Session session = (authenticator != null) ? Session.getDefaultInstance(configuration, authenticator) 
				:Session.getDefaultInstance(configuration);
		MimeMessage message = new MimeMessage(session);
		try {
			message.setFrom(new InternetAddress(sender));
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(toAddress));
			message.setSubject(subject);
			message.setContent(mailContent, "text/html");
			Transport.send(message);
		} catch (AddressException ae) {
			throw new UserOperationException(UserOperationException.EC_MAIL_SEND, ae);
		} catch (MessagingException me) {
			throw new UserOperationException(UserOperationException.EC_MAIL_SEND, me);
		}

		if(LOGGER.isDebugEnabled()) {
			StringBuilder msg = new StringBuilder().append("OTP mail successfully sent to the user ")
					.append(userId).append("(").append(toAddress).append(")");
			LOGGER.info(msg);
		}
	}

	/**
	 * Method to prepare the mail content.
	 * 
	 * @param userId
	 * @param password
	 * @return
	 * @throws UserOperationException 
	 */
	private String createContent(String userId, char[] password) throws UserOperationException {
		Document document = docBuilder.newDocument();
		Node rootNode = document.createElement(USR_CRED_NODE);
		Node userIdNode = document.createElement(USRIR_NODE);
		userIdNode.appendChild(document.createTextNode(userId));
		Node otpNode = document.createElement(OTP_NODE);
		otpNode.appendChild(document.createTextNode(new String(password)));
		rootNode.appendChild(userIdNode);
		rootNode.appendChild(otpNode);
		document.appendChild(rootNode);

		Source source = new DOMSource(document);
		StringWriter contentWriter = new StringWriter();
		Result result = new StreamResult(contentWriter);
		try {
			contentXSLTTemplates.newTransformer().transform(source, result);
		} catch (TransformerConfigurationException tce) {
			throw new UserOperationException(UserOperationException.EC_MAIL_CONTENT_CREATION, tce);
		} catch (TransformerException te) {
			throw new UserOperationException(UserOperationException.EC_MAIL_CONTENT_CREATION, te);
		}
		return contentWriter.toString();
	}
	/* ------------------------------------------------------------------------------------------------------------------------------------
	 * 												DEPENDENCY INJECTION METHODS
	 -------------------------------------------------------------------------------------------------------------------------------------- */

	/**
	 * Getter method for email from address.
	 * 
	 * @return the sender
	 */
	public String getSender() {
		return sender;
	}
	
	/**
	 * Getter method for email subject.
	 * 
	 * @return the subject
	 */
	public String getSubject() {
		return subject;
	}
	
	/**
	 * Getter method for mail server configuration.
	 * 
	 * @return the configuration
	 */
	public Properties getConfiguration() {
		return configuration;
	}
	
	/**
	 * Getter method for mail server userId.
	 * 
	 * @return the userId
	 */
	public String getUserId() {
		return userId;
	}
	
	/**
	 * Getter method for mail server password.
	 * 
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}
	
	/**
	 * Setter method for email from address.
	 * 
	 * @param sender the sender to set
	 */
	public void setSender(String sender) {
		this.sender = sender;
	}
	
	/**
	 * Setter method for mail subject.
	 * 
	 * @param subject the subject to set
	 */
	public void setSubject(String subject) {
		this.subject = subject;
	}
	
	/**
	 * Setter method for mail server configuration.
	 * 
	 * @param configuration the configuration to set
	 */
	public void setConfiguration(Properties configuration) {
		this.configuration = configuration;
	}
	
	/**
	 * Setter method for mail server userId.
	 * 
	 * @param userId the userId to set
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	/**
	 * Setter method for mail server password.
	 * 
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * Getter method for XSLT file path.
	 * 
	 * @return the contentXSLTFile
	 */
	public String getContentXSLTFile() {
		return contentXSLTFile;
	}

	/**
	 * Setter method for XSLT file path.
	 * 
	 * @param contentXSLTFile the contentXSLTFile to set
	 */
	public void setContentXSLTFile(String contentXSLTFile) {
		this.contentXSLTFile = contentXSLTFile;
	}
}

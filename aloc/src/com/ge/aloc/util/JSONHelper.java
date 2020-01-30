/*
 * Copyright © 2012-2013 GE. ALL RIGHTS RESERVED.
 * FileName: JSONHelper.java
 * Purpose: JSONHelper used for construct results
 */
package com.ge.aloc.util;

import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import com.ge.aloc.constants.ALOCConstants;
import com.ge.aloc.exception.ALOCRuntimeException;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

/**
 * @author narasimhulu.b
 *
 */
public class JSONHelper {

	/**
	 * Method to Construct JsonObject with status as Success
	 * @param data
	 * @return
	 */
	public static JsonObject constructSuccessResult() {
		JsonObject result = new JsonObject();
		result.addProperty(ALOCConstants.JSON_PROP_STATUS, ALOCConstants.JSON_STATUS_SUCCESS);
		return result;
	}

	/**
	 * Method to Construct JsonObject from a Map 
	 * @param data
	 * @return
	 */
	public static JsonObject constructResult(Map<String, JsonObject> data) {
		JsonObject result = constructSuccessResult();
		JsonObject jsonData = new JsonObject();
		for(Map.Entry<String, JsonObject> dataEntry : data.entrySet()) {
			jsonData.add(dataEntry.getKey(), dataEntry.getValue());
		}
		result.add(ALOCConstants.JSON_PROP_DATA, jsonData);
		return result;
	}

	/**
	 * Method to Construct JsonObject from a String
	 * @param data
	 * @return
	 */
	public static JsonObject constructResult(String data) {
		JsonObject result = constructSuccessResult();
		result.addProperty(ALOCConstants.JSON_PROP_DATA, data);
		return result;
	}

	/**
	 * Method to Construct JsonObject from a BigInteger
	 * @param data
	 * @return
	 */
	public static JsonObject constructResult(BigInteger data) {
		JsonObject result = constructSuccessResult();
		result.addProperty(ALOCConstants.JSON_PROP_DATA, data);
		return result;
	}
	
	/**
	 * Method to Construct JsonObject from JsonArray
	 * @param data
	 * @return
	 */
	public static JsonObject constructResult(JsonArray data) {
		JsonObject result = constructSuccessResult();
		result.add(ALOCConstants.JSON_PROP_DATA, data);
		return result;
	}

	/**
	 * Method to Construct JsonObject with status as Fail using Error Code and Error Message
	 * @param errorCode
	 * @param errorMsg
	 * @return
	 */
	public static JsonObject constructErrorResult(String errorCode, String errorMsg) {
		JsonObject result = new JsonObject();
		result.addProperty(ALOCConstants.JSON_PROP_STATUS, ALOCConstants.JSON_STATUS_FAILURE);
		result.addProperty(ALOCConstants.JSON_PROP_ERROR_CODE, errorCode);
		result.addProperty(ALOCConstants.JSON_PROP_ERROR_MSG, errorMsg);
		return result;
	}

	/**
	 * Method to write JsonObject to HttpServletResponse
	 * @param result
	 * @param response
	 * @throws IOException
	 */
	public static void writeResponse(JsonObject result, HttpServletResponse response) {
		PrintWriter out = null;
		response.setContentType(ALOCConstants.MIMETYPE_TEXT_STRING);
		response.setHeader(ALOCConstants.CACHE_CONTROL, ALOCConstants.NOCACHE_NOSTORE);
		response.setHeader(ALOCConstants.PRAGMA, ALOCConstants.NO_CACHE);
		response.setHeader(ALOCConstants.EXPIRES, ALOCConstants.MONE);
		try {
			out = response.getWriter();
			out.print(result);
		} catch (IOException ioe) {
			throw new ALOCRuntimeException(ALOCConstants.EMPTY_STRING, ioe);
		} finally {
			if(out != null) {
				out.close();
			}
		}
	}

	/**
	 * Method to write a success JsonObject to HttpServletResponse with Map
	 * @param data
	 * @param response
	 */
	public static void writeSuccessResponse(Map<String, JsonObject> data, HttpServletResponse response) {
		JsonObject result = constructResult(data);
		writeResponse(result, response);
	}

	/**
	 * Method to write a success JsonObject to HttpServletResponse with String
	 * @param data
	 * @param response
	 */
	public static void writeSuccessResponse(String data, HttpServletResponse response) {
		JsonObject result = constructResult(data);
		writeResponse(result, response);
	}
	
	/**
	 * Method to write a success JsonObject to HttpServletResponse with BigInteger
	 * @param data
	 * @param response
	 */
	public static void writeSuccessResponse(BigInteger data, HttpServletResponse response) {
		JsonObject result = constructResult(data);
		writeResponse(result, response);
	}

	/**
	 * Method to write a success JsonObject to HttpServletResponse with JsonArray
	 * @param data
	 * @param response
	 */
	public static void writeSuccessResponse(JsonArray data, HttpServletResponse response) {
		JsonObject result = constructResult(data);
		writeResponse(result, response);
	}

	/**
	 * Method to write a failure JsonObject to HttpServletResponse with error code and error message
	 * @param errorCode
	 * @param errorMsg
	 * @param response
	 */
	public static void writeFailureResponse(String errorCode, String errorMsg, HttpServletResponse response) {
		JsonObject result = constructErrorResult(errorCode, errorMsg);
		writeResponse(result, response);
	}
}

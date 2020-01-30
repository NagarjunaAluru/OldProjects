/*
 * Copyright © 2012-2013 GE. ALL RIGHTS RESERVED.
 * FileName: DelegationConfigBO.java
 * Purpose: DelegationConfigBO used for the all Delegation operations
 */
package com.ge.aloc.bo;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.ge.aloc.ALOCContext;
import com.ge.aloc.InstrumentType;
import com.ge.aloc.OpCode;
import com.ge.aloc.StaticDataFactory;
import com.ge.aloc.constants.ALOCConstants;
import com.ge.aloc.model.DelegationConfig;
import com.ge.aloc.model.Instrument;

/**
 * @author chaitanya.n
 *
 */
public class DelegationConfigBO extends AbstractModel<DelegationConfig> {

	/**
	 * This method is used to Search for specific type of Instrument
	 * @param instrumentType
	 * @param allInstruments
	 * @return
	 */
	private static Instrument searchInstrumentByType(InstrumentType instrumentType, Collection<Instrument> allInstruments) {
		for(Instrument inst : allInstruments) {
			if(instrumentType.getId() == inst.getInstrId().intValue()) {
				return inst;
			}
		}
		return null;
	}

	/**
	 * This method is used to create new DelegationConfig
	 * @return
	 */
	public DelegationConfigBO() {
		this(new DelegationConfig());
	}

	/**
	 * This method is used to get DelegationConfig model
	 * @param model
	 */
	public DelegationConfigBO(DelegationConfig model) {
		super(model);
	}

	/**
	 * This method is used to find the Delegation row deleted or not
	 * @return boolean value
	 */
	public boolean isDeleted() {
		String opCode = getModel().getOpCode();
		return (opCode != null && OpCode.DELETE.getOperationCode().equals(opCode));
	}

	/**
	 * This method is used to set DELETE Opcode for DelegationConfigBO Model
	 * @param status
	 */
	public void setDeleted(boolean status) {
		if(status && !isDeleted()) {
			getModel().setOpCode(OpCode.DELETE.getOperationCode());
		}
	}

	/**
	 * This method is used to get InstrumentIds
	 * @return result
	 */
	public BigInteger[] getInstrumentIds() {
		List<BigInteger> idList = new ArrayList<BigInteger>();
		List<Instrument> allInstruments = getModel().getInstruments();
		for(Instrument instrument : allInstruments) {
			if(instrument.getOpCode() != null && !instrument.getOpCode().equals(OpCode.DELETE.getOperationCode())) {
				idList.add(new BigInteger(instrument.getInstrId().toString()));
			}
		}
		BigInteger[] result = null;
		if(!idList.isEmpty()) {
			result = new BigInteger[idList.size()];
			result = idList.toArray(result);
		}
		return result;
	}

	/**
	 * This method is used to set InstrumentIds
	 * @param ids
	 */
	public void setInstrumentIds(BigInteger[] ids) {

		List<Instrument> oldInstruments = getModel().getInstruments();
		List<Instrument> newInstruments = new ArrayList<Instrument>();
		getModel().setInstruments(newInstruments);
		if(ids != null && ids.length > ALOCConstants.BASE_VALUE) {
			for(int i=ALOCConstants.BASE_VALUE; i<ids.length; i++) {
				InstrumentType instType = InstrumentType.fromId(ids[i].intValue());
				Instrument instrument = searchInstrumentByType(instType, oldInstruments);

				if(instrument == null) {
					instrument = new Instrument();
					instrument.setInstrId(Integer.valueOf(instType.getId()));
					StaticDataFactory staticDataFactory = ALOCContext.getStaticDataFactory();
					instrument.setInstr(staticDataFactory.getInstrumentTypeMap().get(instType.getId()));
					instrument.setOpCode(OpCode.INSERT.getOperationCode());
				}else if(instrument.getOpCode().equals(ALOCConstants.DELETE)){
					instrument.setOpCode(ALOCConstants.EMPTY_STRING);
				}
				newInstruments.add(instrument);
			}
		}

		for(Instrument oldInstrument : oldInstruments) {
			if(!newInstruments.contains(oldInstrument)) {
				if(oldInstrument.getInstrumentFlag()!=null) {
					oldInstrument.setOpCode(OpCode.DELETE.getOperationCode());
					newInstruments.add(oldInstrument);
				}
			}
		}
	}
}

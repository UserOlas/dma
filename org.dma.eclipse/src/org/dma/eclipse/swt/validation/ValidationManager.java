/*******************************************************************************
 * 2008-2017 Public Domain
 * Contributors
 * Marco Lopes (marcolopes@netc.pt)
 *******************************************************************************/
package org.dma.eclipse.swt.validation;

import java.util.LinkedHashMap;
import java.util.Map;

import org.dma.java.util.StringUtils;

public class ValidationManager implements IValidationManager {

	/** Insertion-ordered KEYS */
	private final Map<String, IValidator> validatorMap=new LinkedHashMap();

	public ValidationManager() {}

	/** Isolated validador */
	public ValidationManager(IValidator validator) {
		register(getClass().getName(), validator);
	}


	public void register(String property, IValidator validator) {

		if(validatorMap.containsKey(property))
			throw new Error("VALIDATOR ALREADY REGISTERED :"+property);

		validator.setValidationManager(this);
		validatorMap.put(property, validator);

	}


	/** DOES NOT UNREGISTER associated validador */
	public IValidator remove(String property) {

		IValidator validator=validatorMap.remove(property);
		if(validator!=null) validator.clearError();

		return validator;

	}


	public void unregister(String property) {

		IValidator validator=remove(property);
		if(validator!=null) validator.unregisterAll();

	}


	public void unregisterAll() {

		while(!validatorMap.isEmpty()){
			String property=validatorMap.keySet().iterator().next();
			unregister(property);
		}

	}


	public void processValidators() {

		for(IValidator validator: validatorMap.values()){
			validator.validateFields();
			validator.validateToolBar();
			validator.postErrorMessage(getErrorMessage());
		}

	}



	/*
	 * Errors
	 */
	public boolean hasError() {

		for(IValidator validator: validatorMap.values()){
			if(validator.hasError()) return true;
		}

		return false;

	}


	public String getErrorMessage(String property) {

		IValidator validator=validatorMap.get(property);
		if(validator!=null && validator.hasError())
			return validator.getErrorMessage();

		return "";

	}


	public String getErrorMessage() {

		String errorMessage="";

		for(String property: validatorMap.keySet()){
			String propertyError=getErrorMessage(property);
			if(!propertyError.isEmpty())
				errorMessage=StringUtils.addIfNotEmpy(errorMessage,"; ")+propertyError;
		}

		return errorMessage;

	}


}
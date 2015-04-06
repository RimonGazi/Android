package com.rimon.rsa.ibd.log;

import com.rimon.rsa.ibd.export.PatientData;


public interface SaveCallback {

	public void saveCallback(PatientData patientData);

}

package com.rimon.rsa.ibd.log;

import com.rimon.rsa.ibd.export.PatientData;

public interface ExportCallback {

	public void exportCallback(PatientData patientData);

}

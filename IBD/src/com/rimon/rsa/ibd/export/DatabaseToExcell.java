package com.rimon.rsa.ibd.export;

import java.io.File;
import java.io.IOException;
import java.util.Locale;

import jxl.CellView;
import jxl.Workbook;
import jxl.WorkbookSettings;
import jxl.format.UnderlineStyle;
import jxl.write.Label;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;
import android.content.Context;
import android.database.Cursor;
import android.os.StrictMode;

import com.rimon.rsa.ibd.database.DBHelper;
import com.rimon.rsa.mental.R;

public class DatabaseToExcell {
	private WritableCellFormat times;
	private WritableCellFormat timesBoldUnderline;
	private WritableSheet sheet;
	private WritableWorkbook workbook;
	private Context context;
	private WritableFont times10pt;
	private WritableFont times10ptBoldUnderline;
	private File file;
	private WorkbookSettings wbSettings;

	private void initialized(String fileName, String path) {
		if (android.os.Build.VERSION.SDK_INT > 9) {
			StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder()
					.permitAll().build();
			StrictMode.setThreadPolicy(policy);

		}
		times10pt = new WritableFont(WritableFont.TIMES, 12);
		// Define the cell format
		times = new WritableCellFormat(times10pt);
		try {
			times.setWrap(true);
		} catch (WriteException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		// create create a bold font with unterlines
		times10ptBoldUnderline = new WritableFont(WritableFont.TIMES, 12,
				WritableFont.BOLD, false, UnderlineStyle.SINGLE);
		timesBoldUnderline = new WritableCellFormat(times10ptBoldUnderline);

		try {
			timesBoldUnderline.setWrap(true);
		} catch (WriteException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		file = new File(path, fileName);

		wbSettings = new WorkbookSettings();
		wbSettings.setLocale(new Locale("en", "EN"));

		try {
			workbook = Workbook.createWorkbook(file, wbSettings);
			sheet = workbook.createSheet("Patient informaton", 0);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private void finalizedExcell() {

		try {
			CellView cv = new CellView();
			cv.setFormat(times);
			cv.setFormat(timesBoldUnderline);
			cv.setAutosize(true);
			for (int length_sheet = 0; length_sheet < sheet.getColumns(); length_sheet++) {
				sheet.setColumnView(length_sheet, cv);
			}
			workbook.write();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {

			workbook.close();
		} catch (WriteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void exportToExcel(Cursor cursor, String fileName, String path,
			Context context) {

		this.context = context;
		initialized(fileName, path);
		addcapTion();

		if (cursor.moveToFirst()) {
			do {

				int i = cursor.getPosition() + 1;
				try {
					sheet.addCell(new Label(0, i, cursor.getString(cursor
							.getColumnIndex(DBHelper.STRESS)), times));
					sheet.addCell(new Label(1, i, cursor.getString(cursor
							.getColumnIndex(DBHelper.ANXIETY)), times));
					sheet.addCell(new Label(2, i, cursor.getString(cursor
							.getColumnIndex(DBHelper.DEPRESSION)), times));

					sheet.addCell(new Label(3, i, cursor.getString(cursor
							.getColumnIndex(DBHelper.STRESS_LEVEL)), times));
					sheet.addCell(new Label(4, i, cursor.getString(cursor
							.getColumnIndex(DBHelper.ANXIETY_LEVEL)), times));
					sheet.addCell(new Label(5, i, cursor.getString(cursor
							.getColumnIndex(DBHelper.DEPRESSION_LEVEL)), times));

					sheet.addCell(new Label(6, i, cursor.getString(cursor
							.getColumnIndex(DBHelper.PQ_1)), times));
					sheet.addCell(new Label(7, i, cursor.getString(cursor
							.getColumnIndex(DBHelper.PQ_2)), times));
					sheet.addCell(new Label(8, i, cursor.getString(cursor
							.getColumnIndex(DBHelper.PQ_3)), times));
					sheet.addCell(new Label(9, i, cursor.getString(cursor
							.getColumnIndex(DBHelper.PQ_4)), times));
					sheet.addCell(new Label(10, i, cursor.getString(cursor
							.getColumnIndex(DBHelper.PQ_5)), times));
					sheet.addCell(new Label(11, i, cursor.getString(cursor
							.getColumnIndex(DBHelper.PQ_6)), times));
					sheet.addCell(new Label(12, i, cursor.getString(cursor
							.getColumnIndex(DBHelper.PQ_7)), times));
					sheet.addCell(new Label(13, i, cursor.getString(cursor
							.getColumnIndex(DBHelper.PQ_8)), times));
					sheet.addCell(new Label(14, i, cursor.getString(cursor
							.getColumnIndex(DBHelper.PQ_9)), times));
					sheet.addCell(new Label(15, i, cursor.getString(cursor
							.getColumnIndex(DBHelper.PQ_10)), times));
					sheet.addCell(new Label(16, i, cursor.getString(cursor
							.getColumnIndex(DBHelper.PQ_11)), times));
					sheet.addCell(new Label(17, i, cursor.getString(cursor
							.getColumnIndex(DBHelper.PQ_12)), times));
					sheet.addCell(new Label(18, i, cursor.getString(cursor
							.getColumnIndex(DBHelper.PQ_13)), times));
					sheet.addCell(new Label(19, i, cursor.getString(cursor
							.getColumnIndex(DBHelper.PQ_14)), times));
					sheet.addCell(new Label(20, i, cursor.getString(cursor
							.getColumnIndex(DBHelper.PQ_15)), times));
					sheet.addCell(new Label(21, i, cursor.getString(cursor
							.getColumnIndex(DBHelper.PQ_16)), times));
					sheet.addCell(new Label(22, i, cursor.getString(cursor
							.getColumnIndex(DBHelper.PQ_17)), times));
					sheet.addCell(new Label(23, i, cursor.getString(cursor
							.getColumnIndex(DBHelper.PQ_18)), times));
					sheet.addCell(new Label(24, i, cursor.getString(cursor
							.getColumnIndex(DBHelper.PQ_19)), times));
					sheet.addCell(new Label(25, i, cursor.getString(cursor
							.getColumnIndex(DBHelper.PQ_20)), times));
					sheet.addCell(new Label(26, i, cursor.getString(cursor
							.getColumnIndex(DBHelper.PQ_21)), times));
					sheet.addCell(new Label(27, i, cursor.getString(cursor
							.getColumnIndex(DBHelper.PQ_22)), times));
					sheet.addCell(new Label(28, i, cursor.getString(cursor
							.getColumnIndex(DBHelper.PQ_23)), times));
					sheet.addCell(new Label(29, i, cursor.getString(cursor
							.getColumnIndex(DBHelper.PQ_24)), times));
					sheet.addCell(new Label(30, i, cursor.getString(cursor
							.getColumnIndex(DBHelper.PQ_25)), times));
					sheet.addCell(new Label(31, i, cursor.getString(cursor
							.getColumnIndex(DBHelper.PQ_26)), times));
					sheet.addCell(new Label(32, i, cursor.getString(cursor
							.getColumnIndex(DBHelper.PQ_27)), times));
					sheet.addCell(new Label(33, i, cursor.getString(cursor
							.getColumnIndex(DBHelper.PQ_28)), times));
					sheet.addCell(new Label(34, i, cursor.getString(cursor
							.getColumnIndex(DBHelper.PQ_29)), times));
					sheet.addCell(new Label(35, i, cursor.getString(cursor
							.getColumnIndex(DBHelper.PQ_30)), times));
					sheet.addCell(new Label(36, i, cursor.getString(cursor
							.getColumnIndex(DBHelper.PQ_31)), times));
					sheet.addCell(new Label(37, i, cursor.getString(cursor
							.getColumnIndex(DBHelper.PQ_32)), times));
					sheet.addCell(new Label(38, i, cursor.getString(cursor
							.getColumnIndex(DBHelper.PQ_33)), times));
					sheet.addCell(new Label(39, i, cursor.getString(cursor
							.getColumnIndex(DBHelper.PQ_34)), times));
					sheet.addCell(new Label(40, i, cursor.getString(cursor
							.getColumnIndex(DBHelper.PQ_35)), times));
					sheet.addCell(new Label(41, i, cursor.getString(cursor
							.getColumnIndex(DBHelper.PQ_36)), times));
					sheet.addCell(new Label(42, i, cursor.getString(cursor
							.getColumnIndex(DBHelper.PQ_37)), times));
					sheet.addCell(new Label(43, i, cursor.getString(cursor
							.getColumnIndex(DBHelper.PFQ_1)), times));
					sheet.addCell(new Label(44, i, cursor.getString(cursor
							.getColumnIndex(DBHelper.PFQ_2)), times));
					sheet.addCell(new Label(45, i, cursor.getString(cursor
							.getColumnIndex(DBHelper.PFQ_3)), times));
					sheet.addCell(new Label(46, i, cursor.getString(cursor
							.getColumnIndex(DBHelper.PFQ_4)), times));
					sheet.addCell(new Label(47, i, cursor.getString(cursor
							.getColumnIndex(DBHelper.PFQ_5)), times));
					sheet.addCell(new Label(48, i, cursor.getString(cursor
							.getColumnIndex(DBHelper.PFQ_6)), times));
					sheet.addCell(new Label(49, i, cursor.getString(cursor
							.getColumnIndex(DBHelper.PFQ_7)), times));
					sheet.addCell(new Label(50, i, cursor.getString(cursor
							.getColumnIndex(DBHelper.PFQ_8)), times));
					sheet.addCell(new Label(51, i, cursor.getString(cursor
							.getColumnIndex(DBHelper.PFQ_9)), times));
					sheet.addCell(new Label(52, i, cursor.getString(cursor
							.getColumnIndex(DBHelper.PFQ_10)), times));
					sheet.addCell(new Label(53, i, cursor.getString(cursor
							.getColumnIndex(DBHelper.PFQ_11)), times));
					sheet.addCell(new Label(54, i, cursor.getString(cursor
							.getColumnIndex(DBHelper.PFQ_12)), times));
					sheet.addCell(new Label(55, i, cursor.getString(cursor
							.getColumnIndex(DBHelper.PFQ_13)), times));
					sheet.addCell(new Label(56, i, cursor.getString(cursor
							.getColumnIndex(DBHelper.PFQ_14)), times));
					sheet.addCell(new Label(57, i, cursor.getString(cursor
							.getColumnIndex(DBHelper.PFQ_15)), times));
					sheet.addCell(new Label(58, i, cursor.getString(cursor
							.getColumnIndex(DBHelper.PFQ_16)), times));
					sheet.addCell(new Label(59, i, cursor.getString(cursor
							.getColumnIndex(DBHelper.PFQ_17)), times));

					sheet.addCell(new Label(60, i, cursor.getString(cursor
							.getColumnIndex(DBHelper.TIME)), times));
					sheet.addCell(new Label(61, i, cursor.getString(cursor
							.getColumnIndex(DBHelper.DATE)), times));

				} catch (RowsExceededException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (WriteException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			} while (cursor.moveToNext());
		}
		finalizedExcell();
	}

	private void addcapTion() {
		try {
			sheet.addCell(new Label(0, 0, context.getResources().getString(
					R.string.stress), timesBoldUnderline));
			sheet.addCell(new Label(1, 0, context.getResources().getString(
					R.string.anxiety), timesBoldUnderline));
			sheet.addCell(new Label(2, 0, context.getResources().getString(
					R.string.depression), timesBoldUnderline));

			sheet.addCell(new Label(3, 0, context.getResources().getString(
					R.string.stress_severity_level), timesBoldUnderline));
			sheet.addCell(new Label(4, 0, context.getResources().getString(
					R.string.anxiety_severity_level), timesBoldUnderline));
			sheet.addCell(new Label(5, 0, context.getResources().getString(
					R.string.depression_severity_level), timesBoldUnderline));

			sheet.addCell(new Label(6, 0, context.getResources().getString(
					R.string.patient_q_1), timesBoldUnderline));
			sheet.addCell(new Label(7, 0, context.getResources().getString(
					R.string.patient_q_2), timesBoldUnderline));
			sheet.addCell(new Label(8, 0, context.getResources().getString(
					R.string.patient_q_3), timesBoldUnderline));
			sheet.addCell(new Label(9, 0, context.getResources().getString(
					R.string.patient_q_4), timesBoldUnderline));
			sheet.addCell(new Label(10, 0, context.getResources().getString(
					R.string.patient_q_5), timesBoldUnderline));
			sheet.addCell(new Label(11, 0, context.getResources().getString(
					R.string.patient_q_6), timesBoldUnderline));
			sheet.addCell(new Label(12, 0, context.getResources().getString(
					R.string.patient_q_7), timesBoldUnderline));
			sheet.addCell(new Label(13, 0, context.getResources().getString(
					R.string.patient_q_8), timesBoldUnderline));
			sheet.addCell(new Label(14, 0, context.getResources().getString(
					R.string.patient_q_9), timesBoldUnderline));
			sheet.addCell(new Label(15, 0, context.getResources().getString(
					R.string.patient_q_10), timesBoldUnderline));
			sheet.addCell(new Label(16, 0, context.getResources().getString(
					R.string.patient_q_11), timesBoldUnderline));
			sheet.addCell(new Label(17, 0, context.getResources().getString(
					R.string.patient_q_12), timesBoldUnderline));
			sheet.addCell(new Label(18, 0, context.getResources().getString(
					R.string.patient_q_13), timesBoldUnderline));
			sheet.addCell(new Label(19, 0, context.getResources().getString(
					R.string.patient_q_14), timesBoldUnderline));
			sheet.addCell(new Label(20, 0, context.getResources().getString(
					R.string.patient_q_15), timesBoldUnderline));
			sheet.addCell(new Label(21, 0, context.getResources().getString(
					R.string.patient_q_16), timesBoldUnderline));
			sheet.addCell(new Label(22, 0, context.getResources().getString(
					R.string.patient_q_17), timesBoldUnderline));
			sheet.addCell(new Label(23, 0, context.getResources().getString(
					R.string.patient_q_18), timesBoldUnderline));
			sheet.addCell(new Label(24, 0, context.getResources().getString(
					R.string.patient_q_19), timesBoldUnderline));
			sheet.addCell(new Label(25, 0, context.getResources().getString(
					R.string.patient_q_20), timesBoldUnderline));
			sheet.addCell(new Label(26, 0, context.getResources().getString(
					R.string.patient_q_21), timesBoldUnderline));
			sheet.addCell(new Label(27, 0, context.getResources().getString(
					R.string.patient_q_22), timesBoldUnderline));
			sheet.addCell(new Label(28, 0, context.getResources().getString(
					R.string.patient_q_23), timesBoldUnderline));
			sheet.addCell(new Label(29, 0, context.getResources().getString(
					R.string.patient_q_24), timesBoldUnderline));
			sheet.addCell(new Label(30, 0, context.getResources().getString(
					R.string.patient_q_25), timesBoldUnderline));
			sheet.addCell(new Label(31, 0, context.getResources().getString(
					R.string.patient_q_26), timesBoldUnderline));
			sheet.addCell(new Label(32, 0, context.getResources().getString(
					R.string.patient_q_27), timesBoldUnderline));
			sheet.addCell(new Label(33, 0, context.getResources().getString(
					R.string.patient_q_28), timesBoldUnderline));
			sheet.addCell(new Label(34, 0, context.getResources().getString(
					R.string.patient_q_29), timesBoldUnderline));
			sheet.addCell(new Label(35, 0, context.getResources().getString(
					R.string.patient_q_30), timesBoldUnderline));
			sheet.addCell(new Label(36, 0, context.getResources().getString(
					R.string.patient_q_31), timesBoldUnderline));
			sheet.addCell(new Label(37, 0, context.getResources().getString(
					R.string.patient_q_32), timesBoldUnderline));
			sheet.addCell(new Label(38, 0, context.getResources().getString(
					R.string.patient_q_33), timesBoldUnderline));
			sheet.addCell(new Label(39, 0, context.getResources().getString(
					R.string.patient_q_34), timesBoldUnderline));
			sheet.addCell(new Label(40, 0, context.getResources().getString(
					R.string.patient_q_35), timesBoldUnderline));
			sheet.addCell(new Label(41, 0, context.getResources().getString(
					R.string.patient_q_36), timesBoldUnderline));
			sheet.addCell(new Label(42, 0, context.getResources().getString(
					R.string.patient_q_37), timesBoldUnderline));
			sheet.addCell(new Label(43, 0, context.getResources().getString(
					R.string.feedback_01), timesBoldUnderline));
			sheet.addCell(new Label(44, 0, context.getResources().getString(
					R.string.feedback_02), timesBoldUnderline));
			sheet.addCell(new Label(45, 0, context.getResources().getString(
					R.string.feedback_03), timesBoldUnderline));
			sheet.addCell(new Label(46, 0, context.getResources().getString(
					R.string.feedback_04), timesBoldUnderline));
			sheet.addCell(new Label(47, 0, context.getResources().getString(
					R.string.feedback_05), timesBoldUnderline));
			sheet.addCell(new Label(48, 0, context.getResources().getString(
					R.string.feedback_06), timesBoldUnderline));
			sheet.addCell(new Label(49, 0, context.getResources().getString(
					R.string.feedback_07), timesBoldUnderline));
			sheet.addCell(new Label(50, 0, context.getResources().getString(
					R.string.feedback_08), timesBoldUnderline));
			sheet.addCell(new Label(51, 0, context.getResources().getString(
					R.string.feedback_09), timesBoldUnderline));
			sheet.addCell(new Label(52, 0, context.getResources().getString(
					R.string.feedback_10), timesBoldUnderline));
			sheet.addCell(new Label(53, 0, context.getResources().getString(
					R.string.feedback_11), timesBoldUnderline));
			sheet.addCell(new Label(54, 0, context.getResources().getString(
					R.string.feedback_12), timesBoldUnderline));
			sheet.addCell(new Label(55, 0, context.getResources().getString(
					R.string.feedback_13), timesBoldUnderline));
			sheet.addCell(new Label(56, 0, context.getResources().getString(
					R.string.feedback_14), timesBoldUnderline));
			sheet.addCell(new Label(57, 0, context.getResources().getString(
					R.string.feedback_15), timesBoldUnderline));
			sheet.addCell(new Label(58, 0, context.getResources().getString(
					R.string.feedback_16), timesBoldUnderline));
			sheet.addCell(new Label(59, 0, context.getResources().getString(
					R.string.feedback_17), timesBoldUnderline));
			sheet.addCell(new Label(60, 0, context.getResources().getString(
					R.string.time), timesBoldUnderline));
			sheet.addCell(new Label(61, 0, context.getResources().getString(
					R.string.date), timesBoldUnderline));

		} catch (RowsExceededException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (WriteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void exportToExcel(PatientData patientData, String fileName,
			String path, Context context) {

		this.context = context;
		initialized(fileName, path);
		addcapTion();
		int i = 1;
		try {
			patientData.getPQ_1();
			sheet.addCell(new Label(0, i, patientData.getSTRESS(), times));
			sheet.addCell(new Label(1, i, patientData.getANXIETY(), times));
			sheet.addCell(new Label(2, i, patientData.getDEPRESSION(), times));

			sheet.addCell(new Label(3, i, patientData.getSTRESS_LEVEL(), times));
			sheet.addCell(new Label(4, i, patientData.getANXIETY_LEVEL(), times));
			sheet.addCell(new Label(5, i, patientData.getDEPRESSION_LEVEL(),
					times));

			sheet.addCell(new Label(6, i, patientData.getPQ_1(), times));
			sheet.addCell(new Label(7, i, patientData.getPQ_2(), times));
			sheet.addCell(new Label(8, i, patientData.getPQ_3(), times));
			sheet.addCell(new Label(9, i, patientData.getPQ_4(), times));
			sheet.addCell(new Label(10, i, patientData.getPQ_5(), times));
			sheet.addCell(new Label(11, i, patientData.getPQ_6(), times));
			sheet.addCell(new Label(12, i, patientData.getPQ_7(), times));
			sheet.addCell(new Label(13, i, patientData.getPQ_8(), times));
			sheet.addCell(new Label(14, i, patientData.getPQ_9(), times));
			sheet.addCell(new Label(15, i, patientData.getPQ_10(), times));
			sheet.addCell(new Label(16, i, patientData.getPQ_11(), times));
			sheet.addCell(new Label(17, i, patientData.getPQ_12(), times));
			sheet.addCell(new Label(18, i, patientData.getPQ_13(), times));
			sheet.addCell(new Label(19, i, patientData.getPQ_14(), times));
			sheet.addCell(new Label(20, i, patientData.getPQ_15(), times));
			sheet.addCell(new Label(21, i, patientData.getPQ_16(), times));
			sheet.addCell(new Label(22, i, patientData.getPQ_17(), times));
			sheet.addCell(new Label(23, i, patientData.getPQ_18(), times));
			sheet.addCell(new Label(24, i, patientData.getPQ_19(), times));
			sheet.addCell(new Label(25, i, patientData.getPQ_20(), times));
			sheet.addCell(new Label(26, i, patientData.getPQ_21(), times));
			sheet.addCell(new Label(27, i, patientData.getPQ_22(), times));
			sheet.addCell(new Label(28, i, patientData.getPQ_23(), times));
			sheet.addCell(new Label(29, i, patientData.getPQ_24(), times));
			sheet.addCell(new Label(30, i, patientData.getPQ_25(), times));
			sheet.addCell(new Label(31, i, patientData.getPQ_26(), times));
			sheet.addCell(new Label(32, i, patientData.getPQ_27(), times));
			sheet.addCell(new Label(33, i, patientData.getPQ_28(), times));
			sheet.addCell(new Label(34, i, patientData.getPQ_29(), times));
			sheet.addCell(new Label(35, i, patientData.getPQ_30(), times));
			sheet.addCell(new Label(36, i, patientData.getPQ_31(), times));
			sheet.addCell(new Label(37, i, patientData.getPQ_32(), times));
			sheet.addCell(new Label(38, i, patientData.getPQ_33(), times));
			sheet.addCell(new Label(39, i, patientData.getPQ_34(), times));
			sheet.addCell(new Label(40, i, patientData.getPQ_35(), times));
			sheet.addCell(new Label(41, i, patientData.getPQ_36(), times));
			sheet.addCell(new Label(42, i, patientData.getPQ_37(), times));

			sheet.addCell(new Label(43, i, patientData.getPFQ_1(), times));
			sheet.addCell(new Label(44, i, patientData.getPFQ_2(), times));
			sheet.addCell(new Label(45, i, patientData.getPFQ_3(), times));
			sheet.addCell(new Label(46, i, patientData.getPFQ_4(), times));
			sheet.addCell(new Label(47, i, patientData.getPFQ_5(), times));
			sheet.addCell(new Label(48, i, patientData.getPFQ_6(), times));
			sheet.addCell(new Label(49, i, patientData.getPFQ_7(), times));
			sheet.addCell(new Label(50, i, patientData.getPFQ_8(), times));
			sheet.addCell(new Label(51, i, patientData.getPFQ_9(), times));
			sheet.addCell(new Label(52, i, patientData.getPFQ_10(), times));
			sheet.addCell(new Label(53, i, patientData.getPFQ_11(), times));
			sheet.addCell(new Label(54, i, patientData.getPFQ_12(), times));
			sheet.addCell(new Label(55, i, patientData.getPFQ_13(), times));
			sheet.addCell(new Label(56, i, patientData.getPFQ_14(), times));
			sheet.addCell(new Label(57, i, patientData.getPFQ_15(), times));
			sheet.addCell(new Label(58, i, patientData.getPFQ_16(), times));
			sheet.addCell(new Label(59, i, patientData.getPFQ_17(), times));

			sheet.addCell(new Label(60, i, patientData.getTIME(), times));
			sheet.addCell(new Label(61, i, patientData.getDATE(), times));

		} catch (RowsExceededException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (WriteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finalizedExcell();
	}
}

package com.rimon.rsa.ipaeps.excel;

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

import com.rimon.rsa.ipaeps.appdatabase.PpPatientDBOpenHelper;
import com.rimon.rsa.ipaeps.module.ModuleAnswer;
import com.rimon.rsa.ipaeps.module.ModuleQuestion;

public class DatabaseToExcell {
	private WritableCellFormat times;
	private WritableCellFormat timesBoldUnderline;
	private WritableSheet sheet;
	private WritableWorkbook workbook;

	private WritableFont times10pt;
	private WritableFont times10ptBoldUnderline;
	private File file;
	private WorkbookSettings wbSettings;

	private ModuleAnswer moduleAnswer;
	private ModuleQuestion moduleQuestion;

	private int row_position;
	private final int ROW_FIRST_POSITION = 0;
	private final int ROW_SECONF_POSITION = 2;

	// private Font fontTitle,fontContent;

	public DatabaseToExcell(Context context, String path, String fileName) {
		moduleAnswer = new ModuleAnswer();
		moduleQuestion = new ModuleQuestion(context);
		initialized(fileName, path);
	}

	private void initialized(String fileName, String path) {

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

	private void addcapTion() {

		try {
			row_position = ROW_FIRST_POSITION;
			sheet.addCell(new Label(0, row_position, moduleQuestion
					.q_module_1_1(), timesBoldUnderline));
			sheet.addCell(new Label(1, row_position, moduleQuestion
					.q_module_1_2(), timesBoldUnderline));
			sheet.addCell(new Label(2, row_position, moduleQuestion
					.q_module_1_3(), timesBoldUnderline));

			sheet.addCell(new Label(3, row_position, moduleQuestion
					.q_module_2_1(), timesBoldUnderline));

			sheet.addCell(new Label(4, row_position, moduleQuestion
					.q_module_2_2(), timesBoldUnderline));

			sheet.addCell(new Label(5, row_position, moduleQuestion
					.q_module_2_3(), timesBoldUnderline));

			sheet.addCell(new Label(6, row_position, moduleQuestion
					.q_module_2_4(), timesBoldUnderline));

			sheet.addCell(new Label(7, row_position, moduleQuestion
					.q_module_2_5(), timesBoldUnderline));
			sheet.addCell(new Label(8, row_position, moduleQuestion
					.q_module_2_6(), timesBoldUnderline));

			sheet.addCell(new Label(9, row_position, moduleQuestion
					.q_module_3_1(), timesBoldUnderline));
			sheet.addCell(new Label(10, row_position, moduleQuestion
					.q_module_3_2(), timesBoldUnderline));
			sheet.addCell(new Label(11, row_position, moduleQuestion
					.q_module_3_3(), timesBoldUnderline));
			sheet.addCell(new Label(12, row_position, moduleQuestion
					.q_module_3_4(), timesBoldUnderline));
			sheet.addCell(new Label(13, row_position, moduleQuestion
					.q_module_3_5(), timesBoldUnderline));
			sheet.addCell(new Label(14, row_position, moduleQuestion
					.q_module_3_6(), timesBoldUnderline));
			sheet.addCell(new Label(15, row_position, moduleQuestion
					.q_module_3_7(), timesBoldUnderline));
			sheet.addCell(new Label(16, row_position, moduleQuestion
					.q_module_3_8(), timesBoldUnderline));
			sheet.addCell(new Label(17, row_position, moduleQuestion
					.q_module_3_9(), timesBoldUnderline));
			sheet.addCell(new Label(18, row_position, moduleQuestion
					.q_module_3_10(), timesBoldUnderline));
			sheet.addCell(new Label(19, row_position, moduleQuestion
					.q_module_3_11(), timesBoldUnderline));
			sheet.addCell(new Label(20, row_position, moduleQuestion
					.q_module_3_12(), timesBoldUnderline));
			sheet.addCell(new Label(21, row_position, moduleQuestion
					.q_module_3_13(), timesBoldUnderline));
			sheet.addCell(new Label(22, row_position, moduleQuestion
					.q_module_3_14(), timesBoldUnderline));
			sheet.addCell(new Label(23, row_position, moduleQuestion
					.q_module_3_15(), timesBoldUnderline));
			sheet.addCell(new Label(24, row_position, moduleQuestion
					.q_module_3_16(), timesBoldUnderline));
			sheet.addCell(new Label(25, row_position, moduleQuestion
					.q_module_3_17(), timesBoldUnderline));
			sheet.addCell(new Label(26, row_position, moduleQuestion
					.q_module_3_18(), timesBoldUnderline));
			sheet.addCell(new Label(27, row_position, moduleQuestion
					.q_module_3_19(), timesBoldUnderline));

			sheet.addCell(new Label(28, row_position, moduleQuestion
					.q_module_4_1(), timesBoldUnderline));
			sheet.addCell(new Label(29, row_position, moduleQuestion
					.q_module_4_2(), timesBoldUnderline));
			sheet.addCell(new Label(30, row_position, moduleQuestion
					.q_module_4_3(), timesBoldUnderline));
			sheet.addCell(new Label(31, row_position, moduleQuestion
					.q_module_4_4(), timesBoldUnderline));
			sheet.addCell(new Label(32, row_position, moduleQuestion
					.q_module_4_5(), timesBoldUnderline));
			sheet.addCell(new Label(33, row_position, moduleQuestion
					.q_module_4_6(), timesBoldUnderline));
			sheet.addCell(new Label(34, row_position, moduleQuestion
					.q_module_4_7(), timesBoldUnderline));
			sheet.addCell(new Label(35, row_position, moduleQuestion
					.q_module_4_8(), timesBoldUnderline));
			sheet.addCell(new Label(36, row_position, moduleQuestion
					.q_module_4_9(), timesBoldUnderline));

			sheet.addCell(new Label(37, row_position, moduleQuestion
					.q_module_5_1(), timesBoldUnderline));
			sheet.addCell(new Label(38, row_position, moduleQuestion
					.q_module_5_2(), timesBoldUnderline));
			sheet.addCell(new Label(39, row_position, moduleQuestion
					.q_module_5_3(), timesBoldUnderline));
			sheet.addCell(new Label(40, row_position, moduleQuestion
					.q_module_5_4(), timesBoldUnderline));
			sheet.addCell(new Label(41, row_position, moduleQuestion
					.q_module_5_5(), timesBoldUnderline));

			sheet.addCell(new Label(42, row_position, moduleQuestion
					.q_module_6_1(), timesBoldUnderline));
			sheet.addCell(new Label(43, row_position, moduleQuestion
					.q_module_6_2(), timesBoldUnderline));
			sheet.addCell(new Label(44, row_position, moduleQuestion
					.q_module_6_3(), timesBoldUnderline));
			sheet.addCell(new Label(45, row_position, moduleQuestion
					.q_module_6_4(), timesBoldUnderline));
			sheet.addCell(new Label(46, row_position, moduleQuestion
					.q_module_6_5(), timesBoldUnderline));
			sheet.addCell(new Label(47, row_position, moduleQuestion
					.q_module_6_6(), timesBoldUnderline));
			sheet.addCell(new Label(48, row_position, moduleQuestion
					.q_module_6_7(), timesBoldUnderline));
			sheet.addCell(new Label(49, row_position, moduleQuestion
					.q_module_6_8(), timesBoldUnderline));
			sheet.addCell(new Label(50, row_position, moduleQuestion
					.q_module_6_9(), timesBoldUnderline));
			sheet.addCell(new Label(51, row_position, moduleQuestion
					.q_module_6_10(), timesBoldUnderline));
			sheet.addCell(new Label(52, row_position, moduleQuestion
					.q_module_6_11(), timesBoldUnderline));
			sheet.addCell(new Label(53, row_position, moduleQuestion
					.q_module_6_12(), timesBoldUnderline));

			sheet.addCell(new Label(54, row_position, moduleQuestion
					.q_module_7_1(), timesBoldUnderline));
			sheet.addCell(new Label(55, row_position, moduleQuestion
					.q_module_7_2(), timesBoldUnderline));
			sheet.addCell(new Label(56, row_position, moduleQuestion
					.q_module_7_3(), timesBoldUnderline));
			sheet.addCell(new Label(57, row_position, moduleQuestion
					.q_module_7_4(), timesBoldUnderline));
			sheet.addCell(new Label(58, row_position, moduleQuestion
					.q_module_7_5(), timesBoldUnderline));
			sheet.addCell(new Label(59, row_position, moduleQuestion
					.q_module_7_6(), timesBoldUnderline));
			sheet.addCell(new Label(60, row_position, moduleQuestion
					.q_module_7_7(), timesBoldUnderline));
			sheet.addCell(new Label(61, row_position, moduleQuestion
					.q_module_7_8(), timesBoldUnderline));
			sheet.addCell(new Label(62, row_position, moduleQuestion
					.q_module_7_9(), timesBoldUnderline));
			sheet.addCell(new Label(63, row_position, moduleQuestion
					.q_module_7_10(), timesBoldUnderline));
			sheet.addCell(new Label(64, row_position, moduleQuestion
					.q_module_7_11(), timesBoldUnderline));
			sheet.addCell(new Label(65, row_position, moduleQuestion
					.q_module_7_12(), timesBoldUnderline));
			sheet.addCell(new Label(66, row_position, moduleQuestion
					.q_module_7_13(), timesBoldUnderline));
			sheet.addCell(new Label(67, row_position, moduleQuestion
					.q_module_7_14(), timesBoldUnderline));
			sheet.addCell(new Label(68, row_position, moduleQuestion
					.q_module_7_15(), timesBoldUnderline));
			sheet.addCell(new Label(69, row_position, moduleQuestion
					.q_module_7_16(), timesBoldUnderline));
			sheet.addCell(new Label(70, row_position, moduleQuestion
					.q_module_7_17(), timesBoldUnderline));
			sheet.addCell(new Label(71, row_position, moduleQuestion
					.q_module_7_18(), timesBoldUnderline));
			sheet.addCell(new Label(72, row_position, moduleQuestion
					.q_module_7_19(), timesBoldUnderline));
			sheet.addCell(new Label(73, row_position, moduleQuestion
					.q_module_7_20(), timesBoldUnderline));
			sheet.addCell(new Label(74, row_position, moduleQuestion
					.q_module_7_21(), timesBoldUnderline));
			sheet.addCell(new Label(75, row_position, moduleQuestion
					.q_module_7_22(), timesBoldUnderline));

			sheet.addCell(new Label(76, row_position, moduleQuestion
					.q_module_8_1(), timesBoldUnderline));
			sheet.addCell(new Label(77, row_position, moduleQuestion
					.q_module_8_2(), timesBoldUnderline));
			sheet.addCell(new Label(78, row_position, moduleQuestion
					.q_module_8_3(), timesBoldUnderline));
			sheet.addCell(new Label(79, row_position, moduleQuestion
					.q_module_8_4(), timesBoldUnderline));

			sheet.addCell(new Label(80, row_position, moduleQuestion
					.q_module_9_1(), timesBoldUnderline));
			sheet.addCell(new Label(81, row_position, moduleQuestion
					.q_module_9_2(), timesBoldUnderline));
			sheet.addCell(new Label(82, row_position, moduleQuestion
					.q_module_9_3(), timesBoldUnderline));
			sheet.addCell(new Label(83, row_position, moduleQuestion
					.q_module_9_4(), timesBoldUnderline));
			sheet.addCell(new Label(84, row_position, moduleQuestion
					.q_module_9_5(), timesBoldUnderline));
			sheet.addCell(new Label(85, row_position, moduleQuestion
					.q_module_9_6(), timesBoldUnderline));
			sheet.addCell(new Label(86, row_position, moduleQuestion
					.q_module_9_7(), timesBoldUnderline));

			sheet.addCell(new Label(87, row_position, moduleQuestion
					.q_module_10_1(), timesBoldUnderline));
			sheet.addCell(new Label(88, row_position, moduleQuestion
					.q_module_10_2(), timesBoldUnderline));
			sheet.addCell(new Label(89, row_position, moduleQuestion
					.q_module_10_3(), timesBoldUnderline));
			sheet.addCell(new Label(90, row_position, moduleQuestion
					.q_module_10_4(), timesBoldUnderline));
			sheet.addCell(new Label(91, row_position, moduleQuestion
					.q_module_10_5(), timesBoldUnderline));
			sheet.addCell(new Label(92, row_position, moduleQuestion
					.q_module_10_6(), timesBoldUnderline));

			sheet.addCell(new Label(93, row_position, moduleQuestion
					.q_module_11(), timesBoldUnderline));

			sheet.addCell(new Label(94, row_position, moduleQuestion
					.q_module_12_1(), timesBoldUnderline));
			sheet.addCell(new Label(95, row_position, moduleQuestion
					.q_module_12_2(), timesBoldUnderline));
			sheet.addCell(new Label(96, row_position, moduleQuestion
					.q_module_12_3(), timesBoldUnderline));
			sheet.addCell(new Label(97, row_position, moduleQuestion
					.q_module_12_4(), timesBoldUnderline));
			sheet.addCell(new Label(98, row_position, moduleQuestion
					.q_module_12_5(), timesBoldUnderline));
			sheet.addCell(new Label(99, row_position, moduleQuestion
					.q_module_12_6(), timesBoldUnderline));
			sheet.addCell(new Label(100, row_position, moduleQuestion
					.q_module_12_7(), timesBoldUnderline));
			sheet.addCell(new Label(101, row_position, moduleQuestion
					.q_module_12_8(), timesBoldUnderline));
			sheet.addCell(new Label(102, row_position, moduleQuestion
					.q_module_12_9(), timesBoldUnderline));

			sheet.addCell(new Label(103, row_position, moduleQuestion
					.q_module_13_1(), timesBoldUnderline));
			sheet.addCell(new Label(104, row_position, moduleQuestion
					.q_module_13_2(), timesBoldUnderline));
			sheet.addCell(new Label(105, row_position, moduleQuestion
					.q_module_13_3(), timesBoldUnderline));
			sheet.addCell(new Label(106, row_position, moduleQuestion
					.q_module_13_4(), timesBoldUnderline));
			sheet.addCell(new Label(107, row_position, moduleQuestion
					.q_module_13_5(), timesBoldUnderline));
			sheet.addCell(new Label(108, row_position, moduleQuestion
					.q_module_13_6(), timesBoldUnderline));
			sheet.addCell(new Label(109, row_position, moduleQuestion
					.q_module_13_7(), timesBoldUnderline));
			sheet.addCell(new Label(110, row_position, moduleQuestion
					.q_module_13_8(), timesBoldUnderline));
			sheet.addCell(new Label(111, row_position, moduleQuestion
					.q_module_13_9(), timesBoldUnderline));

			sheet.addCell(new Label(112, row_position, moduleQuestion
					.q_module_14_1(), timesBoldUnderline));
			sheet.addCell(new Label(113, row_position, moduleQuestion
					.q_module_14_2(), timesBoldUnderline));
			sheet.addCell(new Label(114, row_position, moduleQuestion
					.q_module_14_3(), timesBoldUnderline));
			sheet.addCell(new Label(115, row_position, moduleQuestion
					.q_module_14_4(), timesBoldUnderline));
			sheet.addCell(new Label(116, row_position, moduleQuestion
					.q_module_14_5(), timesBoldUnderline));
			sheet.addCell(new Label(117, row_position, moduleQuestion
					.q_module_14_6(), timesBoldUnderline));

			sheet.addCell(new Label(118, row_position, moduleQuestion
					.q_module_15_1(), timesBoldUnderline));
			sheet.addCell(new Label(119, row_position, moduleQuestion
					.q_module_15_2(), timesBoldUnderline));
			sheet.addCell(new Label(120, row_position, moduleQuestion
					.q_module_15_3(), timesBoldUnderline));
			sheet.addCell(new Label(121, row_position, moduleQuestion
					.q_module_15_4(), timesBoldUnderline));
		} catch (RowsExceededException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (WriteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void excelContentData() {

		try {
			sheet.addCell(new Label(0, row_position, moduleAnswer
					.q_module_1_1(), timesBoldUnderline));
			sheet.addCell(new Label(1, row_position, moduleAnswer
					.q_module_1_2(), timesBoldUnderline));
			sheet.addCell(new Label(2, row_position, moduleAnswer
					.q_module_1_3(), timesBoldUnderline));

			sheet.addCell(new Label(3, row_position, moduleAnswer
					.q_module_2_1(), timesBoldUnderline));

			sheet.addCell(new Label(4, row_position, moduleAnswer
					.q_module_2_2(), timesBoldUnderline));

			sheet.addCell(new Label(5, row_position, moduleAnswer
					.q_module_2_3(), timesBoldUnderline));

			sheet.addCell(new Label(6, row_position, moduleAnswer
					.q_module_2_4(), timesBoldUnderline));

			sheet.addCell(new Label(7, row_position, moduleAnswer
					.q_module_2_5(), timesBoldUnderline));
			sheet.addCell(new Label(8, row_position, moduleAnswer
					.q_module_2_6(), timesBoldUnderline));

			sheet.addCell(new Label(9, row_position, moduleAnswer
					.q_module_3_1(), timesBoldUnderline));
			sheet.addCell(new Label(10, row_position, moduleAnswer
					.q_module_3_2(), timesBoldUnderline));
			sheet.addCell(new Label(11, row_position, moduleAnswer
					.q_module_3_3(), timesBoldUnderline));
			sheet.addCell(new Label(12, row_position, moduleAnswer
					.q_module_3_4(), timesBoldUnderline));
			sheet.addCell(new Label(13, row_position, moduleAnswer
					.q_module_3_5(), timesBoldUnderline));
			sheet.addCell(new Label(14, row_position, moduleAnswer
					.q_module_3_6(), timesBoldUnderline));
			sheet.addCell(new Label(15, row_position, moduleAnswer
					.q_module_3_7(), timesBoldUnderline));
			sheet.addCell(new Label(16, row_position, moduleAnswer
					.q_module_3_8(), timesBoldUnderline));
			sheet.addCell(new Label(17, row_position, moduleAnswer
					.q_module_3_9(), timesBoldUnderline));
			sheet.addCell(new Label(18, row_position, moduleAnswer
					.q_module_3_10(), timesBoldUnderline));
			sheet.addCell(new Label(19, row_position, moduleAnswer
					.q_module_3_11(), timesBoldUnderline));
			sheet.addCell(new Label(20, row_position, moduleAnswer
					.q_module_3_12(), timesBoldUnderline));
			sheet.addCell(new Label(21, row_position, moduleAnswer
					.q_module_3_13(), timesBoldUnderline));
			sheet.addCell(new Label(22, row_position, moduleAnswer
					.q_module_3_14(), timesBoldUnderline));
			sheet.addCell(new Label(23, row_position, moduleAnswer
					.q_module_3_15(), timesBoldUnderline));
			sheet.addCell(new Label(24, row_position, moduleAnswer
					.q_module_3_16(), timesBoldUnderline));
			sheet.addCell(new Label(25, row_position, moduleAnswer
					.q_module_3_17(), timesBoldUnderline));
			sheet.addCell(new Label(26, row_position, moduleAnswer
					.q_module_3_18(), timesBoldUnderline));
			sheet.addCell(new Label(27, row_position, moduleAnswer
					.q_module_3_19(), timesBoldUnderline));

			sheet.addCell(new Label(28, row_position, moduleAnswer
					.q_module_4_1(), timesBoldUnderline));
			sheet.addCell(new Label(29, row_position, moduleAnswer
					.q_module_4_2(), timesBoldUnderline));
			sheet.addCell(new Label(30, row_position, moduleAnswer
					.q_module_4_3(), timesBoldUnderline));
			sheet.addCell(new Label(31, row_position, moduleAnswer
					.q_module_4_4(), timesBoldUnderline));
			sheet.addCell(new Label(32, row_position, moduleAnswer
					.q_module_4_5(), timesBoldUnderline));
			sheet.addCell(new Label(33, row_position, moduleAnswer
					.q_module_4_6(), timesBoldUnderline));
			sheet.addCell(new Label(34, row_position, moduleAnswer
					.q_module_4_7(), timesBoldUnderline));
			sheet.addCell(new Label(35, row_position, moduleAnswer
					.q_module_4_8(), timesBoldUnderline));
			sheet.addCell(new Label(36, row_position, moduleAnswer
					.q_module_4_9(), timesBoldUnderline));

			sheet.addCell(new Label(37, row_position, moduleAnswer
					.q_module_5_1(), timesBoldUnderline));
			sheet.addCell(new Label(38, row_position, moduleAnswer
					.q_module_5_2(), timesBoldUnderline));
			sheet.addCell(new Label(39, row_position, moduleAnswer
					.q_module_5_3(), timesBoldUnderline));
			sheet.addCell(new Label(40, row_position, moduleAnswer
					.q_module_5_4(), timesBoldUnderline));
			sheet.addCell(new Label(41, row_position, moduleAnswer
					.q_module_5_5(), timesBoldUnderline));

			sheet.addCell(new Label(42, row_position, moduleAnswer
					.q_module_6_1(), timesBoldUnderline));
			sheet.addCell(new Label(43, row_position, moduleAnswer
					.q_module_6_2(), timesBoldUnderline));
			sheet.addCell(new Label(44, row_position, moduleAnswer
					.q_module_6_3(), timesBoldUnderline));
			sheet.addCell(new Label(45, row_position, moduleAnswer
					.q_module_6_4(), timesBoldUnderline));
			sheet.addCell(new Label(46, row_position, moduleAnswer
					.q_module_6_5(), timesBoldUnderline));
			sheet.addCell(new Label(47, row_position, moduleAnswer
					.q_module_6_6(), timesBoldUnderline));
			sheet.addCell(new Label(48, row_position, moduleAnswer
					.q_module_6_7(), timesBoldUnderline));
			sheet.addCell(new Label(49, row_position, moduleAnswer
					.q_module_6_8(), timesBoldUnderline));
			sheet.addCell(new Label(50, row_position, moduleAnswer
					.q_module_6_9(), timesBoldUnderline));
			sheet.addCell(new Label(51, row_position, moduleAnswer
					.q_module_6_10(), timesBoldUnderline));
			sheet.addCell(new Label(52, row_position, moduleAnswer
					.q_module_6_11(), timesBoldUnderline));
			sheet.addCell(new Label(53, row_position, moduleAnswer
					.q_module_6_12(), timesBoldUnderline));

			sheet.addCell(new Label(54, row_position, moduleAnswer
					.q_module_7_1(), timesBoldUnderline));
			sheet.addCell(new Label(55, row_position, moduleAnswer
					.q_module_7_2(), timesBoldUnderline));
			sheet.addCell(new Label(56, row_position, moduleAnswer
					.q_module_7_3(), timesBoldUnderline));
			sheet.addCell(new Label(57, row_position, moduleAnswer
					.q_module_7_4(), timesBoldUnderline));
			sheet.addCell(new Label(58, row_position, moduleAnswer
					.q_module_7_5(), timesBoldUnderline));
			sheet.addCell(new Label(59, row_position, moduleAnswer
					.q_module_7_6(), timesBoldUnderline));
			sheet.addCell(new Label(60, row_position, moduleAnswer
					.q_module_7_7(), timesBoldUnderline));
			sheet.addCell(new Label(61, row_position, moduleAnswer
					.q_module_7_8(), timesBoldUnderline));
			sheet.addCell(new Label(62, row_position, moduleAnswer
					.q_module_7_9(), timesBoldUnderline));
			sheet.addCell(new Label(63, row_position, moduleAnswer
					.q_module_7_10(), timesBoldUnderline));
			sheet.addCell(new Label(64, row_position, moduleAnswer
					.q_module_7_11(), timesBoldUnderline));
			sheet.addCell(new Label(65, row_position, moduleAnswer
					.q_module_7_12(), timesBoldUnderline));
			sheet.addCell(new Label(66, row_position, moduleAnswer
					.q_module_7_13(), timesBoldUnderline));
			sheet.addCell(new Label(67, row_position, moduleAnswer
					.q_module_7_14(), timesBoldUnderline));
			sheet.addCell(new Label(68, row_position, moduleAnswer
					.q_module_7_15(), timesBoldUnderline));
			sheet.addCell(new Label(69, row_position, moduleAnswer
					.q_module_7_16(), timesBoldUnderline));
			sheet.addCell(new Label(70, row_position, moduleAnswer
					.q_module_7_17(), timesBoldUnderline));
			sheet.addCell(new Label(71, row_position, moduleAnswer
					.q_module_7_18(), timesBoldUnderline));
			sheet.addCell(new Label(72, row_position, moduleAnswer
					.q_module_7_19(), timesBoldUnderline));
			sheet.addCell(new Label(73, row_position, moduleAnswer
					.q_module_7_20(), timesBoldUnderline));
			sheet.addCell(new Label(74, row_position, moduleAnswer
					.q_module_7_21(), timesBoldUnderline));
			sheet.addCell(new Label(75, row_position, moduleAnswer
					.q_module_7_22(), timesBoldUnderline));

			sheet.addCell(new Label(76, row_position, moduleAnswer
					.q_module_8_1(), timesBoldUnderline));
			sheet.addCell(new Label(77, row_position, moduleAnswer
					.q_module_8_2(), timesBoldUnderline));
			sheet.addCell(new Label(78, row_position, moduleAnswer
					.q_module_8_3(), timesBoldUnderline));
			sheet.addCell(new Label(79, row_position, moduleAnswer
					.q_module_8_4(), timesBoldUnderline));

			sheet.addCell(new Label(80, row_position, moduleAnswer
					.q_module_9_1(), timesBoldUnderline));
			sheet.addCell(new Label(81, row_position, moduleAnswer
					.q_module_9_2(), timesBoldUnderline));
			sheet.addCell(new Label(82, row_position, moduleAnswer
					.q_module_9_3(), timesBoldUnderline));
			sheet.addCell(new Label(83, row_position, moduleAnswer
					.q_module_9_4(), timesBoldUnderline));
			sheet.addCell(new Label(84, row_position, moduleAnswer
					.q_module_9_5(), timesBoldUnderline));
			sheet.addCell(new Label(85, row_position, moduleAnswer
					.q_module_9_6(), timesBoldUnderline));
			sheet.addCell(new Label(86, row_position, moduleAnswer
					.q_module_9_7(), timesBoldUnderline));

			sheet.addCell(new Label(87, row_position, moduleAnswer
					.q_module_10_1(), timesBoldUnderline));
			sheet.addCell(new Label(88, row_position, moduleAnswer
					.q_module_10_2(), timesBoldUnderline));
			sheet.addCell(new Label(89, row_position, moduleAnswer
					.q_module_10_3(), timesBoldUnderline));
			sheet.addCell(new Label(90, row_position, moduleAnswer
					.q_module_10_4(), timesBoldUnderline));
			sheet.addCell(new Label(91, row_position, moduleAnswer
					.q_module_10_5(), timesBoldUnderline));
			sheet.addCell(new Label(92, row_position, moduleAnswer
					.q_module_10_6(), timesBoldUnderline));

			sheet.addCell(new Label(93, row_position, moduleAnswer
					.q_module_11(), timesBoldUnderline));

			sheet.addCell(new Label(94, row_position, moduleAnswer
					.q_module_12_1(), timesBoldUnderline));
			sheet.addCell(new Label(95, row_position, moduleAnswer
					.q_module_12_2(), timesBoldUnderline));
			sheet.addCell(new Label(96, row_position, moduleAnswer
					.q_module_12_3(), timesBoldUnderline));
			sheet.addCell(new Label(97, row_position, moduleAnswer
					.q_module_12_4(), timesBoldUnderline));
			sheet.addCell(new Label(98, row_position, moduleAnswer
					.q_module_12_5(), timesBoldUnderline));
			sheet.addCell(new Label(99, row_position, moduleAnswer
					.q_module_12_6(), timesBoldUnderline));
			sheet.addCell(new Label(100, row_position, moduleAnswer
					.q_module_12_7(), timesBoldUnderline));
			sheet.addCell(new Label(101, row_position, moduleAnswer
					.q_module_12_8(), timesBoldUnderline));
			sheet.addCell(new Label(102, row_position, moduleAnswer
					.q_module_12_9(), timesBoldUnderline));

			sheet.addCell(new Label(103, row_position, moduleAnswer
					.q_module_13_1(), timesBoldUnderline));
			sheet.addCell(new Label(104, row_position, moduleAnswer
					.q_module_13_2(), timesBoldUnderline));
			sheet.addCell(new Label(105, row_position, moduleAnswer
					.q_module_13_3(), timesBoldUnderline));
			sheet.addCell(new Label(106, row_position, moduleAnswer
					.q_module_13_4(), timesBoldUnderline));
			sheet.addCell(new Label(107, row_position, moduleAnswer
					.q_module_13_5(), timesBoldUnderline));
			sheet.addCell(new Label(108, row_position, moduleAnswer
					.q_module_13_6(), timesBoldUnderline));
			sheet.addCell(new Label(109, row_position, moduleAnswer
					.q_module_13_7(), timesBoldUnderline));
			sheet.addCell(new Label(110, row_position, moduleAnswer
					.q_module_13_8(), timesBoldUnderline));
			sheet.addCell(new Label(111, row_position, moduleAnswer
					.q_module_13_9(), timesBoldUnderline));

			sheet.addCell(new Label(112, row_position, moduleAnswer
					.q_module_14_1(), timesBoldUnderline));
			sheet.addCell(new Label(113, row_position, moduleAnswer
					.q_module_14_2(), timesBoldUnderline));
			sheet.addCell(new Label(114, row_position, moduleAnswer
					.q_module_14_3(), timesBoldUnderline));
			sheet.addCell(new Label(115, row_position, moduleAnswer
					.q_module_14_4(), timesBoldUnderline));
			sheet.addCell(new Label(116, row_position, moduleAnswer
					.q_module_14_5(), timesBoldUnderline));
			sheet.addCell(new Label(117, row_position, moduleAnswer
					.q_module_14_6(), timesBoldUnderline));

			sheet.addCell(new Label(118, row_position, moduleAnswer
					.q_module_15_1(), timesBoldUnderline));
			sheet.addCell(new Label(119, row_position, moduleAnswer
					.q_module_15_2(), timesBoldUnderline));
			sheet.addCell(new Label(120, row_position, moduleAnswer
					.q_module_15_3(), timesBoldUnderline));
			sheet.addCell(new Label(121, row_position, moduleAnswer
					.q_module_15_4(), timesBoldUnderline));
		} catch (RowsExceededException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (WriteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void exportToExcelWithSingleCursor(Cursor dataCursor) {
		addcapTion();
		moduleAnswer.setCursor(dataCursor);
		row_position += ROW_SECONF_POSITION;
		excelContentData();
		finalizedExcell();

	}

	public int[] exportToExcelWithMultipleCursor(Cursor dataCursor) {
		addcapTion();
		int id[] = new int[dataCursor.getCount()];
		int increment = 0;
		do {
			if (dataCursor != null && dataCursor.getCount() > 0) {
				row_position = dataCursor.getPosition() + ROW_SECONF_POSITION;
				id[increment++] = dataCursor.getInt(dataCursor
						.getColumnIndex(PpPatientDBOpenHelper.database_id));
				moduleAnswer.setCursor(dataCursor);
				excelContentData();
			}

		} while (dataCursor.moveToNext());

		finalizedExcell();
		return id;
	}
}

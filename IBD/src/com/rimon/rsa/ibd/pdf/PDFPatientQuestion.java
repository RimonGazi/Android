package com.rimon.rsa.ibd.pdf;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import android.content.Context;
import android.os.Environment;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.rimon.rsa.ibd.export.PatientData;
import com.rimon.rsa.ibd.main.ConstantValues;
import com.rimon.rsa.mental.R;

public class PDFPatientQuestion {
	PatientData patientData;
	private Context context;

	Document document;

	public PDFPatientQuestion(Context ctx, PatientData data) {
		context = ctx;
		this.patientData = data;

		document = new Document();
	}

	private static Font titleFont, subTitleFont, question_font, answer_font,
			date_font;

	public void cteatePDf() throws FileNotFoundException {

		// ByteArrayOutputStream arrayOutputStream = null;
		try {
			titleFont = new Font(Font.FontFamily.TIMES_ROMAN, 18, Font.BOLD);
			subTitleFont = new Font(Font.FontFamily.TIMES_ROMAN, 14, Font.BOLD);
			date_font = new Font(Font.FontFamily.TIMES_ROMAN, 10, Font.NORMAL);
			question_font = new Font(Font.FontFamily.TIMES_ROMAN, 11,
					Font.NORMAL);
			answer_font = new Font(Font.FontFamily.TIMES_ROMAN, 11,
					Font.NORMAL, new BaseColor(255, 0, 0));

			Paragraph paragraph = new Paragraph();

			addFirstPageTitle(paragraph);
			addFirstPageFirstQuestionLevel(paragraph);

			document.open();
			document.add(paragraph);

			document.close();
		} catch (DocumentException e) {
			e.printStackTrace();
		}

	}

	private void addFirstPageTitle(Paragraph paragraph) {

		Paragraph title = new Paragraph();
		title.setAlignment(com.itextpdf.text.Element.ALIGN_CENTER);
		title.add(new Chunk("Outpatient Brief Mental Health Review", titleFont));
		title.add(Chunk.NEWLINE);

		Chunk my_chunk1, my_chunk2;
		my_chunk1 = new Chunk(context.getResources().getString(R.string.time),
				date_font);
		title.add(my_chunk1);

		my_chunk2 = new Chunk(" " + patientData.getTIME(), date_font);
		title.add(my_chunk2);

		my_chunk1 = new Chunk("    "
				+ context.getResources().getString(R.string.date), date_font);
		title.add(my_chunk1);

		my_chunk2 = new Chunk(" " + patientData.getDATE(), date_font);
		title.add(my_chunk2);
		title.setAlignment(Element.ALIGN_CENTER);

		paragraph.add(title);
		paragraph.add(Chunk.NEWLINE);

	}

	private void addFirstPageFirstQuestionLevel(Paragraph paragraph) {

		PdfPTable pdfPTable = new PdfPTable(2);
		pdfPTable.setHorizontalAlignment(com.itextpdf.text.Element.ALIGN_LEFT);
		pdfPTable.setWidthPercentage(100);
		pdfPTable.setSpacingBefore(0f);
		pdfPTable.setSpacingAfter(0f);

		Chunk chunk1 = new Chunk(context.getResources().getString(
				R.string.anxiety_severity_score), question_font);
		Chunk chunk2 = new Chunk(" " + patientData.getANXIETY(), answer_font);
		Paragraph paragraph2 = new Paragraph();
		paragraph2.add(chunk1);
		paragraph2.add(chunk2);

		PdfPCell cell1 = new PdfPCell(paragraph2);
		cell1.setBorder(Rectangle.BOX);
		cell1.setBorderColor(BaseColor.YELLOW);

		Chunk chunk3 = new Chunk(context.getResources().getString(
				R.string.anxiety_severity_level)
				+ ": ", question_font);
		Chunk chunk4 = new Chunk(patientData.getANXIETY_LEVEL(), answer_font);

		Paragraph paragraph3 = new Paragraph();
		paragraph3.add(chunk3);
		paragraph3.add(chunk4);
		PdfPCell cell3 = new PdfPCell(paragraph3);

		cell3.setBorder(Rectangle.BOX);
		cell3.setBorderColor(BaseColor.YELLOW);

		Chunk chunk5 = new Chunk(context.getResources().getString(
				R.string.depression_severity_score), question_font);
		Chunk chunk6 = new Chunk(" " + patientData.getDEPRESSION(), answer_font);
		Paragraph paragraph4 = new Paragraph();
		paragraph4.add(chunk5);
		paragraph4.add(chunk6);
		PdfPCell cell5 = new PdfPCell(paragraph4);
		cell5.setBorder(Rectangle.BOX);
		cell5.setBorderColor(BaseColor.YELLOW);

		Chunk chunk7 = new Chunk(context.getResources().getString(
				R.string.depression_severity_level)
				+ ": ", question_font);
		Chunk chunk8 = new Chunk(patientData.getDEPRESSION_LEVEL(), answer_font);

		Paragraph paragraph5 = new Paragraph();
		paragraph5.add(chunk7);
		paragraph5.add(chunk8);
		PdfPCell cell7 = new PdfPCell(paragraph5);
		cell7.setBorder(Rectangle.BOX);
		cell7.setBorderColor(BaseColor.YELLOW);

		Chunk chunk9 = new Chunk(context.getResources().getString(
				R.string.stress_severity_score), question_font);
		Chunk chunk10 = new Chunk(" " + patientData.getSTRESS(), answer_font);

		Paragraph paragraph6 = new Paragraph();
		paragraph6.add(chunk9);
		paragraph6.add(chunk10);
		PdfPCell cell9 = new PdfPCell(paragraph6);
		cell9.setBorder(Rectangle.BOX);
		cell9.setBorderColor(BaseColor.YELLOW);

		Chunk chunk11 = new Chunk(context.getResources().getString(
				R.string.stress_severity_level)
				+ ": ", question_font);
		Chunk chunk12 = new Chunk(patientData.getSTRESS_LEVEL(), answer_font);
		Paragraph paragraph7 = new Paragraph();
		paragraph7.add(chunk11);
		paragraph7.add(chunk12);
		PdfPCell cell11 = new PdfPCell(paragraph7);

		cell11.setBorder(Rectangle.BOX);
		cell11.setBorderColor(BaseColor.YELLOW);

		pdfPTable.addCell(cell1);

		pdfPTable.addCell(cell3);

		pdfPTable.addCell(cell5);

		pdfPTable.addCell(cell7);

		pdfPTable.addCell(cell9);

		pdfPTable.addCell(cell11);
		paragraph.add(new Chunk("Patient results : ", subTitleFont));
		paragraph.add(Chunk.NEWLINE);
		paragraph.add(pdfPTable);

		paragraph.add(Chunk.NEWLINE);

		paragraph.add(new Chunk(context.getResources().getString(
				R.string.q_title_p), subTitleFont));
		paragraph.add(Chunk.NEWLINE);

		Chunk my_chunk1, my_chunk2;

		my_chunk1 = new Chunk(context.getResources().getString(
				R.string.patient_q_1), question_font);
		paragraph.add(my_chunk1);

		my_chunk2 = new Chunk(" " + patientData.getPQ_1(), answer_font);
		paragraph.add(my_chunk2);
		addEmptyLine(paragraph, 1);

		my_chunk1 = new Chunk(context.getResources().getString(
				R.string.patient_q_2), question_font);
		paragraph.add(my_chunk1);

		my_chunk2 = new Chunk(" " + patientData.getPQ_2(), answer_font);
		paragraph.add(my_chunk2);
		addEmptyLine(paragraph, 1);

		my_chunk1 = new Chunk(context.getResources().getString(
				R.string.patient_q_3), question_font);
		paragraph.add(my_chunk1);

		my_chunk2 = new Chunk(" " + patientData.getPQ_3(), answer_font);
		paragraph.add(my_chunk2);
		addEmptyLine(paragraph, 1);

		my_chunk1 = new Chunk(context.getResources().getString(
				R.string.patient_q_4), question_font);
		paragraph.add(my_chunk1);

		my_chunk2 = new Chunk(" " + patientData.getPQ_4(), answer_font);
		paragraph.add(my_chunk2);
		addEmptyLine(paragraph, 1);

		my_chunk1 = new Chunk(context.getResources().getString(
				R.string.patient_q_5), question_font);
		paragraph.add(my_chunk1);

		my_chunk2 = new Chunk(" " + patientData.getPQ_5(), answer_font);
		paragraph.add(my_chunk2);
		addEmptyLine(paragraph, 1);

		my_chunk1 = new Chunk(context.getResources().getString(
				R.string.patient_q_6), question_font);
		paragraph.add(my_chunk1);

		my_chunk2 = new Chunk(" " + patientData.getPQ_6(), answer_font);
		paragraph.add(my_chunk2);
		addEmptyLine(paragraph, 1);

		my_chunk1 = new Chunk(context.getResources().getString(
				R.string.patient_q_7), question_font);
		paragraph.add(my_chunk1);

		my_chunk2 = new Chunk(" " + patientData.getPQ_7(), answer_font);
		paragraph.add(my_chunk2);
		addEmptyLine(paragraph, 1);

		my_chunk1 = new Chunk(context.getResources().getString(
				R.string.patient_q_8), question_font);
		paragraph.add(my_chunk1);

		my_chunk2 = new Chunk(" " + patientData.getPQ_8(), answer_font);
		paragraph.add(my_chunk2);
		addEmptyLine(paragraph, 1);

		my_chunk1 = new Chunk(context.getResources().getString(
				R.string.patient_q_9), question_font);
		paragraph.add(my_chunk1);

		my_chunk2 = new Chunk(" " + patientData.getPQ_9(), answer_font);
		paragraph.add(my_chunk2);
		addEmptyLine(paragraph, 1);

		my_chunk1 = new Chunk(context.getResources().getString(
				R.string.patient_q_10), question_font);
		paragraph.add(my_chunk1);

		my_chunk2 = new Chunk(" " + patientData.getPQ_10(), answer_font);
		paragraph.add(my_chunk2);
		addEmptyLine(paragraph, 1);

		my_chunk1 = new Chunk(context.getResources().getString(
				R.string.patient_q_11), question_font);
		paragraph.add(my_chunk1);

		my_chunk2 = new Chunk(" " + patientData.getPQ_11(), answer_font);
		paragraph.add(my_chunk2);
		addEmptyLine(paragraph, 1);

		my_chunk1 = new Chunk(context.getResources().getString(
				R.string.patient_q_12), question_font);
		paragraph.add(my_chunk1);

		my_chunk2 = new Chunk(" " + patientData.getPQ_12(), answer_font);
		paragraph.add(my_chunk2);
		addEmptyLine(paragraph, 1);

		my_chunk1 = new Chunk(context.getResources().getString(
				R.string.patient_q_13), question_font);
		paragraph.add(my_chunk1);

		my_chunk2 = new Chunk(" " + patientData.getPQ_13(), answer_font);
		paragraph.add(my_chunk2);
		addEmptyLine(paragraph, 1);

		my_chunk1 = new Chunk(context.getResources().getString(
				R.string.patient_q_14), question_font);
		paragraph.add(my_chunk1);

		my_chunk2 = new Chunk(" " + patientData.getPQ_14(), answer_font);
		paragraph.add(my_chunk2);
		addEmptyLine(paragraph, 1);

		my_chunk1 = new Chunk(context.getResources().getString(
				R.string.patient_q_15), question_font);
		paragraph.add(my_chunk1);

		my_chunk2 = new Chunk(" " + patientData.getPQ_15(), answer_font);
		paragraph.add(my_chunk2);
		addEmptyLine(paragraph, 1);

		my_chunk1 = new Chunk(context.getResources().getString(
				R.string.patient_q_16), question_font);
		paragraph.add(my_chunk1);

		my_chunk2 = new Chunk(" " + patientData.getPQ_16(), answer_font);
		paragraph.add(my_chunk2);
		addEmptyLine(paragraph, 1);

		my_chunk1 = new Chunk(context.getResources().getString(
				R.string.patient_q_17), question_font);
		paragraph.add(my_chunk1);

		my_chunk2 = new Chunk(" " + patientData.getPQ_17(), answer_font);
		paragraph.add(my_chunk2);
		addEmptyLine(paragraph, 1);

		my_chunk1 = new Chunk(context.getResources().getString(
				R.string.patient_q_18), question_font);
		paragraph.add(my_chunk1);

		my_chunk2 = new Chunk(" " + patientData.getPQ_18(), answer_font);
		paragraph.add(my_chunk2);
		addEmptyLine(paragraph, 1);

		my_chunk1 = new Chunk(context.getResources().getString(
				R.string.patient_q_19), question_font);
		paragraph.add(my_chunk1);

		my_chunk2 = new Chunk(" " + patientData.getPQ_19(), answer_font);
		paragraph.add(my_chunk2);
		addEmptyLine(paragraph, 1);

		my_chunk1 = new Chunk(context.getResources().getString(
				R.string.patient_q_20), question_font);
		paragraph.add(my_chunk1);

		my_chunk2 = new Chunk(" " + patientData.getPQ_20(), answer_font);
		paragraph.add(my_chunk2);
		addEmptyLine(paragraph, 1);

		my_chunk1 = new Chunk(context.getResources().getString(
				R.string.patient_q_21), question_font);
		paragraph.add(my_chunk1);

		my_chunk2 = new Chunk(" " + patientData.getPQ_21(), answer_font);
		paragraph.add(my_chunk2);
		addEmptyLine(paragraph, 1);

		my_chunk1 = new Chunk(context.getResources().getString(
				R.string.patient_q_22), question_font);
		paragraph.add(my_chunk1);

		my_chunk2 = new Chunk(" " + patientData.getPQ_22(), answer_font);
		paragraph.add(my_chunk2);
		addEmptyLine(paragraph, 1);

		my_chunk1 = new Chunk(context.getResources().getString(
				R.string.patient_q_23), question_font);
		paragraph.add(my_chunk1);

		my_chunk2 = new Chunk(" " + patientData.getPQ_23(), answer_font);
		paragraph.add(my_chunk2);
		addEmptyLine(paragraph, 1);

		my_chunk1 = new Chunk(context.getResources().getString(
				R.string.patient_q_24), question_font);
		paragraph.add(my_chunk1);

		my_chunk2 = new Chunk(" " + patientData.getPQ_24(), answer_font);
		paragraph.add(my_chunk2);
		addEmptyLine(paragraph, 1);

		my_chunk1 = new Chunk(context.getResources().getString(
				R.string.patient_q_25), question_font);
		paragraph.add(my_chunk1);

		my_chunk2 = new Chunk(" " + patientData.getPQ_25(), answer_font);
		paragraph.add(my_chunk2);
		addEmptyLine(paragraph, 1);

		my_chunk1 = new Chunk(context.getResources().getString(
				R.string.patient_q_26), question_font);
		paragraph.add(my_chunk1);

		my_chunk2 = new Chunk(" " + patientData.getPQ_26(), answer_font);
		paragraph.add(my_chunk2);
		addEmptyLine(paragraph, 1);

		my_chunk1 = new Chunk(context.getResources().getString(
				R.string.patient_q_27), question_font);
		paragraph.add(my_chunk1);

		my_chunk2 = new Chunk(" " + patientData.getPQ_27(), answer_font);
		paragraph.add(my_chunk2);
		addEmptyLine(paragraph, 1);

		my_chunk1 = new Chunk(context.getResources().getString(
				R.string.patient_q_28), question_font);
		paragraph.add(my_chunk1);

		my_chunk2 = new Chunk(" " + patientData.getPQ_28(), answer_font);
		paragraph.add(my_chunk2);
		addEmptyLine(paragraph, 1);

		my_chunk1 = new Chunk(context.getResources().getString(
				R.string.patient_q_29), question_font);
		paragraph.add(my_chunk1);

		my_chunk2 = new Chunk(" " + patientData.getPQ_29(), answer_font);
		paragraph.add(my_chunk2);
		addEmptyLine(paragraph, 1);

		my_chunk1 = new Chunk(context.getResources().getString(
				R.string.patient_q_30), question_font);
		paragraph.add(my_chunk1);

		my_chunk2 = new Chunk(" " + patientData.getPQ_30(), answer_font);
		paragraph.add(my_chunk2);
		addEmptyLine(paragraph, 1);

		my_chunk1 = new Chunk(context.getResources().getString(
				R.string.patient_q_31), question_font);
		paragraph.add(my_chunk1);

		my_chunk2 = new Chunk(" " + patientData.getPQ_31(), answer_font);
		paragraph.add(my_chunk2);
		addEmptyLine(paragraph, 1);

		my_chunk1 = new Chunk(context.getResources().getString(
				R.string.patient_q_32), question_font);
		paragraph.add(my_chunk1);

		my_chunk2 = new Chunk(" " + patientData.getPQ_32(), answer_font);
		paragraph.add(my_chunk2);
		addEmptyLine(paragraph, 1);

		my_chunk1 = new Chunk(context.getResources().getString(
				R.string.patient_q_33), question_font);
		paragraph.add(my_chunk1);

		my_chunk2 = new Chunk(" " + patientData.getPQ_33(), answer_font);
		paragraph.add(my_chunk2);
		addEmptyLine(paragraph, 1);

		my_chunk1 = new Chunk(context.getResources().getString(
				R.string.patient_q_34), question_font);
		paragraph.add(my_chunk1);

		my_chunk2 = new Chunk(" " + patientData.getPQ_34(), answer_font);
		paragraph.add(my_chunk2);
		addEmptyLine(paragraph, 1);

		my_chunk1 = new Chunk(context.getResources().getString(
				R.string.patient_q_35), question_font);
		paragraph.add(my_chunk1);

		my_chunk2 = new Chunk(" " + patientData.getPQ_35(), answer_font);
		paragraph.add(my_chunk2);
		addEmptyLine(paragraph, 1);

		my_chunk1 = new Chunk(context.getResources().getString(
				R.string.patient_q_36), question_font);
		paragraph.add(my_chunk1);

		my_chunk2 = new Chunk(" " + patientData.getPQ_36(), answer_font);
		paragraph.add(my_chunk2);
		addEmptyLine(paragraph, 1);

		my_chunk1 = new Chunk(context.getResources().getString(
				R.string.patient_q_37), question_font);
		paragraph.add(my_chunk1);

		my_chunk2 = new Chunk(" " + patientData.getPQ_37(), answer_font);
		paragraph.add(my_chunk2);

		if ((patientData.getALL_QUESTION_STAUS())
				.equals(ConstantValues.STATUS_YES)) {
			addEmptyLine(paragraph, 1);
			paragraph
					.add(new Chunk("Post-feedback questions : ", subTitleFont));
			paragraph.add(Chunk.NEWLINE);

			my_chunk1 = new Chunk(context.getResources().getString(
					R.string.feedback_01), question_font);
			paragraph.add(my_chunk1);

			my_chunk2 = new Chunk(" " + patientData.getPFQ_1(), answer_font);
			paragraph.add(my_chunk2);
			addEmptyLine(paragraph, 1);

			my_chunk1 = new Chunk(context.getResources().getString(
					R.string.feedback_02), question_font);
			paragraph.add(my_chunk1);

			my_chunk2 = new Chunk(" " + patientData.getPFQ_2(), answer_font);
			paragraph.add(my_chunk2);
			addEmptyLine(paragraph, 1);

			my_chunk1 = new Chunk(context.getResources().getString(
					R.string.feedback_03), question_font);
			paragraph.add(my_chunk1);

			my_chunk2 = new Chunk(" " + patientData.getPFQ_3(), answer_font);
			paragraph.add(my_chunk2);
			addEmptyLine(paragraph, 1);

			my_chunk1 = new Chunk(context.getResources().getString(
					R.string.feedback_04), question_font);
			paragraph.add(my_chunk1);

			my_chunk2 = new Chunk(" " + patientData.getPFQ_4(), answer_font);
			paragraph.add(my_chunk2);
			addEmptyLine(paragraph, 1);

			my_chunk1 = new Chunk(context.getResources().getString(
					R.string.feedback_05), question_font);
			paragraph.add(my_chunk1);

			my_chunk2 = new Chunk(" " + patientData.getPFQ_5(), answer_font);
			paragraph.add(my_chunk2);
			addEmptyLine(paragraph, 1);

			my_chunk1 = new Chunk(context.getResources().getString(
					R.string.feedback_06), question_font);
			paragraph.add(my_chunk1);

			my_chunk2 = new Chunk(" " + patientData.getPFQ_6(), answer_font);
			paragraph.add(my_chunk2);
			addEmptyLine(paragraph, 1);

			my_chunk1 = new Chunk(context.getResources().getString(
					R.string.feedback_07), question_font);
			paragraph.add(my_chunk1);

			my_chunk2 = new Chunk(" " + patientData.getPFQ_7(), answer_font);
			paragraph.add(my_chunk2);
			addEmptyLine(paragraph, 1);

			my_chunk1 = new Chunk(context.getResources().getString(
					R.string.feedback_08), question_font);
			paragraph.add(my_chunk1);

			my_chunk2 = new Chunk(" " + patientData.getPFQ_8(), answer_font);
			paragraph.add(my_chunk2);
			addEmptyLine(paragraph, 1);

			my_chunk1 = new Chunk(context.getResources().getString(
					R.string.feedback_09), question_font);
			paragraph.add(my_chunk1);

			my_chunk2 = new Chunk(" " + patientData.getPFQ_9(), answer_font);
			paragraph.add(my_chunk2);
			addEmptyLine(paragraph, 1);

			my_chunk1 = new Chunk(context.getResources().getString(
					R.string.feedback_10), question_font);
			paragraph.add(my_chunk1);

			my_chunk2 = new Chunk(" " + patientData.getPFQ_10(), answer_font);
			paragraph.add(my_chunk2);
			addEmptyLine(paragraph, 1);

			my_chunk1 = new Chunk(context.getResources().getString(
					R.string.feedback_11), question_font);
			paragraph.add(my_chunk1);

			my_chunk2 = new Chunk(" " + patientData.getPFQ_11(), answer_font);
			paragraph.add(my_chunk2);
			addEmptyLine(paragraph, 1);

			my_chunk1 = new Chunk(context.getResources().getString(
					R.string.feedback_12), question_font);
			paragraph.add(my_chunk1);

			my_chunk2 = new Chunk(" " + patientData.getPFQ_12(), answer_font);
			paragraph.add(my_chunk2);
			addEmptyLine(paragraph, 1);

			my_chunk1 = new Chunk(context.getResources().getString(
					R.string.feedback_13), question_font);
			paragraph.add(my_chunk1);

			my_chunk2 = new Chunk(" " + patientData.getPFQ_13(), answer_font);
			paragraph.add(my_chunk2);
			addEmptyLine(paragraph, 1);

			my_chunk1 = new Chunk(context.getResources().getString(
					R.string.feedback_14), question_font);
			paragraph.add(my_chunk1);

			my_chunk2 = new Chunk(" " + patientData.getPFQ_14(), answer_font);
			paragraph.add(my_chunk2);
			addEmptyLine(paragraph, 1);

			my_chunk1 = new Chunk(context.getResources().getString(
					R.string.feedback_15), question_font);
			paragraph.add(my_chunk1);

			my_chunk2 = new Chunk(" " + patientData.getPFQ_15(), answer_font);
			paragraph.add(my_chunk2);
			addEmptyLine(paragraph, 1);

			my_chunk1 = new Chunk(context.getResources().getString(
					R.string.feedback_16), question_font);
			paragraph.add(my_chunk1);

			my_chunk2 = new Chunk(" " + patientData.getPFQ_16(), answer_font);
			paragraph.add(my_chunk2);
			addEmptyLine(paragraph, 1);

			my_chunk1 = new Chunk(context.getResources().getString(
					R.string.feedback_17), question_font);
			paragraph.add(my_chunk1);
			my_chunk2 = new Chunk(" " + patientData.getPFQ_17(), answer_font);
			paragraph.add(my_chunk2);
			addEmptyLine(paragraph, 1);
		}

	}

	private void addEmptyLine(Paragraph paragraph, int number) {
		for (int i = 0; i < number; i++) {
			paragraph.add(new Paragraph(" "));
		}
	}

	public String getSavePath() {

		String file = Environment.getExternalStorageDirectory().toString()
				+ "/patient_print_temp_all_question.pdf";
		try {
			File file_delFile = new File(file);
			file_delFile.delete();

		} catch (Exception e) {
			// TODO: handle exception
		}

		try {

			PdfWriter writer = PdfWriter.getInstance(document,
					new FileOutputStream(file));
			HeaderAndFooter event = new HeaderAndFooter();
			writer.setPageEvent(event);
			cteatePDf();

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return file;
	}

	public void SavePdfFile(String file) {

		try {

			PdfWriter writer = PdfWriter.getInstance(document,
					new FileOutputStream(file));
			HeaderAndFooter event = new HeaderAndFooter();
			writer.setPageEvent(event);
			cteatePDf();

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}

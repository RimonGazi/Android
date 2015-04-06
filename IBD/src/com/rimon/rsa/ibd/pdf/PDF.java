package com.rimon.rsa.ibd.pdf;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Environment;

import com.itextpdf.text.BadElementException;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.rimon.rsa.ibd.main.ConstantValues;
import com.rimon.rsa.ibd.print.PrintResultData;
import com.rimon.rsa.mental.R;

public class PDF {
	PrintResultData data;
	private Context context;

	Document document;

	public PDF(Context ctx, PrintResultData data) {
		context = ctx;
		this.data = data;

		document = new Document();
	}

	private static Font titleFont, subTitleFont, question_font, answer_font;

	public void cteatePDf() throws FileNotFoundException {

		// ByteArrayOutputStream arrayOutputStream = null;
		try {
			titleFont = new Font(Font.FontFamily.TIMES_ROMAN, 20, Font.BOLD);

			question_font = new Font(Font.FontFamily.TIMES_ROMAN, 14,
					Font.NORMAL);
			answer_font = new Font(Font.FontFamily.TIMES_ROMAN, 14,
					Font.NORMAL, new BaseColor(255, 0, 0));

			subTitleFont = new Font(Font.FontFamily.TIMES_ROMAN, 18, Font.BOLD);
			// String file =
			// Environment.getExternalStorageDirectory().toString()
			// + "/pdf.pdf";
			// arrayOutputStream = new ByteArrayOutputStream();

			// PdfWriter.getInstance(document, new FileOutputStream(file));
			Paragraph paragraph = new Paragraph();
			// create first page
			addFirstPageTitle(paragraph);
			addFirstPageFirstQuestionLevel(paragraph);
			addSFirstPageecondQuestionLevel(paragraph);
			addFirstPageThirdQuestionLevel(paragraph);
			// create second page
			Paragraph paragraphSecondPage = new Paragraph();
			addSecontPageTitle(paragraphSecondPage);
			addSecondPageImage(paragraphSecondPage);
			addSecondPageNote(paragraphSecondPage);
			addSecondPageFother(paragraphSecondPage);
			// add page
			document.open();
			document.add(paragraph);

			document.newPage();
			document.add(paragraphSecondPage);
			document.close();
		} catch (DocumentException e) {
			e.printStackTrace();
		}

	}

	private void addFirstPageTitle(Paragraph paragraph) {
		Paragraph title = new Paragraph();
		title.setAlignment(com.itextpdf.text.Element.ALIGN_CENTER);
		title.add(new Chunk(context.getResources().getString(
				R.string.print_title_1), titleFont));
		title.add(Chunk.NEWLINE);
		title.add(new Chunk(context.getResources().getString(
				R.string.print_title_2), titleFont));
		paragraph.add(title);
		addEmptyLine(paragraph, 2);

	}

	private void addFirstPageFirstQuestionLevel(Paragraph paragraph) {

		paragraph.add(new Paragraph(context.getResources().getString(
				R.string.print_question_subtitle_1), subTitleFont));
		addEmptyLine(paragraph, 1);

		Chunk chunk1 = new Chunk(context.getResources().getString(
				R.string.p_q_1, question_font));
		Chunk chunk2 = new Chunk(" " + data.getP_q_1(), answer_font);

		paragraph.add(chunk1);
		paragraph.add(chunk2);
		addEmptyLine(paragraph, 1);
		Chunk chunk3 = new Chunk(context.getResources().getString(
				R.string.p_q_2, question_font));
		Chunk chunk4 = new Chunk(" " + data.getP_q_2(), answer_font);
		paragraph.add(chunk3);
		paragraph.add(chunk4);
		addEmptyLine(paragraph, 1);
		Chunk chunk5 = new Chunk(context.getResources().getString(
				R.string.p_q_3, question_font));
		Chunk chunk6 = new Chunk(" " + data.getP_q_3(), answer_font);

		paragraph.add(chunk5);
		paragraph.add(chunk6);
		addEmptyLine(paragraph, 1);
		Chunk chunk7 = new Chunk(context.getResources().getString(
				R.string.p_q_4, question_font));
		Chunk chunk8 = new Chunk(" " + data.getP_q_4(), answer_font);
		paragraph.add(chunk7);
		paragraph.add(chunk8);
		addEmptyLine(paragraph, 1);

	}

	private void addSFirstPageecondQuestionLevel(Paragraph paragraph) {
		addEmptyLine(paragraph, 1);
		paragraph.add(new Paragraph(context.getResources().getString(
				R.string.print_question_subtitle_2), subTitleFont));
		addEmptyLine(paragraph, 1);

		PdfPTable pdfPTable = new PdfPTable(2);
		pdfPTable.setHorizontalAlignment(com.itextpdf.text.Element.ALIGN_LEFT);
		pdfPTable.setWidthPercentage(100);
		pdfPTable.setSpacingBefore(0f);
		pdfPTable.setSpacingAfter(0f);

		Chunk chunk1 = new Chunk(context.getResources().getString(
				R.string.anxiety_severity_score), question_font);
		Chunk chunk2 = new Chunk(data.getP_q_5(), answer_font);
		Paragraph paragraph2 = new Paragraph();
		paragraph2.add(chunk1);
		paragraph2.add(chunk2);
		PdfPCell cell1 = new PdfPCell(paragraph2);
		cell1.setBorder(Rectangle.NO_BORDER);

		Chunk chunk3 = new Chunk(context.getResources().getString(
				R.string.anxiety_severity_level)
				+ ": ", question_font);
		Chunk chunk4 = new Chunk(data.getP_q_6(), answer_font);

		Paragraph paragraph3 = new Paragraph();
		paragraph3.add(chunk3);
		paragraph3.add(chunk4);
		PdfPCell cell3 = new PdfPCell(paragraph3);

		cell3.setBorder(Rectangle.NO_BORDER);

		Chunk chunk5 = new Chunk(context.getResources().getString(
				R.string.depression_severity_score), question_font);
		Chunk chunk6 = new Chunk(data.getP_q_7(), answer_font);
		Paragraph paragraph4 = new Paragraph();
		paragraph4.add(chunk5);
		paragraph4.add(chunk6);
		PdfPCell cell5 = new PdfPCell(paragraph4);
		cell5.setBorder(Rectangle.NO_BORDER);

		Chunk chunk7 = new Chunk(context.getResources().getString(
				R.string.depression_severity_level)
				+ ": ", question_font);
		Chunk chunk8 = new Chunk(data.getP_q_8(), answer_font);

		Paragraph paragraph5 = new Paragraph();
		paragraph5.add(chunk7);
		paragraph5.add(chunk8);
		PdfPCell cell7 = new PdfPCell(paragraph5);
		cell7.setBorder(Rectangle.NO_BORDER);

		Chunk chunk9 = new Chunk(context.getResources().getString(
				R.string.stress_severity_score), question_font);
		Chunk chunk10 = new Chunk(data.getP_q_9(), answer_font);

		Paragraph paragraph6 = new Paragraph();
		paragraph6.add(chunk9);
		paragraph6.add(chunk10);
		PdfPCell cell9 = new PdfPCell(paragraph6);
		cell9.setBorder(Rectangle.NO_BORDER);

		Chunk chunk11 = new Chunk(context.getResources().getString(
				R.string.stress_severity_level)
				+ ": ", question_font);
		Chunk chunk12 = new Chunk(data.getP_q_10(), answer_font);
		Paragraph paragraph7 = new Paragraph();
		paragraph7.add(chunk11);
		paragraph7.add(chunk12);
		PdfPCell cell11 = new PdfPCell(paragraph7);

		cell11.setBorder(Rectangle.NO_BORDER);

		pdfPTable.addCell(cell1);

		pdfPTable.addCell(cell3);

		pdfPTable.addCell(cell5);

		pdfPTable.addCell(cell7);

		pdfPTable.addCell(cell9);

		pdfPTable.addCell(cell11);

		paragraph.add(pdfPTable);

		addEmptyLine(paragraph, 1);

	}

	private void addFirstPageThirdQuestionLevel(Paragraph paragraph) {

		Chunk chunk1 = new Chunk(context.getResources().getString(
				R.string.suicidal), question_font);
		Chunk chunk2 = new Chunk(" " + data.getP_q_11(), answer_font);
		paragraph.add(chunk1);
		paragraph.add(chunk2);
		addEmptyLine(paragraph, 1);
		Chunk chunk3 = new Chunk(context.getResources().getString(
				R.string.mental_healt_professional), question_font);
		Chunk chunk4 = new Chunk(" " + data.getP_q_12(), answer_font);
		paragraph.add(chunk3);
		paragraph.add(chunk4);
		addEmptyLine(paragraph, 1);
		Chunk chunk5 = new Chunk(context.getResources().getString(
				R.string.symptoms_worsen), question_font);
		Chunk chunk6 = new Chunk(" " + data.getP_q_13(), answer_font);
		paragraph.add(chunk5);
		paragraph.add(chunk6);
		addEmptyLine(paragraph, 1);

	}

	private void addSecondPageFother(Paragraph paragraphSecondPage) {
		Paragraph subtitle06 = new Paragraph(context.getResources().getString(
				R.string.thank_u), subTitleFont);
		subtitle06.setAlignment(com.itextpdf.text.Element.ALIGN_CENTER);
		paragraphSecondPage.add(subtitle06);

	}

	private void addSecondPageNote(Paragraph paragraphSecondPage) {

		Chunk noteChunk = new Chunk(context.getResources().getString(
				R.string.please_note), subTitleFont);

		// noteChunk.setBackground(BaseColor.YELLOW);
		paragraphSecondPage.add(noteChunk);

		Chunk noteDescribtionChunk = new Chunk(context.getResources()
				.getString(R.string.please_note_text), question_font);

		// noteDescribtionChunk.setBackground(BaseColor.YELLOW);
		Paragraph subtitle04 = new Paragraph(noteDescribtionChunk);
		subtitle04.setAlignment(com.itextpdf.text.Element.ALIGN_JUSTIFIED);
		paragraphSecondPage.add(subtitle04);
		addEmptyLine(paragraphSecondPage, 1);

	}

	private void addSecontPageTitle(Paragraph paragraphSecondPage) {
		Paragraph subtitle02 = new Paragraph(context.getResources().getString(
				R.string.second_title), subTitleFont);
		subtitle02.setAlignment(com.itextpdf.text.Element.ALIGN_CENTER);
		paragraphSecondPage.add(subtitle02);
		addEmptyLine(paragraphSecondPage, 1);

	}

	private void addEmptyLine(Paragraph paragraph, int number) {
		for (int i = 0; i < number; i++) {
			paragraph.add(new Paragraph(" "));
		}
	}

	private void addSecondPageImage(Paragraph paragraphSecondPage) {
		InputStream inputStream = null;

		try {

			if ((data.getResult_level()).equals(ConstantValues.VERY_LOW)) {
				inputStream = context.getAssets().open("resutl_1_print.PNG");
			} else if ((data.getResult_level()).equals(ConstantValues.LOW)) {
				inputStream = context.getAssets().open("resutl_2_print.PNG");
			} else if ((data.getResult_level()).equals(ConstantValues.MODERATE)) {
				inputStream = context.getAssets().open("resutl_3_print.PNG");
			} else if ((data.getResult_level()).equals(ConstantValues.HIGH)) {
				inputStream = context.getAssets().open("resutl_4_print.PNG");
			}

			Bitmap bmp = BitmapFactory.decodeStream(inputStream);
			ByteArrayOutputStream stream = new ByteArrayOutputStream();
			bmp.compress(Bitmap.CompressFormat.PNG, 100, stream);
			Image image1 = Image.getInstance(stream.toByteArray());
			image1.setAlignment(Image.MIDDLE);
			paragraphSecondPage.add(image1);
			addEmptyLine(paragraphSecondPage, 1);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (BadElementException e) {
			e.printStackTrace();
		}

	}

	public void SavePdf(String file_name) {

		try {

			PdfWriter writer = PdfWriter.getInstance(document,
					new FileOutputStream(file_name));
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

	public byte[] getPrintData() {
		ByteArrayOutputStream arrayOutputStream = new ByteArrayOutputStream();
		try {

			PdfWriter writer = PdfWriter.getInstance(document,
					arrayOutputStream);
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
		return arrayOutputStream.toByteArray();
	}

	public String getSavePath() {

		String file = Environment.getExternalStorageDirectory().toString()
				+ "/patient_print_temp_file.pdf";
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

}
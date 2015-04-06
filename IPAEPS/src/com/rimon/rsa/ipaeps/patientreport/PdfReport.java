package com.rimon.rsa.ipaeps.patientreport;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;

import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import com.itextpdf.text.BadElementException;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.rimon.rsa.ipaeps.R;
import com.rimon.rsa.ipaeps.module.ModuleAnswer;
import com.rimon.rsa.ipaeps.module.ModuleQuestion;

public class PdfReport {
	private ModuleAnswer moduleAnswer;
	private ModuleQuestion moduleQuestion;
	private BaseColor color_title, color_question, color_answer, color_table_1,
			color_table_2;
	private Context context;
	private int font_size_title = 25;
	private int font_size_head_line = 15;
	private int font_size_module = 20;
	private int font_size_module_sub_title = 14;
	private int font_size_a_q = 12;
	private int font_size_k10_q_ = 20;
	private int font_size_k10_a = 20;

	// private int font_size_title = 26;
	// private int font_size_head_line = 16;
	// private int font_size_module = 20;
	// private int font_size_module_sub_title = 14;
	// private int font_size_a_q = 12;
	// private int font_size_k10_q_ = 22;
	// private int font_size_k10_a = 22;

	private Font font_answer, font_question, font_title, font_module,
			font_head_line_q, font_head_line_a, font_module_sub_title,
			font_k10_q, font_k10_a;

	public PdfReport(Context context, Cursor dataCursor) {
		this.context = context;
		moduleAnswer = new ModuleAnswer(dataCursor);
		moduleQuestion = new ModuleQuestion(context);
		setColor();
		setFont();

	}

	private void setColor() {
		color_title = new BaseColor(31, 73, 125);
		color_question = new BaseColor(0, 0, 0);
		color_answer = new BaseColor(192, 80, 77);
		color_table_1 = new BaseColor(149, 179, 215);
		color_table_2 = new BaseColor(155, 187, 89);

	}

	private void setFont() {
		font_answer = new Font(Font.FontFamily.TIMES_ROMAN, font_size_a_q,
				Font.NORMAL, color_answer);
		font_question = new Font(Font.FontFamily.TIMES_ROMAN, font_size_a_q,
				Font.NORMAL, color_question);
		font_title = new Font(Font.FontFamily.TIMES_ROMAN, font_size_title,
				Font.BOLD, color_title);

		font_module = new Font(Font.FontFamily.TIMES_ROMAN, font_size_module,
				Font.BOLD, color_title);
		font_head_line_q = new Font(Font.FontFamily.TIMES_ROMAN,
				font_size_head_line, Font.NORMAL, color_question);

		font_head_line_a = new Font(Font.FontFamily.TIMES_ROMAN,
				font_size_head_line, Font.NORMAL, color_answer);

		font_module_sub_title = new Font(Font.FontFamily.TIMES_ROMAN,
				font_size_module_sub_title, Font.BOLD, color_title);
		font_k10_q = new Font(Font.FontFamily.TIMES_ROMAN, font_size_k10_q_,
				Font.BOLD, color_question);
		font_k10_a = new Font(Font.FontFamily.TIMES_ROMAN, font_size_k10_a,
				Font.BOLD, color_answer);

	}

	public Paragraph getReportTitle() {
		Paragraph paragraph = new Paragraph();
		paragraph.add(addLine());
		paragraph.add(new Chunk(context.getResources().getString(
				R.string.BRIEF_REPORT), font_title));
		paragraph.add(addLine());
		paragraph.add(addLine());
		paragraph.setAlignment(Element.ALIGN_CENTER);
		return paragraph;

	}

	public Paragraph getReportHeadLIne() {

		Paragraph paragraph = new Paragraph();
		paragraph.add(addLine());
		paragraph
				.add(new Chunk(moduleQuestion.q_module_2_6(), font_head_line_q));
		paragraph.add(new Chunk(moduleAnswer.q_module_2_6(), font_head_line_a));
		paragraph.add(addLine());
		paragraph.add(addLine());
		paragraph.setAlignment(Element.ALIGN_CENTER);
		return paragraph;
	}

	public Paragraph getModule_title_1() {
		Paragraph paragraph = new Paragraph();
		paragraph.add(addLine());
		paragraph.add(new Chunk(context.getString(R.string.report_module_1),
				font_module));
		paragraph.add(addLine());
		paragraph.add(addLine());
		paragraph.setAlignment(Element.ALIGN_CENTER);
		return paragraph;
	}

	public Paragraph getTable_1() {
		Paragraph paragraph = new Paragraph();
		PdfPTable table = new PdfPTable(2);
		table.setWidthPercentage(100);
		table.setSpacingBefore(0);

		table.addCell(getTableCell(moduleQuestion.q_module_3_1(),
				font_question, color_table_1));
		table.addCell(getTableCell(moduleAnswer.q_module_3_1(), font_answer,
				color_table_1));

		table.addCell(getTableCell(moduleQuestion.q_module_3_2(),
				font_question, color_table_1));
		table.addCell(getTableCell(moduleAnswer.q_module_3_2(), font_answer,
				color_table_1));

		table.addCell(getTableCell(moduleQuestion.q_module_3_3(),
				font_question, color_table_1));
		table.addCell(getTableCell(moduleAnswer.q_module_3_3(), font_answer,
				color_table_1));

		table.addCell(getTableCell(moduleQuestion.q_module_3_4(),
				font_question, color_table_1));
		table.addCell(getTableCell(moduleAnswer.q_module_3_4(), font_answer,
				color_table_1));

		table.addCell(getTableCell(moduleQuestion.q_module_3_5(),
				font_question, color_table_1));
		table.addCell(getTableCell(moduleAnswer.q_module_3_5(), font_answer,
				color_table_1));

		table.addCell(getTableCell(moduleQuestion.q_module_3_6(),
				font_question, color_table_1));
		table.addCell(getTableCell(moduleAnswer.q_module_3_6(), font_answer,
				color_table_1));

		table.addCell(getTableCell(moduleQuestion.q_module_3_7(),
				font_question, color_table_1));
		table.addCell(getTableCell(moduleAnswer.q_module_3_7(), font_answer,
				color_table_1));

		table.addCell(getTableCell(moduleQuestion.q_module_3_8(),
				font_question, color_table_1));
		table.addCell(getTableCell(moduleAnswer.q_module_3_8(), font_answer,
				color_table_1));

		table.addCell(getTableCell(moduleQuestion.q_module_3_9(),
				font_question, color_table_1));
		table.addCell(getTableCell(moduleAnswer.q_module_3_9(), font_answer,
				color_table_1));

		table.addCell(getTableCell(moduleQuestion.q_module_3_10(),
				font_question, color_table_1));
		table.addCell(getTableCell(moduleAnswer.q_module_3_10(), font_answer,
				color_table_1));

		table.addCell(getTableCell(moduleQuestion.q_module_3_11(),
				font_question, color_table_1));
		table.addCell(getTableCell(moduleAnswer.q_module_3_11(), font_answer,
				color_table_1));

		table.addCell(getTableCell(moduleQuestion.q_module_3_12(),
				font_question, color_table_1));
		table.addCell(getTableCell(moduleAnswer.q_module_3_12(), font_answer,
				color_table_1));

		table.setSpacingAfter(0);
		paragraph.add(table);
		return paragraph;
	}

	public Paragraph getModule_title_2() {
		Paragraph paragraph = new Paragraph();
		paragraph.add(addLine());
		paragraph.add(addLine());
		paragraph.add(new Chunk(context.getString(R.string.report_module_2),
				font_module));
		paragraph.add(addLine());
		paragraph.add(new Chunk(
				context.getString(R.string.report_module_2_sub),
				font_module_sub_title));
		paragraph.add(addLine());
		paragraph.add(addLine());
		paragraph.setAlignment(Element.ALIGN_CENTER);
		return paragraph;

	}

	public Paragraph getTable_2() {
		Paragraph paragraph = new Paragraph();
		PdfPTable table = new PdfPTable(2);
		table.setWidthPercentage(100);
		table.setSpacingBefore(0);

		table.addCell(getTableCell(moduleQuestion.q_module_3_17(),
				font_question, color_table_2));
		table.addCell(getTableCell(moduleAnswer.q_module_3_17(), font_answer,
				color_table_2));

		table.addCell(getTableCell(moduleQuestion.q_module_3_18(),
				font_question, color_table_2));
		table.addCell(getTableCell(moduleAnswer.q_module_3_18(), font_answer,
				color_table_2));

		table.addCell(getTableCell(moduleQuestion.q_module_3_19(),
				font_question, color_table_2));
		table.addCell(getTableCell(moduleAnswer.q_module_3_19(), font_answer,
				color_table_2));

		table.setSpacingAfter(0);

		paragraph.add(table);
		return paragraph;
	}

	public Paragraph getModule_title_3() {
		Paragraph paragraph = new Paragraph();
		paragraph.add(addLine());
		paragraph.add(addLine());
		paragraph.add(new Chunk(context.getString(R.string.report_module_3),
				font_module));
		paragraph.add(addLine());
		paragraph.add(addLine());
		paragraph.setAlignment(Element.ALIGN_CENTER);

		return paragraph;
	}

	public Paragraph getTable_3() {
		Paragraph paragraph = new Paragraph();
		PdfPTable table = new PdfPTable(2);
		table.setWidthPercentage(100);

		table.addCell(getTableCell(
				context.getResources().getString(R.string.ibd_drug),
				font_question, color_table_1));
		table.addCell(getTableCell(
				context.getResources().getString(R.string.dosage),
				font_question, color_table_1));
		table.addCell(getTableCell(moduleAnswer.q_module_4_1(), font_answer,
				color_table_1));
		table.addCell(getTableCell(moduleAnswer.q_module_4_2(), font_answer,
				color_table_1));

		table.addCell(getTableCell(moduleAnswer.q_module_4_3(), font_answer,
				color_table_1));

		table.addCell(getTableCell(moduleAnswer.q_module_4_4(), font_answer,
				color_table_1));

		table.addCell(getTableCell(moduleAnswer.q_module_4_5(), font_answer,
				color_table_1));

		table.addCell(getTableCell(moduleAnswer.q_module_4_6(), font_answer,
				color_table_1));

		table.addCell(getTableCell(moduleAnswer.q_module_4_7(), font_answer,
				color_table_1));

		table.addCell(getTableCell(moduleAnswer.q_module_4_8(), font_answer,
				color_table_1));

		Paragraph p2 = new Paragraph();
		p2.add(new Chunk(moduleQuestion.q_module_4_9(), font_question));
		p2.add(" : ");
		p2.add(new Chunk(moduleAnswer.q_module_4_9(), font_answer));
		PdfPCell cell = new PdfPCell(p2);
		cell.setColspan(2);
		cell.setBackgroundColor(color_table_1);
		cell.setVerticalAlignment(Element.ALIGN_TOP);
		table.addCell(cell);
		paragraph.add(table);
		return paragraph;

	}

	public Paragraph getModule_title_4() {
		Paragraph paragraph = new Paragraph();

		paragraph.add(addLine());
		paragraph.add(addLine());
		paragraph.add(new Chunk(context.getString(R.string.report_module_4),
				font_module));
		paragraph.add(addLine());
		paragraph.add(addLine());
		paragraph.setAlignment(Element.ALIGN_CENTER);
		return paragraph;

	}

	public Paragraph getTable_4() {

		Paragraph paragraph = new Paragraph();

		PdfPTable table = new PdfPTable(5); // 3 columns.
		table.setWidthPercentage(100);
		table.addCell(getTableCell(
				context.getResources().getString(R.string.q_module_6_1_reort),
				font_question, color_table_2));

		table.addCell(getTableCell(
				context.getResources().getString(R.string.q_module_6_2),
				font_question, color_table_2));
		table.addCell(getTableCell(
				context.getResources().getString(R.string.q_module_6_3),
				font_question, color_table_2));

		table.addCell(getTableCell(
				context.getResources().getString(R.string.q_module_6_4_report),
				font_question, color_table_2));

		table.addCell(getImage());

		table.addCell(getTableCell(moduleAnswer.q_module_6_1(), font_answer,
				color_table_2));
		table.addCell(getTableCell(moduleAnswer.q_module_6_2(), font_answer,
				color_table_2));

		table.addCell(getTableCell(moduleAnswer.q_module_6_3(), font_answer,
				color_table_2));

		table.addCell(getTableCell(moduleAnswer.q_module_6_4(), font_answer,
				color_table_2));

		table.addCell(getTableCell(moduleAnswer.q_module_6_5(), font_answer,
				color_table_2));

		table.addCell(getTableCell(moduleAnswer.q_module_6_6(), font_answer,
				color_table_2));

		table.addCell(getTableCell(moduleAnswer.q_module_6_7(), font_answer,
				color_table_2));

		table.addCell(getTableCell(moduleAnswer.q_module_6_8(), font_answer,
				color_table_2));

		table.addCell(getTableCell(moduleAnswer.q_module_6_9(), font_answer,
				color_table_2));

		table.addCell(getTableCell(moduleAnswer.q_module_6_10(), font_answer,
				color_table_2));

		table.addCell(getTableCell(moduleAnswer.q_module_6_11(), font_answer,
				color_table_2));
		table.addCell(getTableCell(moduleAnswer.q_module_6_12(), font_answer,
				color_table_2));

		paragraph.add(table);
		return paragraph;

	}

	private PdfPCell getImage() {
		PdfPCell cell = new PdfPCell();
		cell.setVerticalAlignment(Element.ALIGN_TOP);
		cell.setNoWrap(false);
		cell.setRowspan(5);
		cell.setBorder(Rectangle.NO_BORDER);
		InputStream inputStream = null;
		try {
			inputStream = context.getAssets().open("bodyhuman.png");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Bitmap bmp = BitmapFactory.decodeStream(inputStream);
		ByteArrayOutputStream stream = new ByteArrayOutputStream();
		bmp.compress(Bitmap.CompressFormat.PNG, 100, stream);
		Image image1 = null;
		try {
			image1 = Image.getInstance(stream.toByteArray());
		} catch (BadElementException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		image1.setAlignment(Image.MIDDLE);
		cell.addElement(image1);
		return cell;
	}

	public Paragraph getModule_title_5() {
		Paragraph paragraph = new Paragraph();
		paragraph.add(addLine());
		paragraph.add(addLine());
		paragraph.add(new Chunk(context.getString(R.string.report_module_5),
				font_module));
		paragraph.add(addLine());
		paragraph.add(addLine());
		paragraph.setAlignment(Element.ALIGN_CENTER);
		return paragraph;

	}

	public Paragraph getTable_5() {
		Paragraph paragraph = new Paragraph();
		PdfPTable table = new PdfPTable(2);
		table.setWidthPercentage(100);
		table.addCell(getTableCell(
				context.getResources().getString(R.string.report_11),
				font_question, color_table_2));
		table.addCell(getTableCell(moduleAnswer.q_module_11(), font_answer,
				color_table_1));
		paragraph.add(table);
		return paragraph;

	}

	public Paragraph getModule_title_6() {
		Paragraph paragraph = new Paragraph();
		paragraph.add(addLine());
		paragraph.add(addLine());
		paragraph.add(new Chunk(context.getString(R.string.report_module_6),
				font_module));
		paragraph.add(addLine());
		paragraph.add(addLine());
		paragraph.setAlignment(Element.ALIGN_CENTER);

		return paragraph;

	}

	public Paragraph getTable_6() {
		Paragraph paragraph = new Paragraph();

		PdfPTable table = new PdfPTable(2);
		table.setWidthPercentage(100);
		table.addCell(getTableCell(moduleQuestion.q_module_7_9(),
				font_question, color_table_1));

		table.addCell(getTableCell(moduleAnswer.q_module_7_9(), font_answer,
				color_table_2));

		table.addCell(getTableCell(moduleQuestion.q_module_7_10(),
				font_question, color_table_1));

		table.addCell(getTableCell(moduleAnswer.q_module_7_10(), font_answer,
				color_table_2));
		table.addCell(getTableCell(moduleQuestion.q_module_7_11(),
				font_question, color_table_1));

		table.addCell(getTableCell(moduleAnswer.q_module_7_11(), font_answer,
				color_table_2));

		table.addCell(getTableCell(moduleQuestion.getK_10Title(), font_k10_q,
				color_table_2));

		table.addCell(getTableCell(moduleAnswer.q_k_10(), font_k10_a,
				color_table_2));

		paragraph.add(table);
		return paragraph;
	}

	public Paragraph getK10Note() {
		Paragraph paragraph = new Paragraph();
		paragraph.add(addLine());
		paragraph.add(new Chunk(moduleQuestion.getk_10Note(), font_question));
		paragraph.add(addLine());
		paragraph.add(new Chunk(moduleQuestion.getk_10Note_2()));
		paragraph.add(addLine());
		return paragraph;
	}

	private PdfPCell getTableCell(String text, Font font,
			BaseColor cellBacgrondColor) {
		PdfPCell cell = new PdfPCell(new Phrase(text, font));
		cell.setBackgroundColor(cellBacgrondColor);
		cell.setVerticalAlignment(Element.ALIGN_TOP);
		cell.setNoWrap(false);
		cell.setRunDirection(PdfWriter.RUN_DIRECTION_LTR);
		return cell;
	}

	private String addLine() {
		return System.getProperty("line.separator");
	}

	public String getPatienId_a() {
		return moduleAnswer.q_module_1_1();

	}

	public String getGlsId_a() {
		return moduleAnswer.q_module_1_2();

	}

	public String getSite_a() {
		return moduleAnswer.q_module_1_3();

	}

	public String getDate_a() {
		return moduleAnswer.getDate();

	}

}

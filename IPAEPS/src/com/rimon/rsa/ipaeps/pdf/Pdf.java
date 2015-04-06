package com.rimon.rsa.ipaeps.pdf;

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
import com.itextpdf.text.pdf.PdfContentByte;
import com.rimon.rsa.ipaeps.R;
import com.rimon.rsa.ipaeps.module.ModuleAnswer;
import com.rimon.rsa.ipaeps.module.ModuleName;
import com.rimon.rsa.ipaeps.module.ModuleQuestion;

public class Pdf {
	private Context context;
	private int color_title_teal, color_question_black, color_result;
	private Font answer_font, question_font, title_font;
	private int title_font_size = 14;
	private int a_q_font_size = 12;
	private ModuleQuestion moduleQuestion;
	private ModuleAnswer moduleAnswer;
	private ModuleName moduleName;

	public Pdf(Context context, Cursor dataCursor) {

		this.context = context;
		moduleAnswer = new ModuleAnswer(dataCursor);
		moduleQuestion = new ModuleQuestion(context);
		moduleName = new ModuleName(context);
		setFont();

	}

	private void setFont() {

		color_title_teal = context.getResources().getColor(R.color.teal);
		color_question_black = context.getResources().getColor(R.color.black);
		color_result = context.getResources().getColor(
				R.color.log_result_text_color);

		title_font = new Font(Font.FontFamily.TIMES_ROMAN, title_font_size,
				Font.NORMAL, new BaseColor(color_title_teal));

		question_font = new Font(Font.FontFamily.TIMES_ROMAN, a_q_font_size,
				Font.NORMAL, new BaseColor(color_question_black));

		answer_font = new Font(Font.FontFamily.TIMES_ROMAN, a_q_font_size,
				Font.NORMAL, new BaseColor(color_result));
	}

	public Paragraph getQuestion_1() {
		Paragraph paragraph = new Paragraph();

		paragraph.add(getQuestionSpan(moduleQuestion.q_module_1_1()));

		paragraph.add(addLine());
		paragraph.add(getAnswerSpan(moduleAnswer.q_module_1_1()));
		paragraph.add(addLine());
		paragraph.add(getQuestionSpan(moduleQuestion.q_module_1_2()));
		paragraph.add(addLine());
		paragraph.add(getAnswerSpan(moduleAnswer.q_module_1_2()));
		paragraph.add(addLine());
		paragraph.add(getQuestionSpan(moduleQuestion.q_module_1_3()));
		paragraph.add(addLine());
		paragraph.add(getAnswerSpan(moduleAnswer.q_module_1_3()));
		return paragraph;
	}

	public Paragraph getQuestion_2() {

		Paragraph paragraph = new Paragraph();

		paragraph.add(getQuestionSpan(moduleQuestion.q_module_2_1()));

		paragraph.add(addLine());

		paragraph.add(getAnswerSpan(moduleAnswer.q_module_2_1()));

		paragraph.add(addLine());

		paragraph.add(getQuestionSpan(moduleQuestion.q_module_2_2()));

		paragraph.add(addLine());

		paragraph.add(getAnswerSpan(moduleAnswer.q_module_2_2()));

		paragraph.add(addLine());

		paragraph.add(getQuestionSpan(moduleQuestion.q_module_2_3()));

		paragraph.add(addLine());

		paragraph.add(getAnswerSpan(moduleAnswer.q_module_2_3()));

		paragraph.add(addLine());

		paragraph.add(getQuestionSpan(moduleQuestion.q_module_2_4()));

		paragraph.add(addLine());

		paragraph.add(getAnswerSpan(moduleAnswer.q_module_2_4()));

		paragraph.add(addLine());

		paragraph.add(getQuestionSpan(moduleQuestion.q_module_2_5()));

		paragraph.add(addLine());

		paragraph.add(getAnswerSpan(moduleAnswer.q_module_2_5()));

		paragraph.add(addLine());

		paragraph.add(getQuestionSpan(moduleQuestion.q_module_2_6()));

		paragraph.add(addLine());

		paragraph.add(getAnswerSpan(moduleAnswer.q_module_2_6()));

		return paragraph;

	}

	public Paragraph getQuestion_3() {
		Paragraph paragraph = new Paragraph();

		paragraph.add(getQuestionSpan(moduleQuestion.q_module_3_1()));
		paragraph.add(addLine());
		paragraph.add(getAnswerSpan(moduleAnswer.q_module_3_1()));
		paragraph.add(addLine());

		paragraph.add(getQuestionSpan(moduleQuestion.q_module_3_2()));

		paragraph.add(addLine());

		paragraph.add(getAnswerSpan(moduleAnswer.q_module_3_2()));

		paragraph.add(addLine());

		paragraph.add(getQuestionSpan(moduleQuestion.q_module_3_3()));

		paragraph.add(addLine());

		paragraph.add(getAnswerSpan(moduleAnswer.q_module_3_3()));

		paragraph.add(addLine());

		paragraph.add(getQuestionSpan(moduleQuestion.q_module_3_4()));

		paragraph.add(addLine());

		paragraph.add(getAnswerSpan(moduleAnswer.q_module_3_4()));

		paragraph.add(addLine());

		paragraph.add(getQuestionSpan(moduleQuestion.q_module_3_5()));

		paragraph.add(addLine());

		paragraph.add(getAnswerSpan(moduleAnswer.q_module_3_5()));
		paragraph.add(addLine());

		paragraph.add(getQuestionSpan(moduleQuestion.q_module_3_6()));

		paragraph.add(addLine());

		paragraph.add(getAnswerSpan(moduleAnswer.q_module_3_6()));
		paragraph.add(addLine());

		paragraph.add(getQuestionSpan(moduleQuestion.q_module_3_7()));

		paragraph.add(addLine());

		paragraph.add(getAnswerSpan(moduleAnswer.q_module_3_7()));
		paragraph.add(addLine());

		paragraph.add(getQuestionSpan(moduleQuestion.q_module_3_8()));

		paragraph.add(addLine());

		paragraph.add(getAnswerSpan(moduleAnswer.q_module_3_8()));
		paragraph.add(addLine());

		paragraph.add(getQuestionSpan(moduleQuestion.q_module_3_9()));

		paragraph.add(addLine());

		paragraph.add(getAnswerSpan(moduleAnswer.q_module_3_9()));
		paragraph.add(addLine());

		paragraph.add(getQuestionSpan(moduleQuestion.q_module_3_10()));

		paragraph.add(addLine());

		paragraph.add(getAnswerSpan(moduleAnswer.q_module_3_10()));
		paragraph.add(addLine());

		paragraph.add(getQuestionSpan(moduleQuestion.q_module_3_11()));

		paragraph.add(addLine());

		paragraph.add(getAnswerSpan(moduleAnswer.q_module_3_11()));
		paragraph.add(addLine());

		paragraph.add(getQuestionSpan(moduleQuestion.q_module_3_12()));

		paragraph.add(addLine());

		paragraph.add(getAnswerSpan(moduleAnswer.q_module_3_12()));
		paragraph.add(addLine());

		paragraph.add(getQuestionSpan(moduleQuestion.q_module_3_13()));

		paragraph.add(addLine());

		paragraph.add(getAnswerSpan(moduleAnswer.q_module_3_13()));
		paragraph.add(addLine());

		paragraph.add(getQuestionSpan(moduleQuestion.q_module_3_14()));

		paragraph.add(addLine());

		paragraph.add(getAnswerSpan(moduleAnswer.q_module_3_14()));
		paragraph.add(addLine());

		paragraph.add(getQuestionSpan(moduleQuestion.q_module_3_15()));

		paragraph.add(addLine());

		paragraph.add(getAnswerSpan(moduleAnswer.q_module_3_15()));
		paragraph.add(addLine());

		paragraph.add(getQuestionSpan(moduleQuestion.q_module_3_16()));

		paragraph.add(addLine());

		paragraph.add(getAnswerSpan(moduleAnswer.q_module_3_16()));
		paragraph.add(addLine());

		paragraph.add(getQuestionSpan(moduleQuestion.q_module_3_17()));

		paragraph.add(addLine());

		paragraph
				.add(getAnswerSpan(moduleAnswer.q_module_3_17() + getIbdNote()));
		paragraph.add(addLine());

		paragraph.add(getQuestionSpan(moduleQuestion.q_module_3_18()));

		paragraph.add(addLine());

		paragraph
				.add(getAnswerSpan(moduleAnswer.q_module_3_18() + getIbdNote()));

		paragraph.add(addLine());

		paragraph.add(getQuestionSpan(moduleQuestion.q_module_3_19()));

		paragraph.add(addLine());

		paragraph
				.add(getAnswerSpan(moduleAnswer.q_module_3_19() + getIbdNote()));
		paragraph.add(addLine());

		return paragraph;

	}

	public Paragraph getQuestion_4() {
		Paragraph paragraph = new Paragraph();

		paragraph.add(getQuestionSpan(moduleQuestion.q_module_4_1()));
		paragraph.add(addLine());

		paragraph.add(getAnswerSpan(moduleAnswer.q_module_4_1()));
		paragraph.add(addLine());

		paragraph.add(getQuestionSpan(moduleQuestion.q_module_4_2()));

		paragraph.add(addLine());

		paragraph.add(getAnswerSpan(moduleAnswer.q_module_4_2()));

		paragraph.add(addLine());

		paragraph.add(getQuestionSpan(moduleQuestion.q_module_4_3()));

		paragraph.add(addLine());

		paragraph.add(getAnswerSpan(moduleAnswer.q_module_4_3()));

		paragraph.add(addLine());

		paragraph.add(getQuestionSpan(moduleQuestion.q_module_4_4()));

		paragraph.add(addLine());

		paragraph.add(getAnswerSpan(moduleAnswer.q_module_4_4()));

		paragraph.add(addLine());

		paragraph.add(getQuestionSpan(moduleQuestion.q_module_4_5()));

		paragraph.add(addLine());

		paragraph.add(getAnswerSpan(moduleAnswer.q_module_4_5()));
		paragraph.add(addLine());

		paragraph.add(getQuestionSpan(moduleQuestion.q_module_4_6()));

		paragraph.add(addLine());

		paragraph.add(getAnswerSpan(moduleAnswer.q_module_4_6()));
		paragraph.add(addLine());

		paragraph.add(getQuestionSpan(moduleQuestion.q_module_4_7()));

		paragraph.add(addLine());

		paragraph.add(getAnswerSpan(moduleAnswer.q_module_4_7()));
		paragraph.add(addLine());

		paragraph.add(getQuestionSpan(moduleQuestion.q_module_4_8()));

		paragraph.add(addLine());

		paragraph.add(getAnswerSpan(moduleAnswer.q_module_4_8()));
		paragraph.add(addLine());

		paragraph.add(getQuestionSpan(moduleQuestion.q_module_4_9()));

		paragraph.add(addLine());

		paragraph.add(getAnswerSpan(moduleAnswer.q_module_4_9()));

		return paragraph;
	}

	public Paragraph getQuestion_5() {
		Paragraph paragraph = new Paragraph();
		paragraph.add(getQuestionSpan(moduleQuestion.q_module_5_1()));

		paragraph.add(addLine());

		paragraph.add(getAnswerSpan(moduleAnswer.q_module_5_1()));

		paragraph.add(addLine());

		paragraph.add(getQuestionSpan(moduleQuestion.q_module_5_2()));

		paragraph.add(addLine());

		paragraph.add(getAnswerSpan(moduleAnswer.q_module_5_2()));

		paragraph.add(addLine());

		paragraph.add(getQuestionSpan(moduleQuestion.q_module_5_3()));

		paragraph.add(addLine());

		paragraph.add(getAnswerSpan(moduleAnswer.q_module_5_3()));

		paragraph.add(addLine());

		paragraph.add(getQuestionSpan(moduleQuestion.q_module_5_4()));

		paragraph.add(addLine());

		paragraph.add(getAnswerSpan(moduleAnswer.q_module_5_4()));

		paragraph.add(addLine());

		paragraph.add(getQuestionSpan(moduleQuestion.q_module_5_5()));

		paragraph.add(addLine());

		paragraph.add(getAnswerSpan(moduleAnswer.q_module_5_5())

		);
		return paragraph;

	}

	public Paragraph getQuestion_6() {
		Paragraph paragraph = new Paragraph();

		paragraph.add(getQuestionSpan(moduleQuestion.q_module_6_1()));

		paragraph.add(addLine());

		paragraph.add(getAnswerSpan(moduleAnswer.q_module_6_1()));
		paragraph.add(addLine());

		paragraph.add(getQuestionSpan(moduleQuestion.q_module_6_2()));

		paragraph.add(addLine());

		paragraph.add(getAnswerSpan(moduleAnswer.q_module_6_2()));

		paragraph.add(addLine());

		paragraph.add(getQuestionSpan(moduleQuestion.q_module_6_3()));

		paragraph.add(addLine());

		paragraph.add(getAnswerSpan(moduleAnswer.q_module_6_3()));

		paragraph.add(addLine());

		paragraph.add(getQuestionSpan(moduleQuestion.q_module_6_4()));

		paragraph.add(addLine());

		paragraph
				.add(getAnswerSpan(moduleAnswer.q_module_6_4() + getPainNote()));

		paragraph.add(addLine());

		paragraph.add(getQuestionSpan(moduleQuestion.q_module_6_5()));

		paragraph.add(addLine());

		paragraph.add(getAnswerSpan(moduleAnswer.q_module_6_5()));
		paragraph.add(addLine());

		paragraph.add(getQuestionSpan(moduleQuestion.q_module_6_6()));

		paragraph.add(addLine());

		paragraph.add(getAnswerSpan(moduleAnswer.q_module_6_6()));
		paragraph.add(addLine());

		paragraph.add(getQuestionSpan(moduleQuestion.q_module_6_7()));

		paragraph.add(addLine());

		paragraph.add(getAnswerSpan(moduleAnswer.q_module_6_7()));
		paragraph.add(addLine());

		paragraph.add(getQuestionSpan(moduleQuestion.q_module_6_8()));

		paragraph.add(addLine());

		paragraph
				.add(getAnswerSpan(moduleAnswer.q_module_6_8() + getPainNote()));
		paragraph.add(addLine());

		paragraph.add(getQuestionSpan(moduleQuestion.q_module_6_9()));

		paragraph.add(addLine());

		paragraph.add(getAnswerSpan(moduleAnswer.q_module_6_9()));
		paragraph.add(addLine());

		paragraph.add(getQuestionSpan(moduleQuestion.q_module_6_10()));

		paragraph.add(addLine());

		paragraph.add(getAnswerSpan(moduleAnswer.q_module_6_10()));
		paragraph.add(addLine());

		paragraph.add(getQuestionSpan(moduleQuestion.q_module_6_11()));

		paragraph.add(addLine());

		paragraph.add(getAnswerSpan(moduleAnswer.q_module_6_11()));
		paragraph.add(addLine());

		paragraph.add(getQuestionSpan(moduleQuestion.q_module_6_12()));
		paragraph.add(addLine());

		paragraph.add(getAnswerSpan(moduleAnswer.q_module_6_12()
				+ getPainNote())

		);

		return paragraph;

	}

	public Paragraph getQuestion_7() {
		Paragraph paragraph = new Paragraph();
		paragraph.add(getQuestionSpan(moduleQuestion.q_module_7_1()
				+ getPainNote()));

		paragraph.add(addLine());

		paragraph
				.add(getAnswerSpan(moduleAnswer.q_module_7_1() + getPainNote()));
		paragraph.add(addLine());

		paragraph.add(getQuestionSpan(moduleQuestion.q_module_7_2()));

		paragraph.add(addLine());

		paragraph
				.add(getAnswerSpan(moduleAnswer.q_module_7_2() + getPainNote()));

		paragraph.add(addLine());

		paragraph.add(getQuestionSpan(moduleQuestion.q_module_7_3()));

		paragraph.add(addLine());

		paragraph
				.add(getAnswerSpan(moduleAnswer.q_module_7_3() + getPainNote()));

		paragraph.add(addLine());

		paragraph.add(getQuestionSpan(moduleQuestion.q_module_7_4()));

		paragraph.add(addLine());

		paragraph
				.add(getAnswerSpan(moduleAnswer.q_module_7_4() + getPainNote()));

		paragraph.add(addLine());

		paragraph.add(getQuestionSpan(moduleQuestion.q_module_7_5()));

		paragraph.add(addLine());

		paragraph.add(getAnswerSpan(moduleAnswer.q_module_7_5()));
		paragraph.add(addLine());

		paragraph.add(getQuestionSpan(moduleQuestion.q_module_7_6()));

		paragraph.add(addLine());

		paragraph.add(getAnswerSpan(moduleAnswer.q_module_7_6()));
		paragraph.add(addLine());

		paragraph.add(getQuestionSpan(moduleQuestion.q_module_7_7()));

		paragraph.add(addLine());

		paragraph.add(getAnswerSpan(moduleAnswer.q_module_7_7()));
		paragraph.add(addLine());

		paragraph.add(getQuestionSpan(moduleQuestion.q_module_7_8()));

		paragraph.add(addLine());

		paragraph.add(getAnswerSpan(moduleAnswer.q_module_7_8()));
		paragraph.add(addLine());

		paragraph.add(getQuestionSpan(moduleQuestion.q_module_7_9()));

		paragraph.add(addLine());

		paragraph.add(getAnswerSpan(moduleAnswer.q_module_7_9()));
		paragraph.add(addLine());

		paragraph.add(getQuestionSpan(moduleQuestion.q_module_7_10()));

		paragraph.add(addLine());

		paragraph.add(getAnswerSpan(moduleAnswer.q_module_7_10()));
		paragraph.add(addLine());

		paragraph.add(getQuestionSpan(moduleQuestion.q_module_7_11()));

		paragraph.add(addLine());

		paragraph.add(getAnswerSpan(moduleAnswer.q_module_7_11()));
		paragraph.add(addLine());

		paragraph.add(getQuestionSpan(moduleQuestion.q_module_7_12()));

		paragraph.add(addLine());

		paragraph.add(getAnswerSpan(moduleAnswer.q_module_7_12()));
		paragraph.add(addLine());

		paragraph.add(getQuestionSpan(moduleQuestion.q_module_7_13()));

		paragraph.add(addLine());

		paragraph.add(getAnswerSpan(moduleAnswer.q_module_7_13()));
		paragraph.add(addLine());

		paragraph.add(getQuestionSpan(moduleQuestion.q_module_7_14()));

		paragraph.add(addLine());

		paragraph.add(getAnswerSpan(moduleAnswer.q_module_7_14()));
		paragraph.add(addLine());

		paragraph.add(getQuestionSpan(moduleQuestion.q_module_7_15()));

		paragraph.add(addLine());

		paragraph.add(getAnswerSpan(moduleAnswer.q_module_7_15()));
		paragraph.add(addLine());

		paragraph.add(getQuestionSpan(moduleQuestion.q_module_7_16()));

		paragraph.add(addLine());

		paragraph.add(getAnswerSpan(moduleAnswer.q_module_7_16()));
		paragraph.add(addLine());

		paragraph.add(getQuestionSpan(moduleQuestion.q_module_7_17()));

		paragraph.add(addLine());

		paragraph.add(getAnswerSpan(moduleAnswer.q_module_7_17()));
		paragraph.add(addLine());

		paragraph.add(getQuestionSpan(moduleQuestion.q_module_7_18()));

		paragraph.add(addLine());

		paragraph.add(getAnswerSpan(moduleAnswer.q_module_7_18()));

		paragraph.add(addLine());

		paragraph.add(getQuestionSpan(moduleQuestion.q_module_7_19()));

		paragraph.add(addLine());

		paragraph.add(getAnswerSpan(moduleAnswer.q_module_7_19()));
		paragraph.add(addLine());

		paragraph.add(getQuestionSpan(moduleQuestion.q_module_7_20()));

		paragraph.add(addLine());

		paragraph.add(getAnswerSpan(moduleAnswer.q_module_7_20()));
		paragraph.add(addLine());

		paragraph.add(getQuestionSpan(moduleQuestion.q_module_7_21()));

		paragraph.add(addLine());
		paragraph.add(getAnswerSpan(moduleAnswer.q_module_7_21()));

		return paragraph;

	}

	public Paragraph getQuestion_8() {
		Paragraph paragraph = new Paragraph();

		paragraph.add(getQuestionSpan(moduleQuestion.q_module_8_1()));

		paragraph.add(addLine());

		paragraph.add(getAnswerSpan(moduleAnswer.q_module_8_1()));

		paragraph.add(addLine());

		paragraph.add(getQuestionSpan(moduleQuestion.q_module_8_2()));

		paragraph.add(addLine());

		paragraph.add(getAnswerSpan(moduleAnswer.q_module_8_2()));

		paragraph.add(addLine());

		paragraph.add(getQuestionSpan(moduleQuestion.q_module_8_3()));

		paragraph.add(addLine());

		paragraph.add(getAnswerSpan(moduleAnswer.q_module_8_3()));

		paragraph.add(addLine());

		paragraph.add(getQuestionSpan(moduleQuestion.q_module_8_4()));
		paragraph.add(addLine());
		paragraph.add(getAnswerSpan(moduleAnswer.q_module_8_4())

		);

		return paragraph;

	}

	public Paragraph getQuestion_9() {
		Paragraph paragraph = new Paragraph();
		paragraph.add(getQuestionSpan(moduleQuestion.q_module_9_1()));

		paragraph.add(addLine());

		paragraph.add(getAnswerSpan(moduleAnswer.q_module_9_1()));

		paragraph.add(addLine());

		paragraph.add(getQuestionSpan(moduleQuestion.q_module_9_2()));

		paragraph.add(addLine());

		paragraph.add(getAnswerSpan(moduleAnswer.q_module_9_2()));

		paragraph.add(addLine());

		paragraph.add(getQuestionSpan(moduleQuestion.q_module_9_3()));

		paragraph.add(addLine());

		paragraph.add(getAnswerSpan(moduleAnswer.q_module_9_3()));

		paragraph.add(addLine());

		paragraph.add(getQuestionSpan(moduleQuestion.q_module_9_4()));

		paragraph.add(addLine());

		paragraph.add(getAnswerSpan(moduleAnswer.q_module_9_4()));

		paragraph.add(addLine());

		paragraph.add(getQuestionSpan(moduleQuestion.q_module_9_5()));

		paragraph.add(addLine());

		paragraph.add(getAnswerSpan(moduleAnswer.q_module_9_5()));

		paragraph.add(addLine());

		paragraph.add(getQuestionSpan(moduleQuestion.q_module_9_6()));

		paragraph.add(addLine());

		paragraph.add(getAnswerSpan(moduleAnswer.q_module_9_6()));
		paragraph.add(addLine());

		paragraph.add(getQuestionSpan(moduleQuestion.q_module_9_7()));

		paragraph.add(addLine());

		paragraph.add(getAnswerSpan(moduleAnswer.q_module_9_7())

		);
		return paragraph;

	}

	public Paragraph getQuestion_10() {
		Paragraph paragraph = new Paragraph();

		paragraph.add(getQuestionSpan(moduleQuestion.q_module_10_1()));

		paragraph.add(addLine());

		paragraph.add(getAnswerSpan(moduleAnswer.q_module_10_1()));

		paragraph.add(addLine());

		paragraph.add(getQuestionSpan(moduleQuestion.q_module_10_2()));

		paragraph.add(addLine());

		paragraph.add(getAnswerSpan(moduleAnswer.q_module_10_2()));

		paragraph.add(addLine());

		paragraph.add(getQuestionSpan(moduleQuestion.q_module_10_3()));

		paragraph.add(addLine());

		paragraph.add(getAnswerSpan(moduleAnswer.q_module_10_3()));

		paragraph.add(addLine());

		paragraph.add(getQuestionSpan(moduleQuestion.q_module_10_4()));

		paragraph.add(addLine());

		paragraph.add(getAnswerSpan(moduleAnswer.q_module_10_4()));

		paragraph.add(addLine());

		paragraph.add(getQuestionSpan(moduleQuestion.q_module_10_5()));

		paragraph.add(addLine());

		paragraph.add(getAnswerSpan(moduleAnswer.q_module_10_5()));

		paragraph.add(addLine());

		paragraph.add(getQuestionSpan(moduleQuestion.q_module_10_6()));

		paragraph.add(addLine());

		paragraph.add(getAnswerSpan(moduleAnswer.q_module_10_6()));

		return paragraph;

	}

	public Paragraph getQuestion_11() {
		Paragraph paragraph = new Paragraph();
		paragraph.add(getQuestionSpan(moduleQuestion.q_module_11()));

		paragraph.add(addLine());

		paragraph.add(getAnswerSpan(moduleAnswer.q_module_11()));

		return paragraph;

	}

	public Paragraph getQuestion_12() {
		Paragraph paragraph = new Paragraph();
		paragraph.add(getQuestionSpan(moduleQuestion.q_module_12_1()));

		paragraph.add(addLine());

		paragraph.add(getAnswerSpan(moduleAnswer.q_module_12_1()));
		paragraph.add(addLine());

		paragraph.add(getQuestionSpan(moduleQuestion.q_module_12_2()));

		paragraph.add(addLine());

		paragraph.add(getAnswerSpan(moduleAnswer.q_module_12_2()));

		paragraph.add(addLine());

		paragraph.add(getQuestionSpan(moduleQuestion.q_module_12_3()));

		paragraph.add(addLine());

		paragraph.add(getAnswerSpan(moduleAnswer.q_module_12_3()));

		paragraph.add(addLine());

		paragraph.add(getQuestionSpan(moduleQuestion.q_module_12_4()));

		paragraph.add(addLine());

		paragraph.add(getAnswerSpan(moduleAnswer.q_module_12_4()));

		paragraph.add(addLine());

		paragraph.add(getQuestionSpan(moduleQuestion.q_module_12_5()));

		paragraph.add(addLine());

		paragraph.add(getAnswerSpan(moduleAnswer.q_module_12_5()));
		paragraph.add(addLine());

		paragraph.add(getQuestionSpan(moduleQuestion.q_module_12_6()));

		paragraph.add(addLine());

		paragraph.add(getAnswerSpan(moduleAnswer.q_module_12_6()));
		paragraph.add(addLine());

		paragraph.add(getQuestionSpan(moduleQuestion.q_module_12_7()));

		paragraph.add(addLine());

		paragraph.add(getAnswerSpan(moduleAnswer.q_module_12_7()));
		paragraph.add(addLine());

		paragraph.add(getQuestionSpan(moduleQuestion.q_module_12_8()));

		paragraph.add(addLine());

		paragraph.add(getAnswerSpan(moduleAnswer.q_module_12_8()));
		paragraph.add(addLine());

		paragraph.add(getQuestionSpan(moduleQuestion.q_module_12_9()));

		paragraph.add(addLine());

		paragraph.add(getAnswerSpan(moduleAnswer.q_module_12_9())

		);
		return paragraph;

	}

	public Paragraph getQuestion_13() {

		Paragraph paragraph = new Paragraph();

		paragraph.add(getQuestionSpan(moduleQuestion.q_module_13_1()));

		paragraph.add(addLine());

		paragraph.add(getAnswerSpan(moduleAnswer.q_module_13_1()));
		paragraph.add(addLine());

		paragraph.add(getQuestionSpan(moduleQuestion.q_module_13_2()));

		paragraph.add(addLine());

		paragraph.add(getAnswerSpan(moduleAnswer.q_module_13_2()));

		paragraph.add(addLine());

		paragraph.add(getQuestionSpan(moduleQuestion.q_module_13_3()));

		paragraph.add(addLine());

		paragraph.add(getAnswerSpan(moduleAnswer.q_module_13_3()));

		paragraph.add(addLine());

		paragraph.add(getQuestionSpan(moduleQuestion.q_module_13_4()));

		paragraph.add(addLine());

		paragraph.add(getAnswerSpan(moduleAnswer.q_module_13_4()));

		paragraph.add(addLine());

		paragraph.add(getQuestionSpan(moduleQuestion.q_module_13_5()));

		paragraph.add(addLine());

		paragraph.add(getAnswerSpan(moduleAnswer.q_module_13_5()));
		paragraph.add(addLine());

		paragraph.add(getQuestionSpan(moduleQuestion.q_module_13_6()));

		paragraph.add(addLine());

		paragraph.add(getAnswerSpan(moduleAnswer.q_module_13_6()));
		paragraph.add(addLine());

		paragraph.add(getQuestionSpan(moduleQuestion.q_module_13_7()));

		paragraph.add(addLine());

		paragraph.add(getAnswerSpan(moduleAnswer.q_module_13_7()));
		paragraph.add(addLine());

		paragraph.add(getQuestionSpan(moduleQuestion.q_module_13_8()));

		paragraph.add(addLine());

		paragraph.add(getAnswerSpan(moduleAnswer.q_module_13_8()));
		paragraph.add(addLine());

		paragraph.add(getQuestionSpan(moduleQuestion.q_module_13_9()));

		paragraph.add(addLine());

		paragraph.add(getAnswerSpan(moduleAnswer.q_module_13_9())

		);

		return paragraph;

	}

	public Paragraph getQuestion_14() {
		Paragraph paragraph = new Paragraph();

		paragraph.add(getQuestionSpan(moduleQuestion.q_module_14_1()));

		paragraph.add(addLine());

		paragraph.add(getAnswerSpan(moduleAnswer.q_module_14_1()));

		paragraph.add(addLine());

		paragraph.add(getQuestionSpan(moduleQuestion.q_module_14_2()));

		paragraph.add(addLine());

		paragraph.add(getAnswerSpan(moduleAnswer.q_module_14_2()));

		paragraph.add(addLine());

		paragraph.add(getQuestionSpan(moduleQuestion.q_module_14_3()));

		paragraph.add(addLine());

		paragraph.add(getAnswerSpan(moduleAnswer.q_module_14_3()));

		paragraph.add(addLine());

		paragraph.add(getQuestionSpan(moduleQuestion.q_module_14_4()));

		paragraph.add(addLine());

		paragraph.add(getAnswerSpan(moduleAnswer.q_module_14_4()));

		paragraph.add(addLine());

		paragraph.add(getQuestionSpan(moduleQuestion.q_module_14_5()));

		paragraph.add(addLine());

		paragraph.add(getAnswerSpan(moduleAnswer.q_module_14_5()));

		paragraph.add(addLine());

		paragraph.add(getQuestionSpan(moduleQuestion.q_module_14_6()));

		paragraph.add(addLine());

		paragraph.add(getAnswerSpan(moduleAnswer.q_module_14_6())

		);

		return paragraph;

	}

	public Paragraph getQuestion_15() {

		Paragraph paragraph = new Paragraph();
		paragraph.add(getQuestionSpan(moduleQuestion.q_module_15_1()));

		paragraph.add(addLine());

		paragraph.add(getAnswerSpan(moduleAnswer.q_module_15_1()));

		paragraph.add(addLine());

		paragraph.add(getQuestionSpan(moduleQuestion.q_module_15_2()));

		paragraph.add(addLine());

		paragraph.add(getAnswerSpan(moduleAnswer.q_module_15_2()));

		paragraph.add(addLine());

		paragraph.add(getQuestionSpan(moduleQuestion.q_module_15_3()));

		paragraph.add(addLine());

		paragraph.add(getAnswerSpan(moduleAnswer.q_module_15_3()));

		paragraph.add(addLine());

		paragraph.add(getQuestionSpan(moduleQuestion.q_module_15_4()));

		paragraph.add(addLine());

		paragraph.add(getAnswerSpan(moduleAnswer.q_module_15_4()));

		return paragraph;

	}

	private Chunk getQuestionSpan(String question) {
		return new Chunk(question, question_font);

	}

	private Chunk getAnswerSpan(String answer) {
		return new Chunk(answer, answer_font);

	}

	private Chunk getModuleTitle(String answer) {
		Chunk chunk = new Chunk(answer, title_font);
		chunk.setUnderline(
				new BaseColor(context.getResources().getColor(
						R.color.setting_line_color)), 2f, 0, -3f, 0,
				PdfContentByte.LINE_CAP_PROJECTING_SQUARE);
		return chunk;

	}

	public Paragraph getModule_title_1() {
		Paragraph paragraph = new Paragraph();
		paragraph.setAlignment(Element.ALIGN_LEFT);
		paragraph.add(addLine());
		paragraph.add(getModuleTitle(moduleName.getModuleName_1()));
		paragraph.add(addLine());

		return paragraph;
	}

	public Paragraph getModule_title_2() {
		Paragraph paragraph = new Paragraph();
		paragraph.setAlignment(Element.ALIGN_LEFT);
		paragraph.add(addLine());
		paragraph.add(getModuleTitle(moduleName.getModuleName_2()));
		paragraph.add(addLine());

		return paragraph;

	}

	public Paragraph getModule_title_3() {
		Paragraph paragraph = new Paragraph();
		paragraph.add(addLine());
		paragraph.add(getModuleTitle(moduleName.getModuleName_3()));
		paragraph.add(addLine());

		paragraph.setAlignment(Element.ALIGN_LEFT);

		return paragraph;

	}

	public Paragraph getModule_title_4() {
		Paragraph paragraph = new Paragraph();
		paragraph.add(addLine());
		paragraph.add(getModuleTitle(moduleName.getModuleName_4()));
		paragraph.add(addLine());

		paragraph.setAlignment(Element.ALIGN_LEFT);
		return paragraph;

	}

	public Paragraph getModule_title_5() {
		Paragraph paragraph = new Paragraph();
		paragraph.add(addLine());
		paragraph.add(getModuleTitle(moduleName.getModuleName_5()));
		paragraph.add(addLine());

		paragraph.setAlignment(Element.ALIGN_LEFT);

		return paragraph;

	}

	public Paragraph getModule_title_6() {
		Paragraph paragraph = new Paragraph();
		paragraph.add(addLine());
		paragraph.add(getModuleTitle(moduleName.getModuleName_6()));
		paragraph.add(addLine());

		paragraph.setAlignment(Element.ALIGN_LEFT);

		return paragraph;

	}

	public Paragraph getModule_title_7() {
		Paragraph paragraph = new Paragraph();
		paragraph.add(addLine());
		paragraph.add(getModuleTitle(moduleName.getModuleName_7()));
		paragraph.add(addLine());

		paragraph.setAlignment(Element.ALIGN_LEFT);

		return paragraph;

	}

	public Paragraph getModule_title_8() {
		Paragraph paragraph = new Paragraph();
		paragraph.add(addLine());

		paragraph.add(getModuleTitle(moduleName.getModuleName_8()));
		paragraph.add(addLine());

		paragraph.setAlignment(Element.ALIGN_LEFT);

		return paragraph;

	}

	public Paragraph getModule_title_9() {
		Paragraph paragraph = new Paragraph();
		paragraph.add(addLine());
		paragraph.add(getModuleTitle(moduleName.getModuleName_9()));
		paragraph.add(addLine());

		paragraph.setAlignment(Element.ALIGN_LEFT);

		return paragraph;

	}

	public Paragraph getModule_title_10() {
		Paragraph paragraph = new Paragraph();
		paragraph.add(addLine());
		paragraph.add(getModuleTitle(moduleName.getModuleName_10()));
		paragraph.add(addLine());

		paragraph.setAlignment(Element.ALIGN_LEFT);

		return paragraph;

	}

	public Paragraph getModule_title_11() {
		Paragraph paragraph = new Paragraph();
		paragraph.add(addLine());
		paragraph.add(getModuleTitle(moduleName.getModuleName_11()));
		paragraph.add(addLine());

		paragraph.setAlignment(Element.ALIGN_LEFT);

		return paragraph;

	}

	public Paragraph getModule_title_12() {
		Paragraph paragraph = new Paragraph();
		paragraph.add(addLine());
		paragraph.add(getModuleTitle(moduleName.getModuleName_12()));
		paragraph.add(addLine());

		paragraph.setAlignment(Element.ALIGN_LEFT);

		return paragraph;

	}

	public Paragraph getModule_title_13() {
		Paragraph paragraph = new Paragraph();
		paragraph.add(addLine());
		paragraph.add(getModuleTitle(moduleName.getModuleName_13()));
		paragraph.add(addLine());

		paragraph.setAlignment(Element.ALIGN_LEFT);

		return paragraph;

	}

	public Paragraph getModule_title_14() {
		Paragraph paragraph = new Paragraph();
		paragraph.add(addLine());
		paragraph.add(getModuleTitle(moduleName.getModuleName_14()));
		paragraph.add(addLine());

		paragraph.setAlignment(Element.ALIGN_LEFT);

		return paragraph;

	}

	public Paragraph getModule_title_15() {
		Paragraph paragraph = new Paragraph();
		paragraph.add(addLine());
		paragraph.add(getModuleTitle(moduleName.getModuleName_15()));
		paragraph.add(addLine());

		paragraph.setAlignment(Element.ALIGN_LEFT);
		return paragraph;
	}

	private String addLine() {
		return System.getProperty("line.separator");
	}

	private String getIbdNote() {
		return context.getResources().getString(R.string.ibd_note);
	}

	private String getPainNote() {
		return context.getResources().getString(R.string.pain_note);
	}

	public Paragraph getReportTitle() {
		Paragraph paragraph = new Paragraph();

		paragraph.add(getModuleTitle(context.getResources().getString(
				R.string.BRIEF_REPORT)));
		paragraph.add(addLine());
		paragraph.add(addLine());
		paragraph.setAlignment(Element.ALIGN_CENTER);
		return paragraph;

	}

	public Paragraph getListTitle() {
		Paragraph paragraph = new Paragraph();

		paragraph.add(getModuleTitle(context.getResources().getString(
				R.string.patient_log_list)));
		paragraph.add(addLine());
		paragraph.add(addLine());
		paragraph.setAlignment(Element.ALIGN_CENTER);
		return paragraph;

	}

	public Paragraph getModule_6_image() {
		InputStream inputStream = null;
		try {
			inputStream = context.getAssets().open("bodyhuman.png");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Paragraph paragraph = new Paragraph();
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
		paragraph.add(image1);
		paragraph.add(addLine());
		return paragraph;
	}

	public Paragraph getk10Score() {

		Paragraph paragraph = new Paragraph();
		paragraph.add(addLine());
		paragraph.add(getModuleTitle(moduleQuestion.getK_10Title()));
		paragraph.setAlignment(Element.ALIGN_LEFT);
		paragraph.add(getAnswerSpan(moduleAnswer.q_k_10()));
		paragraph.add(addLine());

		return paragraph;
	}

	public Paragraph getK10Note() {
		Paragraph paragraph = new Paragraph();
		paragraph.add(addLine());
		paragraph.add(getQuestionSpan(moduleQuestion.getk_10Note()));
		paragraph.add(addLine());
		paragraph.add(getQuestionSpan(moduleQuestion.getk_10Note_2()));
		paragraph.add(addLine());
		return paragraph;
	}
}

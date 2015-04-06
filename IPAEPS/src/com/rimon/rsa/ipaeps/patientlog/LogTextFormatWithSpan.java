package com.rimon.rsa.ipaeps.patientlog;

import android.content.Context;
import android.database.Cursor;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;

import com.rimon.rsa.ipaeps.R;
import com.rimon.rsa.ipaeps.module.ModuleAnswer;
import com.rimon.rsa.ipaeps.module.ModuleQuestion;

public class LogTextFormatWithSpan {
	private Context context;
	private SpannableStringBuilder questionSpan, answerSpan;
	private ModuleQuestion moduleQuestion;
	private ModuleAnswer moduleAnswer;

	public LogTextFormatWithSpan(Context context, Cursor cursor) {
		this.context = context;
		moduleQuestion = new ModuleQuestion(context);
		moduleAnswer = new ModuleAnswer(cursor);
	}

	public CharSequence getQuestion_2() {

		return TextUtils.concat(

		getQuestionSpan(moduleQuestion.q_module_2_1()),

		System.getProperty("line.separator"),

		getAnswerSpan(moduleAnswer.q_module_2_1()),

		System.getProperty("line.separator"),

		getQuestionSpan(moduleQuestion.q_module_2_2()),

		System.getProperty("line.separator"),

		getAnswerSpan(moduleAnswer.q_module_2_2()),

		System.getProperty("line.separator"),

		getQuestionSpan(moduleQuestion.q_module_2_3()),

		System.getProperty("line.separator"),

		getAnswerSpan(moduleAnswer.q_module_2_3()),

		System.getProperty("line.separator"),

		getQuestionSpan(moduleQuestion.q_module_2_4()),

		System.getProperty("line.separator"),

		getAnswerSpan(moduleAnswer.q_module_2_4()),

		System.getProperty("line.separator"),

		getQuestionSpan(moduleQuestion.q_module_2_5()),

		System.getProperty("line.separator"),

		getAnswerSpan(moduleAnswer.q_module_2_5()),

		System.getProperty("line.separator"),

		getQuestionSpan(moduleQuestion.q_module_2_6()),

		System.getProperty("line.separator"),

		getAnswerSpan(moduleAnswer.q_module_2_6())

		);

	}

	public CharSequence getQuestion_3() {

		return TextUtils.concat(

		getQuestionSpan(moduleQuestion.q_module_3_1()),
				System.getProperty("line.separator"),
				getAnswerSpan(moduleAnswer.q_module_3_1()),
				System.getProperty("line.separator"),

				getQuestionSpan(moduleQuestion.q_module_3_2()),

				System.getProperty("line.separator"),

				getAnswerSpan(moduleAnswer.q_module_3_2()),

				System.getProperty("line.separator"),

				getQuestionSpan(moduleQuestion.q_module_3_3()),

				System.getProperty("line.separator"),

				getAnswerSpan(moduleAnswer.q_module_3_3()),

				System.getProperty("line.separator"),

				getQuestionSpan(moduleQuestion.q_module_3_4()),

				System.getProperty("line.separator"),

				getAnswerSpan(moduleAnswer.q_module_3_4()),

				System.getProperty("line.separator"),

				getQuestionSpan(moduleQuestion.q_module_3_5()),

				System.getProperty("line.separator"),

				getAnswerSpan(moduleAnswer.q_module_3_5()),
				System.getProperty("line.separator"),

				getQuestionSpan(moduleQuestion.q_module_3_6()),

				System.getProperty("line.separator"),

				getAnswerSpan(moduleAnswer.q_module_3_6()),
				System.getProperty("line.separator"),

				getQuestionSpan(moduleQuestion.q_module_3_7()),

				System.getProperty("line.separator"),

				getAnswerSpan(moduleAnswer.q_module_3_7()),
				System.getProperty("line.separator"),

				getQuestionSpan(moduleQuestion.q_module_3_8()),

				System.getProperty("line.separator"),

				getAnswerSpan(moduleAnswer.q_module_3_8()),
				System.getProperty("line.separator"),

				getQuestionSpan(moduleQuestion.q_module_3_9()),

				System.getProperty("line.separator"),

				getAnswerSpan(moduleAnswer.q_module_3_9()),
				System.getProperty("line.separator"),

				getQuestionSpan(moduleQuestion.q_module_3_10()),

				System.getProperty("line.separator"),

				getAnswerSpan(moduleAnswer.q_module_3_10()),
				System.getProperty("line.separator"),

				getQuestionSpan(moduleQuestion.q_module_3_11()),

				System.getProperty("line.separator"),

				getAnswerSpan(moduleAnswer.q_module_3_11()),
				System.getProperty("line.separator"),

				getQuestionSpan(moduleQuestion.q_module_3_12()),

				System.getProperty("line.separator"),

				getAnswerSpan(moduleAnswer.q_module_3_12()),
				System.getProperty("line.separator"),

				getQuestionSpan(moduleQuestion.q_module_3_13()),

				System.getProperty("line.separator"),

				getAnswerSpan(moduleAnswer.q_module_3_13()),
				System.getProperty("line.separator"),

				getQuestionSpan(moduleQuestion.q_module_3_14()),

				System.getProperty("line.separator"),

				getAnswerSpan(moduleAnswer.q_module_3_14()),
				System.getProperty("line.separator"),

				getQuestionSpan(moduleQuestion.q_module_3_15()),

				System.getProperty("line.separator"),

				getAnswerSpan(moduleAnswer.q_module_3_15()),
				System.getProperty("line.separator"),

				getQuestionSpan(moduleQuestion.q_module_3_16()),

				System.getProperty("line.separator"),

				getAnswerSpan(moduleAnswer.q_module_3_16()),
				System.getProperty("line.separator"),

				getQuestionSpan(moduleQuestion.q_module_3_17()),

				System.getProperty("line.separator"),

				getAnswerSpan(moduleAnswer.q_module_3_17()),
				System.getProperty("line.separator"),

				getQuestionSpan(moduleQuestion.q_module_3_18()),

				System.getProperty("line.separator"),

				getAnswerSpan(moduleAnswer.q_module_3_18()),

				System.getProperty("line.separator"),

				getQuestionSpan(moduleQuestion.q_module_3_19()),

				System.getProperty("line.separator"),

				getAnswerSpan(moduleAnswer.q_module_3_19()),
				System.getProperty("line.separator")

		);

	}

	public CharSequence getQuestion_4() {

		return TextUtils.concat(System.getProperty("line.separator"),
				getAnswerSpan(moduleAnswer.q_module_4_1()),
				System.getProperty("line.separator"),

				getQuestionSpan(moduleQuestion.q_module_4_2()),

				System.getProperty("line.separator"),

				getAnswerSpan(moduleAnswer.q_module_4_2()),

				System.getProperty("line.separator"),

				getQuestionSpan(moduleQuestion.q_module_4_3()),

				System.getProperty("line.separator"),

				getAnswerSpan(moduleAnswer.q_module_4_3()),

				System.getProperty("line.separator"),

				getQuestionSpan(moduleQuestion.q_module_4_4()),

				System.getProperty("line.separator"),

				getAnswerSpan(moduleAnswer.q_module_4_4()),

				System.getProperty("line.separator"),

				getQuestionSpan(moduleQuestion.q_module_4_5()),

				System.getProperty("line.separator"),

				getAnswerSpan(moduleAnswer.q_module_4_5()),
				System.getProperty("line.separator"),

				getQuestionSpan(moduleQuestion.q_module_4_6()),

				System.getProperty("line.separator"),

				getAnswerSpan(moduleAnswer.q_module_4_6()),
				System.getProperty("line.separator"),

				getQuestionSpan(moduleQuestion.q_module_4_7()),

				System.getProperty("line.separator"),

				getAnswerSpan(moduleAnswer.q_module_4_7()),
				System.getProperty("line.separator"),

				getQuestionSpan(moduleQuestion.q_module_4_8()),

				System.getProperty("line.separator"),

				getAnswerSpan(moduleAnswer.q_module_4_8()),
				System.getProperty("line.separator"),

				getQuestionSpan(moduleQuestion.q_module_4_9()),

				System.getProperty("line.separator"),

				getAnswerSpan(moduleAnswer.q_module_4_9())

		);

	}

	public CharSequence getQuestion_5() {

		return TextUtils.concat(

		getQuestionSpan(moduleQuestion.q_module_5_1()),

		System.getProperty("line.separator"),

		getAnswerSpan(moduleAnswer.q_module_5_1()),

		System.getProperty("line.separator"),

		getQuestionSpan(moduleQuestion.q_module_5_2()),

		System.getProperty("line.separator"),

		getAnswerSpan(moduleAnswer.q_module_5_2()),

		System.getProperty("line.separator"),

		getQuestionSpan(moduleQuestion.q_module_5_3()),

		System.getProperty("line.separator"),

		getAnswerSpan(moduleAnswer.q_module_5_3()),

		System.getProperty("line.separator"),

		getQuestionSpan(moduleQuestion.q_module_5_4()),

		System.getProperty("line.separator"),

		getAnswerSpan(moduleAnswer.q_module_5_4()),

		System.getProperty("line.separator"),

		getQuestionSpan(moduleQuestion.q_module_5_5()),

		System.getProperty("line.separator"),

		getAnswerSpan(moduleAnswer.q_module_5_5())

		);

	}

	public CharSequence getQuestion_6() {

		return TextUtils.concat(

		getQuestionSpan(moduleQuestion.q_module_6_1()),

		System.getProperty("line.separator"),

		getAnswerSpan(moduleAnswer.q_module_6_1()),
				System.getProperty("line.separator"),

				getQuestionSpan(moduleQuestion.q_module_6_2()),

				System.getProperty("line.separator"),

				getAnswerSpan(moduleAnswer.q_module_6_2()),

				System.getProperty("line.separator"),

				getQuestionSpan(moduleQuestion.q_module_6_3()),

				System.getProperty("line.separator"),

				getAnswerSpan(moduleAnswer.q_module_6_3()),

				System.getProperty("line.separator"),

				getQuestionSpan(moduleQuestion.q_module_6_4()),

				System.getProperty("line.separator"),

				getAnswerSpan(moduleAnswer.q_module_6_4()),

				System.getProperty("line.separator"),

				getQuestionSpan(moduleQuestion.q_module_6_5()),

				System.getProperty("line.separator"),

				getAnswerSpan(moduleAnswer.q_module_6_5()),
				System.getProperty("line.separator"),

				getQuestionSpan(moduleQuestion.q_module_6_6()),

				System.getProperty("line.separator"),

				getAnswerSpan(moduleAnswer.q_module_6_6()),
				System.getProperty("line.separator"),

				getQuestionSpan(moduleQuestion.q_module_6_7()),

				System.getProperty("line.separator"),

				getAnswerSpan(moduleAnswer.q_module_6_7()),
				System.getProperty("line.separator"),

				getQuestionSpan(moduleQuestion.q_module_6_8()),

				System.getProperty("line.separator"),

				getAnswerSpan(moduleAnswer.q_module_6_8()),
				System.getProperty("line.separator"),

				getQuestionSpan(moduleQuestion.q_module_6_9()),

				System.getProperty("line.separator"),

				getAnswerSpan(moduleAnswer.q_module_6_9()),
				System.getProperty("line.separator"),

				getQuestionSpan(moduleQuestion.q_module_6_10()),

				System.getProperty("line.separator"),

				getAnswerSpan(moduleAnswer.q_module_6_10()),
				System.getProperty("line.separator"),

				getQuestionSpan(moduleQuestion.q_module_6_11()),

				System.getProperty("line.separator"),

				getAnswerSpan(moduleAnswer.q_module_6_11()),
				System.getProperty("line.separator"),

				getQuestionSpan(moduleQuestion.q_module_6_12()),
				System.getProperty("line.separator"),

				getAnswerSpan(moduleAnswer.q_module_6_12())

		);

	}

	public CharSequence getQuestion_7() {

		return TextUtils.concat(

		getQuestionSpan(moduleQuestion.q_module_7_1()),

		System.getProperty("line.separator"),

		getAnswerSpan(moduleAnswer.q_module_7_1()),
				System.getProperty("line.separator"),

				getQuestionSpan(moduleQuestion.q_module_7_2()),

				System.getProperty("line.separator"),

				getAnswerSpan(moduleAnswer.q_module_7_2()),

				System.getProperty("line.separator"),

				getQuestionSpan(moduleQuestion.q_module_7_3()),

				System.getProperty("line.separator"),

				getAnswerSpan(moduleAnswer.q_module_7_3()),

				System.getProperty("line.separator"),

				getQuestionSpan(moduleQuestion.q_module_7_4()),

				System.getProperty("line.separator"),

				getAnswerSpan(moduleAnswer.q_module_7_4()),

				System.getProperty("line.separator"),

				getQuestionSpan(moduleQuestion.q_module_7_5()),

				System.getProperty("line.separator"),

				getAnswerSpan(moduleAnswer.q_module_7_5()),
				System.getProperty("line.separator"),

				getQuestionSpan(moduleQuestion.q_module_7_6()),

				System.getProperty("line.separator"),

				getAnswerSpan(moduleAnswer.q_module_7_6()),
				System.getProperty("line.separator"),

				getQuestionSpan(moduleQuestion.q_module_7_7()),

				System.getProperty("line.separator"),

				getAnswerSpan(moduleAnswer.q_module_7_7()),
				System.getProperty("line.separator"),

				getQuestionSpan(moduleQuestion.q_module_7_8()),

				System.getProperty("line.separator"),

				getAnswerSpan(moduleAnswer.q_module_7_8()),
				System.getProperty("line.separator"),

				getQuestionSpan(moduleQuestion.q_module_7_9()),

				System.getProperty("line.separator"),

				getAnswerSpan(moduleAnswer.q_module_7_9()),
				System.getProperty("line.separator"),

				getQuestionSpan(moduleQuestion.q_module_7_10()),

				System.getProperty("line.separator"),

				getAnswerSpan(moduleAnswer.q_module_7_10()),
				System.getProperty("line.separator"),

				getQuestionSpan(moduleQuestion.q_module_7_11()),

				System.getProperty("line.separator"),

				getAnswerSpan(moduleAnswer.q_module_7_11()),
				System.getProperty("line.separator"),

				getQuestionSpan(moduleQuestion.q_module_7_12()),

				System.getProperty("line.separator"),

				getAnswerSpan(moduleAnswer.q_module_7_12()),
				System.getProperty("line.separator"),

				getQuestionSpan(moduleQuestion.q_module_7_13()),

				System.getProperty("line.separator"),

				getAnswerSpan(moduleAnswer.q_module_7_13()),
				System.getProperty("line.separator"),

				getQuestionSpan(moduleQuestion.q_module_7_14()),

				System.getProperty("line.separator"),

				getAnswerSpan(moduleAnswer.q_module_7_14()),
				System.getProperty("line.separator"),

				getQuestionSpan(moduleQuestion.q_module_7_15()),

				System.getProperty("line.separator"),

				getAnswerSpan(moduleAnswer.q_module_7_15()),
				System.getProperty("line.separator"),

				getQuestionSpan(moduleQuestion.q_module_7_16()),

				System.getProperty("line.separator"),

				getAnswerSpan(moduleAnswer.q_module_7_16()),
				System.getProperty("line.separator"),

				getQuestionSpan(moduleQuestion.q_module_7_17()),

				System.getProperty("line.separator"),

				getAnswerSpan(moduleAnswer.q_module_7_17()),
				System.getProperty("line.separator"),

				getQuestionSpan(moduleQuestion.q_module_7_18()),

				System.getProperty("line.separator"),

				getAnswerSpan(moduleAnswer.q_module_7_18()),

				System.getProperty("line.separator"),

				getQuestionSpan(moduleQuestion.q_module_7_19()),

				System.getProperty("line.separator"),

				getAnswerSpan(moduleAnswer.q_module_7_19()),
				System.getProperty("line.separator"),

				getQuestionSpan(moduleQuestion.q_module_7_20()),

				System.getProperty("line.separator"),

				getAnswerSpan(moduleAnswer.q_module_7_20()),
				System.getProperty("line.separator"),

				getQuestionSpan(moduleQuestion.q_module_7_21()),

				System.getProperty("line.separator"),

				getAnswerSpan(moduleAnswer.q_module_7_21()),

				System.getProperty("line.separator"),
				getQuestionSpan(moduleQuestion.getK_10Title()),

				System.getProperty("line.separator"),

				getAnswerSpan(moduleAnswer.q_module_7_22()),

				System.getProperty("line.separator"),
				
				getQuestionSpan(moduleQuestion.getk_10Note()),
				
				System.getProperty("line.separator"),
				getQuestionSpan(moduleQuestion.getk_10Note_2())

		);

	}

	public CharSequence getQuestion_8() {

		return TextUtils.concat(

		getQuestionSpan(moduleQuestion.q_module_8_1()),

		System.getProperty("line.separator"),

		getAnswerSpan(moduleAnswer.q_module_8_1()),

		System.getProperty("line.separator"),

		getQuestionSpan(moduleQuestion.q_module_8_2()),

		System.getProperty("line.separator"),

		getAnswerSpan(moduleAnswer.q_module_8_2()),

		System.getProperty("line.separator"),

		getQuestionSpan(moduleQuestion.q_module_8_3()),

		System.getProperty("line.separator"),

		getAnswerSpan(moduleAnswer.q_module_8_3()),

		System.getProperty("line.separator"),

		getQuestionSpan(moduleQuestion.q_module_8_4()),
				System.getProperty("line.separator"),
				getAnswerSpan(moduleAnswer.q_module_8_4())

		);

	}

	public CharSequence getQuestion_9() {

		return TextUtils.concat(

		getQuestionSpan(moduleQuestion.q_module_9_1()),

		System.getProperty("line.separator"),

		getAnswerSpan(moduleAnswer.q_module_9_1()),

		System.getProperty("line.separator"),

		getQuestionSpan(moduleQuestion.q_module_9_2()),

		System.getProperty("line.separator"),

		getAnswerSpan(moduleAnswer.q_module_9_2()),

		System.getProperty("line.separator"),

		getQuestionSpan(moduleQuestion.q_module_9_3()),

		System.getProperty("line.separator"),

		getAnswerSpan(moduleAnswer.q_module_9_3()),

		System.getProperty("line.separator"),

		getQuestionSpan(moduleQuestion.q_module_9_4()),

		System.getProperty("line.separator"),

		getAnswerSpan(moduleAnswer.q_module_9_4()),

		System.getProperty("line.separator"),

		getQuestionSpan(moduleQuestion.q_module_9_5()),

		System.getProperty("line.separator"),

		getAnswerSpan(moduleAnswer.q_module_9_5()),

		System.getProperty("line.separator"),

		getQuestionSpan(moduleQuestion.q_module_9_6()),

		System.getProperty("line.separator"),

		getAnswerSpan(moduleAnswer.q_module_9_6()),
				System.getProperty("line.separator"),

				getQuestionSpan(moduleQuestion.q_module_9_7()),

				System.getProperty("line.separator"),

				getAnswerSpan(moduleAnswer.q_module_9_7())

		);

	}

	public CharSequence getQuestion_10() {

		return TextUtils.concat(

		getQuestionSpan(moduleQuestion.q_module_10_1()),

		System.getProperty("line.separator"),

		getAnswerSpan(moduleAnswer.q_module_10_1()),

		System.getProperty("line.separator"),

		getQuestionSpan(moduleQuestion.q_module_10_2()),

		System.getProperty("line.separator"),

		getAnswerSpan(moduleAnswer.q_module_10_2()),

		System.getProperty("line.separator"),

		getQuestionSpan(moduleQuestion.q_module_10_3()),

		System.getProperty("line.separator"),

		getAnswerSpan(moduleAnswer.q_module_10_3()),

		System.getProperty("line.separator"),

		getQuestionSpan(moduleQuestion.q_module_10_4()),

		System.getProperty("line.separator"),

		getAnswerSpan(moduleAnswer.q_module_10_4()),

		System.getProperty("line.separator"),

		getQuestionSpan(moduleQuestion.q_module_10_5()),

		System.getProperty("line.separator"),

		getAnswerSpan(moduleAnswer.q_module_10_5()),

		System.getProperty("line.separator"),

		getQuestionSpan(moduleQuestion.q_module_10_6()),

		System.getProperty("line.separator"),

		getAnswerSpan(moduleAnswer.q_module_10_6())

		);

	}

	public CharSequence getQuestion_11() {

		return TextUtils.concat(

		getQuestionSpan(moduleQuestion.q_module_11()),

		System.getProperty("line.separator"),

		getAnswerSpan(moduleAnswer.q_module_11())

		);

	}

	public CharSequence getQuestion_12() {

		return TextUtils.concat(

		getQuestionSpan(moduleQuestion.q_module_12_1()),

		System.getProperty("line.separator"),

		getAnswerSpan(moduleAnswer.q_module_12_1()),
				System.getProperty("line.separator"),

				getQuestionSpan(moduleQuestion.q_module_12_2()),

				System.getProperty("line.separator"),

				getAnswerSpan(moduleAnswer.q_module_12_2()),

				System.getProperty("line.separator"),

				getQuestionSpan(moduleQuestion.q_module_12_3()),

				System.getProperty("line.separator"),

				getAnswerSpan(moduleAnswer.q_module_12_3()),

				System.getProperty("line.separator"),

				getQuestionSpan(moduleQuestion.q_module_12_4()),

				System.getProperty("line.separator"),

				getAnswerSpan(moduleAnswer.q_module_12_4()),

				System.getProperty("line.separator"),

				getQuestionSpan(moduleQuestion.q_module_12_5()),

				System.getProperty("line.separator"),

				getAnswerSpan(moduleAnswer.q_module_12_5()),
				System.getProperty("line.separator"),

				getQuestionSpan(moduleQuestion.q_module_12_6()),

				System.getProperty("line.separator"),

				getAnswerSpan(moduleAnswer.q_module_12_6()),
				System.getProperty("line.separator"),

				getQuestionSpan(moduleQuestion.q_module_12_7()),

				System.getProperty("line.separator"),

				getAnswerSpan(moduleAnswer.q_module_12_7()),
				System.getProperty("line.separator"),

				getQuestionSpan(moduleQuestion.q_module_12_8()),

				System.getProperty("line.separator"),

				getAnswerSpan(moduleAnswer.q_module_12_8()),
				System.getProperty("line.separator"),

				getQuestionSpan(moduleQuestion.q_module_12_9()),

				System.getProperty("line.separator"),

				getAnswerSpan(moduleAnswer.q_module_12_9())

		);

	}

	public CharSequence getQuestion_13() {

		return TextUtils.concat(

		getQuestionSpan(moduleQuestion.q_module_13_1()),

		System.getProperty("line.separator"),

		getAnswerSpan(moduleAnswer.q_module_13_1()),
				System.getProperty("line.separator"),

				getQuestionSpan(moduleQuestion.q_module_13_2()),

				System.getProperty("line.separator"),

				getAnswerSpan(moduleAnswer.q_module_13_2()),

				System.getProperty("line.separator"),

				getQuestionSpan(moduleQuestion.q_module_13_3()),

				System.getProperty("line.separator"),

				getAnswerSpan(moduleAnswer.q_module_13_3()),

				System.getProperty("line.separator"),

				getQuestionSpan(moduleQuestion.q_module_13_4()),

				System.getProperty("line.separator"),

				getAnswerSpan(moduleAnswer.q_module_13_4()),

				System.getProperty("line.separator"),

				getQuestionSpan(moduleQuestion.q_module_13_5()),

				System.getProperty("line.separator"),

				getAnswerSpan(moduleAnswer.q_module_13_5()),
				System.getProperty("line.separator"),

				getQuestionSpan(moduleQuestion.q_module_13_6()),

				System.getProperty("line.separator"),

				getAnswerSpan(moduleAnswer.q_module_13_6()),
				System.getProperty("line.separator"),

				getQuestionSpan(moduleQuestion.q_module_13_7()),

				System.getProperty("line.separator"),

				getAnswerSpan(moduleAnswer.q_module_13_7()),
				System.getProperty("line.separator"),

				getQuestionSpan(moduleQuestion.q_module_13_8()),

				System.getProperty("line.separator"),

				getAnswerSpan(moduleAnswer.q_module_13_8()),
				System.getProperty("line.separator"),

				getQuestionSpan(moduleQuestion.q_module_13_9()),

				System.getProperty("line.separator"),

				getAnswerSpan(moduleAnswer.q_module_13_9())

		);

	}

	public CharSequence getQuestion_14() {

		return TextUtils.concat(

		getQuestionSpan(moduleQuestion.q_module_14_1()),

		System.getProperty("line.separator"),

		getAnswerSpan(moduleAnswer.q_module_14_1()),

		System.getProperty("line.separator"),

		getQuestionSpan(moduleQuestion.q_module_14_2()),

		System.getProperty("line.separator"),

		getAnswerSpan(moduleAnswer.q_module_14_2()),

		System.getProperty("line.separator"),

		getQuestionSpan(moduleQuestion.q_module_14_3()),

		System.getProperty("line.separator"),

		getAnswerSpan(moduleAnswer.q_module_14_3()),

		System.getProperty("line.separator"),

		getQuestionSpan(moduleQuestion.q_module_14_4()),

		System.getProperty("line.separator"),

		getAnswerSpan(moduleAnswer.q_module_14_4()),

		System.getProperty("line.separator"),

		getQuestionSpan(moduleQuestion.q_module_14_5()),

		System.getProperty("line.separator"),

		getAnswerSpan(moduleAnswer.q_module_14_5()),

		System.getProperty("line.separator"),

		getQuestionSpan(moduleQuestion.q_module_14_6()),

		System.getProperty("line.separator"),

		getAnswerSpan(moduleAnswer.q_module_14_6())

		);

	}

	public CharSequence getQuestion_15() {

		return TextUtils.concat(

		getQuestionSpan(moduleQuestion.q_module_15_1()),

		System.getProperty("line.separator"),

		getAnswerSpan(moduleAnswer.q_module_15_1()),

		System.getProperty("line.separator"),

		getQuestionSpan(moduleQuestion.q_module_15_2()),

		System.getProperty("line.separator"),

		getAnswerSpan(moduleAnswer.q_module_15_2()),

		System.getProperty("line.separator"),

		getQuestionSpan(moduleQuestion.q_module_15_3()),

		System.getProperty("line.separator"),

		getAnswerSpan(moduleAnswer.q_module_15_3()),

		System.getProperty("line.separator"),

		getQuestionSpan(moduleQuestion.q_module_15_4()),

		System.getProperty("line.separator"),

		getAnswerSpan(moduleAnswer.q_module_15_4())

		);

	}

	private SpannableStringBuilder getQuestionSpan(String question) {
		questionSpan = new SpannableStringBuilder(question);
		questionSpan.setSpan(new ForegroundColorSpan(context.getResources()
				.getColor(R.color.black)), 0, question.length(), 0);
		return questionSpan;

	}

	private SpannableStringBuilder getAnswerSpan(String answer) {
		answerSpan = new SpannableStringBuilder(answer);
		answerSpan.setSpan(new ForegroundColorSpan(context.getResources()
				.getColor(R.color.log_result_text_color)), 0, answer.length(),
				0);
		return answerSpan;

	}

}

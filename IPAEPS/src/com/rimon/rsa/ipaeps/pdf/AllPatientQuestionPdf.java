package com.rimon.rsa.ipaeps.pdf;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import android.content.Context;
import android.database.Cursor;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfWriter;
import com.rimon.rsa.ipaeps.R;

public class AllPatientQuestionPdf {
	private Context context;
	private Document document;
	Rectangle pageSize;
	private int page_bac_color;
	private Pdf logTextFormatNormal;

	public AllPatientQuestionPdf(Context paramContext) {
		this.context = paramContext;
		page_bac_color = context.getResources().getColor(R.color.gray_2);

	}

	public void SavePdf(String paramString, Cursor paramCursor) {
		logTextFormatNormal = new Pdf(context, paramCursor);
		pageSize = new Rectangle(PageSize.A4);
		pageSize.setBackgroundColor(new BaseColor(page_bac_color));

		document = new Document(pageSize);

		try {
			PdfWriter writer = PdfWriter.getInstance(document,
					new FileOutputStream(paramString));
			HeaderAndFooter event = new HeaderAndFooter(context.getResources()
					.getString(R.string.report_footer), false);
			writer.setPageEvent(event);
			cteatePDf();
			return;
		} catch (FileNotFoundException localFileNotFoundException) {
			localFileNotFoundException.printStackTrace();
			return;
		} catch (DocumentException localDocumentException) {
			localDocumentException.printStackTrace();
		}
	}

	public void cteatePDf() throws FileNotFoundException {

		document.open();
		try {
			document.add(logTextFormatNormal.getListTitle());

			document.add(logTextFormatNormal.getModule_title_1());
			document.add(logTextFormatNormal.getQuestion_1());

			document.add(logTextFormatNormal.getModule_title_2());
			document.add(logTextFormatNormal.getQuestion_2());

			document.add(logTextFormatNormal.getModule_title_3());
			document.add(logTextFormatNormal.getQuestion_3());

			document.add(logTextFormatNormal.getModule_title_4());
			document.add(logTextFormatNormal.getQuestion_4());

			document.add(logTextFormatNormal.getModule_title_5());
			document.add(logTextFormatNormal.getQuestion_5());

			document.add(logTextFormatNormal.getModule_title_6());
			document.add(logTextFormatNormal.getQuestion_6());

			document.add(logTextFormatNormal.getModule_title_7());
			document.add(logTextFormatNormal.getQuestion_7());
			document.add(logTextFormatNormal.getk10Score());
			document.add(logTextFormatNormal.getK10Note());

			document.add(logTextFormatNormal.getModule_title_8());
			document.add(logTextFormatNormal.getQuestion_8());

			document.add(logTextFormatNormal.getModule_title_9());
			document.add(logTextFormatNormal.getQuestion_9());

			document.add(logTextFormatNormal.getModule_title_10());
			document.add(logTextFormatNormal.getQuestion_10());

			document.add(logTextFormatNormal.getModule_title_11());
			document.add(logTextFormatNormal.getQuestion_11());

			document.add(logTextFormatNormal.getModule_title_12());
			document.add(logTextFormatNormal.getQuestion_12());

			document.add(logTextFormatNormal.getModule_title_13());
			document.add(logTextFormatNormal.getQuestion_13());

			document.add(logTextFormatNormal.getModule_title_14());
			document.add(logTextFormatNormal.getQuestion_14());

			document.add(logTextFormatNormal.getModule_title_15());
			document.add(logTextFormatNormal.getQuestion_15());

			document.close();
			return;
		} catch (DocumentException localDocumentException) {
			while (true)
				localDocumentException.printStackTrace();
		}
	}

	public byte[] getPrintData() {
		return null;
	}

	public String getSavePath() {
		return null;
	}
}
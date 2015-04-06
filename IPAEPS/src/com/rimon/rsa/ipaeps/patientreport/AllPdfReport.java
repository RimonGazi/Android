package com.rimon.rsa.ipaeps.patientreport;

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
import com.rimon.rsa.ipaeps.pdf.HeaderAndFooter;

public class AllPdfReport {
	private Context context;
	private Document document;
	private Rectangle pageSize;
	private int page_bac_color;
	private PdfReport refort_format;

	public AllPdfReport(Context paramContext) {
		this.context = paramContext;
		page_bac_color = context.getResources().getColor(R.color.white);

	}

	public void SavePdf(String paramString, Cursor paramCursor) {
		refort_format = new PdfReport(context, paramCursor);
		pageSize = new Rectangle(PageSize.A4);
		pageSize.setBackgroundColor(new BaseColor(page_bac_color));
		document = new Document(pageSize);

		try {
			PdfWriter writer = PdfWriter.getInstance(document,
					new FileOutputStream(paramString));
			HeaderAndFooter event = new HeaderAndFooter(context.getResources()
					.getString(R.string.report_footer), true,
					refort_format.getPatienId_a(), refort_format.getGlsId_a(),
					refort_format.getDate_a(), refort_format.getSite_a());
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
			document.add(refort_format.getReportTitle());
			document.add(refort_format.getReportHeadLIne());
			document.add(refort_format.getModule_title_1());
			document.add(refort_format.getTable_1());
			document.add(refort_format.getModule_title_2());
			document.add(refort_format.getTable_2());
			document.newPage();
			document.add(refort_format.getModule_title_3());
			document.add(refort_format.getTable_3());

			document.add(refort_format.getModule_title_4());
			document.add(refort_format.getTable_4());

			document.add(refort_format.getModule_title_5());
			document.add(refort_format.getTable_5());

			document.add(refort_format.getModule_title_6());
			document.add(refort_format.getTable_6());
			document.add(refort_format.getK10Note());
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
package com.rimon.rsa.ibd.pdf;

import java.io.IOException;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfPageEventHelper;
import com.itextpdf.text.pdf.PdfWriter;

public class HeaderAndFooter extends PdfPageEventHelper {

	@Override
	public void onEndPage(PdfWriter writer, Document document) {
		final int currentPageNumber = writer.getCurrentPageNumber();
		try {
			final Rectangle pageSize = document.getPageSize();
			final PdfContentByte directContent = writer.getDirectContent();
			directContent.setColorFill(BaseColor.GRAY);
			directContent.setFontAndSize(BaseFont.createFont(), 10);
			directContent.setTextMatrix(pageSize.getRight(40),
					pageSize.getBottom(30));
			directContent.showText(String.valueOf(currentPageNumber));

		} catch (IOException e) {

		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
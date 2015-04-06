package com.rimon.rsa.ipaeps.pdf;

import java.io.IOException;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfPageEventHelper;
import com.itextpdf.text.pdf.PdfWriter;
public class HeaderAndFooter extends PdfPageEventHelper {
	private String footerString;

	private boolean isEnableHeader;
	private BaseFont baseFont;
	private BaseColor color_foter;
	private Font font_answer, font_question;

	private String q_patient_id, q_gls_id, q_data, q_site, a_patient_id,
			a_gls_id, a_data, a_site;

	public HeaderAndFooter(String footerString, boolean isEnableHeader,
			String a_patient_id, String a_gls_id, String a_data, String a_site) {
		super();
		this.footerString = footerString;
		this.isEnableHeader = isEnableHeader;
		this.q_patient_id = "Patient ID ";
		this.q_gls_id = "Gastroenterologist ID ";
		this.q_data = "Date: ";
		this.q_site = "Site: ";
		this.a_patient_id = a_patient_id;
		this.a_gls_id = a_gls_id;
		this.a_data = a_data;
		this.a_site = a_site;
		color_foter = new BaseColor(142, 228, 216);
		initialized();
	}

	public HeaderAndFooter(String footerString, boolean isEnableHeader) {
		super();
		this.isEnableHeader = isEnableHeader;
		this.footerString = footerString;
		initialized();
	}

	@Override
	public void onStartPage(PdfWriter writer, Document document) {
		if (isEnableHeader) {
			PdfContentByte cb = writer.getDirectContent();

			final Rectangle pageSize = document.getPageSize();
			PdfPTable head = new PdfPTable(4);
			head.setTotalWidth(document.right() - document.left());
			head.addCell(getTableCell(q_patient_id, a_patient_id));
			head.addCell(getTableCell(q_gls_id, a_gls_id));
			head.addCell(getTableCell(q_site, a_site));
			head.addCell(getTableCell(q_data, a_data));
			head.writeSelectedRows(0, -1, document.leftMargin(),
					pageSize.getTop(10), cb);
		}
		super.onStartPage(writer, document);
	}

	@Override
	public void onEndPage(PdfWriter writer, Document document) {
		final int currentPageNumber = writer.getCurrentPageNumber();
		final Rectangle pageSize = document.getPageSize();

		final PdfContentByte directContent = writer.getDirectContent();
		directContent.setColorFill(BaseColor.GRAY);
		directContent.setFontAndSize(baseFont, 10);
		directContent.setTextMatrix(pageSize.getRight(document.rightMargin()),
				pageSize.getBottom(10));

		directContent.showText(String.valueOf(currentPageNumber));
		directContent.setFontAndSize(baseFont, 10);
		directContent.setTextMatrix(document.leftMargin(),
				pageSize.getBottom(10));
		directContent.showText(footerString);
	}

	private void initialized() {

		font_answer = new Font(Font.FontFamily.TIMES_ROMAN, 11, Font.NORMAL,
				color_foter);
		font_question = new Font(Font.FontFamily.TIMES_ROMAN, 11, Font.NORMAL,
				BaseColor.GRAY);
		try {
			baseFont = BaseFont.createFont(BaseFont.TIMES_ROMAN,
					BaseFont.CP1252, BaseFont.NOT_EMBEDDED);
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private PdfPCell getTableCell(String q, String a) {
		Paragraph p = new Paragraph();
		p.add(new Chunk(q, font_question));
		p.add(new Chunk(a, font_answer));
		PdfPCell cell = new PdfPCell(p);
		cell.setBorder(Rectangle.NO_BORDER);
		cell.setVerticalAlignment(Element.ALIGN_TOP);
		cell.setNoWrap(false);
		cell.setRunDirection(PdfWriter.RUN_DIRECTION_LTR);
		return cell;
	}
}
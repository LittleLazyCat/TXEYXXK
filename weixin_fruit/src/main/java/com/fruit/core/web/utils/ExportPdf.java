package com.fruit.core.web.utils;

import java.io.OutputStream;
import java.util.List;


public class ExportPdf extends Export {

	@Override
	public OutputStream writeStream(OutputStream out, String type, List<String[]> records) {
		String[] columns = getColumns(type);
		records.add(0, columns);
		PdfUtil.writeStream(out, records);
		return out;
	}

}

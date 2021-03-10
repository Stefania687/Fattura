package it.objectmethod.fattura.jasper;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import it.objectmethod.fattura.domain.Fattura;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRParameter;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

public class JasperService {
	public byte[] getJasperPrintCountry(List<Fattura> beans) throws Exception {

		JRDataSource jasperBeans = new JRBeanCollectionDataSource(beans, true);

		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put(JRParameter.REPORT_LOCALE, Locale.ITALY);

		String jasperFileName = "templates/QuiVaIlPercorsoDelFile.jasper";

		InputStream report = this.getClass().getClassLoader().getResourceAsStream(jasperFileName);
		JasperPrint print = JasperFillManager.fillReport(report, parameters, jasperBeans);

		byte[] pdf = JasperExportManager.exportReportToPdf(print);
		return pdf;
	}

}

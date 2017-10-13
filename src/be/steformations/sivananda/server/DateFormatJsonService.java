package be.steformations.sivananda.server;

import java.io.IOException;
import java.io.InputStream;
import java.text.DateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;

import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import be.steformations.sivananda.client.http.beans.DateParams;
import be.steformations.sivananda.client.http.beans.DateResult;

@SuppressWarnings("serial")
// peut remplacer la déclaration de la servlet : @WebServlet(urlPatterns="/json/service")
public class DateFormatJsonService extends HttpServlet {

	private Calendar calendar = GregorianCalendar.getInstance();
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("DateFormatJsonService.doPost()");
		ObjectMapper mapper = new ObjectMapper();
		InputStream ips = req.getInputStream();
		DateParams params = mapper.readerFor(DateParams.class).readValue(ips);
		System.out.println(params);
				
		calendar.set(Calendar.DAY_OF_MONTH, params.getDay());
		calendar.set(Calendar.MONTH, params.getMonth());
		calendar.set(Calendar.YEAR, params.getYear());
		DateFormat df = DateFormat.getDateInstance(DateFormat.FULL, new Locale(params.getLocale()));
		String formatted = df.format(calendar.getTime());
		DateResult result = new DateResult();
		result.setDate(calendar.getTime());
		result.setFormattedDate(formatted);
		
		String json = mapper.writeValueAsString(result);
		System.out.println(json);
		
		resp.setContentType("application/json");
		resp.getWriter().write(json);
	}

	
	
}

package be.steformations.sivananda.server;

import java.text.DateFormat;
import java.util.Locale;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import java.util.Calendar;
import java.util.GregorianCalendar;

import be.steformations.sivananda.client.http.beans.DateParams;
import be.steformations.sivananda.client.http.beans.DateResult;
import be.steformations.sivananda.client.http.rpc.DateFormatRpcService;

@SuppressWarnings("serial")
public class DateFormatRpcServiceImpl extends RemoteServiceServlet implements DateFormatRpcService {

	private Calendar calendar = GregorianCalendar.getInstance();
	
	@Override
	public String format(DateParams params) {
		System.out.println("DateFormatRpcServiceImpl.format() =>" + params);
		calendar.set(Calendar.DAY_OF_MONTH, params.getDay());
		calendar.set(Calendar.MONTH, params.getMonth());
		calendar.set(Calendar.YEAR, params.getYear());
		DateFormat df = DateFormat.getDateInstance(DateFormat.FULL, new Locale(params.getLocale()));
		String formatted = df.format(calendar.getTime());
		System.out.println(formatted);
		return formatted;
	}

	@Override
	public DateResult formatToObject(DateParams params) {
		System.out.println("DateFormatRpcServiceImpl.formatToObject()");
		calendar.set(Calendar.DAY_OF_MONTH, params.getDay());
		calendar.set(Calendar.MONTH, params.getMonth());
		calendar.set(Calendar.YEAR, params.getYear());
		DateFormat df = DateFormat.getDateInstance(DateFormat.FULL, new Locale(params.getLocale()));
		String formatted = df.format(calendar.getTime());
		System.out.println(formatted);
		DateResult result = new DateResult();
		result.setDate(calendar.getTime());
		result.setFormattedDate(formatted);
		return result;
	}

}

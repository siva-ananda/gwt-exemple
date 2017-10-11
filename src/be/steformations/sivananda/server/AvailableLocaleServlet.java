package be.steformations.sivananda.server;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gwt.dev.util.collect.HashSet;

@SuppressWarnings("serial")
public class AvailableLocaleServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("AvaibleLocaleServlet.doGet()");
		Locale[] locales = Locale.getAvailableLocales();
		Set<String> set = new HashSet<>();
		for (Locale l : locales) {
			if (! l.getLanguage().isEmpty()){
				set.add(l.getLanguage());
			}
		}
		List<String> list = new ArrayList<String>(set);
		Collections.sort(list);
		
		String s = String.join(",", list);
		resp.setContentType("text/plain");
		resp.getWriter().write(s);
		
	}
	
	

}

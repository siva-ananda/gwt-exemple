package be.steformations.sivananda.client.json;

import com.github.nmorel.gwtjackson.client.ObjectMapper;
import com.google.gwt.core.shared.GWT;
import com.google.gwt.http.client.Request;
import com.google.gwt.http.client.RequestCallback;
import com.google.gwt.http.client.Response;
import com.google.gwt.user.client.Window;

import be.steformations.sivananda.client.DateFormatController;
import be.steformations.sivananda.client.http.beans.DateResult;

public class DateFormatJsonDateResultCallback implements RequestCallback {

	private DateFormatController controller;

	public DateFormatJsonDateResultCallback(DateFormatController controller) {
		super();
		this.controller = controller;
	}

	@Override
	public void onResponseReceived(Request request, Response response) {
		String json = response.getText();
		GWT.log("DateFormatJsonDateResultCallback.onResponseReceived() => " + json);
		ObjectMapper<DateResult> mapper = GWT.create(DateResultObjectMapper.class);
		DateResult result = mapper.read(json);
		GWT.log(result.toString());
		this.controller.setDateResult(result);
	}

	@Override
	public void onError(Request request, Throwable exception) {
		Window.alert(exception.getMessage());
	}

}

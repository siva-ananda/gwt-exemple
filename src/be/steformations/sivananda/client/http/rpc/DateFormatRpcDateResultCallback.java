package be.steformations.sivananda.client.http.rpc;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;

import be.steformations.sivananda.client.DateFormatController;
import be.steformations.sivananda.client.http.beans.DateResult;

public class DateFormatRpcDateResultCallback implements AsyncCallback<DateResult>{

	private DateFormatController controller;
	
	
	public DateFormatRpcDateResultCallback(DateFormatController controller) {
		super();
		this.controller = controller;
	}
	
	@Override
	public void onFailure(Throwable caught) {
		Window.alert(caught.getMessage());
	}

	@Override
	public void onSuccess(DateResult result) {
		GWT.log("DateFormatRpcDateResultCallback.onSuccess() => " + result.toString());
		this.controller.setDateResult(result);
	}

}

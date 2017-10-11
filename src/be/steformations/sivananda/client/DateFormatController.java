package be.steformations.sivananda.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;

import be.steformations.sivananda.client.http.beans.DateParams;
import be.steformations.sivananda.client.http.beans.DateResult;
import be.steformations.sivananda.client.http.rpc.DateFormatRpcDateResultCallback;
import be.steformations.sivananda.client.http.rpc.DateFormatRpcService;
import be.steformations.sivananda.client.http.rpc.DateFormatRpcServiceAsync;
//import be.steformations.sivananda.client.http.rpc.DateFormatRpcStringCallback;
import be.steformations.sivananda.client.ui.DateFormatterUI;

public class DateFormatController implements ClickHandler{

	private DateFormatterUI ui;
	
	public DateFormatController(DateFormatterUI ui) {
		super();
		this.ui = ui;
		this.ui.getFormatEventSource().addClickHandler(this);
	}
	
	@Override
	public void onClick(ClickEvent event) {
		GWT.log("DateFormatController.onClick()");
		DateParams params = new DateParams();
		params.setDay(Integer.parseInt(this.ui.getDayInput().getValue()));
		params.setMonth(Integer.parseInt(this.ui.getMonthInput().getValue()));
		params.setYear(this.ui.getYearInput().getValue());
		params.setLocale(this.ui.getLocaleInput().getValue());
		GWT.log(params.toString());
		
		//this.formatDateRpc(params);
		this.formatDateToObjectRpc(params);
	}
	
	public void setFormatedDate(String s){
		GWT.log("DateFormatController.setFormatedDate()");
		this.ui.getOutput().setText(s);
	}
	
	public void setDateResult(DateResult result) {
		GWT.log("DateFormatController.setDateResult() => " + result.toString());
		this.ui.getOutput().setText(result.getFormattedDate());
	}
	
	/*
	private void formatDateRpc(DateParams params) {
		GWT.log("DateFormatController.formatDateRpc()");
		DateFormatRpcServiceAsync service = GWT.create(DateFormatRpcService.class);
		DateFormatRpcStringCallback callback = new DateFormatRpcStringCallback(this);
		service.format(params, callback); // appel http
	}
	*/

	private void formatDateToObjectRpc(DateParams params) {
		GWT.log("DateFormatController.formatDateToObjectRpc()");
		DateFormatRpcServiceAsync service = GWT.create(DateFormatRpcService.class);
		DateFormatRpcDateResultCallback callback = new DateFormatRpcDateResultCallback(this);
		service.formatToObject(params, callback);
	}


}
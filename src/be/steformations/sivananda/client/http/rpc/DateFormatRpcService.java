package be.steformations.sivananda.client.http.rpc;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

import be.steformations.sivananda.client.http.beans.DateParams;
import be.steformations.sivananda.client.http.beans.DateResult;

@RemoteServiceRelativePath("service") // appelle http://127.0.0.1:8888/dateformatter/service
public interface DateFormatRpcService extends RemoteService{
	
	String format(DateParams params);
	DateResult formatToObject(DateParams params);

}

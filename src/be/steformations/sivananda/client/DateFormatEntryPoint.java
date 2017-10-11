package be.steformations.sivananda.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.RootLayoutPanel;

import be.steformations.sivananda.client.ui.material.DateFormatterMaterial;

public class DateFormatEntryPoint implements EntryPoint {

	@Override
	public void onModuleLoad() {
		DateFormatterMaterial ui = new DateFormatterMaterial();
		new DateFormatController(ui);
		RootLayoutPanel.get().add(ui);

	}

}

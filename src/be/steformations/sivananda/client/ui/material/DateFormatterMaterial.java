package be.steformations.sivananda.client.ui.material;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;

import be.steformations.sivananda.client.ui.DateFormatterUI;
import gwt.material.design.client.ui.MaterialButton;
import gwt.material.design.client.ui.MaterialIntegerBox;
import gwt.material.design.client.ui.MaterialLabel;
import gwt.material.design.client.ui.MaterialListBox;
//import gwt.material.design.client.ui.MaterialTextBox;

public class DateFormatterMaterial extends Composite implements DateFormatterUI {

	private static DateFormatterMaterialUiBinder uiBinder = GWT.create(DateFormatterMaterialUiBinder.class);

	interface DateFormatterMaterialUiBinder extends UiBinder<Widget, DateFormatterMaterial> {
	}

	@UiField
	MaterialListBox dayInput;
	@UiField
	MaterialListBox monthInput;
	@UiField
	MaterialIntegerBox yearInput;
	// @UiField MaterialTextBox localeInput;
	@UiField
	MaterialListBox localeInput;
	@UiField
	MaterialButton formatEventSource;
	@UiField
	MaterialLabel output;

	private final String[] months = new String[] { "janvier", "février", "mars", "avril", "mai", "juin", "juillet",
			"août", "septembre", "octobre", "novembre", "décembre" };

	public DateFormatterMaterial() {
		initWidget(uiBinder.createAndBindUi(this));
		for (int i = 1; i <= 31; i++) {
			this.dayInput.add("" + i);
		}
		for (int i = 0; i < months.length; i++) {
			this.monthInput.addItem("" + i, months[i]);
		}
		this.yearInput.setValue(2017);
		// this.localeInput.setText("en");
	}

	@Override
	public MaterialListBox getDayInput() {
		return dayInput;
	}

	@Override
	public MaterialListBox getMonthInput() {
		return monthInput;
	}

	@Override
	public MaterialIntegerBox getYearInput() {
		return yearInput;
	}

	/*
	 * @Override public MaterialTextBox getLocaleInput() { return localeInput; }
	 */

	@Override
	public MaterialListBox getLocaleInput() {
		return localeInput;
	}

	@Override
	public MaterialButton getFormatEventSource() {
		return formatEventSource;
	}

	@Override
	public MaterialLabel getOutput() {
		return output;
	}

	@Override
	public void setLocales(String[] locales) {
		GWT.log("DateFormatterMaterial.setLocales()");
		this.localeInput.clear();
		for (String s : locales) {
			this.localeInput.add(s);
		}
		if (locales.length > 0) {
			this.localeInput.setSelectedIndex(0);
		}
	}

}

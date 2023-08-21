package com.vaadin.training.framework.exercises.ex10;

import com.vaadin.annotations.Theme;
import com.vaadin.data.Item;
import com.vaadin.data.Property.ValueChangeEvent;
import com.vaadin.data.Property.ValueChangeListener;
import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.Grid;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

@Theme("expenses")
public class SassThemeUI extends UI {

	private static final long serialVersionUID = 1L;
	private Grid table;
	private WarningLabel warningLabel;
	private TextField limit;

	@Override
	protected void init(VaadinRequest request) {
		VerticalLayout layout = new VerticalLayout();
		layout.setMargin(true);

		warningLabel = new WarningLabel("You have exceeded your yearly budget!");
		warningLabel.setVisible(false);
		layout.addComponent(warningLabel);

		limit = createLimitTextField();
		layout.addComponent(limit);

		table = new Grid("Monthly expenses");
		// TODO implement cell style generator

		initalizeAndPopulateTable(table);
		layout.addComponent(table);

		setContent(layout);

	}

	private TextField createLimitTextField() {
		TextField limit = new TextField("Limit for monthly expenses");
		limit.setImmediate(true);
		limit.addValueChangeListener(new ValueChangeListener() {

			private static final long serialVersionUID = 1L;

			@Override
			public void valueChange(ValueChangeEvent event) {
				if (countTotalExpenses() > getMonthlyExpenseLimit() * 12) {
					warningLabel.setVisible(true);
				} else {
					warningLabel.setVisible(false);
				}
			}

		});
		return limit;
	}

	private int getMonthlyExpenseLimit() {
		if (limit.getValue() == null || limit.getValue().toString().isEmpty()) {
			return 100000;
		}
		return Integer.parseInt((String) limit.getValue());
	}

	@SuppressWarnings("unchecked")
	private void initalizeAndPopulateTable(Grid table) {
		table.getContainerDataSource().addContainerProperty("month", String.class, null);
		table.getContainerDataSource().addContainerProperty("expenses", Long.class, null);

		String[] monthNames = new java.text.DateFormatSymbols().getMonths();
		for (int month = 0; month < 12; month++) {
			Item item = table.getContainerDataSource().addItem(month);
			item.getItemProperty("month").setValue(monthNames[month]);
			item.getItemProperty("expenses").setValue(getExpenses());
		}
	}

	private long countTotalExpenses() {
		long totalExpenses = 0;
		for (Object itemId : table.getContainerDataSource().getItemIds()) {
			long expenses = (Long) table.getContainerDataSource().getItem(itemId)
					.getItemProperty("expenses").getValue();
			totalExpenses += expenses;
		}

		return totalExpenses;
	}

	// Randomize a value between 300 and 800
	private long getExpenses() {
		return Math.round((Math.random() * 1000) % 500 + 300);
	}
}

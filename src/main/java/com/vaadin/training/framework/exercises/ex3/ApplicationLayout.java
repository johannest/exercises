package com.vaadin.training.framework.exercises.ex3;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.Button;
import com.vaadin.ui.Label;
import com.vaadin.ui.NativeButton;
import com.vaadin.ui.VerticalLayout;

@SuppressWarnings("serial")
public class ApplicationLayout extends VerticalLayout implements View {

	public ApplicationLayout() {
		Label header = new Label("This is the header. My height is 150 pixels");
		header.setStyleName("header");

		Label navigation = new Label(
				"This is the navigation area. My width is 25% of the window.");
		navigation.setStyleName("navigation");

		Label content = new Label("This is the content area");
		content.setStyleName("content");

		Label footer = new Label(
				"This is the footer area. My height is 100 pixels");
		footer.setStyleName("footer");

		addComponent(header);
		addComponent(navigation);
		addComponent(content);
		addComponent(footer);
	}

	@Override
	public void enter(ViewChangeEvent event) {
		//Navigator method, ignore for now
	}

	/**
	 * Ignore this method for now.
	 * 
	 * @return
	 */
	private Button createButton() {
		NativeButton button = new NativeButton("Ignore");
		button.setHeight("200px");
		button.setWidth("200px");
		return button;
	}

}

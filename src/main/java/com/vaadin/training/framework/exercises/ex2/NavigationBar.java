package com.vaadin.training.framework.exercises.ex2;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.Layout;

/**
 * This view should have four buttons in a layout aligned horizontally in the
 * following way.
 * 
 * +--------------------------------------------------------------------+
 * | [Btn1] [Btn2] [Btn3]                                        [Btn4] |
 * +--------------------------------------------------------------------+
 * 
 */
public class NavigationBar extends CustomComponent implements View {

	private static final long serialVersionUID = 1L;

	public NavigationBar() {
		setCompositionRoot(createNavigationLayout());
	}

	private Layout createNavigationLayout() {
		return null;
	}

	@Override
	public void enter(ViewChangeEvent event) {
		//Navigator method, ignore for now
	}

}

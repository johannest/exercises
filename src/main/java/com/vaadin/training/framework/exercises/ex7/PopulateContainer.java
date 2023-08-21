package com.vaadin.training.framework.exercises.ex7;

import com.vaadin.data.util.IndexedContainer;
import com.vaadin.event.SelectionEvent;
import com.vaadin.event.SelectionEvent.SelectionListener;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.Grid;
import com.vaadin.ui.Grid.SelectionMode;
import com.vaadin.ui.Notification;
import com.vaadin.ui.VerticalLayout;

@SuppressWarnings("serial")
public class PopulateContainer extends VerticalLayout implements View {

	public PopulateContainer() {
		Grid table = new Grid();
		table.setContainerDataSource(createContainer());
		table.setImmediate(true);
		table.setSelectionMode(SelectionMode.SINGLE);
		table.addSelectionListener(new SelectionListener() {

			@Override
			public void select(SelectionEvent event) {
				if (event.getSelected().size() > 0)
					Notification
							.show(event.getSelected().iterator().next().toString());
			}
		});

		addComponent(table);
	}

	/**
	 * Creates a container containing three items
	 * 
	 * name 	 | sector			 | 
	 * ----------+-------------------+ 
	 * John Doe  | Private customer  |
	 * Vaadin  	 | Company			 | 
	 * EFF	 	 | Organization 	 | 
	 * ----------+-------------------+
	 * 
	 * @return
	 */
	@SuppressWarnings("unchecked")
	private IndexedContainer createContainer() {
		// TODO
		return null;
	}

	@Override
	public void enter(ViewChangeEvent event) {
		//Navigator method, ignore for now
	}
}

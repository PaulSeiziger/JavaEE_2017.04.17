package ru.sendto.jee.web.client.view;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;

/**
 * Добавление компа. Singleton.
 */
public class QuizView extends Composite {

	private static ExampleUiBinder uiBinder = GWT.create(ExampleUiBinder.class);

	interface ExampleUiBinder extends UiBinder<Widget, QuizView> {
	}
	
	{initWidget(uiBinder.createAndBindUi(this));}

	
	public QuizView() {
	}


}

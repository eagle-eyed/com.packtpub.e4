








package com.packtpub.e4.clock.ui.views;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Canvas;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.part.ViewPart;

import com.packtpub.e4.clock.ui.ClockWidget;

/**
 * Provides a ClockView to show clocks
 */
public class ClockView extends ViewPart {
	/**
	 * Called by Eclipse 3.x to populate the view
	 */
	@SuppressWarnings("unused")
	public void createPartControl(Composite parent) {
		final Canvas clock = new ClockWidget(parent, SWT.NONE);
	}
	
	/**
	 * Called by Eclipse 3.x to notify the view has focus
	 */
	public void setFocus() {
	}
}
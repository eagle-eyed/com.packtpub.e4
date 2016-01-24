








package com.packtpub.e4.clock.ui.views;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.swt.layout.RowData;
import org.eclipse.swt.layout.RowLayout;
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
		Object[] oo = parent.getDisplay().getDeviceData().objects;
		int c = 0;
		for (int i = 0; i < oo.length; i++)
			if (oo[i] instanceof Color)
				c++;
		System.err.println("There are " + c + " Color instances");
		RowLayout layout = new RowLayout(SWT.HORIZONTAL);
		parent.setLayout(layout);
		final ClockWidget clock1 = new ClockWidget(parent, SWT.NONE, new RGB(
				255, 0, 0));
		final ClockWidget clock2 = new ClockWidget(parent, SWT.NONE, new RGB(
				0, 255, 0));
		final ClockWidget clock3 = new ClockWidget(parent, SWT.NONE, new RGB(
				0, 0, 255));
		clock1.setLayoutData(new RowData(20,20));
		clock3.setLayoutData(new RowData(100,100));
	}
	
	/**
	 * Called by Eclipse 3.x to notify the view has focus
	 */
	public void setFocus() {
	}
}









package com.packtpub.e4.clock.ui.views;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.events.PaintListener;
import org.eclipse.swt.widgets.Canvas;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.part.ViewPart;

/**
 * Provides a ClockView to show clocks
 */
public class ClockView extends ViewPart {
	/**
	 * Called by Eclipse 3.x to populate the view
	 */
	public void createPartControl(Composite parent) {
		final Canvas clock = new Canvas(parent, SWT.NONE);
		clock.addPaintListener(new PaintListener() {
			public void paintControl(PaintEvent e) {
				e.gc.drawArc(e.x, e.y, e.width-1, e.height-1, 0, 360);
			}
		});
	}
	/**
	 * Called by Eclipse 3.x to notify the view has focus
	 */
	public void setFocus() {
	}
}
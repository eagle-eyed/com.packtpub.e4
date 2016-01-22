








package com.packtpub.e4.clock.ui.views;

import java.util.Calendar;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.events.PaintListener;
import org.eclipse.swt.graphics.Color;
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
				int seconds = Calendar.getInstance().get(Calendar.SECOND);
				int arc = (15 - seconds) * 6 % 360;
				Color blue = e.display.getSystemColor(SWT.COLOR_BLUE);
				e.gc.setBackground(blue);
				e.gc.fillArc(e.x, e.y, e.width - 1, e.height - 1, arc - 2, 4);
			}
		});
	}
	
	/**
	 * Called by Eclipse 3.x to notify the view has focus
	 */
	public void setFocus() {
	}
}
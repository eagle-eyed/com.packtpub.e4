








package com.packtpub.e4.clock.ui;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.events.PaintListener;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.swt.widgets.Canvas;
import org.eclipse.swt.widgets.Composite;

public class ClockWidget extends Canvas {
	private final Color color;

	public ClockWidget(Composite parent, int style, RGB rgb) {
		
		super(parent, style);
		// FIXME color is leaked!
		this.color = new Color(parent.getDisplay(),rgb);
		addPaintListener(new PaintListener() {
			public void paintControl(PaintEvent e) {
				ClockWidget.this.paintControl(e);
			}
		});
		new Thread("TickTock") {
			public void run() {
				while (!ClockWidget.this.isDisposed()) {
					ClockWidget.this.getDisplay().asyncExec(new Runnable() {
						public void run() {
							if (!ClockWidget.this.isDisposed())
								ClockWidget.this.redraw();
						}
					});
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						return;
					}
				}
			};
		}.start();
	}
	
//	@SuppressWarnings("deprecation")
	public void paintControl(PaintEvent e) {
//		SimpleDateFormat sdfDate = new SimpleDateFormat("yyyy-MM-dd");
//		Date now = Calendar.getInstance().getTime();
//		String strDate =sdfDate.format(now);
//		Point lenStr = e.gc.textExtent(strDate);
//		e.gc.drawText(strDate, (int)(e.x+e.width/2-lenStr.x/2), (int)(e.y+e.height/2-1.25*lenStr.y));
//		sdfDate = new SimpleDateFormat("hh:mm:ss");
//		strDate = sdfDate.format(now);
//		lenStr = e.gc.textExtent(strDate);
//		e.gc.drawText(strDate, (int)(e.x+e.width/2-lenStr.x/2), (int)(e.y+e.height/2+.25*lenStr.y));
//		e.gc.drawLine(0, e.height/2, e.width, e.height/2);
//		e.gc.drawLine(e.width/2, 0, e.width/2, e.height);

		e.gc.drawArc(e.x,e.y,e.width - 1, e.height - 1, 0, 360);
		int seconds = Calendar.getInstance().get(Calendar.SECOND);
		int arc = (15 - seconds) * 6 % 360;
		//Color blue = e.display.getSystemColor(SWT.COLOR_BLUE);
		e.gc.setBackground(color);
		e.gc.fillArc(e.x, e.y, e.width - 1, e.height - 1, arc - 2, 4);
	}
	
	public Point computeSize(int w, int h, boolean changed) {
		int size;
		if (w == SWT.DEFAULT) {
			size = h;
		} else if (h == SWT.DEFAULT) {
			size = w;
		} else {
			size = Math.min(w, h);
		}
		if (size == SWT.DEFAULT)
			size = 50;
		return new Point(size, size);
	}
}

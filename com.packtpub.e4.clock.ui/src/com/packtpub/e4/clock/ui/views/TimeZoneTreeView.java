








package com.packtpub.e4.clock.ui.views;

import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.part.ViewPart;

import com.packtpub.e4.clock.ui.internal.TimeZoneComparator;

public class TimeZoneTreeView extends ViewPart {
	private TreeViewer treeViewer;
	@Override
	public void createPartControl(Composite parent) {
		treeViewer = new TreeViewer(parent, SWT.MULTI | SWT.H_SCROLL
				| SWT.V_SCROLL);
		treeViewer.setLabelProvider(new TimeZoneLabelProvider());
		treeViewer.setContentProvider(new TimeZoneContentProvider());
		treeViewer.setInput(new Object[] {TimeZoneComparator.getTimeZones()});
	}
	@Override
	public void setFocus() {
		treeViewer.getControl().setFocus();
	}

}

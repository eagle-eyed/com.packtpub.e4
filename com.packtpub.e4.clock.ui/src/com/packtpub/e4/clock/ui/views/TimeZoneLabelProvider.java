








package com.packtpub.e4.clock.ui.views;

import java.util.Map;
import java.util.TimeZone;

import org.eclipse.jface.resource.ImageRegistry;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.PlatformUI;

/**
 * Provides a means to convert an object into text.
 * Think of it as an externalised toString representation
 * for an object that is passed in as the argument.
 */
public class TimeZoneLabelProvider extends LabelProvider {
	private final ImageRegistry ir;
	public TimeZoneLabelProvider(ImageRegistry ir) {
		this.ir = ir;
	}
	public Image getImage(Object element) {
		if(element instanceof Map.Entry) {
			return ir.get("sample");
		} else if(element instanceof TimeZone) {
			return ir.get("sample");
		} else {
			return super.getImage(element);
		}
	}
	@SuppressWarnings("rawtypes")
	public String getText (Object element) {
		if (element instanceof Map) {
			return "Time Zones";
		} else if (element instanceof Map.Entry){
			return ((Map.Entry) element).getKey().toString();
		} else if (element instanceof TimeZone) {
			return ((TimeZone) element).getID().split("/")[1];
		} else {
			return "Unknown type: " + element.getClass();
		}
	}
//	public Image getImage(Object element) {
//		if (element instanceof Map.Entry) {
//			return PlatformUI.getWorkbench().getSharedImages()
//					.getImage(ISharedImages.IMG_OBJ_FOLDER);
//		} else {
//			return super.getImage(element);
//		}
//	}
}










package com.packtpub.e4.clock.ui.views;

import java.util.Map;
import java.util.TimeZone;

import org.eclipse.jface.viewers.LabelProvider;

/**
 * Provides a means to convert an object into text.
 * Think of it as an externalised toString representation
 * for an object that is passed in as the argument.
 */
public class TimeZoneLabelProvider extends LabelProvider {
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
}

/*******************************************************************************
 * 2008-2016 Public Domain
 * Contributors
 * Marco Lopes (marcolopes@netc.pt)
 * Paulo Silva (wickay@hotmail.com)
 *******************************************************************************/
package org.dma.eclipse.swt.copypaste;

import java.util.LinkedHashMap;

import org.eclipse.swt.widgets.TabItem;

public class CopyPasteManager extends LinkedHashMap<ICopyPaste, TabItem> {

	private static final long serialVersionUID = 1L;

	private final ICopyPaste header;

	public CopyPasteManager(ICopyPaste header) {
		this.header=header;
	}


	public void executeCopy() {

		for(ICopyPaste key: keySet()){

			TabItem item=get(key);

			if (!item.isDisposed() && !item.getControl().isDisposed() &&
				item.getControl().isVisible()){
				key.executeCopy();
			}

		}

		header.executeCopy();

	}


	public void executePaste() {

		for(ICopyPaste key: keySet()){

			TabItem item=get(key);

			if (!item.isDisposed() && !item.getControl().isDisposed() &&
				item.getControl().isVisible()){
				key.executePaste();
			}

		}

		header.executePaste();

	}


}

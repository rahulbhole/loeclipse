/*************************************************************************
 *
 * $RCSfile: UnoSDKConfigPage.java,v $
 *
 * $Revision: 1.5 $
 *
 * last change: $Author: cedricbosdo $ $Date: 2005/11/27 17:48:17 $
 *
 * The Contents of this file are made available subject to the terms of
 * either of the GNU Lesser General Public License Version 2.1
 *
 * Sun Microsystems Inc., October, 2000
 *
 *
 * GNU Lesser General Public License Version 2.1
 * =============================================
 * Copyright 2000 by Sun Microsystems, Inc.
 * 901 San Antonio Road, Palo Alto, CA 94303, USA
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License version 2.1, as published by the Free Software Foundation.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place, Suite 330, Boston,
 * MA 02111-1307 USA
 * 
 * The Initial Developer of the Original Code is: Sun Microsystems, Inc..
 *
 * Copyright: 2002 by Sun Microsystems, Inc.
 *
 * All Rights Reserved.
 *
 * Contributor(s): Cedric Bosdonnat
 *
 *
 ************************************************************************/
package org.openoffice.ide.eclipse.preferences;

import org.eclipse.jface.preference.PreferencePage;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;
import org.openoffice.ide.eclipse.gui.OOoTable;
import org.openoffice.ide.eclipse.gui.SDKTable;

/**
 * TODOC
 * 
 * @author cbosdonnat
 *
 */
public class UnoSDKConfigPage extends PreferencePage implements
		IWorkbenchPreferencePage {
	
	private SDKTable sdkTable;
	private OOoTable oooTable;

	protected Control createContents(Composite parent) {
		noDefaultAndApplyButton();
		
		sdkTable = new SDKTable(parent);
		sdkTable.getPreferences();
		
		oooTable = new OOoTable(parent);
		oooTable.getPreferences();
		
		return parent;
	}
	
	public boolean performOk() {
		sdkTable.savePreferences();
		oooTable.savePreferences();
		
		return true;
	}
	
	public void dispose() {
		sdkTable.dispose();
		oooTable.dispose();
		super.dispose();
	}
	
	/**
	 * this method does nothing, however, eclipse require this PreferencePage
	 * to implement IWorkbenchPreferencePage.
	 */
	public void init(IWorkbench workbench) {
	}
}
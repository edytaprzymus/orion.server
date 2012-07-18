/*******************************************************************************
 * Copyright (c) 2012 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.orion.server.useradmin.servlets;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.*;

import javax.mail.MessagingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.MultiStatus;
import org.eclipse.orion.server.core.*;
import org.eclipse.orion.server.servlets.OrionServlet;
import org.eclipse.orion.server.user.profile.RandomPasswordGenerator;
import org.eclipse.orion.server.useradmin.*;
import org.json.JSONException;
import org.json.JSONObject;

public class EmailNotificationServlet extends OrionServlet {

	private static final long serialVersionUID = 6390565569459919276L;

	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String email = req.getParameter(UserConstants.KEY_PULL_REQ_NOTIFY_EMAIL);
		String url = req.getParameter(UserConstants.KEY_PULL_REQ_URL);
		try {
			UserEmailUtil.getUtil().sendEmailNotification(url, email, null, null);
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String[] userPathInfoParts = req.getPathInfo().split("\\/", 2);

		// handle calls to /users/[userId]
		//String userId = userPathInfoParts[1];

		//IOrionCredentialsService userAdmin = getUserAdmin();
		//User user = (User) userAdmin.getUser(UserConstants.KEY_UID, userId);

		//if (user == null) {
		//	resp.sendError(HttpServletResponse.SC_NOT_FOUND, "User " + userId + " not found.");
		//	return;
		//}

		//if (req.getParameter(UserConstants.KEY_PASSWORD_RESET_CONFIRMATION_ID) != null) {
		//	resetPassword(user, req, resp);
		//} else {
			//confirmEmail(user, req, resp);
		//}
		
		

	}
	

}
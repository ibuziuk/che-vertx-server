/******************************************************************************* 
 * Copyright (c) 2017 Red Hat, Inc. 
 * Distributed under license by Red Hat, Inc. All rights reserved. 
 * This program is made available under the terms of the 
 * Eclipse Public License v1.0 which accompanies this distribution, 
 * and is available at http://www.eclipse.org/legal/epl-v10.html 
 * 
 * Contributors: 
 * Red Hat, Inc. - initial API and implementation 
 ******************************************************************************/
package io.fabric8.che.vertx.handler;

import io.vertx.core.http.HttpServerResponse;
import io.vertx.core.json.JsonObject;
import io.vertx.ext.web.RoutingContext;

public class CreateServerHandler extends AbstractHandler {
	
	@Override
	public void handle(RoutingContext routingContext) {
		JsonObject jsonObject = routingContext.getBodyAsJson();
		// TODO process request
		HttpServerResponse response = routingContext.response();
		response.putHeader("Content-Type", "application/json").setChunked(true);
		response.write("");
		response.end();
	}
}

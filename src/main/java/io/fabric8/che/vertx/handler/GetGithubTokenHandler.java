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

import io.fabric8.che.vertx.Properties;
import io.vertx.core.Handler;
import io.vertx.core.http.HttpServerResponse;
import io.vertx.ext.web.RoutingContext;

public class GetGithubTokenHandler implements Handler<RoutingContext> {

	@Override
	public void handle(RoutingContext routingContext) {
		HttpServerResponse response = routingContext.response();
		response.putHeader("Content-Type", "application/json").setChunked(true);
		if (routingContext.request().getHeader("Authorization").equals(Properties.DEFAULT_KEYCLOAK_TOKEN)) {
			response.write("{\"access_token\":\"" + Properties.DEFAULT_GITHUB_TOKEN +
			        "\",\"scope\":\"admin:repo_hook,gist,read:org,repo,user\",\"token_type\":\"bearer\"}");
		} else {
			response.write("{\"errorMessage\":\"Invalid token.\"}");
			response.setStatusCode(400);
		}
		response.end();
	}
}

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

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class Utils {

	public static String getTextFromFile(String fileToPath) {
		StringBuilder sb = new StringBuilder();
		List<String> json;
		try {
			json = Files.readAllLines(Paths.get(fileToPath), StandardCharsets.UTF_8);
		} catch (IOException e) {
			throw new RuntimeException("Cannot read file with JSON for a new workspace");
		}
		for (String str : json) {
			sb.append(str);
		}
		return sb.toString();
	}
	
	public static String getProperty(String propertyName, String defaultValue) {
		String property = System.getProperty(propertyName);
		if (property == null || property.isEmpty()) {
			return defaultValue;
		} else {
			return property;
		}
	}
}

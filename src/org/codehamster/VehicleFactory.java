/*
 * Java Reflection Factory Example
 * Copyright (C) 2019 Manny Peterson
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <https://www.gnu.org/licenses/>
 */
package org.codehamster;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;

public class VehicleFactory {
	private HashMap<String, String> registations;

	public VehicleFactory(String packageName) {
		try {
			String[] classNames;
			this.registations = new HashMap<String, String>();
			classNames = this.getClasses(packageName);
			this.registerClasses(classNames);
			return;
		} catch (Exception e) {
			e.printStackTrace();
			return;
		}
	}

	private String[] getClasses(String packageName) {
		try {
			ClassLoader classLoader;
			ArrayList<String> retVal;
			ArrayList<File> classFiles;
			Enumeration<URL> resources;
			retVal = new ArrayList<String>();
			classFiles = new ArrayList<File>();
			classLoader = this.getClass().getClassLoader();
			resources = classLoader.getResources(packageName.replace('.', '/'));
			while (resources.hasMoreElements()) {
				File parent = new File(resources.nextElement().getFile());
				if (parent.exists()) {
					if (parent.canRead()) {
						if (parent.isDirectory()) {
							for (File child : parent.listFiles()) {
								if (child.exists()) {
									if (child.canRead()) {
										if (child.isFile()) {
											if (child.getName().endsWith(".class")) {
												classFiles.add(child);
											}
										}
									}
								}
							}
						} else if (parent.isFile()) {
							if (parent.getName().endsWith(".class")) {
								classFiles.add(parent);
							}
						}
					}
				}
			}
			for (File classFile : classFiles) {
				retVal.add(packageName + '.' + classFile.getName().substring(0, classFile.getName().length() - 6));
			}
			return (String[]) retVal.toArray(new String[retVal.size()]);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public Vehicle getVehicle(String name) {
		try {
			return (Vehicle) Class.forName(this.registations.get(name)).getConstructor().newInstance();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	private void registerClasses(String[] classNames) {
		try {
			for (String className : classNames) {
				Vehicle vehicle = (Vehicle) Class.forName(className).getConstructor().newInstance();
				this.registations.put(vehicle.getName(), className);
			}
			return;
		} catch (Exception e) {
			e.printStackTrace();
			return;
		}
	}
}

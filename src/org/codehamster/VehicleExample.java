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

public class VehicleExample {
	public static void main(String[] args) {
		VehicleFactory vehicleFactory = new VehicleFactory("org.codehamster.vehicles");

		Vehicle vehicleOne = vehicleFactory.getVehcile("boat");
		Vehicle vehicleTwo = vehicleFactory.getVehcile("train");
		Vehicle vehicleThree = vehicleFactory.getVehcile("truck");
		Vehicle vehicleFour = vehicleFactory.getVehcile("airplane");

		System.out.println(vehicleOne);
		System.out.println(vehicleTwo);
		System.out.println(vehicleThree);
		System.out.println(vehicleFour);

		return;
	}
}
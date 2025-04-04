/*
 * Copyright (c) 2010-2025 Contributors to the openHAB project
 *
 * See the NOTICE file(s) distributed with this work for additional
 * information.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0
 *
 * SPDX-License-Identifier: EPL-2.0
 */
package org.openhab.binding.solarwatt.internal.domain.model;

import static org.openhab.binding.solarwatt.internal.SolarwattBindingConstants.*;

import org.eclipse.jdt.annotation.NonNullByDefault;
import org.openhab.binding.solarwatt.internal.domain.dto.DeviceDTO;

/**
 * Base class for all inverters.
 *
 * This fields have been identified to exist:
 * com.kiwigrid.devices.inverter.Inverter=[
 * WorkACOut,
 * PowerInstalledPeak,
 * PowerStringDCIn,
 * PowerACOutMax,
 * PowerACOut,
 * PowerACOutLimit,
 * ACPower,
 * PowerYieldSum
 * ]
 *
 * @author Sven Carstens - Initial contribution
 */
@NonNullByDefault
public class Inverter extends Device {
    public static final String SOLAR_WATT_CLASSNAME = "com.kiwigrid.devices.inverter.Inverter";

    public Inverter(DeviceDTO deviceDTO) {
        super(deviceDTO);
    }

    @Override
    public void update(DeviceDTO deviceDTO) {
        super.update(deviceDTO);

        this.addWattHourQuantity(CHANNEL_WORK_AC_OUT, deviceDTO);
        this.addWattQuantity(CHANNEL_POWER_AC_OUT_MAX, deviceDTO);
        this.addWattQuantity(CHANNEL_POWER_AC_OUT, deviceDTO);
        this.addWattQuantity(CHANNEL_POWER_AC_OUT_LIMIT, deviceDTO);

        this.addWattQuantity(CHANNEL_POWER_INSTALLED_PEAK, deviceDTO, true);
    }

    @Override
    protected String getSolarWattLabel() {
        return "Inverter";
    }
}

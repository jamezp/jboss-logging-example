/*
 * JBoss, Home of Professional Open Source.
 * Copyright 2011, Red Hat, Inc., and individual contributors
 * as indicated by the @author tags. See the copyright.txt file in the
 * distribution for a full listing of individual contributors.
 *
 * This is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation; either version 2.1 of
 * the License, or (at your option) any later version.
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this software; if not, write to the Free
 * Software Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA
 * 02110-1301 USA, or see the FSF site: http://www.fsf.org.
 */

package org.jboss.logging.translation.example;

import org.jboss.logging.BasicLogger;
import org.jboss.logging.LogMessage;
import org.jboss.logging.Logger;
import org.jboss.logging.Message;
import org.jboss.logging.MessageLogger;

import static org.jboss.logging.Logger.Level.DEBUG;

/**
 * @author Kevin Pollet
 */
@MessageLogger(projectCode = "TPS")
public interface TrainsSpotterLog extends BasicLogger {
    /**
     * The logger.
     */
    TrainsSpotterLog LOGGER = Logger.getMessageLogger(TrainsSpotterLog.class, TrainsSpotterLog.class.getPackage().getName());

    @LogMessage
    @Message(id = 1, value = "There is %s diesel trains")
    void nbDieselTrains(int number);

    @LogMessage
    void nbDieselTrains(long number);

    @LogMessage
    @Message(id = Message.INHERIT, value = "There are %s diesel trains on track %s.")
    void nbDieselTrains(int number, String track);


    @LogMessage(level = DEBUG)
    @Message("Test debug %s")
    void testDebug(Class<?> clazz);
}

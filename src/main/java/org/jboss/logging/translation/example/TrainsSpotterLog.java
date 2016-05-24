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

import org.jboss.logging.Cause;
import org.jboss.logging.LogMessage;
import org.jboss.logging.Message;
import org.jboss.logging.MessageLogger;
import static org.jboss.logging.Logger.Level.*;

import java.io.IOException;

/**
 * @author Kevin Pollet
 */
@MessageLogger(projectCode = "TRN")
public interface TrainsSpotterLog {

    @LogMessage
    @Message(id = 1, value = "There are %s diesel trains")
    void nbDieselTrains(int number);

    @LogMessage
    @Message(id = 2, value = "There are %s diesel trains on track %s.")
    // NOTE: The default id Message.INHERIT does *NOT* work in this case - log will just have no ID.. :(
    void nbDieselTrains(int number, String track);

    @LogMessage(level = WARN)
    @Message(id = 6, value = "Heavy warning: %s")
    void warning(String value);

    @LogMessage(level = WARN)
    @Message(id = 13, value = "Failed to create file: %s")
    void touchFileFailed(String fileName, @Cause IOException e);
}

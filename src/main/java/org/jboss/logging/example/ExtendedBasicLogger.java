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

package org.jboss.logging.example;

import org.jboss.logging.BasicLogger;
import org.jboss.logging.LogMessage;
import org.jboss.logging.Logger;
import org.jboss.logging.Logger.Level;
import org.jboss.logging.LoggingClass;
import org.jboss.logging.Message;
import org.jboss.logging.MessageLogger;

/**
 *
 * @author James R. Perkins (jrp)
 */
@MessageLogger(projectCode="BLOG")
interface ExtendedBasicLogger extends BasicLogger {

    /**
     * The extended basic logger.
     */
    ExtendedBasicLogger LOGGER = Logger.getMessageLogger(ExtendedBasicLogger.class, ExtendedBasicLogger.class.getPackage().getName());

    @LogMessage(level = Level.WARN)
    @Message(id = 1, value = "Parameter %s cannot be null.")
    void nullParameterValue(String param);

    @LogMessage(level = Level.INFO)
    @Message(id = 2, value = "Version: %s")
    void releaseVersion(String version);

    @LogMessage(level = Level.INFO)
    @Message(id = 3, value = "Message: %s Line: %d")
    void multiTest(@LoggingClass Class<?> clazz, String message, int line);

    @LogMessage(level = Level.INFO)
    @Message(id = 4, value = "Invalid class name")
    void invalidClassName(@LoggingClass Class clazz);

}

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

import org.jboss.logging.Cause;
import org.jboss.logging.LogMessage;
import org.jboss.logging.Logger.Level;
import org.jboss.logging.Message;
import org.jboss.logging.MessageLogger;

/**
 * @author James R. Perkins (jrp)
 */
@MessageLogger(projectCode = "LOGL")
public interface ErrorLogger {

    @LogMessage(level = Level.ERROR)
    @Message(id = 8, value = "Error: %s")
    void error(String value);

    @Message(id = 500, value = "Value %s is invalid.")
    ValueException invalidValue(String value);


    @LogMessage(level = Level.ERROR)
    @Message("Error Message: %s for class: %s")
    void error(@Cause Throwable cause, String error, Class<?> clazz);
}

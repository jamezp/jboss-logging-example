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
import org.jboss.logging.MessageBundle;

import java.io.File;
import java.io.IOException;

/**
 * @author James R. Perkins (jrp)
 */
@MessageBundle(projectCode = "LOGB")
public interface ExceptionBundle {

    @Message(id = 12, value = "Could not write to file %s.")
    IOException writeError(@Cause Throwable cause, File file);

    @LogMessage(level = Level.FATAL)
    @Message(id = 10, value = "Error calculating %s.")
    ArithmeticException calculationError(@Cause Throwable cause, Object value);

    @Message(id = 11, value = "Value %s is invalid.")
    ValueException invalidValue(@Cause Throwable cause, String value);

    ValueException invalidValue(String value);

    @Message("Invalid key value.")
    ValueException invalidValueKey();

    @Message(id = 99999, value = "A generic error as occurred.")
    GenericException genericError(@Cause Throwable cause);

    @Message(id = 99998, value = "An invalid constructor was found.")
    InvalidCtorException invalidConstructor();

    @Message(id = 99997, value = "Invalid constructor in %s.")
    InvalidCtorException invalidConstructor(Class<?> clazz);

    InvalidCtorException invalidConstructor(@Cause Throwable cause, Class<?> clazz);
}

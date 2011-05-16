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

/**
 *
 */
package org.jboss.logging.example;

import org.jboss.logging.Cause;
import org.jboss.logging.LogMessage;
import org.jboss.logging.Logger.Level;
import org.jboss.logging.Message;
import org.jboss.logging.Message.Format;
import org.jboss.logging.MessageBundle;

import java.io.IOException;

/**
 * @author James R. Perkins Jr. (jrp)
 *
 */
@MessageBundle(projectCode = "LOGB")
public interface ExampleBundle {
    @LogMessage(level = Level.ERROR)
    @Message(value="%s cannot be null.")
    CharSequence valueNotNull(String value);

    @LogMessage(level = Level.INFO)
    @Message(id = 1, value = "Version: %s")
    String version(String version);

    @LogMessage(level = Level.FATAL)
    @Message(id = 2, value = "This is not good! %s is melting.")
    RuntimeException meltDown(@Cause IOException cause, String value);

    @LogMessage(level = Level.WARN)
    @Message(id = 3, value = "Value {0} could not be added to {1}", format = Format.MESSAGE_FORMAT)
    String invalidValue(@Cause Throwable cause, String value, String collectionName);

    @LogMessage(level = Level.ERROR)
    @Message(id = 4, value = "Error: {0}", format = Format.MESSAGE_FORMAT)
    String error(String string);

    @LogMessage(level = Level.FATAL)
    String error(@Cause Throwable cause, String string);
}

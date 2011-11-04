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
import org.jboss.logging.Field;
import org.jboss.logging.FormatWith;
import org.jboss.logging.LogMessage;
import org.jboss.logging.Logger.Level;
import org.jboss.logging.Message;
import org.jboss.logging.MessageBundle;
import org.jboss.logging.Param;
import org.jboss.logging.Property;
import org.xml.sax.Locator;
import org.xml.sax.SAXParseException;

import javax.transaction.xa.XAException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.Formatter;

/**
 * @author James R. Perkins (jrp)
 */
@MessageBundle(projectCode = "LOGB")
interface ExceptionBundle {

    @Message(id = 12, value = "Could not write to file %s.")
    IOException writeError(@Cause Throwable cause, File file) throws RuntimeException;

    @LogMessage(level = Level.FATAL)
    @Message(id = 10, value = "Error calculating %s.")
    ArithmeticException calculationError(@Cause Throwable cause, Object value);

    @Message(id = 11, value = "Value %s is invalid.")
    ValueException invalidValue(@Cause Throwable cause, String value);

    ValueException invalidValue(String value);

    @Message(id = 13, value = "Invalid Decimal")
    ValueException invalidValue(@Property(name = "value") BigDecimal v);

    ValueException invalidValue(@Property Double value);

    ValueException invalidValue(@Property float value);

    @Message("Generic exception caught")
    GenericException caught(@Param Throwable cause, @Field int errorCode);

    @Message("Invalid key value.")
    ValueException invalidValueKey();

    @Message(id = 99999, value = "A generic error as occurred.")
    GenericException genericError(@Cause Throwable cause);

    @Message(id = 99998, value = "An invalid constructor was found.")
    InvalidCtorException invalidConstructor();

    @Message(id = Message.INHERIT, value = "Invalid constructor in %s.")
    InvalidCtorException invalidConstructor(Class<?> clazz);

    InvalidCtorException invalidConstructor(@Cause Throwable cause);

    @Message("Attribute %s is not valid for tag %s.")
    SAXParseException invalidAttribute(@Param Locator locator, String attributeName, String tagName);

    @Message("Transaction is invalid")
    XAException invalidTransaction(@Field Integer errorCode);
}

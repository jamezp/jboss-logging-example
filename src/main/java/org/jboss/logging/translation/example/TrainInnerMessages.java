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

import java.util.Locale;

import org.jboss.logging.Message;
import org.jboss.logging.MessageBundle;
import org.jboss.logging.Messages;

/**
 * @author Kevin Pollet
 */
public class TrainInnerMessages {
    public static final InnerMessages MESSAGES = Messages.getBundle(InnerMessages.class, Locale.ENGLISH);

    // TODO Isn't this slow, and needs caching?!?
    public static InnerMessages MESSAGES(Locale locale) {
        return Messages.getBundle(InnerMessages.class, locale);
    }

    // There could be other normal methods here, and the @MessageBundle can be an inner class
    // (but doesn't have to be, can also be separate like e.g. the TrainsSpotterLog).

    @MessageBundle(projectCode = "TRN")
    public interface InnerMessages {

        @Message(id = 123, value = "There are no diesel trains due to %s")
        String noDieselTrains(String cause);

    }

}

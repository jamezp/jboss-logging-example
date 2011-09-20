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

import org.jboss.logging.Logger;
import org.jboss.logging.translation.example.TrainInnerMessages;
import org.jboss.logging.translation.example.TrainsSpotterLog;

import java.util.Locale;

/**
 * Date: 06.06.2011
 *
 * @author <a href="mailto:jperkins@redhat.com">James R. Perkins</a>
 */
public class Main {

    public static void main(String[] args) {
        if (args == null || args.length == 0) {
            testLocale(Locale.getDefault());
        } else {
            String lang = null;
            String country = null;
            String variant = null;
            for (int i = 0; i < args.length; i++) {
                switch (i) {
                    case 1:
                        lang = args[i];
                        break;
                    case 2:
                        country = args[i];
                        break;
                    case 3:
                        variant = args[i];
                        break;
                }
            }
            final Locale locale;
            if (country == null) {
                locale = new Locale(lang.toLowerCase());
            } else if (variant == null) {
                locale = new Locale(lang.toLowerCase(), country.toLowerCase());
            } else {
                locale = new Locale(lang.toLowerCase(), country.toLowerCase(), variant);
            }
            testLocale(locale);
        }
    }

    public static void testLocale(final Locale locale) {
        final TrainsSpotterLog tsLogger = Logger.getMessageLogger(TrainsSpotterLog.class, Main.class.getPackage().getName(), locale);
        tsLogger.nbDieselTrains(8);
        System.out.println(TrainInnerMessages.MESSAGES.noDieselTrains("XYZ"));
        ExtendedLogger.EXTENDED_LOGGER.invalidValue();
    }
}

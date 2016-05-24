/*
 * JBoss, Home of Professional Open Source.
 * Copyright 2016, Red Hat, Inc., and individual contributors
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

import java.util.Locale;

import org.jboss.logging.Logger;

/**
 * Utility for very commonly used pattern with Logger.
 *
 * @author <a href="mailto:vorburger@redhat.com">Michael Vorburger</a>
 */
public final class LoggerFactory {

    // TODO Propose this to org.jboss.logging.Logger

    private LoggerFactory() {
    }

    public static <T> T getMessageLogger(Class<T> messageLoggerClass, Class<?> categoryClass, Locale locale) {
        return Logger.getMessageLogger(messageLoggerClass, categoryClass.getPackage().getName(), locale);
    }

    public static <T> T getMessageLogger(Class<T> messageLoggerClass, Class<?> categoryClass) {
        return getMessageLogger(messageLoggerClass, categoryClass, Locale.getDefault());
    }

/*
    public static <T> T getMessageLogger(Class<T> messageLoggerClass, Object categoryInstance, Locale locale) {
        return Logger.getMessageLogger(messageLoggerClass, categoryInstance.getClass().getPackage().getName(), locale);
    }

    public static <T> T getMessageLogger(Class<T> messageLoggerClass, Object categoryInstance) {
        return getMessageLogger(messageLoggerClass, categoryInstance, Locale.getDefault());
    }
*/

    public static <T> LoggerFactoryBuilder<T> getMessageLogger(Class<T> messageLoggerClass) {
        return new LoggerFactoryBuilder<T>(messageLoggerClass);
    }

    public static class LoggerFactoryBuilder<T> {

        private final Class<T> messageLoggerClass;
        private Locale locale;

        private LoggerFactoryBuilder(Class<T> messageLoggerClass) {
            this.messageLoggerClass = messageLoggerClass;
        }

        public LoggerFactoryBuilder<T> locale(Locale locale) {
            this.locale = locale;
            return this;
        }

        public T in(Class<?> categoryClass) {
            if (locale == null) {
                return getMessageLogger(messageLoggerClass, categoryClass, Locale.getDefault());
            } else {
                return getMessageLogger(messageLoggerClass, categoryClass, locale);
            }
        }

    }


}

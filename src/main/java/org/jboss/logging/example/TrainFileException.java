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

/**
 * Example exception.
 *
 * @author Michael Vorburger
 */
public class TrainFileException extends Exception {
    private static final long serialVersionUID = 4124552009469378689L;

    public TrainFileException(String message) {
        super(message);
    }

/*
    This pattern is often not needed, unless there really is any code which needs to be able
    to getFile(), e.g. to handle recovery from the error situation.  In that case, File file
    can be marked as @Param in TrainExceptionFactory (but wil then not be part of the message).


    private final File file;

    public TrainFileException(File file) {
        this.file = file;
    }

    public File getFile() {
        return file;
    }
*/
}

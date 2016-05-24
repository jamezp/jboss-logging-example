package org.jboss.logging.example;

import java.io.File;
import java.io.IOException;
import java.util.Locale;

import org.jboss.logging.translation.example.TrainInnerMessages;
import org.jboss.logging.translation.example.TrainsSpotterLog;

public class Trains {

    // NOTE: It is possible specify a Locale when obtaining a Logger here, but
    // for this example, we do not use this, in order to make the logger look
    // very similar to a normal static (non-Message) Logger, for familiarity.
    // This means that the message will be logged in the the default locale.
    // For demos, launch Main with: -Duser.country=FR -Duser.language=fr
    //
    // We illustrate an alternative approach with explicitly passing a Locale
    // (obtained perhaps from a request specific User preference or such) in getMessage().
    //
    private static final TrainsSpotterLog logger = LoggerFactory.getMessageLogger(TrainsSpotterLog.class).in(Main.class);

    public String getMessage(Locale locale) {
        // This will be e.g. "TRN000123: There are no diesel trains due to XYZ"
        return TrainInnerMessages.MESSAGES(locale).noDieselTrains("XYZ");
    }

    public void demoLocalizedLoggingWithMessages() {
        logger.nbDieselTrains(8);
        logger.nbDieselTrains(8, "C");
        logger.warning("yellow alert");

        touchFile1("/does/not/exist/file");

        try {
            touchFile2("/does/not/exist/file");
        } catch (TrainFileException e) {
            // Just an example! ;-) Normally, we'd somehow handle it here..
            // Output: "TRN000069: Failed to touch file: /does/not/exist/file"
            System.err.println(e.getMessage());
        }
    }

    protected boolean touchFile1(String fileName) {
        File f = new File(fileName);
        try {
            f.createNewFile();
            return true;
        } catch (IOException e) {
            logger.touchFileFailed(fileName, e);
            return false;
        }
    }

    protected void touchFile2(String fileName) throws TrainFileException {
        File f = new File(fileName);
        try {
            f.createNewFile();
        } catch (IOException e) {
            throw TrainExceptions.Factory.newTrainFileException(f, e);
        }
    }

}

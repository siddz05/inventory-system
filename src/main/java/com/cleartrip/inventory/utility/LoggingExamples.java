/**
 * 
 */
package com.cleartrip.inventory.utility;
import java.util.logging.*;

/**
 * @author sid
 *
 */
public class LoggingExamples {

    private static final Logger logger =
        Logger.getLogger(LoggingExamples.class.getName());


    public void doIt() {
        logger.entering(getClass().getName(), "doIt");

        try{
            //... something that can throw an exception
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Error doing XYZ", e);
        }

        logger.exiting(getClass().getName(), "doIt");
    }

}
package com.example.TPXProj.processors;

import com.example.TPXProj.models.DatabaseNonprofit;
import com.example.TPXProj.models.Nonprofit;
import com.example.TPXProj.parsers.NonprofitParser;
import com.example.TPXProj.readers.FileReader;
import com.example.TPXProj.repositories.DatabaseNonprofitRepository;

/**
 * Processor class to handle all requests from Database Service regarding Nonprofits.
 * This includes saving Nonprofits, and delivering html files and fallback html files.
 *
 * @author Caleb Warner
 */
public class NonprofitProcessor {
    // *************************************************************************
    // Constants
    // *************************************************************************
    /** File path to read from when Nonprofit request to submit succeeds. */
    private static final String filePath = "src/main/webapp/nonprofit-submit.html";

    /** File path to read from when Nonprofit request to submit fails due to inadequate info. */
    private static final String errorFilePath = "src/main/webapp/nonprofit-submit-error.html";

    /** File path to read from when Nonprofit request is empty. */
    private static final String failureFilePath = "src/main/webapp/nonprofit-submit-failure.html";


    // *************************************************************************
    // Fields
    // *************************************************************************
    /** Class variable to store the object representation of the Nonprofit request to submit. */
    private Nonprofit nonprofit;


    // *************************************************************************
    // Constructors
    // *************************************************************************
    /**
     * Basic constructor used if Nonprofit request is empty.
     */
    public NonprofitProcessor() {
        this.nonprofit = null;
    } // public NonprofitProcessor()

    /**
     * Constructor used if Nonprofit request provides needed information to store nonprofit in database.
     *
     * @param formString String generated by html form
     */
    public NonprofitProcessor(String formString) {
        // Submits formString to NonprofitParser to translate form string to Nonprofit object
        this.nonprofit = new Nonprofit(NonprofitParser.parseString(formString));
    } // public NonprofitProcessor()


    // *************************************************************************
    // Public Methods
    // *************************************************************************
    /**
     * Serves html file with confirmation message
     *
     * @return String representation of success html file
     */
    public String output() {
        // Calls file reader to deliver success html file
        return FileReader.readFile(filePath);
    } // public String output()

    /**
     * Serves html with error message stating that all fields must be filled in
     *
     * @return String representation of error html file
     */
    public String error() {
        // Calls file reader to deliver error html file
        return FileReader.readFile(errorFilePath);
    } // public String error()

    /**
     * Serves html with failure message suggesting to try again (request was empty)
     *
     * @return String representation of failure html file
     */
    public String failure() {
        // Calls file reader to deliver failure html file
        return FileReader.readFile(failureFilePath);
    } // public String failure()

    /**
     * Takes Nonprofit object stored in class variable and stores it in the database.
     * If null flag is set (name == null), then nonprofit did not pass error checking. Therefore return false.
     *
     * @param repository Object reference to MySQL database containing all stored nonprofits
     * @return True if nonprofit passes error checking and is successfully saved to database; otherwise, false
     */
    public boolean saveNonprofit(DatabaseNonprofitRepository repository) {
        // Uses NonprofitParser to call deparseNonprofit() which translates Nonprofit object to database object
        DatabaseNonprofit databaseNonprofit = NonprofitParser.deparseNonprofit(nonprofit);

        // Check if deparseNonprofit approves of nonprofit
        if (databaseNonprofit.getName() == null) {
            // Failed nonprofit error checking; abort repository save
            return false;
        }

        // Use CrudRepository to save the nonprofit to the database
        repository.save(databaseNonprofit);

        // Success, return true
        return true;
    } // public boolean saveNonprofit()
} // public class NonprofitProcessor

package controller;

/**
 * This class has the base methods for any controller
 * @author Adrián Leyva Sánchez
 */
public abstract class BaseController {

    protected enum TypeOfCancellation {
        FORTYEIGHT_HOURS_BEFORE,
        TWENTYFOUR_HOURS_BEFORE,
        TWELVE_HOURS_BEFORE,
        FOUR_HOURS_BEFORE
    }

    protected abstract void setupDependencies();

}

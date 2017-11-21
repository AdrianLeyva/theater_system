package utils;

/**
 * This class handles the generation of folio identifiers
 * @author Adrián Leyva Sánchez
 */
public class FolioGenerator {

    public static String generateFolio(){
        return String.valueOf(System.currentTimeMillis());
    }
}

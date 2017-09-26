package utils;

import java.util.UUID;

/**
 * This class handles the generation of folio identifiers
 * @author Adrián Leyva Sánchez
 */
public class FolioGenerator {

    public static String generateFolio(){
        return UUID.randomUUID().toString();
    }
}

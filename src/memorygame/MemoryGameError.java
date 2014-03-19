/*
 * This class is done!
 */

package memorygame;

/**
 *
 * @author michelewhite
 */
public class MemoryGameError {
        public Object displayError(Object object) {
        String message = (String) object;
        System.out.println("\n\t______________________________________________________________________");
        System.out.println("\n\t ERROR: Uh-Oh, Something isn't right!" + message);
        System.out.println("\n\t______________________________________________________________________");
        return null;
    }
}

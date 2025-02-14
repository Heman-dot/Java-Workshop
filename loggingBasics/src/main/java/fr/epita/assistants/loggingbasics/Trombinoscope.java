package fr.epita.assistants.loggingbasics;

import ch.qos.logback.classic.Logger;
import ch.qos.logback.classic.Level;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

public class Trombinoscope {
    private final Logger LOGGER;
    private final HashMap<String, Long> map = new HashMap<>();

    public Trombinoscope() {
        // FIXME: Instantiate logger with level TRACE
        LOGGER= (Logger) LoggerFactory.getLogger(Trombinoscope.class);
        LOGGER.setLevel(Level.DEBUG);
        LOGGER.setLevel(Level.TRACE);
        LOGGER.trace("Instantiating new Trombinoscope");
        // FIXME: Add logging here

    }

    public Long putPerson(String name, long photoId) {
        // FIXME: Add logging here
        LOGGER.debug("Putting person (\"{}\", {})",name,photoId);
        Long oldPhoto = map.put(name,photoId);
        if(oldPhoto !=null){
            LOGGER.trace("Updated entry for person \"{}\"", name);

        }else{
            LOGGER.trace("Added entry for person \"{}\"", name);

        }

        return oldPhoto;


        // FIXME: Add logging here

    }
}

package fr.cnes.sonar.report.params;

import fr.cnes.sonar.report.exceptions.MissingParameterException;
import fr.cnes.sonar.report.exceptions.UnknownParameterException;

import java.util.HashMap;

/**
 * Parameters of the command
 * @author begarco
 */
public class Params {
    private HashMap<String,String> params;

    public Params() {
        params = new HashMap<String, String>();
    }

    public boolean contains(String key) {
        return this.params.containsKey(key);
    }

    public String get(String key) throws UnknownParameterException {
        if(!contains(key)) {
            throw new UnknownParameterException(key);
        }
        return params.get(key);
    }

    public void put(String key, String value) {
        this.params.put(key, value);
    }

    public boolean isReliable() throws MissingParameterException {
        for(HashMap.Entry<String, String> entry : params.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();

            if("".equals(value)) {
                throw new MissingParameterException(key);
            }
        }
        return true;
    }
}
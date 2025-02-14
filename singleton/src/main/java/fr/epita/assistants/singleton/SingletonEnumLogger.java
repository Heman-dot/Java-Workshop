package fr.epita.assistants.singleton;

import fr.epita.assistants.logger.Logger;


public enum SingletonEnumLogger implements  Logger{
    INSTANCE;
    private int infoCounter = 0;
    private int warnCounter = 0;
    private int errorCounter = 0;


    @Override
    public void log(Level level, String message){
        switch (level){
            case INFO:
                infoCounter++;
                System.err.println("[INFO] " + message);
                break;
            case WARN:
                warnCounter++;
                System.err.println("[WARN] "+ message  );
                break;
            case ERROR:
                errorCounter++;
                System.err.println("[ERROR] "+message);
                break;
        }


    }
    @Override
    public int getInfoCounter(){
        return infoCounter;
    }
    @Override
    public int getWarnCounter(){
        return warnCounter;
    }

    @Override
    public int getErrorCounter(){
        return errorCounter;
    }

    @Override
    public void reset(){
        infoCounter =0;
        warnCounter=0;
        errorCounter =0;
    }


}
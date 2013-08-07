package backupmanager.implementation.Local;

import backupmanager.model.FileSystem.FileReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

class LocalFileReader implements FileReader{
    
    private InputStream input;
    private Boolean streamOpened;
    
    public LocalFileReader() {
        streamOpened=false;
    }
    
    @Override
    public byte[] readFile(String uri, byte[] buff) {
        if (!streamOpened)
            input = openInputStream(new File(uri));
        buff = readInputStream(input, buff);
        if(buff== null)
            closeInputStream(input);
        return buff;
    }

    private InputStream openInputStream(File file) {
        InputStream input = null;
        try {
            input = new FileInputStream(file);
            streamOpened=true;
        } catch (FileNotFoundException ex) {
            Logger.getLogger(LocalFileReader.class.getName()).log(Level.SEVERE, null, ex);
        }
        return input;
    }

    private byte[] readInputStream(InputStream input, byte[] buff) {
        try {
            int endOfValues = input.read(buff);
            if (endOfValues == -1)
                return null;
            if (endOfValues < buff.length )
                buff=Arrays.copyOfRange(buff, 0, endOfValues);
            return buff;
        } catch (IOException ex) {
            Logger.getLogger(LocalFileReader.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    private void closeInputStream(InputStream input) {
        try {
            input.close();
            streamOpened=false;
        } catch (IOException ex) {
            Logger.getLogger(LocalFileReader.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}

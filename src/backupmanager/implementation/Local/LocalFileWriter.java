package backupmanager.implementation.Local;

import backupmanager.model.FileSystem.FileWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

class LocalFileWriter implements FileWriter{
    
    private OutputStream output;
    private Boolean streamOpened;
    
    public LocalFileWriter() {
        streamOpened=false;
    }
    
    @Override
    public boolean writeFile(String uri, byte[] buff) {
        if(buff==null)
            return closeOutputStream(output);
        if(!streamOpened)
            output = openOutputStream(new File(uri));
        
        return writeOutputStream(output, buff);
    }

    private OutputStream openOutputStream(File file) {
        OutputStream output = null;
        try {
            output = new FileOutputStream(file);
            streamOpened=true;
        } catch (FileNotFoundException ex) {
            Logger.getLogger(LocalFileReader.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return output;
    }

    private boolean writeOutputStream(OutputStream output, byte[] buff) {
        try {
            output.write(buff);
        } catch (IOException ex) {
            Logger.getLogger(LocalFileReader.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        return true;
    }

    private boolean closeOutputStream(OutputStream output) {
        if(streamOpened)
        try {
            output.close();
            streamOpened=false;
        } catch (IOException ex) {
            Logger.getLogger(LocalFileReader.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        return true;
    }

}

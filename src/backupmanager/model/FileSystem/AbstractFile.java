package backupmanager.model.FileSystem;

import backupmanager.model.FileList;
import com.sun.jndi.toolkit.url.Uri;

public abstract class AbstractFile {
    private String uri;
    private FileReader reader;
    private FileWriter writer;

    public String getUri() {
        return uri;
    }

    public AbstractFile(String uri,FileReader reader, FileWriter writer) {
        this.uri = uri;
        this.reader = reader;
        this.writer = writer;
    }
    
    public boolean write(byte[] buff){
        return writer.writeFile(uri, buff);
    }
    
    public byte[] read(byte[] buff){
        return reader.readFile(uri, buff);
    }
    
    public abstract long lengthFile();
    
    public abstract boolean isDirectory();
    
    public abstract FileList getFiles();
    
    public abstract long lastModified();
}

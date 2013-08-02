package backupmanager.model.FileSystem;

import com.sun.jndi.toolkit.url.Uri;

public interface ReaderFile {
    
    public abstract byte[] readFile(String uri, byte[] buff);
    
}

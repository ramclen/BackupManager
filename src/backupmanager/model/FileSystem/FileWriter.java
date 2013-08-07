package backupmanager.model.FileSystem;

import com.sun.jndi.toolkit.url.Uri;

public interface FileWriter {
    public abstract boolean writeFile(String uri, byte[] buff);
}

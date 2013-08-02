package backupmanager.model.FileSystem;

import com.sun.jndi.toolkit.url.Uri;

public interface WriterFile {
    public abstract boolean writeFile(String uri, byte[] buff);
}

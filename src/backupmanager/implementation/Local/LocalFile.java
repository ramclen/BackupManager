package backupmanager.implementation.Local;

import backupmanager.model.FileList;
import backupmanager.model.FileSystem.AbstractFile;
import backupmanager.model.FileSystem.ReaderFile;
import backupmanager.model.FileSystem.WriterFile;
import com.sun.jndi.toolkit.url.Uri;
import java.io.File;

public class LocalFile extends AbstractFile{

    public LocalFile(String uri) {
        super(uri, new LocalFileReader(), new LocalFileWriter());
    }

    @Override
    public boolean isDirectory() {
        return new File(getUri()).isDirectory();
    }

    @Override
    public FileList getFiles() {
        File[] files= new File(getUri()).listFiles();
        FileList fileList = new FileList();
        for(File file : files)
            fileList.add(toLocalFile(file));
        return fileList;
    }

    @Override
    public long lastModified() {
        return new File(getUri()).lastModified();
    }
    
    public LocalFile toLocalFile(File file){
        return new LocalFile(file.getAbsoluteFile().toString());
    }
}

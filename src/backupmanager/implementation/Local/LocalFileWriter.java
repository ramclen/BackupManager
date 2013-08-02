package backupmanager.implementation.Local;

import backupmanager.model.FileSystem.WriterFile;

class LocalFileWriter implements WriterFile{

    public LocalFileWriter() {}

    @Override
    public boolean writeFile(String uri, byte[] buff) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}

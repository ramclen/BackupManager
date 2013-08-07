
package backupmanager;

import backupmanager.implementation.Local.LocalFile;

public class BackupManager {

    public static void main(String[] args) {
        LocalFile source = new LocalFile("D:/datos.avi");
        LocalFile destiny = new LocalFile("D:/datosCopy.avi");
        byte[] buff = new byte[1024];
        while((buff=source.read(buff))!=null){
            destiny.write(buff);
        }
        destiny.write(buff);
    }
}

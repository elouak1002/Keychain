package services;

import java.io.*;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

import org.zeroturnaround.zip.NameMapper;
import org.zeroturnaround.zip.ZipUtil;

public class ZipService {

    public static void unzipFile(String fromFile, String toDirectory) throws IOException {
        String directoryName = "";

        //Open the file
        try(ZipFile file = new ZipFile(fromFile))
        {
            //Get file entries
            Enumeration<? extends ZipEntry> entries = file.entries();

            //Iterate over entries
            while (entries.hasMoreElements() && directoryName.equals(""))
            {
                ZipEntry entry = entries.nextElement();
                //If directory then create a new directory in uncompressed folder
                if (entry.isDirectory())
                {
                    if (!entry.getName().contains("__MACOSX")) {
                        directoryName = entry.getName();
                    }
                }
            }
        }

        String prefix = directoryName;

        ZipUtil.unpack(new File(fromFile), new File(toDirectory), new NameMapper() {
            public String map(String name) {
                return name.startsWith(prefix) ? name.substring(prefix.length()) : name;
            }
        });
    }

    public static void zipDirectory(String directoryName) {
        ZipUtil.unexplode(new File(directoryName));
    }

}

package sys.tem.logger;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

public class Logger {
    private static Logger instance = null;
    private FileWriter fileWriter;
    private String logfilePatch = "";
    private String logFileName = "res\\log\\log.txt";

    private Logger() {
        try {
            final File file = new File(logfilePatch + logFileName);
            final File parent_directory = file.getParentFile();
            if (null != parent_directory) {
                parent_directory.mkdirs();
            }
            fileWriter = new FileWriter(file, true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Logger getInstance() {
        if (instance == null) {
            instance = new Logger();
        }
        return instance;
    }

    public void log(String msg) {
        try {
            fileWriter.append("[")
                    .append(LocalDate.now().format(DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM)))
                    .append(":")
                    .append(LocalTime.now().format(DateTimeFormatter.ofPattern("HH.mm.ss.nnn")))
                    .append("] ")
                    .append(msg)
                    .append("\n");
            fileWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

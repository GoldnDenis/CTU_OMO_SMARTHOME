package cvut.fel.omo.report;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public abstract class AbstractReport {
    protected final List<String> reportList;
    protected String fileName;

    protected AbstractReport() {
        this.reportList = new ArrayList<>();
    }

    public void saveReport() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            for (String report : reportList) {
                writer.write(report);
                writer.newLine();
            }
        } catch (IOException e) {
            throw new RuntimeException("Couldn't save report");
        }
    }
}

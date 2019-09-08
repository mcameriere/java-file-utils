import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

class FileUtils {
  static String[] readAllLines(String fileName) {
    List<String> lines = new ArrayList<String>();
    try {
      FileInputStream inputStream = new FileInputStream(fileName);
      InputStreamReader streamReader = new InputStreamReader(inputStream, "windows-1252");
      BufferedReader reader = new BufferedReader(streamReader);
      while (true) {
        String line = reader.readLine();
        if (line == null) break;
        lines.add(line);
      }
      reader.close();
    } catch (IOException exception) {
      System.out.println(exception.getMessage());
    }
    return ArrayUtils.toArray(lines);
  }

  static void writeAllLines(String[] lines, String fileName) {
    try {
      FileOutputStream stream = new FileOutputStream(fileName);
      OutputStreamWriter write = new OutputStreamWriter(stream, "UTF-8");
      BufferedWriter bufferedWriter = new BufferedWriter(write);
      for (String line : lines) {
        bufferedWriter.write(line);
        bufferedWriter.newLine();
      }
      bufferedWriter.close();
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
  }
}

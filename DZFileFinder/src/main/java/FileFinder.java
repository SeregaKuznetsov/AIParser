import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FileFinder {

    public List<String> findFile(String dir, String fileName, ArrayList<String> list) {
        File file = new File(dir);
        File[] files = file.listFiles();
        for (File f : files) {
            if (f.isFile() && f.exists() && isRegexFile(f.getName(), fileName)) {
                list.add(f.getAbsolutePath());
            }
            if (f.isDirectory()) {
                findFile(f.getAbsolutePath(), fileName,list);
            }
        }
        return list;
    }

    private boolean isRegexFile(String dirString, String stringToFind) {
        Pattern p = Pattern.compile(".*" + stringToFind + ".*");
        Matcher m = p.matcher(dirString);
        return m.matches();
    }
}

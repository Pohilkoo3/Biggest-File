import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SizeCalculator {

    public static String getHumanReadableSize (long size){
        double result = size;
        int level = 0;
        while (result > 999){
            result = result / 1024;
            level += 1;
        }
        String[] sizeName = {"B", "Kb", "Mb", "Gb", "Tb"};
        return String.format("%.3f",result) + sizeName[level];
    }

    public static long getSizeFromHumanReadable (String size){
        String regex = "((\\d+)([A-z]+))+";
        Pattern pat = Pattern.compile(regex);
        Matcher mat = pat.matcher(size);
        mat.find();
        long correctSize = 0;
        if (mat.group(3).equals("B")){
            correctSize = Long.parseLong(mat.group(2));
        } else if (mat.group(3).equalsIgnoreCase("K") ||mat.group(3).equalsIgnoreCase("Kb") ){
            correctSize = (Long.parseLong(mat.group(2))) * 1024;
        }else if (mat.group(3).equalsIgnoreCase("M") ||mat.group(3).equalsIgnoreCase("Mb") ) {
            correctSize = (long) (Double.parseDouble(mat.group(2)) * Math.pow(1024, 2));
        }else if (mat.group(3).equalsIgnoreCase("G") ||mat.group(3).equalsIgnoreCase("Gb") ) {
            correctSize = (long) (Double.parseDouble(mat.group(2)) * Math.pow(1024, 3));
        }else if (mat.group(3).equalsIgnoreCase("T") ||mat.group(3).equalsIgnoreCase("Tb") ) {
            correctSize = (long) (Double.parseDouble(mat.group(2)) * Math.pow(1024, 4)) ;
        }
        return correctSize;
    }
}

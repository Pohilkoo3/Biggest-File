import java.io.File;

public class ParametersBag
{

    private long limit;
    private String path;

    public ParametersBag(String[] args){
        if(args.length !=4) {
            throw new IllegalArgumentException("Input two parameters: -l (limit) and -d (path)");
        }
        limit = 0;
        path = "";
        for (int i = 0; i < 4; i++) {
            if (args[i].equals("-l")) {
                limit = SizeCalculator.getSizeFromHumanReadable(args[i + 1]);
            }
            if (args[i].equals("-d")) {
                path = args[i + 1];
            }
        }
            if (limit <= 0) {
                throw new IllegalArgumentException("Limit is not specified ");
            }
            File folder = new File(path);
            if (!folder.exists() || !folder.isDirectory()){
                throw new IllegalArgumentException("Name of file or path to the file is specified wrong.");
            }
    }



    public long getLimit(){
        return limit;
    }

    public  String getPath(){
        return path;
    }

}

import java.io.File;
import java.util.concurrent.ForkJoinPool;


public class Main
{

    public static void main(String[] args)
    {
        ParametersBag bag = new ParametersBag(args);
        String folderPath = bag.getPath();
        long sizeLimit =  bag.getLimit();
        File file = new File(folderPath);
        Node root = new Node(file);

        FolderSizeCalculator calculator = new FolderSizeCalculator(root);
        ForkJoinPool pool = new ForkJoinPool();
        pool.invoke(calculator);
        printRoot(root, sizeLimit);

    }

    static void printRoot(Node root, Long sizeLimit){
        root.getChildren().stream().filter(n -> n.getSize() > sizeLimit).forEach(System.out::println);

    }

    static long getFolderSize(File element) {
        if (element.isFile()){
            return element.length();
        }
        long sum = 0;
        File[] files = element.listFiles();
        for (File element2 : files) {
            sum += getFolderSize(element2);
        } return sum;
    }
}






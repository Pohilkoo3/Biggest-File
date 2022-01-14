import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;

public class Node {
    private File folder;
    private ArrayList<Node> children;
    private long size;
    private int level;
//    private static int sizePrint;

    public Node(File folder){
        this.folder = folder;
        children = new ArrayList<>();
    }

    public long getSize() {
        return size;
    }

    public void setSize(long size) {
        this.size = size;
    }

    private void setLevel(int level) {
        this.level = level;
    }
    public void addChild (Node node){
        node.setLevel (level + 1) ;
        children.add(node);
    }
    public File getFolder() {
        return folder;
    }
    public ArrayList<Node> getChildren (){
        return children;
    }

    @Override
    public String toString() {
//        String size = SizeCalculator.getHumanReadableSize(getSize());
        StringBuilder builder = new StringBuilder();
        String size = SizeCalculator.getHumanReadableSize(getSize());
        builder.append(folder.getName() + " => " + size + "\n");
        String[] spaces = {" ", "    ", "       ", "          ", "      ", "       ", "        ", "          "};
        for (Node child : children){
            builder.append(spaces[level] + " " + child.toString());
        }
        return builder.toString();
    }
}

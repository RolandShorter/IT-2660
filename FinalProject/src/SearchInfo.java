public class SearchInfo {
    private boolean success;
    private int lengthOfPath;
    private int nodesSearch;

    public boolean isSuccess() {
        return success;
    }

    public int getLengthOfPath() {
        return lengthOfPath;
    }

    public int getNodesSearch() {
        return nodesSearch;
    }

    public void setSuccess() {
        this.success = true;
    }

    public void setPath(int lengthOfPath) {this.lengthOfPath = lengthOfPath;}

    public void incNodesSearch() {nodesSearch++;}

    public void setNodesSearched(int size) {
        nodesSearch = size;
    }

    @Override
    public String toString() {
        return "SearchInfo{" +
            "success=" + success +
            ", lengthOfPath=" + lengthOfPath +
            ", nodesSearch=" + nodesSearch +
            '}';
    }
}

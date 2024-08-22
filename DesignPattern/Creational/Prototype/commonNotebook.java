package Prototype;

public class commonNotebook extends notebookPrototype{

    String indexPageDesign;

    public commonNotebook(){
        System.out.println("of type common notebook");
    }

    public commonNotebook(commonNotebook notebook){
        super(notebook);
        this.indexPageDesign=notebook.indexPageDesign;
    }
    public notebookPrototype clone(){
        return new commonNotebook(this);

    }

    @Override
    public String toString() {
        return "commonNotebook [prototypeName=" + prototypeName + ", indexPageDesign=" + indexPageDesign
                + ", numOfPages=" + numOfPages + ", coverDesign=" + coverDesign + ", bindingType=" + bindingType + "]";
    }
}

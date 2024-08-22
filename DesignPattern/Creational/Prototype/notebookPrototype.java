package Prototype;

public abstract class notebookPrototype {
    String prototypeName;
    int numOfPages;
    String coverDesign;
    String bindingType;

    public notebookPrototype(){
        System.out.print("Going to design new notebook prototype ");
    }


    public notebookPrototype(notebookPrototype notebook){
        this.prototypeName=notebook.prototypeName;
        this.numOfPages=notebook.numOfPages;
        this.coverDesign=notebook.coverDesign;
        this.bindingType=notebook.bindingType;
    }

    public abstract notebookPrototype clone();

}

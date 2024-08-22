package Prototype;

public class Diary extends notebookPrototype{

    String calendarPageDesign;

    public Diary(){
        System.out.println("of type Diary.");
    }

    public Diary(Diary diary){
        super(diary);
        this.calendarPageDesign=diary.calendarPageDesign;
    }

    public notebookPrototype clone(){
        return new Diary(this);
    }

    @Override
    public String toString() {
        return "Diary [prototypeName=" + prototypeName + ", calendarPageDesign=" + calendarPageDesign + ", numOfPages="
                + numOfPages + ", coverDesign=" + coverDesign + ", bindingType=" + bindingType + "]";
    }


}

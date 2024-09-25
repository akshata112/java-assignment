package DesignPattern.Structural.Facade.Subsystems;

public class Download {
    private String downloadlink;
    private void setLink(String link){
        this.downloadlink=link;
    }
    public void downloadTemplate(String link){
        setLink(link);
        System.out.println("Checking for availability of link "+this.downloadlink);
        System.out.println("Document downloaded successfully.");
    }
}

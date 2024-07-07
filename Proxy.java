import java.util.Scanner;

interface Document {
    void create();
}

class RealDocument implements Document {
    @Override
    public void create() {
        System.out.println("Document content created.");
    }
}

class DocumentProxy implements Document {

    private Document realDocument;
    private String permission;

    public DocumentProxy(String permission) {
        this.permission = permission;
    }

    @Override
    public void create() {
        if ("admin".equalsIgnoreCase(permission)) {
            if (realDocument == null) {
                realDocument = new RealDocument();
            }
            realDocument.create();
        } else {
            throw new UnauthorizedException("User does not have permission to create documents.");
        }
    }
}

class UnauthorizedException extends RuntimeException {
    public UnauthorizedException(String message) {
        super(message);
    }
}

public class Proxy {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter your permission type (admin/user): ");
        String permission = scanner.nextLine().trim().toLowerCase();

        scanner.close();

        Document documentProxy = new DocumentProxy(permission);

        try {
            documentProxy.create();
        } catch (UnauthorizedException e) {
            System.out.println(e.getMessage());
        }
    }
}

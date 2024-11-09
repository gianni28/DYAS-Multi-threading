import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class MultiThreadedDownloader {
    public static void main(String[] args) {
        // URLs de archivos y nombres
        String[] urls = {
            "https://example.com/file1.jpg",
            "https://example.com/file2.jpg",
            "https://example.com/file3.jpg",
            "https://example.com/file4.jpg"
        };
        
        String[] fileNames = {"file1.jpg", "file2.jpg", "file3.jpg", "file4.jpg"};

        // Crear un ExecutorService con un pool de 3 hilos
        ExecutorService executorService = Executors.newFixedThreadPool(3);

        // Enviar tareas de descarga al executor
        for (int i = 0; i < urls.length; i++) {
            executorService.submit(new FileDownloader(urls[i], fileNames[i]));
        }

        // Apagar el ExecutorService después de enviar todas las tareas
        executorService.shutdown();

        try {
            // Esperar a que todas las tareas se completen
            if (!executorService.awaitTermination(10, TimeUnit.SECONDS)) {
                System.out.println("Algunas descargas no se completaron en el tiempo esperado.");
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            executorService.shutdownNow();
        }

        System.out.println("Todas las descargas han finalizado.");
    }
}


public class FileDownloader implements Runnable {
    private final String fileUrl;
    private final String fileName;

    public FileDownloader(String fileUrl, String fileName) {
        this.fileUrl = fileUrl;
        this.fileName = fileName;
    }

    @Override
    public void run() {
        System.out.println("Iniciando descarga de: " + fileName + " desde " + fileUrl);

        try {
            // Simula tiempo de descarga con Thread.sleep
            Thread.sleep((int) (Math.random() * 3000) + 1000);  // entre 1 y 4 segundos
            System.out.println("Descarga completa de: " + fileName);
        } catch (InterruptedException e) {
            System.out.println("Error en la descarga de: " + fileName);
            Thread.currentThread().interrupt();
        }
    }
}

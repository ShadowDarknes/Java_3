package Home_Work_4;

import java.io.*;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ExecutorServiceEX {
    public static void main(String[] args) {

        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            // Считываем исходный каталог для поиска файлов.
            System.out.print("Введите исходную директорию для поиска файлов:");
            final String directoryPath = reader.readLine();
            reader.close();

            File directory = new File(directoryPath);
            // Убедимся, что директория найдена и это реально директория, а не файл.
            if (directory.exists() && directory.isDirectory()) {
                processDirectory(directory);
            } else {
                System.out.println("Не удалось найти директорию по указанному пути.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void processDirectory(File directory) {
        // Получаем список доступных файлов в указанной директории.
        File[] files = directory.listFiles();
        if (files == null) {
            System.out.println("Нет доступных файлов для обработки.");
            return;
        } else {
            System.out.println("Количество файлов для обработки: " + files.length);
        }


        java.util.concurrent.ExecutorService service = Executors.newFixedThreadPool(10);
        for (final File f : files) {
            if (!f.isFile()) {
                continue;
            }

            service.execute(new Runnable() {
                @Override
                public void run() {
                    try (BufferedReader reader = new BufferedReader(new FileReader(f))) {
                        int lines = 0;
                        while (reader.readLine() != null) {
                            ++lines;
                        }
                        System.out.println("Поток: " + Thread.currentThread().getName() + ". Файл: " + f.getName() + ". Количество строк: " + lines);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
        // Новые задачи более не принимаем, выполняем только оставшиеся.
        service.shutdown();
        // Ждем завершения выполнения потоков не более 10 минут.
        try {
            service.awaitTermination(10, TimeUnit.MINUTES);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

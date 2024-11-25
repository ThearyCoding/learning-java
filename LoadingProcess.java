public class LoadingProcess{
    public static void simulateLoading(int totalProgress, int delay) {
        String[] loadingMessages = {
            "Calculating, please wait...",
            "Still working...",
            "Almost there...",
            "Finishing up...",
            "Performing complex calculations...",
            "Optimizing algorithms...",
            "Generating reports...",
            "Processing data...",
            "Verifying integrity...",
            "Loading resources...",
            "Compiling code...",
            "Running diagnostics...",
            "Analyzing results...",
            "Simulating scenarios...",
            "Applying filters...",
            "Rendering graphics...",
            "Encrypting data...",
            "Decrypting data...",
            "Archiving files...",
            "Extracting files..."
        };

        for (int percent = 1; percent <= totalProgress; percent++) {
            System.out.print(loadingMessages[percent % loadingMessages.length] + " ");
            System.out.print("-----------" + percent + "%");

            try {
                Thread.sleep(delay);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                e.printStackTrace();
            }

            System.out.print("\r");
        }

        System.out.println(loadingMessages[0] + " 100%");
        System.out.println("Process completed!");
    }
}
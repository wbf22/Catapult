

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileUploadExample {

    public static void main(String[] args) throws IOException {
        String url = "https://attractions-api.accessdevelopment-stage.com/v1/attractions/admin/digital-codes/prd_0GV2BJMV03MBY";
        String fileFieldName = "file";
        String filePath = "test.csv";

        try {
            URL apiUrl = new URL(url);
            HttpURLConnection connection = (HttpURLConnection) apiUrl.openConnection();
            connection.setRequestMethod("POST");
            connection.setDoOutput(true);

            String boundary = "---------------------------" + System.currentTimeMillis();

            connection.setRequestProperty("Content-Type", "multipart/form-data; boundary=" + boundary);

            try (OutputStream output = connection.getOutputStream()){
                PrintWriter writer = new PrintWriter(new OutputStreamWriter(output, "UTF-8"), true);
                FileInputStream fileStream = new FileInputStream(new File(filePath));

                // Add expiration parameter
                writer.append("--" + boundary).append("\\r\\n");
                writer.append("Content-Disposition: form-data; name=\"expiration\"").append("\\r\\n");
                writer.append("\\r\\n");
                writer.append("2025-01-02T14:00:00+00").append("\\r\\n");

                // Add threshold parameter
                writer.append("--" + boundary).append("\\r\\n");
                writer.append("Content-Disposition: form-data; name=\"threshold\"").append("\\r\\n");
                writer.append("\\r\\n");
                writer.append("10").append("\\r\\n");

                // Add the file attachment
                writer.append("--" + boundary).append("\\r\\n");
                writer.append("Content-Disposition: form-data; name=\"" + fileFieldName + "\"; filename=\"test.csv\"").append("\\r\\n");
                writer.append("Content-Type: application/octet-stream").append("\\r\\n");
                writer.append("\\r\\n");

                byte[] buffer = new byte[4096];
                int bytesRead;
                while ((bytesRead = fileStream.read(buffer)) != -1) {
                    output.write(buffer, 0, bytesRead);
                }

                writer.append("\\r\\n");
                writer.append("--" + boundary + "--").append("\\r\\n");
            }

            int responseCode = connection.getResponseCode();
            StringBuilder content = new StringBuilder();
            try (BufferedReader errorIn = new BufferedReader(new InputStreamReader(connection.getErrorStream()))) {
                String inputLine;
                while ((inputLine = errorIn.readLine()) != null) {
                    content.append(inputLine);
                }
            } catch (IOException e2) { 
                System.out.println("THIS SHOULDN'T HAPPEN");
            }
            System.out.println("Response Code: " + responseCode);
            System.out.println(content);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

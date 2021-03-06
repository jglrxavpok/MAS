package mas;

import java.io.*;

public class IOUtils {

    public static void copy(InputStream in, OutputStream out) throws IOException {
        byte[] buffer = new byte[4096];
        int i;
        while ((i = in.read(buffer)) != -1) {
            out.write(buffer, 0, i);
        }
        out.flush();
    }

    public static String read(String classpathLoc, String charset) throws IOException {
        InputStream input = IOUtils.class.getResourceAsStream("/" + classpathLoc);
        if (input == null)
            throw new FileNotFoundException("No file found in classpath: /" + classpathLoc);
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        copy(input, out);
        input.close();
        out.close();
        return new String(out.toByteArray(), charset);
    }
}

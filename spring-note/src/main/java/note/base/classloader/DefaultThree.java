package note.base.classloader;

import org.junit.Test;
import sun.misc.Launcher;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.URL;
import java.util.logging.Logger;

/**
 * @Author qianqian.sun
 * @Date 2017/1/20
 * 描述：Java默认提供的三个ClassLoader
 */
public class DefaultThree {
    Logger logger = Logger.getLogger("ha~");

    @Test
    public void bootStrapClassLoader() {
        URL[] urls = Launcher.getBootstrapClassPath().getURLs();
        for (URL url : urls) {
            System.out.println(url);
        }
    }

    @Test
    public void server() throws IOException {
        ServerSocket serverSocket = new ServerSocket(8080);
        Socket socket = serverSocket.accept();
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        logger.info("服务器接收:" + in.readLine());
        OutputStream os = socket.getOutputStream();
        File file = new File("C:\\Users\\92055\\mine\\code\\java\\springnote\\springcorenote\\src\\main\\resources\\Hello.class");
        FileInputStream inputStream = new FileInputStream(file);
        byte[] buffer = new byte[1024];
        while (inputStream.read(buffer) > 0) {
            os.write(buffer);
        }
        os.flush();
        logger.info("文件读出完毕");
        socket.close();
    }

    @Test
    public void client() throws IOException {
        Socket socket = new Socket("127.0.0.1", 8080);
        PrintWriter pw = new PrintWriter(socket.getOutputStream());
        pw.println("hi!");
        pw.flush();
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream(), "utf-8"));
        String s = in.readLine();
        while (s != null) {
            logger.info("服务器接收:" + s);
            s = in.readLine();
        }
        socket.close();
    }


}

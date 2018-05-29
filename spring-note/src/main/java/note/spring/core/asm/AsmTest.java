package note.spring.core.asm;

import org.junit.Test;
import org.springframework.asm.ClassWriter;
import org.springframework.asm.Opcodes;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @Author qianqian.sun
 * @Date 2017/1/10
 * 描述：
 * ①  ClassReader:该类用来解析编译过的class字节码文件。
 * <p>
 * 　　②  ClassWriter:该类用来重新构建编译后的类，比如说修改类名、属性以及方法，甚至可以生成新的类的字节码文件。
 * <p>
 * 　　③  ClassAdapter:该类也实现了ClassVisitor接口，它将对它的方法调用委托给另一个ClassVisitor对象。
 */
public class AsmTest {
    @Test
    public void testAsm() throws IOException {
        ClassWriter cw = new ClassWriter(0);
        cw.visit(Opcodes.V1_5, Opcodes.ACC_PUBLIC,
                "note/spring/core/asm/Hello", null, "java/lang/object",
                null);
        cw.visitField(Opcodes.ACC_PUBLIC + Opcodes.ACC_FINAL + Opcodes.ACC_STATIC, "GREET", "Ljava/lang/String;",
                null, "hello world").visitEnd();
        byte[] data = cw.toByteArray();
        File file = new File("C:\\Users\\92055\\mine\\code\\java\\springnote\\springcorenote\\src\\main\\resources\\Hello.class");
        FileOutputStream fos = new FileOutputStream(file);
        fos.write(data);
    }

    @Test
    public void testWrite() throws IOException {
        File file = new File("C:\\Users\\92055\\mine\\code\\java\\springnote\\springcorenote\\src\\main\\resources\\Hello.txt");
        file.delete();
    }
}

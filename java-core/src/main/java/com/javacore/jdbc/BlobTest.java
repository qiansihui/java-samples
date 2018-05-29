package com.javacore.jdbc;

import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.*;
import java.sql.*;
import java.util.ArrayList;

/**
 * @Author: sunqianqian
 * @Description:
 * @CodeReviewer:
 */
public class BlobTest {
    JFrame jf = new JFrame("图片管理程序");
    private static Connection connection;
    private static PreparedStatement insert;
    private static PreparedStatement query;
    private static PreparedStatement queryAll;

    private DefaultListModel imageModel = new DefaultListModel();
    private JList imageList = new JList(imageModel);
    private JTextField filePath = new JTextField(26);
    private JButton browserBn = new JButton("...");
    private JButton uploadBn = new JButton("上传");
    private JLabel imageLable = new JLabel();
    //以当前路径创建文件选择器
    JFileChooser chooser = new JFileChooser(",");

    static {
        try {
            Jdbc jdbc = new Jdbc();
            Class.forName(jdbc.driver);
            connection = DriverManager.getConnection(jdbc.url, jdbc.user, jdbc.pw);
            //创建执行插入的prepareStatement对象，执行插入后返回自动生成的主键
            insert = connection.prepareStatement("INSERT INTO img VALUES(null,?,?)", Statement.RETURN_GENERATED_KEYS);
            //创建执行查询的对象 查询指定图片。查询所有图片
            query = connection.prepareStatement("select data from img where id = ?");
            queryAll = connection.prepareStatement("SELECT ID ,NAME FROM  img");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void init() throws SQLException {
        //初始化文件选择器
        filter.addExtension("jpg");
        filter.addExtension("jpeg");
        filter.addExtension("gif");
        filter.addExtension("png");
        filter.setDescription("图片文件（*.jpg,*.jpeg,*.gif,*png）");
        chooser.addChoosableFileFilter(filter);
        //禁止文件类型下拉列表中显示所有文件选项
        chooser.setAcceptAllFileFilterUsed(false);
        //--------------初始化程序界面
        fillListModel();
        filePath.setEditable(false);
        //只能单选
        imageList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        JPanel jp = new JPanel();
        jp.add(filePath);
        jp.add(browserBn);  //打开文件框按钮
        browserBn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //显示文件对话框
                int result = chooser.showDialog(jf, "浏览图片文件上传");
                //如果用户选着approve按钮，即打开，保存极其等效按钮
                if (result == JFileChooser.APPROVE_OPTION) {
                    filePath.setText(chooser.getSelectedFile().getPath());
                }
            }
        });
        jp.add(uploadBn);//上传按钮
        uploadBn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //如果上次文件的文本框中有内容
                if (filePath.getText().trim().length() > 0) {
                    //将文件保存到数据库
                    upload(filePath.getText());
                    filePath.setText("");
                }
            }
        });
        JPanel left = new JPanel();
        left.setLayout(new BorderLayout());
        left.add(new JScrollPane(imageLable), BorderLayout.CENTER);
        left.add(jp, BorderLayout.SOUTH);
        jf.add(left);
        imageList.setFixedCellWidth(160);
        jf.add(new JScrollPane(imageList), BorderLayout.EAST);
        imageList.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                //如果鼠标双击
                if (e.getClickCount() >= 2) {
                    //取出选好总的LIst项
                    ImageHolder cur = (ImageHolder) imageList.getSelectedValue();
                    try {
                        showImage(cur.getId());
                    } catch (SQLException e1) {
                        e1.printStackTrace();
                    }
                }
            }
        });
        jf.setSize(620, 400);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setVisible(true);
    }

    //------------MAIN方法
    public static void main(String[] args) throws SQLException {
        new BlobTest().init();

    }

    //------根据图片id显示图片
    private void showImage(int id) throws SQLException {
        ResultSet rs = null;
        try {
            query.setInt(1, id);
            rs = query.executeQuery();
            if (rs.next()) {
                Blob imgBlob = rs.getBlob(1);
                //取出Blob列中数据 转图片
                ImageIcon icon = new ImageIcon(imgBlob.getBytes(1L, (int) imgBlob.length()));
                imageLable.setIcon(icon);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                rs.close();
            }
        }
    }

    //---------将图片放入数据库
    private void upload(String fileName) {
        InputStream is = null;
        try {
            String imageName = fileName.substring(fileName.lastIndexOf('\\') + 1, fileName.lastIndexOf('.'));
            //设置图片名参数
            insert.setString(1, imageName);
            File f = new File(fileName);
            is = new FileInputStream(f);
            insert.setBinaryStream(2, is, (int) f.length());
            int affect = insert.executeUpdate();
            if (affect == 1) {
                //更新listModel
                fillListModel();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                if (is != null) {
                    is.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    //--------查找img 表填充 ListModel
    private void fillListModel() throws SQLException {
        ResultSet rs = null;
        try {
            imageModel.clear();
            rs = queryAll.executeQuery();
            while (rs.next()) {
                imageModel.addElement(new ImageHolder(rs.getInt(1), rs.getString(2)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (rs != null)
                rs.close();
        }
    }

    //创建文件过滤器
    ExtensionFileFilter filter = new ExtensionFileFilter();

    private class ExtensionFileFilter extends FileFilter {
        private String description = "";
        private ArrayList<String> extensions = new ArrayList<String>();

        public void addExtension(String extension) {
            if (!extension.startsWith(".")) {
                extension = "." + extension;
                extensions.add(extension.toLowerCase());
            }
        }

        @Override
        public boolean accept(File f) {
            //若果该文件是路径，接收该文件
            if (f.isDirectory()) return true;
            String name = f.getName().toLowerCase();
            //遍历所有可接受扩展名，若扩展名相同可接受该文件
            for (String extension : extensions) {
                if (name.endsWith(extension)) {
                    return true;
                }
            }
            return false;
        }

        @Override
        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }
    }

    private class ImageHolder {
        private int id;
        private String name;

        public ImageHolder() {
        }

        public ImageHolder(int id, String name) {
            this.id = id;
            this.name = name;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return name;
        }
    }
}
